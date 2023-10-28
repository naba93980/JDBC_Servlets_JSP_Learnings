<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>error page</title>
</head>
<body>
	<p>sorry for error</p>
	<%= exception.getMessage() %>
</body>
</html>