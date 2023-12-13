<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Document</title>
    <style>
	    .bg-opacity-10 {
	  --bs-bg-opacity: 0.75;
	}
    </style>
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>

<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
    <!-- <script
      src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/js/bootstrap.bundle.min.js"
      integrity="sha384-U1DAWAznBHeqEIlVSCgzq+c9gqGAJn5c/t99JyeKa9xxaYpSvHU5awsuZVVFIhvj"
      crossorigin="anonymous"
    ></script> -->
 <script src="/assets/js/invalid-attribute-checkout.js"></script>
  </head>
  <body style="background-color:rgb(231, 238, 243);">
    <div class="container" style="margin-top:70px">
      <div class="py-5 text-center">
        <h2>Thanh toán</h2>
        <!-- <p class="lead">
          Below is an example form built entirely with Bootstrap 5 form
          controls. Each required form group has a validation state that can be
          triggered by attempting to submit the form without completing it.
        </p> -->
      </div>

      <div class="row">
        <div class="col-md-4 order-md-2 mb-4">
          <h4 class="d-flex justify-content-between align-items-center mb-3">
            <span class="text-muted">Your cart</span>
            <span class="badge badge-secondary badge-pill">3</span>
          </h4>
          <ul class="list-group mb-3">
            <li
              class="list-group-item d-flex justify-content-between lh-condensed"
            >
              <div>
                <h6 class="my-0">Product name</h6>
                <small class="text-muted">Brief description</small>
              </div>
              <span class="text-muted">$12</span>
            </li>
            <li
              class="list-group-item d-flex justify-content-between lh-condensed"
            >
              <div>
                <h6 class="my-0">Second product</h6>
                <small class="text-muted">Brief description</small>
              </div>
              <span class="text-muted">$8</span>
            </li>
            <li
              class="list-group-item d-flex justify-content-between lh-condensed"
            >
              <div>
                <h6 class="my-0">Third item</h6>
                <small class="text-muted">Brief description</small>
              </div>
              <span class="text-muted">$5</span>
            </li>
            <!-- <li class="list-group-item d-flex justify-content-between bg-light">
              <div class="text-success">
                <h6 class="my-0">Promo code</h6>
                <small>EXAMPLECODE</small>
              </div>
              <span class="text-success">-$5</span>
            </li> -->
            <li class="list-group-item d-flex justify-content-between">
              <span>Total (USD)</span>
              <strong>$20</strong>
            </li>
          </ul>

          <!-- <form class="card p-2">
            <div class="input-group">
              <input
                type="text"
                class="form-control"
                placeholder="Promo code"
              />
              <div class="input-group-append">
                <button type="submit" class="btn btn-secondary">Redeem</button>
              </div>
            </div>
          </form> -->
        </div>
        <div class="col-md-8 order-md-1">
          <h4 class="mb-3">Billing address</h4>
          <form class="needs-validation" novalidate>
            <div class="row">
              <div class="col-md-6 mb-3">
                <label for="firstName">First name</label>
                <input
                  type="text"
                  class="form-control"
                  id="firstName"
                  placeholder=""
                  value=""
                  required
                />
                <div class="invalid-feedback">
                  Valid first name is required.
                </div>
              </div>
              <div class="col-md-6 mb-3">
                <label for="lastName">Last name</label>
                <input
                  type="text"
                  class="form-control"
                  id="lastName"
                  placeholder=""
                  value=""
                  required
                />
                <div class="invalid-feedback">Valid last name is required.</div>
              </div>
            </div>

            <div class="mb-3">
              <label for="phonenumber">Phone number</label>
              <div class="input-group">
                <input
                  type="text"
                  class="form-control"
                  id="phonenumber"
                  placeholder="phone number"
                  required
                />
                <div class="invalid-feedback" style="width: 100%">
                  Your phonenumber is required.
                </div>
              </div>
            </div>

            <div class="mb-3">
              <label for="email"
                >Email <span class="text-muted">(Optional)</span></label
              >
              <input
                type="email"
                class="form-control"
                id="email"
                placeholder="you@example.com"
              />
              <div class="invalid-feedback">
                Please enter a valid email address for shipping updates.
              </div>
            </div>


            <div class="mb-3">
            <label for="address">Address</label>
            
		    <div style="display: flex;align-items: center;gap:10px">
		      <select
		        class="form-select form-select-sm mb-3"
		        id="city"
		        aria-label=".form-select-sm"
		        required
		      >
		        <option value="" selected>Chọn tỉnh thành</option>
		      </select>
		
		      <select
		        class="form-select form-select-sm mb-3"
		        id="district"
		        aria-label=".form-select-sm"
		        required
		      >
		        <option value="" selected>Chọn quận huyện</option>
		      </select>
		
		      <select
		        class="form-select form-select-sm mb-3"
		        id="ward"
		        aria-label=".form-select-sm"
		        required
		      >
		        <option value="" selected>Chọn phường xã</option>
		      </select>
		    </div>
		    </div>
		   <div class="mb-3">
              <input
                type="text"
                class="form-control"
                id="address"
                placeholder="Địa chỉ chi tiết (Thôn abc)"
              />
            </div>
		    
		
		    <script src="https://cdnjs.cloudflare.com/ajax/libs/axios/0.21.1/axios.min.js"></script>
		    <script>
		      var citis = document.getElementById("city");
		      var districts = document.getElementById("district");
		      var wards = document.getElementById("ward");
		      var Parameter = {
		        url: "https://raw.githubusercontent.com/kenzouno1/DiaGioiHanhChinhVN/master/data.json",
		        method: "GET",
		        responseType: "application/json",
		      };
		      var promise = axios(Parameter);
		      promise.then(function (result) {
		        renderCity(result.data);
		      });
		
		      function renderCity(data) {
		        for (const x of data) {
		          citis.options[citis.options.length] = new Option(x.Name, x.Id);
		        }
		        citis.onchange = function () {
		          district.length = 1;
		          ward.length = 1;
		          if (this.value != "") {
		            const result = data.filter((n) => n.Id === this.value);
		
		            for (const k of result[0].Districts) {
		              district.options[district.options.length] = new Option(
		                k.Name,
		                k.Id
		              );
		            }
		          }
		        };
		        district.onchange = function () {
		          ward.length = 1;
		          const dataCity = data.filter((n) => n.Id === citis.value);
		          if (this.value != "") {
		            const dataWards = dataCity[0].Districts.filter(
		              (n) => n.Id === this.value
		            )[0].Wards;
		
		            for (const w of dataWards) {
		              wards.options[wards.options.length] = new Option(w.Name, w.Id);
		            }
		          }
		        };
		      }
		    </script>
            

            <!-- <div class="mb-3">
              <label for="address2"
                >Address 2 <span class="text-muted">(Optional)</span></label
              >
              <input
                type="text"
                class="form-control"
                id="address2"
                placeholder="Apartment or suite"
              />
            </div> -->

            <!-- <div class="row">
              <div class="col-md-5 mb-3">
                <label for="country">Country</label>
                <select
                  class="custom-select d-block w-100"
                  id="country"
                  required
                >
                  <option value="">Choose...</option>
                  <option>United States</option>
                </select>
                <div class="invalid-feedback">
                  Please select a valid country.
                </div>
              </div>
              <div class="col-md-4 mb-3">
                <label for="state">State</label>
                <select class="custom-select d-block w-100" id="state" required>
                  <option value="">Choose...</option>
                  <option>California</option>
                </select>
                <div class="invalid-feedback">
                  Please provide a valid state.
                </div>
              </div>
              <div class="col-md-3 mb-3">
                <label for="zip">Zip</label>
                <input
                  type="text"
                  class="form-control"
                  id="zip"
                  placeholder=""
                  required
                />
                <div class="invalid-feedback">Zip code required.</div>
              </div>
            </div> -->
            <!-- <hr class="mb-4" /> -->
            <!-- <div class="custom-control custom-checkbox">
              <input
                type="checkbox"
                class="custom-control-input"
                id="same-address"
              />
              <label class="custom-control-label" for="same-address"
                >Shipping address is the same as my billing address</label
              >
            </div>
            <div class="custom-control custom-checkbox">
              <input
                type="checkbox"
                class="custom-control-input"
                id="save-info"
              />
              <label class="custom-control-label" for="save-info"
                >Save this information for next time</label
              >
            </div> -->
            <!-- <hr class="mb-4" /> -->

            <h4 class="mb-3">Phương thức thanh toán</h4>

            <div class="d-block my-3">
              <div class="custom-control custom-radio">
                <input
                  id="credit"
                  name="paymentMethod"
                  type="radio"
                  class="custom-control-input"
                  checked
                  required
                />
                <label class="custom-control-label" for="credit"
                  >Thanh toán khi nhận hàng</label
                >
              </div>
              <div class="custom-control custom-radio">
                <input
                  id="debit"
                  name="paymentMethod"
                  type="radio"
                  class="custom-control-input"
                  required
                />
                <label class="custom-control-label" for="debit">Momo</label>
              </div>
            </div>
            <!-- <div class="row">
              <div class="col-md-6 mb-3">
                <label for="cc-name">Name on card</label>
                <input
                  type="text"
                  class="form-control"
                  id="cc-name"
                  placeholder=""
                  required
                />
                <small class="text-muted">Full name as displayed on card</small>
                <div class="invalid-feedback">Name on card is required</div>
              </div>
              <div class="col-md-6 mb-3">
                <label for="cc-number">Credit card number</label>
                <input
                  type="text"
                  class="form-control"
                  id="cc-number"
                  placeholder=""
                  required
                />
                <div class="invalid-feedback">
                  Credit card number is required
                </div>
              </div>
            </div>
            <div class="row">
              <div class="col-md-3 mb-3">
                <label for="cc-expiration">Expiration</label>
                <input
                  type="text"
                  class="form-control"
                  id="cc-expiration"
                  placeholder=""
                  required
                />
                <div class="invalid-feedback">Expiration date required</div>
              </div>
              <div class="col-md-3 mb-3">
                <label for="cc-cvv">CVV</label>
                <input
                  type="text"
                  class="form-control"
                  id="cc-cvv"
                  placeholder=""
                  required
                />
                <div class="invalid-feedback">Security code required</div>
              </div>
            </div> -->
            <hr class="mb-4" />
            <div class="checkout" style="display: flex; justify-content: end">
              <button class="btn btn-primary btn-lg btn-block" type="submit">
                Continue to checkout
              </button>
            </div>
          </form>
        </div>
      </div>
    </div>
  </body>
</html>
