$(document).ready(function() {
	$("#add-category").click(function() {
		let newRow = $(`<tr>
								<td style="width: 130px;"><input
									class="focus-ring form-control-sm w-75 form-control"
									type="search" style="margin: 0px auto;"
									onkeypress="return isNumber(event)"
										onpaste="return false;"></td>
								<td class="text-break col-md-4"></td>
								<td></td>
								<td></td>
								<td></td>
								<td><a class="btn btn-danger btn-circle ms-1"
									role="button"><i class="fas fa-trash text-white"></i></a></td>
						</tr>`);
		$("#category-table-add tbody").append(newRow);
		$(newRow).find("input[type=search]").on("search", function() {
			if ($(this).val()) {
				$.getJSON(`/admin/ProductLot/product-option?productId=${$(this).val()}`, function(json) {
					console.log(json);
					let replaceRow = $(`<tr>
									<td>${json.productId}</td>
									<td class="text-break col-md-4">${json.productName}</td>
									<td>
										<div class="dropdown color-pick">
											<button class="btn btn-sm" aria-expanded="false"
												data-bs-toggle="dropdown" type="button"
												style="background: #a33232; width: 50px; height: 30px; padding: 0px; border-radius: 0px;"></button>
											<div class="dropdown-menu"
												style="padding: 5px; margin: 0px; margin-left: 13px; min-width: 55px; max-width: 55px;">
											</div>
										</div>
									</td>
									<td><select class="form-select-sm form-control">
									</select></td>
									<td><input class="focus-ring form-control-sm form-control"
										type="text" required="" style="width: 70px;"></td>
									<td><a class="btn btn-danger btn-circle ms-1"
										role="button" type="delete" ><i class="fas fa-trash text-white"></i></a></td>
								</tr>`);
					newRow.replaceWith(replaceRow);
					$(replaceRow).find("a[type=delete]").click(function() {
						replaceRow.remove();
					});
					
					Object.values(json.optionMap).forEach(function(val) {
						let newOption = $(`<a class="dropdown-item" style="width: 43px; height: 30px; background: ${val.color}; padding: 0px;"	role="button"></a>`);
						$(newOption).data('info', val.sizeOption);
						$(replaceRow).find(".dropdown-menu").append(newOption);
						$(newOption).click(function(){
							$(replaceRow).find('.color-pick button').css('background-color', newOption.css('background-color'));
						});
					});
					$(replaceRow).find(".dropdown-menu a:first-child").click();
				}).fail(function() {
					newRow.find(".text-break").html('<label class="form-label text-danger mb-0">Not Found Product</label>');
				});
			}
		});
		$(newRow).find("a[role=button]").click(function() {
			newRow.remove();
		});
	}
	)
});