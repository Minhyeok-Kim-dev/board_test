/**
 * 공통 util js
 */
 
// 가상 키보드 키
const VK=Object.freeze({LBUTTON:0x01,RBUTTON:0x02,CANCEL:0x03,MBUTTON:0x04,BACK:0x08,TAB:0x09,CLEAR:0x0C,RETURN:0x0D,SHIFT:0x10,CONTROL:0x11,MENU:0x12,PAUSE:0x13,CAPITAL:0x14,ESCAPE:0x1B,SPACE:0x20,PRIOR:0x21,NEXT:0x22,END:0x23,HOME:0x24,LEFT:0x25,UP:0x26,RIGHT:0x27,DOWN:0x28,SELECT:0x29,PRINT:0x2A,EXECUTE:0x2B,SNAPSHOT:0x2C,INSERT:0x2D,DELETE:0x2E,HELP:0x2F,NUMPAD0:0x60,NUMPAD1:0x61,NUMPAD2:0x62,NUMPAD3:0x63,NUMPAD4:0x64,NUMPAD5:0x65,NUMPAD6:0x66,NUMPAD7:0x67,NUMPAD8:0x68,NUMPAD9:0x69,SEPARATOR:0x6C,SUBTRACT:0x6D,DECIMAL:0x6E,DIVIDE:0x6F,F1:0x70,F2:0x71,F3:0x72,F4:0x73,F5:0x74,F6:0x75,F7:0x76,F8:0x77,F9:0x78,F10:0x79,F11:0x7A,F12:0x7B,F13:0x7C,F14:0x7D,F15:0x7E,F16:0x7F,F17:0x80,F18:0x81,F19:0x82,F20:0x83,F21:0x84,F22:0x85,F23:0x86,F24:0x87,NUMLOCK:0x90,SCROLL:0x91,LSHIFT:0xA0,RSHIFT:0xA1,LCONTROL:0xA2,RCONTROL:0xA3,LMENU:0xA4,RMENU:0xA5,PLAY:0xFA,ZOOM:0xFB});

define(["jquery", "Promise"], function(jquery, Promise) {
	/*
     * getContextPath
     * 
     * @description: 
     *   현재 컨텍스트 패스를 반환합니다.
     * 
     * @param: 
     *   {none} 
     * 
     * @return: 
     *   {String} 현재 컨텍스트 패스 문자열 
     */
    function getContextPath() { 
        return window.location.pathname.substring(0, window.location.pathname.indexOf("/",2));
    }
    
    /*
     * showPage <PROMISE>
     * 
     * @description: 
     *   Page를 엽니다.
     * 
     * @param: 
     *   {String} pageId: 표시할 pageId (Controller RequestMapping value)
     *   {Object} target: 표시할 대상 Object (DOM)
     *   {Object} [paramObj]: 전송할 Request Parameter
     *      
     * @return: 
     *   {Boolean}: 정상적으로 DOM 추가완료 후 true를 반환합니다.
     */
    function showPage(pageId, target, paramObj) {
        return new Promise(function(resolve) {
            if(typeof target === "undefined") {
                target = $("#app");
            }
            sendGetRequest(pageId, paramObj).then(function(result) {
                if(result !== false) {
                    target.html(result);
                    resolve(true);
                }
            });
        });
    }
    
    /*
     * sendGetRequest <PROMISE>
     * 
     * @description: 
     *   pageId에 해당하는 view내용 반환합니다.
     * 
     * @param: 
     *   {String} pageId: 표시할 pageId
     * 
     * @return: 
     *   {Object}: 
     *      정상: view내용
     *      실패: false  
     */
     function sendGetRequest(pageId, paramObj) {
        return new Promise(function(resolve){
            // paramObj 있는 경우
            if(typeof paramObj !== "undefined") {
            	$.ajax({
                    url: getContextPath() + "/" + pageId,
                    type: "GET",
                    data: paramObj,
                    async: false,
                }).done(function(data) {
                    if(data.length > 0) {                
                        resolve(data);
                    } else {
                        resolve(false);
                    }
                }).fail(function(data) {
                    resolve(false);
                });
                
            // paramObj 없는 경우
            } else {
                $.ajax({
                    url: getContextPath() + "/" + pageId,
                    type: "GET",
                }).done(function(data) {
                    if(data.length > 0) {                
                        resolve(data);
                    } else {
                        resolve(false);
                    }
                }).fail(function(data) {
                    resolve(false);
                });
            }
        });
    }
    
    /*
     * sendPostRequest <PROMISE>
     * 
     * @description: 
     *   pageId로 POST메시지를 전송합니다.
     * 
     * @param: 
     *   {String} pageId: 전송할 pageId
     *   {Object} paramObj: 전송할 parameter 객체 
     * 
     * @return: 
     *   {Object}: 
     *      정상: controller return값
     *      실패: false  
     */
    function sendPostRequest(pageId, paramObj) {
        return new Promise(function(resolve){
            $.ajax({
                "url": getContextPath() + "/" + pageId,
                "type": "POST",
                "contentType": "application/json",
                "data": paramObj
            }).done(function(data) {    
				resolve(data);
				/*
                if(data.length > 0) {                
                    resolve(data);
                } else {
                    resolve(false);
                }
                */
            }).fail(function(data) {
                resolve(false);
            });
        });
    }
    
    return {
		getContextPath: getContextPath,
		showPage: showPage,
		sendGetRequest: sendGetRequest,
		sendPostRequest: sendPostRequest,
	}
});