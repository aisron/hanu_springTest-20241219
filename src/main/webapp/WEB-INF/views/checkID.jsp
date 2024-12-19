<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>checkID</title>
</head>
<body>
	checkID 입니다
	<hr>
	
	<!-- jstl if else  -->
	<c:choose>
		<c:when test="${idcheck eq 'memberOk'}">  <!-- jstl  문자열 비교  eq -->
			<h2>${loginid}님 ${loginpw }로그인 성공하셨습니다.</h2>
		</c:when>
		<c:otherwise>
			<h2>로그인 실패! 아이디와 비밀번호를 확인하세요	</h2>
		</c:otherwise>	
	</c:choose>

</body>
</html>