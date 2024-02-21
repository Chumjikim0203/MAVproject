<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%> 
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
     <%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
     
<!doctype html>
<html lang="utf-8">
  <head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Bootstrap demo</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
    <style>
.col-4{
    margin-right: auto;
}
.card{
   

}
.main{
    width: 70%;
    margin: 0 auto;
    display: flex;
}
.img1{
 border-radius: 50%;
 width: 50%;

 margin: 0 auto;
}
.right{
    display: flex;
}
.right-name{
    display: flex;
}
.card-1{
    display: flex;
    justify-content: space-between;
}

    </style>
</head>
  <br><br>
  <body>
   강의등록완료
  
	<c:forEach var="allclasses" items="${allclass}">
    <div>
        <p>강의번호 ID: ${allclasses.classNum}</p>
        <p>강의명 Name: ${allclasses.className}</p>
        <p>시간 : ${allclasses.classLecturetime}</p>

        <p>수강 인원: ${allclasses.classNumberOfStudents}</p>
        <p> 등급: ${allclasses.classGrade}</p>
        <p>지역: ${allclasses.classLocale}</p>
        <a href="<c:url value='/teacher/updateclass'/>?classNum=${allclasses.classNum}">수정</a>
        <a href="<c:url value='/teacher/deleteclass'/>?classNum=${allclasses.classNum}">삭제</a>
    	<a href="<c:url value='/teacher/detailclass'/>?classNum=${allclasses.classNum}">상세정보</a>
    </div>
</c:forEach>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm" crossorigin="anonymous"></script>
</body>
</html>

