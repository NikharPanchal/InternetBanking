
<!DOCTYPE html>
<%@page import="com.internetbanking.bean.Account"%>
<%@page import="com.internetbanking.bean.Customer"%>
<%@page import="java.util.List"%>
<html lang="en">

<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width,initial-scale=1">
<title>Open Customer Account</title>
<!-- Favicon icon -->
<link rel="icon" type="image/png" sizes="16x16"
	href="images/favicon.png">

<!-- Custom Stylesheet -->
<link href="css/style.css" rel="stylesheet">
<link
	href="./plugins/bootstrap-material-datetimepicker/css/bootstrap-material-datetimepicker.css"
	rel="stylesheet">
<!-- Page plugins css -->
<link href="./plugins/clockpicker/dist/jquery-clockpicker.min.css"
	rel="stylesheet">
<!-- Color picker plugins css -->
<link href="./plugins/jquery-asColorPicker-master/css/asColorPicker.css"
	rel="stylesheet">
<!-- Date picker plugins css -->
<link href="./plugins/bootstrap-datepicker/bootstrap-datepicker.min.css"
	rel="stylesheet">
<!-- Daterange picker plugins css -->
<link href="./plugins/timepicker/bootstrap-timepicker.min.css"
	rel="stylesheet">
<link href="./plugins/bootstrap-daterangepicker/daterangepicker.css"
	rel="stylesheet">

</head>
<jsp:include page="/FetchRegisterUserDetails"/>
<jsp:include page="/FetchOpenedAccountDetails"/>
<%List<Customer> custoList=(List)request.getAttribute("customerList"); 
String str=(String)request.getAttribute("accountstatus");
List<Account> accountList=(List)request.getAttribute("accountList");
%>
<body>

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

		<jsp:include page="header.jsp"/>
		<!--**********************************
            Sidebar start
        ***********************************-->
		<jsp:include page="sidebar.jsp"></jsp:include>
		<!--**********************************
            Sidebar end
        ***********************************-->

		<!--**********************************
            Content body start
        ***********************************-->
		<div class="content-body">

			<div class="row page-titles mx-0">
				<div class="col p-md-0">
					<ol class="breadcrumb">

					</ol>
				</div>
			</div>
			<!-- row -->

			<div class="container-fluid">
				<div class="row justify-content-center">
					<div class="col-lg-12">
						<div class="card">
							<div class="card-body">
								<div class="form-validation">
									<%if(str!=null){ %>
										<%int result=(int)request.getAttribute("result"); %>
										<%if(result>0){ %>
											<h3 style="color :green; text-align: center; "><%=str %></h3>
										<%}else{ %>
											<h3 style="color :red; text-align: center; "><%=str %></h3>
										<%} %>
									<%}%>
									<form class="form-valide" action="OpenUserAccount" method="post">
									
										<div class="form-group row">
											<label class="col-lg-4 col-form-label" for="val-skill">Select
												User <span class="text-danger">*</span>
											</label>
											<div class="col-lg-6">
												<select class="form-control" id="val-skill" name="val-custname">
													<%for(Customer c:custoList){ %>
														
														<%if(c.getStatus()==1){ %>
														<option value="<%=c.getCust_id()%>"><%=c.getCust_name() %></option>
														<%} %>
													
													<%}%>
												</select>
											</div>

										</div>
										<div class="form-group row">
											<label class="col-lg-4 col-form-label" for="val-skill">Select
												Account Type <span class="text-danger">*</span>
											</label>
											<div class="col-lg-6">
												<select class="form-control" id="val-skill" name="val-accounttype" required="required">

													<option value="Saving Account">Saving Account</option>
													<option value="Current Account">Current Account</option>
												</select>
											</div>

											
										</div>
										
										<div class="form-group row">
											<label class="col-lg-4 col-form-label" for="val-phoneus">Open Amount<span class="text-danger">*</span>
											</label>
											<div class="col-lg-6">
												<input type="text" class="form-control" id="val-digits"
													name="val-digits" placeholder="Enter Opening Amount" required="required">
											</div>
										</div>
										
								</div>
								
							</div>
							<div class="form-group row">
								<div class="col-lg-8 ml-auto">
									<input type="submit" value="Open Account" class="btn btn-primary">
								</div>
							</div>
							</form>
						</div>
					</div>
				</div>
			</div>
		</div>
		<!-- #/ container -->
	</div>
	<!--**********************************
            Content body end
        ***********************************-->


	<!--**********************************
            Footer start
        ***********************************-->

	<!--**********************************
            Footer end
        ***********************************-->
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

	<script src="./plugins/validation/jquery.validate.min.js"></script>
	<script src="./plugins/validation/jquery.validate-init.js"></script>

</body>

</html>