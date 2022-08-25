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
    <title>Customer Profile </title>
    <!-- Favicon icon -->
    <link rel="icon" type="image/png" sizes="16x16" href="images/favicon.png">
    <!-- Custom Stylesheet -->
    <link href="css/style.css" rel="stylesheet">

</head>

<body>
<jsp:include page="/FetchRegisterUserDetails"/>

<%HttpSession httpsession=request.getSession(false);
NetBanking netbanking=(NetBanking)httpsession.getAttribute("loginDetails");
List<Customer> customerList=(List)request.getAttribute("customerList");
String msg=(String)request.getAttribute("customerUpdate");
%>
    <!--*******************
        Preloader start
    ********************-->
    <div id="preloader">
        <div class="loader">
            <svg class="circular" viewBox="25 25 50 50">
                <circle class="path" cx="50" cy="50" r="20" fill="none" stroke-width="3" stroke-miterlimit="10" />
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
            Header end ti-comment-alt
        ***********************************-->
		<jsp:include page="sidebar.jsp"/>

        <!--**********************************
            Content body start
        ***********************************-->
        <div class="content-body">

            <div class="row page-titles mx-0">
                <div class="col p-md-0">
                    <ol class="breadcrumb">
                        <li class="breadcrumb-item"><a href="Profile.jsp">Profile</a></li>
                        <li class="breadcrumb-item active"><a href="javascript:void(0)">Home</a></li>
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
									<form class="form-valide" action="UpdateCustomerProfile" method="post" enctype="multipart/form-data">
										<%if(msg!=null){ %>
											<h3 style="color :green; text-align: center; "><%=msg %></h3>
										<%}%>
										<div class="form-group row">
											<label class="col-lg-4 col-form-label" for="val-username">Customer
												Name <span class="text-danger">*</span>
											</label>
											<div class="col-lg-6">
											<%for(Customer c:customerList){ %>
											<%if(c.getAadharno().equals(netbanking.getAadhar_no())){ %>
												
												<input type="hidden" value=<%=c.getCust_id() %> name="custId">
											
												<input type="text" class="form-control uname" id="val-username"
													name="val-username" value="<%=c.getCust_name() %>" placeholder="Enter a username..">
											<%}} %>
											</div>
										</div>
										<div class="form-group row">
											<label class="col-lg-4 col-form-label" for="val-email">Email
												<span class="text-danger">*</span>
											</label>
											<div class="col-lg-6">
											<%for(Customer c:customerList){ %>
											<%if(c.getAadharno().equals(netbanking.getAadhar_no())){ %>
												<input type="email" class="form-control mail" id="val-email"
													name="val-email" value="<%=c.getEmail() %>" placeholder="Your valid email..">
											
											</div>										
										</div>
										
										<div class="form-group row">
											<label class="col-lg-4 col-form-label" for="val-suggestions">Address
												<span class="text-danger">*</span>
											</label>
											<div class="col-lg-6">
												<textarea class="form-control" id="val-suggestions"
													name="address" rows="2"
													placeholder="Enter your full address?" required="required"><%=c.getAddress() %></textarea>
											</div>
										</div>
										<%} }%>
										<div class="form-group row">
											<label class="col-lg-4 col-form-label" for="val-username">Aadhaar
												Number <span class="text-danger">*</span>
											</label>
											<div class="col-lg-6">
												<input type="text" class="form-control" id="aadhaar"
													name="aadhaar" disabled="disabled" value="<%=netbanking.getAadhar_no() %>" placeholder="Enter Aadhaar No" required="required">
												<span id="aadhar-error"  style="color:red; font-size: 10px;"></span>
											</div>
										</div>

										<div class="form-group row">
											<label class="col-lg-4 col-form-label" for="val-phoneus">Phone
												(IND) <span class="text-danger">*</span>
											</label>
											<div class="col-lg-6">
												<input type="tel" class="form-control" id="val-phoneus"
													name="val-phoneus" value="<%=netbanking.getContact() %>" maxlength=10 placeholder="90469-96154">
											</div>
										</div>
										
										<div class="form-group row">
											<label class="col-lg-4 col-form-label" for="val-username">Account
												Number <span class="text-danger">*</span>
											</label>
											<div class="col-lg-6">
												<input type="text" class="form-control" id="account"
													name="val-account" disabled="disabled" value="<%=netbanking.getAccount_no()%>" maxlength=8 placeholder="Enter Account No" required="required">
											<span id="account-error"  style="color:red; font-size: 10px;"></span>
											</div>
										</div>
										
										<div class="form-group row">
											<label class="col-lg-4 col-form-label" for="val-password">Password <span class="text-danger">*</span>
											</label>
											<div class="col-lg-6">
												<input type="password" class="form-control uname" id="val-password"
													name="val-password" disabled="disabled" value="<%=netbanking.getPassword() %>" placeholder="Enter a password..">
											</div>
										</div>
										
										<div class="form-group row">
											<label class="col-lg-4 col-form-label" for="val-phoneus">Upload
												Image <span class="text-danger">*</span>
											</label>
											<div class="col-lg-2">
												<div class="form-group">
												<%for(Customer c:customerList){ %>
											<%if(c.getAadharno().equals(netbanking.getAadhar_no())){ %>
													<input type="file" name="photo"
														class="form-control-file" value=<%=c.getImage_stream() %>>
												<%}} %>
												</div>

											</div>
										</div>
										
										<%for(Customer c:customerList){ %>
											<%if(c.getAadharno().equals(netbanking.getAadhar_no())){ %>
										<div class="form-group row">
											<label class="col-lg-4 col-form-label" for="val-password">Image <span class="text-danger">*</span>
											</label>
											<div class="col-lg-6">
												<img height="70px" width="70px"  src="data:image/png;base64,<%=c.getImage_string()%>">
											</div>
										</div>
										<%}} %>
											
							
										
								</div>
								<div class="form-group row">
									<div class="col-lg-8 ml-auto">
										<button type="submit" class="btn btn-primary">Update Profile</button>
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

</body>

</html>