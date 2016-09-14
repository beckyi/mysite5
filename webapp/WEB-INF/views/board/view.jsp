<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
<head>
<title>mysite</title>
<meta http-equiv="content-type" content="text/html; charset=utf-8">
<link href="/mysite5/assets/css/board.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="/mysite5/assets/js/jquery/jquery-1.9.0.js"></script>
<script type="text/javascript">
$(function() { 
   $("#attachFile").on("click", function(event){
      var fno = $(this).data("fno");
      console.log("view: " + fno);
      var url = "download?fno=" + fno;
      window.open(url);   
   });
});
</script>

</head>
<body>
	<div id="container">
		<c:import url='/WEB-INF/views/include/header.jsp'/>
		<div id="content">
			<div id="board" class="board-form">
				<table class="tbl-ex">
					<tr>
						<th colspan="2">글보기</th>
					</tr>
					<tr>
						<td class="label">제목</td>
						<td>${readBoardVo.title }</td>
					</tr>
					<tr>
						<td class="label">내용</td>
						<td>
							<div class="view-content">
								${readBoardVo.content}
							</div>
						</td>
					</tr>
					<tr>
                  		<td class="label"> 파일명 </td>
                  		<td id="attachFile" data-fno='${attachFileVo.fno }'> ${attachFileVo.orgName }</td>
               		</tr>
				</table>
				<div class="bottom">
					<a href="list">글목록</a>		
					<a href="modifyform?no=${readBoardVo.no}">글수정</a>
				</div>
			</div>
		</div>
		<c:import url='/WEB-INF/views/include/navi.jsp'/>
		<c:import url='/WEB-INF/views/include/footer.jsp'/>
	</div>
</body>
</html>