<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<%@ include file="/common/hrefsheet.jsp"%>
<link rel="stylesheet" href="assets/css/main.css">
<link rel="stylesheet" href="assets/css/filterTemplate.css"><link />
<link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css" rel="stylesheet"/>


</head>
<body style="background-color: rgb(231, 238, 243);">
	<div class="filter-container"
		style="display: inline-block; flex-wrap: wrap;margin-top:100px;border: 2px solid #D6EAF8;  border-radius: 5px;">

	</div>

	<div class="container" style="margin-top:100px;">
		<div class="row">   
			<div class="orderby" style="display: flex; justify-content: center;align-items:center;gap:20px">

		<div class="col-md-6 text-center">
			<div class="input-group">
				<input type="text" class="form-control" value="" /> <span
					class="input-group-btn">
					<button class="btn btn-primary" type="button">
						<i class="fa fa-search"></i>
					</button>
				</span>
			</div>
		</div>


			<div class="form-inline">
				<select class="mr-2 form-control">
					<option value="" hidden selected>Sắp xếp theo</option>
					<option value="hot">Hot</option>
					<option value="new">Mới nhất</option>
					<option value="lowtohigh">Giá từ thấp đến cao</option>
					<option value="hightolow">Giá từ cao đến thấp</option>
					<option value="az">Theo tên A-Z </option>
					<option value="za">Theo tên Z-A </option>
				</select>
			</div>
	</div>
			<div class="row d-flex justify-content-between" style="margin-top:50px;margin-left: 20px ">
				<div
					class="col-md-6 col-xl-5 text-nowrap d-flex justify-content-start align-items-xl-center column-gap-3">
					<div>
						<label class="form-label" style="margin: 0px">Show&nbsp;
						</label><select class="form-select-sm d-inline-block form-select"
							id="page-size" style="width: 100px">
							<option value="10" selected="">10</option>
							<option value="25">25</option>
							<option value="50">50</option>
							<option value="100">100</option>
						</select>
					</div>
				</div>
		</div>
	<div class="container" style="min-height: 70vh">
	
			<div class="row" id="row-all">
			</div>
		</div>  
		</div>
	</div>
	
	<div class="push"></div>

	<script src="https://code.jquery.com/jquery-1.10.2.min.js"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@4.1.1/dist/js/bootstrap.bundle.min.js"></script>
	<script type="text/javascript"></script>
	

	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.20.0/jquery.validate.min.js"
		integrity="sha512-WMEKGZ7L5LWgaPeJtw9MBM4i5w5OSBlSjTjCtSnvFJGSVD26gE5+Td12qN5pvWXhuWaWcVwF++F7aqu9cvqP0A=="
		crossorigin="anonymous" referrerpolicy="no-referrer"></script> 

	<script src="/assets/js/colorPick.js"></script>
	<script src="/assets/js/numberinput.js"></script>
	<script src="/assets/js/product-load.js" type="module"></script>
	<script src="/assets/js/theme.js"></script>

</body>
</html>