<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html data-bs-theme="light" lang="en">

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
    <title>Order History</title>
        <style>
        #listProductOrdered{
            margin-bottom: 68px;
        }
	        .rating {
	  font-size: 20px;
	  cursor: pointer;
	}
	
	.star {
	  color: #ccc;
	  display: inline-block;
	  margin-right: 5px;
	}
	
	.star:hover,
	.star.active {
	  color: #ffcc00;
}
       
    </style>
    <script>
    document.addEventListener("DOMContentLoaded", function () {
    	  const stars = document.querySelectorAll(".star");

    	  stars.forEach((star) => {
    	    star.addEventListener("mouseover", function () {
    	      highlightStars(this.getAttribute("data-rating"));
    	    });

    	    star.addEventListener("mouseout", function () {
    	      resetStars();
    	    });

    	    star.addEventListener("click", function () {
    	      const rating = this.getAttribute("data-rating");
    	      resetStars();
    	      markStarsAsClicked(rating);
    	    });
    	  });

    	  function highlightStars(rating) {
    		  stars.forEach((star) => {
    		    const starRating = parseInt(star.getAttribute("data-rating"), 10);
    		    if (starRating <= parseInt(rating, 10)) {
    		      star.classList.add("active");
    		    } else {
    		      star.classList.remove("active");
    		    }
    		  });
    		}

    	  function resetStars() {
    		  stars.forEach((star) => {
    		    if (!star.classList.contains("active")) {
    		      star.classList.remove("active");
    		    }
    		  });
    		}


    	  function markStarsAsClicked(rating) {
    	    stars.forEach((star) => {
    	      if (star.getAttribute("data-rating") <= rating) {
    	        star.classList.add("active");
    	      }
    	    });
    	  }
    	});

    </script>
<link rel="stylesheet" href="/assets/css/main.css">
<link rel="stylesheet" href="/assets/css/filterTemplate.css">
		<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
		<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js">
	</script>
		    
</head>

