<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page session="false"%>
<html>
	<head>
		<title>Editing ${description}</title>
		<link rel="stylesheet" type="text/css" href="/grocerific_Pelayo/RES/css/list.css">
	</head>
	<body>
		<div style="margin-bottom:10px;">
			<h2 style="margin:0;">Now editing:</h2>
		 	<h3>Product ${productId}: ${description}</h3>
		 </div>
		<form:form commandName="edit-product" method="POST" action="list">
			<table>	
			<tr>
				<td>
					Description
				</td>
				<td>
					<form:input path="description"/>
				</td>
			</tr>
			<tr>
				<td>
					Size
				</td>
				<td>
					<form:input path="size"/>
				</td>
			</tr>
			<tr>
				<td>
					Price
				</td>
				<td>
					<form:input path="price"/>
				</td>
			</tr>
			<tr>
				<td colspan="2" style="text-align:center;">							
					<input type="submit" value="Save"/>	
				</td>
			</tr>			
			</table>
		</form:form>
	</body>
</html>