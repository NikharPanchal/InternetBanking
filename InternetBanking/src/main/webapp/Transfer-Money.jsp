
<!DOCTYPE html>
<%@page import="com.internetbanking.bean.NetBanking"%>
<%@page import="com.internetbanking.bean.Customer"%>
<%@page import="java.util.List"%>
<html lang="en">

<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width,initial-scale=1">
<title>Transfer-Money</title>
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

		$("#account").blur(function() {
			var str = $("#account").val();
			var loginAccountNo= $("#val-digits-from-account").val();
			//alert(str);
			$.get("NetBankingRegistrationServlet", 
			{
				accountNetBanking : str,
				loginAccountNo : loginAccountNo
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
<jsp:include page="/FetchRegisterUserDetails"/>
<%List<Customer> custoList=(List)request.getAttribute("customerList"); 

HttpSession httpsession=request.getSession(false);
NetBanking netbanking=(NetBanking)httpsession.getAttribute("loginDetails");
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
								<%String str=(String)request.getAttribute("trasactionStatus"); %>
									<%if(str!=null){ %>
										
											<h3 style="color :green; text-align: center; "><%=str %></h3>
										<%} %>
									
									<form class="form-valide" action="TransferMoneyServlet" method="post">
									
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
											
											<input type="hidden" id="val-digits-from-account" name="val-digits-from-account" value="<%=netbanking.getAccount_no()%>">		
										
										<div class="form-group row">
											<label class="col-lg-4 col-form-label" for="val-phoneus">Enter Amount for transfer<span class="text-danger">*</span>
											</label>
											<div class="col-lg-6">
												<input type="text" class="form-control" id="val-digits"
													name="val-digits-amount" placeholder="Enter Amount" required="required">
											</div>
										</div>
										
										 <div class="form-group row">
                                            <label class="col-lg-4 col-form-label"><a href="#">Terms &amp; Conditions</a>  <span class="text-danger">*</span>
                                            </label>
                                            <div class="col-lg-8">
                                                <label class="css-control css-control-primary css-checkbox" for="val-terms">
                                                    <input type="checkbox" class="css-control-input" id="val-terms" name="val-terms" value="1"> <span class="css-control-indicator"></span> I agree to the terms</label>
                                            </div>
                                        </div>
										
								</div>
								
							</div>
							<div class="form-group row">
								<div class="col-lg-8 ml-auto">
									<input type="submit" value="Transfer Money" id="Submit" class="btn btn-primary">
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