<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>양티의 스프링 연습 헬스작성표</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
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
	
	
	<div class="container">
	<div class="row">
	<form method="post" action="/springwebprj/db/dbTest.do7?bbsid=${bbsid}">
			<div>
			<div class="form-group">
				<label>제목</label>
				<input type="text" name="Title" class="form-control" maxlength="30">
			</div>
<!-- 			<div class="form-group">
				<label>내용</label>
				<textarea name="Content" class="form-control" maxlength="2048" style="width:800px; height : 300px;"></textarea>
			</div> -->
			</div>
		<div style="width:600px; height:50px;">
 		<select name="health1" class="form-control mx-1 mt-2" style="width:300px; height : 50px;float:left;">
				<option value="턱걸이">턱걸이</option>
				<option value="스쿼트">스쿼트</option>
				<option value="벤치프레스-덤벨">벤치프레스-덤벨</option>
				<option value="덤벨컬">덤벨컬</option>
				<option value="숄더프레스">숄더프레스</option>
		</select>
		<input type="text" name="h1-1" class="form-control" maxlength="30" style="width:100px; height:50px; margin-top: 8px; float:left;">
		<span class="input-group-text" style="width:50px; height : 50px; margin-top: 8px; float:left;">X</span>
		<input type="text" name="h1-2" class="form-control" maxlength="30" style="width:100px; height:50px; margin-top: 8px; float:left;">
		</div>

		<div style="width:600px; height:50px;">
 		<select name="health2" class="form-control mx-1 mt-2" style="width:300px; height : 50px;float:left;">
				<option value="턱걸이">턱걸이</option>
				<option value="스쿼트" selected>스쿼트</option>
				<option value="벤치프레스-덤벨">벤치프레스-덤벨</option>
				<option value="덤벨컬">덤벨컬</option>
				<option value="숄더프레스">숄더프레스</option>
		</select>
		<input type="text" name="h2-1" class="form-control" maxlength="30" style="width:100px; height:50px; margin-top: 8px; float:left;">
		<span class="input-group-text" style="width:50px; height : 50px; margin-top: 8px; float:left;">X</span>
		<input type="text" name="h2-2" class="form-control" maxlength="30" style="width:100px; height:50px; margin-top: 8px; float:left;">
		</div>
		
		<div style="width:600px; height:50px;">
 		<select name="health3" class="form-control mx-1 mt-2" style="width:300px; height : 50px; float:left;">
				<option value="턱걸이">턱걸이</option>
				<option value="스쿼트">스쿼트</option>
				<option value="벤치프레스-덤벨" selected>벤치프레스-덤벨</option>
				<option value="덤벨컬">덤벨컬</option>
				<option value="숄더프레스">숄더프레스</option>
		</select>
		<input type="text" name="h3-1" class="form-control" maxlength="30" style="width:100px; height:50px; margin-top: 8px; float:left;">
		<span class="input-group-text" style="width:50px; height : 50px; margin-top: 8px; float:left;">X</span>
		<input type="text" name="h3-2" class="form-control" maxlength="30" style="width:100px; height:50px; margin-top: 8px; float:left;">
		</div>
		
		<div style="width:600px; height:50px;">
 		<select name="health4" class="form-control mx-1 mt-2" style="width:300px; height : 50px; float:left;">
				<option value="턱걸이">턱걸이</option>
				<option value="스쿼트">스쿼트</option>
				<option value="벤치프레스-덤벨">벤치프레스-덤벨</option>
				<option value="덤벨컬" selected>덤벨컬</option>
				<option value="숄더프레스">숄더프레스</option>
		</select>
		<input type="text" name="h4-1" class="form-control" maxlength="30" style="width:100px; height:50px; margin-top: 8px; float:left;">
		<span class="input-group-text" style="width:50px; height : 50px; margin-top: 8px; float:left;">X</span>
		<input type="text" name="h4-2" class="form-control" maxlength="30" style="width:100px; height:50px; margin-top: 8px; float:left;">
		</div>
		
		<div style="width:600px; height:50px;">
 		<select name="health5" class="form-control mx-1 mt-2" style="width:300px; height : 50px;float:left;">
				<option value="턱걸이">턱걸이</option>
				<option value="스쿼트">스쿼트</option>
				<option value="벤치프레스-덤벨">벤치프레스-덤벨</option>
				<option value="덤벨컬">덤벨컬</option>
				<option value="숄더프레스" selected>숄더프레스</option>
		</select>
		<input type="text" name="h5-1" class="form-control" maxlength="30" style="width:100px; height:50px; margin-top: 8px;float:left;">
		<span class="input-group-text" style="width:50px; height : 50px; margin-top: 8px;float:left;">X</span>
		<input type="text" name="h5-2" class="form-control" maxlength="30" style="width:100px; height:50px; margin-top: 8px;float:left;">
		</div>
		
		<div style="width:600px; height:50px;">
 		<select name="health6" class="form-control mx-1 mt-2" style="width:300px; height : 50px;float:left;">
				<option value="유산소 : 싸이클">유산소 : 싸이클</option>
		</select>
		<input type="text" name="h6-1" class="form-control" maxlength="30" style="width:100px; height:50px; margin-top: 8px;float:left;">
		</div>
		
		
		<input type="submit" class="btn btn-primary pull-right" value="글쓰기">
	</form>

	</div>
	</div>


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
<!-- <script type="text/javascript">
	$(document).ready(function(e){
		$('#alterbutton').click(function(){

			// 입력 값 체크
			if($.trim($('#userId').val()) == ''){
				alert("아이디를 입력해 주세요.");
				$('#userId').focus();
				return;
			}else if($.trim($('#passwd').val()) == ''){
				alert("패스워드를 입력해 주세요.");
				$('#passwd').focus();
				return;
			}
			
			//전송
			$('#loginFrm').submit();
		});
		
	});
</script> -->
</html>