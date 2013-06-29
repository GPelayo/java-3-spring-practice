<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page session="false"%>
<html>
	<head>
		<title>${titleMsg}</title>
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/RES/css/edit.css">
	</head>
	<body>
		<div class="header">
			<h3 style="margin:0;">${headerMsg}</h3>
			<h2 style="margin:2;">${subheaderMsg}</h2>
		 </div>
		<form:form commandName="inventory" method="POST">
			<table style="text-align:left;">	
				<tr>
					<td>
						Product ID
					</td>
					<td>
						<form:input path="productId"/>
					</td>
				</tr>
				<tr>
					<td>
						Quantity
					</td>
					<td>
						<form:input size="10px" path="quanity"/>
					</td>
				</tr>
				<tr>
					<td colspan="2" style="text-align:center;border-bottom-width:0">							
						<input class="button" type="submit" value="Save"/>	
					</td>
				</tr>			
			</table>
		</form:form>
	</body>
</html>