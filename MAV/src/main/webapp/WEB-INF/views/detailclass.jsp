<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>상세 페이지</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
    <style>
        .carousel-inner img {
            width: 100%;
            height: 65vh;
            object-fit: cover;
        }
        .container {
            width: 80%;  
            margin: 0 auto;
        }
        .detail-box {
            padding: 1rem;
            margin-bottom: 2rem;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            border-radius: 10px;
            background-color: white;
        }
        .detail-row {
            display: flex;
            justify-content: space-between;
            flex-wrap: wrap;
        }
        .detail-left {
            width: 70%;
        }
        .detail-left .detail-box {
            width: 100%;
            margin-bottom: 1rem;
        }
        .detail-right {
            width: 28%;
        }
    </style>
</head>
<body>
    <nav class="navbar navbar-expand-lg navbar-light bg-light container">
        <a class="navbar-brand" href="#">Logo</a>
    </nav>

    <div id="carouselExampleIndicators" class="carousel slide container" data-bs-ride="carousel">
        <div class="carousel-inner">
            <div class="carousel-item active">
                <img src="https://static.nike.com/a/images/w_1920,c_limit,f_auto,q_auto/918325cf-fc65-4f3a-8d61-89495fc985d2/image.png" class="d-block w-100" alt="첫 번째 슬라이드">
            </div>
          <div class="carousel-item active">
            <img src="https://static.nike.com/a/images/w_1920,c_limit,f_auto,q_auto/918325cf-fc65-4f3a-8d61-89495fc985d2/image.png" class="d-block w-100" alt="첫 번째 슬라이드">
          </div>
          <div class="carousel-item active">
            <img src="https://static.nike.com/a/images/w_1920,c_limit,f_auto,q_auto/918325cf-fc65-4f3a-8d61-89495fc985d2/image.png" class="d-block w-100" alt="첫 번째 슬라이드">
          </div>
        </div>
        <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide="prev">
          <span class="carousel-control-prev-icon" aria-hidden="true"></span>
          <span class="visually-hidden">Previous</span>
        </button>
        <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide="next">
          <span class="carousel-control-next-icon" aria-hidden="true"></span>
          <span class="visually-hidden">Next</span>
        </button>
    </div>
    <br>
    <div class="container">
        <div class="detail-row d-flex">
            <div class="detail-left">
                <div class="detail-box">
                    <h1>상세 정보 제목</h1>
                    <p>${detailclass.className} </p>
                </div>
                <div class="detail-box">
                    <h2>상세 정보 내용</h2>
                    <pre>${detailclass.classIntroduction}<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br></pre>
                </div>
            </div>
            <div class="detail-box detail-right" style="height: 810px;">
                <h2>강의 정보</h2>
                <button type="button" class="btn btn-primary mt-2">수정</button>
                <a href="/MAV/Class" class="btn btn-primary mt-2">강의신청하기</a>
                <br><br><br><br><br><br><br>
                <h2>지도 정보</h2>
                <input type="text" class="form-control" placeholder="추가 정보 입력">
                <button type="button" class="btn btn-primary mt-2">추가</button>
            
            </div>
        
        </div>
    </div>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm" crossorigin="anonymous"></script>
</body>
</html>