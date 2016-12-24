<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://www.springframework.org/tags/form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="b"%>
<script src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>
<script src="../../resource/admin/bower_components/jquery/dist/jquery.min.js"></script>


<!--
Author: W3layouts
Author URL: http://w3layouts.com
License: Creative Commons Attribution 3.0 Unported
License URL: http://creativecommons.org/licenses/by/3.0/
-->
<!DOCTYPE html>
<html>
<head>
  <title></title>


  <link href='//fonts.googleapis.com/css?family=Open+Sans:400,300italic,300,400italic,600,600italic,700,700italic,800,800italic' rel='stylesheet' type='text/css'>
  <link href='//fonts.googleapis.com/css?family=Lato:400,100,100italic,300,300italic,400italic,700,700italic,900,900italic' rel='stylesheet' type='text/css'>

  <meta name="viewport" content="width=device-width, initial-scale=1" />
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
  <meta name="keywords" content="Lambent Login Form Responsive, Login Form Web Template, Flat Pricing Tables, Flat Drop-Downs, Sign-Up Web Templates, Flat Web Templates, Login Sign-up Responsive Web Template, Smartphone Compatible Web Template, Free Web Designs for Nokia, Samsung, LG, Sony Ericsson, Motorola Web Design" />
  <script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
  <link rel="stylesheet" href="../../resource/admin/admin/css/style.css">
</head>
<body>
<h1>Đặt vé xe buýt online</h1>
<div class="main-agileinfo">
  <h2>Login Now</h2>

  <c:form cssClass="login-container" modelAttribute="adminEntity" action="/admin" method="post">
    <input type="text" name="username" class="name" placeholder="Usename" required="">
    <input type="password" name="password" class="password" placeholder="Password" required="">
    <ul>
      <li>
        <input type="checkbox" id="brand1" value="">
        <label for="brand1"><span></span>Remember me</label>
      </li>
    </ul>
    <a href="#">Forgot Password?</a><br>
    <div class="clear"></div>
    <input type="submit" value="Login">
    <br>
    <div style="color: red;text-align: center">${msg}</div>
  </c:form>

</div>
<div class="footer-w3l">
  <p class="agile"> &copy; 2016 Login Form . All Rights Reserved | Design by TandT</p>
</div>
</body>
</html>



