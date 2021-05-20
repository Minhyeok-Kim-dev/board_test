/**
 * sidebar 처리 관련 js
 */
  define(["jquery", "board"], function(jquery, board) {
	function init() {
		_initEvents();
	}
	
	function _initEvents() {
		$("#sidebar_btnMenuWrite").on("click", function() {
			board.showWriteForm();
		});
		
		$("#sidebar_btnMenuList").on("click", function() {
			board.showListForm();
		});
	}
	
	return {
        init: init
   	} 
});