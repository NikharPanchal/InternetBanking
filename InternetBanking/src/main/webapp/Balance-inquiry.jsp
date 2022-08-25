<%@page import="com.internetbanking.bean.NetBanking"%>
<%@page import="com.internetbanking.bean.Account"%>
<%@page import="com.internetbanking.bean.Customer"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width,initial-scale=1">
<title>Balance-Inquiry</title>
<!-- Favicon icon -->
<link rel="icon" type="image/png" sizes="16x16"
	href="images/favicon.png">
<!-- Custom Stylesheet -->

<link href="css/style.css" rel="stylesheet">
</head>

<body>
	<jsp:include page="/FetchRegisterUserDetails" />
	<jsp:include page="/FetchOpenedAccountDetails" />

	<%
	HttpSession httpsession = request.getSession(false);
	NetBanking netbankingData = (NetBanking) httpsession.getAttribute("loginDetails");
	List<Customer> customerList = (List) request.getAttribute("customerList");
	List<Account> accountList = (List) request.getAttribute("accountList");
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
						<li class="breadcrumb-item"><a href="javascript:void(0)">Balance
								Inquiry</a></li>
						<li class="breadcrumb-item active"><a
							href="javascript:void(0)">Home</a></li>
					</ol>
				</div>
			</div>
			<!-- row -->

			<div class="container-fluid">
				<div class="col-lg-10 px-md-20">
					<div class="card">
						<div class="card-body">
							<h4 class="card-title"
								style="text-align: center; font-size: 20px;">Account
								Balance</h4>
							<div class="table-responsive">
								<table class="table header-border">
									<!-- <thead>
                                            <tr>
                                                <th scope="col">Account Number</th>
                                                <th scope="col">Available Balance</th>
                                                <th scope="col">Current Balance</th>
                                            </tr>
                                        </thead> -->
                                        <tbody>
									<%
									for (Account a : accountList) {
									%>
									<%
									if (netbankingData.getAccount_no() == a.getAccount_no()) {
									%>
									<tr>
										<th scope="col">Accout Number</th>
										<td><%=a.getAccount_no()%></td>
									</tr>
									<tr>
										<th scope="col">Total Amount</th>
										<td>INR <%=a.getAmount()%>.00</td>
									</tr>
									<tr>
										<th scope="col">Current Amount</th>
										<td>INR <%=a.getAmount()%>.00</td>
									</tr>
									<%}}%>
							</tbody>


								</table>
							</div>
						</div>
					</div>
				</div>


			</div>
		</div>
		<script src="plugins/common/common.min.js"></script>
		<script src="js/custom.min.js"></script>
		<script src="js/settings.js"></script>
		<script src="js/gleek.js"></script>
		<script src="js/styleSwitcher.js"></script>
</body>

</html>