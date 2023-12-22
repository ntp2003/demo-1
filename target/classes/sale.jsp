<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <title>Sale</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
	<link rel="stylesheet" href="/assets/css/main.css">
	<link rel="stylesheet" href="/assets/css/filterTemplate.css"><link />
	<link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css" rel="stylesheet"/>
  <style>
	.jumbotron {
	  display: flex;
	  flex-direction: column;
	  align-items: center;
	  justify-content: center;
	  position: relative;
	  background-image: url("${promotion.banner}");
	  background-size: cover;
	  background-position: center;
	  color: #fff;
	  text-align: center;
	  min-width: 100%;
	  height: 400px;
	}
	
	.jumbotron::before {
	  content: '';
	  position: absolute;
	  top: 0;
	  left: 0;
	  width: 100%;
	  height: 100%;
	  background: inherit;
	  filter: blur(8px); /* Adjust the blur intensity as needed */
	}

/* Media query for screens smaller than 1000px */
	@media (max-width: 1000px) {
	  .jumbotron {
	    min-width: 100%;
	    max-height: none; /* Remove the max-height property for smaller screens */
	  }
	}
    .jumbotron h1,
    .jumbotron p {
      position: relative; /* Ensure that text appears above the blurred layer */
      z-index: 1;
      color: white;
      font-weight: bolder;
    }
 #demo {
    line-height: 1;
    padding: 20px;
    font-size: 40px;
    color: #f07c22;
    background-color: #000; /* Màu nền đen */
    border-radius: 10px; /* Góc bo tròn */
    display: inline-block; /* Hiển thị như một khối inline */
    animation: fadeIn 1s ease-in-out; /* Hiệu ứng fadeIn */
  }

  @keyframes fadeIn {
    from {
      opacity: 0;
    }
    to {
      opacity: 1;
    }
  }
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
  <script>
  console.log("${promotion.endTime}" + " GMT+07:00");
    var countDownDate = new Date("${promotion.endTime}" + " GMT+07:00").getTime();
    countDownDate += 86400000;

 	// Update the count down every 1 second
 	var x = setInterval(function() {

   // Get today's date and time
   var now = new Date().getTime();

   // Find the distance between now and the count down date
   var distance = countDownDate - now;

   // Time calculations for days, hours, minutes and seconds
   var days = Math.floor(distance / (1000 * 60 * 60 * 24));
   var hours = Math.floor((distance % (1000 * 60 * 60 * 24)) / (1000 * 60 * 60));
   var minutes = Math.floor((distance % (1000 * 60 * 60)) / (1000 * 60));
   var seconds = Math.floor((distance % (1000 * 60)) / 1000);

   // Display the result in the element with id="demo"
   document.getElementById("demo").innerHTML = days + "d " + hours + "h "
   + minutes + "m " + seconds + "s ";

   // If the count down is finished, write some text
   if (distance < 0) {
     clearInterval(x);
     location.reload();
   }
 }, 1000); 

  </script>
</head>



<body style="background-color: rgb(231, 238, 243);">

	<div class="container-fluid mx-auto" style="margin-bottom: 50px; padding: 0px 0px" id="banner">
	  <div class="row">
	    <div class="jumbotron text-center" style="width:100%">
	      <h1 class="display-4">${promotion.promotionName}</h1>
			<p id="demo"></p>
	    </div>
	  </div>
	</div>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
  	<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.2/dist/umd/popper.min.js"></script>

	<script src="/assets/js/sale-load.js"></script>
</body>
</html>