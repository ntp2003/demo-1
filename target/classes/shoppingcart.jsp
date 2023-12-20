<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Shopping Cart</title>
    
	<link rel="stylesheet" href="/assets/css/main.css">
	<link rel="stylesheet" href="/assets/css/filterTemplate.css"><link />
 	<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
  </head>
  <body style="background-color:rgb(231, 238, 243);">
    <section class="h-100 gradient-custom">
      <div class="container py-5">
        <div class="row d-flex justify-content-center my-4">
          <div class="col-md-8">
            <div class="card mb-4">
              <div class="card-header py-3">
                <h5 class="mb-0">Cart - 2 items</h5>
              </div>
              <div class="card-body">
                <!-- Single item -->
                <div class="row">
                  <div class="col-lg-3 col-md-12 mb-4 mb-lg-0">
                    <!-- Image -->
                    <div
                      class="bg-image hover-overlay hover-zoom ripple rounded"
                      data-mdb-ripple-color="light"
                    >
                      <img
                        src="https://img.mwc.com.vn/giay-thoi-trang?w=1150&h=0&FileInput=/Resources/Product/2023/11/10/z4866023315266_142c89838534918b9bcf1b6e534b3b0b.jpg"
                        class="w-100"
                        alt="Blue Jeans Jacket"
                      />
                      <a href="#!">
                        <div
                          class="mask"
                          style="background-color: rgba(251, 251, 251, 0.2)"
                        ></div>
                      </a>
                    </div>
                    <!-- Image -->
                  </div>

                  <div class="col-lg-5 col-md-6 mb-4 mb-lg-0">
                    <!-- Data -->
                    <p><strong>Blue denim shirt</strong></p>
                    <p>Color: blue</p>
                    <p>Size: M</p>
                    <button
                      type="button"
                      class="btn btn-danger btn-sm me-1 mb-2"
                      data-mdb-toggle="tooltip"
                      title="Remove item"
                    >
                      <i class="fas fa-trash"></i>
                    </button>

                  </div>

                  <div class="col-lg-4 col-md-6 mb-4 mb-lg-0">
                    <!-- Quantity -->
                    <label class="form-label" for="form1">Quantity</label>

                    <div class="d-flex mb-4" style="max-width: 150px">
                      <button
                        class="btn btn-primary px-2 me-2"
                        onclick="this.parentNode.querySelector('input[type=number]').stepDown()"
                      >
                        <i class="fas fa-minus"></i>
                      </button>

                      <div class="form-outline">
                        <input
                          id="form1"
                          min="1"
                          name="quantity"
                          value="1"
                          type="number"
                          class="form-control"
                        />
                      </div>

                      <button
                        class="btn btn-primary px-2 ms-2"
                        onclick="this.parentNode.querySelector('input[type=number]').stepUp()"
                      >
                        <i class="fas fa-plus"></i>
                      </button>
                    </div>
                    <!-- Quantity -->
					<div class="price" style=" display:flex;gap:15px">
					<p class="text-start text-md-center">
					  <del>$17.99</del>
					</p>

                     <p class="text-start text-md-center">
                      <strong>$15.99</strong>
                    </p>
					</div>
 
                  </div>
                </div>
                <!-- Single item -->

                <hr class="my-4" />

                <!-- Single item -->
                <div class="row">
                  <div class="col-lg-3 col-md-12 mb-4 mb-lg-0">
                    <!-- Image -->
                    <div
                      class="bg-image hover-overlay hover-zoom ripple rounded"
                      data-mdb-ripple-color="light"
                    >
                      <img
                        src="https://mdbcdn.b-cdn.net/img/Photos/Horizontal/E-commerce/Vertical/13a.webp"
                        class="w-100"
                      />
                      <a href="#!">
                        <div
                          class="mask"
                          style="background-color: rgba(251, 251, 251, 0.2)"
                        ></div>
                      </a>
                    </div>
                    <!-- Image -->
                  </div>

                  <div class="col-lg-5 col-md-6 mb-4 mb-lg-0">
                    <!-- Data -->
                    <p><strong>Red hoodie</strong></p>
                    <p>Color: red</p>
                    <p>Size: M</p>

                    <button
                      type="button"
                      class="btn btn-danger btn-sm me-1 mb-2"
                      data-mdb-toggle="tooltip"
                      title="Remove item"
                    >
                      <i class="fas fa-trash"></i>
                    </button>

                  </div>

                  <div class="col-lg-4 col-md-6 mb-4 mb-lg-0">
                    <!-- Quantity -->
                    <label class="form-label" for="form1">Quantity</label>

                    <div class="d-flex mb-4" style="max-width: 150px">
                      <button
                        class="btn btn-primary px-2 me-2"
                        onclick="this.parentNode.querySelector('input[type=number]').stepDown()"
                      >
                        <i class="fas fa-minus"></i>
                      </button>

                      <div class="form-outline">
                        <input
                          id="form1"
                          min="1"
                          name="quantity"
                          value="1"
                          type="number"
                          class="form-control"
                        />
                      </div>

                      <button
                        class="btn btn-primary px-2 ms-2"
                        onclick="this.parentNode.querySelector('input[type=number]').stepUp()"
                      >
                        <i class="fas fa-plus"></i>
                      </button>
                    </div>
                    <!-- Quantity -->

					<div class="price" style=" display:flex;gap:15px">
					<p class="text-start text-md-center">
					  <del>$17.99</del>
					</p>

                     <p class="text-start text-md-center">
                      <strong>$15.99</strong>
                    </p>
					</div>
                  </div>
                </div>
                <!-- Single item -->
              </div>
            </div>

          </div>
          <div class="col-md-4">
            <div class="card mb-4">
              <div class="card-header py-3">
                <h5 class="mb-0">Summary</h5>
              </div>
              <div class="card-body">
                <ul class="list-group list-group-flush">
                  <li
                    class="list-group-item d-flex justify-content-between align-items-center border-0 px-0 pb-0"
                  >
                    Products
                    <span>$53.98</span>
                  </li>
                  
                  <li
                    class="list-group-item d-flex justify-content-between align-items-center border-0 px-0 pb-0"
                  >
                    Discount
                    <span>$53.98</span>
                  </li>
                  
                  <li
                    class="list-group-item d-flex justify-content-between align-items-center px-0"
                  >
                    Shipping
                    <span>Free</span>
                  </li>
                  <li
                    class="list-group-item d-flex justify-content-between align-items-center border-0 px-0 mb-3"
                  >
                    <div>
                      <strong>Total amount</strong>
                      <strong>
                        <p class="mb-0">(including VAT)</p>
                      </strong>
                    </div>
                    <span><strong>$53.98</strong></span>
                  </li>
                </ul>
				<form style="display: flex;justify-content: end;margin-top:30px" id="CheckoutForm" action="/customer/Checkout" method="get">				
                <button type="submit" class="btn btn-primary btn-md btn-block"  role="button">
                  Go to checkout
                </button>
                </form>
              </div>
            </div>
          </div>
        </div>
      </div>
    </section>
  </body>
</html>
