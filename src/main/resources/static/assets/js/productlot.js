$(document).ready(function() {
	$("#add-category").click(function(){
			let newRow = $(`<tr>
								<td><input
									class="focus-ring form-control-sm w-75 form-control"
									type="search" style="margin: 0px auto;"></td>
								<td class="text-break col-md-4">
								<td></td>
								<td></td>
								<td></td>
								<td><a class="btn btn-danger btn-circle ms-1"
									role="button"><i class="fas fa-trash text-white"></i></a></td>
						</tr>`);
			$("#category-table-add tbody").append(newRow);
		}
	)
});