<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
    <style>
        .main-container
        {
            width: 70%;
            margin: 0 auto;
        }
        .container
        {
            margin-top: 20px;
        }
    </style>
  </head>
  <body>
    <div class="main-container">
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
                    <a class="nav-link active" aria-disabled="true" href="../login">로그인</a>
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
        <div class="container">
            <div class="input-form-backgroud row">
                <div class="input-form col-md-12 mx-auto">
                    <h4 class="mb-3">회원가입</h4>
                    <form:form modelAttribute="member" class="form-horizontal" action="../add/member" method="post">
						<fieldset>
					 	<div class="row">
	                      	<div class="col-md-6 mb-3">
	                       		<label for="memberId">아이디</label>
	                         	<form:input path="memberId" class="form-control" />                          
	                       	</div>
                            <div class="invalid-feedback">
                                아이디를 입력해주세요.
                            </div>
	                        <div class="col-md-6 mb-3">
	                            <label for="memberPassword">비밀번호</label>
	                            <form:password class="form-control" path="memberPassword"/>
	                        </div>
                            <div class="invalid-feedback">
                                비밀번호를 입력해주세요.
                            </div>
	                        <div class="col-md-6 mb-3">
	                           	<label for="memberBirth">생년월일</label>
	                           	<form:input type="date" class="form-control" path="memberBirth" />
	                       	</div>
                            <div class="invalid-feedback">
                                생년월일을 입력해주세요.
                            </div>
	                        <div class="col-md-2 mb-3">
	                            <label for="memberPhone01">휴대폰</label>
	                            <form:select class="form-select" aria-label="Default select example" path="memberPhone01">
	                                <form:options items="${phone01Options}"/>
	                            </form:select>
	                        </div>
	                        <div class="col-md-2 mb-3">
	                            <label for="memberPhone02"></label>
	                            <form:input class="form-control" path="memberPhone02"/>
	                        </div>
	                        <div class="col-md-2 mb-3">
	                            <label for="memberPhone03"></label>
	                            <form:input class="form-control" path="memberPhone03" />
	                        </div>
                            <div class="invalid-feedback">
                                휴대폰번호를 입력해주세요.
                            </div>
	                        <div class="col-md-6 mb-3">
	                            <label for="memberGender">성별</label>
	                            <form:select class="form-select" aria-label="Default select example" path="memberGender">
	                             	<form:options items="${genderOptions}"/>
	                            </form:select>
	                        </div>
                            <div class="invalid-feedback">
                                성별을 입력해주세요.
                            </div>
	                        <div class="col-md-6 mb-3">
	                            <label for="memberName">이름</label>
	                            <form:input class="form-control" path="memberName" />                        
	                        </div>
                            <div class="invalid-feedback">
                                이름을 입력해주세요.
                            </div>                        
                    	</div>
	                    <div class="mb-3">
	                        <label for="memberEmail">이메일</label>
	                        <form:input  class="form-control" path="memberEmail" />
	                    </div>
                        <div class="invalid-feedback">
                            이메일을 입력해주세요.
                        </div>
	                    <div class="mb-3">
	                        <label for="memberAddr">주소</label>
	                        <form:input class="form-control" path="memberAddr" />                  
	                    </div>
                        <div class="invalid-feedback">
                            주소를 입력해주세요.
                        </div>
	                    <hr class="mb-4">
	                    <div class="mb-4"></div>	
                    	<input class="btn btn-primary btn-lg btn-block" type="submit" value="가입 완료"/>				
					</fieldset>
					</form:form>
                </div>
            </div>
        </div>
    </div>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm" crossorigin="anonymous"></script>
  </body>
</html>