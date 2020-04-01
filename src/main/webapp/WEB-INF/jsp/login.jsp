<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<!DOCTYPE html>
<html lang="en">
	<head>
		<meta charset="utf-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<title>Login</title>
		<!-- Tell the browser to be responsive to screen width -->
		<meta name="viewport" content="width=device-width, initial-scale=1">
		
		<!-- Font Awesome -->
		<link rel="stylesheet" href="<c:url value="/resources-lte/plugins/fontawesome-free/css/all.min.css" />">
		<!-- Ionicons -->
		<link rel="stylesheet" href="https://code.ionicframework.com/ionicons/2.0.1/css/ionicons.min.css">
		<!-- icheck bootstrap -->
		<link rel="stylesheet" href="<c:url value="/resources-lte/plugins/icheck-bootstrap/icheck-bootstrap.min.css" />">
		<!-- Theme style -->
		<link rel="stylesheet" href="<c:url value="/resources-lte/dist/css/adminlte.min.css" />">
		<!-- Google Font: Source Sans Pro -->
		<link href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,400i,700" rel="stylesheet">
	</head>

	<body class="hold-transition login-page">
		<div class="login-box">
		  	<div class="login-logo">
		    	<b>Admin</b> Penjualan MVC
		  	</div>
		  	
		  	<!-- /.login-logo -->
		  	<div class="card">
		    	<div class="card-body login-card-body">
		      		<p class="login-box-msg">Sign in to start your session</p>
					
					<form:form method="post" action="${pageContext.request.contextPath}/login/check-login" modelAttribute="MstKaryawanDto">
		        		<div class="input-group mb-3">
		          			<form:input class="form-control" placeholder="Username" path="username"/><form:errors path="username"/>
		          			<div class="input-group-append">
		            			<div class="input-group-text">
		              				<span class="fas fa-user"></span>
		            			</div>
		          			</div>
		        		</div>
		        		
		        		<div class="input-group mb-3">
		          			<form:input type="password" class="form-control" placeholder="Password" path="password"/><form:errors path="password"/>
		          			<div class="input-group-append">
					            <div class="input-group-text">
					              	<span class="fas fa-lock"></span>
					            </div>
		          			</div>
		        		</div>
		        		
		        		<div class="row">
			          		<div class="col-8"></div>
			          		<!-- /.col -->
				          	<div class="col-4">
				            	<button type="submit" class="btn btn-primary btn-block">Sign In</button>
				          	</div>
			          		<!-- /.col -->
			        	</div>
					</form:form>
					
				</div>
    			<!-- /.login-card-body -->
  			</div>
		</div>
		<!-- /.login-box -->


		<!-- jQuery -->
		<script src="<c:url value="/resources-lte/plugins/jquery/jquery.min.js" />"></script>
		<!-- Bootstrap 4 -->
		<script src="<c:url value="/resources-lte/plugins/bootstrap/js/bootstrap.bundle.min.js" />"></script>
		<!-- AdminLTE App -->
		<script src="<c:url value="/resources-lte/dist/js/adminlte.min.js" />"></script>
	</body>
</html>