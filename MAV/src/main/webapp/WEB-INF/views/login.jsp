<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!doctype html>
<html lang="en">
  <head>
  	<style>
		.main-container
		{
			width: 70%;
			margin: 0 auto;
			background-color:rgba(240,240,240);
		}
		.navbar
		{
			margin-bottom: 50px;
		}
		.login-box {
		    background: white;
		    border-radius:15px;
		    text-align: center;
		    margin-bottom: 55px;
		    box-shadow: 0 3px 6px rgba(0, 0, 0, 0.16), 0 3px 6px rgba(0, 0, 0, 0.23);
		}
		
		.login-key {
		    height: 100px;
		    font-size: 80px;
		    line-height: 100px;
		    background: -webkit-linear-gradient(#27EF9F, #0DB8DE);
		    -webkit-background-clip: text;
		    -webkit-text-fill-color: transparent;
		}
		
		.login-title {
		    margin-top: 15px;
		    text-align: center;
		    font-size: 30px;
		    letter-spacing: 2px;
		    margin-top: 15px;
		    font-weight: bold;
		    color: black;
		}
		
		.login-form {
		    margin-top: 25px;
		    text-align: left;
		}
		
		input[type=text] {
		    background-color: white;
		    border: none;
		    border-bottom: 2px solid #0DB8DE;
		    border-top: 0px;
		    border-radius: 0px;
		    font-weight: bold;
		    outline: 0;
		    margin-bottom: 20px;
		    padding-left: 0px;
		    color: black;
		}
		
		input[type=password] {
		    background-color: white;
		    border: none;
		    border-bottom: 2px solid #0DB8DE;
		    border-top: 0px;
		    border-radius: 0px;
		    font-weight: bold;
		    outline: 0;
		    padding-left: 0px;
		    margin-bottom: 20px;
		    color: black;
		}
		
		.form-group {
		    margin-bottom: 40px;
		    outline: 0px;
		}
		
		.form-control:focus {
		    border-color: inherit;
		    -webkit-box-shadow: none;
		    box-shadow: none;
		    border-bottom: 2px solid #0DB8DE;
		    outline: 0;
		    background-color: #1A2226;
		    color: #ECF0F5;
		}
		
		input:focus {
		    outline: none;
		    box-shadow: 0 0 0;
		}
		
		label {
		    margin-bottom: 0px;
		}
		
		.form-control-label {
		    font-size: 10px;
		    color: #6C6C6C;
		    font-weight: bold;
		    letter-spacing: 1px;
		}
		
		.btn-outline-primary {
		    border-color: #0DB8DE;
		    color: #0DB8DE;
		    border-radius: 0px;
		    font-weight: bold;
		    letter-spacing: 1px;
		    box-shadow: 0 1px 3px rgba(0, 0, 0, 0.12), 0 1px 2px rgba(0, 0, 0, 0.24);
		}
		
		.btn-outline-primary:hover {
		    background-color: #0DB8DE;
		    right: 0px;
		}
		
		.login-btm {
		    margin: 0 auto;
		}
		
		.login-button {
		    padding-right: 0px;
		    text-align: center;
		    margin-bottom: 25px;
		}
		
		.login-text {
		    text-align: left;
		    padding-left: 0px;
		    color: #A2A4A4;
		}
		
		.loginbttm {
		    padding: 0px;
		}
  	</style>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>로그인</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
  </head>
  <body>
  	<div class="main-container mb-3">
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
                    <a class="nav-link active" aria-disabled="true" href="./login">로그인</a>
                  </li>
                   <li class="nav-item">
                    <a class="nav-link active" aria-disabled="true" href="./member/add/member">회원가입</a>
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
	        <div class="row">
	            <div class="col-lg-3 col-md-2"></div>
	            <div class="col-lg-6 col-md-8 login-box">
	                <div class="col-lg-12 login-key">
	                    <i class="fa fa-key" aria-hidden="true"></i>
	                </div>
	                <div class="col-lg-12 login-title">
	                    LOGIN
	                </div>
	
	                <div class="col-lg-12 login-form">
	                    <div class="col-lg-12 login-form">
	                        <form:form modelAttribute="member" action="./login" method="post">
	                            <div class="form-group">
	                                <label class="form-control-label"><h5>아이디</h5></label>
	                                <form:input type="text" class="form-control" path="memberId"/>
	                            </div>
	                            <div class="form-group">
	                                <label class="form-control-label"><h5>비밀번호</h5></label>
	                                <form:input type="password" class="form-control" path="memberPassword"/>
	                            </div>	
	                            <div class="col-lg-12 loginbttm">
	                                <div class="col-lg-6 login-btm login-text">
	                                    <!-- Error Message -->
	                                </div>
	                                <div class="col-lg-6 login-btm login-button">
	                                    <button type="submit" class="btn btn-outline-primary">로그인</button>
	                                </div>
	                            </div>
	                        </form:form>
	                    </div>
	                </div>
	                <div class="col-lg-3 col-md-2"></div>
	            </div>
	        </div>
		</div>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm" crossorigin="anonymous"></script>
  </body>
</html>