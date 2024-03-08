<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
        }tyle>
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
    <script>
		function goBack() 
		{
		    window.history.back();
		}
	</script>
  </head>
  <body>
    <div class="main-container">
        <jsp:include page="./section/nav.jsp" />
        <div class="container">
            <div class="input-form-backgroud row">
                <div class="input-form col-md-12 mx-auto">
                    <h4 class="mb-3">회원 정보 수정</h4>
                    <form:form modelAttribute="member" class="form-horizontal" action="/MAV/member/update/member" method="post">
						<fieldset>
					 	<div class="row">
	                      	<div class="col-md-6 mb-3">
	                       		<label for="memberId">아이디</label>
	                         	<form:input path="memberId" class="form-control" value="${member.memberId}" />                          
	                       	</div>
                            <div class="invalid-feedback">
                                아이디를 입력해주세요.
                            </div>
	                        <div class="col-md-6 mb-3">
	                            <label for="memberPassword">비밀번호</label>
	                            <form:password class="form-control" path="memberPassword" value="${member.memberPassword}"/>
	                        </div>
                            <div class="invalid-feedback">
                                비밀번호를 입력해주세요.
                            </div>
	                        <div class="col-md-6 mb-3">
	                           	<label for="memberBirth">생년월일</label>
	                           	<form:input type="date" class="form-control" path="memberBirth" value="${member.memberBirth}" />
	                       	</div>
                            <div class="invalid-feedback">
                                생년월일을 입력해주세요.
                            </div>
	                        <div class="col-md-2 mb-3">
	                            <label for="memberPhone01">휴대폰</label>
	                            <form:select class="form-select" aria-label="Default select example" path="memberPhone01" value="${member.memberPhone01}">
	                                <form:options items="${phone01Options}"/>
	                            </form:select>
	                        </div>
	                        <div class="col-md-2 mb-3">
	                            <label for="memberPhone02"></label>
	                            <form:input class="form-control" path="memberPhone02" value="${member.memberPhone02}"/>
	                        </div>
	                        <div class="col-md-2 mb-3">
	                            <label for="memberPhone03"></label>
	                            <form:input class="form-control" path="memberPhone03" value="${member.memberPhone02}"/>
	                        </div>
                            <div class="invalid-feedback">
                                휴대폰번호를 입력해주세요.
                            </div>
	                        <div class="col-md-6 mb-3">
	                            <label for="memberGender">성별</label>
	                            <form:select class="form-select" aria-label="Default select example" path="memberGender" value="${member.memberGender}">
	                             	<form:options items="${genderOptions}"/>
	                            </form:select>
	                        </div>
                            <div class="invalid-feedback">
                                성별을 입력해주세요.
                            </div>
	                        <div class="col-md-6 mb-3">
	                            <label for="memberName">이름</label>
	                            <form:input class="form-control" path="memberName" value="${member.memberName}"/>                        
	                        </div>
                            <div class="invalid-feedback">
                                이름을 입력해주세요.
                            </div>                        
                    	</div>
	                    <div class="mb-3">
	                        <label for="memberEmail">이메일</label>
	                        <form:input  class="form-control" path="memberEmail" value="${member.memberEmail}"/>
	                    </div>
                        <div class="invalid-feedback">
                            이메일을 입력해주세요.
                        </div>
	                    <div class="mb-3">
	                        <label for="memberAddr">주소</label>
	                        <form:input class="form-control" path="memberAddr" value="${member.memberAddr}"/>                  
	                    </div>
                        <div class="invalid-feedback">
                            주소를 입력해주세요.
                        </div>
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