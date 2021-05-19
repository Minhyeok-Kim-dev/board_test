requirejs.config({
    baseUrl: "resources",
    waitSeconds: 200,
    paths: {
        "jquery": "common/js/jquery/jquery-3.3.1.min",
        "jquery-ui": "common/js/jquery/jquery-ui",
        "domready": "common/js/require/domReady",
        "Promise": "https://cdn.jsdelivr.net/npm/bluebird@3.7.1/js/browser/bluebird.min",   // IE Promise 사용가능토록
        
        "board": "board/js/board",
    },
    //waitSeconds: 200,
    shim: {
        "jquery": {"exports": "$"},
        "jquery-ui": {"exports": "jquery-ui", "deps": ["jquery"]},
		"board": {"exports": "board", "deps": ["jquery"]},
    }
});

