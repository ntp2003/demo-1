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
                    <div id="admin" class="card shadow">
                        <div class="card-header py-3">
                            <p class="fw-bold text-primary m-0">Admin Account Management</p>
                        </div>
                        <div class="card-body">
                            <div class="row d-flex justify-content-between gap-2">
                                <div class="col text-nowrap d-flex justify-content-start align-items-center">
                                    <div class="ms-2"><label class="form-label" style="margin: 0px;">Show&nbsp; </label>
                                    <select id="admin-page-size" class="form-select-sm d-inline-block form-select" style="width: 100px;">
                                            <option value="10" selected="">10</option>
                                            <option value="25">25</option>
                                            <option value="50">50</option>
                                            <option value="100">100</option>
                                        </select></div>
                                    <div></div>
                                </div>
                                <div class="col-md-6 col-xl-7 d-flex justify-content-end flex-wrap gap-2">
                                    <div class="d-flex align-items-center" style="padding: 0px 8px;">
                                    <select id="admin-type-op" class="form-select-sm d-inline-block form-select">
                                            <option sort="fullName" value="0" selected="">Name</option>
                                            <option sort="phoneNumber" value="1">Phone Number</option>
                                            <option sort="email" value="2">Email</option>
                                            <option sort="cccd" value="3">CCCD</option>
                                            <option sort="username" value="4">User Name</option>
                                        </select></div>
                                    <div class="d-flex align-items-center" style="padding: 0px 8px;"><select id="admin-sort-op" class="form-select-sm d-inline-block form-select">
                                            <option value=",asc">ASC</option>
                                            <option value=",desc">DESC</option>
                                        </select></div>
                                    <div class="d-flex align-items-center" style="padding: 0px 8px;">
                                    <input id="admin-search-value" class="form-control-sm form-control" type="search" aria-controls="dataTable" placeholder="Search" style="max-height: 31px;">
                                    </div>
                                </div>
                            </div>
                            <div class="table-responsive table mt-2" id="producttable" role="grid" aria-describedby="dataTable_info">
                                <table class="table my-0 align-middle table-hover" id="admin-tb">
                                    <thead>
                                        <tr>
                                            <th>User Name</th>
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
                                    </tbody>
                                </table>
                            </div>
                            <div class="row">
                                <div class="col-md-6 col-xl-4 col-xxl-2 d-flex" style="margin-top: 4px;">
                                    <p id="admin-dt-info" class="dataTables_info" role="status" aria-live="polite"></p>
                                </div>
                                <div class="col">
                                    <nav class="d-lg-flex justify-content-lg-end">
                                        <ul id="admin-pg" class="pagination">
                                        </ul>
                                    </nav>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div id="customer" class="card shadow mt-4">
                        <div class="card-header py-3">
                            <p class="fw-bold text-primary m-0">Customer Account Management</p>
                        </div>
                        <div class="card-body">
                            <div class="row d-flex justify-content-between gap-2">
                                <div class="col text-nowrap d-flex justify-content-start align-items-center align-items-xl-center column-gap-3">
                                    <div><label class="form-label" style="margin: 0px;">Show&nbsp; </label>
                                    <select id="customer-page-size" class="form-select-sm d-inline-block form-select" style="width: 100px;">
                                            <option value="10" selected="">10</option>
                                            <option value="25">25</option>
                                            <option value="50">50</option>
                                            <option value="100">100</option>
                                        </select></div>
                                </div>
                                <div class="col-md-6 col-xl-7 d-flex justify-content-end flex-wrap gap-2">
                                    <div class="d-flex align-items-center" style="padding: 0px 8px;">
                                    <select id="customer-type-op" class="form-select-sm d-inline-block form-select">
                                            <option sort="email" value="2" selected="">Email</option>
                                            <option sort="customerName" value="0">Name</option>
                                            <option sort="phoneNumber" value="1">Phone number</option>
                                        </select></div>
                                    <div id="customer-sort-op" class="d-flex align-items-center" style="padding: 0px 8px;"><select class="form-select-sm d-inline-block form-select">
                                            <option value=",asc" selected="">ASC</option>
                                            <option value=",desc">DESC</option>
                                        </select></div>
                                    <div class="d-flex align-items-center align-items-xl-center" style="padding: 0px 8px;">
                                    <input id="customer-search-value" class="form-control-sm form-control" type="search" aria-controls="dataTable" placeholder="Search" style="max-height: 31px;"></div>
                                </div>
                            </div>
                            <div class="table-responsive table mt-2" id="producttable-1" role="grid" aria-describedby="dataTable_info">
                                <table class="table my-0 align-middle table-hover" id="customer-tb">
                                    <thead>
                                        <tr>
                                            <th>Account ID</th>
                                            <th>Email</th>
                                            <th>First Name</th>
                                            <th>Last Name</th>
                                            <th>Phone Numer</th>
                                            <th></th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        
                                    </tbody>
                                </table>
                            </div>
                            <div class="row">
                                <div class="col-md-6 col-xl-4 col-xxl-2 d-flex" style="margin-top: 4px;">
                                    <p id="customer-dt-info" class="dataTables_info" role="status" aria-live="polite"></p>
                                </div>
                                <div class="col">
                                    <nav class="d-lg-flex justify-content-lg-end">
                                        <ul id="customer-pg" class="pagination">
                                        </ul>
                                    </nav>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
       <script src="/assets/js/notify.js"></script>
       <script src="/assets/js/adminaccount.js"></script>
</body>
</html>