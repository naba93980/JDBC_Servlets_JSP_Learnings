<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

 <jsp:useBean id="product1" class="com.jsp.actions.Product" ></jsp:useBean>
 <jsp:setProperty property="*" name="product1"/>
 
 <p>Product Details : </p>
 <jsp:getProperty property="id" name="product1"/><br>
 <jsp:getProperty property="name" name="product1"/><br>
 <p><%=product1.getDescription() %></p>
 <p><%=product1.getPrice() %></p>
 
</body>
</html>