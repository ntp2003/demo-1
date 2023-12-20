$(document).ready(function() {
	let pathArray = window.location.pathname.split('/');
	let id = pathArray[pathArray.length - 1]

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
			color.on('click', function(){
				let price_box = $('#price-box');
				let sizes = $("#size-select");
				sizes.html('');
				price_box.html('')
				if(productDetail.discountRate)
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
					if(stock.stock <= 0){
						size.attr('disabled', true);
						size.find('input').attr('disabled', true);
						$("#add-to-cart").prop('disabled', true);
					}
					else{
						$("#add-to-cart").prop('disabled', false);
					}
					sizes.append(size);
					size.click(function(){
						$("#typeNumber").attr('max',stock.stock);
						$("#stock-item").html(`<small>Stock: ${stock.stock}</small>`);
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
			$(this).on('click',function() {
				color_select.find("label[class*='active']").removeClass("active");
				$(this).addClass("active");
			});
		});
		color_select.find("label:first-child").click();
	});
});
function change_image(image) {
	var container = document.getElementById("main-image");
	var mainImageURL = container.src;

	container.src = image.src;
	image.src = mainImageURL;
}