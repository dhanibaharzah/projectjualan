<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="f"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>List Barang</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
	integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh"
	crossorigin="anonymous">
</head>
<body>
	<table class="table">
		<thead>
			<tr>
				<th>Kode Barang</th>
				<th>Nama Barang</th>
				<th>Kode Suplier</th>
				<th>Stok Barang</th>
				<th class="text-center">Actions</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${listBarang}" var="b">
				<tr>
					<td>${b.kodeBarang}</td>
					<td>${b.namaBarang}</td>
					<td>${b.kodeSupplier}</td>
					<td>${b.stokBarang}</td>
					<td class="text-center">
						<a href="${pageContext.request.contextPath}/barang/detail/${b.kodeBarang}" class="btn btn-success">Edit</a>&nbsp;
						<a href="${pageContext.request.contextPath}/barang/delete/${b.kodeBarang}" class="btn btn-danger"> Delete</a>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<div class="text-center form-group">
		<a href="${pageContext.request.contextPath}/barang/add" class="btn btn-primary"> Tambah Barang</a>
	</div>
	<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js"
		integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
		integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
		crossorigin="anonymous"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"
		integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6"
		crossorigin="anonymous"></script>
</body>
</html>