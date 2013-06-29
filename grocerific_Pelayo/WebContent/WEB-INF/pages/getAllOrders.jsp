<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt" %>
<%@ page session="false"%>
<html>
<head>
	<title>Grocerific Order List</title>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/RES/css/list.css"/>
</head>
<body>	
<div class="header" style="margin-bottom:10px;">
	<h1 style="margin:0">
		Order List
	</h1>
</div>
<div class="addButton">
	<a class="button" href="../addOrder">Add Order</a>
</div>
<div class="list">
	<table>
		<tr style="font-weight:bold; text-align:center">
			<td>ID</td>
			<td>Date</td>
			<td>Total</td>
			<td colspan="2">Action<td>
		</tr>
		<c:forEach items="${orders}" var="iOrder">
			<tr>
				<td>${iOrder.id}</td>
				<td>${iOrder.orderDate}</td>
				<td>${iOrder.total}</td>
				<td class="button"><a class="button" href="editOrder?id=${iOrder.id}">Edit</a></td>
				<td class="button"><a class="button" href="deleteOrder?id=${iOrder.id}">Delete</a></td>
			</tr>
		</c:forEach>	
	</table>
</div>
</body>
</html>