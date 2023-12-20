$(document).ready(function() {
	let currentFilter = {
		colors: [],
		brands: [],
		productTypes: [],
		minPrice: null,
		maxPrice: null
	}

	function initFilter() {
		currentFilter = {
			colors: [],
			brands: [],
			productTypes: [],
			minPrice: null,
			maxPrice: null
		}
	}

	function loadColors() {
		$.getJSON("/product/color", function(colors) {
			$(".Cfilter-container").html('');

			let titleHtml = $(`
			<div class="Color-filter" style="border: 2px solid #D6EAF8; border-radius: 5px;">
				<article class="filter-group">
					<header class="card-header" style="border: 2px solid #D6EAF8; border-radius: 5px;">
						<a style="text-decoration: none;" href="#" data-toggle="collapse" data-target="#collapse_1" aria-expanded="true" class="">
							<h6 style="font-size: 18px" class="title">Color</h6>
						</a>
					</header>
					<div class="filter-content collapse show" id="collapse_1" style="margin-top:5px">
						<div class="card-body">
							<ul class="nav tree" style="list-style-type: none;" >
									<li class="cb-color" id="colorList">
	
									</li>
							</ul>
						</div>
					</div>
				</article>
			</div>
			<button class="btn btn-block btn-primary" style="margin-top:20px;margin-left:20px; color: white;  font-weight: 600;  font-size: 18px;width: 120px"
			type="submit">Apply</button>
		`);
			$(".filter-container").append(titleHtml);

			colors.forEach((product) => {
				let productHtmlColor = $(`
				<label class="bg-color" style="background-color: ${product}">
					<input name="cbColor" type="checkbox" value="${product}" data-flag="false" readonly multiple />
				</label>
			`);
				$("#colorList").append(productHtmlColor);
			});
			var labels = document.querySelectorAll("label.bg-color");

			labels.forEach(function(label) {
				label.addEventListener("click", function() {
					var checkbox = this.querySelector('input[type="checkbox"]');
					checkbox.checked = !checkbox.checked;

					if (checkbox.checked) {
						this.classList.add("active");
					} else {
						this.classList.remove("active");
					}
				});
			});
		});
	};

	function loadBrand() {
		$.getJSON("/product/brand", function(brands) {
			let categoryHtmlBrand = $(`
					   <div class="Brand-filter" style="margin-bottom: 15px;border: 2px solid #D6EAF8;  border-radius: 5px;">
				<article class="filter-group">
					<header class="card-header" style="  border: 2px solid #D6EAF8;  border-radius: 5px;">
						<a style ="text-decoration: none" href="#" data-toggle="collapse" data-target="#collapse_2"
							aria-expanded="true" class="">
							<h6 style=" font-size: 18px" class="title">Brands</h6>
						</a>
					</header>
					<div class="filter-content collapse show" id="collapse_2">
						<div class="card-body">
						</div>
					</div>
				</article>
			</div>
			`);
			brands.forEach((brand) => {
				$(categoryHtmlBrand).find(".card-body").append(`
					<label class="custom-control custom-checkbox"> <input value='${brand}'
								type="checkbox" checked="" class="custom-control-input" />
								<div class="custom-control-label">${brand}</div>
							</label>
				`)
			});
			$(".filter-container").prepend(categoryHtmlBrand);
		});
	};

	function loadType() {
		$.getJSON("/product/type", function(types) {
			let typeHtml = $(`
				<div class="type-filter" style="margin-bottom: 15px;border: 2px solid #D6EAF8;  border-radius: 5px;">
					<article class="filter-group">
						<header class="card-header" style="  border: 2px solid #D6EAF8;  border-radius: 5px;">
							<a style ="text-decoration: none" href="#" data-toggle="collapse" data-target="#collapse_0"
								aria-expanded="true" class="">
								<h6 style=" font-size: 18px" class="title">Category</h6>
							</a>
						</header>
						<div class="filter-content collapse show" id="collapse_0">
							<div class="card-body">
							<label class="custom-control custom-checkbox">
								<input value="All" type="checkbox" checked="" class="custom-control-input customCheck" />
								<div class="custom-control-label">All</div>
							</label>
							</div>
						</div>
					</article>
				</div>
			`);

			$(".filter-container").prepend(typeHtml);
			types.forEach((product) => {
				let productHtml = $(`
					<label class="custom-control custom-checkbox">
						<input value="${product.productTypeId}" type="checkbox" class="custom-control-input customCheck"  />
						<div class="custom-control-label">${product.typeName}</div>
					</label>
				`);
				$(".type-filter .filter-content .card-body").append(productHtml);
			});

			$(".filter-container").on("change", ".custom-control-input.customCheck[value='All']", function() {
				if ($(this).prop("checked")) {
					$(".filter-content .card-body .custom-control-input.customCheck[value!='All']").prop("checked", false);
				}
			});
			$(".filter-container").on("change", ".custom-control-input.customCheck[value!='All']", function() {
				$(".filter-content .card-body .custom-control-input.customCheck[value='All']").prop("checked", false);
			});
		});
	}


	$.ajaxSetup({ async: false });
	loadBrand();
	loadType();
	loadColors();
	$.ajaxSetup({ async: true });

	function handelParam() {
		const urlParams = new URLSearchParams(window.location.search);
		if (urlParams.size > 0) {
			let productTypeId = urlParams.get('productTypeId');
			let sort = urlParams.get('sort');

			if (productTypeId != null) {
				$(`.type-filter input[value=${productTypeId}]`).each(function() {
					$(this).prop('checked', true);
					$(this).change();
				});
				currentFilter.productTypes.push(productTypeId);
			}

			if (sort != null) {
				$(`#sort-option`).val(sort);
			}
		}
	}

	handelParam()

	function LoadAllProduct(page = 0) {
		$.ajax({
			url: `/product/filter?page=${page}&size=${$("#page-size option:selected").val()}&sort=${$("#sort-option option:selected").val()}`,
			method: "POST",
			contentType: "application/json; charset=utf-8", // "jsonp" is required for cross-domain requests; use "json" for same-domain requests

			data: JSON.stringify(currentFilter),
			success: function(page) {
				var pCatalogList1 = page.content;
				$("#row-all").html('');
				pCatalogList1.forEach((product) => {
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
					$("#row-all").append(productItem);
					colors.find("label:last-child").click();
				});
				let pagination = $('ul.pagination');
				pagination.html('');
				pagination.append(`<li class=""><button class="page-link"><span aria-hidden="true">«</span></button></li>
							<li class=""><button class="page-link"><span aria-hidden="true">»</span></button></li>`)
				let firstPage = pagination.children(':first-child');
				let lastPage = pagination.children(':last-child');
				if (page.first) {
					firstPage.attr('class', 'page-item disabled');
				}
				else {
					firstPage.attr('class', 'page-item');
					firstPage.children('button').click(function() { LoadAllProduct(0) });
				}

				if (page.last) {
					lastPage.attr('class', 'page-item disabled');
				}
				else {
					lastPage.attr('class', 'page-item');
					lastPage.children('button').click(function() { LoadAllProduct(page.totalPages - 1) });
				}
				if (!page.empty) {
					let count = 0;
					firstPage.after(`<li class="page-item active"><a class="page-link">${page.number + 1}</a></li>`);
					for (let i = 1; (i < 3 || (page.totalPages < i + page.number + 1 && page.totalPages + i - page.number - 1 < 5)) && (page.number + 1 - i) > 0; i++) {
						count++;
						let newElement = $(`<li class="page-item"><button class="page-link">${page.number + 1 - i}</button></li>`);
						firstPage.after(newElement);
						newElement.click(function() { LoadAllProduct(page.number - i) });
					}
					for (let i = 1; count < 4 && (page.number + i) < page.totalPages; i++) {
						count++;
						let newElement = $(`<li class="page-item"><button class="page-link">${page.number + 1 + i}</button></li>`);
						lastPage.before(newElement);
						newElement.click(function() { LoadAllProduct(page.number + i) });
					}
				}
				$('#dataTable-info').html(`Showing ${page.pageable.offset + 1} to ${page.pageable.offset + page.numberOfElements} of ${page.totalElements}`);
			}
		})
	};



	LoadAllProduct();
	$("#page-size, #sort-option").change(function() {
		LoadAllProduct();
	});

	$("#filter-form").submit(function(event) {
		event.preventDefault();
		initFilter();
		$(".Brand-filter input[type=checkbox]:checked").each(function() {
			currentFilter.brands.push($(this).val());
		});
		$(".Color-filter input[type=checkbox]:checked").each(function() {
			currentFilter.colors.push($(this).val());
		});

		currentFilter.minPrice = $(".Price-filter input[name=priceOption]:checked").data("min");
		currentFilter.maxPrice = $(".Price-filter input[name=priceOption]:checked").data("max");
		$(".type-filter input[type=checkbox]:checked").each(function() {
			$(this).val() != "All" && currentFilter.productTypes.push($(this).val());
		});
		console.log(currentFilter);
		LoadAllProduct();
	});

	$('#searchInput').on('input', function() {
		if($(this).val()){
			$.getJSON(`/product/search?searchValue=${$('#searchInput').val()}`, function(products) {
				console.log(products)
				let fillBox = $('#searchResults');
				fillBox.html('');
				if (products.length == 0) {
					fillBox.html('<p>No products found</p>');
					return;
				}
				products.forEach((i) => {
					let item = $(`<div class="product">
						<div class="product-container">
							<img src='${i.image}' alt="Product 2">
							<div class="product-info">
								<a class="h6" href="/product/detail/${i.productId}" style="text-decoration:none" >${i.productName}</a>
								<div class="countSP">
								<p>Sold: ${i.purchaseCount}</p>
								</div>
								</div>
							</div>
						</div>
					</div>`);
					if(i.discountRate){
						let sale = $(`
							<div class="sale-overlay-search">Sale </div>
						`);
						sale.insertBefore(item.find(".countSP"));
					}
					fillBox.append(item);
				});
			});
		};
	})
	$('body').on('click', function () {
    	if($("#searchInput:hover, #searchResults:hover").length == 0)
      		$('#searchResults').html('');
    });

})