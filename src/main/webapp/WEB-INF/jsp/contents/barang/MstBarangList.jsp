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
          <h1 class="m-0 text-dark">Barang</h1>
        </div>
        <div class="col-sm-6">
          <ol class="breadcrumb float-sm-right">
            <li class="breadcrumb-item"><a href="${pageContext.request.contextPath}/dashboard">Dashboard</a></li>
            <li class="breadcrumb-item active">Barang</li>
          </ol>
        </div>
      </div>
    </div><!-- /.container-fluid -->
  </section>
  
  <!-- Main content -->
  <section class="content">

    <div class="card">
      <div class="card-header">
        <a href="${pageContext.request.contextPath}/barang/add">
        	<button class="btn btn-primary"><span class="fas fa-plus"></span> Add</button>
        </a>
      </div>
      <!-- /.card-header -->
      <div class="card-body">
        <table id="example1" class="table table-bordered table-striped">
          <thead>
          <tr>
				<th>Kode Barang</th>
				<th>Nama Barang</th>
				<th>Supplier</th>
				<th>Stok Barang</th>
				<th class="text-center">Actions</th>
          </tr>
          </thead>
          <tbody>
          	<c:forEach items="${listBarang}" var="b">
				<tr>
					<td>${b.kodeBarang}</td>
					<td>${b.namaBarang}</td>
					<td>${b.namaSupplier}</td>
					<td>${b.stokBarang}</td>
					<td class="text-center">
						<a href="${pageContext.request.contextPath}/barang/detail/${b.kodeBarang}" class="btn btn-success"><span class="fas fa-edit"></span></a>&nbsp;
						<a href="${pageContext.request.contextPath}/barang/delete/${b.kodeBarang}" class="btn btn-danger"><span class="fas fa-trash-alt"></span></a>
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