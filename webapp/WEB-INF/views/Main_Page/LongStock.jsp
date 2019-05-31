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
<link href="/ISMEDIA/assets/css/longstock.css" rel="stylesheet" type="text/css">
<link href="/ISMEDIA/assets/css/login.css" rel="stylesheet" type="text/css">  
<script type="text/javascript" src="/ISMEDIA/assets/js/jquery/jquery-1.9.0.js"></script>
<script src="/ISMEDIA/assets/js/sweetalert.min.js"></script> 
</head>
<body>
<div id="container">

<jsp:include page="/WEB-INF/views/include/header.jsp" />
	 <div id="content">
			<div class="container_map">
				<div class="container_mapsub">

					<div id="store_header">
						<div id="store">
							<h1 id="sub_h1">장기재고</h1>
						</div>
						<div id="txt_header">
							<p>품목별 장기재고현황을 볼 수 있는 화면입니다</p>
							<p>년도를 입력하시고 찾기 버튼을 눌러주세요</p>
						</div>
					</div>
					
						<div id="search">
						<form id="search_form" action="/ISMEDIA/longstock/list" method="get">
							<input type="text" id="kwd" name="kwd" value="${longstock.keyword }">
							<input type="submit" value="찾기">
						</form>
					</div>
					
					<c:if test='${not empty longstock.list }'>
					<div id="radio">
					<form id="radio_form" >
        			<input type="radio" id=radioTotal name="radioTxt" value="${longstock.keyword }" checked >리스트조회
        			<input type="radio" id="radioGraph" name="radioTxt" value="${longstock.keyword }" >통계조회
					</form>
					</div>
					</c:if>

					<div id=map_container>
						<div id="board">
							<table class="tbl-ex">
								<tr>
									<th>기준월</th>
									<th>월</th>
									<th>품목계정</th>
									<th>품목코드</th>
									<th>품목명</th>
									<th>규격</th>
									<th>입고수량</th>
									<th>출고계</th>
									<th>출고</th>
									<th>재고</th>
									<th>품목수</th>
									<th>품목순번</th>
									<th>단가</th>
									<th>금액</th>
									<th>비고</th>
									<th>비고상세</th>
									<th>초과일수</th>
								</tr>
								
								<c:forEach var='vo' items='${longstock.list}' varStatus='status' >
									<tr>
										<td>${vo.stdate }</td>
										<td>${vo.month }</td>
										<td>${vo.itemkind}</td>
										<td>${vo.itemcd }</td>
										<td>${vo.itemnm }</td>
										<td>${vo.size }</td>
										<td><fmt:formatNumber value="${vo.inqty}" pattern="#,##0" /></td>
										<td><fmt:formatNumber value="${vo.sumout}" pattern="#,##0" /></td>
										<td><fmt:formatNumber value="${vo.outqty}" pattern="#,##0" /></td>
										<td><fmt:formatNumber value="${vo.jqty}" pattern="#,##0" /></td>
										<td>${vo.coitemcd }</td>
										<td>${vo.seqitemcd }</td>
										<td><fmt:formatNumber value="${vo.price}" pattern="#,##0.00" /></td>
										<td><fmt:formatNumber value="${vo.amt}" pattern="#,##0.00" /></td>
										<td>${vo.remark }</td>
										<td>${vo.dremark }</td>
										<td>${vo.overdate }</td>
									</tr>
								</c:forEach>
							</table>

							<c:if test='${empty longstock.list }'>
								<div id="map_right">
									<div id="map_risk">
										<img src="/ISMEDIA/assets/images/longstock/risk.png">
									</div>
									<p class="map_list-right">
										검색된 결과를 찾을 수 없습니다. <br>
									</p>
								</div>
							</c:if>

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
					 location.href='/ISMEDIA/longstock/list?kwd=${longstock.keyword}';
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
						 location.href='/ISMEDIA/longstock/graph?kwd=${longstock.keyword}';
					} 
				},
				error: function(jsXHR, status, e){
					console.error("error:"+status+":"+e);
				}
			});
		});
});
</script>
