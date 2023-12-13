<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Document</title>
    <link
      href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css"
      rel="stylesheet"
    />
    <!-- Google Fonts -->
    <link
      href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700&display=swap"
      rel="stylesheet"
    />
 <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>

<!-- Bao gồm Bootstrap JS -->
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="/assets/css/OrderHistory.css" />
    <style>
	    .bg-opacity-10 {
	  --bs-bg-opacity: 0.75;
	}
	.navbar {
  position: relative;
  display: block;
}

	
    </style>
</head>

<body  style="background-color:rgb(231, 238, 243);">

<section class="vh-50 gradient-custom-2">
  <div class="container-fluid py-5 h-100"> <!-- Thay đổi từ container thành container-fluid -->
    <div class="row d-flex justify-content-center align-items-center h-100">
      <div class="col-md-10 col-lg-8 col-xl-6">
            <div class="card card-stepper" style="border-radius: 16px">
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
                    <h6 class="mb-0"><a href="#">Đã xác nhận</a></h6>
                  </div>
                </div>
              </div>
              <div class="card-body p-4">
                <div class="row" style="margin-bottom: 30px">
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
                    <p>
                      <strong
                        >Blue denim shirt Blue denim shirt Blue denim shirt Blue
                        denim shirt</strong
                      >
                    </p>
                    <span id="Color" style="display: flex; gap: 10px">
                      <h6>Color:</h6>
                      <h6>Blue</h6>
                    </span>
                    <span id="Size" style="display: flex; gap: 10px">
                      <h6>Size:</h6>
                      <h6>S</h6>
                    </span>
                  </div>

                  <div class="col-lg-4 col-md-6 mb-4 mb-lg-0">
                    <!-- Quantity -->
                    <label class="form-label" for="form1">Quantity:</label>
                    <label class="form-label" for="form1">1</label>
                    <p class="text-start text-md-center">
                      <strong>$17.99</strong>
                    </p>
                    <!-- Price -->
                  </div>
                </div>

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
                    <p>
                      <strong
                        >Blue denim shirt Blue denim shirt Blue denim</strong
                      >
                    </p>
                    <span id="Color" style="display: flex; gap: 10px">
                      <h6>Color:</h6>
                      <h6>Blue</h6>
                    </span>
                    <span id="Size" style="display: flex; gap: 10px">
                      <h6>Size:</h6>
                      <h6>S</h6>
                    </span>
                  </div>

                  <div class="col-lg-4 col-md-6 mb-4 mb-lg-0">
                    <!-- Quantity -->
                    <label class="form-label" for="form1">Quantity:</label>
                    <label class="form-label" for="form1">1</label>
                    <p class="text-start text-md-center">
                      <strong>$17.99</strong>
                    </p>
                    <!-- Price -->
                  </div>
                </div>
              </div>
              <div class="card-footer" style="display:flex;gap:20px;justify-content: end;align-items: center">
                <div
                  class="methodPay"
                  style="display: flex; gap: 10px; justify-content: end"
                >
                  <p><strong>Phương thức thanh toán:</strong></p>
                  <p>COD</p>
                </div>
                <div
                  class="price-container"
                  style="display: flex; gap: 10px;justify-content: end"
                >
                  <p><strong>Total:</strong></p>
                  <p>50$</p>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </section>
  </body>
</html>
