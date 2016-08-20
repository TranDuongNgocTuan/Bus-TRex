package com.iviettech.bus.repository;

import com.iviettech.bus.config.SpringConfig;
import com.iviettech.bus.entity.InfoTicket;
import com.iviettech.bus.entity.ScheduleEntity;
import com.iviettech.bus.entity.TimeTableScheduleEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by tran on 19/08/2016.
 */
@Repository
public class InfoTicketRepository{

    @Autowired
    private BusstationRepository busstationRepository;

    @Autowired
    private BusServicesRepository busServicesRepository;

    @Autowired
    private PromotionTimeRepository promotionTimeRepository;

    @Autowired
    private TimeTableScheduleRepository timeTableScheduleRepository;

    @Autowired
    BusesRepository busesRepository;

    private JdbcTemplate jdbcTemplate;

//    List<InfoTicket> infoTicketList;


    public InfoTicketRepository(){
        ApplicationContext context =
                new AnnotationConfigApplicationContext(SpringConfig.class);
        jdbcTemplate = new JdbcTemplate((DataSource) context.getBean("dataSource"));
    }

    public  List<InfoTicket> findAllInfoTicket(int fromId, int toId, Date datePay){
        String sql = "SELECT schedule.* , timetableschedule.*" +
                ", case when bus.seats is null then 0 else bus.seats END as 'seat'" +
                ", case when buses.id is null then 0 else count(ticket.id) END as 'Quantity'" +
                " from schedule" +
                " inner join timetableschedule" +
                " on schedule.id = timetableschedule.scheduleId" +
                " inner join busservices" +
                " on busservices.id = schedule.busservicesId" +
                " left join buses" +
                " on buses.timetablescheduleId = timetableschedule.id" +
                " left join ticket" +
                " on buses.id = ticket.busesId" +
                " left join bus" +
                " on timetableschedule.busId = bus.id"+
                " where schedule.departureId = " + fromId + " and schedule.arrivalId = " + toId + " and datediff('" +  datePay  + "', busservices.dob)%schedule.numberday = 0" +
                " group by timetableschedule.id";
        List<InfoTicket> infoTicketList = jdbcTemplate.query(sql, new RowMapper<InfoTicket>() {

            @Override
            public InfoTicket mapRow(ResultSet rs, int rowNum) throws SQLException {
                InfoTicket aInfoTicket = new InfoTicket();
                ScheduleEntity scheduleEntity = new ScheduleEntity();
                TimeTableScheduleEntity timeTableScheduleEntity = new TimeTableScheduleEntity();

                scheduleEntity.setId(rs.getInt(1));
                scheduleEntity.setDistance(rs.getFloat(2));
                scheduleEntity.setNumberDay(rs.getInt(3));
                scheduleEntity.setNumberTrip(rs.getInt(4));
                scheduleEntity.setArrival(busstationRepository.findOne(rs.getInt(5)));
                scheduleEntity.setDeparture(busstationRepository.findOne(rs.getInt(7)));
                scheduleEntity.setBusServicesEntity(busServicesRepository.findOne(rs.getInt(6)));
                scheduleEntity.setPromotionTimeEntityList(promotionTimeRepository.findByScheduleEntityId(rs.getInt(1)));
                scheduleEntity.setTimeTableScheduleEntityList(timeTableScheduleRepository.findByScheduleEntityId(rs.getInt(1)));
                timeTableScheduleEntity.setScheduleEntity(scheduleEntity);
                timeTableScheduleEntity.setId(rs.getInt(8));
                timeTableScheduleEntity.setArriveTime(rs.getTime(9));
                timeTableScheduleEntity.setDepartureTime(rs.getTime(10));
                timeTableScheduleEntity.setDuration(rs.getTime(11));
                timeTableScheduleEntity.setBusesEntityList(busesRepository.findByTimeTableScheduleEntityId(rs.getInt(8)));

                aInfoTicket.setScheduleEntity(scheduleEntity);
                aInfoTicket.setTimeTableScheduleEntity(timeTableScheduleEntity);
                aInfoTicket.setNumberSeat(rs.getInt(14));
                aInfoTicket.setNumberTicket(rs.getInt("Quantity"));

                return aInfoTicket;
            }

        });

        return infoTicketList;
    }
}
