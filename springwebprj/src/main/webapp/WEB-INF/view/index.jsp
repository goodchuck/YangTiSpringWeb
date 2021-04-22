<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>양티의 스프링 연습 헬스작성표</title>

<!-- 부트스트랩 -->
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css"
	integrity="sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l"
	crossorigin="anonymous">
</head>
<body>
	<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
		<a class="navbar-brand" href="#">양티</a>
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
					href="/springwebprj/Ytbbs">게시판</a></li>
				<li class="nav-item">
				<a class="nav-link"
					href="/springwebprj/versionnote">버전 노트</a></li>
				<li class="nav-item">
				<a class="nav-link"
					href="/springwebprj/gallery">갤러리</a></li>
				<li class="nav-item">
				<a class="nav-link"
					href="/springwebprj/dnftest">던파 연습</a>
			</ul>
		</div>

		<div class="nav-item dropdown" style="float: right;">
			<% if(session.getAttribute("sessiontest") == null) { %>
			<a class="nav-link dropdown-toggle" href="#"
				id="navbarDropdownMenuLink" role="button" data-toggle="dropdown"
				aria-haspopup="true" aria-expanded="false"> 접속하기 </a>
			<% } %>
			<% if(session.getAttribute("sessiontest") != null) { %>
			<a class="nav-link dropdown-toggle" href="#"
				id="navbarDropdownMenuLink" role="button" data-toggle="dropdown"
				aria-haspopup="true" aria-expanded="false"> 접속상태입니다. </a>
			<% } %>
			<div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
				<% if(session.getAttribute("sessiontest") == null) { %>
				<a class="dropdown-item" href="/springwebprj/userLogin">로그인</a> 
				<a class="dropdown-item" href="/springwebprj/userJoin">회원가입</a>
				<% } %>
				<% if(session.getAttribute("sessiontest") != null) {%>
				<a class="dropdown-item" href="/springwebprj/userLogout">로그아웃</a>
				<% } %>
			</div>
		</div>
	</nav>


	<form action="./index.jsp" method="get"
		class="form-inline my-2 my-lg=0">
		<input type="text" name="search" class="form-control mr-sm-2"
			type="search" placeholder="내용을 입력하세요." aria-label="Search">
		<button class="btn btn-outline-success my-2 my-sm-0" type="submit">검색</button>
	</form>
	<%-- <h1>들어온사람 : <%= session.getAttribute("testForm") != null ? "존재" : "없음" %></h1> --%>
	<h1>들어온사람 : ${sessiontest}</h1>


	
	<section class="container"> <!-- html5에서 사용하는거고 본문같은거 담을때 사용함 -->
		<form method="get" action="/springwebprj/index" class="form-inline mt-3">
			<select name="lectureDivide" class="form-control mx-1 mt-2">
				<option value="전체">전체</option>
				<option value="전공">전공</option>
				<option value="교양">교양</option>
				<option value="기타">기타</option>
			</select>
			
			<select name="searchType" class="form-control mx-1 mt-2">
				<option value="최신순">최신순</option>
				<option value="추천순">추천순</option>
			</select>
			<input type="text" name="search" class="form-control mx-1 mt-2" placeholder="내용을 입력하세요.">
			<button type="submit" class="btn btn-primary mx-1 mt-2">검색</button>
			<a class="btn btn-primary mx-1 mt-2" data-toggle="modal" href="#registerModal">등록하기</a> <!-- modal은 웹페이지의 위쪽에 등장하는 하나의 등록양식과같은 특이한거 -->
			<a class="btn btn-danger mx-1 mt-2" data-toggle="modal" href="#reportModal">신고</a> <!-- modal은 웹페이지의 위쪽에 등장하는 하나의 등록양식과같은 특이한거 -->
		</form>

	<c:forEach var="test" items="${testarray}" varStatus="status">
			<div class="card bg-light mt-3">
		<div class="card-header bg-light">
			<div class="row">
				<div class="col-8 text-left"> &nbsp;<small></small></div>
				<div class="col-4 text-right">
					종합<span style="color : red;">${test.bbsid}</span>
				</div>
			</div>
		</div>
		<div class="card-body">
			<h5 class="card-title">
				&nbsp;<small>${test.id}, ${test.title}</small>
			</h5>
			<p class="card-text">${test.content}</p>
			<div class="row">
				<div class="col-9 text-left">
					성적<span style="color: red;"></span>
					널널<span style="color: red;"></span>
					강의<span style="color: red;"></span>
					<span style="color: green;"></span>
				</div>
				<div class="col-3 text-right">
					<a onclick="return confirm('추천하시겠습니까?')" href="./likeAction.jsp?evaluationID=">추천</a>
					<a onclick="return confirm('삭제하시겠습니까?')" href="./deleteAction.jsp?evaluationID=">삭제</a>
				</div>
			</div>
		</div>
	</div>
	</c:forEach>
	</section>      




