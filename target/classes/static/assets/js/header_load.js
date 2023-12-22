$(document).ready(function() {
	loadHeaderType();
	loadHeaderCart();
})

function loadHeaderType() {
	$.getJSON("/product/type", function(types) {
		types.forEach((product) => {
			let newItem = `<li class="nav-item"><a class="nav-link" href='/product?productTypeId=${product.productTypeId}'>${product.typeName}</a></li>`;
			$(newItem).insertAfter("#all-product-header");
		});
	});
};
function loadHeaderCart() {
	$.getJSON("/customer/Cart/count", function(count) {
		$(".product-count").html(count);
	})
}