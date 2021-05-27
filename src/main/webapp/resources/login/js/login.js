/**
 * login 처리 관련 js  
 */
 define(["jquery", "util"], function(jquery, util) {
	function init() {
		_initEvents();
	}
	
	function _initEvents() {
		$("#btnLogin").on("click", function() {
			let header = {
				"data": {
					"userInfo": {
						"edgcid": $("#txtEdgcid").val(),
						"passwd": $("#txtPasswd").val()
					}
				}
			};
			
			/*
			util.sendPostRequest("api/login", JSON.stringify(header)).then(function(result) {
                if(result.success === true) {
					util.sendRedirect("board");
				}
            });
            */
            
            $.ajax({
                url: util.getContextPath() + "/" + "api/file/download",
                type: "GET",
            }).done(function(data) {
				console.log(data);
			});
		});
	}
	
	return {
        init: init
   	} 
});