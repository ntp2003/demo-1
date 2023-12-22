<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Account</title>
</head>
<body>
	<div class="container-fluid">
             <h3 class="text-dark mb-4">Account Management</h3>
                    <div class="card shadow">
                        <div class="card-header py-3">
                            <p class="fw-bold text-primary m-0">Admin Account Management</p>
                        </div>
                        <div class="card-body">
                            <div class="row d-flex justify-content-between gap-2">
                                <div class="col text-nowrap d-flex justify-content-start align-items-center">
                                    <div class="ms-2"><label class="form-label" style="margin: 0px;">Show&nbsp; </label><select class="form-select-sm d-inline-block form-select" style="width: 100px;">
                                            <option value="10" selected="">10</option>
                                            <option value="25">25</option>
                                            <option value="50">50</option>
                                            <option value="100">100</option>
                                        </select></div>
                                    <div></div>
                                </div>
                                <div class="col-md-6 col-xl-7 d-flex justify-content-end flex-wrap gap-2">
                                    <div class="d-flex align-items-center" style="padding: 0px 8px;"><select class="form-select-sm d-inline-block form-select">
                                            <option value="" selected="">Name</option>
                                            <option value="">Phone Number</option>
                                            <option value="">Email</option>
                                            <option value="">CCCD</option>
                                            <option value="">User Name</option>
                                        </select></div>
                                    <div class="d-flex align-items-center" style="padding: 0px 8px;"><select class="form-select-sm d-inline-block form-select">
                                            <option value="">ASC</option>
                                            <option value="">DESC</option>
                                        </select></div>
                                    <div class="d-flex align-items-center" style="padding: 0px 8px;"><input class="form-control-sm form-control" type="search" aria-controls="dataTable" placeholder="Search" style="max-height: 31px;"></div>
                                </div>
                            </div>
                            <div class="table-responsive table mt-2" id="producttable" role="grid" aria-describedby="dataTable_info">
                                <table class="table my-0 align-middle table-hover" id="dataTable">
                                    <thead>
                                        <tr>
                                            <th>User Name</th>
                                            <th>Password</th>
                                            <th>First Name</th>
                                            <th>Last Name</th>
                                            <th>Phone Numer</th>
                                            <th>CCCD</th>
                                            <th>Email</th>
                                            <th>Creator</th>
                                            <th></th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <tr>
                                            <td>admin</td>
                                            <td><input class="border-0 form-control-sm" type="password" disabled="" value="jkdjakdjkakdsa;" style="background: transparent;"></td>
                                            <td>Nguyen</td>
                                            <td>Phat</td>
                                            <td>0777166027</td>
                                            <td>89278177109903218</td>
                                            <td>2113918309189831983091901</td>
                                            <td style="text-align: center;">1</td>
                                            <td></td>
                                        </tr>
                                        <tr>
                                            <td>admin</td>
                                            <td><input class="border-0 form-control-sm" type="text" value="dajalksjkdjalkda" disabled="" style="background: transparent;"></td>
                                            <td>Nguyen</td>
                                            <td>Phat</td>
                                            <td>0777166027</td>
                                            <td>89278177109903218</td>
                                            <td>2113918309189831983091901</td>
                                            <td style="text-align: center;">1</td>
                                            <td><button class="btn btn-danger btn-sm btn-circle ms-1" type="button" style="width: 33px;height: 33px;"><i class="fas fa-trash text-white"></i></button></td>
                                        </tr>
                                    </tbody>
                                </table>
                            </div>
                            <div class="row">
                                <div class="col-md-6 col-xl-4 col-xxl-2 d-flex" style="margin-top: 4px;">
                                    <p id="dataTable_info" class="dataTables_info" role="status" aria-live="polite">Showing 1 to 10 of 27</p>
                                </div>
                                <div class="col">
                                    <nav class="d-lg-flex justify-content-lg-end">
                                        <ul class="pagination">
                                            <li class="page-item disabled"><a class="page-link" aria-label="Previous" href="#"><span aria-hidden="true">«</span></a></li>
                                            <li class="page-item active"><a class="page-link" href="#">1</a></li>
                                            <li class="page-item"><a class="page-link" href="#">2</a></li>
                                            <li class="page-item"><a class="page-link" href="#">2</a></li>
                                            <li class="page-item"><a class="page-link" href="#">2</a></li>
                                            <li class="page-item"><a class="page-link" href="#">3</a></li>
                                            <li class="page-item"><a class="page-link" aria-label="Next" href="#"><span aria-hidden="true">»</span></a></li>
                                        </ul>
                                    </nav>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="card shadow mt-4">
                        <div class="card-header py-3">
                            <p class="fw-bold text-primary m-0">Customer Account Management</p>
                        </div>
                        <div class="card-body">
                            <div class="row d-flex justify-content-between gap-2">
                                <div class="col text-nowrap d-flex justify-content-start align-items-center align-items-xl-center column-gap-3">
                                    <div><label class="form-label" style="margin: 0px;">Show&nbsp; </label><select class="form-select-sm d-inline-block form-select" style="width: 100px;">
                                            <option value="10" selected="">10</option>
                                            <option value="25">25</option>
                                            <option value="50">50</option>
                                            <option value="100">100</option>
                                        </select></div>
                                </div>
                                <div class="col-md-6 col-xl-7 d-flex justify-content-end flex-wrap gap-2">
                                    <div class="d-flex align-items-center" style="padding: 0px 8px;"><select class="form-select-sm d-inline-block form-select">
                                            <option value="" selected="">Email</option>
                                            <option value="">Name</option>
                                            <option value="">Phone number</option>
                                        </select></div>
                                    <div class="d-flex align-items-center" style="padding: 0px 8px;"><select class="form-select-sm d-inline-block form-select">
                                            <option value="" selected="">ASC</option>
                                            <option value="">DESC</option>
                                        </select></div>
                                    <div class="d-flex align-items-center align-items-xl-center" style="padding: 0px 8px;"><input class="form-control-sm form-control" type="search" aria-controls="dataTable" placeholder="Search" style="max-height: 31px;"></div>
                                </div>
                            </div>
                            <div class="table-responsive table mt-2" id="producttable-1" role="grid" aria-describedby="dataTable_info">
                                <table class="table my-0 align-middle table-hover" id="dataTable">
                                    <thead>
                                        <tr>
                                            <th>Account ID</th>
                                            <th>Email</th>
                                            <th>Password</th>
                                            <th>First Name</th>
                                            <th>Last Name</th>
                                            <th>Phone Numer</th>
                                            <th></th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <tr>
                                            <td style="text-align: center;">1</td>
                                            <td class="text-break">idajidjslkadlkajjlkdjalkjdlkajdlkajlkk</td>
                                            <td>nkznlczklcxlkzczczc</td>
                                            <td>Phat</td>
                                            <td>Nguyen Tan</td>
                                            <td>0777166027</td>
                                            <td class="py-1"><button class="btn btn-danger btn-sm btn-circle ms-1" type="button" style="width: 33px;height: 33px;"><i class="fas fa-trash text-white"></i></button></td>
                                        </tr>
                                    </tbody>
                                </table>
                            </div>
                            <div class="row">
                                <div class="col-md-6 col-xl-4 col-xxl-2 d-flex" style="margin-top: 4px;">
                                    <p id="dataTable_info-1" class="dataTables_info" role="status" aria-live="polite">Showing 1 to 10 of 27</p>
                                </div>
                                <div class="col">
                                    <nav class="d-lg-flex justify-content-lg-end">
                                        <ul class="pagination">
                                            <li class="page-item disabled"><a class="page-link" aria-label="Previous" href="#"><span aria-hidden="true">«</span></a></li>
                                            <li class="page-item active"><a class="page-link" href="#">1</a></li>
                                            <li class="page-item"><a class="page-link" href="#">2</a></li>
                                            <li class="page-item"><a class="page-link" href="#">2</a></li>
                                            <li class="page-item"><a class="page-link" href="#">2</a></li>
                                            <li class="page-item"><a class="page-link" href="#">3</a></li>
                                            <li class="page-item"><a class="page-link" aria-label="Next" href="#"><span aria-hidden="true">»</span></a></li>
                                        </ul>
                                    </nav>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
       <script src="/assets/js/notify.js"></script>
</body>
</html>