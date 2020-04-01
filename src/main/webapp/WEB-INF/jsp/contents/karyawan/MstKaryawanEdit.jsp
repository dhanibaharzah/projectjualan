<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<!-- Content Wrapper. Contains page content -->
<div class="content-wrapper">
  <!-- Content Header (Page header) -->
  <section class="content-header">
    <div class="container-fluid">
      <div class="row mb-2">
        <div class="col-sm-6">
          <h1 class="m-0 text-dark">Karyawan Edit</h1>
        </div>
        <div class="col-sm-6">
          <ol class="breadcrumb float-sm-right">
            <li class="breadcrumb-item"><a href="${pageContext.request.contextPath}/dashboard">Dashboard</a></li>
            <li class="breadcrumb-item"><a href="${pageContext.request.contextPath}/karyawan">Karyawan</a></li>
            <li class="breadcrumb-item active">Edit</li>
          </ol>
        </div>
      </div>
    </div><!-- /.container-fluid -->
  </section>
  
  <!-- Main content -->
  <section class="content">

    <div class="container-fluid">
          <div class="card card-primary">
            <div class="card-header">
               	<!-- <div class="card-tools">
	              <button type="button" class="btn btn-tool" data-card-widget="collapse"><i class="fas fa-minus"></i></button>
	              <button type="button" class="btn btn-tool" data-card-widget="remove"><i class="fas fa-remove"></i></button>
	            </div> -->
            </div>
            <!-- /.card-header -->
            <!-- form start -->
            <form:form method="post" id="quickForm" action="${pageContext.request.contextPath}/karyawan/edit/save" modelAttribute="MstKaryawanDto">
            
              <div class="card-body">
              	<div class="row">
	               <div class="col-md-6">
		             <div class="form-group">
		                  <label>Kode Karyawan</label>
		                  <form:input readonly="true" class="form-control" placeholder="Kode Karyawan" path="kodeKaryawan" required=""/><form:errors path="kodeKaryawan"/>
		                </div>
		                <div class="form-group">
		                  <label>Nama Karyawan</label>
		                  <form:input class="form-control" placeholder="Nama Karyawan" path="namaKaryawan" required=""/><form:errors path="namaKaryawan"/>
		                </div>
		             </div>
		             
		             <div class="col-md-6">
		                <div class="form-group">
		                  <label>Username</label>
		                  <form:input class="form-control" placeholder="Username" path="username" required=""/><form:errors path="username"/>
		                </div>
		                <div class="form-group">
		                  <label>Password</label>
		                  <form:input type="password" class="form-control" placeholder="Password" path="password" required=""/><form:errors path="password"/>
		                </div>
		             </div>
		           </div>
              </div>
              <!-- /.card-body -->
              <div class="card-footer">
                <button type="submit" class="btn btn-success"><span class="fas fa-save"></span> Update</button>
                <a href="${pageContext.request.contextPath}/karyawan">
                	<button type="button" class="btn btn-danger"><span class="fas fa-backspace"></span> Cancel</button>
                </a>
              </div>
            
            </form:form>
          </div>
          <!-- /.card -->
          
    </div><!-- /.container-fluid -->

  </section>
  <!-- /.content -->
</div>
<!-- /.content-wrapper -->