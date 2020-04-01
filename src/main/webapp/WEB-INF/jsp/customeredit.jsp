<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<title>Tambah Customer</title>
</head>
<body>
	<h1>&nbsp;&nbsp; Tambah Customer</h1>
	<form:form method="POST" class="form-horizontal" action="${pageContext.request.contextPath}/customer/save" modelAttribute="dto">
		<div class="form-group">
			<label class="control-label col-sm-2">Kode Customer:</label>
			<div class="col-sm-6">
				<form:input path="kodeCustomer" type="text" class="form-control" placeholder="Masukkan kode Customer" readonly="true" /><form:errors path="kodeCustomer"/>
			</div>
		</div>
		
		<div class="form-group">
			<label class="control-label col-sm-2">Nama Customer:</label>
			<div class="col-sm-6">
				<form:input path="namaCustomer" type="text" class="form-control" placeholder="Masukkan Nama Customer" /><form:errors path="namaCustomer"/>
			</div>
		</div>
		
		<div class="form-group">
			<label class="control-label col-sm-2">Alamat Customer:</label>
			<div class="col-sm-6">
			<form:input path="alamatCustomer" type="text" class="form-control" placeholder="Masukkan Alamat Customer" /><form:errors path="alamatCustomer"/>
			</div>
		</div>
		
		<div class="form-group">
			<label class="control-label col-sm-2">Jenis Kelamin</label>
			<div class="col-sm-6">
			<form:input path="jenisKelamin" type="text" class="form-control" placeholder="Masukkan Jenis Kelamin" /><form:errors path="jenisKelamin"/>
			</div>
		</div>
		
		<div class="form-group">
			<label class="control-label col-sm-2">Email:</label>
			<div class="col-sm-6">
			<form:input path="emailCustomer" type="text" class="form-control" placeholder="Masukkan Email" /><form:errors path="emailCustomer"/>
			</div>
		</div>
		
		<div class="form-group">
			<label class="control-label col-sm-2">Kota:</label>
			<div class="col-sm-6">
			<form:input path="kodeKota" type="text" class="form-control" placeholder="Pilih Kode Kota" /><form:errors path="kodeKota"/>
			</div>
		</div>
		
		<div class="form-group">
			<div class="col-sm-offset-2 col-sm-10">
				<button type="submit" class="btn btn-success">Submit</button>
				<a href="${pageContext.request.contextPath}/customer/list" class="btn btn-danger"> Cancel</a>
			</div>
		</div>
	</form:form>
</body>
</html>
