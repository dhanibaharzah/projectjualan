<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="f" %>


<!-- Content Wrapper. Contains page content -->
<div class="content-wrapper">
  <!-- Content Header (Page header) -->
  <section class="content-header">
    <div class="container-fluid">
      <div class="row mb-2">
        <div class="col-sm-6">
          <h1 class="m-0 text-dark">Penjualan</h1>
        </div>
        <div class="col-sm-6">
          <ol class="breadcrumb float-sm-right">
            <li class="breadcrumb-item"><a href="${pageContext.request.contextPath}/dashboard">Dashboard</a></li>
            <li class="breadcrumb-item active">Penjualan</li>
          </ol>
        </div>
      </div>
    </div><!-- /.container-fluid -->
  </section>
  
  <!-- Main content -->
  <section class="content">
  
    <div class="card">
      <div class="card-header">
        <a href="${pageContext.request.contextPath}/penjualan/add">
        	<button class="btn btn-primary"><span class="fas fa-plus"></span> Add</button>
        </a>
      </div>
      <!-- /.card-header -->
      <div class="card-body">
        <table id="example1" class="table table-bordered table-striped">
          <thead>
          <tr>
          	<th>No Nota</th>
			<th>Tanggal Transaksi</th>
			<th>Harga Total</th>
			<th>Nama Customer</th>
			<th>Nama Karyawan</th>
			<th width="100">Action</th>
		  </tr>
		  </thead>
		  <tbody>
		  	<c:forEach items="${TrPenjualan}" var="thp">
		  		<tr>
					<td>${thp.noNota}</td>
					<td><f:formatDate value="${thp.tanggalTransaksi}" pattern="yyyy-MM-dd"/></td>
					<td>${thp.hargaTotal}</td>
					<td>${thp.namaCustomer}</td>
					<td>${thp.namaKaryawan}</td>
					<td align="center">
						<a href="${pageContext.request.contextPath}/headerPenjualan/edit/${thp.noNota}">
							<button class="btn btn-success"><span class="fas fa-edit"></span></button>
						</a>
						<a href="${pageContext.request.contextPath}/headerPenjualan/delete/${thp.noNota}"
						onClick="return confirm('Are you sure to delete penjualan ${thp.noNota} ?')">
							<button class="btn btn-danger"><span class="fas fa-trash-alt"></span></button>
						</a>
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