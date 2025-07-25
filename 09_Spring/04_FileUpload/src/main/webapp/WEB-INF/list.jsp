<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ko">
<head>
	<meta charset="UTF-8">
	<title>게시글 모음</title>
	<script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.7/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-LN+7fdVzj6u52u30Kp6M/trliBMCMKTyK833zpbD+pXdCLuTusPj697FH4R/5mcr" crossorigin="anonymous">
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.7/dist/js/bootstrap.bundle.min.js" integrity="sha384-ndDqU0Gzau9qJ1lfW4pNLlhNTkCfHzAVBReH9diLvGRem5+R9g2FzA8ZGN954O5Q" crossorigin="anonymous"></script>
</head>
<body>
	<div class="container">
		<h1>List Page</h1>
		<table class="table">
			<thead>
				<th>번호</th>
				<th>제목</th>
				<th>작성 시간</th>
			</thead>
			<tbody></tbody>
			
		</table>
		<button button type="button" class="btn btn-outline-warning">글 추가</button>
		<!-- Button trigger modal -->
			<button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#exampleModal">
			  Launch demo modal
			</button>

			<!-- Modal -->
			<div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
			  <div class="modal-dialog">
			    <div class="modal-content">
			      <div class="modal-header">
			        <h1 class="modal-title fs-5" id="exampleModalLabel">Modal title</h1>
			        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
			      </div>
				  <form>
			      <div class="modal-body">
			        <form action="/write" method="post" enctype="multipart/form-data">
						<div class="mb-3">
						<label for="exampleFormControlInput1" class="form-label">title</label>
						<input type="text" class="form-control" placeholder="name@example.com" name="title">
						</div>
						<div class="mb-3">
						<label for="exampleFormControlTextarea1" class="form-label">Content</label>
						<textarea class="form-control" rows="3" name="content"></textarea>
						</div>
						<div class="mb-3">
						<label for="formFile" class="form-label">addFile</label>
						<input class="form-control" name="file" type="file" id="formFile" accept="image/*">
						</div>
					</form>	
			      </div>
			      <div class="modal-footer">
			        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">닫기</button>
			        <button type="submit" class="btn btn-warning">등록</button>
			      </div>
				  </form>
			    </div>
			  </div>
		
	</div>
	
	</div>
	
	
</body>
</html>



















