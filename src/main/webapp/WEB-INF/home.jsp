<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Home</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
	 <link rel="stylesheet" href="/assets/css/Simple-Slider-swiper-bundle.min.css">
    <link rel="stylesheet" href="/assets/css/Simple-Slider.css">
    <link rel="stylesheet" href="/assets/css/main.css">
	<!--     <link rel="stylesheet" href="assets/css/filterTemplate.css">
	 -->    
	 <style>
		input[type="checkbox"]:not(.custom-control-input) {
		  display: none;
		}
		
		label.bg-color {
		  display: inline-block;
		  padding: 10px;
		  border: 2px solid #ccc;
		  border-radius: 5px;
		  cursor: pointer;
		  user-select: none;
		  transition: transform 0.3s;
		  border-radius:50%;
		}
	 </style>
    
    <script src="/assets/js/hide-showBanChay.js"></script>
    <script src="/assets/js/Simple-Slider-swiper-bundle.min.js"></script>
    <script src="/assets/js/Simple-Slider.js"></script>
    
<script src="https://unpkg.com/swiper/swiper-bundle.min.js"></script>
<script>
    document.addEventListener("DOMContentLoaded", function() {
        var swiper = new Swiper(".swiper-container", {
            loop: true,
            autoplay: {
                delay: 2500,
                disableOnInteraction: false,
            },
            pagination: {
                el: ".swiper-pagination",
                clickable: true,
            },
            navigation: {
                nextEl: ".swiper-button-next",
                prevEl: ".swiper-button-prev",
            },
        });
    });
    window.addEventListener('DOMContentLoaded', function () {
    	  showCategory('Giay'); // Hiển thị danh sách sản phẩm Nam khi trang web được tải lên
    	});
</script>
</head>
<body style="background-color: rgb(231, 238, 243);">
    <div class="simple-slider">
        <div class="swiper-container">
            <div class="swiper-wrapper">
                <div class="swiper-slide" style="width: 100%;background: url(&quot;https://img.mwc.com.vn/giay-thoi-trang?w=1920&amp;h=0&amp;FileInput=/Resources/Silde/2023/09/19/new collection-01.jpg&quot;) center center / cover no-repeat;"></div>
                <div class="swiper-slide" style="background: url(https://ananas.vn/wp-content/uploads/Banner-mobile_Clothing.jpg) center center / cover no-repeat;"></div>
            </div>
            <div class="swiper-pagination"></div>
            <div class="swiper-button-prev"></div>
            <div class="swiper-button-next"></div>
        </div>
    </div>

<!--     <div class="container " style="margin-top:50px"
      id="container-ban-chay">
      <div class="row mb-5"> -->
 <!--        <div class="col-md-8 col-xl-6 text-center mx-auto bordered-container">
          <h4 class="text-uppercase text-center link-dark">Sản phẩm bán chạy</h4>
          				<hr style="  border-top: 2px dashed #616A6B	;">
          <nav class="navbar navbar-expand-md navbar-light">
            <div class="container">
              <div class="collapse navbar-collapse" id="navbarNav">
                <ul class="navbar-nav mx-auto">
                  <li class="nav-item">
					<a class="nav-link" href="javascript:void(0);" onclick="showCategory('Giay')">Giày</a>
                  </li>
                  <li class="nav-item">
					<a class="nav-link" href="javascript:void(0);" onclick="showCategory('Balo')">Balo</a>
                  </li>
                   <li class="nav-item">
                    <a class="nav-link" href="javascript:void(0);" onclick="showCategory('QuanAo')">Quần áo</a>
                  </li> 
                </ul>
              </div>              
            </div>
          </nav>
        </div> -->
       <div class="container" style="margin-top:50px">
		<div class="row" style="margin-bottom: 50px">
        <div class="col-md-8 col-xl-6 text-center mx-auto bordered-container">
  <h4 class="text-uppercase text-center link-dark">Sản phẩm bán chạy</h4>
  <hr style="border-top: 2px dashed #616A6B;">
  <nav class="navbar navbar-expand-md navbar-light">
    <div class="container">
      <!-- Thêm nút cho menu khi màn hình nhỏ hơn md -->
      <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
      </button>
      <div class="collapse navbar-collapse" id="navbarNav">
        <ul class="navbar-nav mx-auto">
          <li class="nav-item">
            <a class="nav-link" href="javascript:void(0);" onclick="showCategory('Giay')">Giày</a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="javascript:void(0);" onclick="showCategory('Balo')">Balo</a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="javascript:void(0);" onclick="showCategory('QuanAo')">Quần áo</a>
          </li>
        </ul>
      </div>              
    </div>
  </nav>
