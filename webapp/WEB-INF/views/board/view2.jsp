<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%
	pageContext.setAttribute("newLine", "\n");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="/mysite5/assets/css/board.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="/mysite5/assets/js/jquery/jquery-1.9.0.js"></script>
<title>Insert title here</title>
</head>
<body>
	<div id="container">
		<c:import url='/WEB-INF/views/include/header.jsp' />
		<div id="content">
			<div id="board" class="board-form">
				<form method="post" action="">
					<table class="tbl-ex">
						<tr>
							<th colspan="2">글보기</th>
						</tr>
						<tr>
							<td class="label">제목</td>
							<td id="bTitle"></td>
						</tr>
						<tr>
							<td class="label" >내용</td>
							<td id="bContent">
							</td>
						</tr>
					</table>
					<input type="text" id="no" name="no" value="" />
					<div class="bottom">
						<input id="btn_read" type="button" value="글가져오기">
					</div>
				</form>
			</div>
		</div>
		<c:import url='/WEB-INF/views/include/navi.jsp' />
		<c:import url='/WEB-INF/views/include/footer.jsp' />
	</div>
</body>
<script>
	$("#btn_read").on("click",function(){
		var no = $("#no").val();
		var title = "제목입니다";
		var content="내용입니다.";
		
		
		//Script 객체
		var bbsVo ={
			"no": no,
			"title": title,
			"content": content
		};
		
		$.ajax( {
			url : "readAjax",
			type: "POST",
			data: JSON.stringify(bbsVo),	//보냄
			dataType: "json",
			contentType: "application/json",
			success: function( bbsVo ){	//받아옴
				console.log(bbsVo);
				$("#bTitle").html(bbsVo.title);
				$("#bContent").html(bbsVo.content);
			},
			error: function( jqXHR, status, error ){
				console.error( status + " : " + error );
			}
		});
	});
</script>
</html>