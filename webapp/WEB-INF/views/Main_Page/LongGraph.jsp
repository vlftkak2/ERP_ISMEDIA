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
<link href="/ISMEDIA/assets/css/stock.css" rel="stylesheet" type="text/css">
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
						<form id="search_form" action="/ISMEDIA/longstock/graph" method="get">
							<input type="text" id="kwd" name="kwd" value="${longGraph.keyword }">
							<input type="submit" value="찾기">
						</form>
					</div>
					
					<c:if test='${not empty longGraph.Graph }'>
					<div id="radio">
					<form id="radio_form" >
        			<input type="radio" id=radioTotal name="radioTxt" value="${longGraph.keyword }"  >전체조회
        			<input type="radio" id="radioGraph" name="radioTxt" value="${longGraph.keyword }" checked >통계조회
					</form>
					</div>
					</c:if>

					<div id=map_container>
						<div id="board">
							<table class="tbl-ex">
								<tr>
									<th>기준월</th>
									<th>품목계정</th>
									<th>재고</th>
									<th>금액</th>
								</tr>
								
								<c:forEach var='vo' items='${longGraph.Graph}' varStatus='status' >
									<tr>
										<td>${vo.stdate }</td>
										<td>${vo.itemkind}</td>
										<td><fmt:formatNumber value="${vo.jqty}" pattern="#,##0" /></td>
										<td><fmt:formatNumber value="${vo.amt}" pattern="#,##0.00" /></td>
									</tr>
								</c:forEach>
							</table>

							<c:if test='${empty longGraph.Graph }'>
								<div id="map_right">
									<div id="map_risk">
										<img src="/ISMEDIA/assets/images/longstock/risk.png">
									</div>
									<p class="map_list-right">
										검색된 결과를 찾을 수 없습니다. <br>
									</p>
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
					 location.href='/ISMEDIA/longstock/list?kwd=${longGraph.keyword}';
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
