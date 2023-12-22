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
	border-radius: 8px;
} /* Bo tròn góc hình */
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