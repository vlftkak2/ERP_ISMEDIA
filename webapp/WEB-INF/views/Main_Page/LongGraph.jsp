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
<link href="/ISMEDIA/assets/css/stockgraph.css" rel="stylesheet" type="text/css">
<link href="/ISMEDIA/assets/css/login.css" rel="stylesheet" type="text/css">  
<script type="text/javascript" src="/ISMEDIA/assets/js/jquery/jquery-1.9.0.js"></script>
<script src="/ISMEDIA/assets/js/sweetalert.min.js"></script> 

<script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
<script src="http://code.jquery.com/jquery-latest.js"></script>

<script type="text/javascript">
google.charts.load('current', {'packages' : ['corechart']});
google.charts.setOnLoadCallback(drawChart);

function drawChart(){
	
	var data = new google.visualization.DataTable();

    data.addColumn('string', '계정');
    data.addColumn('number', '금액');

    data.addRows([
    	
    	<c:forEach var='vo' items='${longGraph.Graph}' varStatus='status' >
    	['${vo.itemkind}',${vo.amt}],
    	</c:forEach>
  ]);
    
    var Pieoptions = {'title' : '품목계정 통계 [원형그래프]', 'width' :850, 'height' : 500};
    var Piechart = new google.visualization.PieChart(document.getElementById('Piechart'));
    
    var Baroptions = {'title' : '품목계정 통계 [막대그래프]', 'width' :850, 'height' : 500};
    var Barchart = new google.visualization.BarChart(document.getElementById('Barchart'));
    
    Piechart.draw(data, Pieoptions);
    Barchart.draw(data, Baroptions);
}
</script>

<script type="text/javascript">
google.charts.load('current', {'packages' : ['corechart']});
google.charts.setOnLoadCallback(drawChart);

function drawChart(){
	
	var data = new google.visualization.DataTable();
    data.addColumn('string', '계정');
    data.addColumn('number', '금액');

    data.addRows([	
    	<c:forEach var='vo' items='${longGraph.HighGraph}' varStatus='status' >
    	['${vo.itemnm}',${vo.amt}],
    	</c:forEach>
  ]);
    var HighPieoptions = {'title' : '상위10 통계 [원형그래프]', 'width' :850, 'height' : 500};
    var HighPiechart = new google.visualization.PieChart(document.getElementById('HighPiechart'));
    
    var HighBaroptions = {'title' : '상위10 통계 [막대그래프]', 'width' :850, 'height' : 500};
    var HighBarchart = new google.visualization.BarChart(document.getElementById('HighBarchart'));
    
    HighPiechart.draw(data, HighPieoptions);
    HighBarchart.draw(data, HighBaroptions);
}
</script>

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
        			<input type="radio" id=radioTotal name="radioTxt" value="${longGraph.keyword }"  >리스트조회
        			<input type="radio" id="radioGraph" name="radioTxt" value="${longGraph.keyword }" checked >통계조회
					</form>
					</div>
					</c:if>

					<div id=map_container>
						<div id="board">
							
							<div id="ItemkindChart">
							<div id="Piechart"></div>
							<div id="Barchart"></div>
							</div>
							
							<div id="HighChart">
							<div id="HighPiechart"></div>
							<div id="HighBarchart"></div>
							</div>

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
