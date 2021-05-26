requirejs.config({
    baseUrl: "resources",
    waitSeconds: 200,
    paths: {
        "jquery": "common/js/jquery/jquery-3.3.1.min",
        "jquery-ui": "common/js/jquery/jquery-ui",
        "domready": "common/js/require/domReady",
        "Promise": "https://cdn.jsdelivr.net/npm/bluebird@3.7.1/js/browser/bluebird.min",   // IE Promise 사용가능토록
        "util": "common/js/util",
		"login": "login/js/login",
        "board": "board/js/board",
        "sidebar": "board/js/include/sidebar",
        "dataTables": "https://cdn.datatables.net/1.10.24/js/jquery.dataTables",
    },
    //waitSeconds: 200,
    shim: {
        "jquery": {"exports": "$"},
        "jquery-ui": {"exports": "jquery-ui", "deps": ["jquery"]},
		"util": {"exports": "util", "deps": ["jquery", "Promise"]},
		"login": {"exports": "login", "deps": ["jquery"]},
		"board": {"exports": "board", "deps": ["jquery"]},
		"sidebar": {"exports": "sidebar", "deps": ["jquery", "board"]},
		"dataTables": {"exports": "dataTables", "deps": ["jquery"]},
    }
});

