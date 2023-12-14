$(document).ready(function() {
	$("#add-category").click(function() {
		let newRow = $(`<tr>
								<td style="width: 130px;">
								<input
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
												style="width: 50px; height: 30px; padding: 0px; border-radius: 0px;"></button>
											<div class="dropdown-menu"
												style="padding: 5px; margin: 0px; margin-left: 13px; min-width: 55px; max-width: 55px;">
											</div>
										</div>
									</td>
									<td><select class="form-select-sm form-control">
									</select></td>
									<td><input class="focus-ring form-control-sm form-control"
										type="text" required="" style="width: 70px;"
										onkeypress="return isNumber(event)"
										onpaste="return false;" form="add-lot-form"></td>
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
						$(newOption).click(function() {
							$(replaceRow).find('.color-pick button').css('background-color', newOption.css('background-color'));
							let sizeSelect = $(replaceRow).find('select');
							sizeSelect.html('');

							Object.entries($(newOption).data('info')).forEach((entry) => {
								const [key, value] = entry;
								sizeSelect.append($('<option>', {
									value: key,
									text: value
								}))
							});
							$(sizeSelect).find('option:first-child').attr('selected', 'selected');
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
		$(newRow).find("input[type=search]").on('keypress', function(e) {
			$(this).on('search');
		});
	});

	$('#add-lot-form').submit(function(event) {
		event.preventDefault();
		let formData = [];
		$('#category-table-add tbody tr').each(function() {
			let stockInventoryID = $(this).find('select option:selected').val();
			if (stockInventoryID) {
				formData.push({
					stockInventoryID: stockInventoryID,
					quantity: Number($(this).find('input').val())
				})
			}
		});

		console.log(formData);
		if (formData.length === 0) {
			$.notify(`Lô hàng không được để trống !!!`, "warn", 9999);
		}
		else {
			$.ajax({
				type: "POST",
				contentType: "application/json; charset=utf-8",
				url: "/admin/ProductLot/import-product-lot",
				data: JSON.stringify(formData),
				cache: false,
				success: function() {
					$.notify("Thêm lô hàng thành công!", "success", 9999);
					$('#add-lot-modal').modal('hide');
					$("#category-table-add tbody").html('');
				},
				error: function() {
					$.notify("Thêm lô hàng thất bại!", "danger", 9999);
				}
			});
		}
	});

	function loadProductLot(page=0) {
		let filterData = {
			fromDate: $("#from-day").val(),
			toDate: $("#to-day").val(),
			searchValue: $("#filter-data").find("input[type=search]").val(),
			searchOption: $("#search-option option:selected").val()
		}
		
		let tbody = $("#product-lot-table tbody");
		$(tbody).html('');
		$.ajax({
			type: "POST",
			contentType: "application/json; charset=utf-8",
			url: `/admin/ProductLot?page=${page}&size=${$("#page-size option:selected").val()}`,
			data: JSON.stringify(filterData),
			cache: false,
			success: function(page) {
				let lotList = page.content;
				
				lotList.forEach((i) => {
					let p = $(`<tr data-info='${JSON.stringify(i)}'>
								<td>${i.lotId}</td>
								<td>${i.importDate}</td>
								<td>${i.confirmerName}</td>
								<td>${i.confirmerPhoneNumber}</td>
								<td>${i.confirmerEmail}</td>
								<td><a role="button" href="#">View</a></td>
							</tr>`);
					$(tbody).append(p)
					p.find("a[role=button]").click(function(event) {
						event.preventDefault();
						$("#lot-details-modal").data('info', p.data('info'))
						$("#lot-details-modal").modal("show");
					});
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
					firstPage.children('button').click(function() { loadProductLot(0)});
				}

				if (page.last) {
					lastPage.attr('class', 'page-item disabled');
				}
				else {
					lastPage.attr('class', 'page-item');
					lastPage.children('button').click(function() { loadProductLot(page.totalPages - 1)});
				}
				if (!page.empty) {
					let count = 0;
					firstPage.after(`<li class="page-item active"><a class="page-link">${page.number + 1}</a></li>`);
					for (let i = 1; (i < 3 || (page.totalPages < i + page.number + 1 && page.totalPages + i - page.number - 1 < 5)) && (page.number + 1 - i) > 0; i++) {
						count++;
						let newElement = $(`<li class="page-item"><button class="page-link">${page.number + 1 - i}</button></li>`);
						firstPage.after(newElement);
						newElement.click(function() {loadProductLot(page.number - i)});
					}
					for (let i = 1; count < 4 && (page.number + i) < page.totalPages; i++) {
						count++;
						let newElement = $(`<li class="page-item"><button class="page-link">${page.number + 1 + i}</button></li>`);
						lastPage.before(newElement);
						newElement.click(function() {loadProductLot(page.number + i)});
					}
				}
				$('#dataTable-info').html(`Showing ${page.pageable.offset + 1} to ${page.pageable.offset + page.numberOfElements} of ${page.totalElements}`);
			},
			error: function() {
				$.notify("Tải thông tin thất bại!", "danger", 9999);
			}
		});
	}
	
	$("#lot-details-modal").on('show.bs.modal', function() {
		let lotId = $(this).data('info').lotId;
		let tBody = $(this).find('tbody');
		
		$('#lotId-lbl').html(`Lot ID : ${lotId}`);
		$('#confirmer-lbl').html(`Confirmer : ${$(this).data('info').confirmerName}`);
		$('#importDate-lbl').html(`Import Date : ${$(this).data('info').importDate}`);
		
		$.getJSON(`/admin/ProductLot/lot-import-item-details?lotId=${lotId}`, function(json) {
			json.forEach((i) => {
				let newRow = `<tr>
									<td>${i.productId}</td>
									<td class="text-break col-md-4">${i.productName}</td>
									<td>
										<div
											style="background: ${i.color}; width: 50px; height: 30px; margin: 0px auto;"></div>
									</td>
									<td>${i.size}</td>
									<td>${i.quantity}</td>
								</tr>`;
				tBody.append(newRow);
			});
		});
	});
	
	$("#lot-details-modal").on('hidden.bs.modal', function() {
		$(this).find('tbody').html('');
		$('#lotId-lbl').html('');
		$('#confirmer-lbl').html('');
		$('#importDate-lbl').html('');
	});
	
	$("#from-day, #to-day, #search-option, #page-size").change(function(){
		loadProductLot();
	});
	$("#filter-data").find("input[type=search]").on("search", function(){
		loadProductLot();
	})
	loadProductLot();
});