<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset = utf-8" language="java" pageEncoding="UTF-8"/>
    <title>Домашняя страница</title>
</head>
<body>
<h1>Домашняя страница</h1>
<p>
    ${message}<br/>
<a href="${pageContext.request.contextPath}/deal/add.html">Добавить дело</a><br/>
<a href="${pageContext.request.contextPath}/deal/all_deal.html">Просмотреть список дел</a><br/>
<a href="${pageContext.request.contextPath}/deal/list.html">Вся база</a><br/>
<input type="button" onclick="location.href='/deal/add_default_record.html'" value="Добавить 10 дел"/>


</p>
</body>
</html>