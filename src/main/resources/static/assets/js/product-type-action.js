var x;
import shortid from "https://cdn.skypack.dev/shortid@2.2.16";
$(document).ready(function() {
	$("#type-table tr td a:first-child").click(function() {
		x = $(this).parent().parent().children("td[product-category-id]").html();
	});
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
		// File details
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
			const options = json.map(x => `<option value=${JSON.stringify(x)}>${x.typeName}</option>`);
			x.append(options);
			x.children(":first").attr("selected");
		});
	}
	LoadProductType();

	$("#addProductForm").submit(function(event) {
		event.preventDefault();
		var formData = {
			'productName': $('#productName').val(),
			'productType': JSON.parse($('#productType').val()),
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
			success: function(result) {
				$.notify("Thêm sản phẩm thành công!", "success");
			},
			error: function() {
				$.notify("Thêm sản phẩm thất bại!", "danger");
			}
		});
	});

	const LoadProductCatalog = () => {
		$.getJSON('/admin/product-list', function(json) {
			var pCatalogList = json.content;
			$("#productCatalogsTable tbody").html('');
			pCatalogList.forEach((i) => {
				$("#productCatalogsTable tbody").append(
					`<tr data-info=${JSON.stringify(i)}>
                        <td>${i.productName}</td>
                        <td>${i.productType.typeName}</td>
                        <td>${i.origin}</td>
                        <td>${i.brand}</td>
                        <td>${i.releaseDate}</td>
                        <td>${i.purchaseCount}</td>
                        <td>
                          <button
                            class="btn btn-primary btn-sm"
                            style="height: 33px"
                            data-bs-target="#show-type"
                            data-bs-toggle="modal">
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
                      </tr>`
				)
			});
		});
	};

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

	$(".picker").colorPick({
		initialColor: "Black",
		palette: [
			"Black",
			"BurlyWood",
			"CadetBlue",
			"DarkSlateGray",
			"DimGrey",
			"Gold",
			"Indigo",
			"Navy",
			"Violet",
			"Yellow",
			"YellowGreen",
			"Red",
			"Orange",
			"Khaki",
			"Pink",
			"SlateGray",
			"White",
		],
	});
});