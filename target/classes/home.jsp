<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Home</title>
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
<link rel="stylesheet"
	href="/assets/css/Simple-Slider-swiper-bundle.min.css">
<link rel="stylesheet" href="/assets/css/Simple-Slider.css">
<link rel="stylesheet" href="/assets/css/main.css">
<style>
input[type="checkbox"]:not(.custom-control-input) {
	display: none;
}

label.bg-color {
	display: inline-block;
	padding: 8px;
	margin-left: 5px;
	border: 1px solid #424949;
	/*  border: 2px solid #ccc;
		
		*/
	border-radius: 5px;
	cursor: pointer;
	user-select: none;
	transition: transform 0.3s;
	border-radius: 50%;
}
</style>
<script src="/assets/js/productHome-load.js"></script>
<script src="/assets/js/Simple-Slider-swiper-bundle.min.js"></script>
<script src="/assets/js/Simple-Slider.js"></script>
<script src="https://unpkg.com/swiper/swiper-bundle.min.js"></script>
<script>
	document.addEventListener("DOMContentLoaded", function() {
		var swiper = new Swiper(".swiper-container", {
			loop : true,
			autoplay : {
				delay : 2500,
				disableOnInteraction : false,
			},
			pagination : {
				el : ".swiper-pagination",
				clickable : true,
			},
			navigation : {
				nextEl : ".swiper-button-next",
				prevEl : ".swiper-button-prev",
			},
		});
	});
</script>
</head>
<body style="background-color: rgb(231, 238, 243);">
	<div id="slider" class="simple-slider">
		<div class="swiper-container">
			<div class="swiper-wrapper">
				<div class="swiper-slide"
					style="width: 100%; background: url(https://img.mwc.com.vn/giay-thoi-trang?w=1920&amp;h=0&amp;FileInput=/Resources/Silde/2023/11/30/NOEL-01.jpg) center center/cover no-repeat;"></div>
				<div class="swiper-slide"
					style="width: 100%; background: url(https://img.mwc.com.vn/giay-thoi-trang?w=1920&amp;h=0&amp;FileInput=/Resources/Silde/2023/11/30/NOEL-01.jpg) center center/cover no-repeat;"></div>
			</div>
			<div class="swiper-pagination"></div>
			<div class="swiper-button-prev"></div>
			<div class="swiper-button-next"></div>
		</div>
	</div>

	<!-- <div class="container" style="margin-top: 50px">
		<div class="row" style="margin-bottom: 50px">
			<div class="col-md-8 col-xl-6 text-center mx-auto bordered-container">
				<h4 class="text-uppercase text-center link-dark">Sản phẩm bán
					chạy</h4>
				<hr style="border-top: 2px dashed #616A6B;">
				<nav class="navbar navbar-expand-md navbar-light">
					<div class="container">
						Thêm nút cho menu khi màn hình nhỏ hơn md
						<button class="navbar-toggler" type="button"
							data-toggle="collapse" data-target="#navbarNav"
							aria-controls="navbarNav" aria-expanded="false"
							aria-label="Toggle navigation">
							<span class="navbar-toggler-icon"></span>
						</button>
						<div class="collapse navbar-collapse" id="navbarNav">
							<ul class="navbar-nav mx-auto">
								<li class="nav-item"><a class="nav-link"
									href="javascript:void(0);">Giày</a>
								</li>
								<li class="nav-item"><a class="nav-link"
									href="javascript:void(0);">Balo</a>
								</li>
								<li class="nav-item"><a class="nav-link"
									href="javascript:void(0);">Quần
										áo</a></li>
							</ul>
						</div>
					</div>
				</nav>
			</div>
		</div>
		<div class="container" id="container-giay">
			<div class="row" id="row-banchay-giay"></div>
		</div>


		<div class="container" id="container-balo">
			<div class="row" id="row-banchay-balo"></div>
		</div>
		<div class="container" id="container-quanao">
			<div class="row" id="row-banchay-quanao"></div>
		</div>
		<div class="text-center" id="more-xemthem-1">
			<a class="text-uppercase text-center link-dark" href="#">Xem thêm</a>
		</div>
	</div>
	<hr style="border-top: 1px solid #616A6B"> -->
	<!-- <section>
		<div class="container" style="margin-bottom: 30px;">
			<div class="text-center">
				<a class="text-uppercase fw-semibold" href="#"
					style="text-decoration: none;">
					<p class="fs-4 fw-normal text-dark">Giày nam</p>
				</a>
			</div>
			<div class="container">
				<div class="row" id="row-giay"></div>
			</div>
			<div class="text-center" id="more-xemthem-1">
				<a class="text-uppercase text-center link-dark" href="Sale">Xem
					thêm</a>
			</div>
		</div>
		<hr style="border-top: 1px solid #616A6B">


		<div class="container" style="margin-bottom: 30px;">
			<div class="text-center">
				<a class="text-uppercase fw-semibold" href="Sale"
					style="text-decoration: none;">
					<p class="fs-4 fw-normal text-dark">Balo</p>
				</a>
			</div>
			<div class="container">
				<div class="row" id="row-balo"></div>
			</div>
			<div class="text-center" id="more-xemthem-1">
				<a class="text-uppercase text-center link-dark" href="Sale">Xem
					thêm</a>
			</div>
		</div>

		<div class="container" style="margin-bottom: 30px;">
			<div class="text-center">
				<a class="text-uppercase fw-semibold" href="Sale"
					style="text-decoration: none;">
					<p class="fs-4 fw-normal text-dark">Quần áo</p>
				</a>
			</div>
			<div class="container">
				<div class="row" id="row-quanao"></div>
			</div>
			<div class="text-center" id="more-xemthem-1">
				<a class="text-uppercase text-center link-dark" href="Sale">Xem
					thêm</a>
			</div>
		</div>
	</section> -->

	<script src="https://code.jquery.com/jquery-1.10.2.min.js"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@4.1.1/dist/js/bootstrap.bundle.min.js"></script>
	<script type="text/javascript"></script>


	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>

	<script src="/assets/js/productHome-load.js" type="module"></script>
	<script src="/assets/js/theme.js"></script>
</body>
</html>