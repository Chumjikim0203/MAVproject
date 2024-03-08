<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
  <link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@400;500;700&display=swap" rel="stylesheet">
    <style>
        * 
        {
            font-family: 'Noto Sans KR', sans-serif;
        }
        .main-container
        {
            width: 70%;
            margin: 0 auto;
        }
        .container
        {
            margin-top: 20px;
        }
        textarea 
        {
		    white-space: pre-line; /* 줄바꿈 유지 */
		    overflow-wrap: break-word; /* 긴 단어 줄 바꿈 */
		    word-wrap: break-word; /* 긴 단어 줄 바꿈 */
		    border: none; /* 테두리 제거 */
		    resize: none; /* 크기 조정 비활성화 */
		    outline: none; /* 외곽선 제거 */
		}
        
    </style>
    <script>
		function goBack() 
		{
		    window.history.back();
		}
		window.onload = function() {
		    var textarea = document.getElementsByName('clubInfo')[0];
		    textarea.innerHTML = textarea.innerHTML.replace(/\n/g, '<br>');
		};
	</script>
 <title>동호회 생성</title>
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
                    <a class="nav-link" href="#">동호회</a>
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
                    <a class="nav-link active" aria-disabled="true" href="../add/member">회원가입</a>
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
                  <li class="nav-item">
                    <a class="nav-link" href="#">동호회</a>
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
                    <a class="nav-link active" aria-disabled="true" href="../logout">로그아웃</a>
                  </li>
                   <li class="nav-item">
                    <a class="nav-link active" aria-disabled="true" href="../member/mypage">마이페이지</a>
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
       <div class="container">
           <div class="input-form-backgroud row">
               <div class="input-form col-md-12 mx-auto">
                   <h4 class="mb-3">동호회 생성</h4>
                   <form:form modelAttribute="club" class="form-horizontal" action="/MAV/club/update?clubNum=${club.clubNum}" method="post" enctype="multipart/form-data">
					<fieldset>
				 	<div class="row">
                        <div class="col-md-7 mb-3">
                       		<label for="clubName">동호회 이름</label>
                         	<form:input path="clubName" class="form-control" />                          
                       	</div>
                        <div class="invalid-feedback">
                            동호회 이름을 입력해주세요.
                        </div>                    
                      	<div class="col-md-6 mb-3">
                            <label for="clubLocale">활동 지역</label>
                            <form:select class="form-select" aria-label="Default select example" path="clubLocale" value="${club.clubLocale}">
                            	<form:options items="${localeOptions}"/>
                            </form:select>
                        </div>
                        <div class="invalid-feedback">
                            지역을 입력해주세요.
                        </div>                 
                        <div class="col-md-6 mb-3">
                            <label for="clubCategory">활동 종류</label>
                            <form:select class="form-select" aria-label="Default select example" path="clubCategory">
                                <form:options items="${categoryOptions}"/>
                            </form:select>
                        </div>
                        <div class="col-md-7 mb-3">
                       		<label for="clubImages">동호회 이미지</label>
                         	<form:input type="file" path="clubImages" class="form-control" value="${club.imageFileName}"/>                          
                       	</div>                                            
                        <div class="col-md-12 mb-3">
                            <label for="clubInfo">동호회 소개글</label>
                            <form:textarea class="form-control" path="clubInfo" />                        
                        </div>
                	</div>
                	<br>
                    <hr class="mb-4">
                    <div class="mb-4"></div>	
                   	<input class="btn btn-primary btn-lg btn-block" type="submit" value="수정 완료"/>
                   	<input class="btn btn-danger btn-lg btn-block" type="button" value="취소 하기" onclick="goBack()"/>				
				</fieldset>
				</form:form>
               </div>
           </div>
       </div>
   </div>
   <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm" crossorigin="anonymous"></script>
 </body>
</html>