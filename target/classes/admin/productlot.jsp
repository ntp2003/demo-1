<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="container-fluid">
		<h3 class="text-dark mb-4">Product Lot</h3>
		<div class="card shadow">
			<div class="card-header py-3">
				<p class="fw-bold text-primary m-0">Product Lot Infomation</p>
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
								<input class="form-control-sm form-control" type="date">
							</div>
						</div>
						<div class="d-flex gap-2">
							<div class="d-flex align-items-center">
								<label class="form-label mb-0">To Day:&nbsp;</label>
							</div>
							<div>
								<input class="form-control-sm form-control" type="date">
							</div>
						</div>
					</div>
					<div
						class="col-md-6 col-lg-7 col-xl-7 col-xxl-6 d-flex flex-wrap justify-content-xl-end">
						<div class="d-flex align-items-center">
							<button class="btn btn-success btn-sm" type="button"
								data-bs-toggle="modal" data-bs-target="#add-lot-modal"
								style="margin: 16px; max-height: 34px; border-style: none; text-align: center; font-size: 16px; color: #ffffff;">
								<i class="fas fa-plus"></i>&nbsp;Add Lot
							</button>
						</div>
						<div class="d-flex flex-wrap gap-2">
							<div class="d-flex align-items-center">
								<select class="form-select-sm d-inline-block form-select">
									<option value="" selected="">Name</option>
									<option value="">Phone number</option>
									<option value="">Email</option>
								</select>
							</div>
							<div class="d-flex align-items-center">
								<input class="form-control-sm form-control" type="search"
									aria-controls="dataTable" placeholder="Search"
									style="max-height: 31px;">
							</div>
						</div>
					</div>
				</div>
				<div class="table-responsive table mt-2" id="producttable"
					role="grid" aria-describedby="dataTable_info">
					<table class="table my-0 align-middle table-hover" id="dataTable">
						<thead>
							<tr>
								<th>Lot ID</th>
								<th>Import Date</th>
								<th>Confirmer Name</th>
								<th>Confirmer Phone Numer</th>
								<th>Email</th>
								<th>Details</th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td>1</td>
								<td>20/11/2023</td>
								<td>Nguyen Tan Phat</td>
								<td>0777166027</td>
								<td>pdjapjdajlkdjlakdklajkldjakl</td>
								<td><a role="button" href="#"
									data-bs-target="#lot-details-modal" data-bs-toggle="modal">View</a></td>
							</tr>
							<tr>
								<td>1</td>
								<td>20/11/2023</td>
								<td>Nguyen Tan Phat</td>
								<td>0777166027</td>
								<td>nkadlkajlkdjlkajdlkaslkjdalkj</td>
								<td><a role="button" href="#">View</a></td>
							</tr>
							<tr>
								<td>1</td>
								<td>20/11/2023</td>
								<td>Nguyen Tan Phat</td>
								<td>0777166027</td>
								<td>aklkdlkajdklajlkdlkajlkdjkajlk</td>
								<td><a role="button" href="#">View</a></td>
							</tr>
							<tr>
								<td>1</td>
								<td>20/11/2023</td>
								<td>Nguyen Tan Phat</td>
								<td>0777166027</td>
								<td>jkahjdhjadljalkdjklajdklajkldj</td>
								<td><a role="button" href="#">View</a></td>
							</tr>
						</tbody>
					</table>
				</div>
				<div class="row">
					<div class="col-md-6 col-xl-2 text-nowrap"
						style="max-width: 130px;">
						<label class="form-label" style="margin: 0px;">Show&nbsp;
						</label><select class="form-select-sm d-inline-block form-select"
							style="width: 70px;">
							<option value="10" selected="">10</option>
							<option value="25">25</option>
							<option value="50">50</option>
							<option value="100">100</option>
						</select>
					</div>
					<div class="col-md-6 col-xl-4 col-xxl-2 d-flex"
						style="margin-top: 4px;">
						<p id="dataTable_info" class="dataTables_info" role="status"
							aria-live="polite">Showing 1 to 10 of 27</p>
					</div>
					<div class="col">
						<nav class="d-lg-flex justify-content-lg-end">
							<ul class="pagination">
								<li class="page-item disabled"><a class="page-link"
									aria-label="Previous" href="#"><span aria-hidden="true">«</span></a></li>
								<li class="page-item active"><a class="page-link" href="#">1</a></li>
								<li class="page-item"><a class="page-link" href="#">2</a></li>
								<li class="page-item"><a class="page-link" href="#">2</a></li>
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
	<div class="modal fade" role="dialog" tabindex="-1" id="add-lot-modal"
		aria-labelledby="exampleModalLabel">
		<div class="modal-dialog modal-lg" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h4>Add Lot</h4>
					<button class="btn-close" type="button" aria-label="Close"
						data-bs-dismiss="modal"></button>
				</div>
				<div class="modal-body">
					<div class="col" style="text-align: right;">
						<div></div>
						<a class="btn btn-success btn-sm text-white me-2" role="button"
							id="add-category"><i class="fas fa-plus"></i>&nbsp;Add
							Category</a>
					</div>
					<div class="table-responsive table mt-2 px-2" id="type-table"
						role="grid" aria-describedby="dataTable_info"
						style="border-radius: 5px; display: block; height: 300px; text-align: center;">
						<table
							class="table table-hover table-bordered my-0 table-bordered align-middle"
							id="category-table-add">
							<thead class="table-dark">
								<tr>
									<th>Product ID</th>
									<th>Product Name</th>
									<th>Color</th>
									<th>Size</th>
									<th>Quantity</th>
									<th></th>
								</tr>
							</thead>
							<tbody>
								<tr>
									<td>Airi Satou</td>
									<td class="text-break col-md-4">Balo msmsmmsmsmmssms</td>
									<td>
										<div class="dropdown">
											<button class="btn btn-sm" aria-expanded="false"
												data-bs-toggle="dropdown" type="button"
												style="background: #a33232; width: 50px; height: 30px; padding: 0px; border-radius: 0px;"></button>
											<div class="dropdown-menu"
												style="padding: 5px; margin: 0px; margin-left: 13px; min-width: 55px; max-width: 55px;">
												<a class="dropdown-item"
													style="width: 43px; height: 30px; background: #358742; padding: 0px;"
													role="button"></a><a class="dropdown-item"
													style="width: 43px; height: 30px; background: #172fac; padding: 0px;"
													role="button"></a><a class="dropdown-item"
													style="width: 43px; height: 30px; background: #850e79; padding: 0px;"
													role="button"></a>
											</div>
										</div>
									</td>
									<td><select class="form-select-sm form-control">
											<option value="12" selected="">XL</option>
											<option value="13">XXL</option>
											<option value="14">M</option>
									</select></td>
									<td><input class="focus-ring form-control-sm form-control"
										type="text" required="" style="width: 70px;"></td>
									<td><a class="btn btn-danger btn-circle ms-1"
										role="button"><i class="fas fa-trash text-white"></i></a></td>
								</tr>
								<!-- <tr>
									<td><input
										class="focus-ring form-control-sm w-75 form-control"
										type="search" style="margin: 0px auto;"></td>
									<td class="text-break col-md-4"><label
										class="form-label text-danger mb-0">Not Found Product</label></td>
									<td></td>
									<td></td>
									<td></td>
									<td><a class="btn btn-danger btn-circle ms-1"
										role="button"><i class="fas fa-trash text-white"></i></a></td>
								</tr> -->
							</tbody>
						</table>
					</div>
				</div>
				<div class="modal-footer">
					<button class="btn btn-primary me-2" type="button">Submit</button>
				</div>
			</div>
		</div>
	</div>
	<div class="modal fade" role="dialog" tabindex="-1"
		id="lot-details-modal" aria-labelledby="exampleModalLabel">
		<div class="modal-dialog modal-lg modal-dialog-centered"
			role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h4>Lot Details</h4>
					<button class="btn-close" type="button" aria-label="Close"
						data-bs-dismiss="modal"></button>
				</div>
				<div class="modal-body">
					<div>
						<div class="container">
							<div class="row">
								<div class="col-md-12">
									<label class="col-form-label">Lot ID :</label>
								</div>
							</div>
						</div>
						<div class="container">
							<div class="row">
								<div class="col-md-6">
									<label class="col-form-label">Confirmer :</label>
								</div>
								<div class="col-md-6">
									<label class="col-form-label">Import Date :&nbsp;</label>
								</div>
							</div>
						</div>
					</div>
					<div class="table-responsive table mt-2 px-2" id="type-table-2"
						role="grid" aria-describedby="dataTable_info"
						style="border-radius: 5px; display: block; height: 300px; text-align: center;">
						<table
							class="table table-hover table-bordered my-0 table-bordered align-middle"
							id="dataTable">
							<thead class="table-dark">
								<tr>
									<th>Product ID</th>
									<th>Product Name</th>
									<th>Color</th>
									<th>Size</th>
									<th>Quantity</th>
								</tr>
							</thead>
							<tbody>
								<tr>
									<td>Airi Satou</td>
									<td class="text-break col-md-4">Balo msmsmmsmsmmssms</td>
									<td>
										<div
											style="background: #e11b1b; width: 50px; height: 30px; margin: 0px auto;"></div>
									</td>
									<td>XL</td>
									<td>111</td>
								</tr>
							</tbody>
						</table>
					</div>
				</div>
			</div>
		</div>
	</div>
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
	<script src="/assets/js/productlot.js"></script>
</body>
</html>