<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>Login</title>
	
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
</head>

<body>
	<input id="txtEdgcid" type="text" name="edgcid" placeholder="Enter ID">
	<input id="txtPasswd" type="password" name="passwd" placeholder="Enter PW">
	<button id="btnLogin" class="btn btn-primary">Login</button>
</body>

<script>
	require(["login"], function(login) {
		login.init();
	});
</script>
</html>