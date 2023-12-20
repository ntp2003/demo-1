<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Promotion</title>
<link rel="stylesheet"
	href="https://maxcdn.icons8.com/fonts/line-awesome/1.1/css/line-awesome.min.css">
</head>
<body>
	<div class="container-fluid">
		<div class="row">
			<div class="col">
				<div class="card shadow">
					<div class="card-header py-3">
						<p class="fw-bold text-primary m-0">Promotion Info</p>
					</div>
					<div class="card-body">
						<div class="row d-flex justify-content-between">
							<div
								class="col d-flex justify-content-start align-items-center flex-wrap gap-2">
								<div class="d-flex gap-2">
									<div class="d-flex align-items-center">
										<label class="form-label mb-0">From Day:&nbsp;</label>
									</div>
									<div>
										<input class="form-control-sm form-control" id="from-day"
											type="date">
									</div>
								</div>
								<div class="d-flex gap-2">
									<div class="d-flex align-items-center">
										<label class="form-label mb-0">To Day:&nbsp;</label>
									</div>
									<div>
										<input class="form-control-sm form-control" id="to-day"
											type="date">
									</div>
								</div>
							</div>
							<div
								class="col-md-6 col-lg-7 col-xl-7 col-xxl-6 d-flex flex-wrap justify-content-xl-end">
								<div class="d-flex align-items-center">
									<button class="btn btn-success btn-sm border-0 me-2"
										data-bs-target="#add-promotion-modal" data-bs-toggle="modal"
										type="button"
										style="color: rgb(255, 255, 255); border-style: none; width: 133.025px; min-width: 100px;">
										<i class="la la-plus me-1" style="font-weight: bold;"></i><strong>Add
											Promotion</strong>
									</button>
								</div>
								<div class="d-flex flex-wrap gap-2">
									<div class="d-flex align-items-center">
										<input class="form-control-sm form-control me-2" type="search"
											aria-controls="dataTable" id="searchInput"
											placeholder="Search" style="width: 216.8px;">
									</div>
								</div>
							</div>
						</div>
						<div id="promotion-table-box"
							class="table-responsive table mt-2  text-center" role="grid"
							aria-describedby="dataTable-info">
							<div>
								<table class="table my-0 align-middle flex-fill"
									id="promotion-table">
									<thead>
										<tr>
											<th style="width: 120px;">Promotion ID</th>
											<th>Promotion Name</th>
											<th style="width: 160px;">Start Time</th>
											<th style="width: 160px;">End Time</th>
											<th style="width: 100px;">Banner</th>
											<th style="width: 160px;">Promotion Detail</th>
											<th style="width: 70px;"></th>
										</tr>
									</thead>
									<tbody>
									</tbody>
								</table>
							</div>

						</div>
						<div class="row">
							<div class="col-md-6 align-self-center flex">
								<div class="d-flex align-items-center dataTables_length"
									id="dataTable_length" aria-controls="dataTable">
									<label class="form-label text-start form-label mb-0 me-2">Show</label><select
										class="form-select-sm d-inline-block form-select me-3"
										id="page-size" style="width: auto;">
										<option value="10" selected="">10</option>
										<option value="25">25</option>
										<option value="50">50</option>
										<option value="100">100</option>
									</select>
									<p id="dataTable-info" class="dataTables_info mb-0 me-2"
										role="status" aria-live="polite">Showing 1 to 10 of 27</p>
								</div>
							</div>
							<div class="col-md-6">
								<nav
									class="d-lg-flex justify-content-lg-end dataTables_paginate paging_simple_numbers">
									<ul class="pagination">
										<li class="page-item disabled"><a class="page-link"
											aria-label="Previous" href="#"><span aria-hidden="true">«</span></a></li>
										<li class="page-item active"><a class="page-link"
											href="#">1</a></li>
										<li class="page-item"><a class="page-link" href="#">2</a></li>
										<li class="page-item"><a class="page-link" href="#">3</a></li>
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
	</div>
	<div class="modal fade" role="dialog" tabindex="-1"
		id="add-promotion-modal">
		<div class="modal-dialog modal-lg modal-dialog-centered modal-md"
			role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="text-primary modal-title">
						<strong>Add Promotion</strong>
					</h5>
					<button class="btn-close" aria-label="Close"
						data-bs-dismiss="modal" type="button"></button>
				</div>
				<div class="modal-body mx-3">
					<div class="d-flex gap-3">
						<div class="d-flex">
							<p class="mt-1">Promotion name:</p>
						</div>
						<div>
							<input class="form-control-sm form-control" id="promotionName"
								name="promotionName" form="add-promotion-form" type="text"
								required>
						</div>
					</div>
					<div class="col d-flex align-items-center flex-wrap gap-5">
						<div class="d-flex gap-2 me-5">
							<div class="d-flex align-items-center">
								<label class="form-label mb-0">Start Time:&nbsp;</label>
							</div>
							<div>
								<input class="form-control-sm form-control" name="startTime"
									id="startTime" form="add-promotion-form" type="date" required>
							</div>
						</div>
						<div class="d-flex gap-2">
							<div class="d-flex align-items-center">
								<label class="form-label mb-0">End Time:&nbsp;</label>
							</div>
							<div>
								<input class="form-control-sm form-control" name="endTime"
									id="endTime" form="add-promotion-form" type="date" required>
							</div>
						</div>
					</div>
					<div class="d-flex justify-content-end mt-3">
						<button class="btn btn-success btn-sm link-light" id="add-product"
							type="button">
							<strong>Add Product</strong>
						</button>
					</div>
					<div class="table-responsive mt-3"
						style="max-height: 300px; overflow-y: scroll;">
						<table id="added-product-table"
							class="table table-hover table-bordered">
							<thead class="thead-dark">
								<tr class="table-light">
									<th style="width: 110px;">Product ID</th>
									<th>Product Name</th>
									<th style="width: 130px;">Discount Rate</th>
									<th style="width: 60px;"></th>
								</tr>
							</thead>
							<tbody>
								<!-- <tr>
                <td><input class="form-control-sm form-control" type="search" style="margin: 0px auto;width: 70px;" /></td>
                <td class="text-break"></td>
                <td>
                    <div class="input-group input-group-sm" style="margin: 0px auto;width: 80px;"><input class="form-control" type="text" /><span class="input-group-text">%</span></div>
                </td>
                <td style="text-align: center;width: 50px;"><button class="btn btn-danger btn-sm btn-circle ms-1" role="button" type="button"><i class="fas fa-trash text-white"></i></button></td>
            </tr> -->
							</tbody>
						</table>
					</div>
					<div class="d-flex mt-2">
						<button class="btn btn-success btn-sm link-light mb-2"
							id="addBannerButton" type="button">
							<strong>Add Banner</strong>
						</button>
					</div>
					<input type="file" accept="image/*" id="bannerInput"
						style="display: none;" form="add-promotion-form" required>
					<div class="ms-3" id="photoFrame"
						style="width: 600px; height: 280px; border: 1px solid #ddd; margin-top: 10px; text-align: center; overflow: hidden; position: relative;">
						<img id="selectedBanner" style="width: 100%; height: 100%;">
					</div>
				</div>
				<div class="modal-footer mx-1">
					<form id="add-promotion-form">
						<button class="btn btn-primary me-2" type="submit">Submit</button>
					</form>
				</div>
			</div>
		</div>
	</div>
	<div class="modal fade" role="dialog" tabindex="-1"
		id="promotion-detail-modal">
		<div class="modal-dialog modal-lg modal-dialog-centered modal-md"
			role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h4 class="modal-title">Promotion Detail</h4>
					<button class="btn-close" aria-label="Close"
						data-bs-dismiss="modal" type="button"></button>
				</div>
				<div class="modal-body">
					<div class="d-flex gap-3">
						<div class="d-flex">
							<p class="mt-1 p-name">Promotion name:</p>
						</div>
					</div>
					<div class="col d-flex flex-row align-items-xxl-center">
						<div class="d-flex gap-2 me-md-5">
							<div class="d-flex align-items-center">
								<label class="form-label mb-0 s-time">Start Time: </label>
							</div>
						</div>
						<div class="d-flex gap-2 ms-md-5">
							<div class="d-flex align-items-center">
								<label class="form-label mb-0 e-time">End Time:&nbsp;</label>
							</div>
						</div>
					</div>
					<div class="table-responsive text-center mt-3">
						<table id="promotion-detail-table" class="table table-bordered">
							<thead class="thead-dark">
								<tr class="table-active">
									<th style="width: 110px;">Product ID</th>
									<th>Product Name</th>
									<th style="width: 150px;">Discount Rate</th>
								</tr>
							</thead>
							<tbody>
								
							</tbody>
						</table>
					</div>
				</div>
			</div>
		</div>
	</div>
	<script src="/assets/js/adminpromotion.js"></script>
</body>
</html>