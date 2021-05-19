<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>Board test</title>
	
	<!-- Require.js -->
	<script src="<c:url value="/resources/common/js/require/require.js"/>"></script>
    <script src="<c:url value="/resources/common/js/require/main.js"/>" ></script>
    
    <!-- AdminLTE -->
    <!-- Google Font: Source Sans Pro -->
  	<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,400i,700&display=fallback">
  	<!-- Font Awesome -->
  	<link rel="stylesheet" href="<c:url value="/resources/adminlte/plugins/fontawesome-free/css/all.min.css"/>"> 
  	<!-- Theme style -->
  	<link rel="stylesheet" href="<c:url value="/resources/adminlte/dist/css/adminlte.min.css"/>">
  	
  	<style>
		/* 210517_kmh wrapper full height 적용 */
		.wrapper, body, html {
			height: 100%;
		}			
	</style>
</head>

<body class="hold-transition sidebar-mini">
	<!-- Site wrapper -->
	<div class="wrapper">
		<%@ include file="/WEB-INF/views/board/include/navbar.jsp" %>
		<%@ include file="/WEB-INF/views/board/include/sidebar.jsp" %>
	</div>
</body>

<script>
	require(["board"], function(board) {
		board.init();
	});
</script>
</html>