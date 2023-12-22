$(document).ready(function() {
	const ViewBoxMode = {
		BESTSELLER: { key: 0, href: "/product?sort=purchaseCount,desc" },
		SALE: { key: 1, href: "/Sale" },
		NEWLYRELEASED: { key: 2, href: "/product?sort=releaseDate,desc" },
	};
	function productElement(product) {
		let productItem = $(`
						<div class="col-md-3 col-sm-6">
						<div class="product-grid-item">
							<div class="product-image2">
								<a class="image-box">
									
								</a>
								<a class="add-to-cart" href="/product/detail/${product.productId}">Add to cart <i class="fa-solid fa-cart-shopping fa-bounce"></i></a>
								<div></div> 
	
							</div>
							<div class="product-content">
								<h3 class="title"><a href="/product/detail/${product.productId}">${product.productName}</a></h3>
							<div class="color-available" style="display:flex;justify-content: center">
								<ul class="nav tree" style="list-style-type: none">
								</ul>
							</div>
							<div class="price-container">
								<span class="price"><s>222</s></span>
								
							</div>
								<div class="sale-count" style="display:flex;gap:10px;justify-content: end;">
								<span style="font-size:13px" class="sale-count-prouduct">Đã bán</span>
								<span style="font-size:13px"  class="sale-count-prouduct">${product.purchaseCount}</span>
								</div>
							</div>
						</div>
					  </div>
					`);
		if (product.discountRate > 0) {
			productItem.find(".product-image2 div").html(`<div class="sale-overlay">Sale <li style="list-style-type: none">${product.discountRate}%</li></div>`);
		}
		let colors = productItem.find("ul.tree");
		const formatter = new Intl.NumberFormat('en-US', {
			style: 'currency',
			currency: 'USD'
		});
		product.categories.forEach((i) => {
			let option = $(`<li class="cb-color">
							<label class="bg-color" style="background-color: ${i.color}">
								<input name="cbColor" type="checkbox" value="${i.color}" multiple />
							</label>
						</li>`);
			option.find("label").click(function() {
				productItem.find(".image-box").html(`
								<img class="pic-1" src="${i.images[0]}" />
									<img class="pic-2" src="${i.images[1]}" />
							`);
				productItem.find(".price-container").html(`<span class="price"> ${formatter.format(i.price * (1 - product.discountRate / 100))}</span>`)
				if (product.discountRate > 0) {
					productItem.find(".price-container").prepend(`<span class="price"><small><s>${formatter.format(i.price)}</s></small></span>`);
				}
			});
			colors.append(option);
		});
		colors.find("label:last-child").click();
		return productItem;
	}
	function loadViewBox(title, mode) {
		let box = $(` <div class="container" style="margin-top: 50px">
		<div class="row" style="margin-bottom: 50px">
			<div class="col-md-8 col-xl-6 text-center mx-auto bordered-container">
				<h4 class="text-uppercase text-center link-dark">${title}</h4>
				<hr style="border-top: 2px dashed #616A6B;">
				<nav class="navbar navbar-expand-md navbar-light">
					<div class="container">
						<button class="navbar-toggler" type="button"
							data-toggle="collapse" data-target="#navbarNav"
							aria-controls="navbarNav" aria-expanded="false"
							aria-label="Toggle navigation">
							<span class="navbar-toggler-icon"></span>
						</button>
						<div class="collapse navbar-collapse" id="navbarNav">
							<ul class="navbar-nav mx-auto">
								
							</ul>
						</div>
					</div>
				</nav>
			</div>
		</div>
		<div class="container" id="container-item">
		</div>
		<div class="text-center">
			<a class="text-uppercase text-center link-dark" href="${mode.href}">Xem thêm</a>
		</div>
	</div>`);
		$.getJSON(`/product/view?mode=${mode.key}`, function(views) {
			let container = box.find("#container-item");
			views.forEach((view) => {
				let type = $(`<li class="nav-item"><a class="nav-link"
									href="javascript:void(0);">${view.productType.typeName}</a>
								</li>`);
				let rowItems = $('<div class="row"></div>');
				box.find("ul.navbar-nav").append(type);
				view.productViewItems.forEach((i) => {
					rowItems.append(productElement(i));
				});
				type.find("a").click(function(e) {
					e.preventDefault();
					container.html(rowItems);
				});
			});

			box.find("ul").find("li:first-child").find("a").click();
		});
		$("#slider").after(box)
		$(box).after('<hr style="border-top: 1px solid #616A6B">');
	}
	loadViewBox("NEWLY RELEASED", ViewBoxMode.NEWLYRELEASED);
	loadViewBox("BEST SELLER", ViewBoxMode.BESTSELLER);
	$.getJSON("/promotion/exists", function(exists) {
		if (exists)
			loadViewBox("SUPER SALE", ViewBoxMode.SALE);
	});
});