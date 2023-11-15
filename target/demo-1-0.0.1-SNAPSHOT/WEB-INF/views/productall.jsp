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

<script>
    // Chờ cho trang được tải hoàn toàn
    document.addEventListener('DOMContentLoaded', function () {
        // Chọn phần tử input range
        var priceRange = document.getElementById('priceRange');

        // Chọn phần tử để hiển thị giá trị
        var priceValue = document.getElementById('priceValue');

        // Thêm sự kiện input cho input range
        priceRange.addEventListener('input', function () {
            // Cập nhật giá trị hiển thị
            priceValue.innerText = priceRange.value + '$';
        });
    });
    
</script>


<script>

function changeColor(button) {
  // Lấy danh sách tất cả các button
  var buttons = document.getElementsByClassName('filter-button');
  
  // Đặt màu ban đầu cho tất cả các button
  for (var i = 0; i < buttons.length; i++) {
    buttons[i].style.backgroundColor = ''; // Màu mặc định của button
  }
  // Đặt màu mới cho button được click
  button.style.backgroundColor = '#2ECC71'; // Màu mới của button
}

window.onload = function() {
	  document.querySelector('[data-filter="all"]').click();
};
</script>

<script>
	document.addEventListener("DOMContentLoaded", function() {
		var labels = document.querySelectorAll("label.bg-color");
		labels.forEach(function(label) {
			label.addEventListener("click", function() {
				// Khi label được click, kiểm tra trạng thái của checkbox
				var checkbox = this.querySelector('input[type="checkbox"]');
				checkbox.checked = !checkbox.checked;

				// Xác định trạng thái của checkbox và thêm/loại bỏ lớp active tương ứng
				if (checkbox.checked) {
					this.classList.add("active");
				} else {
					this.classList.remove("active");
				}
			});
		});
	});
</script>



</head>
<body style="background-color: rgb(231, 238, 243);">
	<div class="filter-container"
		style="display: inline-block; flex-wrap: wrap;margin-top:100px">
		<h5 class="font-weight-bold">Categories</h5>
		<div class="Brand-filter">
			<article class="filter-group">
				<header class="card-header" >
					<a href="#" data-toggle="collapse" data-target="#collapse_2"
						aria-expanded="true" class=""> <i
						class="icon-control fa fa-chevron-down"></i>
						<h6 class="title">Brands</h6>
					</a>
				</header>
				<div class="filter-content collapse show" id="collapse_2">
					<div class="card-body">
						<label class="custom-control custom-checkbox"> <input
							type="checkbox" checked="" class="custom-control-input" />
							<div class="custom-control-label">
								Ananas
								<!--                   <b class="badge badge-pill badge-light float-right">120</b>
 -->
							</div>
						</label> <label class="custom-control custom-checkbox"> <input
							type="checkbox" checked="" class="custom-control-input" />
							<div class="custom-control-label">
								MWC
								<!--                   <b class="badge badge-pill badge-light float-right">15</b>
 -->
							</div>
						</label> <label class="custom-control custom-checkbox"> <input
							type="checkbox" checked="" class="custom-control-input" />
							<div class="custom-control-label">
								Colmate
								<!--                   <b class="badge badge-pill badge-light float-right">35</b>
 -->
							</div>
						</label>
					</div>
					<!-- card-body.// -->
				</div>
			</article>
		</div>

		
    <div class="Price-filter">
        <article class="filter-group">
            <header class="card-header">
                <a href="#" data-toggle="collapse" data-target="#collapse_3" aria-expanded="true" class="">
                    <i class="icon-control fa fa-chevron-down"></i>
                    <h6 class="title">Price</h6>
                </a>
            </header>
            <div class="filter-content collapse show" id="collapse_3">
                <div class="card-body" style="display: grid">
			<div class="form-group" style="margin-top: 20px;">
			    <label>Price Range</label>
			    <input type="range" class="form-range" min="100" max="1000" step="1" value="1000" id="priceRange" />
			    <p id="priceValue">1000$</p>
			</div>

             </div>
         </div>
     </article>
 </div>



		<div class="Color-filter">
			<article class="filter-group">
				<header class="card-header">
					<a href="#" data-toggle="collapse" data-target="#collapse_1"
						aria-expanded="true" class=""> <i
						class="icon-control fa fa-chevron-down"></i>
						<h6 class="title">Color</h6>
					</a>
				</header>
				<div class="filter-content collapse show" id="collapse_1">
					<div class="card-body">
						<ul class="nav tree" style="list-style-type: none">
							<li class="cb-color"><label class="bg-color"
								style="background-color: white"> <input name="cbColor"
									type="checkbox" value="white" multiple />
							</label> <label class="bg-color" style="background-color: red"> <input
									name="cbColor" type="checkbox" value="red" multiple />
							</label> <label class="bg-color" style="background-color: black">
									<input name="cbColor" type="checkbox" value="black" multiple />
							</label> <label class="bg-color" style="background-color: yellow">
									<input name="cbColor" type="checkbox" value="yellow" hidden="" />
							</label> <label class="bg-color" style="background-color: blue">
									<input name="cbColor" type="checkbox" value="blue" multiple />
							</label> <label class="bg-color" style="background-color: green">
									<input name="cbColor" type="checkbox" value="green" multiple />
							</label> <label class="bg-color" style="background-color: aqua">
									<input name="cbColor" type="checkbox" value="aqua" multiple />
							</label> <label class="bg-color" style="background-color: brown">
									<input name="cbColor" type="checkbox" value="brown" hidden="" />
							</label></li>
						</ul>
					</div>
				</div>
			</article>
		</div>
		<button class="btn btn-block btn-primary" style="margin-top: 20px;">Apply</button>
	</div>

	<div class="container" style="margin-top:100px;">
		<div class="row">
