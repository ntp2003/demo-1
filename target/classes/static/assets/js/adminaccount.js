$(document).ready(function() {
	function loadAmdinAccount(pageNumber = 0) {
		let filterData = {
			searchValue: $("#admin-search-value").val(),
			searchOption: $("#admin-type-op").val()
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
							data: { promotionId: i.promotionId },
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
	}

	function loadCustomerAccount(pageNumber = 0) {
		let filterData = {
			searchValue: $("#customer-search-value").val(),
			searchOption: $("#customer-type-op").val()
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
							data: { promotionId: i.promotionId },
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
	}
	loadAmdinAccount()
	loadCustomerAccount();
});