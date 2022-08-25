
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width,initial-scale=1">
<title>Customer - Registration Form</title>
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
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script>
	$(document).ready(function() {

		$("input[type=email]").blur(function() {
			var str = $("#val-email").val();
			$.get("UserRegistrationServlet", {
				email : str
			}).done(function(data) {

				if (data == 'true') {
					//alert("This email id is already exist");
					$('#email-error').html("This Email Id Already Exist");
					$(document).ready(function() {
						$("input[type=email]").val('').focus();
					});
				}
			});
		});
	});
</script>
</head>

<body>
	<%
	String msg = (String) request.getAttribute("registermsg");
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
									<form class="form-valide" action="UserRegistrationServlet"
										method="post" enctype="multipart/form-data">
										<%
										if (msg != null) {
										%>
										<h4 style="color: green"><%=msg%></h4>
										<%
										}
										%>
										<div class="form-group row">
											<label class="col-lg-4 col-form-label" for="val-username">Customer
												Name <span class="text-danger">*</span>
											</label>
											<div class="col-lg-6">
												<input type="text" class="form-control uname"
													id="val-username" name="val-username"
													placeholder="Enter a username..">
											</div>
										</div>
										<div class="form-group row">
											<label class="col-lg-4 col-form-label" for="val-email">Email
												<span class="text-danger">*</span>
											</label>
											<div class="col-lg-6">
												<input type="email" class="form-control mail" id="val-email"
													name="val-email" placeholder="Your valid email..">

												<span id="email-error" style="color: red; font-size: 15px;"></span>
											</div>
										</div>

										<div class="form-group row">
											<label class="col-lg-4 col-form-label" for="val-suggestions">Address
												<span class="text-danger">*</span>
											</label>
											<div class="col-lg-6">
												<textarea class="form-control" id="val-suggestions"
													name="address" rows="5"
													placeholder="Enter your full address?" required="required"></textarea>
											</div>
										</div>

										<div class="form-group row">
											<label class="col-lg-4 col-form-label" for="val-suggestions">DOB
												<span class="text-danger">*</span>
											</label>
											
											<div class="col-lg-6">
												<div class="input-group">
													<!-- <input type="text" required="required"
														class="form-control mydatepicker" placeholder="mm/dd/yyyy"
														name="dob"> <span class="input-group-append"><span
														class="input-group-text"><i
															class="mdi mdi-calendar-check"></i></span></span> --> 
															
													<input type="text"
														class="form-control" id="datepicker-autoclose"
														placeholder="mm/dd/yyyy" name="dob" required="required"> <span
														class="input-group-append"><span
														class="input-group-text"><i
															class="mdi mdi-calendar-check"></i></span></span>
												</div>
											</div>
										

										</div>

										<div class="form-group row">
											<label class="col-lg-4 col-form-label" for="val-username">Aadhaar
												Number <span class="text-danger">*</span>
											</label>
											<div class="col-lg-6">
												<input type="text" class="form-control" id="aadhaar"
													name="aadhaar" placeholder="Enter Aadhaar No"
													required="required">
											</div>
										</div>

										<div class="form-group row">
											<label class="col-lg-4 col-form-label" for="val-digits">Phone
												(IND) <span class="text-danger">*</span>
											</label>
											<div class="col-lg-6">
												<input type="text" class="form-control" id="val-digits"
													name="val-digits" maxlength=10 placeholder="90469-96154">


											</div>
										</div>

										<div class="form-group row">
											<label class="col-lg-4 col-form-label" for="val-phoneus">Gender
												<span class="text-danger">*</span>
											</label>
											<div class="col-lg-2">
												<label> <input type="radio" name="gender"
													value="male" required="required"> Male
												</label>
											</div>
											<div class="radio mb-3">
												<label> <input type="radio" name="gender"
													value="female" required="required"> Female
												</label>
											</div>
										</div>

										<div class="form-group row">
											<label class="col-lg-4 col-form-label" for="val-phoneus">Upload
												Image <span class="text-danger">*</span>
											</label>
											<div class="col-lg-2">
												<div class="form-group">
													<input type="file" name="photo" required="required"
														class="form-control-file">
												</div>

											</div>
										</div>
								</div>
								<div class="form-group row">
									<div class="col-lg-8 ml-auto">
										<button type="submit" class="btn btn-primary">Submit</button>
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