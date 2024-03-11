<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
  <%@ page import="java.time.LocalDate" %>
<!DOCTYPE html>
<html>

<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>강의등록 - Bootstrap</title>

  <!-- Bootstrap CSS -->
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
  <link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@400;500;700&display=swap" rel="stylesheet">
    <style>
        * 
        {
            font-family: 'Noto Sans KR', sans-serif;
        }


    .container{
     width: 80%;
     margin: 0 auto;
     margin-top : 20px;
    }
  </style>
</head>

<body>
<jsp:include page="./section/nav.jsp"/>
  <div class="container">
    <div class="input-form-backgroud row">
      <div class="input-form col-md-12 mx-auto">
        <h4 class="mb-3">강의등록</h4>
                  
        <form:form modelAttribute="classes" class="validation-form"  method="post" action="./addclass">
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>  
        <div class="row">
                <div class="col-md-6 mb-3">
                    <label for="className">강의명</label>
                    <form:input path="className" class="form-control"  />
                </div>
       </div>
            <div class="row">
                <div class="col-md-6 mb-3">
                    <label for="classLecturedate">강의날짜</label>
                    <form:hidden class="form-control" path="teacherId" value="${teacher.teacherId}"/>
        
                    <form:input type="date" class="form-control" path="classLecturedate" min="<%= LocalDate.now() %>"  />
					<div class="invalid-feedback">
                    	강의날짜를 선택해주세요.
               		</div>
                </div>

                <div class="col-md-6 mb-3">
                    <label for="classLecturetime">강의시간</label>
                   	<form:input type="time" class="form-control" path="classLecturetime" />
					<div class="invalid-feedback">
                    	강의시간를 선택해주세요.
               		</div>
                </div>
            </div>
            <div class="row">
                <div class="col-md-6 mb-3">
                    <label for="classNumberOfStudents">강의수강인원</label>
                    <form:input class="form-control" path="classNumberOfStudents"   />
                    <div class="invalid-feedback">
                    강의수강인원을 입력해주세요
                    </div>
                </div>
                <div class="col-md-6 mb-3">
                    <label for="classGrade">강의 등급</label>
                   <form:input  class="form-control" path="classGrade"  />
                    <div class="invalid-feedback">
                    강의 등급을 입력해주세요.
                    </div>
                </div>
            </div>
            <div class="row">
                <div class=" col-md-6 mb-3">
                    <label for="classCourseContents">수강 내용</label>
                    <form:input   class="form-control" path="classCourseContents"  />
                    <div class="invalid-feedback">
                    수강내용을 입력해주세요.
                    </div>
                </div>
                <div class="col-md-6 mb-3">
                    <label for="classLocale" class="form-label">강의 지역</label>
                   <form:input  class="form-control"  path="classLocale"/>
                </div>
            </div>
             <div class="row">
                <div class="col-md-6 mb-3">
                    <label for="classImages" class="form-label">강의 이미지</label>
                    <form:input class="form-control" type="file" path="classImages"/>
                </div>
           	</div>  

          <div class="mb-3">
            <label for="classIntroduction">강의소개<span class="text-muted">&nbsp;(필수 아님)</span></label>
           <form:textarea cols="50" rows="2" class="form-control" path="classIntroduction" />
            </div>

          <div class="mb-4"></div>
             <input class="" type="submit" value="강의등록하기"/>
        </form:form>
      </div>
    </div>

  </div>
  <script>
    window.addEventListener('load', () => {
      const forms = document.getElementsByClassName('validation-form');

      Array.prototype.filter.call(forms, (form) => {
        form.addEventListener('submit', function (event) {
          if (form.checkValidity() === false) {
            event.preventDefault();
            event.stopPropagation();
          }

          form.classList.add('was-validated');
        }, false);

  </script>
</body>

</html>