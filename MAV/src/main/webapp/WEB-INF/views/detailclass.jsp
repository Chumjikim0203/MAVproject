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
    <link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@400;500;700&display=swap" rel="stylesheet">
    <style>
        * 
        {
            font-family: 'Noto Sans KR', sans-serif;
        }
        .carousel-inner
        {
           margin-top : 20px;
           margin-bottom : 20px;
           width : 100%
        }
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
<jsp:include page="./section/nav.jsp"/>
    <div class="container">
       <div id="carouselExampleIndicators" class="carousel slide" data-bs-ride="carousel">
           <div class="carousel-inner">
			    <div class="carousel-item active">
			        <img src="/MAV/resources/images/${detailclass.classImagesFileName1}" class="d-block w-100" alt="첫 번째 슬라이드">
			    </div>
			    <div class="carousel-item active">
			        <img src="/MAV/resources/images/${detailclass.classImagesFileName2}" class="d-block w-100" alt="첫 번째 슬라이드" >
			    </div>
			    <div class="carousel-item active">
			        <img src="/MAV/resources/images/${detailclass.classImagesFileName4}" class="d-block w-100" alt="첫 번째 슬라이드">
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
        <div class="detail-row d-flex">
            <div class="detail-left">
                <div class="detail-box">
                    <h1>상세 정보 제목</h1>
                    <p>${detailclass.className} </p>
                </div>
                <div class="detail-box">
                    <h2>상세 정보 내용</h2>
                    <pre>${detailclass.classIntroduction}</pre>
                </div>
            </div>
            <div class="detail-box detail-right" style="height: 810px;">
                <h2>강의 정보</h2>
                <c:choose>
                   <c:when test="${member.memberId eq detailclass.classId}">
                      <a href="/MAV/Class/updateclass?classNum=${detailclass.classNum}" class="btn btn-primary mt-2">수정</a>
                   </c:when>
                </c:choose>
               <!-- 강의 신청하기 버튼 -->            
            <a href="/MAV/Class/addmember?classNum=${detailclass.classNum}" class="btn btn-primary mt-2">강의신청하기</a>
                 <button type="button" class="btn btn-primary mt-2" data-bs-toggle="modal" data-bs-target="#exampleModal">
                  ${detailclass.className} 수강생 목록
              </button>
                <br><br>
  
                       <!-- 모달  -->

    
       <div class="card-1 mb-3">
           <!-- 강의 정보 -->
          
           <!-- 수강생 목록 버튼 -->
         
   
           <div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-header">
                           
                            <div class="modal-mid-title-bt">                           
                                <div>
                                    <b><h5 class="modal-title " id="exampleModalLabel">${detailclass.classNum} ${detailclass.className} 수강목록</h5></b>
                                </div>
                            </div>
                            <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                        </div>
                        <div class="modal-body">
                        
                            <!-- 모달  -->
                        <form:form modelAttribute="resultForm" method="post" action="/MAV/match/matchpoint">
                                <div class="modal-mid">
                                   <c:forEach items="${memberlist}" var="memberlist">                                       
                                       <h5 class="" id="">${memberlist.memberName}  ${memberlist.memberGender}</h5>
                                   </c:forEach>
                               </div>
                            </form:form>
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">닫기</button>
                        </div>
                    </div>
                </div>
            </div>
       </div>

   <br><br><br><br><br><br><br>
                <h2>지도 정보</h2>
                <input type="text" class="form-control" placeholder="추가 정보 입력">
                <button type="button" class="btn btn-primary mt-2">추가</button>
            </div>
        
        </div>
    </div>
</body>
</html>