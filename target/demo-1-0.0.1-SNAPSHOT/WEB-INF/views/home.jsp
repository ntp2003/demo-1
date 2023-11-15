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
<body>
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

    <div class="container justify-content-center align-items-center align-content-center py-4 py-xl-5"
      id="container-ban-chay">
      <div class="row mb-5">
        <div class="col-md-8 col-xl-6 text-center mx-auto">
          <h2>Bán chạy</h2>
          <nav class="navbar navbar-expand-md navbar-light bg-body bg-gradient py-3">
            <div class="container">
              <button
                class="navbar-toggler"
                type="button"
                data-bs-toggle="collapse"
                data-bs-target="#navbarNav"
                aria-controls="navbarNav"
                aria-expanded="false"
                aria-label="Toggle navigation">
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
                <img class="pic-1" src="https://www.bootdey.com/image/280x300/6495ED/000000"/>
                <img class="pic-2" src="https://www.bootdey.com/image/280x300/FFB6C1/000000"/>
              </a>
<!--               <ul class="social">
                <li>
                  <a href="#" data-tip="View"><i class="fa fa-eye"></i></a>
                </li>
                <li>
                  <a href="#" data-tip="Add to Cart"
                    ><i class="fa fa-shopping-cart"></i></a>
                </li>
              </ul> -->
              <a class="add-to-cart" href>Add to cart</a>
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
                <img class="pic-1" src="https://www.bootdey.com/image/280x300/00FFFF/000000"/>
                <img class="pic-2" src="https://www.bootdey.com/image/280x300/FFB6C1/000000" />
              </a>
<!--               <ul class="social">
                <li>
                  <a href="#" data-tip="View"><i class="fa fa-eye"></i
                  ></a>
                </li>

                <li>
                  <a href="#" data-tip="Add to Cart"><i class="fa fa-shopping-cart"></i></a>
                </li>
              </ul> -->
              <a class="add-to-cart" href>Add to cart</a>
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
                  src="https://www.bootdey.com/image/280x300/FF7F50/000000" />
                <img
                  class="pic-2"
                  src="https://www.bootdey.com/image/280x300/E9967A/000000" />
              </a>
              <ul class="social">
                <li>
                  <a href="#" data-tip="View" ><i class="fa fa-eye"></i ></a>
                </li>

                <li>
                  <a href="#" data-tip="Add to Cart" ><i class="fa fa-shopping-cart"></i ></a>
                </li>
              </ul>
              <a class="add-to-cart" href>Add to cart</a>
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
                  src="https://www.bootdey.com/image/280x300/00008B/000000"
                />
                <img
                  class="pic-2"
                  src="https://www.bootdey.com/image/280x300/8B008B/000000"
                />
              </a>
              <ul class="social">
                <li>
                  <a href="#" data-tip="View"
                    ><i class="fa fa-eye"></i
                  ></a>
                </li>
                <li>
                  <a href="#" data-tip="Add to Cart"
                    ><i class="fa fa-shopping-cart"></i
                  ></a>
                </li>
              </ul>
              <a class="add-to-cart" href>Add to cart</a>
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
                  src="https://www.bootdey.com/image/280x300/6495ED/000000"
                />
                <img
                  class="pic-2"
                  src="https://www.bootdey.com/image/280x300/FFB6C1/000000"
                />
              </a>
              <ul class="social">
                <li>
                  <a href="#" data-tip="View"
                    ><i class="fa fa-eye"></i
                  ></a>
                </li>
                <li>
                  <a href="#" data-tip="Add to Cart"
                    ><i class="fa fa-shopping-cart"></i
                  ></a>
                </li>
              </ul>
              <a class="add-to-cart" href>Add to cart</a>
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
                  src="https://www.bootdey.com/image/280x300/00FFFF/000000"
                />
                <img
                  class="pic-2"
                  src="https://www.bootdey.com/image/280x300/FFB6C1/000000"
                />
              </a>
              <ul class="social">
                <li>
                  <a href="#" data-tip="View"
                    ><i class="fa fa-eye"></i
                  ></a>
                </li>
                <li>
                  <a href="#" data-tip="Add to Cart"
                    ><i class="fa fa-shopping-cart"></i
                  ></a>
                </li>
              </ul>
              <a class="add-to-cart" href>Add to cart</a>
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
                  src="https://www.bootdey.com/image/280x300/FF7F50/000000"
                />
                <img
                  class="pic-2"
                  src="https://www.bootdey.com/image/280x300/E9967A/000000"
                />
              </a>
              <ul class="social">
                <li>
                  <a href="#" data-tip="View"
                    ><i class="fa fa-eye"></i
                  ></a>
                </li>
                <li>
                  <a href="#" data-tip="Add to Cart"
                    ><i class="fa fa-shopping-cart"></i
                  ></a>
                </li>
              </ul>
              <a class="add-to-cart" href>Add to cart</a>
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
                  src="https://www.bootdey.com/image/280x300/00008B/000000"
                />
                <img
                  class="pic-2"
                  src="https://www.bootdey.com/image/280x300/8B008B/000000"
                />
              </a>
              <ul class="social">
                <li>
                  <a href="#" data-tip="View"
                    ><i class="fa fa-eye"></i
                  ></a>
                </li>
                <li>
                  <a href="#" data-tip="Add to Cart"
                    ><i class="fa fa-shopping-cart"></i
                  ></a>
                </li>
              </ul>
              <a class="add-to-cart" href>Add to cart</a>
            </div>
            <div class="product-content">
              <h3 class="title"><a href="#">baloooo</a></h3>
              <span class="price">$599.99</span>
            </div>
          </div>
        </div>
      </div>
    </div>

        <div class="text-center border rounded-0 border-light" id="more-xemthem"><a class="text-uppercase text-center link-dark" href="#">Xem thêm</a></div>
    </div>
    <section>
        <div class="container" id="container-giay-nam" style="margin-bottom: 30px;">
            <div class="text-center shadow-lg"><a class="text-uppercase fw-semibold" href="#" style="text-decoration: none;">
                    <p class="fs-4 fw-normal text-dark">Giày nam</p>
                </a></div>
