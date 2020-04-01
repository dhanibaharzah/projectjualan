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
          <h1 class="m-0 text-dark">Kota Edit</h1>
        </div>
        <div class="col-sm-6">
          <ol class="breadcrumb float-sm-right">
            <li class="breadcrumb-item"><a href="${pageContext.request.contextPath}/dashboard">Dashboard</a></li>
            <li class="breadcrumb-item"><a href="${pageContext.request.contextPath}/kota">Kota</a></li>
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
            <form:form method="post" id="quickForm" action="${pageContext.request.contextPath}/kota/edit/save" modelAttribute="MstKotaEdit">
            
              <div class="card-body">
              	<div class="row">
	               <div class="col-md-6">
		             <div class="form-group">
		                  <label>Kode Kota</label>
		                  <form:input readonly="true" class="form-control" placeholder="Kode Kota" path="kodeKota" required=""/><form:errors path="kodeKota"/>
		                </div>
		                <div class="form-group">
		                  <label>Nama Kota</label>
		                  <form:input class="form-control" placeholder="Nama Kota" path="namaKota" required=""/><form:errors path="namaKota"/>
		                </div>
		             </div>
		             
		             <div class="col-md-6">
		                <div class="form-group">
		                  <label>Nama Provinsi</label>
		                  <form:select class="form-control" path="kodeProvinsi" id="kodeProvinsiDat">
		                  		<c:forEach items="${listprovinsi}" var="listprov">
									<form:option value="${listprov.kodeProvinsi}"><c:if test="${listprov.kodeProvinsi == MstKotaEdit.kodeProvinsi}"></c:if>${listprov.namaProvinsi}</form:option>
								</c:forEach>
		                  </form:select>
		                </div>
		             </div>
		           </div>
              </div>
              <!-- /.card-body -->
              <div class="card-footer">
                <button type="submit" class="btn btn-success"><span class="fas fa-save"></span> Save</button>
                <a href="${pageContext.request.contextPath}/kota">
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