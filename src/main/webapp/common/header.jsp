<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>

<header>
	<div>
		<nav
			class="navbar navbar-expand-md fixed-top bg-body bg-opacity-10 py-3">
			<div class="container">
				<!-- <form action="Home" method="get"> -->
					<a class="navbar-brand d-flex align-items-center" href="/Home"
						onclick="submitForm()"> <span
						class="bs-icon-sm bs-icon-rounded bs-icon-primary d-flex justify-content-center align-items-center me-2 bs-icon">
							<i class="far fa-smile"></i>
					</span> <span>Conbo</span>
					</a>
				<!-- </form> -->
				<button data-bs-toggle="collapse" class="navbar-toggler"
					data-bs-target="#navcol-1">
					<span class="visually-hidden">Toggle navigation</span> <span
						class="navbar-toggler-icon"></span>
				</button>
				<div
					class="collapse navbar-collapse text-uppercase fs-6 fw-semibold"
					id="navcol-1">
					<ul class="navbar-nav mx-auto">
						<li class="nav-item"><a class="nav-link" href="/Sale">SALE</a></li>
						<li id="all-product-header" class="nav-item"><a class="nav-link" href="/product">Sản
								phẩm</a></li>
						<li class="nav-item"><a class="nav-link" href="/product?sort=purchaseCount,desc">Sản phẩm bán chạy</a></li>
					</ul>
					<div class="d-flex align-items-center" style="gap: 20px;">
							
						<sec:authorize access="!hasRole('CUSTOMER')">
							<!-- <form id="loginForm" action="/customer/Login" method="get"> -->
								<a id="loginButton" type="submit" href="/Login"
									class="btn btn-primary ms-auto" role="button">Login</a>
							<!-- </form> -->
						</sec:authorize>
						<sec:authorize access="hasRole('CUSTOMER')">
							<div class="cart-icon-container">
							<a href="/customer/Cart">
							  <i id="header-cart-i" class="fa-solid fa-cart-shopping fa-lg"></i>
							  <span class="product-count"></span>
							</a>
							</div>
							<div class="dropdown">
								<a style="text-decoration: none" class="dropdown-toggle"
									href="#" role="button" id="dropdownMenuAvatar"
									data-toggle="dropdown" aria-haspopup="true"
									aria-expanded="false"> <img
									src= "<sec:authentication property="principal.customerAccount.avatar"/>"
									onerror="this.onerror=null;this.src='https://bootdey.com/img/Content/avatar/avatar7.png';"
									class="rounded-circle" width="30" height="30"
									alt="Black and White Portrait of a Man" loading="lazy">
								</a>
								<ul class="dropdown-menu dropdown-menu-end"
									aria-labelledby="dropdownMenuAvatar"
									style = "margin-top: 10px;">
									<li><a class="dropdown-item" href="/customer/Profile">My profile</a></li>
									<li><a class="dropdown-item" href="/customer/logout">Logout</a></li>
								</ul>
							</div>
						</sec:authorize>


					</div>

				</div>
			</div>
		</nav>
	</div>
</header>
