$(document).ready(function() {
	const formatter = new Intl.NumberFormat('en-US', {
		style: 'currency',
		currency: 'USD'
	});
	let price = 0;
	let discount = 0;

	function loadPrice() {
		$("#price-or").html(formatter.format(price));
		$("#discount").html(formatter.format(discount));
		$("#total").html(formatter.format(price + discount));
	}
	let count = loadNumberItem();
	$.ajaxSetup({ async: false });
	function getColorName(rgb) {
		let rel;
		$.getJSON(`https://www.thecolorapi.com/id?rgb=${rgb}`, function(info) {
			rel = info.name.value;
		});
		return rel;
	}

	$.getJSON("/customer/Cart/info", function(info) {
		info.forEach((i) => {
			let newItem = $(`<div class="row">
                  <div class="col-lg-3 col-md-12 mb-4 mb-lg-0">
                    <div
                      class="bg-image hover-overlay hover-zoom ripple rounded"
                      data-mdb-ripple-color="light"
                    >
                      <img
                        src="${i.image}"
                        class="w-100"
                      />
                    </div>
                  </div>
                  <div class="col-lg-5 col-md-6 mb-4 mb-lg-0">
                    <p><strong><a href="/product/detail/${i.productId}">${i.productName}</a></strong></p>
                    <p>Color: ${getColorName(i.color)}</p>
                    <p>Size: ${i.sizeName}</p>

                    <button
                      type="button"
                      class="btn btn-danger btn-sm me-1 mb-2 btn-remove"
                    >
                      <i class="fas fa-trash"></i>
                    </button>

                  </div>

                  <div class="col-lg-4 col-md-6 mb-4 mb-lg-0">
                    <label class="form-label">Quantity</label>

                    <div class="d-flex" style="max-width: 150px">
                      <button
                        class="btn btn-primary px-2 me-2 minus"
                        onclick="this.parentNode.querySelector('input[type=number]').stepDown()"
                      >
                        <i class="fas fa-minus"></i>
                      </button>

                      <div class="form-outline">
                        <input
                        	data-info="${i.stockInventoryId}"
                          min="1"
                          max="${i.stock}"
                          name="quantity"
                          value="${i.quantity}"
                          type="number"
                          class="form-control"
                        />
                      </div>

                      <button
                        class="btn btn-primary px-2 ms-2 plus"
                        onclick="this.parentNode.querySelector('input[type=number]').stepUp()"
                      >
                        <i class="fas fa-plus"></i>
                      </button>
                    </div>
                    <p class="text-danger alert-err"></p>
					<div class="price" style=" display:flex;gap:15px">
                     <p class="text-end text-md-center">
                      <strong>${formatter.format(Math.round(i.price * i.quantity * 100) / 100)}</strong>
                    </p>
					</div>
                  </div>
                </div>`);
			price += Math.round(i.price * i.quantity * 100) / 100;
			function loadPriceItem(){
			if (i.discountRate > 0) {
				newItem.find('.price').html(`
				<p class="text-end text-md-center">
                      <strong>${formatter.format(Math.round(Math.round(i.price * i.quantity * (100 - i.discountRate)) / 100))}</strong>
                    </p>
				<p class="text-start text-md-center">
					  <del>${formatter.format(Math.round(i.price * i.quantity * 100) / 100)}</del>
					</p>`);
				discount += Math.round(i.price * i.quantity * (100 - i.discountRate)) / 100;
			}
			else{
				newItem.find('.price').html(`<p class="text-end text-md-center">
                      <strong>${formatter.format(Math.round(i.price * i.quantity * 100) / 100)}</strong>
                    </p>`);
			}
			}
			loadPriceItem();
			function quantityChange() {
				let val = Number(newItem.find(`input[data-info="${i.stockInventoryId}"]`).val());

				if (val > 0 && val <= i.stock) {
					let change = val - i.quantity;
					$.ajax({
						type: "PUT",
						url: "/customer/Cart/update",
						data: { stockInventoryId: i.stockInventoryId, quantity: change },
						cache: false,
						success: function() {
							newItem.find(".alert-err").html("");
							price += Math.round(i.price * change * 100) / 100;
							if (i.discountRate > 0) {
								discount += Math.round(i.price * change * (100 - i.discountRate)) / 100;
							}
							i.quantity = val;
							loadPrice();
							loadPriceItem();
						},
						error: function() {
							newItem.find(".alert-err").html("Change quantity failed");
							newItem.find(`input[data-info="${i.stockInventoryId}"]`).val(val - change);
						}
					});
				}
				else {
					val <= 0 && newItem.find(".alert-err").html("Quantity must greater than 0");
					val > i.stock && newItem.find(".alert-err").html("Stock is not enough");
				}
			}
			newItem.find(`input[data-info="${i.stockInventoryId}"]`).on('keyup', function() {
				quantityChange();
			});
			newItem.find(`button.minus, button.plus`).on('click', function() {
				quantityChange();
			});
			let line = $(`<hr class="my-4" />`)
			$("#cart-box").append(newItem);
			$("#cart-box").append(line);
			newItem.find("button.btn-remove").click(function() {
				$.ajax({
					type: "DELETE",
					url: "/customer/Cart/delete",
					data: { stockInventoryId: i.stockInventoryId},
					cache: false,
					success: function() {
						price -= Math.round(i.price * i.quantity * 100) / 100;
						if (i.discountRate > 0) {
							discount -= Math.round(i.price * i.quantity * (100 - i.discountRate)) / 100;
						}
						newItem.remove();
						line.remove();
						loadPrice();
						count = loadNumberItem();
						loadHeaderCart();
					},
					error: function() {
						$.notify("Remove cart item failed!!!", "danger", 9999);
					}
				});
			});
		});
		$("#cart-box hr").last().remove();
		loadPrice();
	});
	$.ajaxSetup({ async: true });
	$("#go-checkout").click(function(){
		if(count == null || count == 0){
			alert("There are no items in the cart");
		}
		else{
			window.location.href = window.location.protocol + "//" + window.location.host + "/customer/Checkout"
		}
	});
});

function loadNumberItem(){
	let a;
	$.ajaxSetup({ async: false });
	$.getJSON("/customer/Cart/count", function(count) {
		$("#number-item").html(`Cart - ${count} items`);
		a =count; 
	});
	$.ajaxSetup({ async: true });
	return a;
}