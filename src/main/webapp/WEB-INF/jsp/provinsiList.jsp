<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<!DOCTYPE html>
<html lang="en">
	<head>
		<meta charset="ISO-8859-1">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
		<meta name="description" content="">
		<meta name="author" content="">
		<!-- <link rel="icon" href="../../favicon.ico"> -->
		<!-- <link rel="canonical" href="https://getbootstrap.com/docs/3.3/examples/signin/"> -->
		
		<title>List Provinsi</title>
		
		<!-- Bootstrap core CSS -->
		<link href="<c:url value="/plugin/css/bootstrap.min.css" />" rel="stylesheet">
		
		<!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
		<link href="<c:url value="/plugin/css/ie10-viewport-bug-workaround.css" />" rel="stylesheet">
		
		<!-- Custom styles for this template -->
		<link href="signin.css" rel="stylesheet">
		
		<!-- Just for debugging purposes. Don't actually copy these 2 lines! -->
		<!--[if lt IE 9]><script src="../../assets/js/ie8-responsive-file-warning.js"></script><![endif]-->
		<script src="<c:url value="/plugin/js/ie-emulation-modes-warning.js" />"></script>
		
		<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
		<!--[if lt IE 9]>
		  <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
		  <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
		<![endif]-->
	</head>
	
	<body>
		<input type="button" value="Add" class="btn btn-primary" 
		onclick="location.href='${pageContext.request.contextPath}/provinsi/addProvinsi';">
	<table class="table table-dark">
	<thead>
		<tr>
			<th>Kode Provinsi</th>
			<th>Nama Provinsi</th>
			<th>Action</th>
		</tr>
		<c:forEach items="${listprovinsi}" var="lp">
			<tr>
				<td>${lp.kodeProvinsi}</td>
				<td>${lp.namaProvinsi}</td>
				<td>
					<a href="${pageContext.request.contextPath}/provinsi/editProvinsi/${lp.kodeProvinsi}"
					class="btn btn-success">Edit</a>&nbsp;
					<a href="${pageContext.request.contextPath}/provinsi/deleteProvinsi/${lp.kodeProvinsi}"
					class="btn btn-danger"
					onClick="return confirm('Are you sure to delete provinsi number : ${lp.kodeProvinsi} from list?')">Delete</a>
				</td>
			</tr>
		</c:forEach>	
	</thead>
	</table>
	</body>
</html>