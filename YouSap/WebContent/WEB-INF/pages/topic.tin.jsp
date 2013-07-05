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
	
	<script language="javascript">
function toggle2(showHideDiv, switchTextDiv) {
var ele = document.getElementById(showHideDiv);
var text = document.getElementById(switchTextDiv);
if(ele.style.display == "block") {
ele.style.display = "none";
text.innerHTML = "bulaga";
}
else {
ele.style.display = "block";
text.innerHTML = "hala ka";
}
}
function toggle3(contentDiv, controlDiv) {
if (contentDiv.constructor == Array) {
for(i=0; i < contentDiv.length; i++) {
toggle2(contentDiv[i], controlDiv[i]);
}
}
else {
toggle2(contentDiv, controlDiv);
}
}
</script>
	
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
	<table>
	<tr>
	<td>
	<div style="border: 1px solid blue; background-color: ‎#99CCFF; padding: 5px; width: 150px;">
<a id="myHeader1" href="javascript:toggle2('myContent1','myHeader1');" >click me</a>
</div>
		<c:forEach items="${messageList}" var="iMessage">
			<div id="myContent1" style="display: none">
<span id="content" class="message">
<span id="content" class="message-data">
<span class="username">
{iMessage.username}
</span>
<span>
Message #:{iMessage.messageID}
</span>
</span>
<span id="content" class="reply-data">
Reply To <!-- ${iMessage.parentMessageID} ${iMessage.date} -->
</span>
<span class="message-text">
{iMessage.messageText}
</span>
</span>
</div>


</td>
<td>
<div style="border: 1px solid blue; background-color: #99CCFF; padding: 5px; width: 150px;">
<a id="myHeader2" href="javascript:toggle2('myContent2','myHeader2');" >click me</a>
</div>
<div id="myContent2" style="display: none"><textarea rows="10" cols="35"></textarea>
</div>
</td>
<td>
<div style="border: 1px solid blue; background-color: #99CCFF; padding: 5px; width: 150px;">
<a id="myHeader3" href="javascript:toggle2('myContent3', 'myHeader3');" >click me</a>
</div>
<div id="myContent3" style="display: none"><textarea rows="10" cols="35"></textarea>
</div>
</td>
</tr>
</table>
		</c:forEach>
	
</form:form>
</body>
</html>