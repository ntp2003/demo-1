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
    <!-- Bao gồm jQuery -->
 	<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>

<!-- Bao gồm Bootstrap JS -->
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>

  </head>
  <body style="background-color:rgb(231, 238, 243);">
    <section class="h-100 gradient-custom">
      <div class="container py-5">
        <div class="row d-flex justify-content-center my-4">
          <div class="col-md-8">
            <div class="card mb-4">
              <div class="card-header py-3">
                <h5 id="number-item" class="mb-0"></h5>
              </div>
              <div class="card-body" id="cart-box">
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
                    <span id="price-or"></span>
                  </li>
                  
                  <li
                    class="list-group-item d-flex justify-content-between align-items-center border-0 px-0 pb-0"
                  >
                    Discount
                    <span id="discount"></span>
                  </li>
                  <li
                    class="list-group-item d-flex justify-content-between align-items-center border-0 px-0 mb-3"
                  >
                    <div>
                      <strong>Total amount</strong>
                    </div>
                    <span><strong id="total"></strong></span>
                  </li>
                </ul>
                <button id="go-checkout" class="btn btn-primary btn-md btn-block"  role="button">
                  Go to checkout
                </button>
              </div>
            </div>
          </div>
        </div>
      </div>
    </section>
    <script src="/assets/js/notify.js"></script>
    <script src="/assets/js/shoppingcart.js"></script>
  </body>
</html>
