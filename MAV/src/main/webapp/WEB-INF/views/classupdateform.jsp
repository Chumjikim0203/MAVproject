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
        }
        .main-container
        {
            width: 80%;
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
  <jsp:include page="./section/nav.jsp"/>
    <div class="main-container">
       <div class="container">
            <div class="input-form-backgroud row">
                <div class="input-form col-md-12 mx-auto">
                    <h4 class="mb-3"> 수정</h4>
                    <form:form modelAttribute="classes" class="form-horizontal" action="/MAV/Class/updateclass" method="post">
                     <form:hidden path="classNum" value="${classes.classNum}"/> 

                  <fieldset>
                           <div class="row">
                				<div class="col-md-6 mb-3">
                    				<label for="className">강의명</label>
                    				<form:input path="className" class="form-control" value="${classes.className}"/>
                    				<form:hidden  class="form-control"  path="teacherId" value="${member.memberId}" />
               					 </div>
       						</div>
                            <div class="invalid-feedback">
                                강의명을 입력해주세요
                            </div>
                           <div class="row">
				                <div class="col-md-6 mb-3">
				                    <label for="classLecturedate">강의날짜</label>
				                    <form:input type="date" class="form-control" path="classLecturedate" value="${classes.classLecturedate}" />
									<div class="invalid-feedback">
				                    	강의날짜를 선택해주세요.
				               		</div>
				                </div>
				
				                <div class="col-md-6 mb-3">
				                    <label for="classLecturetime">강의시간</label>
				                   	<form:input type="time" class="form-control" path="classLecturetime" value="${classes.classLecturetime}" />
									<div class="invalid-feedback">
				                    	강의시간를 선택해주세요.
				               		</div>
				                </div>
				            </div>

                  <%--          <div class="col-md-2 mb-3">
                               <label for="className">휴대폰</label>
                               <form:select class="form-select" aria-label="Default select example" path="className">
                                   <form:options items="${phone01Options}"/>
                               </form:select>
                           </div> --%>

                         <%--   <div class="col-md-6 mb-3">
                               <label for="className">성별</label>
                               <form:select class="form-select" aria-label="Default select example" path="className">
                                   <form:options items="${genderOptions}"/>
                               </form:select>
                           </div> --%>
					<div class="row">
	                	<div class="col-md-6 mb-3">
	                    	<label for="classNumberOfStudents">강의수강인원</label>
	                    	<form:input class="form-control" path="classNumberOfStudents"  value="${classes.classNumberOfStudents}"  />
	                    	<div class="invalid-feedback">
	                    	강의수강인원을 입력해주세요
	                    	</div>
	                	</div>
                		<div class="col-md-6 mb-3">
                    		<label for="classGrade">강의 등급</label>
                   			<form:input  class="form-control" path="classGrade"  value="${classes.classGrade}" />
                   			 <div class="invalid-feedback">
                    			강의 등급을 입력해주세요.
                    		</div>
                		</div>
            		</div>                       
                       
                       <div class="row">
                			<div class=" col-md-6 mb-3">
			                    <label for="classCourseContents">수강 내용</label>
			                    <form:input   class="form-control" path="classCourseContents"  value="${classes.classCourseContents}" />
			                    <div class="invalid-feedback">
			                    수강내용을 입력해주세요.
			                    </div>
			                </div>
			                <div class="col-md-6 mb-3">
			                    <label for="classLocale" class="form-label">강의 지역</label>
			                   <form:input  class="form-control"  path="classLocale"  value="${classes.classLocale}"/>
			                </div>
			            </div>
                   		   <div class="mb-3">
				            <label for="classIntroduction">강의소개<span class="text-muted">&nbsp;(필수 아님)</span></label>
				            <form:textarea class="form-control" path="classIntroduction" cols="50" row="2"  value="${classes.classIntroduction}"/>
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