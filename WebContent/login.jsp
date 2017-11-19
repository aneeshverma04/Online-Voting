<%@page import="com.voting.online.Login"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login</title>
</head>
<body>
<jsp:useBean id="loginObject" class="com.voting.online.Login"></jsp:useBean>
<jsp:setProperty property="*" name="loginObject"/>
<% 
	boolean val = loginObject.verify();
	if(val) {
		out.print("Login Successfull");
		out.println("<br>");
		session.setAttribute("Fname", Login.Fname);
		session.setAttribute("Lname", Login.Lname);
		out.print("Welcome : " + session.getAttribute("Fname") + " " + session.getAttribute("Lname"));		
	}
	else
		out.println("Unsuccessfull");
%> 
<%--  <jsp:getProperty property="email" name="loginObject"/> 
	this only for attributes of bean class
--%>

<jsp:forward page="Temp1.jsp"></jsp:forward>
</body>
</html>