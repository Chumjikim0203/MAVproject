<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style>
	.main-container
	{
		width : 70%;
		margin : 0 auto;
	}
</style>
<title>클럽 페이지</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
</head>
<body>
	<div class="main-container">
	  	<c:choose>
	    	<c:when test="${empty sessionScope.member}">
		        <nav class="navbar navbar-expand-lg bg-body-tertiary">
		            <div class="container-fluid">
		              <a class="navbar-brand" href="#">MAV</a>
		              <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
		                <span class="navbar-toggler-icon"></span>
		              </button>
		              <div class="collapse navbar-collapse" id="navbarSupportedContent">
		                <ul class="navbar-nav me-auto mb-2 mb-lg-0">
		                  <li class="nav-item">
		                    <a class="nav-link active" aria-current="page" href="#">Home</a>
		                  </li>
		                  <li class="nav-item">
		                    <a class="nav-link" href="/MAV/add/club">동호회</a>
		                  </li>
		                  <li class="nav-item dropdown">
		                    <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
		                      매칭
		                    </a>
		                    <ul class="dropdown-menu">
		                      <li><a class="dropdown-item" href="#">일반매칭</a></li>
		                      <li><a class="dropdown-item" href="#">토너먼트</a></li>
		                      <li><hr class="dropdown-divider"></li>
		                      <li><a class="dropdown-item" href="#">기타매칭</a></li>
		                    </ul>
		                  </li>
		                  <li class="nav-item">
		                    <a class="nav-link active" aria-disabled="true" href="/MAV/login">로그인</a>
		                  </li>
		                   <li class="nav-item">
		                    <a class="nav-link active" aria-disabled="true" href="/MAV/member/add/member">회원가입</a>
		                  </li>
		                </ul>
		                <form class="d-flex" role="search">
		                  <input class="form-control me-2" type="search" placeholder="search" aria-label="Search">
		                  <button class="btn btn-outline-success" type="submit">search</button>
		                </form>
		              </div>
		            </div>
		        </nav>
	        	</c:when>
	        	   <c:otherwise>
	       	    <nav class="navbar navbar-expand-lg bg-body-tertiary">
	            <div class="container-fluid">
	              <a class="navbar-brand" href="#">MAV</a>
	              <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
	                <span class="navbar-toggler-icon"></span>
	              </button>
	              <div class="collapse navbar-collapse" id="navbarSupportedContent">
	                <ul class="navbar-nav me-auto mb-2 mb-lg-0">
	                  <li class="nav-item">
	                    <a class="nav-link active" aria-current="page" href="#">Home</a>
	                  </li>
	                  <li class="nav-item dropdown">
	                    <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
	                      동호회
	                    </a>
	                    <ul class="dropdown-menu">
	                      <li><a class="dropdown-item" href="/MAV/club/add">동호회 생성</a></li>
	                      <li><hr class="dropdown-divider"></li>
	                      <li><a class="dropdown-item" href="/MAV/club/clubpage">동호회 페이지</a></li>
	                      <li><hr class="dropdown-divider"></li>
	                      <li><a class="dropdown-item" href="/MAV/club/list">동호회 리스트</a></li>
	                    </ul>
	                  </li>
	                  <li class="nav-item dropdown">
	                    <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
	                      매칭
	                    </a>
	                    <ul class="dropdown-menu">
	                      <li><a class="dropdown-item" href="#">일반매칭</a></li>
	                      <li><hr class="dropdown-divider"></li>
	                      <li><a class="dropdown-item" href="#">토너먼트</a></li>
	                      <li><hr class="dropdown-divider"></li>
	                      <li><a class="dropdown-item" href="#">기타매칭</a></li>
	                    </ul>
	                  </li>
	                  <li class="nav-item">
	                    <a class="nav-link active" aria-disabled="true" href="/MAV/logout">로그아웃</a>
	                  </li>
	                   <li class="nav-item">
	                    <a class="nav-link active" aria-disabled="true" href="/MAV/member/mypage">마이페이지</a>
	                  </li>
	                </ul>
	                <form class="d-flex" role="search">
	                  <input class="form-control me-2" type="search" placeholder="search" aria-label="Search">
	                  <button class="btn btn-outline-success" type="submit">search</button>
	                </form>
	              </div>
	            </div>
	        </nav>
	       </c:otherwise> 
		</c:choose>
		<h4> 클럽명 : ${club.clubName}</h4>
		<h4> 클럽 종류 : ${club.clubCategory}</h4>
		<h4> 클럽 지역 : ${club.clubLocale}</h4>
		<h4> 클럽 포인트 : ${club.clubPoint}</h4>
		<h4> 클럽 소개글 : ${club.clubInfo}</h4>
		<a href="/MAV/club/update">클럽 수정하기</a>
		<a href="/MAV/club/delete">클럽 삭제하기</a>
	</div>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm" crossorigin="anonymous" />
</body>
</html>