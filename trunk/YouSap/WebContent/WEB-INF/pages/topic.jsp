<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page session="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>Yousap</title>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/RES/css/green.css"/>
</head>
<body>	
<div class="content" style="margin-bottom:30px;">
	<h1>
		Yousap
	</h1>
</div>
<form:form commandName="message" method="POST">
	<div id="message-box">
		<table id="message-box" class="content" style="text-align:left">	
			<tr>
				<td>
					Username
				</td>
				<td>
					<form:input path="username" />
				</td>
			</tr>
			<tr>
				<td>
					Message
				</td>
				<td>
					<form:textarea rows="6" path="messageText" style="width:95%;" maxlength="5000"/>
				</td>
			</tr>
			<tr>
				<td>
					No Reply
				</td>
				<td>
					<form:radiobutton path="parentMessageID" value="-1"/>
				</td>
			</tr>
			<tr>
				<td class="button-footer" colspan="2">							
					<input class="button" type="submit" value="Save" formaction="add"/>	
				</td>
			</tr>
		</table>
	</div>
	<div>
		<c:forEach items="${messageList}" var="iMessage">
			<div id=${iMessage.messageID}>
				<c:if test="${iMessage.messageID == highlightID}">
						<c:set var="highlightStyle" value="background-color:yellow;"/>
				</c:if>
				<c:if test="${iMessage.messageID != highlightID}">
						<c:set var="highlightStyle" value="background-color:#BFB541;"/>
				</c:if>				
				<span id="message" class="content" style="${highlightStyle}">
					<span id="message-header" class="content">						
						<span class="username">							
							<form:radiobutton id="radiobutton" path="parentMessageID" value="${iMessage.messageID}"/>
							${iMessage.username}
						</span>
							
						<span>
							Msg. ${iMessage.messageID}
						</span>
						<span>
							 [${iMessage.date}]
						</span>						
					</span>
					<fmt:parseNumber var="nullID" value="-1" />		
					<c:if test="${iMessage.parentMessageID > nullID}">					
						<span id="reply-header" class="content">
							<a href="highlight?parentID=${iMessage.parentMessageID}#${iMessage.parentMessageID}"> 
								Replying to Msg.${iMessage.parentMessageID}
							</a>
						</span>					
					</c:if>
					
					<span class="message-text">
						${iMessage.messageText}
					</span>
					<span id="button-footer" class="content">
						<a class="button" href="edit?id=${iMessage.messageID}">Edit</a>				
						<input class="button" type="submit" value="Delete" formaction="delete?id=${iMessage.messageID}"/>	
					</span>
				</span>
			</div>
		</c:forEach>
	</div>
	<div id=bottom></div> 
</form:form>
</body>
</html>