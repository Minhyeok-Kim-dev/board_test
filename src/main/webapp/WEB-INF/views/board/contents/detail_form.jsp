<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<input type="hidden" id="detailForm_idx" />

<!-- Horizontal Form -->
<div id="detailForm" class="card card-info">
  	<div class="card-header">
    	<h3 class="card-title">Detail Form</h3>
	</div>
  	<!-- /.card-header -->
  	<!-- form start -->
  	<form class="form-horizontal">
    	<div class="card-body">
      		<div class="form-group row">
        		<label for="detailForm_txtComapny" class="col-sm-1 col-form-label">의뢰기관명</label>
        		<div class="col-sm-6">
          			<input id="detailForm_txtComapny" type="text" class="form-control">
        		</div>
      		</div>
      		<div class="form-group row">
        		<label for="detailForm_sbTestid" class="col-sm-1 col-form-label">문의유형</label>
        		<div class="col-sm-2">
          			<select id="detailForm_sbTestid" class="form-control">
          				<option value="">검사명</option>
          				<option value="검사1">검사1</option>
          				<option value="검사2">검사2</option>
          				<option value="검사3">검사3</option>
          			</select>
        		</div>
        		<div class="col-sm-4">
          			<select id="detailForm_sbReqType" class="form-control">
          				<option value="">문의유형</option>
          				<option value="10">접수문의</option>
          				<option value="20">결과문의</option>
          				<option value="30">결과상담</option>
          				<option value="90">기타</option>
          			</select>
        		</div>
      		</div>
      		<div class="form-group row">
        		<label for="detailForm_txtTitle" class="col-sm-1 col-form-label">제목</label>
       			<div class="col-sm-6">
          			<input id="detailForm_txtTitle" type="text" class="form-control">
        		</div>
      		</div>
      		<div class="form-group row">
        		<label for="detailForm_taContents" class="col-sm-1 col-form-label">문의내용</label>
       			<div class="col-sm-6">
          			<textarea id="detailForm_taContents" class="form-control" rows="3"></textarea>
        		</div>
      		</div>
      		<div class="form-group row">
        		<label for="detailForm_file" class="col-sm-1 col-form-label">파일첨부</label>
       			<div class="col-sm-6 ">
       				<div class="custom-file">
	          			<input id="detailForm_file" type="file" class="custom-file-input">
	          			<label class="custom-file-label" for="writeForm_file">Choose File</label>
       				</div>
        		</div>
      		</div>
    	</div>
    	<!-- /.card-body -->
    	<div class="card-footer">
      		<button id="detailForm_btnDelete" class="btn btn-info float-right">삭제</button>
      		<button id="detailForm_btnModify" class="btn btn-info float-right">수정</button>
    	</div>
    	<!-- /.card-footer -->
  	</form>
</div>
<!-- /.detailForm -->

<div id="replyForm"class="card card-info">
	<form class="form-horizontal">
		<div class="card-body">
			<div class="form-group row">
	       		<label for="replyForm_txtUserNm" class="col-sm-1 col-form-label">작성자</label>
	       		<div class="col-sm-2">
	         			<input id="replyForm_txtUserNm" type="text" class="form-control">
	      		</div>
	    	</div>
	    	<div class="form-group row">
	       		<label for="replyForm_sbStatus" class="col-sm-1 col-form-label">처리상태</label>
	       		<div class="col-sm-2">
          			<select id="replyForm_sbStatus" class="form-control">
          				<option value="N">처리중</option>
          				<option value="Y">처리완료</option>
          			</select>
        		</div>
	    	</div>
	    	<div class="form-group row">
	       		<label for="replyForm_taContents" class="col-sm-1 col-form-label">답변내용</label>
	      			<div class="col-sm-6">
	         			<textarea id="replyForm_taContents" class="form-control" rows="3"></textarea>
	       		</div>
	     	</div>
		</div>
		<!-- /.card-body -->
    	<div class="card-footer">
      		<button id="replyForm_btnDelete" class="btn btn-info float-right">삭제</button>
      		<button id="replyForm_btnModify" class="btn btn-info float-right">수정</button>
      		<button id="replyForm_btnSave" class="btn btn-info float-right">저장</button>
    	</div>
	</form>
</div>