<body style="background-color: rgb(231, 238, 243);">
    <div class="container py-5">
      <div class="d-flex justify-content-center flex-wrap gap-5">
        <div class="d-flex">
          <div>
            <div class="card mt-3" style="width: 306.325px">
              <ul
                class="list-group list-group-flush list-group-flush list-group-flush list-group-flush"
              >
                <li class="list-group-item">
                  <a class="nav-link" href="Profile"
                    ><div style="display: flex; align-items: center">
                      <svg
                        xmlns="http://www.w3.org/2000/svg"
                        width="1em"
                        height="1em"
                        viewBox="0 0 20 20"
                        fill="none"
                        style="font-size: 16px; margin-right: 10px"
                      >
                        <path
                          fill-rule="evenodd"
                          d="M10 9C11.6569 9 13 7.65685 13 6C13 4.34315 11.6569 3 10 3C8.34315 3 7 4.34315 7 6C7 7.65685 8.34315 9 10 9ZM3 18C3 14.134 6.13401 11 10 11C13.866 11 17 14.134 17 18H3Z"
                          fill="currentColor"
                        ></path></svg
                      ><span>Account Information</span>
                    </div></a
                  >
                </li>
                <li class="list-group-item">
                  <a class="nav-link" href="OrderHistory"
                    ><div style="display: flex; align-items: center">
                      <svg
                        class="bi bi-cart-fill"
                        xmlns="http://www.w3.org/2000/svg"
                        width="1em"
                        height="1em"
                        fill="currentColor"
                        viewBox="0 0 16 16"
                        style="margin-right: 10px"
                      >
                        <path
                          d="M0 1.5A.5.5 0 0 1 .5 1H2a.5.5 0 0 1 .485.379L2.89 3H14.5a.5.5 0 0 1 .491.592l-1.5 8A.5.5 0 0 1 13 12H4a.5.5 0 0 1-.491-.408L2.01 3.607 1.61 2H.5a.5.5 0 0 1-.5-.5zM5 12a2 2 0 1 0 0 4 2 2 0 0 0 0-4zm7 0a2 2 0 1 0 0 4 2 2 0 0 0 0-4zm-7 1a1 1 0 1 1 0 2 1 1 0 0 1 0-2zm7 0a1 1 0 1 1 0 2 1 1 0 0 1 0-2z"
                        ></path></svg
                      ><span>Purchase History</span>
                    </div></a
                  >
                </li>
                <li class="list-group-item">
                  <a class="nav-link" href="feedback.html"
                    ><div style="display: flex; align-items: center">
                      <svg
                        xmlns="http://www.w3.org/2000/svg"
                        width="1em"
                        height="1em"
                        fill="currentColor"
                        viewbox="0 0 16 16"
                        style="margin-right: 10px"
                      >
                        <path d="M0 0h24v24H0z" fill="none"></path>
                        <path
                          d="M20 2H4c-1.1 0-1.99.9-1.99 2L2 22l4-4h14c1.1 0 2-.9 2-2V4c0-1.1-.9-2-2-2zm-7 12h-2v-2h2v2zm0-4h-2V6h2v4z"
                        ></path></svg
                      ><span>Feedback</span>
                    </div></a
                  >
                </li>
                <li class="list-group-item">
                  <a class="nav-link" href="#"
                    ><div style="display: flex; align-items: center">
                      <svg
                        xmlns="http://www.w3.org/2000/svg"
                        width="1em"
                        height="1em"
                        viewbox="0 0 24 24"
                        fill="none"
                        style="margin-right: 10px"
                      >
                        <path
                          d="M8.51428 20H4.51428C3.40971 20 2.51428 19.1046 2.51428 18V6C2.51428 4.89543 3.40971 4 4.51428 4H8.51428V6H4.51428V18H8.51428V20Z"
                          fill="currentColor"
                        ></path>
                        <path
                          d="M13.8418 17.385L15.262 15.9768L11.3428 12.0242L20.4857 12.0242C21.038 12.0242 21.4857 11.5765 21.4857 11.0242C21.4857 10.4719 21.038 10.0242 20.4857 10.0242L11.3236 10.0242L15.304 6.0774L13.8958 4.6572L7.5049 10.9941L13.8418 17.385Z"
                          fill="currentColor"
                        ></path></svg
                      ><span>Logout</span>
                    </div></a
                  >
                </li>
              </ul>
            </div>
          </div>
        </div>
        <div
          class="d-flex justify-content-center flex-wrap"
          style="max-width: 70%"
        >
          <div class="container-fluid">
            <div class="row gx-1">
              <div class="col-md-6 col-xl-3 mb-4">
                <div class="card shadow border-start-info py-2">
                  <div class="card-body">
                    <div class="row align-items-center no-gutters">
                      <div class="col me-2">
                        <div
                          class="text-uppercase fw-bold text-info text-xs mb-1"
                        >
                          <span class="text-warning">AWAITTIng</span>
                        </div>
                        <div class="row g-0 align-items-center">
                          <div class="col-auto">
                            <div class="fw-bold text-dark h5 mb-0 me-3">
                              <span style="font-size: 16px">88</span>
                            </div>
                          </div>
                        </div>
                      </div>
                      <div class="col-auto">
                        <i class="fas fa-laugh text-warning fa-2x"></i>
                      </div>
                    </div>
                  </div>
                </div>
              </div>
              <div class="col-md-6 col-xl-3 mb-4">
                <div class="card shadow border-start-info py-2">
                  <div class="card-body">
                    <div class="row align-items-center no-gutters">
                      <div class="col me-2">
                        <div
                          class="text-uppercase fw-bold text-info text-xs mb-1"
                        >
                          <span>SHIPPING</span>
                        </div>
                        <div class="row g-0 align-items-center">
                          <div class="col-auto">
                            <div class="fw-bold text-dark h5 mb-0 me-3">
                              <span style="font-size: 16px">88</span>
                            </div>
                          </div>
                        </div>
                      </div>
                      <div class="col-auto">
                        <i class="fas fa-car-side text-info fa-2x"></i>
                      </div>
                    </div>
                  </div>
                </div>
              </div>
              <div class="col-md-6 col-xl-3 mb-4">
                <div class="card shadow border-start-warning py-2">
                  <div class="card-body">
                    <div class="row align-items-center no-gutters">
                      <div class="col me-2">
                        <div
                          class="text-uppercase fw-bold text-warning text-xs mb-1"
                        >
                          <span class="text-danger">CANCELLED</span>
                        </div>
                        <div class="fw-bold text-dark h5 mb-0">
                          <span style="font-size: 16px">33</span>
                        </div>
                      </div>
                      <div class="col-auto">
                        <i
                          class="far fa-angry text-danger fa-2x text-gray-300"
                        ></i>
                      </div>
                    </div>
                  </div>
                </div>
              </div>
              <div class="col-md-6 col-xl-3 mb-4">
                <div class="card shadow border-start-info py-2">
                  <div class="card-body">
                    <div class="row align-items-center no-gutters">
                      <div class="col me-2">
                        <div
                          class="text-uppercase fw-bold text-info text-xs mb-1"
                        >
                          <span class="text-success">delivered</span>
                        </div>
                        <div class="row g-0 align-items-center">
                          <div class="col-auto">
                            <div class="fw-bold text-dark h5 mb-0 me-3">
                              <span style="font-size: 16px">88</span>
                            </div>
                          </div>
                        </div>
                      </div>
                      <div class="col-auto">
                        <i class="fas fa-grin-hearts text-success fa-2x"></i>
                      </div>
                    </div>
                  </div>
                </div>
              </div>
            </div>
          </div>
          <div id="filter-order" style="display: flex; margin-bottom: 40px">
            <div class="d-flex align-items-center me-5" style="gap: 10px">
              <span>Trạng thái</span
              ><select class="form-select-sm">
                <option value="all">All</option>
                <option value="awaiting">Awaitng</option>
                <option value="shipping">Shipping</option>
                <option value="cancelled">Cancelled</option>
                <option value="Delivered">Delivered</option>
                
              </select>
            </div>
            <div class="d-flex align-items-center me-5" style="gap: 10px">
              <span>Thời gian</span
              ><select class="form-select-sm">
                <option value="7">7 ngày gần nhất</option>
               <option value="15">15 ngày gần nhất</option>
                <option value="30">30 ngày gần nhất</option>
                <option value="60">60 ngày gần nhất</option>
                 <option value="">Tất cả</option>
                
              </select>
            </div>
          </div>
          <div
            class="card card-stepper"
            id="listProductOrdered"
            style="border-radius: 16px; margin-bottom: 50px"
          >
            <div class="card-header p-4">
              <div class="d-flex justify-content-between align-items-center">
                <div>
                  <p class="text-muted mb-2">
                    Order ID <span class="fw-bold text-body">1222528743</span>
                  </p>
                  <p class="text-muted mb-0">
                    Place On
                    <span class="fw-bold text-body">12,March 2019</span>
                  </p>
                </div>
                <div class="d-flex flex-wrap">
                  <div>
                    <h6 class="mb-0">Đã xác nhận</h6>
                  </div>
                </div>
              </div>
            </div>
            <div class="card-body p-4">
              <div class="row" style="margin-bottom: 30px">
                <div class="col-md-12 col-lg-3 mb-4 mb-lg-0">
                  <div
                    class="bg-image hover-overlay hover-zoom ripple rounded"
                    data-mdb-ripple-color="light"
                  >
                    <img
                      class="w-100"
                      src="https://img.mwc.com.vn/giay-thoi-trang?w=1150&amp;h=0&amp;FileInput=/Resources/Product/2023/11/10/z4866023315266_142c89838534918b9bcf1b6e534b3b0b.jpg"
                      alt="Blue Jeans Jacket"
                    /><a href="#!"
                      ><div
                        class="mask"
                        style="background-color: rgba(251, 251, 251, 0.2)"
                      ></div
                    ></a>
                  </div>
                </div>
                <div class="col-md-6 col-lg-5 mb-4 mb-lg-0">
                  <p>
                    <strong
                      >Blue denim shirt Blue denim shirt Blue denim shirt Blue
                      denim shirt</strong
                    >
                  </p>
                  <span id="Color" style="display: flex; gap: 10px"
                    ><h6>Color:</h6>
                    <h6>Blue</h6></span
                  ><span id="Size" style="display: flex; gap: 10px"
                    ><h6>Size:</h6>
                    <h6>S</h6></span
                  ><span id="Quantity" style="display: flex; gap: 10px"
                    ><h6>Quantity:</h6>
                    <h6>1</h6></span
                  ><span id="Price" style="display: flex; gap: 10px"
                    ><h6>Price:</h6>
                    <h6>99$</h6></span
                  >
                </div>
