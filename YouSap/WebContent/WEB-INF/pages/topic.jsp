<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page session="false"%>
<html>
<head>
	<title>Yousap</title>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/RES/css/topic.css"/>
</head>
<body>	
<div class="header" style="margin-bottom:10px;">
	<h1 style="margin:0">
		Yousap
	</h1>
</div>

<form:form commandName="message" method="POST">
	<div>
		<table style="text-align:left; float:left;">	
			<tr>
				<td>
					Username
				</td>
				<td>
					<form:input size="5px" path="username"/>
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
	</div>
	<div class="list">
		<c:forEach items="${messageList}" var="iMessage">
			<div style="text-align:center;">
				${iMessage.username} ${iMessage.productID} 7/13/2013
				<div class="header" style="height:100px; text-align:left;">
					<div class="header" style="width:100px; height:20px; margin-left:0px; border:0px; background-color:red; text-align:left;">
						Reply To <!-- ${iMessage.parentMessageID} -->
					</div>
					${iMessage.messageText}				
				</div>
			</div>
		</c:forEach>
		<!-- 
		<table>
		
			<tr style="font-weight:bold; text-align:center">
				<td>Reply</td>
				<td>Message No.</td>
				<td>Message</td>
				<td colspan="2">Action<td>
			</tr>
			<c:forEach items="${messageList}" var="iMessage">
				<tr>
					<td><form:radiobutton path="parentMessageID" value="${iMessages.messageID}" /></td>
					<td>${iMessage.messageID}</td>
					<td>${iMessage.username}</td>
					<td>${iMessage.messageText}</td>
					
						<td class="button"><a class="button" href="editInventory?id=${iMessages.productId}">Edit</a></td>
					  
					<td class="button"><a class="button" href="deleteInventory?id=${iMessages.messageID}">Delete</a></td>
				</tr>
			</c:forEach>	
		</table>
		-->
	</div>
</form:form>
</body>
</html>