<%@page import="com.internetbanking.bean.Customer"%>
<%@page import="java.util.List"%>
<%@page import="com.internetbanking.bean.NetBanking"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width,initial-scale=1">
<title>Customer List</title>
<!-- Favicon icon -->
<link rel="icon" type="image/png" sizes="16x16"
	href="images/favicon.png">
<!-- Custom Stylesheet -->
<link
	href="./plugins/tables/css/datatable/dataTables.bootstrap4.min.css"
	rel="stylesheet">
<script type="text/javascript">
	
	function getid(customerid){
		var cid=customerid;
		var link="DeleteCustomerDetails?id="+cid;
		document.getElementById("acceptid").setAttribute("href",link);
	}
</script>
<link href="css/style.css" rel="stylesheet">
</head>
<body>
	<jsp:include page="/FetchRegisterUserDetails" />
	<%
	List<Customer> customerList = (List) request.getAttribute("customerList");
	%>
	<!--*******************
        Preloader start
    ********************-->
	<div id="preloader">
		<div class="loader">
			<svg class="circular" viewBox="25 25 50 50">
                <circle class="path" cx="50" cy="50" r="20" fill="none"
					stroke-width="3" stroke-miterlimit="10" />
            </svg>
		</div>
	</div>
	<!--*******************
        Preloader end
    ********************-->


	<!--**********************************
        Main wrapper start
    ***********************************-->
	<div id="main-wrapper">

		<jsp:include page="header.jsp" />

		<!--**********************************
            Header end ti-comment-alt
        ***********************************-->
		<jsp:include page="sidebar.jsp" />

		<!--**********************************
            Content body start
        ***********************************-->
		<div class="content-body">

			<div class="row page-titles mx-0">
				<div class="col p-md-0">
					<ol class="breadcrumb">
						<li class="breadcrumb-item"><a href="">Customer List</a></li>
						<li class="breadcrumb-item active"><a href="index.jsp">Home</a></li>
					</ol>
				</div>
			</div>
			<!-- row -->

			<div class="container-fluid">
				<div class="row">
					<div class="col-12">
						<div class="card">
							<div class="card-body">
								<h4 class="card-title">Data Table</h4>
								<div class="table-responsive">
									<table
										class="table table-striped table-bordered zero-configuration">
										<thead>
											<tr>
												<th>Id</th>
												<th>Name</th>
												<th>Email</th>
												<th>Address</th>
												<th>DOB</th>
												<th>Aadhaar No</th>
												<th>Contact No</th>
												<th>Gender</th>
												<th>Image</th>
												<th>Status</th>
												<th>Delete</th>
											</tr>
										</thead>
										<tbody>
											<%
											for (Customer c : customerList) {
											%>
											<tr>
												<td><%=c.getCust_id()%></td>
												<td><%=c.getCust_name()%></td>
												<td><%=c.getEmail()%>
												<td><%=c.getAddress()%></td>
												<td><%=c.getDob()%></td>
												<td><%=c.getAadharno()%></td>
												<td><%=c.getPhoneno()%></td>
												<td><%=c.getGender()%></td>
												<td><img height="70px" width="70px" src="data:image/png;base64,<%=c.getImage_string()%>"></td>
												<%if(c.getStatus()==1){ %>
												<td>Active</td>
												<%}else{ %>
												<td>Not Active</td>
												<%} %>
												<td><a data-toggle="modal" data-target="#exampleModalCenter" onclick="getid(<%=c.getCust_id()%>);"><i class="fa fa-trash" aria-hidden="true" style="color: red; cursor: pointer; font-size: 25px;"></i></a></td>
											</tr>
											<%}%>


											<!-- Modal -->
											<div class="modal fade" id="exampleModalCenter">
												<div class="modal-dialog modal-dialog-centered"
													role="document">
													<div class="modal-content">
														<div class="modal-header">
															<h5 class="modal-title">Are You Sure Want To Delete</h5>
															<button type="button" class="close" data-dismiss="modal">
																<span>&times;</span>
															</button>
														</div>
														<div class="modal-body">
															<p>Delete Customer</p>
														</div>
														<div class="modal-footer">
															<button type="button" class="btn btn-secondary"
																data-dismiss="modal">Close</button>
															<button type="button" class="btn btn-primary">
																<a id="acceptid" style="color: black;">Delete</a></button>
														</div>
													</div>
												</div>
											</div>
										</tbody>

									</table>
								</div>
							</div>
						</div>
					</div>
				</div>

			</div>



		</div>




	</div>
	<!--**********************************
        Main wrapper end
    ***********************************-->

	<!--**********************************
        Scripts
    ***********************************-->
	<script src="plugins/common/common.min.js"></script>
	<script src="js/custom.min.js"></script>
	<script src="js/settings.js"></script>
	<script src="js/gleek.js"></script>
	<script src="js/styleSwitcher.js"></script>

	<script src="./plugins/tables/js/jquery.dataTables.min.js"></script>
	<script
		src="./plugins/tables/js/datatable/dataTables.bootstrap4.min.js"></script>
	<script src="./plugins/tables/js/datatable-init/datatable-basic.min.js"></script>


</body>

</html>