<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8" />
    <script src="https://kit.fontawesome.com/1a6288a620.js"
        crossorigin="anonymous"></script>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css"
        rel="stylesheet"
        integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9"
        crossorigin="anonymous">
    <title>게시판 목록보기</title>
    <link href='//spoqa.github.io/spoqa-han-sans/css/SpoqaHanSansNeo.css'
        rel='stylesheet' type='text/css'>

<link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@400;500;700&display=swap" rel="stylesheet">
    <style>
        * 
        {
            font-family: 'Noto Sans KR', sans-serif;
        }
        .main-container
        {
        	width:80%;
        	margin: 0 auto;
        }
	    .notice 
	    {
	        padding-top: 3rem;
	        margin: 0 auto;
	        text-align: center;
	        font-size: 3rem;
	        font-weight: bold;
	    }
	
	    .noticemom 
	    {       
	        height: 10rem;
	        margin: 0 auto;
	    }


</style>
</head>

<body>
<jsp:include page="./section/nav.jsp" />
<div class="main-container">
    <div class="noticemom">
        <h1 class="notice mt-5">공지사항</h1>
    </div>
    <section class="board">
        <!-- board list area -->
        <div id="board-list" class="container mt-3">
            <table class="table ">
				<thead style="background: linear-gradient(to right, #ff6b6b, #434343);">
					<tr >
                        <th scope="col">번호</th>
                        <th scope="col">제목</th>
                        <th scope="col">조회수</th>
                        <th scope="col">작성자</th>
                        <th scope="col">등록일</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="notices" items="${notices}">
                        <tr>
                            <td>${notices.noticeNum}</td>
                            <td><a
                                href="<c:url value='/notice/noticeDetail'/>?noticeNum=${notices.noticeNum}"
                                class="text-dark">${notices.noticeTitle}</a></td>
                            <td>${notices.noticeHits}</td>
                            <td>${notices.noticeWriter}</td>
                            <td>${notices.noticeDate}</td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
            <br>
            <div class="text-center">
                <a href="./writeForm" class="btn btn-primary">글쓰기</a>
            </div>
            <br>

            <nav aria-label="Page navigation" class="mt-3">
                <ul class="pagination justify-content-center">

                    <c:set var="startPage"
                        value="${currentPage - 2 > 0 ? currentPage - 2 : 1}" />
                    <c:set var="endPage"
                        value="${startPage + 4 > pageCount ? pageCount : startPage + 4}" />

                    <c:if test="${currentPage > 1}">
                        <li class="page-item"><a class="page-link"
                            href="<c:url value='/notice/list'/>?page=${currentPage - 1}"
                            aria-label="Previous"> <span aria-hidden="true">&laquo;</span>
                        </a></li>
                    </c:if>

                    <c:forEach var="page" begin="${startPage}" end="${endPage}">
                        <li class="page-item ${page == currentPage ? 'active' : ''}">
                            <a class="page-link"
                                href="<c:url value='/notice/list'/>?page=${page}">${page}</a>
                        </li>
                    </c:forEach>
                    <c:if test="${currentPage < pageCount}">
                        <li class="page-item"><a class="page-link"
                            href="<c:url value='/notice/list'/>?page=${currentPage + 1}"
                            aria-label="Next"> <span aria-hidden="true">&raquo;</span>
                        </a></li>
                    </c:if>
                </ul>
            </nav>
        </div>
    </section>
</div>
</body>
</html>
