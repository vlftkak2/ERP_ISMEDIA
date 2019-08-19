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
<link href="/ISMEDIA/assets/css/bomlist2.css" rel="stylesheet" type="text/css">
<link href="/ISMEDIA/assets/css/login.css" rel="stylesheet" type="text/css">  
<script type="text/javascript" src="/ISMEDIA/assets/js/jquery/jquery-1.9.0.js"></script>
<script src="/ISMEDIA/assets/js/sweetalert.min.js"></script> 
</head>
<body >
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
					
					<c:if test="${not empty mpbomlist.bomlist }">
					<div id="radio">
					<form id="radio_form">
        			<input type="radio" id="radioTotal" name="radioTxt" value="${mpbomlist.keyword }" checked>리스트조회
        			<input type="radio" id="radioGraph" name="radioTxt" value="${mpbomlist.keyword }">통계조회
        			<input type="button" id="Button" name="FileDown" onclick="location.href='/ISMEDIA/bom/downloadCSV?pjtno=${mpbomlist.pjtno }&itemcd=${mpbomlist.itemcd }'" value="BOM 파일 다운로드 ">
					</form>
					</div>
					</c:if>

					<div id="map_container" >
						<div id="board">
							<table class="tbl-ex">
							<thead>
								<tr>
									<th>순서</th>
									<th>모품목코드</th>
									<th>모품목명</th>
									<th>자품목코드</th>
									<th>품목명</th>
									<th>규격</th>
									<th>패키지</th>
									<th>메이커</th>
									<th>레벨</th>
									<th>reference</th>
									<th>표준원수</th>
									<th>소요원수</th>
									<th>화폐</th>
									<th>단가</th>
									<th>금액</th>
									<th>거래처</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach var="vo" items="${mpbomlist.bomlist}" varStatus="status">
									<tr>
										<td align="center">${vo.seqno }</td>
										<td>${vo.pitemcd }</td>
										<td align="left">${vo.pitemnm }</td>
										<td align="center">${vo.itemcd }</td>
										<td align="center">${vo.itemnm }</td>
										<td align="center">${vo.size }</td>
										<td align="center">${vo.material }</td>
										<td align="center">${vo.maker }</td>
										<td align="center">${vo.level }</td>
										<td align="center">${vo.reference }</td>
										<td align="center">${vo.bomst }</td>
										<td align="center">${vo.bomsu }</td>
										<td align="center">${vo.currency }</td>
										<td align="right"><fmt:formatNumber value="${vo.price}" pattern="#,##0" /></td>
										<td align="right"><fmt:formatNumber value="${vo.amt }" pattern="#,##0" /></td>
										<td align="center">${vo.customnm }</td>
									</tr>
								</c:forEach>
								</tbody>
							</table>

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
