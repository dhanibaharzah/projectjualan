<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!-- Content Wrapper. Contains page content -->
<div class="content-wrapper">
  <!-- Content Header (Page header) -->
  <section class="content-header">
    <div class="container-fluid">
      <div class="row mb-2">
        <div class="col-sm-6">
          <h1 class="m-0 text-dark">Customer</h1>
        </div>
        <div class="col-sm-6">
          <ol class="breadcrumb float-sm-right">
            <li class="breadcrumb-item"><a href="${pageContext.request.contextPath}/dashboard">Dashboard</a></li>
            <li class="breadcrumb-item active">Customer</li>
          </ol>
        </div>
      </div>
    </div><!-- /.container-fluid -->
  </section>
  
  <!-- Main content -->
  <section class="content">

    <div class="card">
      <div class="card-header">
        <a href="${pageContext.request.contextPath}/customer/add">
        	<button class="btn btn-primary"><span class="fas fa-plus"></span> Add</button>
        </a>
      </div>
      <!-- /.card-header -->
      <div class="card-body">
       <table class="table">
		<thead>
			<tr>
				<th>Kode Customer</th>
				<th>Nama Customer</th>
				<th>Alamat</th>
				<th>Jenis Kelamin</th>
				<th>Email</th>
				<th>Kota</th>
				<th class="text-center">Actions</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${listCustomer}" var="b">
				<tr>
					<td>${b.kodeCustomer}</td>
					<td>${b.namaCustomer}</td>
					<td>${b.alamatCustomer}</td>
					<td>${b.jenisKelamin}</td>
					<td>${b.emailCustomer}</td>
					<td>${b.namaKota}</td>
					<td class="text-center">
						<a href="${pageContext.request.contextPath}/customer/detail/${b.kodeCustomer}" class="btn btn-success"><span class="fas fa-edit"></span></a>&nbsp;
						<a href="${pageContext.request.contextPath}/customer/delete/${b.kodeCustomer}" class="btn btn-danger"><span class="fas fa-trash-alt"></span></a>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
      </div>
      <!-- /.card-body -->
    </div>
    <!-- /.card -->

  </section>
  <!-- /.content -->
</div>
<!-- /.content-wrapper -->