<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>매칭 상세 페이지</title>
    <script src="https://kit.fontawesome.com/1a6288a620.js" crossorigin="anonymous"></script>
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
            flex-direction: row;        }
        .detail-left {
            width: 70%;
        }
        .detail-left .detail-box {
            width: 100%;
            margin-bottom: 1rem;
        }
        .detail-right {
            width: 28%;
            flex-direction: column;
            display: flex;

        }

        .additional-info-box {
            padding: 1rem;
            margin-bottom: 2rem;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            border-radius: 10px;
            background-color: white;
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
                <img src="https://static.nike.com/a/images/w_1920,c_limit,f_auto,q_auto/17b0c9a1-66b7-47f7-af08-84dbcce9acda/image.png" class="d-block w-100" alt="첫 번째 슬라이드">
            </div>
          <div class="carousel-item active">
            <img src="https://static.nike.com/a/images/t_PDP_1728_v1/f_auto,q_auto:eco/cdef252c-ee93-4047-b52b-c8f0cb13e841/%EC%8A%A4%EC%9A%B0%EC%8B%9C-%EC%97%AC%EC%84%B1-%EB%93%9C%EB%9D%BC%EC%9D%B4-%ED%95%8F-%EC%BF%BC%ED%84%B0%EC%A7%91-%EB%AF%B8%EB%93%9C-%EB%A0%88%EC%9D%B4%EC%96%B4-4O4ifntv.png" class="d-block w-100" alt="첫 번째 슬라이드">
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
                    <h1>${room.roomName}</h1>
                    <p>참가인원 :${room.roomCount}&nbsp;&nbsp;&nbsp;&nbsp;수용인원 :${room.roomCapacity}</p>
                </div>
                <div class="detail-box">
                    <h2>상세내용</h2>
                   <pre>${room.roomDetail}</pre>
                </div>
            </div>
            <div class="detail-right">
                <div class="detail-box"style="height: 25rem;">
                    <b><p>MatchDate :<b>
                    <h5>${room.roomDate}<br>${room.roomTime}</h5>
                   
                    <b><p>방제 : ${matching.matchTitle}<b>
                    <p>동호회명 : ${matching.creatorId}
                    <p>동호회 점수 : ${matching.creatorId}
                    <p>동호회 정보 : ${matching.creatorId}                  
                    <a href="#">상세정보</a>
                    
					<form:form modelAttribute="matching" action="${pageContext.request.contextPath}/match/matchingApply" method="post" onsubmit="return checkIds()">
					    <div id="matching_bt">
					        <form:hidden path="roomNum" value="${room.roomNum}" />
					        <form:hidden path="creatorId" value="${matching.creatorId}" />
					        
					        <!-- 추가적인 데이터 필드들을 여기에 추가 -->
					        <button type="submit" class="btn btn-danger mt-2">매칭신청하기</button>
					    </div>
					</form:form>
                </div>
                <div class="detail-box additional-info-box" style="height: 30rem;">
                    <div id="googleMapContainer">
                        <iframe id="googleMap" src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3258.9865696752536!2d128.58126887497116!3d35.231704354538195!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x356f32161a07d2b5%3A0xd8e276b01df1f6e4!2z7JWE7J207Yuw7JeQ65OA64S37ZWZ7JuQ!5e0!3m2!1sko!2skr!4v1708005623123!5m2!1sko!2skr" width="100%" height="450" style="border:0;" allowfullscreen="" loading="lazy" referrerpolicy="no-referrer-when-downgrade"></iframe>
                    </div>                
                </div>

            </div>
        </div>
    </div>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm" crossorigin="anonymous"></script>
</body>
	<script>
	
	function checkIds() {
	    var creatorId = document.querySelector('[name="creatorId"]').value;
	    var applicantId = "${member.memberId}";
	
	    if (creatorId === applicantId) {
	        alert("방장의 아이디와 동일한 아이디로 신청할 수 없습니다.");
	        return false;
	    }
	
	    return true;
	}
	</script>
</html>