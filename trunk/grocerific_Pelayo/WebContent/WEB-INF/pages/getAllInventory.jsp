<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt" %>
<%@ page session="false"%>
<html>
<head>
	<title>Grocerific Inventory List</title>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/RES/css/list.css"/>
</head>
<body>	
<div class="header" style="margin-bottom:10px;">
	<h1 style="margin:0">
		Product Inventory List
	</h1>
</div>
<div class="addButton">
	<a class="button" href="addInventory">Add Order</a>
</div>
<div class="list">
	<table>
		<tr style="font-weight:bold; text-align:center">
			<td>Product ID</td>
			<td>Date</td>
			<td>Total</td>
			<td colspan="2">Action<td>
		</tr>
		<c:forEach items="${inventories}" var="iOrder">
			<tr>
				<td>${iInventories.productId}</td>
				<td>${iInventories.quantity}</td>
				<td class="button"><a class="button" href="editInventory?id=${iInventories.id}">Edit</a></td>
				<td class="button"><a class="button" href="deleteInventory?id=${iInventories.id}">Delete</a></td>
			</tr>
		</c:forEach>	
	</table>
</div>
</body>
</html>