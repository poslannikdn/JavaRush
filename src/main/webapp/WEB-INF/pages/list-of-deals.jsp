<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<?xml version="1.0" encoding="ISO-8859-1" ?>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"  />
<title>Список дел</title>
</head>
<body>
<p><a href="${pageContext.request.contextPath}/index.html">Домашняя страница</a></p>
<h1>Список дел</h1>
<form action="test.form" method="get">
	<input type="text" name="name">
	<input type="submit">
</form>
<p>Ваш список</p>
<table border="1px" cellpadding="0" cellspacing="0" >
	<tr>
		<td><input type="button"  onclick="location.href='/deal/all_deal.html'" value="Все дела" />

		</td>
		<td><input type="button"  onclick="location.href='/deal/done_deal.html'" value="Выполненые" />

		</td>
		<td><input type="button"  onclick="location.href='/deal/not_done_deal.html'" value="Не выполненые" />

		</td>
	</tr>
</table>
<table border="1px" cellpadding="0" cellspacing="0" >
<thead>
<tr>
<th width="10%">Ид</th><th width="15%">Дело</th><th width="10%">Выполнено</th><th width="10%">Дата</th><th width="10%">Действия</th>
</tr>
</thead>
<tbody>
<c:forEach var="deal" items="${deals}">
<tr>
	<td>${deal.id}</td>
	<td>${deal.business}</td>
	<td>${deal.done}</td>
	<td>${deal.add_date}</td>
	<td>
	<a href="${pageContext.request.contextPath}/deal/edit/${deal.id}.html">Редактировать</a><br/>
	<a href="${pageContext.request.contextPath}/deal/delete/${deal.id}.html">Удалить</a><br/>
	</td>
</tr>
</c:forEach>
</tbody>
</table>


</body>
</html>