
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>Checkout</title>

<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>

<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="/assets/css/main.css">
<link rel="stylesheet" href="/assets/css/filterTemplate.css">
<link />
</head>
<body style="background-color: rgb(231, 238, 243);">
	<sec:authentication var="info" property="principal.customerAccount" />
	<div class="container" style="margin-top: 50px; margin-bottom: 60px">
		<div class="py-5 text-center">
			<h2>Thanh toán</h2>
		</div>
		<div class="row">
			<div class="col-md-4 order-md-2 mb-4">
				<h4 class="d-flex justify-content-between align-items-center mb-3">
					<span class="text-muted">Your cart</span>
				</h4>
				<ul id="item-box" class="list-group mb-3">
					<li class="list-group-item d-flex justify-content-between">
						Shipping <span id="shippingfee">Free</span>
					</li>
					<li class="list-group-item d-flex justify-content-between"><span>Total
							(USD)</span> <strong id="total"></strong></li>
				</ul>

			</div>
			<div class="col-md-8 order-md-1">
				<h4 class="mb-3">Billing information</h4>
				<form id="checkout-form" class="needs-validation" novalidate>
					<div class="row">
						<div class="col-md-6 mb-3">
							<label for="firstName">First name</label> <input type="text"
								class="form-control" id="firstName" placeholder=""
								value="${info.firstName}" disabled />
							<div class="invalid-feedback">Valid first name is required.
							</div>
						</div>
						<div class="col-md-6 mb-3">
							<label for="lastName">Last name</label> <input type="text"
								class="form-control" id="lastName" placeholder=""
								value="${info.lastName}" disabled />
							<div class="invalid-feedback">Valid last name is required.</div>
						</div>
					</div>

					<div class="mb-3" style="margin: 10px 0px">
						<label for="phonenumber">Phone number</label>
						<div class="input-group">
							<input type="text" class="form-control" id="phonenumber"
								value="${info.phoneNumber}" placeholder="phone number" />
							<div class="invalid-feedback" style="width: 100%">Valid
								your phone number is required.</div>
						</div>
					</div>




					<div class="mb-3" style="margin: 10px 0px">
						<label for="address">Address</label>
						<div style="display: flex; align-items: center; gap: 10px">
							<select class="form-select form-select-sm mb-3" id="city"
								aria-label=".form-select-sm" required>
								<option value="" selected>Chọn tỉnh thành</option>
							</select> <select class="form-select form-select-sm mb-3" id="district"
								aria-label=".form-select-sm" required>
								<option value="" selected>Chọn quận huyện</option>
							</select> <select class="form-select form-select-sm mb-3" id="ward"
								aria-label=".form-select-sm" required>
								<option value="" selected>Chọn phường xã</option>
							</select>
						</div>

					</div>
					<div class="mb-3" style="margin-bottom: 10px">
						<label for="details-address">Details Address <span
							class="text-muted">(Optional)</span>
						</label> <input type="text" class="form-control" id="address-detail"
							placeholder="Apartment or suite" />
					</div>


					<script
						src="https://cdnjs.cloudflare.com/ajax/libs/axios/0.21.1/axios.min.js"></script>

					<h4 class="mb-3">Phương thức thanh toán</h4>

					<div class="d-block my-3">
						<div class="custom-control custom-radio">
							<input id="cod" name="paymentMethod" type="radio"
								class="custom-control-input" value="1" checked required /> <label
								class="custom-control-label" for="credit">Thanh toán khi
								nhận hàng</label>
						</div>
						<c:choose>
								<c:when test="${empty info.electronicWallet}">
											<div>
							<div class="custom-control custom-radio">
								<input id="debit-no-link" name="paymentMethod" type="radio"
									class="custom-control-input" required disabled /> <label
									class="custom-control-label" for="debit-no-link">Thanh toán qua ví điện tử</label>
							</div>
							<span style="font-size: 13px">Bạn chưa liên kết ví điện tử</span>
						</div>
								</c:when>
								<c:otherwise><div id ="wallet-box">
											<div class="custom-control custom-radio">
							<input id="wallet" name="paymentMethod" value="2" type="radio"
								class="custom-control-input" required /> <label
								class="custom-control-label" for="debit">Thanh toán qua
								ví điện tử</label>
						</div></div>
								</c:otherwise>
							</c:choose>
					</div>
					<hr class="mb-4" />
					<div class="checkout" style="display: flex; justify-content: end">
						<button id="submit" class="btn btn-primary btn-md btn-block"
							type="submit">Continue to checkout</button>
					</div>
				</form>
			</div>
		</div>
	</div>
	<script>
		    const formatter = new Intl.NumberFormat('en-US', {
				style: 'currency',
				currency: 'USD'
			});
		    	let shippingfee; 
		    	$.ajaxSetup({ async: false });
		    	$.getJSON("https://raw.githubusercontent.com/elsaconbo/testJSON/main/testJson.json", function(json){
			    	shippingfee = json;
			    	});
		    	$.ajaxSetup({ async: true});
		    	var citis = document.getElementById("city");
		      var districts = document.getElementById("district");
		      var wards = document.getElementById("ward");
		      let value = JSON.parse(`${info.address}`);
		      var Parameter = {
		        url: "https://raw.githubusercontent.com/kenzouno1/DiaGioiHanhChinhVN/master/data.json",
		        method: "GET",
		        responseType: "application/json",
		      };
		      var promise = axios(Parameter);
		      promise.then(function (result) {
		        renderCity(result.data);
		        $("#city").val(value.city);
			      citis.onchange();
			      $("#district").val(value.district);
			      district.onchange();
			      $("#ward").val(value.ward);
			      $("#address-detail").val(value.detail);
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

		          $("#shippingfee").html(formatter.format(shippingfee[this.value]));
		          $("#shippingfee").data('info', shippingfee[this.value]);
		        };
		        district.onchange = function () {
		          ward.length = 1;
		          const dataCity = data.filter((n) => n.Id === citis.value);
		          $()
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
	<script type="text/javascript">
		$(document).ready(function() {
			$.getJSON("/customer/Checkout/info", function(info){
				console.log(info);
				function loadTotal(){
					$("#total").val(info.total + Number($("#shippingfee").data('info')))
					$("#total").html(formatter.format($("#total").val()));
					if($("#total").val() > Number(`${info.electronicWallet.balance}`)){
						$("#wallet-box").html(`
							<div class="custom-control custom-radio">
							<input id="wallet" name="paymentMethod" type="radio"
								value="2"
									class="custom-control-input" required disabled /> <label
									class="custom-control-label" for="debit-no-money">Momo</label>
							</div>
							<span style="font-size: 13px">Tài khoản của bạn không đủ</span>
						`);
						$("#cod").prop("checked", true);
					}
					else{
						$("#wallet-box").html(`
								<div class="custom-control custom-radio">
								<input id="wallet" name="paymentMethod" value="2" type="radio"
									class="custom-control-input" required /> <label
									class="custom-control-label" for="debit">Thanh toán qua
									ví điện tử</label>
							</div>
						`);
					}
				}
				$("#city").on("change", loadTotal);
				info.itemDetails.forEach(i => {
					let item = $(`<li
							class="list-group-item d-flex justify-content-between lh-condensed">
							<div>
								<h6 class="my-0 mb-2">` + i.productName + `</h6>
								<small class="text-muted">Color: `+ getColorName(i.color) +`<br>Size: `+i.sizeName+`<br>Quantity: `+i.quantity+`</small>
							</div>
							<div class="price-product">
							</div>
						</li>`);
					if(i.discount > 0){
						item.find('.price-product').html(`
								<span class="text-muted">`+formatter.format((i.price - i.discount)*i.quantity)+`</span> <span
								style="text-decoration: line-through; font-size: 13px"
								class="text-muted ">`+formatter.format(i.price*i.quantity)+`</span>
						`);
					}
					else{
						item.find('.price-product').html(`
								<span class="text-muted">`+formatter.format(i.price*i.quantity)+`</span>
						`);
					}
					$("#item-box").prepend(item);
				});
				loadTotal();
				$("#checkout-form").submit(function(e){
					e.preventDefault();
					info.shippingFee = $("#shippingfee").data('info');
					info.address = JSON.stringify(
							{
								city : $('#city').val(), 
								district : $('#district').val(), 
								ward : $('#ward').val(), 
								detail : $('#address-detail').val()
							});
					info.paymentMethod = $('input[name="paymentMethod"]:checked').val();
					info.phoneNumber = $("#phonenumber").val();
					info.total = $("#total").val();
					
					$.ajax({
						type: "POST",
						contentType: "application/json; charset=utf-8",
						url: "/customer/Checkout",
						data: JSON.stringify(info),
						cache: false,
						success: function() {
							window.location.href = window.location.protocol + "//" + window.location.host + "/customer/Checkout/complete"
						},
						error: function(jqXHR, textStatus, errorThrown) {
						    alert(jqXHR.responseText);
						    location.reload();
						}
					});
				});
			});
		});
		function getColorName(rgb) {
			let rel;
			$.ajaxSetup({ async: false });
			$.getJSON("https://www.thecolorapi.com/id?rgb=" +rgb, function(info) {
				rel = info.name.value;
			});
			$.ajaxSetup({ async: true });
			return rel;
		}
	</script>

	<script src="/assets/js/checkout.js"></script>
</body>
</html>
