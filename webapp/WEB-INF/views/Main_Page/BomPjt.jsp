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
<link href="/ISMEDIA/assets/css/bompjt.css" rel="stylesheet" type="text/css">
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
							<h1 id="sub_h1">장비재료비</h1>
						</div>
						<div id="txt_header">
							<p>장비재료비를 볼 수 있는 화면입니다</p>
							<p>년도를 입력하시고 찾기 버튼을 눌러주세요</p>
						</div>
					</div>
					
					<div id="search">
						<form id="search_form" action="/ISMEDIA/bom/pjtlist" method="get">
							<input type="text" id="kwd" name="kwd" value="${pjtlist.keyword }">
							<input type="submit" value="찾기">
						</form>
					</div>
					

					<div id="map_container">
						<div id="board">
							<table class="tbl-ex">
								<tr>
									<th>수주일자</th>
									<th>프로젝트번호</th>
									<th>프로젝트명</th>
									<th>품목코드</th>
									<th>품목명</th>
									<th>규격</th>
									<th>수량</th>
									<th>이니셜</th>
								</tr>
								
								<c:forEach var="vo" items="${pjtlist.list}" varStatus="status">
									<tr>
										<td>${vo.orderdt }</td>
										<td align="center"><a href="/ISMEDIA/bom/bomlist?pjtno=${vo.pjtno }&itemcd=${vo.itemcd}">${vo.pjtno }</a></td>
										<td>${vo.pjtnm}</td>
										<td>${vo.itemcd }</td>
										<td align="left">${vo.itemnm }</td>
										<td>${vo.size }</td>
										<td align="right">${vo.qty }</td>
										<td>${vo.customnm }</td>
									</tr>
								</c:forEach>
							</table>

							<c:if test="${empty pjtlist.list }">
								<div id="map_right">
									<div id="map_risk">
										<img src="/ISMEDIA/assets/images/pjtlist/risk.png">
									</div>
									<p class="map_list-right">
										검색된 결과를 찾을 수 없습니다. <br>
									</p>
								</div>
							</c:if>

							<!-- begin:paging -->
							<c:if test='${not empty pjtlist.list }'>
							<div class="pager">
								<ul>
									<c:if test="${pjtlist.prevtoPage >= 0 }">
										<li><a href="/ISMEDIA/bom/pjtlist?kwd=${pjtlist.keyword}&p=${pjtlist.prevtoPage }">◀◀</a></li>
									</c:if>

									<c:if test="${pjtlist.prevPage >= 0 }">
										<li><a href="/ISMEDIA/bom/pjtlist?kwd=${pjtlist.keyword}&p=${pjtlist.prevPage }">◀</a></li>
									</c:if>

									<c:forEach begin='${pjtlist.firstPage }' end='${pjtlist.lastPage }'
										step='1' var='i'>
										<c:choose>
											<c:when test='${pjtlist.currentPage == i }'>
												<li class="selected">${i }</li>
											</c:when>

											<c:when test='${i > pjtlist.pageCount }'>
												<li>${i }</li>
											</c:when>

											<c:otherwise>
												<li><a href="/ISMEDIA/bom/pjtlist?kwd=${pjtlist.keyword}&p=${i }">${i }</a></li>
											</c:otherwise>
										</c:choose>
									</c:forEach>

									<c:if test='${pjtlist.nextPage > 0 }'>
										<li><a href="/ISMEDIA/bom/pjtlist?kwd=${pjtlist.keyword}&p=${pjtlist.nextPage }">▶</a></li>
									</c:if>
									<c:if test='${pjtlist.nexttoPage > 0 }'>
										<li><a href="/ISMEDIA/bom/pjtlist?kwd=${pjtlist.keyword}&p=${pjtlist.nexttoPage }">▶▶</a></li>
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

<script>
$(function() {	
 	
	 $("#radioTotal").on("click", function(){
		
		var keyword = $("#radioTotal").val();
		
		$.ajax({	
			url: "radioTotal",
			type: "POST",
			data: {"keyword": keyword},
			dataType: "text",
			success: function(result){	
				console.log(result);
				 if(result == "true"){
					 location.href='/ISMEDIA/pjtlist/list?kwd=${pjtlist.keyword}';
				} 
			},
			error: function(jsXHR, status, e){
				console.error("error:"+status+":"+e);
			}
		});
	});
	 
	 
	 $("#radioGraph").on("click", function(){
			
			var keyword = $("#radioGraph").val();
			
			$.ajax({	
				url: "radioGraph",
				type: "POST",
				data: {"keyword": keyword},
				dataType: "text",
				success: function(result){	
					console.log(result);
					 if(result == "true"){
						 location.href='/ISMEDIA/pjtlist/graph?kwd=${pjtlist.keyword}';
					} 
				},
				error: function(jsXHR, status, e){
					console.error("error:"+status+":"+e);
				}
			});
		});
});
</script>
