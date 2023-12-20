$(document).ready(function() {
	$.getJSON("/product/type", function(types) {
		types.forEach((product) => {
			let newItem = `<li class="nav-item"><a class="nav-link" href='/product?productTypeId=${product.productTypeId}'>${product.typeName}</a></li>`;
			$(newItem).insertAfter("#all-product-header");
		});
	});
})