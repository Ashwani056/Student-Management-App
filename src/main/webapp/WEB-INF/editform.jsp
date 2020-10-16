<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

<title>Insert title here</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
</head>
<body>
<jsp:include page="/WEB-INF/welcome.jsp"/>
<br><br>
<h2 style="color:red;" align="center">Durga Software Solution</h2>
<h2 style="color:green;" align="center">Student Edit form</h2>
<form method="POST" action="update">
<table align="center">
<tr>
	<td>Student Id</td>
	<td>${student.sid}</td>
</tr>
<tr>
	<td>Student Name</td>
	<td><input type="text" name="sname",value='${student.sname}'></td>
</tr>
<tr>
	<td>Student Address</td>
	<td><input type="text" name="saddr",value='${student.saddr}'></td>
</tr>
<tr>
	<td><input type="submit" value="UPDATE"></td>
</tr>
</table>
<input type="hidden" name="sid" value='${student.sid}'/>
</form>
</body>
</html>