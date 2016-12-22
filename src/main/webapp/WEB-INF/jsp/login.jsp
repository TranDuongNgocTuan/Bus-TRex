<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://www.springframework.org/tags/form" %>
<script src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>
<script src="../../resource/admin/bower_components/jquery/dist/jquery.min.js"></script>
<!DOCTYPE html>
<html >
  <head>
  
    <meta charset="UTF-8">
    <title>Login Form</title>
    <link rel="stylesheet" href="../../resource/css/style.css">

  </head>
  <body>

    <div class="login">
      <div class="login-triangle"></div> 
      <h2 class="login-header">Log in</h2>
      <%--<form class="login-container">--%>
        <c:form cssClass="login-container" modelAttribute="adminEntity" action="/admin" method="post">
          <%--<p><c:input path="username" placeholder="Username" type="text"/></p>--%>
          <%--<p><c:input path="password" placeholder="Password" type="password"/></p>--%>
          <input type="text" name="username" placeholder="Username" />
          <input type="password" name="password" placeholder="Password"/>
          <p><input type="submit" value="Log in"></p>
          <div style="color: red">${msg}</div>
        </c:form>
      <%--</form>--%>
    </div>


  </body>
</html>
