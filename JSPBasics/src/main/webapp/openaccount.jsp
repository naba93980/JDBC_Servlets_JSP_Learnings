<%@ page import="java.sql.*" language="java"
	contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" errorPage="/errorHandler.jsp"%>
	
<%@ include file="openaccount.html" %>

<%!
	Connection connection;
	PreparedStatement statement;

	public void jspInit() {
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost/mydb", "root", "12345678");
			statement = connection.prepareStatement("INSERT INTO account VALUE(?,?,?,?)");
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public void jspDestroy(){
		try{
			statement.close();
			connection.close();
		}catch (Exception e){
			e.printStackTrace();
		}
	}
%>


<%

	int accno = Integer.parseInt(request.getParameter("accno"));
	String lastname = request.getParameter("lastname");
	String firstname = request.getParameter("firstname");
	int bal = Integer.parseInt(request.getParameter("bal"));
	
	statement.setInt(1, accno);
	statement.setString(2, lastname);
	statement.setString(3, firstname);
	statement.setInt(4, bal);
	
	int result = statement.executeUpdate();
	
 	out.println(result + " recorded");
%>

 	
