<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<?xml version="1.0" encoding="ISO-8859-1" ?>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" />
<title>Редактирование</title>
</head>
<body>
<h1>Редактирование</h1>
<p>Внесите изменения</p>
<p>${message}</p>
<form:form method="POST" commandName="deal" action="${pageContext.request.contextPath}/deal/edit/${deal.id}.html">
<table>
<tbody>
	<tr>
		<td>Дело:</td>
		<td><form:input path="business" /></td>
	</tr>
	<tr>
		<td>Выполнено:</td>
		<td><span class="checkbox"><form:checkbox path="done" /></span></td>
	</tr>
	<tr>
		<td><input type="submit" value="Сохранить" /></td>
		<td></td>
	</tr>
</tbody>
</table>
</form:form>

<p><a href="${pageContext.request.contextPath}/index.html">Домашняя страница</a></p>
</body>
</html>