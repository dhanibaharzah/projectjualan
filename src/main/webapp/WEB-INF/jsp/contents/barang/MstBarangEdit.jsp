<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="content-wrapper">
		<section class="content-header">
	    <div class="container-fluid">
	      <div class="row mb-2">
	        <div class="col-sm-6">
	          <h1 class="m-0 text-dark">Tambah Barang</h1>
	        </div>
	        <div class="col-sm-6">
	          <ol class="breadcrumb float-sm-right">
	            <li class="breadcrumb-item"><a href="${pageContext.request.contextPath}/barang">Barang</a></li>
	            <li class="breadcrumb-item active">Tambah Barang</li>
	          </ol>
	        </div>
	      </div>
	    </div><!-- /.container-fluid -->
	  </section>
	<section class="content">
		<div class="container-fluid">
			<div class="card card-primary">
			<div class="card-header"></div>
				<form:form method="POST" class="form-horizontal"
					action="${pageContext.request.contextPath}/barang/save"
					modelAttribute="dto">
					
				<div class="card-body">
					<div class="row">
						<div class="col-sm-6">
							<div class="form-group">
								<label class="control-label">Kode Barang:</label>
								<form:input path="kodeBarang" type="text" class="form-control"
									placeholder="Masukkan kode Barang" readonly="true"/>
								<form:errors path="kodeBarang" />
							</div>
							<div class="form-group">
								<label class="control-label">Nama Barang:</label>
								<form:input path="namaBarang" type="text" class="form-control"
									placeholder="Masukkan Nama Barang" />
								<form:errors path="namaBarang" />
							</div>
						</div>
						<div class="col-sm-6">
							<div class="form-group">
								<label class="control-label">Supplier:</label>
								<form:select class="form-control" path="kodeSupplier" >
									<c:forEach items="${listSupplier}" var="s">
										<form:option value="${s.kodeSupplier}">${s.namaSupplier}</form:option>
									</c:forEach>
								</form:select>
								<form:errors path="kodeSupplier" />
							</div>
							<div class="form-group">
								<label class="control-label">Stok Barang:</label>
								<form:input path="stokBarang" type="number" class="form-control"
									placeholder="Masukkan Jumlah Stok" />
								<form:errors path="stokBarang" />
							</div>
						</div>
					</div>
					<div class="form-group">
						<div class="col-sm-offset-2 col-sm-10">
							<button type="submit" class="btn btn-success"><span class="fas fa-save"></span> Save</button>
							<a href="${pageContext.request.contextPath}/barang"
								class="btn btn-danger"><span class="fas fa-backspace"></span> Cancel</a>
						</div>
					</div>
					</div>
				</form:form>
				</div>
			</div>
	</section>
</div>