<div class="container">
<div class="row">
  <div class="col-md-3 col-sm-6">
    <div class="product-grid-giay">
      <div class="product-image2">
        <a href="#">
          <img
            class="pic-1"
            src="https://www.bootdey.com/image/280x300/6495ED/000000"
          />
          <img
            class="pic-2"
            src="https://www.bootdey.com/image/280x300/FFB6C1/000000"
          />
        </a>
        <ul class="social">
          <li>
            <a href="#" data-tip="View"
              ><i class="fa fa-eye"></i
            ></a>
          </li>
          <li>
            <a href="#" data-tip="Add to Cart"
              ><i class="fa fa-shopping-cart"></i
            ></a>
          </li>
        </ul>
        <a class="add-to-cart" href>Add to cart</a>
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
            src="https://www.bootdey.com/image/280x300/00FFFF/000000"
          />
          <img
            class="pic-2"
            src="https://www.bootdey.com/image/280x300/FFB6C1/000000"
          />
        </a>
        <ul class="social">
          <li>
            <a href="#" data-tip="View"
              ><i class="fa fa-eye"></i
            ></a>
          </li>
          <li>
            <a href="#" data-tip="Add to Cart"
              ><i class="fa fa-shopping-cart"></i
            ></a>
          </li>
        </ul>
        <a class="add-to-cart" href>Add to cart</a>
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
            src="https://www.bootdey.com/image/280x300/FF7F50/000000"
          />
          <img
            class="pic-2"
            src="https://www.bootdey.com/image/280x300/E9967A/000000"
          />
        </a>
        <ul class="social">
          <li>
            <a href="#" data-tip="View"
              ><i class="fa fa-eye"></i
            ></a>
          </li>
          <li>
            <a href="#" data-tip="Add to Cart"
              ><i class="fa fa-shopping-cart"></i
            ></a>
          </li>
        </ul>
        <a class="add-to-cart" href>Add to cart</a>
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
            src="https://www.bootdey.com/image/280x300/00008B/000000"
          />
          <img
            class="pic-2"
            src="https://www.bootdey.com/image/280x300/8B008B/000000"
          />
        </a>
        <ul class="social">
          <li>
            <a href="#" data-tip="View"
              ><i class="fa fa-eye"></i
            ></a>
          </li>
          <li>
            <a href="#" data-tip="Add to Cart"
              ><i class="fa fa-shopping-cart"></i
            ></a>
          </li>
        </ul>
        <a class="add-to-cart" href>Add to cart</a>
      </div>
      <div class="product-content">
        <h3 class="title"><a href="#">Women's Designer Top</a></h3>
        <span class="price">$599.99</span>
      </div>
    </div>
  </div>
