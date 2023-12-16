$(document).ready(function() {
	$('#bannerInput').on("change", function(e) {
		var reader = new FileReader();
		reader.onload = function(event) {
			$('#selectedBanner').attr('src', event.target.result);
		}
		reader.readAsDataURL(e.target.files[0]);
	});

	$('#addBannerButton').click(function() {
		$('#bannerInput').click();
	});

	$("#add-product").click(function() {
		let tbody = $("#added-product-table tbody");
		let newRow = $(`<tr>
                <td><input class="form-control-sm form-control" type="search" style="margin: 0px auto;width: 70px;" /></td>
                <td class="text-break"></td>
                <td></td>
                <td style="text-align: center;width: 50px;"><button class="btn btn-danger btn-sm btn-circle ms-1" role="button" type="button"><i class="fas fa-trash text-white"></i></button></td>
            </tr>`)
		tbody.append(newRow);
		$(newRow).find("button").click(function() {
			newRow.remove();
		})
		$(newRow).find("input[type=search]").on("search", function() {
			if ($(this).val()) {
				$.getJSON(`/admin/Promotion/find-product?productId=${$(this).val()}`, function(json) {
					console.log(json);
					let productId = Object.getOwnPropertyNames(json)[0];
					let replaceRow = $(`<tr>
                <td style="text-align: center;">${productId}</td>
                <td class="text-break">${json[productId]}</td>
                <td>
                    <div class="input-group input-group-sm" style="margin: 0px auto;width: 80px;">
                    <input class="form-control discount-rate" type="text"
                    onkeypress="return isNumber(event)"
					onpaste="return false;"
                     form="add-promotion-form" 
                     data-info="${productId}" required/>
                    <span class="input-group-text">%</span></div>
                </td>
                <td style="text-align: center;width: 50px;">
                <button class="btn btn-danger btn-sm btn-circle ms-1" role="button" type="button">
                <i class="fas fa-trash text-white"></i>
                </button></td>
            </tr>`);
					newRow.replaceWith(replaceRow);
					$(replaceRow).find("button").click(function() {
						replaceRow.remove();
					});
				});
			}
		});
	});

	$('#add-promotion-form').submit(function(event) {
		event.preventDefault();
		let formData = {
			promotionName: $("#promotionName").val(),
			startTime: $("#startTime").val(),
			endTime: $("#endTime").val(),
			banner: $("#selectedBanner").attr("src"),
			items: []
		};
		try {
			if (formData.startTime > formData.endTime)
				throw "Thông tin về thời gian không hợp lệ";
			$("#added-product-table input.discount-rate").each(function() {
				let item = {
					productId: $(this).data("info"),
					discountRate: Number($(this).val())
				}
				if (item.productId == null || item.discountRate <= 0 || item.discountRate > 100)
					throw "Thông tin sản phẩm hoặc tỉ lệ giảm giá không hợp lệ";
				formData.items.push(item);
			});
			if (formData.items.length === 0)
				throw "Không có sản phẩm khuyến mãi";
		} catch (err) {
			$.notify(err, "danger", 9999);
			return;
		}
		$.LoadingOverlay("show");
		$.ajax({
			type: "POST",
			contentType: "application/json; charset=utf-8",
			url: "/admin/Promotion/add-promotion",
			data: JSON.stringify(formData),
			cache: false,
			success: function() {
				$('#add-promotion-modal').modal('hide');
				$("#added-product-table tbody").html('');
				document.getElementById('add-promotion-form').reset();
				loadPromotions();
				$.LoadingOverlay("hide");
				$.notify("Thêm khuyến mãi thành công!", "success", 9999);
			},
			error: function() {
				$.LoadingOverlay("hide");
				$.notify("Thêm khuyến mãi thất bại!", "danger", 9999);
			}
		});
	});

	function loadPromotions(pageNumber = 0) {
		let filterData = {
			fromDay: $("#from-day").val(),
			toDay: $("#to-day").val(),
			searchValue: $("#searchInput").val(),
		}

		let tbody = $("#promotion-table tbody");
		$(tbody).html('');
		$.ajax({
			type: "POST",
			contentType: "application/json; charset=utf-8",
			url: `/admin/Promotion?page=${pageNumber}&size=${$("#page-size option:selected").val()}`,
			data: JSON.stringify(filterData),
			cache: false,
			success: function(page) {
				console.log(filterData);
				console.log(page);
				let promotionList = page.content;

				promotionList.forEach((i) => {
					let p = $(` <tr data-info='${JSON.stringify(i)}'>
                					<td>${i.promotionId}</td>
                					<td class="text-break">${i.promotionName}</td>
                					<td>${i.startTime}</td>
                					<td>${i.endTime}</td>
                					<td class="text-center"><a href="${i.banner}" target="_blank">Link</a></td>
                					<td><button class="btn btn-primary btn-sm detail">Promotion Detail</button></td>
                					<td>
                					${i.canDelete ?
							'<button class="btn btn-danger btn-sm btn-circle ms-1"><i class="fas fa-trash text-white"></i></button>' : ''}
                					</td>
            					</tr>`);
					$(tbody).append(p)
					p.find("button.detail").click(function() {
						$("#promotion-detail-modal").data('info', p.data('info'))
						$("#promotion-detail-modal").modal("show");
					});
					p.find("button.btn-danger").click(function() {
						$.ajax({
							type: "DELETE",
							url: "/admin/Promotion/delete-promotion",
							data: {promotionId : i.promotionId},
							success: function() {
								$.notify("Xóa khuyến mãi thành công!", "success", 9999);
								loadPromotions(pageNumber);
							},
							error: function() {
								$.notify("Xóa khuyến mãi thất bại!", "error", 9999);
							}
						});
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
					firstPage.children('button').click(function() { loadPromotions(0) });
				}

				if (page.last) {
					lastPage.attr('class', 'page-item disabled');
				}
				else {
					lastPage.attr('class', 'page-item');
					lastPage.children('button').click(function() { loadPromotions(page.totalPages - 1) });
				}
				if (!page.empty) {
					let count = 0;
					firstPage.after(`<li class="page-item active"><a class="page-link">${page.number + 1}</a></li>`);
					for (let i = 1; (i < 3 || (page.totalPages < i + page.number + 1 && page.totalPages + i - page.number - 1 < 5)) && (page.number + 1 - i) > 0; i++) {
						count++;
						let newElement = $(`<li class="page-item"><button class="page-link">${page.number + 1 - i}</button></li>`);
						firstPage.after(newElement);
						newElement.click(function() { loadPromotions(page.number - i) });
					}
					for (let i = 1; count < 4 && (page.number + i) < page.totalPages; i++) {
						count++;
						let newElement = $(`<li class="page-item"><button class="page-link">${page.number + 1 + i}</button></li>`);
						lastPage.before(newElement);
						newElement.click(function() { loadPromotions(page.number + i) });
					}
				}
				$('#dataTable-info').html(`Showing ${page.pageable.offset + 1} to ${page.pageable.offset + page.numberOfElements} of ${page.totalElements}`);
			},
			error: function() {
				$.notify("Tải thông tin thất bại!", "danger", 9999);
			}
		});
	};

	$("#promotion-detail-modal").on('show.bs.modal', function() {
		let info = $(this).data('info');
		let tBody = $("#promotion-detail-table tbody");
		$('p.p-name').html(`Promotion Name: ${info.promotionName}`);
		$('label.s-time').html(`Start Time: ${info.startTime}`);
		$('label.e-time').html(`End Time: ${info.endTime}`);

		info.items.forEach((i) => {
			let newRow = `<tr>
									<td>${i.productId}</td>
									<td class="text-break">${i.productName}</td>
									<td>${i.discountRate}</td>
							</tr>`;
			tBody.append(newRow);
		});
	});

	$("#promotion-detail-modal").on('hidden.bs.modal', function() {
		$(this).find('tbody').html('');
		$('p.p-name, label.s-time, label.e-time').html('');
	});

	$("#from-day, #to-day, #page-size").change(function() {
		loadPromotions();
	});
	$("#searchInput").on("search", function() {
		loadPromotions();
	})

	loadPromotions();
})