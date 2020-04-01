<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!-- Navbar -->
<nav class="main-header navbar navbar-expand navbar-white navbar-light">
  <!-- Left navbar links -->
  <ul class="navbar-nav">
    <li class="nav-item">
      <a class="nav-link" data-widget="pushmenu" href="#"><i class="fas fa-bars"></i></a>
    </li>
  </ul>

  <!-- Right navbar links -->
  <ul class="navbar-nav ml-auto">
    <li class="nav-item dropdown user-menu">
      <a href="#" class="nav-link dropdown-toggle" data-toggle="dropdown">
        <img src="<c:url value="/resources-lte/dist/img/avatar5.png" />" class="user-image img-circle elevation-2" alt="User Image">
        <span class="d-none d-md-inline"><%=session.getAttribute("namaKaryawan")%></span>
      </a>
      <ul class="dropdown-menu dropdown-menu-lg dropdown-menu-right">
        <!-- User image -->
        <li class="user-header bg-primary">
          <img src="<c:url value="/resources-lte/dist/img/avatar5.png" />" class="img-circle elevation-2" alt="User Image">

          <p>
            <%=session.getAttribute("namaKaryawan")%>
          </p>
        </li>
        <!-- Menu Footer-->
        <li class="user-footer">
          <!-- <a href="#" class="btn btn-default btn-flat">Profile</a> -->
          <a href="${pageContext.request.contextPath}/logout" class="btn btn-default btn-flat float-right">Sign out</a>
        </li>
      </ul>
    </li>
  </ul>
</nav>
<!-- /.navbar -->