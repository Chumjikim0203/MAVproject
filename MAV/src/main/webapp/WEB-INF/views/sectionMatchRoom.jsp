<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
            <!-- 매칭룸관리 -->
        <div class="room-title">매칭룸관리</div>
        <c:forEach items="${myRooms}" var="room">
            <c:choose>
                <c:when test="${room.matched == 1}">
                    <c:forEach items="${matchView}" var="MatchRoom">
                        <c:if test="${room.roomNum == MatchRoom.roomNum}">
                            <div class="card-1 mb-4">
                                <div class="room-info">
                                    <div class="room-date">
                                        <span>${room.roomDate}<br>${room.roomTime}</span>
                                    </div>
                                    <div class="room-title room-dt">
                                        <span class="romm-ddt">no.${MatchRoom.roomNum} &nbsp${MatchRoom.roomName} </span><br>
                                        <span class="romm-ddt">${MatchRoom.matchTitle}</span>
                                    </div>
                                    <span class="room-application ">
                                        <a href="<c:url value='/match/matchingDetail'/>?roomNum=${MatchRoom.roomNum}"
                                            class="room-application-link room-application-btn2">조회</a>
                                        <!-- 수정코드 필요여부에 따라 -->
                                        <%-- <a href="<c:url value='/room/roomsUpdate'/>?roomNum=${room.roomNum}" class="room-application-link room-application-btn2">수정</a> --%>
                                        <a href="#" class="room-application-link room-application-btn2"
                                            onclick="confirmDelete(${room.roomNum});">삭제</a>
                                    </span>
                                    
                                </div>
                            </div>
                        </c:if>
                    </c:forEach>
                </c:when>   
	    <c:otherwise>
	        <!-- 비워두기 -->					      
	    </c:otherwise>                                        
            </c:choose>                
        </c:forEach>
</body>
</html>