<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html >
  <head>
    <meta charset="UTF-8">
    <title>Login Form</title>
    <link rel="stylesheet" href="../../resource/css/style.css">
    <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
  </head>
  <body>
    <div class="login">
      <div class="login-triangle"></div> 
      <h2 class="login-header">Log in</h2>
      <%--<form class="login-container">--%>
        <form Class="login-container" action="/adminstaff" method="post">
          <input name="username" placeholder="Username" type="text"/>
          <input class="password" placeholder="Password" type="password"/>
          <input type="submit" value="Log in">
          <div style="color: red">${msg}</div>
        </form>
      <%--</form>--%>
    </div>
  </body>
</html>
