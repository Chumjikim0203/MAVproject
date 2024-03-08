<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="utf-8">

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>업체 마이페이지</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet"integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
    <script src="https://kit.fontawesome.com/1a6288a620.js" crossorigin="anonymous"></script>
    <script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
   
   
    <link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@400;500;700&display=swap" rel="stylesheet">
    <style>
        * 
        {
            font-family: 'Noto Sans KR', sans-serif;
        }
        body {
            font-family: 'Noto Sans KR', sans-serif;
            background-color: #f8f9fa;
            color: #212529;
            width: 80vw;
            margin: 0 auto;

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
            font-size: 1.0rem;
            font-weight: bold;
            margin-bottom: 0.5rem;
            color: #343a40;
            
        }
        
        .room-dt{
        
	        text-align: left;
        
        }
        .romm-ddt{
           background-color: rgba(235, 235, 235, 0.9);
           border-radius: 0.25rem;
           padding: 0 0.5rem
        
        }
        .room-date {
            font-weight: bold;

        }


        .room-application-btn {
            padding: 0.5rem 1rem;
            background-color: #007bff;
            color: white;
            border-radius: 0.25rem;
            text-decoration: none;
        }
        
        .room-application-btn2 {
            padding: 0.5rem 1rem;
            background-color: #ef1047;
            color: white;
            border-radius: 0.25rem;
            text-decoration: none;
        }
        
        .room-application-btn3 {
            padding: 0.5rem 1rem;
            background-color: #0404B4;
            color: white;
            border-radius: 0.25rem;
            text-decoration: none;
        }
        
        .room-application-btn4 {
            padding: 0.5rem 1rem;
            background-color: #FEA51d;
            color: white;
            border-radius: 0.25rem;
            text-decoration: none;
            border: none;
            
        }

        .room-info {
            display: flex;
            justify-content: space-between;
            align-items: center;
            font-size: 1rem;
        }
        
        .modal-mid{
             display: flex;
             justify-content: center;
	         align-items: center;
	         font-size: 0.5rem;
        	
        }
        
        .modal-mid-bt{
        margin: 0 1rem
        }
        
        .modal-mid-title-bt{
              display: flex;
             justify-content: space-btween;
	         align-items: center;
	         font-size: 0.5rem;
        }

    </style>
	<script type="text/javascript">
	    function confirmDelete(roomNum) {
	        if (window.confirm("매칭대기중인 방입니다. 정말로 삭제하시겠습니까?")) {
	            window.location.href = "<c:url value='/room/deleteMyRoom'/>?roomNum=" + roomNum;
	        }
	    }
	    $(document).ready(function() {
	        // 모든 버튼에 대한 클릭 이벤트 핸들러
	        $('#roomManagementButton, #MatchRoomManagementButton, #ResultManagementButton, #TournamentButton').click(function(e) {
	            e.preventDefault();

	            // 각 버튼에 대한 AJAX 요청 URL
	            var urls = {
	                'roomManagementButton': './store/RoomManagement',
	                'MatchRoomManagementButton': './store/MatchRoomManagement',
	                'ResultManagementButton': './store/ResultManagement',
	                'TournamentButton': './tournament/tournamentManagement'
	            };

	            // 각 버튼에 대한 컨텐츠 ID
	            var contents = {
	                'roomManagementButton': '#content1',
	                'MatchRoomManagementButton': '#content2',
	                'ResultManagementButton': '#content3',
	                'TournamentButton': '#content4'
	            };

	            // 클릭한 버튼의 ID를 가져옵니다.
	            var id = $(this).attr('id');

	            // 다른 컨텐츠들을 숨깁니다.
	            $.each(contents, function(key, value) {
	                if (key !== id) $(value).hide();
	            });

	            // AJAX 요청을 보냅니다.
	            $.ajax({
	                url: urls[id],
	                type: 'get',
	                dataType: 'html',
	                success: function(data) {
	                    // 해당 컨텐츠를 보이게 하고, 데이터를 채웁니다.
	                    $(contents[id]).show().html(data);
	                },
	                error: function(xhr, status, error) {
	                    console.error('AJAX 요청 실패:', error);
	                }
	            });
	        });
	    });

	</script>

