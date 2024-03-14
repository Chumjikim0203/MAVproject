<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="utf-8">

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>클럽 리스트</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
    <style>
        body 
        {
            width : 80%;
        	margin : 0 auto;
        }

        .main {
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
            
        }
         .tab {
        overflow: hidden;
       
    }

    .tab button {
        background-color: inherit;
        float: left;
        border: none;
        outline: none;
        cursor: pointer;
        padding: 14px 16px;
        transition: 0.3s;
    }

    .tab button:hover {
      
    }

    .tab button.active {
       
    }

    .tabcontent {
        display: none;
        
    }
    .club-choose
    {
    	list-style : none;
    	display : flex;
    	flex-direction : row;
    	align-items: center;
    	justify-content : space-around;
    }
    .body-btn
    {
    	text-decoration : none;
    	border : 1px solid silver;
    	border-radius : 10px;
    	color : black;
    	padding : 10px;
    }
	.clublistimage
	{
		height : 450px;
	}    
	.clublistimage img 
	{
	    max-width: 100%;
	    height: auto;
	    max-height: 100%;
	}
    </style>
</head>
<body>
	<div class="main-container">
		<c:choose>
		  	<c:when test="${empty sessionScope.member}">
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
		                   <a class="nav-link active" aria-disabled="true" href="/MAV/login">로그인</a>
		                 </li>
		                  <li class="nav-item">
		                   <a class="nav-link active" aria-disabled="true" href="../add/member">회원가입</a>
		                 </li>
		               </ul>
		               <form class="d-flex" role="search">
		                 <input class="form-control me-2" type="search" placeholder="search" aria-label="Search">
		                 <button class="btn btn-outline-success" type="submit">search</button>
		               </form>
		             </div>
		           </div>
		       </nav>
		      </c:when>
			       <c:otherwise>
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
		                  <li class="nav-item dropdown">
		                    <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
		                      동호회
		                    </a>
		                    <ul class="dropdown-menu">
		                      <li><a class="dropdown-item" href="/MAV/club/add">동호회 생성</a></li>
		                      <li><hr class="dropdown-divider"></li>
		                      <li><a class="dropdown-item" href="/MAV/club/list">동호회 리스트</a></li>
		                    </ul>
		                  </li>
		                  <li class="nav-item dropdown">
		                    <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
		                      매칭
		                    </a>
		                    <ul class="dropdown-menu">
		                      <li><a class="dropdown-item" href="#">일반매칭</a></li>
		                      <li><hr class="dropdown-divider"></li>
		                      <li><a class="dropdown-item" href="#">토너먼트</a></li>
		                      <li><hr class="dropdown-divider"></li>
		                      <li><a class="dropdown-item" href="#">기타매칭</a></li>
		                    </ul>
		                  </li>
		                  <li class="nav-item">
		                    <a class="nav-link active" aria-disabled="true" href="/MAV/logout">로그아웃</a>
		                  </li>
		                   <li class="nav-item">
		                    <a class="nav-link active" aria-disabled="true" href="/MAV/member/mypage">마이페이지</a>
		                  </li>
		                </ul>
		                <form class="d-flex" role="search">
		                  <input class="form-control me-2" type="search" placeholder="search" aria-label="Search">
		                  <button class="btn btn-outline-success" type="submit">search</button>
		                </form>
		              </div>
		            </div>
		        </nav>
		       </c:otherwise>      
		    </c:choose>
		    <div class="mt-3 clublistimage">
	    		<img src="<c:url value="/resources/images/clublistpage.jpg"/>" style="width: 100%;">		    
		    </div>
	    	<div class="club-choose col-3 mt-3">	    	
	   			<a class="body-btn" href="/MAV/club/list" role="button">전체 보기</a>
	    		<li class="dropdown">
                    <a class="dropdown-toggle body-btn locale" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                      지역별
                    </a>
                    <ul class="dropdown-menu">
                      <li><a class="dropdown-item" href="#" onclick="filterLocale('전체')">전체</a></li>
                      <li><hr class="dropdown-divider"></li>
                      <li><a class="dropdown-item" href="#" onclick="filterLocale('서울')">서울</a></li>
                      <li><hr class="dropdown-divider"></li>
                      <li><a class="dropdown-item" href="#" onclick="filterLocale('경기')">경기</a></li>
                      <li><hr class="dropdown-divider"></li>
                      <li><a class="dropdown-item" href="#" onclick="filterLocale('충청')">충청</a></li>
                      <li><hr class="dropdown-divider"></li>
                      <li><a class="dropdown-item" href="#" onclick="filterLocale('경상')">경상</a></li>
                      <li><hr class="dropdown-divider"></li>
                      <li><a class="dropdown-item" href="#" onclick="filterLocale('전라')">전라</a></li>
                      <li><hr class="dropdown-divider"></li>
                      <li><a class="dropdown-item" href="#" onclick="filterLocale('강원')">강원</a></li>
                      <li><hr class="dropdown-divider"></li>
                      <li><a class="dropdown-item" href="#" onclick="filterLocale('제주')">제주</a></li>
                    </ul>
	            </li>
	            <li class="dropdown">
                    <a class="dropdown-toggle body-btn category" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                      종목별
                    </a>
                    <ul class="dropdown-menu">
                      <li><a class="dropdown-item" href="#" onclick="filterCategory('전체')">전체</a></li>
                      <li><hr class="dropdown-divider"></li>
                      <li><a class="dropdown-item" href="#" onclick="filterCategory('축구')">축구</a></li>
                      <li><hr class="dropdown-divider"></li>
                      <li><a class="dropdown-item" href="#" onclick="filterCategory('풋살')">풋살</a></li>
                      <li><hr class="dropdown-divider"></li>
                      <li><a class="dropdown-item" href="#" onclick="filterCategory('당구')">당구</a></li>
                      <li><hr class="dropdown-divider"></li>
                      <li><a class="dropdown-item" href="#" onclick="filterCategory('농구')">농구</a></li>
                      <li><hr class="dropdown-divider"></li>
                      <li><a class="dropdown-item" href="#" onclick="filterCategory('야구')">야구</a></li>
                      <li><hr class="dropdown-divider"></li>
                      <li><a class="dropdown-item" href="#" onclick="filterCategory('족구')">족구</a></li>
                      <li><hr class="dropdown-divider"></li>
                      <li><a class="dropdown-item" href="#" onclick="filterCategory('기타')">기타</a></li>
                    </ul>
	            </li>
	    	</div>
		    <div class="main col-12">
	            <div class = "col-12 ">
	               <div class="room-title">동호회 리스트</div>
	                <c:forEach items="${club}" var="club">
	                    <div class="card-1 mb-3">
	                        <div class="room-info" style="text-align: center">
	                            <span class="room-title">&nbsp;&nbsp;${club.clubName}</span>
	                            <span class="room-date clubCategory">동호회 종류 : ${club.clubCategory}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span>
	                            <span class="room-date clubLocale">동호회 활동지역 : ${club.clubLocale}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span>
	                            <span class="room-application">                          
	                          	<a href="<c:url value='/club/clubinfo'/>?clubName=${club.clubName}" class="room-application-link room-application-btn">클럽 상세정보</a>
	                            </span>
	                        </div>
	                    </div>
	                </c:forEach>
	           </div>
		   	</div>
		</div>
		<script>
			function filterCategory(category) {
			    const clubCards = document.querySelectorAll('.card-1');
			    clubCards.forEach(card => {
			        const clubCategory = card.querySelector('.clubCategory').textContent.trim().split(':')[1].trim();
			        console.log("선택된 종목명 : " + category)
			        if (category === '전체' || clubCategory === category) {
			            card.style.display = 'block';
			        } else {
			            card.style.display = 'none';
			        }
			    });
			}
		</script>
		<script>
		    function filterLocale(locale) {
		        const clubCards = document.querySelectorAll('.card-1');
		        clubCards.forEach(card => {
		            const clubLocale = card.querySelector('.clubLocale').textContent.trim().split(':')[1].trim();
		            console.log("선택된 지역명 : " + locale)
		            if (locale === '전체' || clubLocale === locale) {
		                card.style.display = 'block';
		            } else {
		                card.style.display = 'none';
		            }
		        });
		    }
		</script>				
	    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js"
	        integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm"
	        crossorigin="anonymous">
	    </script>
	    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
	    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"></script>
	    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>