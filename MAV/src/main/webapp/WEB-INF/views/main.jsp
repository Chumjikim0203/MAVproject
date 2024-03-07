<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>메인 페이지</title>
    <script src="https://kit.fontawesome.com/1a6288a620.js" crossorigin="anonymous"></script>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
    <style>
        body{
            width: 80vw;
            margin: 0 auto;
        }

        .innershadow:hover{
          
          color: red;
        }

        .innershadow2:hover{
          
          color: rgb(14, 14, 192);
        }

                /* ë ì§ ì íê¸° ì¤íì¼ë§ */
        input[type="date"] {
          padding: 8px;
          border: 1px solid #ccc;
          border-radius: 4px;
          font-size: 14px;
        }

        /* ì íë ë ì§ ì¤íì¼ë§ */
        input[type="date"]::-webkit-datetime-edit {
          color: #333;
          font-weight: bold;
        }

        /* ë¬ë ¥ ìì´ì½ ì¤íì¼ë§ */
        input[type="date"]::-webkit-calendar-picker-indicator {
          background-color: #ccc;
          padding: 4px;
          border-radius: 50%;
          cursor: pointer;
        }
    </style>
  </head>
  <body>
<jsp:include page="./section/nav.jsp" />
      <div id="myCarousel" class="carousel slide" data-ride="carousel">
        <div class="carousel-inner">
          <div class="carousel-item active">
            <img src="https://static.nike.com/a/images/w_1920,c_limit,f_auto,q_auto/918325cf-fc65-4f3a-8d61-89495fc985d2/image.png" class="d-block w-100" alt="첫 번째 슬라이드">
          </div>
          <div class="carousel-item">
            <img src="https://static.nike.com/a/images/w_1920,c_limit,f_auto,q_auto/7cc7ad0c-9886-4bc2-b5f3-ea1c1e6bf5b0/image.png" class="d-block w-100" alt="두 번째 슬라이드">
          </div>
          <div class="carousel-item">
            <img src="https://static.nike.com/a/images/w_1920,c_limit,f_auto,q_auto/0f48ad69-e539-4c6d-8e60-40b9ad120b03/image.png" class="d-block w-100" alt="세 번째 슬라이드">
          </div>
        </div>
        <!-- 이전/다음 화살표 -->
        <a class="carousel-control-prev" href="#myCarousel" role="button" data-slide="prev">
          <span class="carousel-control-prev-icon" aria-hidden="true"></span>
          <span class="sr-only"></span>
        </a>
        <a class="carousel-control-next" href="#myCarousel" role="button" data-slide="next">
          <span class="carousel-control-next-icon" aria-hidden="true"></span>
          <span class="sr-only"></span>
        </a>
      </div>
  <div class="p-4 p-md-5 mb-4 rounded text-bg-dark">
    <div class="col-md-6 px-0">
      <h1 class="display-4 fst-italic">3월 oo컵 시작</h1>
      <p class="lead my-3">어쩌구 저쩌구 샬러샬러</p>
      <p class="lead mb-0"><a href="#" class="text-white fw-bold">참여하기</a></p>
    </div>
  </div>
       <!-- 매칭룸 -->
      <div class="my-3 p-3 bg-body rounded shadow">
        <h6 class="border-bottom pb-2 mb-0 fw-bold innershadow"><i class="fa-solid fa-fire">&nbsp;</i></i> Mattching Room</h6>
        <ul class="nav nav-pills">
          <li class="nav-item">
            <a class="nav-link active" aria-current="page" href="#">전체</a>
          </li>&nbsp;
          <li class="nav-item dropdown">
            <a class="nav-link dropdown-toggle" data-bs-toggle="dropdown" href="#" role="button" aria-expanded="false">종목</a>
            <ul class="dropdown-menu">
              <li><a class="dropdown-item" href="#">탁구</a></li>
              <li><a class="dropdown-item" href="#">풋살</a></li>
              <li><a class="dropdown-item" href="#">축구</a></li>
              <li><a class="dropdown-item" href="#">농구</a></li>
              <li><a class="dropdown-item" href="#">야구</a></li>
              <li><a class="dropdown-item" href="#">볼링</a></li>
              <li><a class="dropdown-item" href="#">당구</a></li>
              <li><a class="dropdown-item" href="#">배드민턴</a></li>
              <li><a class="dropdown-item" href="#">골프</a></li>
              <li><a class="dropdown-item" href="#">스쿼시</a></li>
              <li><a class="dropdown-item" href="#">테니스</a></li>
              <li><hr class="dropdown-divider"></li>
            </ul>
          </li>
          &nbsp;
          <label for="datepicker"></label>
          <input type="date" id="datepicker">
        </ul>
        <div class="d-flex text-body-secondary pt-3">
          <img  style="border-radius: 4px; border: 0.5px solid bisque;" src="https://search.pstatic.net/common/?src=http%3A%2F%2Fblogfiles.naver.net%2FMjAyMzEwMzFfMjk5%2FMDAxNjk4NzI2ODMzODM1.IwC69pz2-KkLOuYdY_bfKkY_kwPodTHsYabwstlFRJgg.HVut_PkKzsY07RqP-frp2roB5BKgqJpedPttcdFfhHwg.JPEG.renoma4339%2F20231023%25A3%25DF220440.jpg" alt="" width="100" height="100">
          &nbsp;&nbsp;&nbsp;
          <div class="pb-3 mb-0 small lh-sm border-bottom w-100">
            <div class="d-flex justify-content-between">
              <strong class="text-gray-dark" ><h5><b>날아라 숫돌이 경기장</b></h5></strong>
              <button class="btn btn-danger" type="submit">매칭하기</button>
            </div>
            <b>
              <span class="d-block">2024-03-21</span>
              <br>
              <span class="d-block">17:00</span>
            </b>  
          </div>
        </div>
        <small class="d-block text-end mt-3">
          <button type="button" class="btn btn-secondary">모두보기</button>
        </small>
      </div>

      <!-- 경기장 -->
      <div class="my-3 p-3 bg-body rounded shadow">
        <h6 class="border-bottom pb-2 mb-0 fw-bold innershadow2"><i class="fa-solid fa-calendar-days"></i>&nbsp;</i></i> Field</h6>
        <ul class="nav nav-pills">
          <li class="nav-item">
            <a class="nav-link active" aria-current="page" href="#">전체</a>
          </li>&nbsp;
          <li class="nav-item dropdown">
            <a class="nav-link dropdown-toggle" data-bs-toggle="dropdown" href="#" role="button" aria-expanded="false">종목</a>
            <ul class="dropdown-menu">
              <li><a class="dropdown-item" href="#">탁구</a></li>
              <li><a class="dropdown-item" href="#">풋살</a></li>
              <li><a class="dropdown-item" href="#">축구</a></li>
              <li><a class="dropdown-item" href="#">농구</a></li>
              <li><a class="dropdown-item" href="#">야구</a></li>
              <li><a class="dropdown-item" href="#">볼링</a></li>
              <li><a class="dropdown-item" href="#">당구</a></li>
              <li><a class="dropdown-item" href="#">배드민턴</a></li>
              <li><a class="dropdown-item" href="#">골프</a></li>
              <li><a class="dropdown-item" href="#">스쿼시</a></li>
              <li><a class="dropdown-item" href="#">테니스</a></li>
              <li><hr class="dropdown-divider"></li>
            </ul>
          </li>
          &nbsp;
          <label for="datepicker"></label>
          <input type="date" id="datepicker" >
        </ul>
        <div class="d-flex text-body-secondary pt-3">
          <img  style="border-radius: 4px; border: 0.5px solid bisque;" src="https://search.pstatic.net/common/?src=http%3A%2F%2Fblogfiles.naver.net%2FMjAyMzEwMzFfMjk5%2FMDAxNjk4NzI2ODMzODM1.IwC69pz2-KkLOuYdY_bfKkY_kwPodTHsYabwstlFRJgg.HVut_PkKzsY07RqP-frp2roB5BKgqJpedPttcdFfhHwg.JPEG.renoma4339%2F20231023%25A3%25DF220440.jpg" alt="" width="100" height="100">
          &nbsp;&nbsp;&nbsp;
          <div class="pb-3 mb-0 small lh-sm border-bottom w-100">
            <div class="d-flex justify-content-between">
              <strong class="text-gray-dark" ><h5><b>날아라 숫돌이 경기장</b></h5></strong>
              <button class="btn btn-primary" type="submit">방만들기</button>
            </div>
            <b>
              <span class="d-block">2024-03-21</span>
              <br>
              <span class="d-block">17:00</span>
            </b>  
          </div>
        </div>
        <small class="d-block text-end mt-3">
          <button type="button" class="btn btn-secondary">모두보기</button>
        </small>
      </div>    
    </div>
  </div>
<jsp:include page="./section/footer.jsp" />
  
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm" crossorigin="anonymous"></script>
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    <script>
      // datepicker 요소 가져오기
      var datepicker = document.getElementById('datepicker');

      // datepicker 값 변경 시 이벤트 처리
      datepicker.addEventListener('change', function() {
        var selectedDate = datepicker.value;
        console.log('선택된 날짜:', selectedDate);

        // 선택된 날짜를 기반으로 추가 작업 수행
        // 예: 서버에 전송, 다른 동작 수행 등
});
    </script>
    
  </body>
</html>