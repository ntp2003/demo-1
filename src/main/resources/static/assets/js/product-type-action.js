var x;
import shortid from "https://cdn.skypack.dev/shortid@2.2.16";
$(document).ready(function() {
	$("#show-view, #add-type, #add-images").on("hidden.bs.modal", function() {
		$("#show-type").modal("show");
	});

	let selectedfile = [];

	const filesizes = (bytes, decimals = 2) => {
		if (bytes === 0) return "0 Bytes";
		const k = 1024;
		const dm = decimals < 0 ? 0 : decimals;
		const sizes = ["Bytes", "KB", "MB", "GB", "TB", "PB", "EB", "ZB", "YB"];
		const i = Math.floor(Math.log(bytes) / Math.log(k));
		return parseFloat((bytes / Math.pow(k, i)).toFixed(dm)) + " " + sizes[i];
	};

	const SetFileInfo = (fileInfo) => {
		const fileBoxElement = document.createElement("div");
		fileBoxElement.id = "image-" + fileInfo.id;
		fileBoxElement.classList.add("file-atc-box");
		const fileAttachmentElement = document.createElement("div");
		fileAttachmentElement.classList.add("file-image");
		if (fileInfo.filename.match(/.$/i)) {
			const fileImageElement = document.createElement("img");
			fileImageElement.src = fileInfo.fileimage;
			fileAttachmentElement.appendChild(fileImageElement);
		} else {
			const fileIconElement = document.createElement("i");
			fileIconElement.classList.add("far", "fa-file-alt");
			fileAttachmentElement.appendChild(fileIconElement);
		}

		const fileDetailElement = document.createElement("div");
		fileDetailElement.classList.add("file-detail");

		const fileNameElement = document.createElement("h6");
		fileNameElement.textContent = fileInfo.filename;

		const lineElement = document.createElement("p");

		const contentFileDetailElement = document.createElement("p");

		const fileSizeSpan = document.createElement("span");
		fileSizeSpan.textContent = "Size: " + fileInfo.filesize;

		const modifiedTimeSpan = document.createElement("span");
		modifiedTimeSpan.classList.add("ml-2");
		modifiedTimeSpan.textContent = "Modified Time: " + fileInfo.datetime;

		contentFileDetailElement.appendChild(fileSizeSpan);
		contentFileDetailElement.appendChild(modifiedTimeSpan);

		const fileActionsElement = document.createElement("div");
		fileActionsElement.classList.add("file-actions");

		const deleteButton = document.createElement("button");
		deleteButton.classList.add("file-action-btn");
		deleteButton.textContent = "Delete";
		deleteButton.addEventListener("click", (e) => {
			e.preventDefault();
			DeleteSelectFile(fileInfo.id);
		});

		fileActionsElement.appendChild(deleteButton);
		fileDetailElement.appendChild(fileNameElement);
		fileDetailElement.appendChild(lineElement);
		fileDetailElement.appendChild(contentFileDetailElement);
		fileDetailElement.appendChild(fileActionsElement);

		fileBoxElement.appendChild(fileAttachmentElement);
		fileBoxElement.appendChild(fileDetailElement);

		let uploadForm = document.getElementById("upload-details");
		uploadForm.appendChild(fileBoxElement);
	};

	$("#fileupload").change((e) => {
		const images = Array.from(e.target.files);
		images.forEach((image, i) => {
			const fileInfo = {
				id: shortid.generate(),
				filename: e.target.files[i].name,
				filetype: image.type,
				fileimage: URL.createObjectURL(image),
				datetime: image.lastModifiedDate.toLocaleString("en-IN"),
				filesize: filesizes(image.size),
			};
			selectedfile.push(fileInfo);
			SetFileInfo(fileInfo);
		});
		$("#fileupload").val(null);
	});

	const DeleteSelectFile = (id) => {
		if (window.confirm("Are you sure you want to delete this Image?")) {
			const result = selectedfile.filter((data) => data.id !== id);
			selectedfile = result;
			document.getElementById("image-" + id).remove();
		}
	};

	const LoadProductType = () => {
		$.getJSON('/admin/product-type', function(json) {
			var x = $('#productType');
			const options = json.map(i => `<option value='${JSON.stringify(i)}'>${i.typeName}</option>`);
			x.append(options);
			x.children(":first").attr("selected");
		});
	}
	LoadProductType();

	$("#addProductForm").submit(function(event) {
		event.preventDefault();
		let formData = {
			'productName': $('#productName').val(),
			'productType': JSON.parse($('#productType option:selected').val()),
			'origin': $('#origin').val(),
			'brand': $('#brand').val(),
			'releaseDate': $('#releaseDate').val(),
			'description': $('#description').val()
		};

		$.ajax({
			type: "POST",
			contentType: "application/json; charset=utf-8",
			url: "/admin/add-product",
			data: JSON.stringify(formData),
			cache: false,
			success: function() {
				$.notify("Thêm sản phẩm thành công!", "success");
				document.getElementById('addProductForm').reset();
				$('#add-product-modal').modal('hide');
				LoadProductCatalog();
			},
			error: function() {
				$.notify("Thêm sản phẩm thất bại!", "danger");
			}
		});
	});

	$("#add-type-form").submit(function(event) {
		event.preventDefault();
		let formData = {
			'productId': $("#show-type").data('info').productId,
			'color': $(this).find('.picker').css('color'),
			'price': $('#price-input').val()
		};

		$.ajax({
			type: "POST",
			contentType: "application/json; charset=utf-8",
			url: "/admin/add-product-category",
			data: JSON.stringify(formData),
			cache: false,
			success: function() {
				$.notify("Thêm loại sản phẩm mới thành công!", "success");
				document.getElementById('add-type-form').reset();
				$('#add-type').modal('hide');
			},
			error: function() {
				$.notify("Thêm loại sản phẩm mới thất bại!", "danger");
			}
		});
	});

	$('#upload-image-form').submit(function(event) {
		event.preventDefault();
		var formData = {
			productCategoryId: $("#add-images").data('info').productCategoryId,
			dataURLs: selectedfile.map(i => i.fileimage)
		};

		let p = new Promise(function(resolve, reject) {
			try {
				formData.dataURLs.forEach((data, i) => {

					fetch(data).then(r => r.blob()).then(b => {
						const reader = new FileReader();
						reader.onloadend = () => {
							const base64 = reader.result;
							$.ajax({
								type: "POST",
								url: "/admin/upload-images",
								data: {
									dataURL : base64,
									productCategoryId : formData.productCategoryId
								},
								success: function() {
									$.notify("Tải ảnh lên thành công!", "success");
								},
								error: function() {
									$.notify("Tải ảnh lên thất bại!", "danger");
								}
							});
						};
						reader.readAsDataURL(b);
					});

				});
			}
			catch (e) {
				reject(e);
			}

			resolve();
		});
		p.then(function() {
			selectedfile = [];
			$('#upload-details').html('');
			$('#add-images').modal('hide');
		}).catch(e => {
			console.log(e);
		});;
	});

	function DeleteProductCatalog(productId, page = 0) {
		$.ajax({
			type: "DELETE",
			url: "/admin/delete-product",
			cache: false,
			data: { productId: productId },
			success: function() {
				$.notify("Xóa sản phẩm thành công!", "success");
				LoadProductCatalog(page, $('#page-size option:selected').val(), $('#sort-option').attr('value'))
			},
			error: function() {
				$.notify("Xóa sản phẩm thất bại!", "danger");
			}
		});
	};

	$("#delete-p-categories").click(function() {
		$("#show-type").find('input:checked.form-check-input').each(function() {
			let tr = $(this).parent().parent();
			let productCategoryId = tr.data('info').productCategoryId;
			$.ajax({
				type: "DELETE",
				url: "/admin/delete-product-category",
				cache: false,
				data: { productCategoryId: productCategoryId },
				success: function() {
					$.notify(`Xóa loại sản phẩm ${productCategoryId} thành công!`, "success");
					tr.remove();
				},
				error: function() {
					$.notify(`Xóa loại sản phẩm ${productCategoryId} thất bại!`, "danger");
				}
			})
		});
	});
	$("#show-type").on('show.bs.modal', function() {
		$(this).find('.modal-header h5').html($(this).data('info').productName);
		$('#product-id-lbl').html('Mã sản phẩm : ' + $(this).data('info').productId);
		$('#product-brand-lbl').html('Thương hiệu : ' + $(this).data('info').brand);
		$('#product-re-date-lbl').html('Ngày phát hành : ' + $(this).data('info').releaseDate);
		$.getJSON(`/admin/product-category-list?productId=${$(this).data('info').productId}`, function(json) {
			var pCategoryList = json;
			$("#product-category-dt tbody").html('');
			pCategoryList.forEach((i) => {
				let p = $(`<tr data-info='${JSON.stringify(i)}'>
						<td>
							<input class="form-check-input" type="checkbox">
						</td>
                        <td product-category-id="">${i.productCategoryId}</td>
						<td>
							<div style="height: 30px; width: 50px; background: ${i.color}; margin: 0px auto;"></div>
						</td>
						<td>${i.price}</td>
						<td class="d-flex justify-content-around gap-3">
						<a class="btn btn-info image-view" role="button"
							href="#" style="color: rgb(255, 255, 255)"
							data-bs-target="#show-view" data-bs-toggle="modal">View</a>
							<a class="btn btn-success add-images" role="button"
							style="color: rgb(255, 255, 255); background: #1eb53a; border-style: none;">Add</a>
						</td>
                      </tr>`);
				$("#product-category-dt tbody").append(p);
				p.find('.add-images').click(function() {
					$("#add-images").data('info', p.data('info'));
					$("#show-type").modal('hide');
					$("#add-images").modal("show");
				});
			});
		});
	});


	function LoadProductCatalog(page = 0, size = 10, sort = 'productName,asc') {
		$.getJSON(`/admin/product-list?page=${page}&size=${size}&sort=${sort}`, function(json) {
			var pCatalogList = json.content;
			$("#productCatalogsTable tbody").html('');
			pCatalogList.forEach((i) => {
				let p = $(`<tr data-info='${JSON.stringify(i)}'>
                        <td>${i.productName}</td>
                        <td>${i.productType.typeName}</td>
                        <td>${i.origin}</td>
                        <td>${i.brand}</td>
                        <td>${i.releaseDate}</td>
                        <td>${i.purchaseCount}</td>
                        <td>
                          <button
                          	id="edit-p"
                            class="btn btn-primary btn-sm"
                            style="height: 33px">
                            Edit
                          </button>
                        </td>
                        <td style="width: 73.1875px">
                          <button
                            class="btn btn-danger btn-sm"
                            style="height: 33px; width: 73.1875px">
                            Delete
                          </button>
                        </td>
                      </tr>`);
				$("#productCatalogsTable tbody").append(p)
				p.children(':last-child').children('button').click(function() { DeleteProductCatalog(i.productId, json.number) });
				p.children().children('#edit-p').click(function() {
					$("#show-type").data('info', p.data('info'))
					$("#show-type").modal("show");
				});
			});
			let pagination = $('#pagination-box .pagination');
			pagination.html('');
			pagination.append(`<li class=""><button class="page-link" aria-label="Previous"><span aria-hidden="true">«</span></button></li>
							<li class=""><button class="page-link" aria-label="Next"><span aria-hidden="true">»</span></button></li>`)
			let firstPage = pagination.children(':first-child');
			let lastPage = pagination.children(':last-child');
			if (json.first) {
				firstPage.attr('class', 'page-item disabled');
			}
			else {
				firstPage.attr('class', 'page-item');
				firstPage.children('button').click(function() { LoadProductCatalog(0, $('#page-size option:selected').val(), $('#sort-option').attr('value')) });
			}

			if (json.last) {
				lastPage.attr('class', 'page-item disabled');
			}
			else {
				lastPage.attr('class', 'page-item');
				lastPage.children('button').click(function() { LoadProductCatalog(json.totalPages - 1, $('#page-size option:selected').val(), $('#sort-option').attr('value')) });
			}
			if (!json.empty) {
				let count = 0;
				firstPage.after(`<li class="page-item active"><a class="page-link">${json.number + 1}</a></li>`);
				for (let i = 1; (i < 3 || (json.totalPages < i + json.number + 1 && json.totalPages + i - json.number - 1 < 5)) && (json.number + 1 - i) > 0; i++) {
					count++;
					let newElement = $(`<li class="page-item"><button class="page-link">${json.number + 1 - i}</button></li>`);
					firstPage.after(newElement);
					newElement.click(function() { LoadProductCatalog(json.number - i, $('#page-size option:selected').val(), $('#sort-option').attr('value')) });
				}
				for (let i = 1; count < 4 && (json.number + i) < json.totalPages; i++) {
					count++;
					let newElement = $(`<li class="page-item"><button class="page-link">${json.number + 1 + i}</button></li>`);
					lastPage.before(newElement);
					newElement.click(function() { LoadProductCatalog(json.number + i, $('#page-size option:selected').val(), $('#sort-option').attr('value')) });
				}
			}
			$('#p-catalog-dt-info').html(`Showing ${json.pageable.offset + 1} to ${json.pageable.offset + json.numberOfElements} of ${json.totalElements}`);
		});
	};

	$('#sort-option .dropdown-item').click(function() {
		$(this).parent().attr('value', $(this).attr('value'));
		LoadProductCatalog(0, $('#page-size option:selected').val(), $(this).attr('value'));
	});

	$('#page-size').change(function() {
		LoadProductCatalog(0, $(this).val(), $('#sort-option').attr('value'));
	});

	LoadProductCatalog();



	$("[id^=carousel-selector-]").click(function() {
		var id_selector = $(this).attr("id");
		var id = parseInt(id_selector.substr(id_selector.lastIndexOf("-") + 1));
		$("#myCarousel").carousel(id);
	});
	if ($(window).width() < 575) {
		$("#carousel-thumbs .row div:nth-child(4)").each(function() {
			var rowBoundary = $(this);
			$('<div class="row mx-0">')
				.insertAfter(rowBoundary.parent())
				.append(rowBoundary.nextAll().addBack());
		});
		$("#carousel-thumbs .carousel-item .row:nth-child(even)").each(function() {
			var boundary = $(this);
			$('<div class="carousel-item">')
				.insertAfter(boundary.parent())
				.append(boundary.nextAll().addBack());
		});
	}
	if ($("#carousel-thumbs .carousel-item").length < 2) {
		$("#carousel-thumbs [class^=carousel-control-]").remove();
		$(".machine-carousel-container #carousel-thumbs").css("padding", "0 5px");
	}
	$("#myCarousel").on("slide.bs.carousel", function(e) {
		var id = parseInt($(e.relatedTarget).attr("data-slide-number"));
		$("[id^=carousel-selector-]").removeClass("selected");
		$("[id=carousel-selector-" + id + "]").addClass("selected");
	});
	$("#myCarousel .carousel-item img").on("click", function(e) {
		var src = $(e.target).attr("data-remote");
		if (src) $(this).ekkoLightbox();
	});

	$(".picker").colorPick({ 'allowCustomColor': true });
});