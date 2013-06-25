<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<html>
<head>
<title>Home</title>
	<style>
		body
		{
			color: rgb(142, 87, 86);
			background-image:url("http://farm4.static.flickr.com/3570/3333105812_4f062174d1.jpg");
		}		
		h1
		{
			margin:0
			
		}
		div.header
		{
			text-align:center;
			background-color: rgb(135, 216, 222);
			border-width:5;
			border-style:solid;
			border-color: rgb(88, 133, 52);			
			background-color: rgb(135, 216, 222);
			margin-bottom: 10px;
			max-width: 33%;
			margin-left: 33%;
			margin-right: 33%;
		}
		table
		{
			float:left;
			width:%40;
			border-width:5;
			border-style:solid;
			border-color: rgb(88, 133, 52);			
			background-color: rgb(135, 216, 222);
		}
		td
		{
			border-bottom-width:3;
			border-bottom-style:solid;
			border-bottom-color: rgb(138, 183, 102);
		}
	</style>
</head>
<body>

<div class="header"><h1>Product Inventory</h1></div>
<table>
	<tr><td>
		<tr style="font-weight:bold">
			<td>ID</td>
			<td>Description</td>
			<td>Size</td>
			<td>Price</td>
			<td/><td/>
		</tr>
		<c:forEach items="${products}" var="iProduct">
			<tr>
				<td>${iProduct.id}</td>
				<td>${iProduct.description}</td>
				<td>${iProduct.size}</td>
				<td>${iProduct.price}</td>
				<td><a href="/grocerific_Pelayo/editProduct?id=${iProduct.id}">Edit</a></td>
				<td><a href="/grocerific_Pelayo/deleteProduct?id=${iProduct.id}">Delete</a></td>
			</tr>
		</c:forEach>
	<td></tr>
</table>
</body>
</html>