<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
<title>Home</title>
<script language = javascript>
//게시물 수정, 삭제
function btn_click(str){
	if(str == 'update'){
		form2.action = "/update";
	}else if(str == 'delete'){
		form2.action = "/delete";
	}
}

// Controller방식
// **댓글 목록1
function listReply(){
    $.ajax({
        type: "get",
        url: "/list?bno=${dto.bno}",
        success: function(result){
        // responseText가 result에 저장됨.
            $("#listReply").html(result);
        }
    });
}
// RestController방식 (Json)
// **댓글 목록2 (json)
function listReply2(){
    $.ajax({
        type: "get",
        //contentType: "application/json", ==> 생략가능(RestController이기때문에 가능)
        url: "/listJson?bno=${dto.bno}",
        success: function(result){
            console.log(result);
            var output = "<table>";
            for(var i in result){
                output += "<tr>";
                output += "<td>"+result[i].userName;
                output += "("+changeDate(result[i].regdate)+")<br>";
                output += result[i].replytext+"</td>";
                output += "<tr>";
            }
            output += "</table>";
            $("#listReply").html(output);
        }
    });
}
// **날짜 변환 함수 작성
function changeDate(date){
    date = new Date(parseInt(date));
    year = date.getFullYear();
    month = date.getMonth();
    day = date.getDate();
    hour = date.getHours();
    minute = date.getMinutes();
    second = date.getSeconds();
    strDate = year+"-"+month+"-"+day+" "+hour+":"+minute+":"+second;
    return strDate;
}

</script>
</head>
<body>
 
 <h1>게시글 보기</h1>
 <form name="form2" method="POST">
    <div>        <!-- 원하는 날짜형식으로 출력하기 위해 fmt태그 사용 -->
        작성일자 : <fmt:formatDate value="${dto.regdate}" pattern="yyyy-MM-dd a HH:mm:ss"/>
                <!-- 날짜 형식 => yyyy 4자리연도, MM 월, dd 일, a 오전/오후, HH 24시간제, hh 12시간제, mm 분, ss 초 -->
    </div>
    <div>
        조회수 : ${dto.viewcnt}
    </div>
    <div>
        제목
        <input name="title" id="title" size="80" value="${dto.title}" placeholder="제목을 입력해주세요">
    </div>
    <div>
        내용
        <textarea name="content" id="content" rows="4" cols="80" placeholder="내용을 입력해주세요">${dto.content}</textarea>
    </div>
    <div>
        이름
        <input name="writer" id="writer" value="${dto.writer}" placeholder="이름을 입력해주세요">
    </div>
    <button type="button" id="back" onclick="location.href='/list'">뒤로가기</button>
    <div style="width:650px; text-align: center;">
        <!-- 게시물번호를 hidden으로 처리 -->
        <input type="hidden" name="bno" value="${dto.bno}">
         <button type="submit" id="btnUpdate" onclick = "btn_click('update')">수정</button>
         <button type="submit" id="btnDelete" onclick = "btn_click('delete')">삭제</button>
    </div>
</form>
</br>
</br>
</br>
	<div>
        이름	<input name="writer" id="writer" value="${dto.writer}" placeholder="이름을 입력해주세요">
    </div>
 	<div style="width:650px; text-align: center;">
        <br>
        <!-- **로그인 한 회원에게만 댓글 작성폼이 보이게 처리 -->
        <!-- 로그인 아직 <c:if test="${sessionScope.userId != null}">    --> 
        <textarea rows="2" cols="40" id="replytext" placeholder="댓글을 작성해주세요"></textarea>
        <br>
        <button type="button" id="btnReply">댓글 작성</button>
        <!-- </c:if> -->
    </div>
    
    <!-- **댓글 목록 출력할 위치 -->
    <div id="listReply"></div>

 
</body>
</html>
