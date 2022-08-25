<%@page import="com.internetbanking.bean.NetBanking"%>
<%@page import="com.internetbanking.bean.User"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%HttpSession httpsession=request.getSession(false);
NetBanking netbanking=(NetBanking)httpsession.getAttribute("loginDetails");
%>
<!--**********************************
            Sidebar start
        ***********************************-->
        <div class="nk-sidebar">           
            <div class="nk-nav-scroll">
                <ul class="metismenu" id="menu">
                    
                    <li>
                        <a href="index.jsp" aria-expanded="false">
                            <i class="icon-badge menu-icon"></i><span class="nav-text">Home</span>
                        </a>
                    </li>
                    <%if(null==httpsession.getAttribute("loginDetails")){ %>
                    <li>
                        <a href="login.jsp"  aria-expanded="false">
                            <i class="icon-login"></i><span class="nav-text">Login</span>
                        </a>
                     </li>
                     <%}else{ %>
                     	<li>
                        <a href="LogoutServlet"  aria-expanded="false">
                            <i class="icon-logout"></i><span class="nav-text">Logout</span>
                        </a>
                     </li>
                     <%} %>
 					<%if(null!=netbanking && "Admin".equalsIgnoreCase(netbanking.getRole())){ %>		                   
                    <li>
                        <a href="blank.jsp" aria-expanded="false">
                            <i class="icon-badge menu-icon"></i><span class="nav-text">Blank</span>
                        </a>
                    </li>
                     
                     <li>
                        <a href="registration.jsp"  aria-expanded="false">
                            <i class="fa fa-user-plus"></i><span class="nav-text">User Registration</span>
                        </a>
                     </li>
                     
                     <li>
                        <a href="openaccount.jsp"  aria-expanded="false">
                            <i class="fa fa-bank"></i><span class="nav-text">Open Account</span>
                        </a>
                     </li>
                     
                      
                     <li>
                        <a href="CustomerList.jsp"  aria-expanded="false">
                            <i class="icon-user"></i><span class="nav-text">Customer List</span>
                        </a>
                     </li>
                     
                     <li>
                        <a href="NetBankingList.jsp"  aria-expanded="false">
                            <i class="icon-user"></i><span class="nav-text">NetBanking List</span>
                        </a>
                     </li>
                     
                     <li>
                        <a href="OpenedAccount.jsp"  aria-expanded="false">
                            <i class="icon-user"></i><span class="nav-text">OpenedAccounts List</span>
                        </a>
                     </li>
                     
                      
                     <li>
                        <a href="TransactionList.jsp"  aria-expanded="false">
                            <i class="icon-user"></i><span class="nav-text">All Transaction List</span>
                        </a>
                     </li>
                     
                     <%}%>
                     <%if(null!=netbanking && "Customer".equalsIgnoreCase(netbanking.getRole())){ %>	
                     <li>
                        <a href="Transfer-Money.jsp" aria-expanded="false">
                            <i class="fa fa-exchange"></i><span class="nav-text">Transfer Money</span>
                        </a>
                    </li>
                    
                    <li>
                        <a href="Balance-inquiry.jsp" aria-expanded="false">
                            <i class="icon-wallet"></i><span class="nav-text">Balance Inquiry</span>
                        </a>
                    </li>
                    
                     <li>
                        <a href="CustomerTransaction.jsp"  aria-expanded="false">
                            <i class="icon-user"></i><span class="nav-text">Transaction History</span>
                        </a>
                     </li>
                     <%} %>
                        <!-- <ul aria-expanded="false">
                            <li><a href="./page-login.html">Login</a></li>
                            <li><a href="./page-register.html">Register</a></li>
                            <li><a href="./page-lock.html">Lock Screen</a></li>
                            <li><a class="has-arrow" href="javascript:void()" aria-expanded="false">Error</a>
                                <ul aria-expanded="false">
                                    <li><a href="./page-error-404.html">Error 404</a></li>
                                    <li><a href="./page-error-403.html">Error 403</a></li>
                                    <li><a href="./page-error-400.html">Error 400</a></li>
                                    <li><a href="./page-error-500.html">Error 500</a></li>
                                    <li><a href="./page-error-503.html">Error 503</a></li>
                                </ul>
                            </li>
                        </ul> -->
                   
                </ul>
            </div>
        </div>
        <!--**********************************
            Sidebar end
        ***********************************-->
