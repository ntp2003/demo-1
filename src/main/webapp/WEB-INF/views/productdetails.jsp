<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>Product detail</title>
<link rel="stylesheet" href="/assets/css/productdetails.css" />
<link rel="stylesheet" href="/assets/css/main.css">
<link rel="stylesheet" href="/assets/css/filterTemplate.css">
<link />
</head>
<body style="background-color: rgb(231, 238, 243);">
	<div class="container mt-5 mb-5">
		<div class="row d-flex justify-content-center">
			<div class="col-md-12">
				<div class="card">
					<div class="row">
						<div class="d-flex justify-content-start align-items-center">
							<div class="d-flex align-items-center" style="padding: 15px">
								<a class="backProduct" href="javascript: history.go(-1)" style="text-decoration: none">
									<i class="fa fa-long-arrow-left"></i> <span class="ml-1">Back</span>
								</a>
							</div>
						</div>
						<div class="col-md-6">
							<div class="images p-3">
								<div class="text-center p-4">
									<div class="image-container w-100">
										<img id="main-image"/>
									</div>
								</div>
								<div class="thumbnail mx-4 d-flex justify-content-start gap-2 text-center">
								</div>
							</div>
						</div>
						<div class="col-md-6">
							<div class="product p-4" style="margin-left: 30px">

								<div class="mt-4 mb-3">
									<span id="brand" class="text-uppercase text-muted brand">Ananas</span>
									<h5 id="product-name" class="text-uppercase"></h5>
									<div id="price-box" class="price d-flex flex-row align-items-center gap-2">
									</div>
								</div>
								<hr class="decription" />
								<div class="Color-filter mt-2">
									<article class="filter-group">
										<label class="form-label" for="">Color</label>
										<div class="filter-content collapse show" id="collapse_1">
											<div class="card-body-product">
												<ul class="nav tree" style="list-style-type: none">
													<li id="color-select" class="cb-color"></li>
												</ul>
											</div>
										</div>
									</article>
								</div>
								<div class="sizes mb-2">
									<h6 class="text-uppercase">Size</h6>
									<div id="size-select" class="d-flex gap-2">
									</div>
								</div>
								<div class="quantity">
									<div class="d-flex form-outline" style="width: 10rem">
										<label class="form-label me-2" for="typeNumber">Quantity</label>
										<input min="1" type="number" id="typeNumber"
											form="update-cart-form"
											value="1" onkeypress="return isNumber(event)"
											onpaste="return false;" class="form-control form-control-sm" required/>

									</div>
									<span id="stock-item"></span>
								</div>
								<hr class="decription" />
								<form id="update-cart-form">
								<div class="cart mt-4 align-items-center">
									<button id="add-to-cart" style="min-width: 150px; margin: 10px"
										type="submit"
										class="btn btn-success btn-md text-uppercase mr-2 px-4" disabled>
										Add to cart</button>
								
									<a
										style="min-width: 30px; margin: 10px; border: 1px solid #42dca3"
										class="btn" href="/customer/Cart" type="button">
										<i class="fa-solid fa-cart-shopping fa-lg"
											style="color: #42dca3"></i>
									</a>
								</div>
								</form>
							</div>
						</div>

						<div class="decriptionProduct mb-4" style="margin-left: 30px">
							<hr style="width: 90%" class="decription" />
							<h5 class="text-uppercase">Decription Product</h5>
							<p class="about" style="margin-right: 30px"></p>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<script src="/assets/js/numberinput.js"></script>
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
	
	<script src="/assets/js/notify.js"></script>
	<script src="/assets/js/productdetail-load.js"></script>
</body>
</html>