</div>
</div>            <div class="text-center border rounded-0 border-light" id="more-xemthem-1"><a class="text-uppercase text-center link-dark" href="#">Xem thêm</a></div>
        </div>


        <div class="container" id="container-balo" style="margin-bottom: 30px;">
            <div class="text-center"><a class="text-uppercase fw-semibold" href="#" style="text-decoration: none;">
                    <p class="fs-4 fw-normal text-dark shadow-lg">balo</p>
                </a></div>
<div class="container">
<div class="row">
  <div class="col-md-3 col-sm-6">
    <div class="product-grid-balo">
      <div class="product-image2">
        <a href="#">
          <img
            class="pic-1"
            src="https://www.bootdey.com/image/280x300/6495ED/000000"
          />
          <img
            class="pic-2"
            src="https://www.bootdey.com/image/280x300/FFB6C1/000000"
          />
        </a>
        <ul class="social">
          <li>
            <a href="#" data-tip="View"
              ><i class="fa fa-eye"></i
            ></a>
          </li>
          <li>
            <a href="#" data-tip="Add to Cart"
              ><i class="fa fa-shopping-cart"></i
            ></a>
          </li>
        </ul>
        <a class="add-to-cart" href>Add to cart</a>
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
            src="https://www.bootdey.com/image/280x300/00FFFF/000000"
          />
          <img
            class="pic-2"
            src="https://www.bootdey.com/image/280x300/FFB6C1/000000"
          />
        </a>
        <ul class="social">
          <li>
            <a href="#" data-tip="View"
              ><i class="fa fa-eye"></i
            ></a>
          </li>
          <li>
            <a href="#" data-tip="Add to Cart"
              ><i class="fa fa-shopping-cart"></i
            ></a>
          </li>
        </ul>
        <a class="add-to-cart" href>Add to cart</a>
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
            src="https://www.bootdey.com/image/280x300/FF7F50/000000"
          />
          <img
            class="pic-2"
            src="https://www.bootdey.com/image/280x300/E9967A/000000"
          />
        </a>
        <ul class="social">
          <li>
            <a href="#" data-tip="View"
              ><i class="fa fa-eye"></i
            ></a>
          </li>
          <li>
            <a href="#" data-tip="Add to Cart"
              ><i class="fa fa-shopping-cart"></i
            ></a>
          </li>
        </ul>
        <a class="add-to-cart" href>Add to cart</a>
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
            src="https://www.bootdey.com/image/280x300/00008B/000000"
          />
          <img
            class="pic-2"
            src="https://www.bootdey.com/image/280x300/8B008B/000000"
          />
        </a>
        <ul class="social">
          <li>
            <a href="#" data-tip="View"
              ><i class="fa fa-eye"></i
            ></a>
          </li>
          <li>
            <a href="#" data-tip="Add to Cart"
              ><i class="fa fa-shopping-cart"></i
            ></a>
          </li>
        </ul>
        <a class="add-to-cart" href>Add to cart</a>
      </div>
      <div class="product-content">
        <h3 class="title"><a href="#">Women's Designer Top</a></h3>
        <span class="price">$599.99</span>
      </div>
    </div>
  </div>
</div>
</div>            <div class="text-center border rounded-0 border-light" id="more-xemthem-3"><a class="text-uppercase text-center link-dark" href="#">Xem thêm</a></div>
        </div>
    </section>
    
<script src="https://code.jquery.com/jquery-1.10.2.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.1.1/dist/js/bootstrap.bundle.min.js"></script>
<script type="text/javascript"></script>

</body>
</html>