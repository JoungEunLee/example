<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
<title>replyList</title>
</head>
<body>
    <table style="width:700px">
        <c:forEach var="row" items="${list}">
        <tr>    
            <td>
                ${row.userName}(<fmt:formatDate value="${row.regdate}" pattern="yyyy-MM-dd HH:mm:ss"/>)
                <br>
                ${row.replytext}
            </td>
        </tr>
        </c:forEach>
    </table>
</body>
</html>