</head>
<jsp:include page="./section/nav.jsp" />
<body>
	<ul class="navbar-nav center">
      <li>
         <h5><b>${member.memberName}</b> 업주님 환영합니다!</h5>
      </li>
   </ul>	
    <div class="main">
        <div class="col-4">
            <div class="card" style="width: 100%;">
                <h5 class="card-title" style="text-align: center; font-size: 1.5rem;">업주</h5>
                <img src="." class="card-img-top img1" alt="...">
                <div class="card-body">
                    <p class="card-text" style="text-align: center; font-size: 1.2rem;">${store.storeName}</p>
                    <p class="card-text" style="text-align: center; font-size: 1rem;">${member.memberEmail}</p>
                </div>
                <ul class="list-group list-group-flush">
                	<li class="list-group-item">
						<a href="#" id="roomManagementButton">경기장관리</a>
                    </li>
                    <li class="list-group-item">
						<a href="#" id="MatchRoomManagementButton">매칭룸관리</a>
                    </li>
                     <li class="list-group-item">
						<a href="#" id="ResultManagementButton">결과관리</a>
                    </li>
                    <li class="list-group-item">
						<a href="#" id="TournamentButton">토너먼트관리</a>
                    </li>
                    <li class="list-group-item">
                        <a href="./tournament/addtournament">토너먼트등록</a>
                    </li>
                    <li class="list-group-item">
                        <a href="./room/addrooms">경기장만들기</a>
                    </li>
                    <li class="list-group-item">
                        <a href="store/delete?storeId=${store.storeId}">업주탈퇴</a>
                    </li>
                </ul>
                <div class="card-body">
                    <a href="store/update?storeId=${store.storeId}" class="card-link">정보수정</a>
                </div>
            </div>
        </div>
        <div class="col-7">
            <div class="card">
                <h5>개인정보</h5>
                <div class="right">
                    <img src=".." class="" width="30%">
                    <div class="right-name">
                        <p>${store.storeName}</p>
                        <p>${member.memberEmail}</p>
                    </div>
                </div>
                <hr>
            </div> 
             <br>           
             <div>
	             <div id="content1"></div> 
	             <div id="content2"></div> 
	             <div id="content3"></div>
	             <div id="content4"></div> 
             </div>
        </div>
  </div>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm"
        crossorigin="anonymous"></script>
</body>


<!-- 
       $(document).ready(function() {
           $('#roomManagementButton').click(function(e) {
               e.preventDefault();
   
               $.ajax({
                   url: './store/RoomManagement',
                   type: 'get',
                   dataType: 'html',
                   success: function(data) {
                       $('#content1').html(data);
                   },
                   error: function(xhr, status, error) {
                       console.error('AJAX 요청 실패:', error);
                   }
               });
           });
       });
       $(document).ready(function() {
           $('#MatchRoomManagementButton').click(function(e) {
               e.preventDefault();
   
               $.ajax({
                   url: './store/MatchRoomManagement',
                   type: 'get',
                   dataType: 'html',
                   success: function(data) {
                       $('#content2').html(data);
                   },
                   error: function(xhr, status, error) {
                       console.error('AJAX 요청 실패:', error);
                   }
               });
           });
       });      
       $(document).ready(function() {
           $('#ResultManagementButton').click(function(e) {
               e.preventDefault();
   
               $.ajax({
                   url: './store/ResultManagement',
                   type: 'get',
                   dataType: 'html',
                   success: function(data) {
                       $('#content3').html(data);
                   },
                   error: function(xhr, status, error) {
                       console.error('AJAX 요청 실패:', error);
                   }
               });
           });
       });
       $(document).ready(function() {
           $('#TournamentButton').click(function(e) {
               e.preventDefault();
   
               $.ajax({
                   url: './tournament/tournamentManagement',
                   type: 'get',
                   dataType: 'html',
                   success: function(data) {
                       $('#content4').html(data);
                   },
                   error: function(xhr, status, error) {
                       console.error('AJAX 요청 실패:', error);
                   }
               });
           });
       });

 -->
</html>


