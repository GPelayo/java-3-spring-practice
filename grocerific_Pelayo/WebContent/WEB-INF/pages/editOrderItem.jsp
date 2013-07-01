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
		<form:form commandName="orderItem" method="POST">
			<table style="text-align:left;">	
				<tr>
					<td>
						Order ID
					</td>
					<td>
						<form:input size="5px" path="orderId"/>
					</td>
				</tr>
				<tr>
					<td>
						Line Number
					</td>
					<td>
						<form:input size="5px" path="lineNumber"/>
					</td>
				</tr>
				<tr>
					<td>
						Product ID
					</td>
					<td>
						<form:input size="5px" path="productId"/>
					</td>
				</tr>
				<tr>
					<td>
						Quantity
					</td>
					<td>
						<form:input size="5px" path="quantity"/>
					</td>
				</tr>
				<tr>
					<td>
						Unit Price
					</td>
					<td>
						<form:input size="5px" path="unitPrice"/>
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