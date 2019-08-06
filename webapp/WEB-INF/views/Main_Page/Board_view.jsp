<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>isMedia</title>
<link rel="stylesheet" type="text/css" href="/ISMEDIA/assets/css/sweetalert.css">
<link href="/ISMEDIA/assets/css/board.css" rel="stylesheet" type="text/css">
<link href="/ISMEDIA/assets/css/login.css" rel="stylesheet" type="text/css">  
<script type="text/javascript" src="/ISMEDIA/assets/js/jquery/jquery-1.9.0.js"></script>
<script src="/ISMEDIA/assets/js/sweetalert.min.js"></script> 

<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>

</head>
<body>
<div id="container">

<jsp:include page="/WEB-INF/views/include/header.jsp" />
	 <div id="content">
			
		</div><div class="container_map">
				<div class="container_mapsub">

					<div id="store_header">
						<div id="store">
							<h1 id="sub_h1">게시판</h1>
						</div>
						<div id="txt_header">
							<p>게시판에 글을 작성하는 화면입니다</p>
							<p>글 작성을 해주시길 바랍니다</p>
						</div>
					</div>
					
					
					<div id="map_container">
						<div id="board" class="board">
						<form class="board-form" method="post" autocomplete="off"
						action="/ISMEDIA/board/write?userid=${authUser.id }"
						enctype="multipart/form-data">
						
						<table class="tbl-ex">
							<tr>
								<th colspan="2">글보기</th>
							</tr>
							<tr>
								<td class="label">제목</td>
								<td><input type="text" name="title" value=""></td>
							</tr>
							<tr>
								<td class="label">내용</td>
								<td><textarea id="content" name="content"></textarea></td>
							</tr>
							<tr>
								<td class="label">첨부파일</td>
								<td><input type="file" name="file" class="ShowFileName" multiple="multiple" >
							</tr>
						</table>

						<div class="bottom">
							<a href="/ISMEDIA/board/list">취소</a> <input type="submit" value="등록">
						</div>
					</form>
						</div>
						<div id="map"></div>
						
					</div>

				</div>
			</div>
</div>

<jsp:include page="/WEB-INF/views/include/footer.jsp" />


</body>