</div>
      </div>
    <div class="container">
      <div class="row">
        <div class="col-md-3 col-sm-6">
          <div class="product-grid-ban-chay-giay">
            <div class="product-image2">
              <a href="#">
                <img class="pic-1" src="https://ananas.vn/wp-content/uploads/Pro_A6T014_1-500x500.jpeg"/>
                <img class="pic-2" src="https://ananas.vn/wp-content/uploads/Pro_A6T014_2-500x500.jpeg"/>
              </a>
						<a class="add-to-cart" href="abc">Add to cart <i class="fa-solid fa-cart-shopping fa-bounce"></i></a>
            </div>
            <div class="product-content">
              <h3 class="title"><a href="#">nammmm</a></h3>
              <span class="price">$599.99</span>
            </div>
          </div>
        </div>
        <div class="col-md-3 col-sm-6">
          <div class="product-grid-ban-chay-giay">
            <div class="product-image2">
              <a href="#">
                <img class="pic-1" src="https://ananas.vn/wp-content/uploads/Pro_A6T014_1-500x500.jpeg"/>
                <img class="pic-2" src="https://ananas.vn/wp-content/uploads/Pro_A6T014_2-500x500.jpeg" />
              </a>
						<a class="add-to-cart" href="abc">Add to cart <i class="fa-solid fa-cart-shopping fa-bounce"></i></a>
            </div>
            <div class="product-content">
              <h3 class="title"><a href="#">nammmm</a></h3>
              <span class="price">$699.99</span>
            </div>
          </div>
        </div>
        <div class="col-md-3 col-sm-6">
          <div class="product-grid-ban-chay-giay">
            <div class="product-image2">
              <a href="#">
                <img
                  class="pic-1"
                  src="https://ananas.vn/wp-content/uploads/Pro_A6T014_2-500x500.jpeg" />
                <img
                  class="pic-2"
                  src="https://ananas.vn/wp-content/uploads/Pro_A6T014_1-500x500.jpeg" />
              </a>
						<a class="add-to-cart" href="abc">Add to cart <i class="fa-solid fa-cart-shopping fa-bounce"></i></a>
            </div>
            <div class="product-content">
              <h3 class="title"><a href="#">nammmm</a></h3>
              <span class="price">$599.99</span>
            </div>
          </div>
        </div>
        <div class="col-md-3 col-sm-6">
          <div class="product-grid-ban-chay-giay">
            <div class="product-image2">
              <a href="#">
                <img
                  class="pic-1"
                  src="https://ananas.vn/wp-content/uploads/Pro_A6T014_3-500x500.jpeg"
                />
                <img
                  class="pic-2"
                  src="https://ananas.vn/wp-content/uploads/Pro_A6T014_1-500x500.jpeg"
                />
              </a>
						<a class="add-to-cart" href="abc">Add to cart <i class="fa-solid fa-cart-shopping fa-bounce"></i></a>
            </div>
            <div class="product-content">
              <h3 class="title"><a href="#">nammmm</a></h3>
              <span class="price">$599.99</span>
            </div>
          </div>
        </div>
      </div>
    </div>


    <div class="container">
       <div class="row">
        <div class="col-md-3 col-sm-6">
          <div class="product-grid-ban-chay-balo">
            <div class="product-image2">
              <a href="#">
                <img
                  class="pic-1"
                  src="https://ananas.vn/wp-content/uploads/Pro_AV00205_1.jpeg"
                />
                <img
                  class="pic-2"
                  src="https://ananas.vn/wp-content/uploads/Pro_AV00205_2.jpeg"
                />
              </a>
						<a class="add-to-cart" href="abc">Add to cart <i class="fa-solid fa-cart-shopping fa-bounce"></i></a>
            </div>
            <div class="product-content">
              <h3 class="title"><a href="#">baloooo</a></h3>
              <span class="price">$599.99</span>
            </div>
          </div>
        </div>
        <div class="col-md-3 col-sm-6">
          <div class="product-grid-ban-chay-balo">
            <div class="product-image2">
              <a href="#">
                <img
                  class="pic-1"
                  src="https://ananas.vn/wp-content/uploads/Pro_AV00205_2.jpeg"
                />
                <img
                  class="pic-2"
                  src="https://ananas.vn/wp-content/uploads/Pro_AV00205_1.jpeg"
                />
              </a>
						<a class="add-to-cart" href="abc">Add to cart <i class="fa-solid fa-cart-shopping fa-bounce"></i></a>
            </div>
            <div class="product-content">
              <h3 class="title"><a href="#">baloooo</a></h3>
              <span class="price">$699.99</span>
            </div>
          </div>
        </div>
        <div class="col-md-3 col-sm-6">
          <div class="product-grid-ban-chay-balo">
            <div class="product-image2">
              <a href="#">
                <img
                  class="pic-1"
                  src="https://ananas.vn/wp-content/uploads/Pro_AV00205_3.jpeg"
                />
                <img
                  class="pic-2"
                  src="https://ananas.vn/wp-content/uploads/Pro_AV00205_1.jpeg"
                />
              </a>
						<a class="add-to-cart" href="abc">Add to cart <i class="fa-solid fa-cart-shopping fa-bounce"></i></a>
            </div>
            <div class="product-content">
              <h3 class="title"><a href="#">baloooo</a></h3>
              <span class="price">$599.99</span>
            </div>
          </div>
        </div>
        <div class="col-md-3 col-sm-6">
          <div class="product-grid-ban-chay-balo">
            <div class="product-image2">
              <a href="#">
                <img
                  class="pic-1"
                  src="https://ananas.vn/wp-content/uploads/Pro_AV00205_1.jpeg"
                />
                <img
                  class="pic-2"
                  src="https://ananas.vn/wp-content/uploads/Pro_AV00205_1.jpeg"
                />
              </a>
						<a class="add-to-cart" href="abc">Add to cart <i class="fa-solid fa-cart-shopping fa-bounce"></i></a>
            </div>
            <div class="product-content">
              <h3 class="title"><a href="#">baloooo</a></h3>
              <span class="price">$599.99</span>
            </div>
          </div>
        </div> 
      </div>
    </div>
        <div class="text-center" id="more-xemthem-1"><a class="text-uppercase text-center link-dark" href="#">Xem thêm</a></div>
    </div>
    <hr style="border-top: 1px solid #616A6B" >
    <section>
        <div class="container" id="container-giay-nam" style="margin-bottom: 30px;">
            <div class="text-center"><a class="text-uppercase fw-semibold" href="#" style="text-decoration: none;">
                    <p class="fs-4 fw-normal text-dark">Giày nam</p>
                </a></div>
