<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <header>
        <div>
            <nav class="navbar navbar-expand-md fixed-top bg-body bg-opacity-10 py-3">
                <div class="container">
                	 <form action="Home" method="get">
                    <a class="navbar-brand d-flex align-items-center" href="Home" onclick="submitForm()">
                        <span class="bs-icon-sm bs-icon-rounded bs-icon-primary d-flex justify-content-center align-items-center me-2 bs-icon">
                            <i class="far fa-smile"></i>
                        </span>
                        <span>Conbo</span>
                    </a>
                </form>
                		<button data-bs-toggle="collapse" class="navbar-toggler" data-bs-target="#navcol-1">
                			<span class="visually-hidden">Toggle navigation</span>
                			<span class="navbar-toggler-icon"></span></button>
                    <div class="collapse navbar-collapse text-uppercase fs-6 fw-semibold" id="navcol-1">
                        <ul class="navbar-nav mx-auto">
                            <li class="nav-item"><a class="nav-link" href="#sale">SALE</a></li>
                            <li class="nav-item"><a class="nav-link" href="SanPham">Sản phẩm</a></li>
                            <li class="nav-item"><a class="nav-link" href="Giay">Giày</a></li>
                            <li class="nav-item"><a class="nav-link" href="QuanAo">Quần áo</a></li>                         
                           <li class="nav-item"><a class="nav-link" href="Balo">Balo</a></li>
                            <li class="nav-item"><a class="nav-link" href="BanChay">Sản phẩm bán chạy</a></li>
                        </ul>
                        <div class="d-flex align-items-center" style="gap: 20px;">
                            <div data-reflow-type="product-search"></div>
                            <span>
                            <a class="fs-4" href="Cart"><svg xmlns="http://www.w3.org/2000/svg" width="1em" height="1em" fill="currentColor" viewBox="0 0 16 16" class="bi bi-cart2 text-dark">
                                        <path d="M0 2.5A.5.5 0 0 1 .5 2H2a.5.5 0 0 1 .485.379L2.89 4H14.5a.5.5 0 0 1 .485.621l-1.5 6A.5.5 0 0 1 13 11H4a.5.5 0 0 1-.485-.379L1.61 3H.5a.5.5 0 0 1-.5-.5zM3.14 5l1.25 5h8.22l1.25-5H3.14zM5 13a1 1 0 1 0 0 2 1 1 0 0 0 0-2zm-2 1a2 2 0 1 1 4 0 2 2 0 0 1-4 0zm9-1a1 1 0 1 0 0 2 1 1 0 0 0 0-2zm-2 1a2 2 0 1 1 4 0 2 2 0 0 1-4 0z"></path>
                                    </svg></a></span>
                                <form id="loginForm" action="Login" method="get">
								    <button  id="loginButton" type="submit" class="btn btn-primary ms-auto" role="button">Login</button>
								</form>
                            
                            <div class="dropdownHeader">
							  <a class="btn btn-success dropdown-toggle" href="#" role="button" id="dropdownMenuLink" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
							    <span id="userName" class="user-name"><i class="fa fa-user"></i> ${customer.getCustomerName()}</span>
							  </a>
							
							  <div class="dropdown-menu" aria-labelledby="dropdownMenuLink">
							    <a class="dropdown-item" href="#">Profile</a>
							    <a class="dropdown-item link-danger" href="Logout">Logout</a>
							  </div>
							</div>
						</div>
                                    
                       </div>
                    </div>
                    </nav>
                </div>            
    </header>
