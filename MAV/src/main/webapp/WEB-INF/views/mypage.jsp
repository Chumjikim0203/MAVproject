<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>	
	<h3>멤버 아이디 : ${member.memberId}</h3>
	<h3>멤버 이름 : ${member.memberName}</h3>
	<h3>멤버 생년월일 : ${member.memberBirth}</h3>
	<h3>멤버 주소 : ${member.memberAddr}</h3>
	<h3>멤버 성별 : ${member.memberGender}</h3>
	<h3>멤버 이메일 : ${member.memberEmail}</h3>	
	<a href="<c:url value='./update/member'/>?memberId=${member.memberId}">수정하기</a>
	<a href="<c:url value='./delete/member'/>?memberId=${member.memberId}">삭제하기</a>
</body>
</html>