<%@page import="java.util.List"%>
<%@page import="com.internetbanking.bean.Customer"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="com.internetbanking.bean.NetBanking"%>

<jsp:include page="/FetchRegisterUserDetails"/>
<%HttpSession httpsession=request.getSession(false);
NetBanking netbanking=(NetBanking)httpsession.getAttribute("loginDetails");
List<Customer> customerList=(List)request.getAttribute("customerList");
%>
        <!--**********************************
            Nav header start
        ***********************************-->
        <div class="nav-header">
            <div class="brand-logo">
                <a href="index.jsp">
                    <b class="logo-abbr"><img src="images/Apna-Bank.png" alt=""> </b>
                    <span class="logo-compact"><img src="images/Apna-Bank.png" alt=""></span>
                    <span class="brand-title">
                        <img src="images/Apna-Bank.png" alt="">
                    </span>
                </a>
            </div>
        </div>
        <!--**********************************
            Nav header end
        ***********************************-->

        <!--**********************************
            Header start
        ***********************************-->
        <div class="header">    
            <div class="header-content clearfix">
                
                <div class="nav-control">
                    <div class="hamburger">
                        <span class="toggle-icon"><i class="icon-menu"></i></span>
                    </div>
                </div>
                <div class="header-left">
                    <div class="input-group icons">
                        <div class="input-group-prepend">
                            <span class="input-group-text bg-transparent border-0 pr-2 pr-sm-3" id="basic-addon1"><i class="mdi mdi-magnify"></i></span>
                        </div>
                        <input type="search" class="form-control" placeholder="Search Dashboard" aria-label="Search Dashboard">
                        <div class="drop-down animated flipInX d-md-none">
                            <form action="#">
                                <input type="text" class="form-control" placeholder="Search">
                            </form>
                        </div>
                    </div>
                </div>
                <div class="header-right">
                    <ul class="clearfix">
                  
                        <li class="icons dropdown">
                            <div class="user-img c-pointer position-relative"   data-toggle="dropdown">
                                <span class="activity active"></span>
                                
                                <%for(Customer c:customerList){ %>
                                	<%if(netbanking!=null && c.getAadharno().equals(netbanking.getAadhar_no())) {%>	
                                	<img src="data:image/png;base64,<%=c.getImage_string()%>" height="20" width="20" alt="">
                               		<%} %>
                               	<%} %>
                            </div>
                           <%--  <%int flag=0; %>
                             <%if(null!=httpsession.getAttribute("loginDetails")){ %>
                             <%for(Customer c:customerList){ %>
                             
                             <%if(netbanking.getAadhar_no().equals(c.getAadharno())){ %>
                             
                             	<h6>Welcome,<%=c.getCust_name()%></h6>
                             
                             <%}else{ %>
                             
                              	<h6>Welcome,Admin</h6>
                             
                             <%}}%>
                             <%} %> --%>
                            <div class="drop-down dropdown-profile animated fadeIn dropdown-menu">
                                <div class="dropdown-content-body">
                                    <ul>
                                        
                                        
                                        <hr class="my-2">
                                        <li>
                                            <a href="page-lock.html"><i class="icon-lock"></i> <span>Lock Screen</span></a>
                                        </li>
                                    	 <%if(null==httpsession.getAttribute("loginDetails")){ %>
                                    	
                                    	
                                        
                                        <li><a href="login.jsp"><i class="icon-key"></i> <span>Login</span></a></li>
                                    	
                                    	
                                    	<%} else {%>
	                                    	<li>
	                                            <a href="Profile.jsp"><i class="icon-user"></i> <span>Profile</span></a>
	                                        </li>
                                    	
                                    		<li><a href="LogoutServlet"><i class="icon-key"></i> <span>Logout</span></a></li>
                                    	
                                    	<%} %>
                                    </ul>
                                </div>
                            </div>
                        </li>
                    </ul>
                </div>
            </div>
        </div>
