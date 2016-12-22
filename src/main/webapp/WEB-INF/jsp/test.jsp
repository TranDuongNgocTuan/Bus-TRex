<%@ page import="org.json.simple.JSONObject" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
    <script src="https://code.jquery.com/jquery-2.2.4.js"  integrity="sha256-iT6Q9iMJYuQiMWNd9lDyBUStIq/8PuOW33aOqmvFpqI="   crossorigin="anonymous"></script>
    <%--<script type="text/javascript" src="/webjars/js/test.js"></script>--%>

</head>
<body>
    <h1>Hello</h1>
    <%
        JSONObject json = new JSONObject();
        json.put("title", "TITLE_TEST");
        json.put("link", "LINK_TEST");
        System.out.println(json);
        System.out.flush();
        System.out.println(json.get("search"));
    %>
</body>
</html>
