<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<form action="<%= request.getContextPath() %>/EmployeeLogin" method="post">
   <table style="with: 80%">
    <tr>
     <td>Login</td>
     <td><input type="text" name="login" /></td>
    </tr>
    <tr>
     <td>password</td>
     <td><input type="password" name="senha" /></td>
    </tr>
    </table>
    <input type="submit" value="Submit" />
</form>
</body>
</html>