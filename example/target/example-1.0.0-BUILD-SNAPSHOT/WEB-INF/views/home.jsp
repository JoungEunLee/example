<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
<title>Home</title>
</head>
<body>
 
 <h1>Hello world!</h1>
    <form action = "/main" method = "POST">
		ID : <input type="text" name="id"><br>
		Password : <input type="password" name="pw"><br>		
		이름 : <input type="text" name="name"><br><br>
 
 
 <button type="submit" class="btn_button">입력</button>
 
 </form>

 
</body>
</html>