<!--                 <div class="col-md-6 col-lg-4 mb-4 mb-lg-0">
				<a style="text-decoration: none;border:1px solid #42dca3;border-radius: 10px;padding: 5px;" href="#exampleModalCenter"  data-toggle="modal">
				  Feedback
				</a>
                </div> -->
                <div class="col-md-6 col-lg-4 mb-4 mb-lg-0 d-flex justify-content-end">
				    <div style="max-width: 200px;"> <!-- Thay đổi giá trị max-width tùy thuộc vào nhu cầu của bạn -->
				        <a style="text-decoration: none; border: 1px solid #42dca3; border-radius: 10px; padding: 5px 15px;" href="#exampleModalCenter" data-toggle="modal">
				            Feedback
				        </a>
				    </div>
				</div>
                
              </div>
              <div class="row">
                <div class="col-md-12 col-lg-3 mb-4 mb-lg-0">
                  <div
                    class="bg-image hover-overlay hover-zoom ripple rounded"
                    data-mdb-ripple-color="light"
                  >
                    <img
                      class="w-100"
                      src="https://img.mwc.com.vn/giay-thoi-trang?w=1150&amp;h=0&amp;FileInput=/Resources/Product/2023/11/10/z4866023315266_142c89838534918b9bcf1b6e534b3b0b.jpg"
                      alt="Blue Jeans Jacket"
                    /><a href="#!"
                      ><div
                        class="mask"
                        style="background-color: rgba(251, 251, 251, 0.2)"
                      ></div
                    ></a>
                  </div>
                </div>
                <div class="col-md-6 col-lg-5 mb-4 mb-lg-0">
                  <p>
                    <strong
                      >Blue denim shirt Blue denim shirt Blue denim</strong
                    >
                  </p>
                  <span id="Color" style="display: flex; gap: 10px"
                    ><h6>Color:</h6>
                    <h6>Blue</h6></span
                  ><span id="Size" style="display: flex; gap: 10px"
                    ><h6>Size:</h6>
                    <h6>S</h6></span
                  ><span id="Quantity" style="display: flex; gap: 10px"
                    ><h6>Quantity:</h6>
                    <h6>1</h6></span
                  ><span id="Price-1" style="display: flex; gap: 10px"
                    ><h6>Price:</h6>
                    <h6>99$</h6></span
                  >
                </div>
				<div class="col-md-6 col-lg-4 mb-4 mb-lg-0 d-flex justify-content-end">
				    <div style="max-width: 200px;"> <!-- Thay đổi giá trị max-width tùy thuộc vào nhu cầu của bạn -->
				        <a style="text-decoration: none; border: 1px solid #42dca3; border-radius: 10px; padding: 5px 15px;" href="#exampleModalCenter" data-toggle="modal">
				            Feedback
				        </a>
				    </div>
				</div>              </div>
            </div>
            <div class="card-footer p-4">
              <div
                class="methodPay"
                style="display: flex; gap: 10px; justify-content: end"
              >
                <p><strong>Phương thức thanh toán:</strong></p>
                <p>COD</p>
              </div>
              <div
                class="price-container"
                style="display: flex; gap: 10px; justify-content: end"
              >
                <p><strong>Total:</strong></p>
                <p>50$</p>
              </div>
            </div>
          </div>
          <div
            class="modal fade"
            role="dialog"
            tabindex="-1"
            id="exampleModalCenter"
            aria-labelledby="exampleModalCenterTitle"
            aria-hidden="true"
          >
            <div class="modal-dialog modal-dialog-centered" role="document">
              <div class="modal-content">
                <div class="modal-header">
                  <h5 class="modal-title" id="exampleModalLongTitle">
                    Feedback
                  </h5>
                  <button
                    aria-label="Close"
                    class="close"
                    data-dismiss="modal"
                    type="button"
                  >
                    <span aria-hidden="true">×</span>
                  </button>
                </div>
                <div class="modal-body">
					<div class="card">
						<div class="card-body">
						    <div class="d-flex flex-wrap gap-5">
						        <div><img src="https://ananas.vn/wp-content/uploads/Pro_AV00205_1-500x500.jpeg" width="70" height="70" /></div>
						        <div>
						            <div><span >Product Name: Vintas Vivu - Low Top</span></div>
						            <div >
						            <span style="font-size: 14px;color: #797D7F">Color: Red 
			                        </span>
						            </div>
						            <div><span style="font-size: 14px;color: #797D7F">Size: 39</span></div>            
						        </div>
						    </div>
						    <div class="rating-feedback" style="display: flex;gap:10px;align-items: center;padding: 10px 0px">
						     	<div><span>Rating:</span></div>            
						      <div id="rating-stars" class="rating">
							  <span class="star" data-rating="1">&#9733;</span>
							  <span class="star" data-rating="2">&#9733;</span>
							  <span class="star" data-rating="3">&#9733;</span>
							  <span class="star" data-rating="4">&#9733;</span>
							  <span class="star" data-rating="5">&#9733;</span>
							</div>
						    </div>
							
 							<div class="mb-3">
							  <label for="exampleFormControlTextarea1" class="form-label">Đánh giá chi tiết</label>
							  <textarea class="form-control" id="exampleFormControlTextarea1" rows="3"></textarea>
							</div>
							</div>
			
					</div>
                </div>
                <div class="modal-footer">
                  <button
                    class="btn btn-secondary"
                    data-dismiss="modal"
                    type="button"
                  >
                    Close</button
                  ><button class="btn btn-primary" type="button">
                    Gửi đánh giá
                  </button>
                </div>
              </div>
            </div>
          </div>
          <div
            class="card card-stepper"
            id="listProductOrdered"
            style="border-radius: 16px"
          >
            <div class="card-header p-4">
              <div class="d-flex justify-content-between align-items-center">
                <div>
                  <p class="text-muted mb-2">
                    Order ID <span class="fw-bold text-body">1222528743</span>
                  </p>
                  <p class="text-muted mb-0">
                    Place On
                    <span class="fw-bold text-body">12,March 2019</span>
                  </p>
                </div>
                <div>
                  <h6 class="mb-0">Đã xác nhận</h6>
                </div>
              </div>
            </div>
            <div class="card-body p-4">
              <div class="row" style="margin-bottom: 30px">
                <div class="col-md-12 col-lg-3 mb-4 mb-lg-0">
                  <div
                    class="bg-image hover-overlay hover-zoom ripple rounded"
                    data-mdb-ripple-color="light"
                  >
                    <img
                      class="w-100"
                      src="https://img.mwc.com.vn/giay-thoi-trang?w=1150&amp;h=0&amp;FileInput=/Resources/Product/2023/11/10/z4866023315266_142c89838534918b9bcf1b6e534b3b0b.jpg"
                      alt="Blue Jeans Jacket"
                    /><a href="#!"
                      ><div
                        class="mask"
                        style="background-color: rgba(251, 251, 251, 0.2)"
                      ></div
                    ></a>
                  </div>
                </div>
                <div class="col-md-6 col-lg-5 mb-4 mb-lg-0">
                  <p>
                    <strong
                      >Blue denim shirt Blue denim shirt Blue denim shirt Blue
                      denim shirt</strong
                    >
                  </p>
                  <span id="Color" style="display: flex; gap: 10px"
                    ><h6>Color:</h6>
                    <h6>Blue</h6></span
                  ><span id="Size" style="display: flex; gap: 10px"
                    ><h6>Size:</h6>
                    <h6>S</h6></span
                  ><span id="Quantity" style="display: flex; gap: 10px"
                    ><h6>Quantity:</h6>
                    <h6>1</h6></span
                  ><span id="Price-2" style="display: flex; gap: 10px"
                    ><h6>Price:</h6>
                    <h6>99$</h6></span
                  >
                </div>
				<div class="col-md-6 col-lg-4 mb-4 mb-lg-0 d-flex justify-content-end">
				    <div style="max-width: 200px;"> <!-- Thay đổi giá trị max-width tùy thuộc vào nhu cầu của bạn -->
				        <a style="text-decoration: none; border: 1px solid #42dca3; border-radius: 10px; padding: 5px 15px;" href="#exampleModalCenter" data-toggle="modal">
				            Feedback
				        </a>
				    </div>
				</div>              </div>
              <div class="row">
                <div class="col-md-12 col-lg-3 mb-4 mb-lg-0">
                  <div
                    class="bg-image hover-overlay hover-zoom ripple rounded"
                    data-mdb-ripple-color="light"
                  >
                    <img
                      class="w-100"
                      src="https://img.mwc.com.vn/giay-thoi-trang?w=1150&amp;h=0&amp;FileInput=/Resources/Product/2023/11/10/z4866023315266_142c89838534918b9bcf1b6e534b3b0b.jpg"
                      alt="Blue Jeans Jacket"
                    /><a href="#!"
                      ><div
                        class="mask"
                        style="background-color: rgba(251, 251, 251, 0.2)"
                      ></div
                    ></a>
                  </div>
                </div>
                <div class="col-md-6 col-lg-5 mb-4 mb-lg-0">
                  <p>
                    <strong
                      >Blue denim shirt Blue denim shirt Blue denim</strong
                    >
                  </p>
                  <span id="Color" style="display: flex; gap: 10px"
                    ><h6>Color:</h6>
                    <h6>Blue</h6></span
                  ><span id="Size" style="display: flex; gap: 10px"
                    ><h6>Size:</h6>
                    <h6>S</h6></span
                  ><span id="Quantity" style="display: flex; gap: 10px"
                    ><h6>Quantity:</h6>
                    <h6>1</h6></span
                  ><span id="Price-3" style="display: flex; gap: 10px"
                    ><h6>Price:</h6>
                    <h6>99$</h6></span
                  >
                </div>
				<div class="col-md-6 col-lg-4 mb-4 mb-lg-0 d-flex justify-content-end">
				    <div style="max-width: 200px;"> <!-- Thay đổi giá trị max-width tùy thuộc vào nhu cầu của bạn -->
				        <a style="text-decoration: none; border: 1px solid #42dca3; border-radius: 10px; padding: 5px 15px;" href="#exampleModalCenter" data-toggle="modal">
				            Feedback
				        </a>
				    </div>
				</div>              </div>
            </div>
            <div class="card-footer p-4">
              <div
                class="methodPay"
                style="display: flex; gap: 10px; justify-content: end"
              >
                <p><strong>Phương thức thanh toán:</strong></p>
                <p>COD</p>
              </div>
              <div
                class="price-container"
                style="display: flex; gap: 10px; justify-content: end"
              >
                <p><strong>Total:</strong></p>
                <p>50$</p>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
</body>

</html>