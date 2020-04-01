<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ page import="java.io.PrintWriter"%>
<%
if ((session.getAttribute("kodeKaryawan") == null) || (session.getAttribute("kodeKaryawan") == "")) {
    PrintWriter alt = response.getWriter();
    alt.println("<script type=\"text/javascript\">");
    alt.println("alert('Access denied ! You must login first.');");
    alt.println("location='"+ application.getContextPath() +"/login';");
    alt.println("</script>");
}
%>

<!DOCTYPE html>
<html lang="en">
  	<head>
  		<meta charset="utf-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<title><tiles:getAsString name="title"/></title>
		<!-- Tell the browser to be responsive to screen width -->
		<meta name="viewport" content="width=device-width, initial-scale=1">
		
		<!-- Font Awesome -->
		<link rel="stylesheet" href="<c:url value="/resources-lte/plugins/fontawesome-free/css/all.min.css" />">
		<!-- Ionicons -->
		<link rel="stylesheet" href="https://code.ionicframework.com/ionicons/2.0.1/css/ionicons.min.css">
		<!-- Tempusdominus Bbootstrap 4 -->
		<link rel="stylesheet" href="<c:url value="/resources-lte/plugins/tempusdominus-bootstrap-4/css/tempusdominus-bootstrap-4.min.css" />">
		<!-- Theme style -->
		<link rel="stylesheet" href="<c:url value="/resources-lte/dist/css/adminlte.min.css" />">
		<!-- DataTables -->
		<link rel="stylesheet" href="<c:url value="/resources-lte/plugins/datatables-bs4/css/dataTables.bootstrap4.css" />">
		<!-- overlayScrollbars -->
		<link rel="stylesheet" href="<c:url value="/resources-lte/plugins/overlayScrollbars/css/OverlayScrollbars.min.css" />">
		<!-- Daterange picker -->
		<link rel="stylesheet" href="<c:url value="/resources-lte/plugins/daterangepicker/daterangepicker.css" />">
		<!-- bootstrap datepicker -->
		<link rel="stylesheet" href="<c:url value="/resources-lte/plugins/bootstrap-datepicker/css/bootstrap-datepicker.min.css" />">
		<!-- Select2 -->
		<link rel="stylesheet" href="<c:url value="/resources-lte/plugins/select2/css/select2.min.css" />">
		<link rel="stylesheet" href="<c:url value="/resources-lte/plugins/select2-bootstrap4-theme/select2-bootstrap4.min.css" />">
		<!-- Google Font: Source Sans Pro -->
		<link href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,400i,700" rel="stylesheet">
  	</head>

  	<body class="hold-transition sidebar-mini layout-fixed">
		<div class="wrapper">
			
			<tiles:insertAttribute name="topnav"/>
			<tiles:insertAttribute name="sidebar"/>
			<tiles:insertAttribute name="content"/>
			<tiles:insertAttribute name="footer"/>
			
		</div>
		<!-- ./wrapper -->
		
		<!-- jQuery -->
		<script src="<c:url value="/resources-lte/plugins/jquery/jquery.min.js" />"></script>
		<!-- jQuery UI 1.11.4 -->
		<script src="plugins/jquery-ui/jquery-ui.min.js"></script>
		<!-- Resolve conflict in jQuery UI tooltip with Bootstrap tooltip -->
		<script>
		  $.widget.bridge('uibutton', $.ui.button)
		</script>
		<!-- Bootstrap 4 -->
		<script src="<c:url value="/resources-lte/plugins/bootstrap/js/bootstrap.bundle.min.js" />"></script>
		<!-- Select2 -->
		<script src="<c:url value="/resources-lte/plugins/select2/js/select2.full.min.js" />"></script>
		<!-- daterangepicker -->
		<script src="<c:url value="/resources-lte/plugins/moment/moment.min.js" />"></script>
		<script src="<c:url value="/resources-lte/plugins/daterangepicker/daterangepicker.js" />"></script>
		<!-- Tempusdominus Bootstrap 4 -->
		<script src="<c:url value="/resources-lte/plugins/tempusdominus-bootstrap-4/js/tempusdominus-bootstrap-4.min.js" />"></script>
		<!-- overlayScrollbars -->
		<script src="<c:url value="/resources-lte/plugins/overlayScrollbars/js/jquery.overlayScrollbars.min.js" />"></script>
		<!-- AdminLTE App -->
		<script src="<c:url value="/resources-lte/dist/js/adminlte.js" />"></script>
		<!-- AdminLTE dashboard demo (This is only for demo purposes) -->
		<script src="<c:url value="/resources-lte/dist/js/pages/dashboard.js" />"></script>
		<!-- AdminLTE for demo purposes -->
		<script src="<c:url value="/resources-lte/dist/js/demo.js" />"></script>
		<!-- DataTables -->
		<script src="<c:url value="/resources-lte/plugins/datatables/jquery.dataTables.js" />"></script>
		<script src="<c:url value="/resources-lte/plugins/datatables-bs4/js/dataTables.bootstrap4.js" />"></script>
		<!-- InputMask -->
		<script src="<c:url value="/resources-lte/plugins/moment/moment.min.js" />"></script>
		<script src="<c:url value="/resources-lte/plugins/inputmask/min/jquery.inputmask.bundle.min.js" />"></script>
		<!-- Bootstrap Switch -->
		<script src="<c:url value="/resources-lte/plugins/bootstrap-switch/js/bootstrap-switch.min.js" />"></script>
		<!-- bootstrap datepicker -->
		<script src="<c:url value="/resources-lte/plugins/bootstrap-datepicker/js/bootstrap-datepicker.min.js" />"></script>
		
		<!-- page script -->
		<script>
		  $(function () {
			  
		    $("#example1").DataTable();
		    $('#example2').DataTable({
		      "paging": true,
		      "lengthChange": false,
		      "searching": false,
		      "ordering": true,
		      "info": true,
		      "autoWidth": false,
		    });
		    
		    //Initialize Select2 Elements
		    $('.select2').select2()

		    //Initialize Select2 Elements
		    $('.select2bs4').select2({
		      theme: 'bootstrap4'
		    })
		    
		    //Date picker
			$('#datepicker').datepicker({
				dateFormat: 'yyyy-mm-dd',
				autoclose: true
			})
		  });
		</script>
    
  	</body>
</html>