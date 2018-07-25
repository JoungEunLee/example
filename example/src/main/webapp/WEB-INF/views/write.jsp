<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
<title>Home</title>
</head>
<body>
 
 <h1>게시글 작성</h1>
 
 <form name="form1" method="POST" action="/insert">
    <div> 제목  <input name="title" id="title" size="80" placeholder="제목을 입력해주세요">
    </div>
    <div> 내용 <textarea name="content" id="content" rows="4" cols="80" placeholder="내용을 입력해주세요"></textarea>
    </div>
    <div> 이름 <input name="writer" id="writer" placeholder="이름을 입력해주세요">
    </div>
    <button type="button" id="back" onclick="location.href='/list'">뒤로가기</button>
    <div style="width:650px; text-align: center;">
        <button type="submit" id="btnSave">확인</button>
        <button type="reset">취소</button>
    </div>
</form>
 
 
</body>
</html>
