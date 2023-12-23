<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html data-bs-theme="light" lang="en">

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
    <title>account</title>
    <link rel="stylesheet" href="/assets/bootstrap/css/bootstrap.min.css">
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js">
    </script>
    <link rel="stylesheet" href="/assets/css/feedback.css">
    <link rel="stylesheet" href="/assets/css/filterTemplate.css">
</head>

<body>
    <div class="container py-5">
        <div class="d-flex justify-content-center flex-wrap gap-5">
            <div class="d-flex">
                <div>
                    <div class="card mt-3" style="width:306.325px;">
                        <ul class="list-group list-group-flush">
							<li class="list-group-item"><a class="nav-link"
								href="/customer/Profile"><div
										style="display: flex; align-items: center;">
										<svg xmlns="http://www.w3.org/2000/svg" width="1em"
											height="1em" viewbox="0 0 20 20" fill="none"
											style="font-size: 16px; margin-right: 10px;">
											<path fill-rule="evenodd"
												d="M10 9C11.6569 9 13 7.65685 13 6C13 4.34315 11.6569 3 10 3C8.34315 3 7 4.34315 7 6C7 7.65685 8.34315 9 10 9ZM3 18C3 14.134 6.13401 11 10 11C13.866 11 17 14.134 17 18H3Z"
												fill="currentColor"></path></svg>
										<span>Account Information</span>
									</div></a></li>
							<li class="list-group-item"><a class="nav-link"
								href="/customer/OrderHistory"><div
										style="display: flex; align-items: center;">
										<svg class="bi bi-cart-fill"
											xmlns="http://www.w3.org/2000/svg" width="1em" height="1em"
											fill="currentColor" viewbox="0 0 16 16"
											style="margin-right: 10px;">
											<path
												d="M0 1.5A.5.5 0 0 1 .5 1H2a.5.5 0 0 1 .485.379L2.89 3H14.5a.5.5 0 0 1 .491.592l-1.5 8A.5.5 0 0 1 13 12H4a.5.5 0 0 1-.491-.408L2.01 3.607 1.61 2H.5a.5.5 0 0 1-.5-.5zM5 12a2 2 0 1 0 0 4 2 2 0 0 0 0-4zm7 0a2 2 0 1 0 0 4 2 2 0 0 0 0-4zm-7 1a1 1 0 1 1 0 2 1 1 0 0 1 0-2zm7 0a1 1 0 1 1 0 2 1 1 0 0 1 0-2z"></path></svg>
										<span>Purchase History</span>
									</div></a></li>
							<li class="list-group-item"><a class="nav-link"
								href="/customer/Feedback"><div
										style="display: flex; align-items: center;">
										<svg xmlns="http://www.w3.org/2000/svg" width="1em"
											height="1em" fill="currentColor" viewbox="0 0 16 16"
											style="margin-right: 10px;">
											<path d="M0 0h24v24H0z" fill="none"></path>
											<path
												d="M20 2H4c-1.1 0-1.99.9-1.99 2L2 22l4-4h14c1.1 0 2-.9 2-2V4c0-1.1-.9-2-2-2zm-7 12h-2v-2h2v2zm0-4h-2V6h2v4z"></path></svg>
										<span>Feedback</span>
									</div></a></li>
							<li class="list-group-item"><a class="nav-link"
								href="/customer/logout"><div
										style="display: flex; align-items: center;">
										<svg xmlns="http://www.w3.org/2000/svg" width="1em"
											height="1em" viewbox="0 0 24 24" fill="none"
											style="margin-right: 10px;">
											<path
												d="M8.51428 20H4.51428C3.40971 20 2.51428 19.1046 2.51428 18V6C2.51428 4.89543 3.40971 4 4.51428 4H8.51428V6H4.51428V18H8.51428V20Z"
												fill="currentColor"></path>
											<path
												d="M13.8418 17.385L15.262 15.9768L11.3428 12.0242L20.4857 12.0242C21.038 12.0242 21.4857 11.5765 21.4857 11.0242C21.4857 10.4719 21.038 10.0242 20.4857 10.0242L11.3236 10.0242L15.304 6.0774L13.8958 4.6572L7.5049 10.9941L13.8418 17.385Z"
												fill="currentColor"></path></svg>
										<span>Logout</span>
									</div></a></li>
						</ul>
                    </div>
                </div>
            </div>
            <div class="d-flex justify-content-center flex-wrap" style="width: 70%;">
                <div class="d-flex justify-content-end mb-2" style="width: 100%;">
                    <div><label class="form-label form-label me-2">Time:</label></div>
                    <div><select class="form-control form-control-sm form-select" style="width: 125px;">
                            <option value="">All</option>
                            <option value="12">7 days ago</option>
                            <option value="13">30 days ago</option>
                            <option value="14">6 months ago</option>
                        </select></div>
                </div>
                <div class="card">
                    <div class="card-body">
                        <div class="d-flex flex-wrap gap-5">
                            <div><img src="" style="width: 70px;height: 70px;"></div>
                            <div>
                                <div><span>Product Name</span></div>
                                <div><span class="text-muted small">Color</span></div>
                                <div><span class="text-muted small">Size</span></div>
                            </div>
                        </div>
                        <div class="rating-feedback" style="display:flex;gap:10px;align-items:center;">
                            <div><span>Rating:</span></div>
                            <div id="rating-stars" class="rating"><span class="star star-filled" data-rating="1">★</span><span class="star star-filled" data-rating="2">★</span><span class="star star-filled" data-rating="3">★</span><span class="star star-filled" data-rating="4">★</span><span class="star star-filled" data-rating="5">★</span></div>
                        </div>
                        <div><span>Content</span><textarea class="form-control ms-2 mt-2" style="width:95%;height:85px;"></textarea></div>
                    </div>
                </div>
                <div class="card">
                    <div class="card-body">
                        <div class="d-flex flex-wrap gap-5">
                            <div><img src="" style="width: 70px;height: 70px;"></div>
                            <div>
                                <div><span>Product Name</span></div>
                                <div><span class="text-muted small">Color</span></div>
                                <div><span class="text-muted small">Size</span></div>
                            </div>
                        </div>
                        <div class="rating-feedback" style="display:flex;gap:10px;align-items:center;">
                            <div><span>Rating:</span></div>
                            <div id="rating-stars-1" class="rating"><span class="star star-filled" data-rating="1">★</span><span class="star star-filled" data-rating="2">★</span><span class="star star-filled" data-rating="3">★</span><span class="star star-filled" data-rating="4">★</span><span class="star star-filled" data-rating="5">★</span></div>
                        </div>
                        <div><span>Content</span><textarea class="form-control ms-2 mt-2" style="width:95%;height:85px;"></textarea></div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <script src="/assets/bootstrap/js/bootstrap.min.js"></script>
    <script src="/assets/js/feedback.js"></script>
</body>

</html>