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
          <h1 class="m-0 text-dark">Provinsi Add</h1>
        </div>
        <div class="col-sm-6">
          <ol class="breadcrumb float-sm-right">
            <li class="breadcrumb-item"><a href="${pageContext.request.contextPath}/dashboard">Dashboard</a></li>
            <li class="breadcrumb-item"><a href="${pageContext.request.contextPath}/provinsi">Provinsi</a></li>
            <li class="breadcrumb-item active">Add</li>
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
            <form:form method="post" id="quickForm" action="${pageContext.request.contextPath}/provinsi/add/save" modelAttribute="MstProvinsiAdd">
            
              <div class="card-body">
              	<div class="row">
	               <div class="col-md-6">
		             <div class="form-group">
		                  <label>Kode Provinsi</label>
		                  <form:input class="form-control" placeholder="Kode Provinsi" path="kodeProvinsi" required=""/><form:errors path="kodeProvinsi"/>
		                </div>
		                <div class="form-group">
		                  <label>Nama Provinsi</label>
		                  <form:input class="form-control" placeholder="Nama Provinsi" path="namaProvinsi" required=""/><form:errors path="namaProvinsi"/>
		                </div>
		             </div>
		           </div>
              </div>
              <!-- /.card-body -->
              <div class="card-footer">
                <button type="submit" class="btn btn-success"><span class="fas fa-save"></span> Save</button>
                <a href="${pageContext.request.contextPath}/provinsi">
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