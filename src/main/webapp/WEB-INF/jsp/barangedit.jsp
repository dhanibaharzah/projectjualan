
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
<title>Tambah Penduduk</title>
</head>
<body>
	<h1>&nbsp;&nbsp; Tambah Penduduk</h1>
	<form:form method="POST" class="form-horizontal" action="${pageContext.request.contextPath}/barang/save" modelAttribute="dto">
		<div class="form-group">
			<label class="control-label col-sm-2">Kode Barang:</label>
			<div class="col-sm-6">
				<form:input path="kodeBarang" type="text" class="form-control" placeholder="Masukkan kode Barang" readOnly="true" /><form:errors path="kodeBarang"/>
			</div>
		</div>
		<div class="form-group">
			<label class="control-label col-sm-2">Nama Barang:</label>
			<div class="col-sm-6">
				<form:input path="namaBarang" type="text" class="form-control" placeholder="Masukkan Nama Barang" /><form:errors path="namaBarang"/>
			</div>
		</div>
		
		<div class="form-group">
			<label class="control-label col-sm-2">Kode Supplier:</label>
			<div class="col-sm-6">
			<form:input path="kodeSupplier" type="text" class="form-control" placeholder="Masukkan Kode Supplier" /><form:errors path="kodeSupplier"/>
			</div>
		</div>
		<div class="form-group">
			<label class="control-label col-sm-2">Stok Barang:</label>
			<div class="col-sm-6">
			<form:input path="stokBarang" type="number" class="form-control" placeholder="Masukkan Jumlah Stok" /><form:errors path="stokBarang"/>
			</div>
		</div>
		<div class="form-group">
			<div class="col-sm-offset-2 col-sm-10">
				<button type="submit" class="btn btn-success">Submit</button>
				<a href="${pageContext.request.contextPath}/barang/list" class="btn btn-danger"> Cancel</a>
			</div>
		</div>
	</form:form>
</body>
</html>
