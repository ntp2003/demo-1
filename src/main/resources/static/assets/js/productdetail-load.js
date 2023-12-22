$(document).ready(function() {
	let pathArray = window.location.pathname.split('/');
	let id = pathArray[pathArray.length - 1]

	$(window).keydown(function(event) {
		if (event.keyCode == 13) {
			event.preventDefault();
			return false;
		}
	});
	function getColorName(rgb) {
		let rel;
		$.ajaxSetup({ async: false });
		$.getJSON(`https://www.thecolorapi.com/id?rgb=${rgb}`, function(info) {
			rel = info.name.value;
		});
		$.ajaxSetup({ async: true });
		return rel;
	}
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
	$.getJSON(`/product/detail/info/${id}`, function(productDetail) {
		const formatter = new Intl.NumberFormat('en-US', {
			style: 'currency',
			currency: 'USD'
		});
		$("#product-name").html(productDetail.productName);
		$("#brand").html(productDetail.brand);
		$(".decriptionProduct .about").html(`Release Date: ${productDetail.releaseDate}<br>Origin: ${productDetail.origin}<br>${productDetail.description}`);
		let color_select = $("#color-select");
		productDetail.categoriedetails.forEach((i) => {
			let color = $(`<label class="bg-color" style="background-color: ${i.color}">
								<input name="cbColor" type="checkbox"
								multiple />
							</label>`);
			color.on('click', function() {
				let price_box = $('#price-box');
				let sizes = $("#size-select");
				sizes.html('');
				price_box.html('')
				if (productDetail.discountRate)
					price_box.append(`<span class="act-price">${formatter.format(i.price * (1 - productDetail.discountRate / 100))}</span>
										<div class="ml-2">
											<small class="dis-price">${formatter.format(i.price)}</small>
											<span>${productDetail.discountRate}% OFF</span>
										</div>`);
				else
					price_box.append(`<span class="act-price">${formatter.format(i.price)}</span>`);

				i.stocks.forEach(stock => {
					let size = $(`<label class="radio"> <input type="radio" name="size"
										value="${stock.stockInventoryId}"/> <span>${stock.sizeName}</span>
									</label>`);

					if (stock.stock <= 0) {
						size.attr('disabled', true);
						size.find('input').attr('disabled', true);
						$("#add-to-cart").prop('disabled', true);
					}
					else {
						$("#add-to-cart").prop('disabled', false);
					}

					sizes.append(size);
					size.click(function() {
						$("#typeNumber").attr('max', stock.stock);
						$("#stock-item").html(`<small>Stock: ${stock.stock}</small>`);
						if (stock.stock <= 0) {
							$("#add-to-cart").prop('disabled', true);
						}
						else {
							$("#add-to-cart").prop('disabled', false);
						}
					})
				});

				sizes.find("label:first-child").click();

				$(".image-container img").attr("src", i.images[0]);
				$(".thumbnail.text-center").html('');
				i.images.slice(1).forEach((img) => {
					$(".thumbnail.text-center").append(`<img onclick="change_image(this)"
										src="${img}"
										width="70" />`)
				})
			});
			color_select.append(color);
		});
		color_select.find("label").each(function() {
			$(this).on('click', function() {
				color_select.find("label[class*='active']").removeClass("active");
				$(this).addClass("active");
			});
		});
		color_select.find("label:first-child").click();
	});
	$("#update-cart-form").submit(function(e) {
		e.preventDefault();
		console.log($("#size-select input[name='size']:checked").val());
		$.ajax({
			type: "PUT",
			url: "/customer/Cart/update",
			data: { stockInventoryId: $("#size-select input[name='size']:checked").val(), quantity: $('#typeNumber').val() },
			cache: false,
			success: function() {
				$("#header-cart-i").addClass("fa-bounce");
				loadHeaderCart();
				setTimeout(() => {
					$("#header-cart-i").removeClass("fa-bounce");
				}, 3000);
			},
			error: function(xhr, textStatus) {
				if (xhr.status == 405)
					window.location.href = window.location.protocol + "//" + window.location.host + "/Login"
				$.notify("Thêm vào giỏ hàng thất bại!", "danger", 9999);
			}
		});
	});
	
	$.getJSON(`/product/detail/feedback/${id}`, function(feedbacks) {
		feedbacks.forEach(f => {
			let feedback = $(`<div class="userFeedback"
								style="border: 2px solid #CACFD2; border-radius: 10px; padding: 10px; margin-bottom: 35px">
								<div class="userFeedback-container">
									<div class="d-flex flex-wrap gap-5"
										style="justify-content: space-between;">
										<div class="userInfoFeedback"
											style="display: flex; gap: 15px; align-items: center">
											<div class="userInfoFeedback-container"
												style="display: flex; gap: 10px; align-items: center">
												<div>
													<img style="border-radius: 50px"
														src="${f.avatar}"
														width="40" height="40" />
												</div>
												<div class="ratingInfo">
													<span class="userNameFeedback">${f.customerName}</span>
													<div class="rating-feedback"
														style="display: flex; gap: 10px; align-items: center;">
														<div id="rating-stars" class="rating">
															<span class="star" data-rating="1">&#9733;</span>
															<span class="star" data-rating="2">&#9733;</span>
															<span class="star" data-rating="3">&#9733;</span> <span
																class="star" data-rating="4">&#9733;</span> <span
																class="star" data-rating="5">&#9733;</span>
														</div>
													</div>
												</div>
											</div>
										</div>
										<div class="time-order"
											style="font-size: 15px; padding-right: 30px">
											<span class="text-timeorder">Thời gian:</span> <span>${formatDate(f.time)}</span>
										</div>
									</div>
									<div class="infoProductFeedback d-flex gap-3"
										style="margin-top: 5px">
										<div>
											<span style="font-size: 14px; color: #797D7F">Color: ${getColorName(f.color)}</span>
										</div>
										<div>
											<span style="font-size: 14px; color: #797D7F">Size: ${f.size}</span>
										</div>
									</div>
									<p class="about" style="margin-right: 30px; padding-top: 5px">
										${f.review}</p>
								</div>
							</div>`);
					for(let i=0 ; i<=f.rate; i++ ){
						feedback.find(`span.star[data-rating='${i}']`).addClass("active");
					}
					$("#feedback-box").append(feedback);
		})
	})
});
function change_image(image) {
	var container = document.getElementById("main-image");
	var mainImageURL = container.src;

	container.src = image.src;
	image.src = mainImageURL;
}