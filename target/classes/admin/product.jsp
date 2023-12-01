<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html data-bs-theme="light" lang="en">
<head>
<meta charset="utf-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, shrink-to-fit=no" />
<title>Product (3)</title>
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
</head>

<body>
	<div id="wrapper">
		<nav
			class="navbar align-items-start sidebar sidebar-dark accordion bg-gradient-primary p-0 navbar-dark">
			<div class="container-fluid p-0">
				<a
					class="navbar-brand d-flex justify-content-center align-items-center sidebar-brand m-0"
					href="#"><div class="sidebar-brand-icon rotate-n-15">
						<i class="fas fa-laugh-wink"></i>
					</div>
					<div class="sidebar-brand-text mx-3">
						<span>Brand</span>
					</div></a>
				<hr class="sidebar-divider my-0" />
				<ul class="navbar-nav text-light" id="accordionSidebar">
					<li class="nav-item"><a class="nav-link" href="index.html"><i
							class="fas fa-tachometer-alt"></i><span>Dashboard</span></a></li>
					<li class="nav-item"><a class="nav-link" href="profile.html"><i
							class="fas fa-user"></i><span>Profile</span></a></li>
					<li class="nav-item"><a class="nav-link" href="table.html"><i
							class="fas fa-table"></i><span>Product Plot</span></a></li>
					<li class="nav-item"></li>
					<li class="nav-item"><a class="nav-link" href="register.html"><i
							class="fas fa-user-circle"></i><span>Register</span></a></li>
					<li class="nav-item"><a class="nav-link active"
						href="product.html"><i class="fas fa-shopping-cart"></i><span>Product</span></a></li>
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
						<form
							class="d-none d-sm-inline-block me-auto ms-md-3 my-2 my-md-0 mw-100 navbar-search">
							<div class="input-group">
								<input
									class="bg-light border-0 form-control form-control form-control form-control form-control form-control small"
									type="text" placeholder="Search for ..." />
								<button class="btn btn-primary py-0" type="button">
									<i class="fas fa-search"></i>
								</button>
							</div>
						</form>
						<ul class="navbar-nav flex-nowrap ms-auto">
							<li class="nav-item dropdown no-arrow">
								<div class="nav-item dropdown no-arrow">
									<a class="dropdown-toggle nav-link" aria-expanded="false"
										data-bs-toggle="dropdown" href="#"><span
										class="d-none d-lg-inline me-2 text-gray-600 small">Valerie
											Luna</span><img class="border rounded-circle img-profile"
										src="assets/img/avatars/avatar1.jpeg" /></a>
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
				<div class="container-fluid">
					<h3 class="text-dark mb-4">Product</h3>
					<div class="card shadow">
						<div class="card-header py-3">
							<p class="fw-bold text-primary m-0">Product Info</p>
						</div>
						<div class="card-body">
							<div class="row d-flex justify-content-between">
								<div
									class="col-md-6 col-xl-5 text-nowrap d-flex justify-content-start align-items-xl-center column-gap-3">
									<div>
										<label class="form-label" style="margin: 0px">Show&nbsp;
										</label><select class="form-select-sm d-inline-block form-select"
											style="width: 100px">
											<option value="10" selected="">10</option>
											<option value="25">25</option>
											<option value="50">50</option>
											<option value="100">100</option>
										</select>
									</div>
									<div>
										<div class="dropdown">
											<button class="btn btn-success btn-sm dropdown-toggle"
												aria-expanded="false" data-bs-toggle="dropdown"
												style="color: rgb(255, 255, 255)" type="button">
												Sort By</button>
											<div class="dropdown-menu">
												<a class="dropdown-item" href="#" id="sortProductNameAZ">ProductName:
													A -&gt; Z</a><a class="dropdown-item" href="#"
													id="sortProductNameZA">ProductName: Z -&gt; A</a><a
													class="dropdown-item" href="#" id="sortPurchaseCountAsc">PuchaseCount:
													Price increases</a><a class="dropdown-item" href="#"
													id="sortPurchaseCountDesc">PuchaseCount: Price
													decreases</a>
											</div>
										</div>
									</div>
								</div>
								<div
									class="col-md-6 col-xl-5 d-flex flex-nowrap justify-content-xl-end">
									<div>
										<button class="btn btn-primary btn-sm" type="button"
											data-bs-toggle="modal" data-bs-target="#add-product-modal"
											style="margin: 16px; color: var(--bs-btn-color); background: var(--bs-green); font-size: 16px; border-color: var(--bs-form-valid-color); text-align: center; max-height: 34px;">
											<svg xmlns="http://www.w3.org/2000/svg" width="1em"
												height="1em" viewbox="0 0 24 24" fill="none"
												style="color: var(--bs-btn-hover-color); background: var(--bs-green); border-color: var(--bs-form-valid-color); position: static; display: inline-grid;">
                          <path
													d="M12 4C11.4477 4 11 4.44772 11 5V11H5C4.44772 11 4 11.4477 4 12C4 12.5523 4.44772 13 5 13H11V19C11 19.5523 11.4477 20 12 20C12.5523 20 13 19.5523 13 19V13H19C19.5523 13 20 12.5523 20 12C20 11.4477 19.5523 11 19 11H13V5C13 4.44772 12.5523 4 12 4Z"
													fill="currentColor"></path>
                        </svg>
											Add Product
										</button>
									</div>
									<div class="d-flex align-items-center align-items-xl-center">
										<input class="form-control-sm form-control" type="search"
											aria-controls="dataTable" placeholder="Search"
											style="max-height: 31px" />
									</div>
								</div>
							</div>
							<div class="table-responsive table mt-2" id="producttable"
								role="grid" aria-describedby="dataTable_info">
								<table class="table my-0 align-middle" id="productCatalogsTable">
									<thead>
										<tr>
											<th>ProductName</th>
											<th>Product Type</th>
											<th>Origin</th>
											<th>Brand</th>
											<th>Release Date</th>
											<th>Puchase Count</th>
											<th>Edit</th>
											<th>Delete</th>
										</tr>
									</thead>
									<tbody>
									</tbody>
									<tfoot>
										<tr></tr>
									</tfoot>
								</table>
							</div>
							<div class="row">
								<div class="col-md-6 align-self-center">
									<p id="dataTable_info" class="dataTables_info" role="status"
										aria-live="polite">Showing 1 to 10 of 27</p>
								</div>
								<div class="col-md-6">
									<nav
										class="d-lg-flex justify-content-lg-end dataTables_paginate paging_simple_numbers">
										<ul class="pagination">
											<li class="page-item disabled"><a class="page-link"
												aria-label="Previous" href="#"><span aria-hidden="true">«</span></a></li>
											<li class="page-item active"><a class="page-link"
												href="#">1</a></li>
											<li class="page-item"><a class="page-link" href="#">2</a>
											</li>
											<li class="page-item"><a class="page-link" href="#">3</a>
											</li>
											<li class="page-item"><a class="page-link"
												aria-label="Next" href="#"><span aria-hidden="true">»</span></a></li>
										</ul>
									</nav>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
			<footer class="bg-white sticky-footer">
				<div class="container my-auto">
					<div class="text-center my-auto copyright">
						<span>Copyright © Brand 2023</span>
					</div>
				</div>
			</footer>
			<div class="modal fade" role="dialog" tabindex="-1"
				id="add-product-modal" data-bs-backdrop="static"
				data-bs-keyboard="false" aria-labelledby="staticBackdropLabel"
				aria-hidden="true">
				<div class="modal-dialog" role="document">
					<div class="modal-content">
						<div class="modal-header">
							<h5 class="modal-title">
								<strong>Add Product</strong>
							</h5>
							<button class="btn-close" aria-label="Close"
								data-bs-dismiss="modal" type="button"></button>
						</div>
						<form id="addProductForm">
							<div class="modal-body"
								style="margin-left: 13px; margin-right: 1rem">
								<div class="row mb-3">
									<div class="col">
										<label class="col-form-label text-start col-form-label ps-2"
											for="productName">Product Name</label>
									</div>
									<div class="col-sm-8">
										<input class="form-control" type="text" id="productName"
											required="" />
									</div>
								</div>
								<div class="row mb-3">
									<div class="col">
										<label class="col-form-label text-start col-form-label ps-2"
											for="productType">Product Type</label>
									</div>
									<div class="col-sm-8">
										<select class="form-select" id="productType">
										</select>
									</div>
								</div>
								<div class="row mb-3">
									<div class="col">
										<label class="col-form-label text-start col-form-label ps-2"
											for="origin">Origin</label>
									</div>
									<div class="col-sm-8">
										<input class="form-control" type="text" id="origin"
											required="" />
									</div>
								</div>
								<div class="row mb-3">
									<div class="col">
										<label class="col-form-label text-start col-form-label ps-2"
											for="brand">Brand</label>
									</div>
									<div class="col-sm-8">
										<input class="form-control" type="text" id="brand" required="" />
									</div>
								</div>
								<div class="row mb-3">
									<div class="col">
										<label class="col-form-label text-start col-form-label ps-2"
											for="releaseDate">Release Date</label>
									</div>
									<div class="col-sm-8">
										<input class="form-control" id="releaseDate" required=""
											type="date" />
									</div>
								</div>
								<div class="row mb-0">
									<div class="col">
										<label
											class="col-form-label text-start col-sm-4 col-form-label ps-2"
											for="description">Decription</label>
									</div>
								</div>
								<div class="row d-flex justify-content-lg-end mb-3">
									<div class="col" style="padding-left: 20px">
										<textarea class="form-control" id="description"
											style="height: 100px" required=""></textarea>
									</div>
								</div>
							</div>
							<div class="modal-footer">
								<button class="btn btn-secondary" data-bs-dismiss="modal"
									type="button">Close</button>
								<button class="btn btn-primary" type="submit">Submit</button>
							</div>
						</form>
					</div>
				</div>
			</div>
			<div class="modal fade" role="dialog" tabindex="-1" id="add-images"
				aria-labelledby="exampleModalLabel" aria-hidden="true">
				<div class="modal-dialog" role="document">
					<div class="modal-content">
						<div class="modal-header">
							<h5 class="modal-title kb-data-title">Upload image</h5>
							<button class="btn-close" aria-label="Close"
								data-bs-dismiss="modal" type="button"></button>
						</div>
						<div class="modal-body">
							<div class="fileupload-view">
								<div class="row justify-content-center m-0">
									<form id="upload-image-form">
										<div class="kb-file-upload">
											<div class="file-upload-box">
												<input type="file" id="fileupload" class="file-upload-input"
													accept="image/*" multiple="true" /> <span> Drag and
													drop or <span class="file-link"> Choose your files
														or images </span>
												</span>
											</div>
										</div>
										<div id="upload-details" class="kb-attach-box mb-3"></div>
										<div class="kb-buttons-box">
											<button type="submit" class="btn btn-primary form-submit">
												Upload Images</button>
										</div>
									</form>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
			<div class="modal fade" role="dialog" tabindex="-1" id="show-type"
				aria-labelledby="exampleModalLabel">
				<div class="modal-dialog modal-lg" role="document">
					<div class="modal-content">
						<div class="modal-header">
							<h4>Áo thun</h4>
							<button class="btn-close" type="button" aria-label="Close"
								data-bs-dismiss="modal"></button>
						</div>
						<div class="modal-body">
							<div>
								<div class="container">
									<div class="row">
										<div class="col-md-12">
											<label class="col-form-label">Mã sản phẩm</label>
										</div>
									</div>
								</div>
								<div class="container">
									<div class="row">
										<div class="col-md-6">
											<label class="col-form-label">Thương hiệu</label>
										</div>
										<div class="col-md-6">
											<label class="col-form-label">Ngày sản xuất</label>
										</div>
									</div>
								</div>
							</div>
							<div>
								<div class="card">
									<div class="card-header d-inline-flex flex-fill"
										style="--bs-body-bg: #fff">
										<div class="col">
											<div></div>
										</div>
										<div
											class="col-md-12 d-lg-flex justify-content-lg-end align-items-lg-center"
											style="display: flex; padding-bottom: 0px; margin-bottom: 2px; width: auto;">
											<div class="mail-custom-btn">
												<a class="custom-btn light-btn" href="#" role="button"
													style="background: #1eb53a; color: var(--bs-body-bg);"
													data-bs-target="#add-type" data-bs-toggle="modal"><i
													class="fas fa-plus"
													style="font-size: 21px; padding-bottom: 0px; padding-right: 0px; padding-left: 0px; transform: translateY(2px);"></i></a><a
													class="custom-btn light-btn" href="#" role="button"
													style="background: #e84c3d; color: var(--bs-body-bg);"><i
													class="fa fa-trash"
													style="font-size: 22px; transform: translateY(2px);"></i></a><a
													class="custom-btn light-btn" href="#" role="button"
													style="background: #3299dc; color: var(--bs-body-bg);"><i
													class="fas fa-refresh"
													style="font-size: 21px; padding-bottom: 0px; padding-right: 0px; padding-left: 0px; transform: translateY(2px);"></i></a>
											</div>
										</div>
									</div>
									<div class="card-body">
										<div class="table-responsive table mt-2" id="type-table"
											role="grid" aria-describedby="dataTable_info"
											style="border-radius: 5px; display: block; height: 300px; text-align: center;">
											<table
												class="table table-hover table-bordered my-0 table-bordered align-middle"
												id="dataTable">
												<thead class="table-dark">
													<tr>
														<th>Product Category ID</th>
														<th>Color</th>
														<th>Price</th>
														<th>Image</th>
													</tr>
												</thead>
												<tbody>
													<tr>
														<td product-category-id="">Airi Satou</td>
														<td>
															<div
																style="height: 30px; width: 50px; background: #1e9823; margin: 0px auto;"></div>
														</td>
														<td>99999999999</td>
														<td class="d-flex justify-content-around gap-3"><a
															class="btn btn-info" role="button" id="image-view"
															href="#" style="color: rgb(255, 255, 255)"
															data-bs-target="#show-view" data-bs-toggle="modal">View</a><a
															class="btn btn-success" role="button"
															href="teamApagar.php?id="
															style="color: rgb(255, 255, 255); background: #1eb53a; border-style: none;"
															data-bs-target="#add-images" data-bs-toggle="modal">Add</a>
														</td>
													</tr>
													<tr>
														<td product-category-id="">Airi Satou</td>
														<td>
															<div
																style="height: 30px; width: 50px; background: #1e9823; margin: 0px auto;"></div>
														</td>
														<td>99999999999</td>
														<td class="d-flex justify-content-around gap-3"><a
															class="btn btn-info" role="button" id="image-view-7"
															href="#" style="color: rgb(255, 255, 255)"
															data-bs-target="#show-view" data-bs-toggle="modal">View</a><a
															class="btn btn-success" role="button"
															href="teamApagar.php?id="
															style="color: rgb(255, 255, 255); background: #1eb53a; border-style: none;"
															data-bs-target="#add-images" data-bs-toggle="modal">Add</a>
														</td>
													</tr>
													<tr>
														<td product-category-id="">Airi Satou</td>
														<td>
															<div
																style="height: 30px; width: 50px; background: #1e9823; margin: 0px auto;"></div>
														</td>
														<td>99999999999</td>
														<td class="d-flex justify-content-around gap-3"><a
															class="btn btn-info" role="button" id="image-view-6"
															href="#" style="color: rgb(255, 255, 255)"
															data-bs-target="#show-view" data-bs-toggle="modal">View</a><a
															class="btn btn-success" role="button"
															href="teamApagar.php?id="
															style="color: rgb(255, 255, 255); background: #1eb53a; border-style: none;"
															data-bs-target="#add-images" data-bs-toggle="modal">Add</a>
														</td>
													</tr>
													<tr>
														<td product-category-id="">Airi Satou</td>
														<td>
															<div
																style="height: 30px; width: 50px; background: #1e9823; margin: 0px auto;"></div>
														</td>
														<td>99999999999</td>
														<td class="d-flex justify-content-around gap-3"><a
															class="btn btn-info" role="button" id="image-view-5"
															href="#" style="color: rgb(255, 255, 255)"
															data-bs-target="#show-view" data-bs-toggle="modal">View</a><a
															class="btn btn-success" role="button"
															href="teamApagar.php?id="
															style="color: rgb(255, 255, 255); background: #1eb53a; border-style: none;"
															data-bs-target="#add-images" data-bs-toggle="modal">Add</a>
														</td>
													</tr>
													<tr>
														<td product-category-id="">Airi Satou</td>
														<td>
															<div
																style="height: 30px; width: 50px; background: #1e9823; margin: 0px auto;"></div>
														</td>
														<td>99999999999</td>
														<td class="d-flex justify-content-around gap-3"><a
															class="btn btn-info" role="button" id="image-view-4"
															href="#" style="color: rgb(255, 255, 255)"
															data-bs-target="#show-view" data-bs-toggle="modal">View</a><a
															class="btn btn-success" role="button"
															href="teamApagar.php?id="
															style="color: rgb(255, 255, 255); background: #1eb53a; border-style: none;"
															data-bs-target="#add-images" data-bs-toggle="modal">Add</a>
														</td>
													</tr>
													<tr>
														<td product-category-id="">Airi Satou</td>
														<td>
															<div
																style="height: 30px; width: 50px; background: #1e9823; margin: 0px auto;"></div>
														</td>
														<td>99999999999</td>
														<td class="d-flex justify-content-around gap-3"><a
															class="btn btn-info" role="button" id="image-view-3"
															href="#" style="color: rgb(255, 255, 255)"
															data-bs-target="#show-view" data-bs-toggle="modal">View</a><a
															class="btn btn-success" role="button"
															href="teamApagar.php?id="
															style="color: rgb(255, 255, 255); background: #1eb53a; border-style: none;"
															data-bs-target="#add-images" data-bs-toggle="modal">Add</a>
														</td>
													</tr>
													<tr>
														<td product-category-id="">Airi Satou</td>
														<td>
															<div
																style="height: 30px; width: 50px; background: #1e9823; margin: 0px auto;"></div>
														</td>
														<td>99999999999</td>
														<td class="d-flex justify-content-around gap-3"><a
															class="btn btn-info" role="button" id="image-view-2"
															href="#" style="color: rgb(255, 255, 255)"
															data-bs-target="#show-view" data-bs-toggle="modal">View</a><a
															class="btn btn-success" role="button"
															href="teamApagar.php?id="
															style="color: rgb(255, 255, 255); background: #1eb53a; border-style: none;"
															data-bs-target="#add-images" data-bs-toggle="modal">Add</a>
														</td>
													</tr>
													<tr>
														<td product-category-id="">Airi Satou</td>
														<td>
															<div
																style="height: 30px; width: 50px; background: #1e9823; margin: 0px auto;"></div>
														</td>
														<td>99999999999</td>
														<td class="d-flex justify-content-around gap-3"><a
															class="btn btn-info" role="button" id="image-view-1"
															href="#" style="color: rgb(255, 255, 255)"
															data-bs-target="#show-view" data-bs-toggle="modal">View</a><a
															class="btn btn-success" role="button"
															href="teamApagar.php?id="
															style="color: rgb(255, 255, 255); background: #1eb53a; border-style: none;"
															data-bs-target="#add-images" data-bs-toggle="modal">Add</a>
														</td>
													</tr>
												</tbody>
											</table>
										</div>
									</div>
								</div>
							</div>
						</div>
						<div class="modal-footer">
							<button class="btn btn-light" type="button"
								data-bs-dismiss="modal"
								style="background: var(--bs-btn-hover-border-color)">
								Close</button>
						</div>
					</div>
				</div>
			</div>
			<div class="modal fade" role="dialog" tabindex="-1" id="add-type">
				<div class="modal-dialog modal-sm modal-dialog-centered"
					role="document">
					<div class="modal-content">
						<div class="modal-header">
							<h5>Add product category</h5>
							<button class="btn-close" type="button" aria-label="Close"
								data-bs-dismiss="modal"></button>
						</div>
						<form id="add-type-form">
							<div class="modal-body">
								<div class="container">
									<div class="d-flex">
										<div class="d-lg-flex align-items-lg-center"
											style="margin-right: 15px">
											<label class="form-label">Color :</label>
										</div>
										<div>
											<div class="picker"></div>
										</div>
									</div>
									<div class="d-flex mt-2">
										<div style="margin-right: 24px">
											<label class="form-label">Price:</label>
										</div>
										<div>
											<input class="form-control form-control-sm" type="text"
												onkeypress="return isNumber(event)" onpaste="return false;" />
										</div>
									</div>
								</div>
							</div>
							<div class="modal-footer">
								<button class="btn btn-light" type="button"
									data-bs-dismiss="modal">Close</button>
								<button class="btn btn-primary" type="submit">Save</button>
							</div>
						</form>
					</div>
				</div>
			</div>
			<div class="modal fade" role="dialog" tabindex="-1" id="show-view">
				<div class="modal-dialog modal-lg" role="document">
					<div class="modal-content">
						<div class="modal-header">
							<h4 class="modal-title">Product images</h4>
							<button class="btn-close" aria-label="Close"
								data-bs-dismiss="modal" type="button"></button>
						</div>
						<div class="modal-body mt-0">
							<div class="d-flex justify-content-lg-end">
								<button class="btn btn-danger" type="button"
									style="font-weight: bold; padding: 3px 12px">
									<i class="fas fa-trash"
										style="padding-right: 0px; margin-right: 7px"></i>Delete
								</button>
							</div>
							<div class="container mt-2">
								<div class="row carousel-container position-relative">
									<div id="myCarousel" class="carousel slide"
										data-bs-ride="carousel">
										<div class="carousel-inner">
											<div class="carousel-item active" data-slide-number="0">
												<img src="https://source.unsplash.com/Pn6iimgM-wo/1600x900/"
													class="d-block w-100" alt="..."
													data-remote="https://source.unsplash.com/Pn6iimgM-wo/"
													data-type="image" data-bs-toggle="lightbox"
													data-bs-gallery="example-gallery" />
											</div>
											<div class="carousel-item" data-slide-number="1">
												<img src="https://source.unsplash.com/tXqVe7oO-go/1600x900/"
													class="d-block w-100" alt="..."
													data-remote="https://source.unsplash.com/tXqVe7oO-go/"
													data-type="image" data-bs-toggle="lightbox"
													data-bs-gallery="example-gallery" />
											</div>
											<div class="carousel-item" data-slide-number="2">
												<img src="https://source.unsplash.com/qlYQb7B9vog/1600x900/"
													class="d-block w-100" alt="..."
													data-remote="https://source.unsplash.com/qlYQb7B9vog/"
													data-type="image" data-bs-toggle="lightbox"
													data-bs-gallery="example-gallery" />
											</div>
											<div class="carousel-item" data-slide-number="3">
												<img src="https://source.unsplash.com/QfEfkWk1Uhk/1600x900/"
													class="d-block w-100" alt="..."
													data-remote="https://source.unsplash.com/QfEfkWk1Uhk/"
													data-type="image" data-bs-toggle="lightbox"
													data-bs-gallery="example-gallery" />
											</div>
											<div class="carousel-item" data-slide-number="4">
												<img src="https://source.unsplash.com/CSIcgaLiFO0/1600x900/"
													class="d-block w-100" alt="..."
													data-remote="https://source.unsplash.com/CSIcgaLiFO0/"
													data-type="image" data-bs-toggle="lightbox"
													data-bs-gallery="example-gallery" />
											</div>
											<div class="carousel-item" data-slide-number="5">
												<img src="https://source.unsplash.com/a_xa7RUKzdc/1600x900/"
													class="d-block w-100" alt="..."
													data-remote="https://source.unsplash.com/a_xa7RUKzdc/"
													data-type="image" data-bs-toggle="lightbox"
													data-bs-gallery="example-gallery" />
											</div>
											<div class="carousel-item" data-slide-number="6">
												<img src="https://source.unsplash.com/uanoYn1AmPs/1600x900/"
													class="d-block w-100" alt="..."
													data-remote="https://source.unsplash.com/uanoYn1AmPs/"
													data-type="image" data-bs-toggle="lightbox"
													data-bs-gallery="example-gallery" />
											</div>
											<div class="carousel-item" data-slide-number="7">
												<img src="https://source.unsplash.com/_snqARKTgoc/1600x900/"
													class="d-block w-100" alt="..."
													data-remote="https://source.unsplash.com/_snqARKTgoc/"
													data-type="image" data-bs-toggle="lightbox"
													data-bs-gallery="example-gallery" />
											</div>
											<div class="carousel-item" data-slide-number="8">
												<img src="https://source.unsplash.com/M9F8VR0jEPM/1600x900/"
													class="d-block w-100" alt="..."
													data-remote="https://source.unsplash.com/M9F8VR0jEPM/"
													data-type="image" data-bs-toggle="lightbox"
													data-bs-gallery="example-gallery" />
											</div>
											<div class="carousel-item" data-slide-number="9">
												<img src="https://source.unsplash.com/Q1p7bh3SHj8/1600x900/"
													class="d-block w-100" alt="..."
													data-remote="https://source.unsplash.com/Q1p7bh3SHj8/"
													data-type="image" data-bs-toggle="lightbox"
													data-bs-gallery="example-gallery" />
											</div>
										</div>
									</div>
									<div id="carousel-thumbs" class="carousel slide"
										data-bs-ride="carousel">
										<div class="carousel-inner">
											<div class="carousel-item active">
												<div class="row mx-0">
													<div id="carousel-selector-0"
														class="thumb col-4 col-sm-2 px-1 py-2 selected"
														data-bs-target="#myCarousel" data-bs-slide-to="0">
														<img
															src="https://source.unsplash.com/Pn6iimgM-wo/600x400/"
															class="img-fluid" alt="..." />
													</div>
													<div id="carousel-selector-1"
														class="thumb col-4 col-sm-2 px-1 py-2"
														data-bs-target="#myCarousel" data-bs-slide-to="1">
														<img
															src="https://source.unsplash.com/tXqVe7oO-go/600x400/"
															class="img-fluid" alt="..." />
													</div>
													<div id="carousel-selector-2"
														class="thumb col-4 col-sm-2 px-1 py-2"
														data-bs-target="#myCarousel" data-bs-slide-to="2">
														<img
															src="https://source.unsplash.com/qlYQb7B9vog/600x400/"
															class="img-fluid" alt="..." />
													</div>
													<div id="carousel-selector-3"
														class="thumb col-4 col-sm-2 px-1 py-2"
														data-bs-target="#myCarousel" data-bs-slide-to="3">
														<img
															src="https://source.unsplash.com/QfEfkWk1Uhk/600x400/"
															class="img-fluid" alt="..." />
													</div>
													<div id="carousel-selector-4"
														class="thumb col-4 col-sm-2 px-1 py-2"
														data-bs-target="#myCarousel" data-bs-slide-to="4">
														<img
															src="https://source.unsplash.com/CSIcgaLiFO0/600x400/"
															class="img-fluid" alt="..." />
													</div>
													<div id="carousel-selector-5"
														class="thumb col-4 col-sm-2 px-1 py-2"
														data-bs-target="#myCarousel" data-bs-slide-to="5">
														<img
															src="https://source.unsplash.com/a_xa7RUKzdc/600x400/"
															class="img-fluid" alt="..." />
													</div>
												</div>
											</div>
											<div class="carousel-item">
												<div class="row mx-0">
													<div id="carousel-selector-6"
														class="thumb col-4 col-sm-2 px-1 py-2"
														data-bs-target="#myCarousel" data-bs-slide-to="6">
														<img
															src="https://source.unsplash.com/uanoYn1AmPs/600x400/"
															class="img-fluid" alt="..." />
													</div>
													<div id="carousel-selector-7"
														class="thumb col-4 col-sm-2 px-1 py-2"
														data-bs-target="#myCarousel" data-bs-slide-to="7">
														<img
															src="https://source.unsplash.com/_snqARKTgoc/600x400/"
															class="img-fluid" alt="..." />
													</div>
													<div id="carousel-selector-8"
														class="thumb col-4 col-sm-2 px-1 py-2"
														data-bs-target="#myCarousel" data-bs-slide-to="8">
														<img
															src="https://source.unsplash.com/M9F8VR0jEPM/600x400/"
															class="img-fluid" alt="..." />
													</div>
													<div id="carousel-selector-9"
														class="thumb col-4 col-sm-2 px-1 py-2"
														data-bs-target="#myCarousel" data-bs-slide-to="9">
														<img
															src="https://source.unsplash.com/Q1p7bh3SHj8/600x400/"
															class="img-fluid" alt="..." />
													</div>
													<div class="col-2 px-1 py-2"></div>
													<div class="col-2 px-1 py-2"></div>
												</div>
											</div>
										</div>
										<a class="carousel-control-prev" href="#carousel-thumbs"
											role="button" data-bs-slide="prev"> <span
											class="carousel-control-prev-icon" aria-hidden="true"></span>
											<span class="sr-only">Previous</span>
										</a> <a class="carousel-control-next" href="#carousel-thumbs"
											role="button" data-bs-slide="next"> <span
											class="carousel-control-next-icon" aria-hidden="true"></span>
											<span class="sr-only">Next</span>
										</a>
									</div>
								</div>
							</div>
						</div>
						<div class="modal-footer">
							<button class="btn btn-light" data-bs-dismiss="modal"
								type="button">Close</button>
							<button class="btn btn-primary" type="button">Save</button>
						</div>
					</div>
				</div>
			</div>
		</div>
		<a class="d-inline border rounded scroll-to-top" href="#page-top"><i
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
