<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
<title>Home</title>
<style>
#modDiv {
	width: 300px;
	height: 100px;
	background-color: gray;
	position: absolute;
	top: 50%;
	left: 50%;
	margin-top: -50px;
	margin-left: -150px;
	padding: 10px;
	z-index: 1000;
}
</style>
</head>
<body>
 
 <div id='modDiv' style="display: none;">
		<div class='modal-title'></div>
		<div>
			<input type='text' id='replytext'>
		</div>
		<div>
			<button type="button" id="replyModBtn">Modify</button>
			<button type="button" id="replyDelBtn">DELETE</button>
			<button type="button" id='closeBtn'>Close</button>
		</div>
	</div>
 
 
 <h2>Ajax Test Page!!</h2>
 
 	<div>
		<div>
			REPLYER <input type='text' name='replyer' id='newReplyWriter'>
		</div>
		<div>
			REPLY TEXT <input type='text' name='replytext' id='newReplyText'>
		</div>
		<button id="replyAddBtn">ADD REPLY</button>
	</div>
 
   
  <ul id = "replies">
  </ul>
 
 <!-- jQuery -->
 <script src = "/resources/plugins/jQuery/jQuery-2.1.4.min.js" type="text/javascript"></script>
 <script type="text/javascript">
 	var bno = 9;
 	
 	getList();
 	
 	//전체 댓글 목록 출력 getAllList 함수 처리
 	function getList() {

			$.getJSON("/reply/all/" + bno, function(data) {
				console.log(data.length);
				var str = "";
				$(data).each(function() {
					str += "<li data-rno='"+this.rno+"' class='replyLi'>"
						+ this.rno
						+ ":"
						+ this.replytext
						+ "<button>MOD</button></li>";
				});

				$("#replies").html(str);
			});
 	}
 	

 	
 	//버튼 클릭 이벤트 처리 + 댓글 등록 후 getAllList 호출해 댓글 목록 갱신
 	$("#replyAddBtn").on("click", function() {

		var replyer = $("#newReplyWriter").val();
		var replytext = $("#newReplyText").val();

		$.ajax({
			type : 'post',
			url : '/reply',
			headers : {
				"Content-Type" : "application/json",
				"X-HTTP-Method-Override" : "POST"
			},
			dataType : 'text',
			data : JSON.stringify({
				bno : bno,
				replyer : replyer,
				replytext : replytext
			}),
			success : function(result) {

				if (result == 'SUCCESS') {

					alert("등록 되었습니다.");
					getList();

				} else {
					alert("에베베베");
					getList();
				}
			}
		});
	});
 	
 	$("#replies").on("click", ".replyLi button", function() {

		var reply = $(this).parent();

		var rno = reply.attr("data-rno");
		var replytext = reply.text();

		$(".modal-title").html(rno);
		$("#replytext").val(replytext);
		$("#modDiv").show("slow");

	});
 	
 	$("#replyDelBtn").on("click", function() {

		var rno = $(".modal-title").html();
		var replytext = $("#replytext").val();

		$.ajax({
			type : 'delete',
			url : '/reply/' + rno,
			headers : {
				"Content-Type" : "application/json",
				"X-HTTP-Method-Override" : "DELETE"
			},
			dataType : 'text',
			success : function(result) {
				console.log("result: " + result);
				if (result == 'SUCCESS') {
					alert("삭제 되었습니다.");
					$("#modDiv").hide("slow");
					getList();
				}
			}
		});
	});

 	$("#replyModBtn").on("click",function(){
		  
		  var rno = $(".modal-title").html();
		  var replytext = $("#replytext").val();
		  
		  $.ajax({
				type:'put',
				url:'/reply/'+rno,
				headers: { 
				      "Content-Type": "application/json",
				      "X-HTTP-Method-Override": "PUT" },
				data:JSON.stringify({replytext:replytext}), 
				dataType:'text', 
				success:function(result){
					console.log("result: " + result);
					if(result == 'SUCCESS'){
						alert("수정 되었습니다.");
						 $("#modDiv").hide("slow");
						getList();
						 //getPageList(replyPage);
					}
			}});
	});	

 
 </script>
 
</body>
</html>
