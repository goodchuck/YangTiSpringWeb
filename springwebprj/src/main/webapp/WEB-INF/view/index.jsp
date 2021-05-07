<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib  prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page import="java.util.*"%>
<%@ page import="java.io.PrintWriter" %> <!-- 한글 깨짐 방지를 위한 초반 작업 -->
<%
	request.setCharacterEncoding("UTF-8");
%> <!-- 건너오는 모든데이터를 utf-8로 받게끔 -->
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
<title>양티의 스프링 연습 헬스작성표</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- 부트스트랩 -->
<link rel="stylesheet" type="text/css" href="css/yang.css">
	
	<link rel="stylesheet" href="http://poiemaweb.com/assets/css/ajax.css">
    <!-- 부트스트랩 -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css" integrity="sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l" crossorigin="anonymous">
	
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <!-- IE8 에서 HTML5 요소와 미디어 쿼리를 위한 HTML5 shim 와 Respond.js -->
    <!-- WARNING: Respond.js 는 당신이 file:// 을 통해 페이지를 볼 때는 동작하지 않습니다. -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
  	<style>
  	h1 {
  			color: rgb(0, 0, 0);
			text-decoration: underline;
  		}
	body {
		background-image:url('resources/images/background.png');
		background-repeat: no-repeat;
		background-size : cover;
		}
	</style>
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
		
	<c:choose>
	<c:when test = "${sessiontest ==null}">
	<div class="alert alert-primary" role="alert">
		로그인을 해주세요!
	</div>
	</c:when>
	<c:when test = "${sessiontest != null}">
	<div class="alert alert-primary" role="alert">
		환영합니다! ${sessiontest}님! 오늘도 열심히 운동합시다!
	</div>
	</c:when>
	</c:choose>

	<section class="container"> <!-- html5에서 사용하는거고 본문같은거 담을때 사용함 -->
		<form method="get" action="" class="form-inline mt-3">
<!-- 			<select name="lectureDivide" class="form-control mx-1 mt-2">
				<option value="전체">전체</option>
				<option value="전공">전공</option>
				<option value="교양">교양</option>
				<option value="기타">기타</option>
			</select> -->
			
<!-- 			<select name="searchType" class="form-control mx-1 mt-2">
				<option value="최신순">최신순</option>
				<option value="추천순">추천순</option>
			</select> -->
			<input type="text" name="search" class="form-control mx-1 mt-2" placeholder="내용을 입력하세요.">
			<button type="submit" class="btn btn-primary mx-1 mt-2">검색</button>
			
			<c:if test ="${sessiontest != null }">
			<!-- <a class="btn btn-primary mx-1 mt-2" data-toggle="modal" href="#registerModal">등록하기</a> modal은 웹페이지의 위쪽에 등장하는 하나의 등록양식과같은 특이한거 -->
			<a class="btn btn-primary mx-1 mt-2" href="/springwebprj/db/bbswrite?userId=sessiontest">등록하기</a>
			</c:if>
			<!-- <a class="btn btn-danger mx-1 mt-2" data-toggle="modal" href="#reportModal">신고</a> modal은 웹페이지의 위쪽에 등장하는 하나의 등록양식과같은 특이한거 -->
		</form>

	<c:forEach var="test" items="${testarray}" varStatus="status">
	<c:if test="${test.bbsav == 1}">
			<div class="card bg-light mt-3">
		<div class="card-header bg-light">
			<div class="row">
				<div class="col-8 text-left"><b>제목 : ${test.title}</b> <small> 작성자 : ${test.id}</small></div>
				<div class="col-4 text-left">
					<span>${test.bbsid} 번 게시물</span>
					<span style="color : red;">작성시간 : ${test.nowtime}</span>
				</div>
			</div>
		</div>
		<div class="card-body">
			<h5 class="card-title">
				&nbsp;<small>내용</small>
			</h5>
			<p class="card-text">${test.content}</p>
			<c:if test="${test.id == sessiontest}">
			<div class="col-3 text-left">
				<!-- <a class="btn btn-primary mx-1 mt-2" id="alterbutton" data-toggle="modal" href="#AlterModal">수정하기</a> -->
				<a onclick="return confirm('수정하시겠습니까?')" href="/springwebprj/db/bbsview?bbsid=${test.bbsid}&userid=${test.id}&sid=${sessiontest}&bbscontent=${test.content}&bbstitle=${test.title}">수정</a> 
				<a onclick="return confirm('삭제하시겠습니까?')" href="/springwebprj/db/bbsDeleteAction?bbsid=${test.bbsid}&userid=${test.id}&sid=${sessiontest}">삭제</a>
			</div>
			</c:if>
		</div>
	</div>
	</c:if>
	

	</c:forEach>
	</section>      

<%-- 	<div class="modal fade" id="AlterModal" tabindex="-1" role="dialog" aria-labelledby="modal" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="modal"></h5>
					<button type="button" class="close" data-dismiss="modal" aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body">
					<form action="/springwebprj/db/bbsAlterAction?bbsid=${test.bbsid}" method="post">

						<div class="form-group">
							<label>제목</label>
							<input type="text" name="Title" class="form-control" maxlength="30" placeholder="내용을입력하세요">
						</div>
						<div class="form-group">
							<label>내용</label>
							<textarea name="Content" class="form-control" maxlength="2048" placeholder="내용을 입력하세요" style="height : 180px;" ></textarea>
						</div>

						<div class="modal-footer">
							<button type="button" class="btn btn-secondary" data-dismiss="modal">취소</button>
							<button type="submit" class="btn btn-primary">수정하기</button>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div> --%>

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

						<div class="form-group">
							<label>제목</label>
							<input type="text" id="Title" name="Title" class="form-control" maxlength="30">
						</div>
						<div class="form-group">
							<label>내용</label>
							<textarea name="Content" id="Content" class="form-control" maxlength="2048" style="height : 180px;"></textarea>
						</div>

						<div class="modal-footer">
							<button type="button" class="btn btn-secondary" data-dismiss="modal">취소</button>
							<button type="submit" id="modalsubmit" class="btn btn-primary">등록하기</button>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
	


			<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
				aria-labelledby="myModalLabel" aria-hidden="true">
				<div class="modal-dialog">
					<div class="modal-content">
						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal"
								aria-hidden="true">&times;</button>
							<h4 class="modal-title" id="myModalLabel">Modal title</h4>
						</div>
						<div class="modal-body">처리가 완료되었습니다.</div>
						<div class="modal-footer">
							<button type="button" class="btn btn-default"
								data-dismiss="modal">Close</button>
							<button type="button" class="btn btn-primary">Save
								changes</button>
						</div>
					</div>
					<!-- /.modal-content -->
				</div>
				<!-- /.modal-dialog -->
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
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-Piv4xVNRyMGpqkS2by6br4gNJ7DXjqk09RmUpJ8jgGtD7zP9yug3goQfGII0yAns" crossorigin="anonymous"></script>
</body>
<script type="text/javascript">
	$(document).ready(function(e){
		$('#modalsubmit').click(function(){

		// 입력 값 체크
			if($.trim($('#Title').val()) == ''){
				alert("제목을 입력해 주세요.");
				$('#Title').focus();
				return;
			}else if($.trim($('#Content').val()) == ''){
				alert("내용을 입력해 주세요.");
				$('#Content').focus();
				return;
			} 
			
			
			alert("등록이 완료되었습니다.");
			return;
			//전송
			//$('#loginFrm').submit();
		});
		
	});
</script>
</html>