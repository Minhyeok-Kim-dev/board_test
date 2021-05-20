<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- Horizontal Form -->
<div class="card card-info">
  	<div class="card-header">
    	<h3 class="card-title">Write Form</h3>
	</div>
  <!-- /.card-header -->
  <!-- form start -->
  	<form class="form-horizontal">
    	<div class="card-body">
      		<div class="form-group row">
        		<label for="writeForm_txtComapny" class="col-sm-1 col-form-label">의뢰기관명</label>
        		<div class="col-sm-6">
          			<input id="writeForm_txtComapny" type="text" class="form-control">
        		</div>
      		</div>
      		<div class="form-group row">
        		<label for="writeForm_sbPrdNm" class="col-sm-1 col-form-label">문의유형</label>
        		<div class="col-sm-2">
          			<select id="writeForm_sbPrdNm" class="form-control">
          				<option value=0>검사명</option>
          				<option value=1>검사1</option>
          				<option value=2>검사2</option>
          				<option value=3>검사3</option>
          			</select>
        		</div>
        		<div class="col-sm-4">
          			<select id="writeForm_sbType" class="form-control">
          				<option value=0>문의유형</option>
          				<option value=1>접수문의</option>
          				<option value=2>결과문의</option>
          				<option value=3>결과상담</option>
          				<option value=4>기타</option>
          			</select>
        		</div>
      		</div>
      		<div class="form-group row">
        		<label for="writeForm_txtTitle" class="col-sm-1 col-form-label">제목</label>
       			<div class="col-sm-6">
          			<input id="writeForm_txtTitle" type="text" class="form-control">
        		</div>
      		</div>
      		<div class="form-group row">
        		<label for="writeForm_taContents" class="col-sm-1 col-form-label">문의내용</label>
       			<div class="col-sm-6">
          			<textarea id="writeForm_taContents" class="form-control" rows="3"></textarea>
        		</div>
      		</div>
      		<div class="form-group row">
        		<label for="writeForm_file" class="col-sm-1 col-form-label">파일첨부</label>
       			<div class="col-sm-6 ">
       				<div class="custom-file">
	          			<input id="writeForm_file" type="file" class="custom-file-input">
	          			<label class="custom-file-label" for="writeForm_file">Choose File</label>
       				</div>
        		</div>
      		</div>
    	</div>
    	<!-- /.card-body -->
    	<div class="card-footer">
      		<button id="writeForm_btnSave" class="btn btn-info float-right">등록</button>
    	</div>
    <!-- /.card-footer -->
  	</form>
</div>
