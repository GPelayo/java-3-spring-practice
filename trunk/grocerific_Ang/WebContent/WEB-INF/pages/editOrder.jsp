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
		<form:form commandName="order" method="POST">
			<table style="text-align:left;">	
				<tr>
					<td>
						Order Date <br/>(YYYY-MM-DD)
					</td>
					<td>
						<form:input path="orderDate"/>
					</td>
				</tr>
				<tr>
					<td>
						total
					</td>
					<td>
						<form:input size="10px" path="total"/>
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