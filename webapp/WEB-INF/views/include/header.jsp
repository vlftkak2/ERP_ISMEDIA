<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="/ISMEDIA/assets/css/header.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="/ISMEDIA/assets/js/jquery/jquery-1.9.0.js"></script>
<title>Insert title here</title>
</head>
<body>

<div class="header">
		<!-- topwrap -->
		<div class="topwrap">
			<!-- brandwrap -->
			<div class="brdwrap">
				<!-- utility -->
				<div class="uty">
					<ul>
					<c:choose>
					<c:when test='${empty sessionScope.authUser }'>
					<li><a href="/gs25/user/loginform">로그인</a></li>
					</c:when>
					<c:otherwise>
						<li>${authUser.name}님안녕하세요^^;</li>
						<li><a href="/gs25/user/logout">로그아웃</a></li>
					</c:otherwise>
				</c:choose>
						</ul>
					</div>
					<!-- //utility -->
				</div>
				<!-- //brandwrap -->
				<!-- gnbwrap -->
				<div class="gnbwrap">
					<div class="gnbw">
						<h1 class="logo"><a href="/ISMEDIA/main">GS25</a></h1>
						<div class="gnb" id="gnb_menu">
							<ul>
							<c:if test="${authUser.no==100 }">
								<li><h2><a href="/gs25/product/Mainlist" class="on">상품</a></h2>
								</li>
								</c:if>
								<li><h2><a href="/gs25/custom/list" class="on">원가검증</a></h2>
								</li>
								<li><h2><a href="/gs25/membership">SN</a></h2>
								</li>
								<li><h2><a href="/gs25/map/list">장기재고</a></h2>
								</li>
								<li><h2><a href="/gs25/companyintro">장비재료비</a></h2>
								</ul>
							</div>
						</div>

						<div class="gnb_bg" style="display: none;"></div>
					</div>
					<!-- //gnbwrap -->
				</div>
				<!-- //topwrap -->
			</div>

</body>
</html>