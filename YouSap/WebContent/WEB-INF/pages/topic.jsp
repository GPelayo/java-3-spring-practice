<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page session="false"%>
<html>
<head>
	<title>Yousap</title>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/RES/css/list.css"/>
</head>
<body>	
<div class="header" style="margin-bottom:10px;">
	<h1 style="margin:0">
		Yousap
	</h1>
</div>
<div>
	<form:form commandName="message" method="POST">
		<table style="text-align:left;">	
			<tr>
				<td>
					Message ID
				</td>
				<td>
					<form:input size="5px" path="messageID"/>
				</td>
			</tr>
			<tr>
				<td>
					Message
				</td>
				<td>
					<form:input size="10px" path="messageText"/>
				</td>
			</tr>
			<tr>
				<td colspan="2" style="text-align:center;border-bottom-width:0">							
					<input class="button" type="submit" value="Save"/>	
				</td>
			</tr>
		</table>
	</form:form>
</div>
<div class="list">
	<table>
		<tr style="font-weight:bold; text-align:center">
			<td>Message No.</td>
			<td>Message</td>
			<td colspan="2">Action<td>
		</tr>
		<c:forEach items="${messageList}" var="iMessage">
			<tr>
				<td>${iMessage.messageID}</td>
				<td>${iMessage.messageText}</td>
				<!-- 
					<td class="button"><a class="button" href="editInventory?id=${iMessages.productId}">Edit</a></td>
				  -->
				<td class="button"><a class="button" href="deleteInventory?id=${iMessages.messageID}">Delete</a></td>
			</tr>
		</c:forEach>	
	</table>
</div>
</body>
</html>