<div class="container">
<div class="row" id="row-giay">
 <!--  <div class="col-md-3 col-sm-6">
    <div class="product-grid-giay">
      <div class="product-image2">
        <a href="#">
          <img
            class="pic-1"
            src="https://ananas.vn/wp-content/uploads/Pro_AV00205_1.jpeg"
          />
          <img
            class="pic-2"
            src="https://ananas.vn/wp-content/uploads/Pro_AV00205_3.jpeg"
          />
        </a>
						<a class="add-to-cart" href="abc">Add to cart <i class="fa-solid fa-cart-shopping fa-bounce"></i></a>
      </div>
      <div class="product-content">
        <h3 class="title"><a href="#">Women's Designer Top</a></h3>
        <span class="price">$599.99</span>
      </div>
    </div>
  </div>
  <div class="col-md-3 col-sm-6">
    <div class="product-grid-giay">
      <div class="product-image2">
        <a href="#">
          <img
            class="pic-1"
            src="https://ananas.vn/wp-content/uploads/Pro_AV00205_2.jpeg"
          />
          <img
            class="pic-2"
            src="https://ananas.vn/wp-content/uploads/Pro_AV00205_1.jpeg"
          />
        </a>
						<a class="add-to-cart" href="abc">Add to cart <i class="fa-solid fa-cart-shopping fa-bounce"></i></a>
      </div>
      <div class="product-content">
        <h3 class="title"><a href="#">Women's Yellow Top</a></h3>
        <span class="price">$699.99</span>
      </div>
    </div>
  </div>
  <div class="col-md-3 col-sm-6">
    <div class="product-grid-giay">
      <div class="product-image2">
        <a href="#">
          <img
            class="pic-1"
            src="https://ananas.vn/wp-content/uploads/Pro_AV00205_4.jpeg"
          />
          <img
            class="pic-2"
            src="https://ananas.vn/wp-content/uploads/Pro_AV00205_1.jpeg"
          />
        </a>
						<a class="add-to-cart" href="abc">Add to cart <i class="fa-solid fa-cart-shopping fa-bounce"></i></a>
      </div>
      <div class="product-content">
        <h3 class="title"><a href="#">Women's Designer Top</a></h3>
        <span class="price">$599.99</span>
      </div>
    </div>
  </div>
  <div class="col-md-3 col-sm-6">
    <div class="product-grid-giay">
      <div class="product-image2">
        <a href="#">
          <img
            class="pic-1"
            src="https://ananas.vn/wp-content/uploads/Pro_AV00205_2.jpeg"
          />
          <img
            class="pic-2"
            src="https://ananas.vn/wp-content/uploads/Pro_AV00205_3.jpeg"
          />
        </a>
						<a class="add-to-cart" href="abc">Add to cart <i class="fa-solid fa-cart-shopping fa-bounce"></i></a>
      </div>
      <div class="product-content">
        <h3 class="title"><a href="#">Women's Designer Top</a></h3>
        <span class="price">$599.99</span>
      </div>
    </div>
  </div> -->
