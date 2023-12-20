 <%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Checkout</title>

    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>

	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
	<link rel="stylesheet" href="/assets/css/main.css">
<link rel="stylesheet" href="/assets/css/filterTemplate.css"><link />
  </head>
  <body style="background-color:rgb(231, 238, 243);">
    <div class="container" style="margin-top:50px;margin-bottom: 60px">
      <div class="py-5 text-center">
        <h2>Thanh toán</h2>
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
            <li class="list-group-item d-flex justify-content-between">
              <span>Total (USD)</span>
              <strong>$20</strong>
            </li>
          </ul>

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
                />
                <div class="invalid-feedback">Valid last name is required.</div>
              </div>
            </div>

            <div class="mb-3" style="margin:10px 0px">
              <label for="phonenumber">Phone number</label>
              <div class="input-group">
                <input
                  type="text"
                  class="form-control"
                  id="phonenumber"
                  placeholder="phone number"
                />
                <div class="invalid-feedback" style="width: 100%">
                  Valid your phone number is required.
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


            <div class="mb-3" style="margin:10px 0px">
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
				<div class="mb-3" style="margin-bottom: 10px">
              <label for="details-address"
                >Details Address <span class="text-muted">(Optional)</span></label
              >
              <input
                type="text"
                class="form-control"
                id="details-address"
                placeholder="Apartment or suite"
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
            
            <!-- Thêm thư viện jQuery -->

		<script>
		  $(document).ready(function() {
		    // Validate phone number format
		    $('#phonenumber').on('input', function() {
		      var phoneNumber = $(this).val().replace(/\D/g, ''); // Lấy chỉ số điện thoại mà không bao gồm ký tự không phải số
		      if (phoneNumber.length === 10 && !isNaN(phoneNumber)) {
		        $(this).removeClass('is-invalid');
		      } else {
		        $(this).addClass('is-invalid');
		      }
		    });
		
		    // Validate email format
		    $('#email').on('input', function() {
		      var email = $(this).val();
		      var emailRegex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
		      if (emailRegex.test(email) || email === '') {
		        $(this).removeClass('is-invalid');
		      } else {
		        $(this).addClass('is-invalid');
		      }
		    });
		    
		    $('#firstName').on('input', function() {
		        var firstName = $('#firstName').val();
		        if (firstName.trim() !== '' ) {
			        $(this).removeClass('is-invalid');
			      } else {
			        $(this).addClass('is-invalid');
			      }
		    });

		    
		    $('#lastName').on('input', function() {
		        var lastName = $('#lastName').val();
		        if (lastName.trim() === '' ) {
			        $(this).addClass('is-invalid');
			      } else {
			        $(this).removeClass('is-invalid');
			      }
		    });
		    
		    $('#city').on('input', function() {
		        var city = $('#city').val();
		        if (city.trim() === 'Chọn tỉnh thành' ) {
			        $(this).addClass('is-invalid');
			      } else {
			        $(this).removeClass('is-invalid');
			      }
		    });
		    
		    $('#district').on('input', function() {
		        var city = $('#district').val();
		        if (city.trim() === 'Chọn quận huyện' ) {
			        $(this).addClass('is-invalid');
			      } else {
			        $(this).removeClass('is-invalid');
			      }
		    });

		    $('#ward').on('input', function() {
		        var city = $('#ward').val();
		        if (city.trim() === 'Chọn phường xã' ) {
			        $(this).addClass('is-invalid');
			      } else {
			        $(this).removeClass('is-invalid');
			      }
		    });


		    
		    
		    $('.btn-primary').on('click', function(event) {
		        // Kiểm tra lỗi cho số điện thoại
		        var phoneNumber = $('#phonenumber').val().replace(/\D/g, '');
		        if (phoneNumber.length !== 10 || isNaN(phoneNumber)) {
		          $('#phonenumber').addClass('is-invalid');
		          event.preventDefault(); // Ngăn chặn sự kiện mặc định (submit form)
		        } else {
		          $('#phonenumber').removeClass('is-invalid');
		        }

		        // Kiểm tra lỗi cho email
		        var email = $('#email').val();
		        var emailRegex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
		        if (!emailRegex.test(email) && email !== '') {
		          $('#email').addClass('is-invalid');
		          event.preventDefault(); // Ngăn chặn sự kiện mặc định (submit form)
		        } else {
		          $('#email').removeClass('is-invalid');
		        }

		        // Kiểm tra lỗi cho first name và last name
		        var firstName = $('#firstName').val();
		        var lastName = $('#lastName').val();
		        if (firstName.trim() === '' || lastName.trim() === '') {
		          $('#firstName, #lastName').addClass('is-invalid');
		          event.preventDefault(); // Ngăn chặn sự kiện mặc định (submit form)
		        } else {
		          $('#firstName, #lastName').removeClass('is-invalid');
		        }
		        var city = $('#city').val();
		        if (city === '') {
		          $('#city').addClass('is-invalid');
		          event.preventDefault(); // Ngăn chặn sự kiện mặc định (submit form)
		        } else {
		          $('#city').removeClass('is-invalid');
		        }

		        // Kiểm tra lỗi cho quận huyện
		        var district = $('#district').val();
		        if (district === '') {
		          $('#district').addClass('is-invalid');
		          event.preventDefault(); // Ngăn chặn sự kiện mặc định (submit form)
		        } else {
		          $('#district').removeClass('is-invalid');
		        }

		        // Kiểm tra lỗi cho phường xã
		        var ward = $('#ward').val();
		        if (ward === '') {
		          $('#ward').addClass('is-invalid');
		          event.preventDefault(); // Ngăn chặn sự kiện mặc định (submit form)
		        } else {
		          $('#ward').removeClass('is-invalid');
		        }
		      });
		  });
		</script>
            

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
                <label class="custom-control-label" for="debit">Ví điện tử</label>
              </div>
            </div>
            <hr class="mb-4" />
            <div class="checkout" style="display: flex; justify-content: end">
              <button class="btn btn-primary btn-md btn-block" type="submit">
                Continue to checkout
              </button>
              
            </div>
          </form>
        </div>
      </div>
    </div>
  </body>
</html>
 