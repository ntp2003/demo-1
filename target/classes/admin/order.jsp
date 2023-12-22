<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, shrink-to-fit=no" />
<title>Order</title>
<link rel="stylesheet" href="/assets/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i&amp;display=swap">
<link rel="stylesheet" href="/assets/fonts/fontawesome-all.min.css">
<link rel="stylesheet" href="/assets/css/order.css">
</head>
<body>
	<div id="wrapper">
		<div class="d-flex flex-column" id="content-wrapper">
			<div id="content">
				<nav
					class="navbar navbar-expand bg-white shadow mb-4 topbar static-top navbar-light">
					<div class="container-fluid">
						<div class="row">
							<div class="col">
								<div
									class="d-sm-flex justify-content-between align-items-center mb-4">
									<h3 class="text-dark mb-0">Order Management</h3>
								</div>
							</div>
						</div>
						<a class="btn btn-primary btn-sm d-none d-sm-inline-block"
							role="button" href="#"><i
							class="fas fa-download text-white-50 fa-sm"></i>&nbsp;Generate
							Report</a>
					</div>
				</nav>
				<div class="container-fluid">
					<div class="row">
						<div class="col-md-6 col-xl-3 mb-4">
							<div class="card shadow border-start-primary py-2"
								style="background: var(--bs-card-cap-bg);">
								<div class="card-body">
									<div class="row align-items-center no-gutters">
										<div class="col me-2">
											<div class="text-uppercase fw-bold text-primary text-xs mb-1">
												<span>New orders</span>
											</div>
											<div class="fw-bold text-dark h5 mb-0">
												<span style="font-size: 16px;">Total order</span><br>
												<span style="font-size: 16px;" data-count="Not confirmed">0</span>
											</div>
										</div>
										<div class="col-auto">
											<i class="fas fa-calendar fa-2x text-gray-300"></i>
										</div>
									</div>
								</div>
							</div>
						</div>
						<div class="col-md-6 col-xl-3 mb-4">
							<div class="card shadow border-start-success py-2">
								<div class="card-body">
									<div class="row align-items-center no-gutters">
										<div class="col me-2">
											<div class="text-uppercase fw-bold text-warning text-xs mb-1">
												<span>CONFIRMED</span>
											</div>
											<div class="fw-bold text-dark h5 mb-0">
												<span style="font-size: 16px;">total order</span><br>
												<span style="font-size: 16px;" data-count="Awaiting delivery">0</span>
											</div>
										</div>
										<div class="col-auto">
											<i class="fas fa-dollar-sign fa-2x text-gray-300"></i>
										</div>
									</div>
								</div>
							</div>
						</div>
						<div class="col-md-6 col-xl-3 mb-4">
							<div class="card shadow border-start-info py-2">
								<div class="card-body">
									<div class="row align-items-center no-gutters">
										<div class="col me-2">
											<div class="text-uppercase fw-bold text-info text-xs mb-1">
												<span>BEING TRANSPORTED</span>
											</div>
											<div class="row g-0 align-items-center">
												<div class="col-auto">
													<div class="fw-bold text-dark h5 mb-0 me-3">
														<span style="font-size: 16px;">total order</span><br>
														<span style="font-size: 16px;"data-count="In progress">0</span>
													</div>
												</div>
											</div>
										</div>
										<div class="col-auto">
											<i class="fas fa-car-side fa-2x text-gray-300"></i>
										</div>
									</div>
								</div>
							</div>
						</div>
						<div class="col-md-6 col-xl-3 mb-4">
							<div class="card shadow border-start-warning py-2">
								<div class="card-body">
									<div class="row align-items-center no-gutters">
										<div class="col me-2">
											<div class="text-uppercase fw-bold text-success text-xs mb-1">
												<span>COMPLETED</span>
											</div>
											<div class="fw-bold text-dark h5 mb-0">
												<span style="font-size: 16px;">total order</span><br>
												<span style="font-size: 16px;"data-count="Completed">0</span>
											</div>
										</div>
										<div class="col-auto">
											<i class="fas fa-comments fa-2x text-gray-300"></i>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
					<div class="row">
						<div class="col">
							<div class="card shadow">
								<div class="card-body">
									<div class="row d-flex justify-content-between gap-2">
										<div
											class="col-auto d-flex justify-content-start align-items-center flex-wrap gap-2">
											<div class="d-flex gap-2">
												<div class="d-flex align-items-center">
													<label class="form-label form-label mb-0">From day: </label>
												</div>
												<div>
													<input id="fromDay" class="form-control-sm form-control" type="date">
												</div>
											</div>
											<div class="d-flex gap-2">
												<div class="d-flex align-items-center">
													<label class="form-label form-label mb-0">To day: </label>
												</div>
												<div>
													<input id="toDay" class="form-control-sm form-control" type="date">
												</div>
											</div>
										</div>
										<div
											class="col-auto d-flex flex-wrap justify-content-xl-end gap-2">
											<div class="d-flex align-items-center">
												<select
													class="form-select-sm d-inline-block form-select me-2"
													id="statusFilter"
													style="width: auto;">
													<option value="" selected="">All</option>
												</select>
											</div>
							
										</div>
									</div>
									<div id="dataTable-1" class="table-responsive table mt-2"
										role="grid" aria-describedby="dataTable_info">
										<div>
											<table class="table my-0 align-middle flex-fill"
												id="orderpage-tb">
												<thead>
													<tr>
														<th>InvoiceID</th>
														<th>AccountID</th>
														<th>Created Time</th>
														<th>Completed Time</th>
														<th>Price</th>
														<th>Payment Method</th>
														<th>Order Details</th>
														<th>Status</th>
														<th>Update</th>
													</tr>
												</thead>
												<tbody>
													
												</tbody>
											</table>
										</div>
										<div class="modal fade" role="dialog" tabindex="-1"
											id="orderDetails" aria-labelledby="orderDetails">
											<div class="modal-dialog modal-lg modal-dialog-centered"
												role="document">
												<div class="modal-content">
													<div class="modal-header">
														<h5 class="modal-title">Order
															Details</h5>
														<button class="btn-close" aria-label="Close"
															data-bs-dismiss="modal" type="button"></button>
													</div>
													<div class="modal-body bg-light">
														<div class="d-flex">
															<div style="min-width: 180px; max-width: 180px">
																<p class="d-flex gap-2 me-md-5" id="invoice-id">Invoice ID:</p>
															</div>
															<div class="d-flex align-items-center gap-2 ms-md-5">
																<p id="payment-method">Payment method:</p>
															</div>
														</div>
														<div class="d-flex">
															<div style="min-width: 180px; max-width: 180px">
																<p id="account-id" class="d-flex gap-2 me-md-5">Account ID:</p>
															</div>
															<div class="d-flex align-items-center gap-2 ms-md-5">
																<p id="customer-name">Customer Name:</p>
															</div>
														</div>
														<div>
															<p id="address" class="d-flex gap-2 me-md-5">Address:</p>
														</div>
														<div class="d-flex align-items-center gap-2">
															<p id="address-detail" class="d-flex flex-row align-items-center me-5">Address
																Detail:</p>
														</div>
														<div>
															<p id="phone-number">Phone Number:</p>
														</div>
														<div>
															<p id="shipping-fee">Shipping fee:</p>
														</div>
														<div class="table-responsive">
															<table id="p-in-order" class="table table-bordered">
																<caption class="caption-top">Item List</caption>
																<thead class="thead-dark">
																	<tr class="fs-6">
																		<th>Product ID</th>
																		<th style="width: 290px;">Product Item</th>
																		<th>Quantity</th>
																		<th>Original</th>
																		<th>Discount</th>
																		<th>Total</th>
																	</tr>
																</thead>
																<tbody>
																	<!-- <tr>
																		<td class="text-center">22</td>
																		<td class="text-break d-flex flex-column"
																			style="font-size: 12px;"><label
																			class="form-label">product name:
																				kdakjfhkjahsfkjahkjfhakjhfkja</label><label
																			class="form-label">color:</label><label
																			class="form-label">size:</label></td>
																		<td class="text-center">2902190390</td>
																		<td style="text-align: center;">Cell 4</td>
																		<td style="text-align: center;">Cell 5</td>
																		<td style="text-align: center;">Cell 6</td>
																	</tr> -->
																</tbody>
															</table>
														</div>
														<div class="d-flex justify-content-end me-2">
															<p id="order-total" class="d-flex flex-row align-items-center">Total :</p>
														</div>
													</div>
												</div>
											</div>
										</div>
									</div>
									<div class="row">
										<div class="col-md-6 col-xl-2 text-nowrap"
											style="max-width: 130px;">
											<label class="form-label" style="margin: 0px;">Show&nbsp;
											</label><select id="page-size"
												class="form-select-sm d-inline-block form-select"
												style="width: 70px;">
												<option value="10" selected="">10</option>
												<option value="25">25</option>
												<option value="50">50</option>
												<option value="100">100</option>
											</select>
										</div>
										<div class="col-md-6 col-xl-4 col-xxl-2 d-flex"
											style="margin-top: 4px;">
											<p id="dataTable-info" class="dataTables_info" role="status"
												aria-live="polite"></p>
										</div>
										<div class="col">
											<nav class="d-lg-flex justify-content-lg-end">
												<ul class="pagination">
												</ul>
											</nav>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<script src="https://unpkg.com/xlsx/dist/xlsx.full.min.js"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
	<script src="/assets/bootstrap/js/bootstrap.min.js"></script>
	<script src="/assets/js/notify.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/gasparesganga-jquery-loading-overlay@2.1.7/dist/loadingoverlay.min.js"></script>
	<script src="/assets/js/theme.js"></script>
	<script src="/assets/js/adminorder.js"></script>
</body>
</html>