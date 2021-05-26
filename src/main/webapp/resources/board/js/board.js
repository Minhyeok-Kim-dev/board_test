/**
 * board 처리 관련 js  
 */
 define(["jquery", "util", "Promise"], function(jquery, util, Promise) {
	let _detailBoardData = {};
	
	////////////////////////////////////////////////////////////////////////
	/*
	 *	Common Area 
	 */
	////////////////////////////////////////////////////////////////////////
	function init() {
		_initEvents();
	}

	// 게시판 공통 event 정의
	function _initEvents() {
		// 'logout' 버튼
		$("#sidebar_btnLogout").on("click", function() {
			util.sendPostRequest("api/login/logout").then(function(result) {
				if(result.success === true) {
					util.sendRedirect("");
				}
			})
		});
	}
	
	
	////////////////////////////////////////////////////////////////////////
	/*
	 *	Write Form Area 
	 */
	////////////////////////////////////////////////////////////////////////
	// 게시판 - 작성화면 event 정의
	function _initWriteFormEvents() {
		// - '저장' 버튼
		$("#writeForm_btnSave").on("click", function(e) {
			e.preventDefault();
			let header = {
				"data": {
					"board": {
						"testid" : $("#writeForm_sbTestid").val(),
						"reqType": $("#writeForm_sbReqType").val(),
						"title": $("#writeForm_txtTitle").val(),
						"contents": $("#writeForm_taContents").val()
					}
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
	
	
	////////////////////////////////////////////////////////////////////////
	/*
	 *	List Form Area 
	 */
	////////////////////////////////////////////////////////////////////////
	function showListForm() {
		util.showPage("board/listForm", $("#contents")).then(function() {
			let header = {
				"data": {
				    "search": {
					  "skey": "title",
					  "svalue": ""
					}, 
					"paging": {
					  "cPage": 1,
					  "next10": 2,
					  "pageSize": 10,
					  "prev10": 4,
					  "total": 5,
					  "totalPage": 6
					},
					"sort": [{
					  "column": "title",
					  "alias": "_alias1",
					  "sord": "asc"
					}]
				  }
			};
			
			util.sendPostRequest("api/board/list", JSON.stringify(header)).then(function(result) {
                console.log(result);
                _initBoardListTable(result.data.boardFormList);
            });
		});
	}
	
	
	/*
     * _initBoardListTable
     * 
     * @description: 
     *   DataTable 초기화
     * 
     * @param: 
     *   {Object} data: DataTable bind 할 data (JSON)
     * 
     * @return: 
     *   {none} 
     */
	function _initBoardListTable(data) {
		let columns = [
			{"data": null}, 
			{"data": "testid"}, 
			{"data": "title"}, 
			{"data": "company"}, 
			{"data": "regdt"}, 
			{"data": "status"}
		];
		
		let table = $("#boardTable").DataTable({
			"columns": columns,
			// define index column 
			"columnDefs": [{
				"searchable": false,
				"orderable": false,
				"targets": 0
			}],
			
			"pasing": true,
			"pagingType": "full_numbers",
			"filter": false,
			"serverSize": false,
			
			"recordsTotal": 100,
			"recordsFiltered": 100,
		});
		
		// create index column
		table.on("order.dt search.dt", function() {
			table.column(0, {
				"search": "applied",
				"order": "applied"
			}).nodes().each(function(cell, i) {
				cell.innerHTML = i + 1;
			});
		}).draw();
		
		// tr click
		table.on("click", "tr", function() {
			let data = table.row(this).data();
			
			if(data !== "undefined" && data.idx !== "undefined") {
				_showDetailFormByRowData(data.idx);
			}
		});
		
		_addRowsBoardListTable(data);
	}
	
	
	/*
     * _clearBoardListTable
     * 
     * @description: 
     *   DataTable 데이터 삭제
     * 
     * @param: 
     *   {none} 
     * 
     * @return: 
     *   {none} 
     */
	function _clearBoardListTable() {
		$("#boardTable").DataTable().clear().draw();
	}
	
	
	/*
     * _addRowsBoardListTable
     * 
     * @description: 
     *   DataTable에 Data를 추가합니다.
     * 
     * @param: 
     *   {Object} data: DataTable bind 할 data (JSON)  
     * 
     * @return: 
     *   {none} 
     */
	function _addRowsBoardListTable(data) {
		$("#boardTable").DataTable().rows.add(data).draw();
	}
	
	
	////////////////////////////////////////////////////////////////////////
	/*
	 *	Detail Form Area 
	 */
	////////////////////////////////////////////////////////////////////////
	function _showDetailFormByRowData(idx) {
		util.showPage("board/detailForm", $("#contents")).then(function() {
			// 상세 영역 초기화
			_initDetailForm(idx);
			_initDetailFormEvents();
			
			// 댓글 영역 초기화
			_initReplyForm(idx);
			_initReplyFormEvents();
		});
	}
	
	function _initDetailForm(idx) {
		let url = "api/board/" + idx;
		util.sendGetRequest(url).then(function(result) {
			if(result !== "undefined" && result.success === true) {
				_detailBoardData = result.data.boardForm;
				
				$("#detailForm_idx").val(_detailBoardData.idx);
				$("#detailForm_txtComapny").val(_detailBoardData.company);
				$("#detailForm_sbTestid").val(_detailBoardData.testid);
				$("#detailForm_sbReqType").val(_detailBoardData.reqType);
				$("#detailForm_txtTitle").val(_detailBoardData.title);
				$("#detailForm_taContents").val(_detailBoardData.contents);
				
			}
		});
	}
	
	function _initDetailFormEvents() {
		// '수정' 버튼
		$("#detailForm_btnModify").on("click", function(e) {
			e.preventDefault();
			
			_detailBoardData.title =  $("#detailForm_txtTitle").val();
			_detailBoardData.contents = $("#detailForm_taContents").val();
			_detailBoardData.testid = $("#detailForm_sbTestid").val();
			_detailBoardData.reqType = $("#detailForm_sbReqType").val();

			let header = {
				"data": {
					"board": _detailBoardData
				}
			};
			
			util.sendPutRequest("api/board", JSON.stringify(header)).then(function(result) {
				if(result.success === true) {
					alert("수정되었습니다.");
					showListForm();
				}
			})
		});	
		
		// '삭제' 버튼
		$("#detailForm_btnDelete").on("click", function(e) {
			e.preventDefault();
			
			util.sendDeleteRequest("api/board/" + _detailBoardData.idx).then(function(result) {
				if(result.success === true) {
					alert("삭제되었습니다.");
					showListForm();
				}
			})
		});
	}
	
	////////////////////////////////////////////////////////////////////////
	/*
	 *	Detail Form > Reply Form Area 
	 */
	////////////////////////////////////////////////////////////////////////
	function _initReplyForm(parentsIdx) {
		
	}
	
	function _initReplyFormEvents() {
		// '저장' 버튼
		$("#replyForm_btnSave").on("click", function() {
			let header = {
				"data": {
					"board": {
						"parentsIdx": _detailBoardData.idx, 
						"depth": _detailBoardData.depth + 1,
						"status": $("#replyForm_sbStatus").val(),
						"contents": $("#replyForm_taContents").val()
					}
				}
			};
			
			util.sendPostRequest("api/reply", JSON.stringify(header)).then(function(result) {
	            alert(result);
	        });			
		});
		
		// '수정' 버튼
		$("#replyForm_btnModify").on("click", function() {
			
		});
		
		// '삭제' 버튼
		$("#replyForm_btnDelete").on("click", function() {
			
		});
	}
	
	return {
        init: init,
        showWriteForm: showWriteForm,
        showListForm: showListForm
   	} 
});