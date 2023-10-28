
<%-- DIRECTIVES (page, include, taglib) --%> 
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>


<%-- SCRIPTING ELEMENTS--%> 
<% 
	int num1 = Integer.parseInt(request.getParameter("number1"));
	int num2 = Integer.parseInt(request.getParameter("number2"));
%>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
</head>
<body>
	<p>sum of <%=num1 %> and <%= num2 %> is <%= num1 + num2 %></p>
</body>
</html>
