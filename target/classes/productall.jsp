<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<%@ include file="/common/hrefsheet.jsp"%>
<link rel="stylesheet" href="assets/css/main.css">
<link rel="stylesheet" href="assets/css/filterTemplate.css">
<link />
<link
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css"
	rel="stylesheet" />
<title>Product</title>
<style>
#searchResults {
	margin-top: 20px;
	position: absolute;
	z-index: 1000;
	background-color: white;
	box-shadow: 0px 4px 8px rgba(0, 0, 0, 0.1);
	width: 380px; /* Điều chỉnh chiều rộng của kết quả tìm kiếm */
	border-radius: 8px;
	overflow: hidden;
}

.product {
	position: relative;
	margin-bottom: 10px; /* Điều chỉnh margin giữa các kết quả tìm kiếm */
	padding: 10px; /* Điều chỉnh padding của kết quả tìm kiếm */
}

.product-container {
	display: flex;
	/*     margin-bottom: 10px;
 */
	padding-right: 10px;
	padding-top: 10px;
}

.product-container img {
	width: 60px; /* Điều chỉnh chiều rộng của ảnh sản phẩm */
	height: 60px; /* Điều chỉnh chiều cao của ảnh sản phẩm */
	object-fit: cover;
	/*     margin-right: 10px;
 */
	border-radius: 5px;
}

.product-info {
	flex: 1;
	padding-top: 10px; /* Điều chỉnh padding trên của thông tin sản phẩm */
}

.countSP {
	display: flex;
	justify-content: end;
}

.product-container h3 {
	font-size: 14px;
	margin: 0;
	color: #333;
}

.product-info p {
	font-size: 12px;
	color: #777;
	margin: 10px 0;
}

.sale-overlay-search {
	position: absolute;
	top: 0;
	right: 0;
	border-radius: 5px;
	background-color: red;
	color: white;
	padding: 3px 5px; /* Điều chỉnh padding của hộp Sale */
}

.product-image2 {
	position: relative;
}

.sale-overlay {
	position: absolute;
	top: 0;
	left: 0;
	background-color: rgba(255, 0, 0, 0.8);
	/* Màu nền overlay (ở đây là màu đỏ) */
	color: #fff; /* Màu chữ */
	padding: 3px 5px;
	font-size: 16px;
	border-radius: 8px; /* Bo tròn góc hình */
}
</style>

<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
</head>
<body style="background-color: rgb(231, 238, 243);">
	<form id="filter-form">
		<div class="filter-container"
			style="display: inline-block; flex-wrap: wrap; margin-top: 100px; border: 2px solid #D6EAF8; border-radius: 5px;">
			<div class="Price-filter"
				style="margin-bottom: 15px; border: 2px solid #D6EAF8; border-radius: 5px;">
				<article class="filter-group">
					<header class="card-header"
						style="border: 2px solid #D6EAF8; border-radius: 5px;">
						<a style="text-decoration: none;" href="#" data-toggle="collapse"
							data-target="#collapse_3" aria-expanded="true" class="">
							<h6 style="font-size: 18px" class="title">Price</h6>
						</a>
					</header>
					<div class="filter-content collapse show" id="collapse_3">
						<div class="card-body" style="display: grid">
							<div class="form-group">
								<div class="form-check">
									<input class="form-check-input" type="radio" name="priceOption"
										checked> <label class="form-check-label"> All
									</label>
								</div>
								<div class="form-check">
									<input class="form-check-input" data-max="300" type="radio" name="priceOption">
									<label class="form-check-label"> 0$ - 300$ </label>
								</div>
								<div class="form-check">
									<input class="form-check-input" data-min="300" data-max="600" type="radio" name="priceOption">
									<label class="form-check-label"> 300$ - 600$ </label>
								</div>
								<div class="form-check">
									<input class="form-check-input" data-min="600" data-max="900" type="radio" name="priceOption">
									<label class="form-check-label"> 600$ - 900$ </label>
								</div>
								<div class="form-check">
									<input class="form-check-input" data-min="900" type="radio" name="priceOption">
									<label class="form-check-label"> > 900$ </label>
								</div>
							</div>
						</div>
					</div>

				</article>
			</div>
		</div>
	</form>
	<div class="container" style="margin-top: 100px;">
		<div class="row">
			<div class="orderby"
				style="display: flex; justify-content: center; align-items: center; gap: 20px">
				<div class="col-sm-4 text-center">
					<div class="input-group">
						<input type="text" class="form-control" id="searchInput" />
					</div>
					<div id="searchResults" style="position: absolute;">
					</div>
				</div>


				<div class="form-inline">
					<select id="sort-option" class="mr-2 form-control">
						<option value="productName,asc" selected="selected">Name ASC A-Z</option>
						<option value="productName,desc">Name DESC Z-A</option>
						<option value="price,asc">Price Low to High</option>
						<option value="price,desc">Price High to Low</option>
						<option value="purchaseCount,desc">Hot</option>
						<option value="releaseDate,desc">New</option>
					</select>
				</div>
			</div>
			<div class="row d-flex justify-content-between"
				style="margin-top: 50px; margin-left: 20px">
				<div
					class="col-md-6 col-xl-5 text-nowrap d-flex justify-content-start align-items-xl-center column-gap-3">
					<div>
						<label class="form-label" style="margin: 0px">Show&nbsp; </label><select
							class="form-select-sm d-inline-block form-select" id="page-size"
							style="width: 100px">
							<option value="12" selected="selected">12</option>
							<option value="24">24</option>
							<option value="48">48</option>
						</select>
					</div>
				</div>
			</div>
			<div class="container" style="min-height: 70vh">

				<div class="row" id="row-all"></div>

			</div>
			<div class="row" style="margin-top: 50px">
				<div class="col-md-6 align-self-center">
					<p id="dataTable-info" role="status"
						aria-live="polite">Showing 1 to 10 of 27</p>
				</div>
				<div class="col-md-6" id="pagination-box">
					<nav
						class="d-lg-flex justify-content-lg-end dataTables_paginate paging_simple_numbers">
						<ul class="pagination">
							<li class=""><a class="page-link" aria-label="Previous"
								href="#"><span aria-hidden="true">«</span></a></li>
							<li class=""><a class="page-link" aria-label="Next" href="#"><span
									aria-hidden="true">»</span></a></li>
						</ul>
					</nav>
				</div>
			</div>
		</div>
	</div>
	<div class="push"></div>
	<script src="https://code.jquery.com/jquery-1.10.2.min.js"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@4.1.1/dist/js/bootstrap.bundle.min.js"></script>
	<script type="text/javascript"></script>
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
		<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"> </script>
		
	<script src="/assets/js/product-load.js" type="module"></script>
	<script src="/assets/js/theme.js"></script>
</body>
</html>