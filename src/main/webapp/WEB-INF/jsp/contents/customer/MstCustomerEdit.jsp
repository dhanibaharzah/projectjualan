<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="content-wrapper">
		<section class="content-header">
	    <div class="container-fluid">
	      <div class="row mb-2">
	        <div class="col-sm-6">
	          <h1 class="m-0 text-dark">Edit Customer</h1>
	        </div>
	        <div class="col-sm-6">
	          <ol class="breadcrumb float-sm-right">
	            <li class="breadcrumb-item"><a href="${pageContext.request.contextPath}/customer">Customer</a></li>
	            <li class="breadcrumb-item active">Edit Customer</li>
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
					action="${pageContext.request.contextPath}/customer/save"
					modelAttribute="dto">
					<div class="card-body">
					<div class="row">
						<div class="col-md-6">

							<div class="form-group">
								<label class="control-label">Kode Customer:</label>
								<form:input path="kodeCustomer" type="text" class="form-control"
									placeholder="Masukkan kode Customer" readonly="true"/>
								<form:errors path="kodeCustomer" />

							</div>

							<div class="form-group">
								<label class="control-label">Nama Customer:</label>
								<form:input path="namaCustomer" type="text" class="form-control"
									placeholder="Masukkan Nama Customer" />
								<form:errors path="namaCustomer" />

							</div>

							<div class="form-group">
								<label class="control-label">Alamat Customer:</label>
								<form:input path="alamatCustomer" type="text"
									class="form-control" placeholder="Masukkan Alamat Customer" />
								<form:errors path="alamatCustomer" />

							</div>
						</div>
						<div class="col-md-6">
							<div class="form-group">
								<label class="control-label">Jenis Kelamin</label>
								<form:select class="form-control" path="jenisKelamin" >
										<form:option value="PRIA">PRIA</form:option>
										<form:option value="WANITA">WANITA</form:option>
								</form:select>
								<form:errors path="jenisKelamin" />

							</div>

							<div class="form-group">
								<label class="control-label">Email:</label>
								<form:input path="emailCustomer" type="text"
									class="form-control" placeholder="Masukkan Email" />
								<form:errors path="emailCustomer" />

							</div>

							<div class="form-group">
								<label class="control-label">Kota:</label>
								<form:select class="form-control" path="kodeKota" >
									<c:forEach items="${listKota}" var="s">
										<form:option value="${s.kodeKota}">${s.namaKota}</form:option>
								</c:forEach>
								</form:select>
								<form:errors path="kodeKota" />

							</div>
						</div>
					</div>
					<div class="form-group">
						<div class="col-sm-offset-2 col-sm-10">
							<button type="submit" class="btn btn-success"><span class="fas fa-save"></span> Save</button>
							<a href="${pageContext.request.contextPath}/customer"
								class="btn btn-danger"><span class="fas fa-backspace"></span> Save</a>
						</div>
					</div>
					</div>
				</form:form>
			</div>
		</div>
	</section>
</div>