<!-- 	<div class="category" style="display:flex; justify-content: center;gap:10px;">
          <button class="btn btn-default filter-button" data-filter="all">
            All
          </button>
          <button class="btn btn-default filter-button" data-filter="hdpe">
            Giày
          </button>
          <button class="btn btn-default filter-button" data-filter="sprinkle">
            Quần
          </button>
          <button class="btn btn-default filter-button" data-filter="spray">
            Balo
          </button>
        </div>	 -->
        
        
        <div class="category" style="display:flex; justify-content: center;gap:10px;">
		  <button class="btn btn-default filter-button" data-filter="all" onclick="changeColor(this)">
		    All
		  </button>
		  <button class="btn btn-default filter-button" data-filter="hdpe" onclick="changeColor(this)">
		    Giày
		  </button>
		  <button class="btn btn-default filter-button" data-filter="sprinkle" onclick="changeColor(this)">
		    Quần
		  </button>
		  <button class="btn btn-default filter-button" data-filter="spray" onclick="changeColor(this)">
		    Balo
		  </button>
		</div>
		
			<div class="orderby" style="display: flex; justify-content: center;gap:20px">
		<div class="col-md-6 text-center">
			<div class="input-group">
				<input type="text" class="form-control" value="" /> <span
					class="input-group-btn">
					<button class="btn btn-primary" type="button">
						<i class="fa fa-search"></i>
					</button>
				</span>
			</div>
		</div>


		<header class="border-bottom mb-4 pb-3">
			<div class="form-inline">
				<select class="mr-2 form-control">
					<option value="" hidden selected>Sort by</option>
					<option value="hot">Hot</option>
					<option value="new">Mới nhất</option>
					<option value="lowtohigh">Giá từ thấp đến cao</option>
					<option value="hightolow">Giá từ cao đến thấp</option>
					<option value="az">Sắp xếp theo tên Z-A</option>
					<option value="za">Sắp xếp theo tên A-Z</option>
				</select>
			</div>
		</header>
	</div>
	
			<div class="col-md-3 col-sm-6">
				<div class="product-grid-giay">
					<div class="product-image2">
						<a href="#"> <img class="pic-1"
							src="https://www.bootdey.com/image/280x300/6495ED/000000" />
							<img class="pic-2"
							src="https://www.bootdey.com/image/280x300/FFB6C1/000000" />
						</a>
