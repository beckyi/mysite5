<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@page import="java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<title>mysite5</title>
<meta http-equiv="content-type" content="text/html; charset=utf-8">
<link href="/mysite5/assets/css/board.css" rel="stylesheet" type="text/css">
</head>
<body>
	<div id="container">
		<c:import url='/WEB-INF/views/include/header.jsp'/>
		<div id="content">
			<div id="board">
				<form id="search_form" action="/mysite5/board" method="get">
               <input type="text" id="kwd" name="kwd" value="">
					<input type="submit" value="찾기">
				</form>
				<table class="tbl-ex">
					<tr>
						<th>번호</th>
						<th>제목</th>
						<th>작성일</th>
					</tr>
					<c:forEach items="${listBoard }" var="bbsVo">
					 <tr>
						<td>${bbsVo.no }</td>
                  		<td><a href="view?no=${bbsVo.no}" >${bbsVo.title }</a></td>
                  		<td>${bbsVo.regdate }</td>
					 </tr>
					</c:forEach>
				</table>
				<div class="bottom">
               		<a href="write" id="new-book">글쓰기</a>
            	</div>   
			</div>
		</div>
		<c:import url='/WEB-INF/views/include/navi.jsp'/>
		<c:import url='/WEB-INF/views/include/footer.jsp'/>
	</div>
</body>
</html>