<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ page session="false" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
<title>게시글 목록</title>
<script>
  
</script>

</head>
<body>
 
 <h1>게시글 목록</h1>
 <table border = "1" width = "900px">
 	<tr>
 		<th width = "50px">No</th>
 		<th width = "400px">제목</th>
 		<th width = "100px">이름</th>
 		<th width = "300px">작성일</th>
 		<th width = "50px">조회수</th>
 	</tr>
 	<c:choose>
 		 <c:when test="${fn:length(list) == 0}">
                            <tr>
                                <td colspan="4" align="center"> 조회결과가 없습니다. </td>
                            </tr>
         </c:when>
         <c:otherwise>
      	   <c:forEach var="row" items = "${list }">
 			<tr>
 				<td align = "center">${row.bno }</td>
 				<td><a name = "title" content_id = "${row.bno }">${row.title }</a></td>
 				<td align = "center">${row.writer }</td>
 				<td align = "center">${row.regdate }</td>
 				<td align = "center">${row.viewcnt }</td>
 			</tr>
 			</c:forEach>
         </c:otherwise>
 	</c:choose>
 	
 </table>
 
 <button type="button" id = "btnWrite" onclick="location.href='/write'"> 글쓰기</button>
 
 
</body>
</html>
