<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page session="false"%>
<!doctype html>
<html>
<head>
	<title>Yousap</title>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/RES/css/green.css"/>
</head>
<body>	
<div id="content" style="margin-bottom:30px;">
	<h1>
		Yousap
	</h1>
</div>

<form:form commandName="message" method="POST">
	<div>
		<table id="content" style="text-align:left">	
			<tr>
				<td>
					Username
				</td>
				<td>
					<form:input path="username"/>
				</td>
			</tr>
			<tr>
				<td>
					Message
				</td>
				<td>
					<form:textarea rows="4" path="messageText" maxlength="2000"/>
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
				<td colspan="2" style="text-align:center;border-bottom-width:0">							
					<input class="button" type="submit" value="Save" formaction="add"/>	
				</td>
			</tr>
		</table>
	</div>
	<div>
		<c:forEach items="${messageList}" var="iMessage">
			<div>				
				<span id="content" class="message">
					<span id="content" class="message-header">						
						<span class="username">							
							<form:radiobutton path="parentMessageID" value="${iMessage.messageID}"/>
							${iMessage.username}
						</span>
						<span>
							Msg. ${iMessage.messageID}
						</span>
						<span>
							 [${iMessage.date}]
						</span>
					</span>					
					<c:if test="${iMessage.parentMessageID!='-1'}">
						<span id="content" class="reply-header">
							Reply to Msg.${iMessage.parentMessageID}
						</span>					
					</c:if>
					<span class="message-text">
						${iMessage.messageText}
					</span>
				</span>
			</div>
		</c:forEach>
	</div>
</form:form>
</body>
</html>