<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="java.time.LocalDate" %>

<!DOCTYPE html>
<html lang="ko">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>공지사항</title>

	<script src="https://kit.fontawesome.com/1a6288a620.js" crossorigin="anonymous"></script>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">

    <style>
        body {
            width: 70vw;
            margin: 0 auto;
        }

        .input-form-backgroud {
            background-color: #f8f9fa;
            padding: 20px;
            margin-top: 30px;
            border-radius: 10px;
        }

        .input-form {
            background-color: #ffffff;
            padding: 30px;
            border-radius: 10px;
        }

        .form-control {
            margin-bottom: 15px;
        }

        .mb-4 {
            margin-bottom: 4rem;
        }

        .validation-form {
            position: relative;
        }

        .invalid-feedback {
            display: none;
            color: #dc3545;
        }

        .btn-primary {
            background-color: #007bff;
            border-color: #007bff;
        }

        .btn-primary:hover {
            background-color: #0056b3;
            border-color: #0056b3;
        }

        .bonmun{
            border-radius: 1rem;
            border: 1px solid rgb(213, 239, 248);
            height: 50vw;
        }
        
        table{
        	margin: 0 auto;
        	width: 60vw !important;
        }
    </style>
</head>
<body>
<br><br><br>
<jsp:include page="./section/nav.jsp" />
<div class="container">
    <div class="input-form-backgroud row">
        <div class="input-form col-md-12 mx-auto">
            <h3 class="mb-4"><b>${detailNotice.noticeTitle}</h4>               
                <div class="bonmun">
                	<p><pre>${detailNotice.noticeContents}</pre></p>
                </div> 
            </form>
        </div>
    </div>
</div>
<br><br>
   <table class="table ">
            <tr>
                <th scope="coltitle" colspan="5" class="text-center" >제목</th>           
            </tr>
            <tr >
                <td ><i class="fa-solid fa-angle-up"  class="col-"></i><span>  다음글</span></td>
                <td colspan="3"><a
                    href="<c:url value='/notice/noticeDetail'/>?noticeNum=${notices.noticeNum}"
                    class="text-dark" >${notices.noticeTitle}</a></td>
                <td  colspan="1" class="table_body">${notices.noticeDate}</td>
            </tr>
            <tr >
                <td ><i class="fa-solid fa-angle-down"></i><span>  이전글</span></td>
                <td colspan="3"><a
                    href="<c:url value='/notice/noticeDetail'/>?noticeNum=${notices.noticeNum}"
                    class="text-dark" >${notices.noticeTitle}</a></td>
                <td  colspan="1" class="table_body">${notices.noticeDate}</td>
            </tr>
    </table>

    <div class="row">
        <div class="col-md-10 row "> 
        </div>
        <br>
        <a href="./list" class=" col-md-2 text-center ">전체보기</a>                
    </div>
    
</html>
