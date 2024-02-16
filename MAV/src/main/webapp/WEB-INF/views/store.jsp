<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="utf-8">

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>업체 마이페이지</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
    <style>
        body {
            font-family: 'Noto Sans KR', sans-serif;
            background-color: #f8f9fa;
            color: #212529;
        }

        .main {
            width: 80%;
            margin: 0 auto;
            display: flex;
            padding: 2rem;
        }

        .col-4 {
            margin-right: auto;
        }

        .card {
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
            background-color: #fff;
            border: none;
        }


        .img1 {
            border-radius: 50%;
            width: 50%;
            margin: 0 auto;
        }

        .right, .right-name {
            display: flex;
        }

        .right img {
            width: 30%;
        }

        .card-title, .card-text {
            margin: 0;
        }

        .list-group-item a {
            text-decoration: none;
            color: #212529;
        }

        .list-group-item:hover {
            background-color: #f8f9fa;
        }

        .card-link {
            color: #007bff;
            text-decoration: none;
        }

        .card-link:hover {
            text-decoration: underline;
        }

        .card h5 {
            font-size: 1.2rem;
            margin-bottom: 1rem;
        }

        .card-1 {
            display: flex;
            flex-direction: column;
            justify-content: space-between;
            padding: 0.5rem;
            margin-bottom: 1.5rem;
            border: 1px solid #dee2e6;
            border-radius: 0.25rem;
            background-color: #fff;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
        }

        h1 {
            font-size: 2rem;
            margin-bottom: 1.5rem;
            color: #007bff;
        }

        a {
            color: #007bff;
            text-decoration: none;
        }

        a:hover {
            text-decoration: underline;
        }

        .room-title {
            font-size: 1.2rem;
            margin-bottom: 1rem;
            color: #343a40;
        }

        .room-application-btn {
            padding: 0.5rem 1rem;
            background-color: #007bff;
            color: white;
            border-radius: 0.25rem;
            text-decoration: none;
        }

        .room-info {
            display: flex;
            justify-content: space-between;
            align-items: center;
            font-size: 1rem;
        }
    </style>
</head>

<body>
    <div class="main">
        <div class="col-4">
            <div class="card" style="width: 100%;">
                <h5 class="card-title" style="text-align: center; font-size: 1.5rem;">업주</h5>
                <img src="." class="card-img-top img1" alt="...">
                <div class="card-body">
                    <p class="card-text" style="text-align: center; font-size: 1.2rem;">김태영사무소</p>
                    <p class="card-text" style="text-align: center; font-size: 1rem;">123@123.com</p>
                </div>
                <ul class="list-group list-group-flush">
                    <li class="list-group-item">
                        <a href="#">토너먼트등록</a>
                    </li>
                    <li class="list-group-item">
                        <a href="./store/addrooms">경기장만들기</a>
                    </li>
                    <li class="list-group-item">
                        <a href="#">업주탈퇴</a>
                    </li>
                </ul>
                <div class="card-body">
                    <a href="#" class="card-link">정보수정</a>
                </div>
            </div>
        </div>
        <div class="col-7">
            <div class="card">
                <h5>개인정보</h5>
                <div class="right">
                    <img src=".." class="" width="30%">
                    <div class="right-name">
                        <p>업주명</p>
                        <p>123@gmail.com</p>
                    </div>
                </div>
                <hr>
            </div>
            <br>
            <div>
                <div class="room-title">경기장관리</div>
                <c:forEach items="${myRooms}" var="room">
                    <div class="card-1 mb-3">
                        <div class="room-info">
                            <span class="room-title">&nbsp;&nbsp;${room.roomNum} - ${room.roomName}</span>
                            <span class="room-date">날짜 :${room.roomDate}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;시간 : ${room.roomTime}</span>
                            <span class="room-application">
                                <span class="room-application-count">0/1</span>
        						<a href="<c:url value='/store/roomsDetail'/>?roomNum=${room.roomNum}" class="room-application-link room-application-btn">조회</a>   
        						<a href="<c:url value='/store/roomsUpdate'/>?roomNum=${room.roomNum}" class="room-application-link room-application-btn">수정</a>   
        						<a href="<c:url value='/store/deleteMyRoom'/>?roomNum=${room.roomNum}" class="room-application-link room-application-btn">삭제</a>   
                            </span>
                        </div>
                    </div>
                </c:forEach>
            </div>
            <div>
                <div class="room-title">토너먼트 관리</div>
                <c:forEach items="${myRooms}" var="room">
                    <div class="card-1 mb-3">
                        <div class="room-info">
                            <span class="room-title">&nbsp;&nbsp;${room.roomNum} - ${room.roomName}</span>
                            <span class="room-date">날짜 :${room.roomDate}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;시간 : ${room.roomTime}</span>
                            <span class="room-application">
                                <span class="room-application-count">0/1</span>
                                <a href="#" class="room-application-link room-application-btn">상세보기</a>
                                <a href="#" class="room-application-link room-application-btn">수정</a>
                                <a href="#" class="room-application-link room-application-btn">삭제</a>
                            </span>
                        </div>
                    </div>
                </c:forEach>
            </div>
        </div>
    </div>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm"
        crossorigin="anonymous"></script>
</body>

</html>
