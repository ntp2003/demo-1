$(document).ready(function() {
	const formatter = new Intl.NumberFormat('en-US', {
		style: 'currency',
		currency: 'USD'
	});

	let address_map;
	$.getJSON("https://raw.githubusercontent.com/kenzouno1/DiaGioiHanhChinhVN/master/data.json", function(json) {
		address_map = json;
	})

	function getColorName(rgb) {
		let rel;
		$.ajaxSetup({ async: false });
		$.getJSON(`https://www.thecolorapi.com/id?rgb=${rgb}`, function(info) {
			rel = info.name.value;
		});
		$.ajaxSetup({ async: true });
		return rel;
	}
	
	function loadOrderStatusStatistic(){
		$.getJSON(`/admin/Order/status-statistic`, function(info) {
			console.log(info);
			$("span[data-count]").each(function(){
				let flag = 0;
				info.forEach(i => {
					console.log(i.status)
					console.log($(this).data("count"))
					if(i.status == $(this).data("count")){
						$(this).html(i.count);
						flag = 1;
					}
				});
				if(flag === 0) $(this).html(0);
			})
		});
	}
	
	loadOrderStatusStatistic();
	
	function padTo2Digits(num) {
		return num.toString().padStart(2, '0');
	}

	function formatDate(data) {
		date = new Date(data);
		return (
			[
				date.getFullYear(),
				padTo2Digits(date.getMonth() + 1),
				padTo2Digits(date.getDate()),
			].join('-') +
			' ' +
			[
				padTo2Digits(date.getHours()),
				padTo2Digits(date.getMinutes())
			].join(':')
		);
	}

	function getColorForStatus(status) {
		switch (status) {
			case 'Not confirmed': return '#FFA500';
			case 'Awaiting delivery': return '#FFD700';
			case 'Cancelled': return '#FF4500';
			case 'In progress': return '#0000FF';
			case 'Completed': return '#008000';
			case 'Undeliverable': return '#FF69B4';
			default: return 'black';
		}
	}
	$.ajaxSetup({ async: false });
	$.getJSON("/admin/Order/status", function(statuss) {
		statuss.forEach(s => {
			$("#statusFilter").append(`<option value="${s}">${s}</option>`)
		})
	});
	$.ajaxSetup({ async: true });

	function getOrderRow(order) {
		let row = $(`<tr>
					<td>${order.invoiceId}</td>
					<td>${order.accountId}</td>
					<td>${formatDate(order.createdTime)}</td>
					<td>${order.completedTime != null ? formatDate(order.completedTime) : "Not complete"}</td>
					<td>${formatter.format(order.total)}</td>
					<td>${order.payment}</td>
					<td><button class="btn btn-primary btn-sm show-modal" type="button">Order details</button></td>
					<td><select
							class="form-select-sm form-control statusSelect statusColor">
							
							</select></td>
							<td><button class="btn btn-primary btn-sm btn-update"
						style="height: 33px;">Update</button></td>
					</tr>`);
		let select = row.find("select");
		select.on("change", function() {
			select.css('color', getColorForStatus(select.val()));
			if (select.val() == order.status) {
				row.find(".btn-update").css("display", "none");
			}
			else {
				row.find(".btn-update").css("display", "");
			}
		})
		select.append(`<option value='${order.status}'style='color: ${getColorForStatus(order.status)};' selected>${order.status}</option>`)
		order.nextPossibleStatus.forEach(i => {
			select.append(`<option value='${i}' style='color: ${getColorForStatus(i)};'>${i}</option>`)
		});

		row.find(".btn-update").click(function() {
			$.ajax({
				type: "PUT",
				url: "/admin/Order/update",
				data: { purchaseHistoryId: order.purchaseHistoryId, updateStatus: select.val() },
				cache: false,
				success: function(updatedOrder) {
					row.replaceWith(getOrderRow(updatedOrder));
					$.notify("Update status success", "success", 9999);
					loadOrderStatusStatistic()
				},
				error: function() {
					$.notify("Update status failed!", "danger", 9999);
				}
			});
		});

		row.find("button.show-modal").click(function() {
			$.LoadingOverlay("show");
			$.getJSON(`/admin/Order/detail?purchaseHistoryId=${order.purchaseHistoryId}`, function(detail) {
				let address = JSON.parse(detail.address)
				$("#invoice-id").html(`Invoice ID: ${detail.invoiceId}`)
				$("#payment-method").html(`Payment method: ${detail.payment}`)
				$("#account-id").html(`Account ID: ${detail.accountId}`)
				$("#customer-name").html(`Customer name: ${detail.customerName}`)
				$("#address-detail").html(`Address detail: ${address.detail}`)
				$("#phone-number").html(`Phone Number: ${detail.phoneNumber}`)
				$("#shipping-fee").html(`Shipping fee: ${formatter.format(detail.shippingFee)}`)
				$("#order-total").html(`Total : ${formatter.format(detail.total)}`)
				$("#orderDetails").modal("show")

				address_map.forEach(city => {
					if (city.Id == address.city) {
						city.Districts.forEach(dis => {
							if (dis.Id == address.district) {
								dis.Wards.forEach(w => {
									if (w.Id == address.ward) {
										$("#address").html(`Address: ${city.Name}, ${dis.Name}, ${w.Name}`);
									}
								})
							}
						})
					}
				});

				let tbody = $("#p-in-order tbody");
				tbody.html('');
				detail.itemDetails.forEach(item => {
					let newRow = $(`<tr>
									<td class="text-center">${item.productId}</td>
									<td class="text-break d-flex flex-column"
									style="font-size: 12px;"><label
									class="form-label">product name: ${item.productName}</label><label
										class="form-label">color: ${getColorName(item.color)}</label><label
										class="form-label">size: ${item.sizeName}</label></td>
										<td class="text-center">${item.quantity}</td>
										<td style="text-align: center;">${formatter.format(item.price)}</td>
										<td style="text-align: center;">${formatter.format(item.discount)}</td>
										<td style="text-align: center;">${formatter.format((item.price - item.discount)*item.quantity)}</td>
									</tr>`)
					tbody.append(newRow);
				});
			});
			$.LoadingOverlay("hide");
		});

		select.change();
		return row;
	}

	function loadOrderPage(page = 0) {
		let filter = {
			fromDay: new Date($("#fromDay").val()),
			toDay: new Date($("#toDay").val()),
			status: $("#statusFilter").val()
		};

		let tbody = $("#orderpage-tb tbody");
		$(tbody).html('');

		$.ajax({
			type: "POST",
			contentType: "application/json; charset=utf-8",
			url: `/admin/Order?page=${page}&size=${$("#page-size").val()}`,
			data: JSON.stringify(filter),
			cache: false,
			success: function(page) {
				let orderList = page.content;

				orderList.forEach((i) => {
					let o = getOrderRow(i);
					$(tbody).append(o)
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
					firstPage.children('button').click(function() { loadOrderPage(0) });
				}

				if (page.last) {
					lastPage.attr('class', 'page-item disabled');
				}
				else {
					lastPage.attr('class', 'page-item');
					lastPage.children('button').click(function() { loadOrderPage(page.totalPages - 1) });
				}
				if (!page.empty) {
					let count = 0;
					firstPage.after(`<li class="page-item active"><a class="page-link">${page.number + 1}</a></li>`);
					for (let i = 1; (i < 3 || (page.totalPages < i + page.number + 1 && page.totalPages + i - page.number - 1 < 5)) && (page.number + 1 - i) > 0; i++) {
						count++;
						let newElement = $(`<li class="page-item"><button class="page-link">${page.number + 1 - i}</button></li>`);
						firstPage.after(newElement);
						newElement.click(function() { loadOrderPage(page.number - i) });
					}
					for (let i = 1; count < 4 && (page.number + i) < page.totalPages; i++) {
						count++;
						let newElement = $(`<li class="page-item"><button class="page-link">${page.number + 1 + i}</button></li>`);
						lastPage.before(newElement);
						newElement.click(function() { loadOrderPage(page.number + i) });
					}
				}
				$('#dataTable-info').html(`Showing ${page.pageable.offset + 1} to ${page.pageable.offset + page.numberOfElements} of ${page.totalElements}`);
			},
			error: function() {
				$.notify("Load order failed!", "danger", 9999);
			}
		});
	};
	loadOrderPage();
	$("#fromDay, #toDay, #statusFilter, #page-size").change(function() {
		loadOrderPage();
	});
})