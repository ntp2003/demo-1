$(document).ready(function() {

function LoadProductQuanAo() {
	$.ajax({
       url: "/product/filter",
       method : "POST",
               contentType: "application/json; charset=utf-8", // "jsonp" is required for cross-domain requests; use "json" for same-domain requests

         data: JSON.stringify({
		productTypes : [ 2 ]
	}),
         success: function (json) {
		console.log(json);
        var pCatalogList1 = json.content;
        $("#row-all").html('');
        pCatalogList1.forEach((product) => {
					const sortedMinPrices = product.categories.map(category => category.price).sort((a, b) => a - b);
    	const sortedMaxPrices = product.categories.map(category => category.price).sort((a, b) => b - a);

    // Lấy giá thấp nhất từ mảng đã sắp xếp
    const lowestPrice = sortedMinPrices[0];
    const highestPrice = sortedMaxPrices[0];
        let priceHtml;

    // Kiểm tra nếu giá thấp nhất bằng giá cao nhất
    if (lowestPrice === highestPrice) {
        priceHtml = `<span class="price">${lowestPrice}đ</span>`;
    } else {
        priceHtml = `<span class="price">${lowestPrice}đ - ${highestPrice}đ</span>`;
    }
                let productHtml1 = $(`                    
				    <div class="col-md-3 col-sm-6">
                    <div class="product-grid-giay">
                        <div class="product-image2">
                            <a href="#">
                                <img class="pic-1" src="${product.categories[0].images[0]}" />
                                <img class="pic-2" src="${product.categories[0].images[1]}" />
                            </a>
                            <a class="add-to-cart" href="abc">Add to cart <i class="fa-solid fa-cart-shopping fa-bounce"></i></a>
                        </div>
                        <div class="product-content">
                            <h3 class="title"><a href="#">${product.productName}</a></h3>
						<div class="color-available" style="display:flex;justify-content: center">
						    <ul class="nav tree" style="list-style-type: none">
						        ${product.categories.map(category => {
						            const color = category.color;
						            return `
						                <li class="cb-color">
						                    <label class="bg-color" style="background-color: ${color}">
						                        <input name="cbColor" type="checkbox" value="${color}" multiple />
						                    </label>
						                </li>
						            `;
						        }).join('')}
						    </ul>
						</div>
                            <span class="price">${priceHtml}</span>
                            <div class="sale-count" style="display:flex;gap:10px;justify-content: end;">
                            <span style="font-size:13px" class="sale-count-prouduct">Đã bán</span>
                            <span style="font-size:13px"  class="sale-count-prouduct">${product.purchaseCount}</span>                        </div>
                    </div>
				  </div>
                `);
                $("#row-all").append(productHtml1);
        }); 
        
    }
    })
};

function LoadFilterProduct() {
    $.getJSON("/product/type", function (json) {
        console.log(json);

        
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
						<label class="custom-control custom-checkbox"> <input
							type="checkbox" checked="" class="custom-control-input" />
							<div class="custom-control-label">Ananas</div>
						</label>
						 <label class="custom-control custom-checkbox"> <input
							type="checkbox" checked="" class="custom-control-input" />
							<div class="custom-control-label">Nike</div>
						</label> 
						<label class="custom-control custom-checkbox"> <input
							type="checkbox" checked="" class="custom-control-input" />
							<div class="custom-control-label">Colmate</div>
						</label>
						<label class="custom-control custom-checkbox"> <input
							type="checkbox" checked="" class="custom-control-input" />
							<div class="custom-control-label">Levents</div>
						</label> 
						<label class="custom-control custom-checkbox"> <input
							type="checkbox" checked="" class="custom-control-input" />
							<div class="custom-control-label">MWC</div>
						</label>
						<label class="custom-control custom-checkbox"> <input
							type="checkbox" checked="" class="custom-control-input" />
							<div class="custom-control-label">Bama</div>
						</label>
					</div>
				</div>
			</article>
		</div>
        `);
		$(".filter-container").append(categoryHtmlBrand);
		let categoryHtmlPrice = $(`
    <div class="Price-filter" style="margin-bottom: 15px; border: 2px solid #D6EAF8; border-radius: 5px;">
        <article class="filter-group">
            <header class="card-header" style="border: 2px solid #D6EAF8; border-radius: 5px;">
                <a style="text-decoration: none;" href="#" data-toggle="collapse" data-target="#collapse_3" aria-expanded="true" class="">
                    <h6 style="font-size: 18px" class="title">Price</h6>
                </a>
            </header>
            <div class="filter-content collapse show" id="collapse_3">
                <div class="card-body" style="display: grid">
                    <div class="form-group">
                        <label>Price Range</label>
                        <input type="range" class="form-range" min="100" max="2000" step="1" value="2000" id="priceRange" />
                        <p id="priceValue">2000</p>
                    </div>
                </div>
            </div>
        </article>
    </div>
        `);
        $(".filter-container").append(categoryHtmlPrice);
                            var priceRange = document.getElementById('priceRange');
            var priceValue = document.getElementById('priceValue');

            // Update the displayed value when the slider changes
            priceRange.addEventListener('input', function () {
                priceValue.innerText = priceRange.value;
            });
        $.getJSON("/product/color", function (json) {
    console.log(json);
    var pCatalogList2 = json;
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
        <button class="btn btn-block btn-primary" style="margin-top:20px;margin-left:20px; color: white;  font-weight: 600;  font-size: 18px;width: 120px">Apply</button>
    `);
    $(".filter-container").append(titleHtml);

    pCatalogList2.forEach((product) => {
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
				// Khi label được click, kiểm tra trạng thái của checkbox
				var checkbox = this.querySelector('input[type="checkbox"]');
				checkbox.checked = !checkbox.checked;

				// Xác định trạng thái của checkbox và thêm/loại bỏ lớp active tương ứng
				if (checkbox.checked) {
					this.classList.add("active");
				} else {
					this.classList.remove("active");
				}
			});
		});
});
});

};

LoadProductQuanAo();
LoadFilterProduct();
})