<%@page import="java.time.LocalDateTime"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<style>
.navbody {
	background-color: #FFFFFF !important;
}

/* MAV 글자 색상 변경 */
.navbar-brand {
	color: #28BEA2;
	font-weight: bold;
}

/* 검색 입력 테두리 색상 변경 */
/* .form-control {
    border-color: #0023a4;
} */

/* 검색 버튼 텍스트 색상 변경 */
.btn-outline-success {
	color: #28BEA2;
}

/* 검색 버튼 테두리 색상 변경 */
.btn-outline-success {
	border-color: #d3d3d3;
	font-weight: bold;
}

/* 네비게이션 바 하단에 연한 회색 밑줄 추가 */
.navbar {
	border-bottom: 1px solid #d3d3d3;
}
</style>
</head>
<body>
	<div class="navwd">
		<c:choose>
			<c:when test="${empty sessionScope.member}">
				<nav class="navbar navbar-expand-lg bg-body-tertiary navbody">
					<div class="container-fluid">
						<a class="navbar-brand" href="#">MAV</a>
						<button class="navbar-toggler" type="button"
							data-bs-toggle="collapse"
							data-bs-target="#navbarSupportedContent"
							aria-controls="navbarSupportedContent" aria-expanded="false"
							aria-label="Toggle navigation">
							<span class="navbar-toggler-icon"></span>
						</button>
						<div class="collapse navbar-collapse" id="navbarSupportedContent">
							<ul class="navbar-nav me-auto mb-2 mb-lg-0">
								<li class="nav-item"><a class="nav-link active"
									aria-current="page" href="#">Home</a></li>
								<li class="nav-item"><a class="nav-link" href="#">동호회</a></li>
								<li class="nav-item dropdown"><a
									class="nav-link dropdown-toggle" href="#" role="button"
									data-bs-toggle="dropdown" aria-expanded="false"> 매칭 </a>
									<ul class="dropdown-menu">
										<li><a class="dropdown-item" href="#">일반매칭</a></li>
										<li><a class="dropdown-item" href="#">토너먼트</a></li>
										<li><hr class="dropdown-divider"></li>
										<li><a class="dropdown-item" href="#">기타매칭</a></li>
									</ul></li>
								<li class="nav-item"><a class="nav-link active"
									aria-disabled="true" href="/MAV/login">로그인</a></li>
								<li class="nav-item"><a class="nav-link active"
									aria-disabled="true" href="/MAV/member/add/member">회원가입</a></li>
							</ul>
							<form class="d-flex" role="search">
								<input class="form-control me-2" type="search"
									placeholder="search" aria-label="Search">
								<button class="btn btn-outline-success" type="submit">search</button>
							</form>
						</div>
					</div>
				</nav>
			</c:when>
			<c:otherwise>
				<nav class="navbar navbar-expand-lg bg-body-tertiary navbody">
					<div class="container-fluid">
						<a class="navbar-brand" href="#">MAV</a>
						<button class="navbar-toggler" type="button"
							data-bs-toggle="collapse"
							data-bs-target="#navbarSupportedContent"
							aria-controls="navbarSupportedContent" aria-expanded="false"
							aria-label="Toggle navigation">
							<span class="navbar-toggler-icon"></span>
						</button>
						<div class="collapse navbar-collapse" id="navbarSupportedContent">
							<ul class="navbar-nav me-auto mb-2 mb-lg-0">
								<li class="nav-item"><a class="nav-link active"
									aria-current="page" href="#">Home</a></li>
								<li class="nav-item dropdown"><a
									class="nav-link dropdown-toggle" href="#" role="button"
									data-bs-toggle="dropdown" aria-expanded="false"> 동호회 </a>
									<ul class="dropdown-menu">
										<li><a class="dropdown-item" href="/MAV/club/add">동호회
												생성</a></li>
										<li><hr class="dropdown-divider"></li>
										<li><a class="dropdown-item" href="/MAV/club/clubpage">동호회
												페이지</a></li>
									</ul></li>
								<li class="nav-item dropdown"><a
									class="nav-link dropdown-toggle" href="#" role="button"
									data-bs-toggle="dropdown" aria-expanded="false"> 매칭 </a>
									<ul class="dropdown-menu">
										<li><a class="dropdown-item" href="#">일반매칭</a></li>
										<li><hr class="dropdown-divider"></li>
										<li><a class="dropdown-item" href="#">토너먼트</a></li>
										<li><hr class="dropdown-divider"></li>
										<li><a class="dropdown-item" href="#">기타매칭</a></li>
									</ul></li>
								<li class="nav-item"><a class="nav-link active"
									aria-disabled="true" href="/MAV/logout">로그아웃</a></li>
								<li class="nav-item"><a class="nav-link active"
									aria-disabled="true" href="/MAV/member/mypage">마이페이지</a></li>
							</ul>
							<form class="d-flex" role="search">
								<input class="form-control me-2" type="search"
									placeholder="search" aria-label="Search">
								<button class="btn btn-outline-success" type="submit">search</button>
							</form>
						</div>
					</div>
				</nav>
			</c:otherwise>
		</c:choose>
	</div>
</body>
</html>
