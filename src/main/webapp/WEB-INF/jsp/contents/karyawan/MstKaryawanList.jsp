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
          <h1 class="m-0 text-dark">Karyawan</h1>
        </div>
        <div class="col-sm-6">
          <ol class="breadcrumb float-sm-right">
            <li class="breadcrumb-item"><a href="${pageContext.request.contextPath}/dashboard">Dashboard</a></li>
            <li class="breadcrumb-item active">Karyawan</li>
          </ol>
        </div>
      </div>
    </div><!-- /.container-fluid -->
  </section>
  
  <!-- Main content -->
  <section class="content">

    <div class="card">
      <div class="card-header">
        <a href="${pageContext.request.contextPath}/karyawan/add">
        	<button class="btn btn-primary"><span class="fas fa-plus"></span> Add</button>
        </a>
      </div>
      <!-- /.card-header -->
      <div class="card-body">
        <table id="example1" class="table table-bordered table-striped">
          <thead>
          <tr>
            <th>Kode Karyawan</th>
            <th>Nama Karyawan</th>
            <th>Username</th>
            <th>Password</th>
            <th width="100">Action</th>
          </tr>
          </thead>
          <tbody>
          	<c:forEach items="${MstKaryawanDto}" var="k">
	          <tr>
	            <td>${k.kodeKaryawan}</td>
	            <td>${k.namaKaryawan}</td>
	            <td>${k.username}</td>
	            <td>******</td>
	            <td align="center">
	            	<a href="${pageContext.request.contextPath}/karyawan/edit/${k.kodeKaryawan}">
			        	<button class="btn btn-success"><span class="fas fa-edit"></span></button>
			        </a>
			        <a href="${pageContext.request.contextPath}/karyawan/delete/${k.kodeKaryawan}" onclick="return confirm('Are you sure delete karyawan ${k.namaKaryawan} ?')">
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