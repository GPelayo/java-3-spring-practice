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
		Order Item List
	</h1>
</div>
<div class="addButton">
	<a class="button" href="addOrderItem">Add Order Item</a>
</div>
<div class="list">
	<table>
		<tr style="font-weight:bold; text-align:center">
			<td>Order ID</td>
			<td>Line #</td>
			<td>Product ID</td>
			<td>Quantity</td>
			<td>Unit Price</td>
			<td colspan="2">Action<td>
		</tr>
		<c:forEach items="${orderItems}" var="iOrderItems">
			<tr>
				<td>${iOrderItems.orderId}</td>
				<td>${iOrderItems.lineNumber}</td>
				<td>${iOrderItems.productId}</td>
				<td>${iOrderItems.quantity}</td>
				<td>${iOrderItems.unitPrice}</td>
				<td class="button"><a class="button" href="editOrderItem?orderId=${iOrderItems.orderId}&lineNumber=${iOrderItems.lineNumber}">Edit</a></td>
				<td class="button"><a class="button" href="deleteOrderItem?orderId=${iOrderItems.orderId}&lineNumber=${iOrderItems.lineNumber}">Delete</a></td>
			</tr>
		</c:forEach>	
	</table>
</div>
</body>
</html>