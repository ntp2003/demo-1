$(document).ready(function() {
	function loadAdminAccount(pageNumber = 0) {
		let filterData = {
			searchValue: $("#admin-search-value").val(),
			searchOption: $("#admin-type-op").val()
		}

		let tbody = $("#admin-tb tbody");
		$(tbody).html('');
		$.ajax({
			type: "POST",
			contentType: "application/json; charset=utf-8",
			url: `/admin/creator/Account/admin?page=${pageNumber}&size=${$("#admin-page-size option:selected").val()}&sort=${$("#admin-type-op option:selected").attr('sort') + $("#admin-sort-op").val()}`,
			data: JSON.stringify(filterData),
			cache: false,
			success: function(page) {
				console.log(filterData);
				console.log(page);
				let customerList = page.content;

				customerList.forEach((i) => {
					let p = $(` <tr>
                                 <td>${i.username}</td>
                                  <td>${i.firstName}</td>
                                   <td>${i.lastName}</td>
                                  <td>${i.phoneNumber}</td>
                                  <td>${i.cccd}</td>
                                  <td>${i.email}</td>
                                 <td style="text-align: center;">${i.creator}</td>
                                  <td class="delete"></td>
                                 </tr>`);
					if (i.creator == false) {
						let btn = $(`<button class="btn btn-danger btn-sm btn-circle ms-1" type="button" style="width: 33px;height: 33px;"><i class="fas fa-trash text-white"></i></button>`);
						p.find(".delete").html(btn);
						btn.click(function() {
							$.ajax({
								type: "DELETE",
								url: "/admin/creator/Account/admin",
								data: { userName: i.username },
								success: function() {
									$.notify("Xóa tài khoản thành công!", "success", 9999);
									loadAdminAccount(pageNumber);
								},
								error: function() {
									$.notify("Xóa tài khoản thất bại!", "error", 9999);
								}
							});
						});
					}
					$(tbody).append(p)

					/*p.find("button.btn-danger").click(function() {
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
					});*/
				});
				let pagination = $('#admin-pg');
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
					firstPage.children('button').click(function() { loadAdminAccount(0) });
				}

				if (page.last) {
					lastPage.attr('class', 'page-item disabled');
				}
				else {
					lastPage.attr('class', 'page-item');
					lastPage.children('button').click(function() { loadAdminAccount(page.totalPages - 1) });
				}
				if (!page.empty) {
					let count = 0;
					firstPage.after(`<li class="page-item active"><a class="page-link">${page.number + 1}</a></li>`);
					for (let i = 1; (i < 3 || (page.totalPages < i + page.number + 1 && page.totalPages + i - page.number - 1 < 5)) && (page.number + 1 - i) > 0; i++) {
						count++;
						let newElement = $(`<li class="page-item"><button class="page-link">${page.number + 1 - i}</button></li>`);
						firstPage.after(newElement);
						newElement.click(function() { loadAdminAccount(page.number - i) });
					}
					for (let i = 1; count < 4 && (page.number + i) < page.totalPages; i++) {
						count++;
						let newElement = $(`<li class="page-item"><button class="page-link">${page.number + 1 + i}</button></li>`);
						lastPage.before(newElement);
						newElement.click(function() { loadAdminAccount(page.number + i) });
					}
				}
				$('#admin-dt-info').html(`Showing ${page.pageable.offset + 1} to ${page.pageable.offset + page.numberOfElements} of ${page.totalElements}`);
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

		let tbody = $("#customer-tb tbody");
		$(tbody).html('');
		$.ajax({
			type: "POST",
			contentType: "application/json; charset=utf-8",
			url: `/admin/creator/Account/customer?page=${pageNumber}&size=${$("#customer-page-size option:selected").val()}&sort=${$("#customer-type-op option:selected").attr('sort') + $("#customer-sort-op").val()}`,
			data: JSON.stringify(filterData),
			cache: false,
			success: function(page) {
				console.log(filterData);
				console.log(page);
				let customerList = page.content;

				customerList.forEach((i) => {
					let p = $(` <tr>
                                    <td style="text-align: center;">${i.accountId}</td>
                                    <td class="text-break">${i.email}</td>
                                     <td>${i.firstName}</td>
                                     <td>${i.lastName}</td>
                                     <td>${i.phoneNumber}</td>
                                      <td class="py-1">
                                      <button class="btn btn-danger btn-sm btn-circle ms-1" type="button" style="width: 33px;height: 33px;"><i class="fas fa-trash text-white"></i></button></td>
                                </tr>`);
					$(tbody).append(p)
					p.find("button").click(function() {
						$.ajax({
							type: "DELETE",
							url: "/admin/creator/Account/customer",
							data: { accountId: i.accountId },
							success: function() {
								$.notify("Xóa tài khoản thành công!", "success", 9999);
								loadCustomerAccount(pageNumber);
							},
							error: function() {
								$.notify("Xóa tài khoản thất bại!", "error", 9999);
							}
						});

					});
				});
				let pagination = $('#customer-pg');
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
					firstPage.children('button').click(function() { loadCustomerAccount(0) });
				}

				if (page.last) {
					lastPage.attr('class', 'page-item disabled');
				}
				else {
					lastPage.attr('class', 'page-item');
					lastPage.children('button').click(function() { loadCustomerAccount(page.totalPages - 1) });
				}
				if (!page.empty) {
					let count = 0;
					firstPage.after(`<li class="page-item active"><a class="page-link">${page.number + 1}</a></li>`);
					for (let i = 1; (i < 3 || (page.totalPages < i + page.number + 1 && page.totalPages + i - page.number - 1 < 5)) && (page.number + 1 - i) > 0; i++) {
						count++;
						let newElement = $(`<li class="page-item"><button class="page-link">${page.number + 1 - i}</button></li>`);
						firstPage.after(newElement);
						newElement.click(function() { loadCustomerAccount(page.number - i) });
					}
					for (let i = 1; count < 4 && (page.number + i) < page.totalPages; i++) {
						count++;
						let newElement = $(`<li class="page-item"><button class="page-link">${page.number + 1 + i}</button></li>`);
						lastPage.before(newElement);
						newElement.click(function() { loadCustomerAccount(page.number + i) });
					}
				}
				$('#customer-dt-info').html(`Showing ${page.pageable.offset + 1} to ${page.pageable.offset + page.numberOfElements} of ${page.totalElements}`);
			},
			error: function() {
				$.notify("Tải thông tin thất bại!", "danger", 9999);
			}
		});
	}
	loadAdminAccount()
	loadCustomerAccount();
	
	$("#admin-page-size, #admin-type-op, #admin-sort-op").change(function() {
		loadAdminAccount()
	});
	$("#admin-search-value").on("search", function() {
		loadAdminAccount()
	})
	
	$("#customer-page-size, #customer-type-op, #customer-sort-op").change(function() {
		loadCustomerAccount();
	});
	$("#customer-search-value").on("search", function() {
		loadCustomerAccount();
	})
	
});