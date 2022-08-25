
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="widt h=device-width,initial-scale=1">
<title>Customer - InternetBanking Form</title>
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
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
 <script>
	$(document).ready(function() {

		$("#aadhaar").blur(function() {
			var str = $("#aadhaar").val();
			$.get("NetBankingRegistrationServlet", {
				aadhar : str
			}).done(function(data) {

				if (data == 'false') {
					$('#aadhar-error').html("This Aadhar-no did not match");
					document.getElementById("Submit").disabled = true;
				}else
					{
						$('#aadhar-error').html("");
						document.getElementById("Submit").disabled = false;
					}
			});
		});
		
		$("#account").blur(function() {
			var str = $("#account").val();
			$.get("NetBankingRegistrationServlet", {
				account : str
			}).done(function(data) {

				if (data == 'false') {
					$('#account-error').html("This Account-no did not match");
					document.getElementById("Submit").disabled = true;
				}else
					{
					$('#account-error').html("");
					document.getElementById("Submit").disabled = false;
					}
			});
		});
	});
</script>
</head>

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
<%String msg=(String)request.getAttribute("loginfailed"); %>
			<div class="container-fluid">
				<div class="row justify-content-center">
					<div class="col-lg-12">
						<div class="card">
							<div class="card-body">
								<div class="form-validation">
									<form class="form-valide" action="NetBankingRegistrationServlet" method="post">
										<%if(msg!=null){ %>
									 			<h3 style="color: green; text-align: center;"><%=msg %></h3>
										<%} %>
										<!-- <div class="form-group row">
											<label class="col-lg-4 col-form-label" for="val-username">Customer
												Name <span class="text-danger">*</span>
											</label>
											<div class="col-lg-6">
												<input type="text" class="form-control uname" id="val-username"
													name="val-username" placeholder="Enter a username..">
											</div>
										</div> -->
										<div class="form-group row">
											<label class="col-lg-4 col-form-label" for="val-email">Email
												<span class="text-danger">*</span>
											</label>
											<div class="col-lg-6">
												<input type="email" class="form-control mail" id="val-email"
													name="val-email" placeholder="Your valid email..">
											
											</div>										
										</div>

										<div class="form-group row">
											<label class="col-lg-4 col-form-label" for="val-username">Aadhaar
												Number <span class="text-danger">*</span>
											</label>
											<div class="col-lg-6">
												<input type="text" class="form-control" id="aadhaar"
													name="val-digits-aadhaar" placeholder="Enter Aadhaar No" required="required">
												<span id="aadhar-error" style="color:red; font-size: 10px;"></span>
											</div>
										</div>

										<div class="form-group row">
											<label class="col-lg-4 col-form-label" for="val-phoneus">Phone
												(IND) <span class="text-danger">*</span>
											</label>
											<div class="col-lg-6">
												<input type="text" class="form-control" id="val-digits"
													name="val-digits" maxlength=10 placeholder="90469-96154" required="required">
											</div>
										</div>
										
										<div class="form-group row">
											<label class="col-lg-4 col-form-label" for="val-username">Account
												Number <span class="text-danger">*</span>
											</label>
											<div class="col-lg-6">
												<input type="text" class="form-control" id="account"
													name="val-digits-account" maxlength=8 placeholder="Enter Account No" required="required">
											<span id="account-error" style="color:red; font-size: 10px;"></span>
											</div>
										</div>
										
										<div class="form-group row">
											<label class="col-lg-4 col-form-label" for="val-password">Password <span class="text-danger">*</span>
											</label>
											<div class="col-lg-6">
												<input type="password" class="form-control uname" id="val-password"
													name="val-password" placeholder="Enter a password..">
											</div>
										</div>
										
										  <div class="form-group row">
                                            <label class="col-lg-4 col-form-label" for="val-confirm-password">Confirm Password <span class="text-danger">*</span>
                                            </label>
                                            <div class="col-lg-6">
                                                <input type="password" class="form-control" id="val-confirm-password" name="val-confirm-password" placeholder="..and confirm it!">
                                            </div>
                                        </div>
							
										
								</div>
								<div class="form-group row">
									<div class="col-lg-8 ml-auto">
										<button type="submit" id="Submit" class="btn btn-primary">Submit</button>
									</div>
								</div>
								</form>
							</div>
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