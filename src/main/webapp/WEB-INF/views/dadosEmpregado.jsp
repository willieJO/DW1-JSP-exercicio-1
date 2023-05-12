<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String name = request.getAttribute("id").toString();
	String nome = request.getAttribute("id").toString();
	String sobrenome = request.getAttribute("id").toString();
	String adress = request.getAttribute("id").toString();
	String contato = request.getAttribute("id").toString();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>Logou <%=name%></h3>
</body>
</html>