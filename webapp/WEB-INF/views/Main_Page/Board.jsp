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
					
					<div id="search">
						<form id="search_form" action="/ISMEDIA/board/list" method="get">
							<input type="text" id="kwd" name="kwd" value="${longstock.keyword }">
							<input type="submit" value="찾기">
						</form>
					</div>
					
						<c:choose>
						<c:when test='${empty authUser }'>
   						&nbsp;      
   						</c:when>
							<c:otherwise>
							
								<div class="writer">
									<a href="/ISMEDIA/board/write?userid=${authUser.id}" id="new-book">글쓰기</a>
								</div>

							</c:otherwise>
						</c:choose>
					
						<h4>
							전체 글수 : <span>${map.totalCount }</span>
						</h4>
					
					<div id="map_container">
						<div id="board">
							<table class="tbl-ex">
								<tr>
									<th>번호</th>
									<th>제목</th>
									<th>글쓴이</th>
									<th>조회수</th>
									<th>작성일</th>
									<th>&nbsp;</th>
								</tr>
								
								<c:forEach var="vo" items="${map.list}" varStatus="status">
									<tr>
									<c:choose>
										<c:when test='${vo.depth == 1 }'>
											<td><img src="/ISMEDIA/assets/images/board/que.PNG"></td>
										</c:when>
										<c:otherwise>
											<td><img src="/ISMEDIA/assets/images/board/an.PNG"></td>
										</c:otherwise>
									</c:choose>
									
									<td style="text-align:left; padding-left:${vo.depth*10}px">
										<c:if test='${vo.depth > 1 }'>
											<img src="/ISMEDIA/assets/images/board/re2.png">
										</c:if> 
										<a href="/ISMEDIA/board/viewform?no=${vo.no}&&groupNo=${vo.groupNo}">${vo.title }</a>
									</td>
									
										<td>${vo.name} </td>
										<td>${vo.count }</td>
										<td>${vo.regdate }</td>
										
								<td><c:choose>
									<c:when
									test='${(not empty authUser && authUser.no == vo.userNo) || (authUser.no==100)  }'>
									<a href="/gs25/custom/delete?groupNo=${vo.groupNo}&&groupOrderNo=${vo.groupOrderNo }"
									class="del">삭제</a>
									</c:when>
								<c:otherwise>
            						&nbsp;
              					</c:otherwise>
								</c:choose></td>
										
									</tr>
								</c:forEach>
							</table>

							<c:if test="${empty longstock.list }">
								<div id="map_right">
									<div id="map_risk">
										<img src="/ISMEDIA/assets/images/longstock/risk.png">
									</div>
									<p class="map_list-right">
										검색된 결과를 찾을 수 없습니다. <br>
									</p>
								</div>
							</c:if>

							<!-- begin:paging -->
							<c:if test='${not empty longstock.list }'>
							<!-- begin:paging -->
							<div class="pager">
								<ul>
									<c:if test="${longstock.prevtoPage >= 0 }">
										<li><a href="/ISMEDIA/longstock/list?kwd=${longstock.keyword}&p=${longstock.prevtoPage }">◀◀</a></li>
									</c:if>

									<c:if test="${longstock.prevPage >= 0 }">
										<li><a href="/ISMEDIA/longstock/list?kwd=${longstock.keyword}&p=${longstock.prevPage }">◀</a></li>
									</c:if>

									<c:forEach begin='${longstock.firstPage }' end='${longstock.lastPage }'
										step='1' var='i'>
										<c:choose>
											<c:when test='${longstock.currentPage == i }'>
												<li class="selected">${i }</li>
											</c:when>

											<c:when test='${i > longstock.pageCount }'>
												<li>${i }</li>
											</c:when>

											<c:otherwise>
												<li><a href="/ISMEDIA/longstock/list?kwd=${longstock.keyword}&p=${i }">${i }</a></li>
											</c:otherwise>
										</c:choose>
									</c:forEach>

									<c:if test='${longstock.nextPage > 0 }'>
										<li><a href="/ISMEDIA/longstock/list?kwd=${longstock.keyword}&p=${longstock.nextPage }">▶</a></li>
									</c:if>
									<c:if test='${longstock.nexttoPage > 0 }'>
										<li><a href="/ISMEDIA/longstock/list?kwd=${longstock.keyword}&p=${longstock.nexttoPage }">▶▶</a></li>
									</c:if>
								</ul>
							</div>
							</c:if>

						</div>
						<div id="map"></div>
						
					</div>

				</div>
			</div>
</div>

<jsp:include page="/WEB-INF/views/include/footer.jsp" />


</body>
