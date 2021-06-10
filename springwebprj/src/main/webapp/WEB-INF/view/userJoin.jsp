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
<script src="//code.jquery.com/jquery-3.3.1.min.js"></script>
</head>
<body>
	<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
		<a class="navbar-brand" href="#">양티의 헬스 기록지!</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarNavDropdown" aria-controls="navbarNavDropdown"
			aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarNavDropdown">
			<ul class="navbar-nav">
				<li class="nav-item active"><a class="nav-link"
					href="/springwebprj/index">메인 <span class="sr-only">(current)</span>
				</a></li>
				<li class="nav-item">
				<a class="nav-link"
					href="/springwebprj/versionnote">버전 노트</a></li>
				<li class="nav-item">
				<a class="nav-link"
					href="/springwebprj/gallery">갤러리</a></li>
				<li class="nav-item">
			</ul>
		<form action="./index.jsp" method="get" class="form-inline my-2 my-lg=0">
			<input type="text" name="search" class="form-control mr-sm-2" type="search" placeholder="내용을 입력하세요." aria-label="Search">
			<button class="btn btn-outline-success my-2 my-sm-0" type = "submit">검색</button>
		</form>
		</div>
		
		<c:choose>
		<c:when test="${sessiontest != null}">
			<div class="nav-item dropdown" style="float: right;">
			<a class="nav-link dropdown-toggle" href="#"
				id="navbarDropdownMenuLink" role="button" data-toggle="dropdown"
				aria-haspopup="true" aria-expanded="false"> 접속상태입니다. </a>
			<div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
				<a class="dropdown-item" href="/springwebprj/userLogout">로그아웃</a>
			</div>
			</div>
		</c:when>
		<c:when test="${sessiontest == null }">
				<div class="nav-item dropdown" style="float: right;">
			<a class="nav-link dropdown-toggle" href="#"
				id="navbarDropdownMenuLink" role="button" data-toggle="dropdown"
				aria-haspopup="true" aria-expanded="false"> 접속하기 </a>
			<div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
				<a class="dropdown-item" href="/springwebprj/userLogin">로그인</a>
				<a class="dropdown-item" href="/springwebprj/userJoin">회원가입</a> 
			</div>
		</div>
		</c:when>
		</c:choose>
	</nav>


	<section class="container mt-3" style="max-width: 560px;">
		<!-- html5에서 사용하는거고 본문같은거 담을때 사용함 -->
		<form id="joinFrm" name= "joinFrm" method="post" action="/springwebprj/db/userJoinAction">
			<div class="form-group">
				<label>아이디</label> 
				<input type="text" id="userID" name="userID"
					class="form-control">
			</div>
			<div class="form-group">
				<label>비밀번호</label> 
				<input type="password" id="userPassword" name="userPassword"
					class="form-control">
			</div>
			<div class="form-group">
				<label>이름</label> 
				<input type="text" id="userName" name="userName"
					class="form-control">
			</div>
			<div class="form-group">
				<label>성별</label> 
				<input type='radio' id="userGender" name='userGender' value='남'/>남성
				<input type='radio' id="userGender" name='userGender' value='여'/>여성
<!-- 				<input type="text" name="userGender"
					class="form-control"> -->
			</div>
			<div class="form-group">
				<label>이메일</label> 
				<input type="email" id="userEmail" name="userEmail"
					class="form-control">
			</div>
			<input type="button" id="join" value="회원가입">
			<!-- <button type="submit" class="btn btn-primary">회원가입</button> -->
		</form>
	</section>
	<footer class="bg-dark mt-4 p-5 text-center" style="color: #FFFFFF;">
		Copyright &copy; 2018 나동빈 All Rights Reserved. </footer>
	<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
		integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-Piv4xVNRyMGpqkS2by6br4gNJ7DXjqk09RmUpJ8jgGtD7zP9yug3goQfGII0yAns"
		crossorigin="anonymous"></script>	
	
	<!-- 제이쿼리 자바스크립트 추가하기 -->
	<script src="./js/jquery.min.js"></script>
	<!-- 파퍼 자바스크립트 추가하기 -->
	<script src="./js/pooper.min.js"></script>
	<!-- 부트스트랩 자바스크립트 추가하기 -->
	<script src="./js/bootstrap.min.js"></script>
</body>
<script type="text/javascript">
	$(document).ready(function(e){
		$('#join').click(function(){

			// 입력 값 체크
			if($.trim($('#userID').val()) == ''){
				alert("아이디를 입력해 주세요.");
				$('#userID').focus();
				return;
			} else if($.trim($('#userPassword').val()) == ''){
				alert("비밀번호를 입력해 주세요.");
				$('#userPassword').focus();
				return;
			} else if($.trim($('#userName').val()) == ''){
				alert("이름을 입력해 주세요.");
				$('#userName').focus();
				return;
			} 
/* 			else if($.trim($('#userGender').val()) == ''){
				alert("성별을 입력해 주세요.");
				$('#userPassword').focus();
				return;
			}  */
			else if($.trim($('#userEmail').val()) == ''){
				alert("이메일을 입력해 주세요.");
				$('#userEmail').focus();
				return;
			}
			
			//전송
			$('#joinFrm').submit();
		});
		
	});
</script>
</html>