</div>
</div>            
<div class="text-center" id="more-xemthem-1"><a class="text-uppercase text-center link-dark" href="#">Xem thêm</a></div>
        </div>
            <hr style="border-top: 1px solid #616A6B" >
        


        <div class="container" id="container-balo" style="margin-bottom: 30px;">
           <div class="text-center"><a class="text-uppercase fw-semibold" href="#" style="text-decoration: none;">
                    <p class="fs-4 fw-normal text-dark">Balo</p>
                </a></div>
<div class="container">
<div class="row">
  <div class="col-md-3 col-sm-6">
    <div class="product-grid-balo">
      <div class="product-image2">
        <a href="#">
          <img
            class="pic-1"
            src="https://static.nike.com/a/images/t_PDP_1280_v1/f_auto,q_auto:eco/350e7f3a-979a-402b-9396-a8a998dd76ab/air-force-1-07-shoe-HWWX9W.png"
          />
          <img
            class="pic-2"
            src="https://ananas.vn/wp-content/uploads/Pro_AV00205_2.jpeg"
          />
        </a>
						<a class="add-to-cart" href="abc">Add to cart <i class="fa-solid fa-cart-shopping fa-bounce"></i></a>
      </div>
      <div class="product-content">
        <h3 class="title"><a href="#">Women's Designer Top</a></h3>
        <span class="price">$599.99</span>
      </div>
    </div>
  </div>
  <div class="col-md-3 col-sm-6">
    <div class="product-grid-balo">
      <div class="product-image2">
        <a href="#">
          <img
            class="pic-1"
            src="https://ananas.vn/wp-content/uploads/Pro_AV00205_1.jpeg"
          />
          <img
            class="pic-2"
            src="https://ananas.vn/wp-content/uploads/Pro_AV00205_2.jpeg"
          />
        </a>
						<a class="add-to-cart" href="abc">Add to cart <i class="fa-solid fa-cart-shopping fa-bounce"></i></a>
      </div>
      <div class="product-content">
        <h3 class="title"><a href="#">Women's Yellow Top</a></h3>
        <span class="price">$699.99</span>
      </div>
    </div>
  </div>
  <div class="col-md-3 col-sm-6">
    <div class="product-grid-balo">
      <div class="product-image2">
        <a href="#">
          <img
            class="pic-1"
            src="https://ananas.vn/wp-content/uploads/Pro_AV00205_2.jpeg"
          />
          <img
            class="pic-2"
            src="https://ananas.vn/wp-content/uploads/Pro_AV00205_3.jpeg"
          />
        </a>
						<a class="add-to-cart" href="abc">Add to cart <i class="fa-solid fa-cart-shopping fa-bounce"></i></a>
      </div>
      <div class="product-content">
        <h3 class="title"><a href="#">Women's Designer Top</a></h3>
        <span class="price">$599.99</span>
      </div>
    </div>
  </div>
  <div class="col-md-3 col-sm-6">
    <div class="product-grid-balo">
      <div class="product-image2">
        <a href="#">
          <img
            class="pic-1"
            src="https://ananas.vn/wp-content/uploads/Pro_AV00205_3.jpeg"
          />
          <img
            class="pic-2"
            src="https://ananas.vn/wp-content/uploads/Pro_AV00205_2.jpeg"
          />
        </a>
						<a class="add-to-cart" href="abc">Add to cart <i class="fa-solid fa-cart-shopping fa-bounce"></i></a>
	      </div>
      <div class="product-content">
        <h3 class="title"><a href="#">Women's Designer Top</a></h3>
        <span class="price">$599.99</span>
      </div>
    </div>
  </div>
</div>
</div>            <div class="text-center" id="more-xemthem-1"><a class="text-uppercase text-center link-dark" href="#">Xem thêm</a></div>
        </div>
    </section>
    
<script src="https://code.jquery.com/jquery-1.10.2.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.1.1/dist/js/bootstrap.bundle.min.js"></script>
<script type="text/javascript"></script>


	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.20.0/jquery.validate.min.js"
		integrity="sha512-WMEKGZ7L5LWgaPeJtw9MBM4i5w5OSBlSjTjCtSnvFJGSVD26gE5+Td12qN5pvWXhuWaWcVwF++F7aqu9cvqP0A=="
		crossorigin="anonymous" referrerpolicy="no-referrer"></script>

	<script src="/assets/js/colorPick.js"></script>
	<script src="/assets/js/numberinput.js"></script>
	<script src="/assets/js/product-load.js" type="module"></script>
	<script src="/assets/js/theme.js"></script>

</body>
</html>