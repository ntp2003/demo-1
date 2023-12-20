<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html data-bs-theme="light" lang="en">

<head>
<meta charset="utf-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, shrink-to-fit=no" />
<title>Product</title>
</head>

<body>
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
								id="page-size" style="width: 100px">
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
									style="color: rgb(255, 255, 255)" type="button">Sort
									By</button>
								<div class="dropdown-menu" id="sort-option"
									value="productName,asc">
									<a class="dropdown-item" value="productName,asc">ProductName:
										A -&gt; Z</a> <a class="dropdown-item" value="productName,desc">ProductName:
										Z -&gt; A</a> <a class="dropdown-item" value="purchaseCount,asc">PuchaseCount:
										increases</a> <a class="dropdown-item" value="purchaseCount,desc">PuchaseCount:
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
								<svg xmlns="http://www.w3.org/2000/svg" width="1em" height="1em"
									viewbox="0 0 24 24" fill="none"
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
								<th>ProductID</th>
								<th>Product Name</th>
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
						<p id="p-catalog-dt-info" class="dataTables_info" role="status"
							aria-live="polite">Showing 1 to 10 of 27</p>
					</div>
					<div class="col-md-6" id="pagination-box">
						<nav
							class="d-lg-flex justify-content-lg-end dataTables_paginate paging_simple_numbers">
							<ul class="pagination">
								<li class=""><a class="page-link" aria-label="Previous"
									href="#"><span aria-hidden="true">«</span></a></li>
								<li class=""><a class="page-link" aria-label="Next"
									href="#"><span aria-hidden="true">»</span></a></li>
							</ul>
						</nav>
					</div>
				</div>
			</div>
		</div>
	</div>

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
								<input class="form-control" type="text" id="origin" required="" />
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
	<div class="modal fade" role="dialog" tabindex="-1" id="add-images">
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
											drop or <span class="file-link"> Choose your files or
												images </span>
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
	<div class="modal fade" role="dialog" tabindex="-1" id="show-type">
		<div class="modal-dialog modal-lg" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="mb-0 mt-1"></h5>
					<button class="btn-close" type="button" aria-label="Close"
						data-bs-dismiss="modal"></button>
				</div>
				<div class="modal-body">
					<div>
						<div class="container">
							<div class="row">
								<div class="col-md-12">
									<label class="col-form-label" id="product-id-lbl">Mã
										sản phẩm :</label>
								</div>
							</div>
						</div>
						<div class="container">
							<div class="row">
								<div class="col-md-6">
									<label class="col-form-label" id="product-brand-lbl">Thương
										hiệu :</label>
								</div>
								<div class="col-md-6">
									<label class="col-form-label" id="product-re-date-lbl">Ngày
										phát hành :</label>
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
										<a class="custom-btn light-btn" role="button"
											style="background: #1eb53a; color: var(--bs-body-bg);"
											data-bs-target="#add-type" data-bs-toggle="modal"><i
											class="fas fa-plus"
											style="font-size: 21px; padding-bottom: 0px; padding-right: 0px; padding-left: 0px; transform: translateY(2px);"></i>
										</a> <a id="delete-p-categories" class="custom-btn light-btn"
											role="button"
											style="background: #e84c3d; color: var(--bs-body-bg);"><i
											class="fa fa-trash"
											style="font-size: 22px; transform: translateY(2px);"></i> </a> <a
											id="refresh-categories" class="custom-btn light-btn"
											role="button"
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
										id="product-category-dt">
										<thead class="table-dark">
											<tr>
												<th>Select</th>
												<th>ID</th>
												<th>Color</th>
												<th>Price</th>
												<th>Image</th>
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
										id="price-input" onkeypress="return isNumber(event)"
										onpaste="return false;" required />
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
				<div class="modal-body mt-0 mb-2">
					<div class="d-flex justify-content-lg-end">
						<button id="clear-images-btn" class="btn btn-danger" type="button"
							style="font-weight: bold; padding: 3px 12px">
							<i class="fas fa-trash"
								style="padding-right: 0px; margin-right: 7px"></i>Clear
						</button>
					</div>
					<div class="container mt-2 mb-3">
						<div class="row carousel-container position-relative">

							<div id="myCarousel" class="carousel slide"
								data-bs-ride="carousel">
								<div class="carousel-inner"></div>
							</div>
							<div id="carousel-thumbs" class="carousel slide"
								data-bs-interval="false">
								<div class="carousel-inner"></div>
								<a class="carousel-control-prev" href="#carousel-thumbs"
									role="button" data-bs-slide="prev"> <span
									class="carousel-control-prev-icon" aria-hidden="true"></span> <span
									class="sr-only">Previous</span>
								</a> <a class="carousel-control-next" href="#carousel-thumbs"
									role="button" data-bs-slide="next"> <span
									class="carousel-control-next-icon" aria-hidden="true"></span> <span
									class="sr-only">Next</span>
								</a>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	</div>
	</div>
	<a class="d-inline border rounded scroll-to-top" href="#page-top"><i
		class="fas fa-angle-up"></i></a>
	</div>
	
	
	<script src="/assets/js/product-type-action.js" type="module"></script>
</body>

</html>