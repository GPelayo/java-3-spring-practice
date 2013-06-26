<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt" %>
<%@ page session="false"%>
<html>
<head>
	<title>Grocerific Product List</title>
	<link rel="stylesheet" type="text/css" href="/grocerific_Pelayo/RES/css/list.css"/>
</head>
<body>

<div class="header" style="margin-bottom: 10px;"><h1>Product Inventory</h1></div>

	<div class="list">
		<table>
			<tr style="font-weight:bold; text-align:center" >
				<td>ID</td>
				<td>Description</td>
				<td>Size</td>
				<td>Price</td>
				<td colspan="2">Action<td>
			</tr>
			<c:forEach items="${products}" var="iProduct">
				<tr>
					<td>${iProduct.id}</td>
					<td>${iProduct.description}</td>
					<td>${iProduct.size}</td>
					<td>${iProduct.price}</td>
					<td class="button"><a class="button" href="editProduct?id=${iProduct.id}">Edit</a></td>
					<td class="button"><a class="button" href="deleteProduct?id=${iProduct.id}">Delete</a></td>
				</tr>
			</c:forEach>	
		</table>
	</div>
	<div class="options">
		<a class="button" href="editProduct">Edit</a>
	</div>
</body>
</html>