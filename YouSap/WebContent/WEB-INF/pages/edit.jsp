<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page session="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/RES/css/green.css"/>
		<title>Editing Message ${message.messageID}</title>
	</head>
	<body>
		<div class="content" style="margin-bottom:30px;">
			<h1>
				Editing Message ${message.messageID}
			</h1>
		</div>
		<form:form commandName="message" method="POST">
		<div>
				<table class="content" style="text-align:left">	
					<tr>
						<td>
							Username:
						</td>
						<td>
							${message.username}
						</td>
					</tr>
					<tr>
						<td>
							Message
						</td>
						<td>
							<form:textarea rows="4" path="messageText" value="${message.messageText}" maxlength="2000"/>
						</td>
					</tr>
					<tr>
						<fmt:parseNumber var="nullID" value="-1" />		
						<c:if test="${message.parentMessageID > nullID}">
							<td>
								Replied to 
							</td>
							<td>
								${message.parentMessageID} 
							</td>
						</c:if>
					</tr>
					<tr>
						<td class="button-footer" colspan="2">
							<fmt:parseNumber var="id" value="${message.messageID}"/>							
							<input class="button" type="submit" value="Save"/>	
						</td>
					</tr>
				</table>
			</div>
		</form:form>
	</body>
</html>