<!-- 						<ul class="social">
							<li><a href="#" data-tip="View"><i
									class="fa fa-eye"></i></a></li>

							<li><a href="#" data-tip="Add to Cart"><i
									class="fa fa-shopping-cart"></i></a></li>
						</ul> -->
						<a class="add-to-cart" href="abc">Add to cart</a>
					</div>
					<div class="product-content">
						<h3 class="title">
							<a href="#">Women's Designer Top</a>
						</h3>
						<span class="price">$599.99</span>
					</div>
				</div>
			</div>
			<div class="col-md-3 col-sm-6">
				<div class="product-grid-giay">
					<div class="product-image2 hover-zoom ripple ripple-surface ripple-surface-light">
						<a href="#"> <img class="pic-1"
							src="https://ananas.vn/wp-content/uploads/Pro_A6T014_2-500x500.jpeg" />
							<img class="pic-2"
							src="https://ananas.vn/wp-content/uploads/Pro_A6T014_1-500x500.jpeg" />
						</a>
<!-- 						<ul class="social">
							<li><a href="#" data-tip="View"><i
									class="fa fa-eye"></i></a></li>

							<li><a href="#" data-tip="Add to Cart"><i
									class="fa fa-shopping-cart"></i></a></li>
						</ul> -->
						<a class="add-to-cart" href="abc">Add to cart</a>
					</div>
					<div class="product-content">
						<h3 class="title">
							<a href="#">Women's Yellow Top</a>
						</h3>
						<span class="price">$699.99</span>
					</div>
				</div>
			</div>
			
			<div class="col-md-3 col-sm-6">
				<div class="product-grid-giay">
					<div class="product-image2">
						<a href="#"> <img class="pic-1"
							src="https://www.bootdey.com/image/280x300/FF7F50/000000" />
							<img class="pic-2"
							src="https://www.bootdey.com/image/280x300/E9967A/000000" />
						</a>
<!-- 						<ul class="social">
							<li><a href="#" data-tip="View"><i
									class="fa fa-eye"></i></a></li>
							<li><a href="#" data-tip="Add to Cart"><i
									class="fa fa-shopping-cart"></i></a></li>
						</ul> -->
						<a class="add-to-cart" href>Add to cart</a>
					</div>
					<div class="product-content">
						<h3 class="title">
							<a href="#">Women's Designer Top</a>
						</h3>
						<span class="price">$599.99</span>
					</div>
				</div>
			</div>
			<div class="col-md-3 col-sm-6">
				<div class="product-grid-giay">
					<div class="product-image2">
						<a href="#"> <img class="pic-1"
							src="https://www.bootdey.com/image/280x300/00008B/000000" />
							<img class="pic-2"
							src="https://www.bootdey.com/image/280x300/8B008B/000000" />
						</a>
<!-- 						<ul class="social">
							<li><a href="#" data-tip="View"><i
									class="fa fa-eye"></i></a></li>
							<li><a href="#" data-tip="Add to Cart"><i
									class="fa fa-shopping-cart"></i></a></li>
						</ul> -->
						<a class="add-to-cart" href>Add to cart</a>
					</div>
					<div class="product-content">
						<h3 class="title">
							<a href="#">Women's Designer Top</a>
						</h3>
						<span class="price">$599.99</span>
					</div>
				</div>
			</div>
			
		</div>
	</div>
	<div class="push"></div>

	<script src="https://code.jquery.com/jquery-1.10.2.min.js"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@4.1.1/dist/js/bootstrap.bundle.min.js"></script>
	<script type="text/javascript"></script>

</body>
</html>