<div class="modal fade" id="registerModal" tabindex="-1" role="dialog" aria-labelledby="modal" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="modal">평가등록</h5>
					<button type="button" class="close" data-dismiss="modal" aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body">
					<form action="/springwebprj/db/dbTest.do5" method="post">
<!-- 						<div class="form-row">
							<div class="form-group col-sm-4">
								<label>수강 연도</label>
								<select name="lectureYear" class="form-control">
									<option value="2011">2011</option>
									<option value="2012">2012</option>
									<option value="2013">2013</option>
									<option value="2014">2014</option>
									<option value="2015">2015</option>
									<option value="2016">2016</option>
									<option value="2017">2017</option>
									<option value="2018">2018</option>
									<option value="2019">2019</option>
									<option value="2020">2020</option>
									<option value="2021" selected>2021</option>
									<option value="2022">2022</option>
									<option value="2023">2023</option>
								</select>
							</div>
							<div class="form-group col-sm-4">
								<label>수강 학기</label>
								<select name="semesterDivide" class="form-control">
									<option value="1학기" selected>1학기</option>
									<option value="여름학기" >여름학기</option>
									<option value="2학기" >2학기</option>
									<option value="겨울학기" >겨울학기</option>
								</select>
							</div>
							<div class="form-group col-sm-4">
								<label>강의 구분</label>
								<select name="lectureDivide" class="form-control">
									<option value="전공" selected>전공</option>
									<option value="교양" >교양</option>
									<option value="기타" >기타</option>
								</select>
							</div>
						</div> -->
						<div class="form-group">
							<label>제목</label>
							<input type="text" name="Title" class="form-control" maxlength="30">
						</div>
						<div class="form-group">
							<label>내용</label>
							<textarea name="Content" class="form-control" maxlength="2048" style="height : 180px;"></textarea>
						</div>
						<!-- <div class ="form-row">
							<div class="form-group col-sm-3">
								<label>종합</label>
								<select name="totalScore" class="form-control">
									<option value="A" selected>A</option>
									<option value="B">B</option> 
									<option value="C">C</option>
									<option value="D">D</option>
									<option value="F">F</option>
								</select>
							</div>
							<div class="form-group col-sm-3">
								<label>성적</label>
								<select name="creditScore" class="form-control">
									<option value="A" selected>A</option>
									<option value="B">B</option> 
									<option value="C">C</option>
									<option value="D">D</option>
									<option value="F">F</option>
								</select>
							</div>
							<div class="form-group col-sm-3">
								<label>널널</label>
								<select name="comfortableScore" class="form-control">
									<option value="A" selected>A</option>
									<option value="B">B</option> 
									<option value="C">C</option>
									<option value="D">D</option>
									<option value="F">F</option>
								</select>
							</div>
							<div class="form-group col-sm-3">
								<label>강의</label>
								<select name="lectureScore" class="form-control">
									<option value="A" selected>A</option>
									<option value="B">B</option> 
									<option value="C">C</option>
									<option value="D">D</option>
									<option value="F">F</option>
								</select>
							</div>							
						</div> -->
						<div class="modal-footer">
							<button type="button" class="btn btn-secondary" data-dismiss="modal">취소</button>
							<button type="submit" class="btn btn-primary">등록하기</button>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>

	<div class="modal fade" id="reportModal" tabindex="-1" role="dialog" aria-labelledby="modal" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="modal">신고하기</h5>
					<button type="button" class="close" data-dismiss="modal" aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body">
					<form action="./reportAction.jsp" method="post">
						<div class="form-group">
							<label>신고 제목</label>
							<input type="text" name="reportTitle" class="form-control" maxlength="30">
						</div>
						<div class="form-group">
							<label>신고 내용</label>
							<textarea name="reportContent" class="form-control" maxlength="2048" style="height : 180px;"></textarea>
						</div>
						<div class="modal-footer">
							<button type="button" class="btn btn-secondary" data-dismiss="modal">취소</button>
							<button type="submit" class="btn btn-danger">신고하기</button>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
	<footer class="bg-dark mt-4 p-5 text-center" style="color: #FFFFFF;">
		Copyright &copy; 2021 양태현 All Rights Reserved. </footer>
	<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
		integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-Piv4xVNRyMGpqkS2by6br4gNJ7DXjqk09RmUpJ8jgGtD7zP9yug3goQfGII0yAns"
		crossorigin="anonymous"></script>
</body>
</html>