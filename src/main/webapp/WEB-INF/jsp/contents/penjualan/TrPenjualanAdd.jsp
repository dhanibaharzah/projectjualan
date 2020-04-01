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
          <h1 class="m-0 text-dark">Penjualan Add</h1>
        </div>
        <div class="col-sm-6">
          <ol class="breadcrumb float-sm-right">
            <li class="breadcrumb-item"><a href="${pageContext.request.contextPath}/dashboard">Dashboard</a></li>
            <li class="breadcrumb-item"><a href="${pageContext.request.contextPath}/penjualan">Penjualan</a></li>
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
            <form:form method="post" id="quickForm" action="${pageContext.request.contextPath}/penjualan/add/save" modelAttribute="TrPenjualanAdd">
            
              <div class="card-body">
              	<div class="row">
	               <div class="col-md-6">
		             <div class="form-group">
		                  <label>No Nota</label>
		                  <form:input class="form-control" placeholder="Kode Karyawan" path="noNota" required=""/><form:errors path="noNota"/>
		                </div>
		                <div class="form-group">
		                  <label>Tanggal Transaksi</label>
		                  <div class="input-group">
		                    <div class="input-group-prepend">
		                      <span class="input-group-text">
		                        <i class="far fa-calendar-alt"></i>
		                      </span>
		                    </div>
		                    <form:input class="form-control float-right" id="datepicker" path="tanggalTransaksi" required=""/><form:errors path="tanggalTransaksi"/>
		                  </div>
		                </div>
		             </div>
		             
		             <div class="col-md-6">
		                <div class="form-group">
		                  <label>Karyawan</label>
		                  <form:input readonly="true" class="form-control" path="namaKaryawan" required=""/><form:errors path="namaKaryawan"/>
		                </div>
		             </div>
		           </div>
              </div>
              <!-- /.card-body -->
              <div class="card-footer">
                <button type="submit" class="btn btn-success"><span class="fas fa-save"></span> Save</button>
                <a href="${pageContext.request.contextPath}/penjualan">
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