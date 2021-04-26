<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.io.PrintWriter" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>강의평가 웹 사이트</title>
<!-- 부트스트랩 CSs 추가하기 -->
<link rel="stylesheet" href="./css/bootstrap.min.css">
<!-- 커스텀 CSS 추가하기 -->
<link rel="stylesheet" href="./css/custom.css">
<!-- 부트스트랩 -->
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css"
	integrity="sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l"
	crossorigin="anonymous">
</head>
<body>
<%
	String userID = null;
if(session.getAttribute("userID") != null){
	userID = (String) session.getAttribute("userID");	
}
if(userID != null){
	   PrintWriter script = response.getWriter();
	   script.println("<script>");
	   script.println("alert('로그인이 된 상태입니다.');");
	   script.println("location.href = 'index.jsp';");
	   script.println("</script>");
	   script.close();
	   return;
}
%>
	<nav class="navbar navbar-expand-lg navbar-light bg-light">
	<a class="navbar-brand" href="index.jsp">강의평가 웹 사이트</a>
	<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbar">
		<span class="navbar-toggler-icon"></span>
	</button>
	<div id="navbar" class="collapse navbar-collapse">
		<ul class="navbar-nav mr-auto">
			<li class="nav-item active">
				<a class="nav-link" href = "index.jsp">메인</a>
			</li>
			<li class="nav-item dropdown">
				<a class="nav-link dropdown-toggle" id="dropdown" data-toggle="dropdown">
					회원 관리
				</a>
				<div class="dropdown-menu" aria-labelledby="dropdown">
<%
	if(userID == null){
%>		
					<a class="dropdown-item" href="userLogin.jsp">로그인</a>
					<a class="dropdown-item" href="userJoin.jsp">회원가입</a>
<%
	} else {
%>
					<a class="dropdown-item" href="userLogout.jsp">로그아웃</a>
<%
	}
%>
				</div>
			</li>
		</ul>
		<form action="./index.jsp" method="get" class="form-inline my-2 my-lg=0">
			<input type="text" name="search" class="form-control mr-sm-2" type="search" placeholder="내용을 입력하세요." aria-label="Search">
			<button class="btn btn-outline-success my-2 my-sm-0" type = "submit">검색</button>
		</form>
	</div>
	</nav>
	<section class="container mt-3" style="max-width: 560px;"> <!-- html5에서 사용하는거고 본문같은거 담을때 사용함 -->
		<form method="post" action="/springwebprj/db/userLoginAction">
			<div class="form-group">
				<label>아이디</label>
				<input type="text" name="userID" class="form-control">
			</div>
			<div class="form-group">
				<label>비밀번호</label>
				<input type="password" name="userPassword" class="form-control">
			</div>
			<button type="submit" class="btn btn-primary">로그인</button>
		</form>
		
		
	</section>
	<c:choose>

	<c:when test="${msg == 'failure'}">
		<div style="color: red">
			아이디 또는 비밀번호가 일치하지 않습니다.
		</div>
	</c:when>
	
	<c:when test="${msg == null}">
		<div style="color: red">
			아무것도 없습니다.
		</div>
	</c:when>
	
	</c:choose>
	
	<footer class="bg-dark mt-4 p-5 text-center" style="color: #FFFFFF;">
		Copyright &copy; 2018 나동빈 All Rights Reserved.
	</footer>
		<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
		integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-Piv4xVNRyMGpqkS2by6br4gNJ7DXjqk09RmUpJ8jgGtD7zP9yug3goQfGII0yAns"
		crossorigin="anonymous"></script>
	<!-- 제이쿼리 자바스크립트 추가하기 -->
	<script src ="./js/jquery.min.js"></script>
	<!-- 파퍼 자바스크립트 추가하기 -->
	<script src ="./js/pooper.min.js"></script>
	<!-- 부트스트랩 자바스크립트 추가하기 -->
	<script src ="./js/bootstrap.min.js"></script>
</body>
</html>