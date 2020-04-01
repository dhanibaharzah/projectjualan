<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!-- Content Wrapper. Contains page content -->
<div class="content-wrapper">
  <!-- Content Header (Page header) -->
  <section class="content-header">
    <div class="container-fluid">
      <div class="row mb-2">
        <div class="col-sm-6">
          <h1 class="m-0 text-dark">Supplier Add</h1>
        </div>
        <div class="col-sm-6">
          <ol class="breadcrumb float-sm-right">
            <li class="breadcrumb-item"><a href="${pageContext.request.contextPath}/dashboard">Dashboard</a></li>
            <li class="breadcrumb-item"><a href="${pageContext.request.contextPath}/supplier">Supplier</a></li>
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
            <form:form method="post" id="quickForm" action="${pageContext.request.contextPath}/supplier/add/save" modelAttribute="MstSupplierAdd">
            
              <div class="card-body">
              	<div class="row">
	               <div class="col-md-6">
		             	<div class="form-group">
		                  <label>Kode Supplier</label>
		                  <form:input class="form-control" placeholder="Kode Supplier" path="kodeSupplier" required=""/><form:errors path="kodeSupplier"/>
		                </div>
		                <div class="form-group">
		                  <label>Nama Supplier</label>
		                  <form:input class="form-control" placeholder="Nama Supplier" path="namaSupplier" required=""/><form:errors path="namaSupplier"/>
		                </div>
		                <div class="form-group">
		                  <label>Alamat Supplier</label>
		                  <form:input class="form-control" placeholder="Alamat Supplier" path="alamatSupplier" required=""/><form:errors path="alamatSupplier"/>
		                </div>
		           </div>
		             
		             <div class="col-md-6">
		             	<div class="form-group">
		                  <label>No. Telp Supplier</label>
		                  <form:input class="form-control" placeholder="No. Telp Supplier" path="telpSupplier" required=""/><form:errors path="telpSupplier"/>
		                </div>
		                <div class="form-group">
		                  <label>Email Supplier</label>
		                  <form:input class="form-control" placeholder="Email Supplier" path="emailSupplier" required=""/><form:errors path="emailSupplier"/>
		                </div>
		                <div class="form-group">
		                  <label>Nama Kota</label>
		                  	<form:select class="form-control" path="kodeKota" id="kodeKotaDat">
								<c:forEach items="${listkota}" var="listkota">
									<form:option value="${listkota.kodeKota}">${listkota.namaKota}</form:option>
								</c:forEach>
							</form:select>
		                </div>
		             </div>
		           </div>
              </div>
              <!-- /.card-body -->
              <div class="card-footer">
                <button type="submit" class="btn btn-success"><span class="fas fa-save"></span> Save</button>
                <a href="${pageContext.request.contextPath}/supplier">
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