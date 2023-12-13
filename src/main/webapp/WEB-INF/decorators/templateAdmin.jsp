<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ include file="/common/taglib.jsp"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
<link rel="stylesheet" href="/assets/bootstrap/css/bootstrap.min.css" />
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i&amp;display=swap" />
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.12.0/css/all.css" />
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css" />
<link rel="stylesheet"
	href="/assets/fonts/fontawesome5-overrides.min.css" />
<link rel="stylesheet" href="/assets/css/colorPick.css" />
<link rel="stylesheet" href="/assets/css/product.css" />
<link rel="stylesheet" href="/assets/css/product.compiled.css" />
<style>
ul, li {
	margin: 0;
	padding: 0;
	list-style: none
}

#wrapper #content-wrapper #content {
	flex: none;
}

#sidebarAdmin {
	display: flex;
	justify-content: center;
}
</style>
<sitemesh:write property='head'></sitemesh:write>
<title><sitemesh:write property='title'/></title>
</head>
<body id="page-top">
	<div id="wrapper">
		<nav
			class="navbar align-items-start sidebar sidebar-dark accordion bg-gradient-primary p-0 navbar-dark"
			id="sidebarAdmin">
			<div class="container-fluid p-0">
				<a
					class="navbar-brand d-flex justify-content-center align-items-center sidebar-brand m-0"
					href="#">
					<div class="sidebar-brand-icon rotate-n-15">
						<i class="fas fa-laugh-wink"></i>
					</div>
					<div class="sidebar-brand-text mx-3">
						<span>Brand</span>
					</div>
				</a>
				<hr class="sidebar-divider my-0" />
				<ul class="navbar-nav text-light" id="accordionSidebar">
					<li class="nav-item"><a class="nav-link"
						href="/admin/Dashboard"><i class="fas fa-tachometer-alt"></i><span>Dashboard</span></a></li>
					<li class="nav-item"><a class="nav-link" href="/admin/Profile"><i
							class="fas fa-user"></i><span>Profile</span></a></li>
					<li class="nav-item"><a class="nav-link active"
						href="/admin/Product"><i class="fas fa-shopping-cart"></i><span>Product</span></a></li>
					<li class="nav-item"><a class="nav-link"
						href="/admin/ProductLot"><i class="fas fa-table"></i><span>Product
								Plot</span></a></li>
					<li class="nav-item"><a class="nav-link" href="/admin/Order"><i
							class="fas fa-table"></i><span>Order</span></a></li>
					<li class="nav-item"><a class="nav-link"
						href="/admin/Promotion"><i class="fas fa-table"></i><span>Promotion</span></a></li>
					<sec:authorize access="hasRole('CREATOR')">
						<li class="nav-item"><a class="nav-link"
							href="/admin/creator/Register"><i class="fas fa-user-circle"></i><span>Register</span></a></li>
						<li class="nav-item"><a class="nav-link"
							href="/admin/creator/Account"><i class="fas fa-user-circle"></i><span>Account</span></a></li>
					</sec:authorize>
				</ul>
				<div class="text-center d-none d-md-inline">
					<button class="btn border-0 rounded-circle" id="sidebarToggle"
						type="button"></button>
				</div>
			</div>
		</nav>
		<div class="d-flex flex-column" id="content-wrapper">
			<div id="content">
				<nav
					class="navbar navbar-expand bg-white shadow mb-4 topbar static-top navbar-light">
					<div class="container-fluid">
						<button class="btn btn-link d-md-none rounded-circle me-3"
							id="sidebarToggleTop" type="button">
							<i class="fas fa-bars"></i>
						</button>
						<ul class="navbar-nav flex-nowrap ms-auto">
							<li class="nav-item dropdown no-arrow">
								<div class="nav-item dropdown no-arrow">
									<a class="dropdown-toggle nav-link" aria-expanded="false"
										data-bs-toggle="dropdown" href="#"><span
										class="d-none d-lg-inline me-2 text-gray-600 small">Valerie
											Luna</span><img class="border rounded-circle img-profile"
										src="assets/img/avatars/avatar1.jpeg"></a>
									<div
										class="dropdown-menu shadow dropdown-menu-end animated--grow-in">
										<a class="dropdown-item" href="#"><i
											class="fas fa-user fa-sm fa-fw me-2 text-gray-400"></i>&nbsp;Profile</a><a
											class="dropdown-item" href="#"><i
											class="fas fa-cogs fa-sm fa-fw me-2 text-gray-400"></i>&nbsp;Settings</a><a
											class="dropdown-item" href="#"><i
											class="fas fa-list fa-sm fa-fw me-2 text-gray-400"></i>&nbsp;Activity
											log</a>
										<div class="dropdown-divider"></div>
										<a class="dropdown-item" href="#"><i
											class="fas fa-sign-out-alt fa-sm fa-fw me-2 text-gray-400"></i>&nbsp;Logout</a>
									</div>
								</div>
							</li>
						</ul>
					</div>
				</nav>
			</div>

			<sitemesh:write property='body'></sitemesh:write>
			<footer class="bg-white sticky-footer">
				<div class="container my-auto">
					<div class="text-center my-auto copyright">
						<span>Copyright © Brand 2023</span>
					</div>
				</div>
			</footer>
		</div>
		<a class="border rounded d-inline scroll-to-top" href="#page-top"><i
			class="fas fa-angle-up"></i></a>
	</div>
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.20.0/jquery.validate.min.js"
		integrity="sha512-WMEKGZ7L5LWgaPeJtw9MBM4i5w5OSBlSjTjCtSnvFJGSVD26gE5+Td12qN5pvWXhuWaWcVwF++F7aqu9cvqP0A=="
		crossorigin="anonymous" referrerpolicy="no-referrer"></script>

	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.19.5/additional-methods.min.js"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
	<script src="/assets/js/jquery-3.1.1.min.js"></script>
	<script src="/assets/js/colorPick.js"></script>
	<script src="/assets/js/numberinput.js"></script>
	<script src="/assets/js/product-type-action.js" type="module"></script>
	<script src="/assets/js/theme.js"></script>
	<script src="/assets/js/notify.js"></script>
</body>
</html>