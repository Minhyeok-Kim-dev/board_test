/**
 * board 처리 관련 js  
 */
 define(["jquery", "util"], function(jquery, util) {
	function init() {
		_initEvents();
	}

	// 게시판 공통 event 정의
	function _initEvents() {
		
	}
	
	// 게시판 - 작성화면 event 정의
	function _initWriteFormEvents() {
		// - '저장' 버튼
		$("#writeForm_btnSave").on("click", function(e) {
			e.preventDefault();
			let header = {
				"data": {
					"prdNm" : $("#writeForm_sbPrdNm").val(),
					"type": $("#writeForm_sbType").val(),
					"title": $("#writeForm_txtTitle").val(),
					"contents": $("#writeForm_taContents").val()	
				}
			};
			
			util.sendPostRequest("api/board", JSON.stringify(header)).then(function(result) {
                alert(result);
            });
		});
	}
	
	function showWriteForm() {
		util.showPage("board/writeForm", $("#contents")).then(function() {
			_initWriteFormEvents();		
		});
	}
	
	
	
	function showListForm() {
		util.showPage("board/listForm", $("#contents")).then(function() {
			
		});
	}
	
	function showDetailForm() {
		util.showPage("board/detailForm", $("#contents")).then(function() {
			
		});
	}
	
	return {
        init: init,
        showWriteForm: showWriteForm,
        showListForm: showListForm,
        showDetailForm: showDetailForm
   	} 
});