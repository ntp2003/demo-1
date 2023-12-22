$(document).ready(function() {
	const formatter = new Intl.NumberFormat('en-US', {
		style: 'currency',
		currency: 'USD'
	});
	function padTo2Digits(num) {
		return num.toString().padStart(2, '0');
	}

	function formatDate(data) {
		date = new Date(data);
		return (
			[
				date.getFullYear(),
				padTo2Digits(date.getMonth() + 1),
				padTo2Digits(date.getDate()),
			].join('-') +
			' ' +
			[
				padTo2Digits(date.getHours()),
				padTo2Digits(date.getMinutes())
			].join(':')
		);
	}
	function getColorName(rgb) {
		let rel;
		$.ajaxSetup({ async: false });
		$.getJSON(`https://www.thecolorapi.com/id?rgb=${rgb}`, function(info) {
			rel = info.name.value;
		});
		$.ajaxSetup({ async: true });
		return rel;
	}
	$.getJSON("/customer/OrderHistory/status", function(statuss) {
		statuss.forEach(s => {
			$("#statusFilter").append(`<option value="${s}">${s}</option>`)
		})
	});
	function loadOrderHistory() {
		$("#card-box").html('')
		$.getJSON(`/customer/OrderHistory/info?status=${$("#statusFilter").val()}&fromDay=${$("#time-select").val()}`, function(views) {
			console.log(views)
			views.forEach(order => {
				let box = $(`
				<div class="card card-stepper" style="border-radius: 16px; margin-bottom: 50px">
		            <div class="card-header p-4">
		              <div class="d-flex justify-content-between align-items-center">
		                <div>
		                  <p class="text-muted mb-2">
		                    Invoice ID <span class="fw-bold text-body">${order.invoiceId}</span>
		                  </p>
		                  <p class="text-muted mb-0">
		                    Created time:
		                    <span class="fw-bold text-body">${formatDate(order.createdTime)} </span>
		                  </p>
		                  <p class="text-muted mb-0">
		                    Completed time:
		                    <span class="fw-bold text-body">${order.completedTime != null ? formatDate(order.completedTime) : ''}</span>
		                  </p>
		                </div>
		                <div class="d-flex flex-wrap">
		                  <div>
		                    <h6 class="mb-0">${order.status}</h6>
		                  </div>
		                </div>
		              </div>
		            </div>
		            <div class="cart-items card-body p-4">
		            </div>
		            <div class="card-footer p-4">
		              <div class="methodPay" style="display: flex; gap: 10px; justify-content: end">
		                <p><strong>Payment method:</strong></p>
		                <p>${order.payment}</p>
		              </div>
		              <div class="price-container" style="display: flex; gap: 10px; justify-content: end">
		                <p><strong>Total:</strong></p>
		                <p>${formatter.format(order.total)}</p>
		              </div>
		            </div>
		     </div>`)
				let itembox = box.find(".cart-items")
				order.orderItems.forEach(it => {
					let color = getColorName(it.color);
					let i = $(`
				 <div class="row" style="margin-bottom:20px">
		                <div class="col-md-12 col-lg-3 mb-4 mb-lg-0" >
		                  <div class="bg-image hover-overlay hover-zoom ripple rounded" data-mdb-ripple-color="light">
		                    <img class="w-100"
		                      src="${it.image}"
		                      alt="Blue Jeans Jacket" /><a href="#">
		                      <div class="mask" style="background-color: rgba(251, 251, 251, 0.2)"></div>
		                    </a>
		                  </div>
		                </div>
		                <div class="col-md-6 col-lg-5 mb-4 mb-lg-0">
		                  <p>
		                    <strong>${it.productName}</strong>
		                  </p>
		                  <span id="Color" style="display: flex; gap: 10px">
		                    <h6>Color:</h6>
		                    <h6>${color}</h6>
		                  </span><span id="Size" style="display: flex; gap: 10px">
		                    <h6>Size:</h6>
		                    <h6>${it.sizeName}</h6>
		                  </span><span id="Quantity" style="display: flex; gap: 10px">
		                    <h6>Quantity:</h6>
		                    <h6>${it.quantity}</h6>
		                  </span><span class="price" style="display: flex;align-items:center; gap: 10px">
		                    
		                  </span>
		                </div>
		                <div class="col-md-6 col-lg-4 mb-4 mb-lg-0 d-flex justify-content-end">
		                  <div style="max-width: 200px;" class="feedback-checked"> 
		                    
		                  </div>
		                </div>
		              </div>
				 `);
					if (it.discount > 0) {
						i.find(".price").html(`<h6>Price:</h6>
		                    <h6>${formatter.format(it.price - it.discount)}</h6>
		                    <h6 style="text-decoration: line-through;font-size: small">${formatter.format(it.price)}</h6>`)
					}
					else {
						i.find(".price").html(`<h6>Price:</h6>
		                    <h6>${formatter.format(it.price)}</h6>`)
					}
					let feedbackBtn = $(`<button class="btn btn-outline-success feedback-button" style="text-decoration: none; border: 1px solid #42dca3; border-radius: 10px; padding: 5px 15px;">
		                      Feedback
		                    </button>`);
					if (it.canFeedback) {
						i.find(".feedback-checked").html(feedbackBtn);
						feedbackBtn.click(function() {
							$("#feedback-modal").modal("show");
							$("#feedback-product").html(`<div>
									<img
										src="${it.image}"
										width="70" height="70" />
								</div>
								<div>
									<div>
										<span>Product Name: ${it.productName}</span>
									</div>
									<div>
									<span style="font-size: 14px; color: #797D7F">Color: ${color}</span>
								</div>
							<div>
							<span style="font-size: 14px; color: #797D7F">Size: ${it.sizeName}</span>
						</div>
					</div>`);
							$("#send-feedback").data("purchaseHistoryId", order.purchaseHistoryId);
							$("#send-feedback").data("stockInventoryId", it.stockInventoryId);
						});
					}
					itembox.append(i);
				});
				$("#card-box").append(box);
			});
		});
	}

	loadOrderHistory();
	$("#statusFilter, #time-select").change(function() {
		loadOrderHistory();
	})

	function loadOrderStatusStatistic() {
		$.getJSON(`/customer/OrderHistory/status-statistic`, function(info) {
			$("span[data-count]").each(function() {
				let flag = 0;
				info.forEach(i => {
					if (i.status == $(this).data("count")) {
						$(this).html(i.count);
						flag = 1;
					}
				});
				if (flag === 0) $(this).html(0);
			})
		});
	}

	loadOrderStatusStatistic();
	$("#send-feedback").click(function() {
		let formData = {
			purchaseHistoryId: $(this).data("purchaseHistoryId"),
			stockInventoryId: $(this).data("stockInventoryId"),
			rating: $("#rating-stars span[class*='clicked']").length,
			review: $("#review").val()
		}

		$.ajax({
			type: "POST",
			contentType: "application/json; charset=utf-8",
			url: `/customer/OrderHistory/send-feedback`,
			data: JSON.stringify(formData),
			cache: false,
			success: function() {
				$("#feedback-modal").modal("hide");
				loadOrderHistory();
			},
			error: function() {
				$.notify("Send feedback failed!", "danger", 9999);
			}
		});
	})
})