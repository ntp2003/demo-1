<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Document</title>
    <link rel="stylesheet" href="/assets/css/productdetails.css" />
    <script src="style.js"></script>

<!--     <link
      rel="stylesheet"
      href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-alpha1/dist/css/bootstrap.min.css"
    />
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-alpha1/dist/js/bootstrap.bundle.min.js"></script>
 -->
 
     <link
      href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css"
      rel="stylesheet"
    />
    <!-- Google Fonts -->
    <link
      href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700&display=swap"
      rel="stylesheet"
    />
 <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>

<!-- Bao gồm Bootstrap JS -->
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
    <style>
      hr.description {
        margin: 20px;
        border-top: 2px dashed bisque;
      }

      .images img {
        max-width: 100%;
        height: auto;
      }
      .thumbnail img {
        max-width: 100%;
        height: 70px;
      }
    </style>
    <script>
      document.addEventListener("DOMContentLoaded", function () {
        var labels = document.querySelectorAll("label.bg-color");

        labels.forEach(function (label) {
          label.addEventListener("click", function () {
            var checkbox = this.querySelector('input[type="checkbox"]');
            var checkboxes = document.querySelectorAll(
              'input[type="checkbox"]'
            );

            checkboxes.forEach(function (otherCheckbox) {
              if (otherCheckbox !== checkbox) {
                otherCheckbox.checked = false;
                var otherLabel = otherCheckbox.closest("label.bg-color");
                otherLabel.classList.remove("active");
              }
            });

            checkbox.checked = !checkbox.checked;

            if (checkbox.checked) {
              this.classList.add("active");
            } else {
              this.classList.remove("active");
            }
          });
        });
      });
      function change_image(image) {
    	  var container = document.getElementById("main-image");

    	  container.src = image.src;
    	}

    	document.addEventListener("DOMContentLoaded", function (event) {});

    </script>
  </head>
  <body>
    <div class="container mt-5 mb-5">
      <div class="row d-flex justify-content-center">
        <div class="col-md-12">
          <div class="card">
            <div class="row">
              <div class="col-md-6">
                <div class="images p-3">
                  <div class="text-center p-4">
                    <div class="image-container">
                      <img
                        id="main-image"
                        src="https://img.mwc.com.vn/giay-thoi-trang?w=1150&h=0&FileInput=/Resources/Product/2023/11/10/z4866023315266_142c89838534918b9bcf1b6e534b3b0b.jpg"
                      />
                    </div>
                  </div>
                  <div class="thumbnail text-center">
                    <img
                      onclick="change_image(this)"
                      src="https://images.unsplash.com/photo-1542291026-7eec264c27ff?q=80&w=2070&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D"
                      width="70"
                    />
                    <img
                      onclick="change_image(this)"
                      src="https://platinumlist.net/guide/wp-content/uploads/2023/03/IMG-worlds-of-adventure.webp"
                      width="70"
                    />
                    <img
                      onclick="change_image(this)"
                      src="https://ananas.vn/wp-content/uploads/Pro_AV00203_1.jpeg"
                      width="70"
                    />
                    <img
                      onclick="change_image(this)"
                      src="https://static.nike.com/a/images/t_PDP_1280_v1/f_auto,q_auto:eco/33eb9f15-0a30-4244-bf41-77861d94a45f/air-force-1-07-pro-tech-shoes-KHLmTh.png"
                      width="70"
                    />
                  </div>
                </div>
              </div>
              <div class="col-md-6">
                <div class="product p-4">
                  <div
                    class="d-flex justify-content-between align-items-center"
                  >
                    <div class="d-flex align-items-center">
                      <a
                        class="backProduct"
                        href="#"
                        style="text-decoration: none"
                      >
                        <i class="fa fa-long-arrow-left"></i>
                        <span class="ml-1">Back</span>
                      </a>
                    </div>
                  </div>
                  <div class="mt-4 mb-3">
                    <span class="text-uppercase text-muted brand">Ananas</span>
                    <h5 class="text-uppercase">
                      VINTAS NAUDA EXT - HIGH TOP - MONK'S ROBE
                    </h5>
                    <div class="price d-flex flex-row align-items-center">
                      <span class="act-price">$20</span>
                      <div class="ml-2">
                        <small class="dis-price">$59</small>
                        <span>40% OFF</span>
                      </div>
                    </div>
                  </div>
                  <hr class="decription" />

                  <div class="sizes mt-5">
                    <h6 class="text-uppercase">Size</h6>
                    <label class="radio">
                      <input type="radio" name="size" value="S" checked />
                      <span>39</span>
                    </label>
                    <label class="radio">
                      <input type="radio" name="size" value="M" />
                      <span>40</span>
                    </label>
                    <label class="radio">
                      <input type="radio" name="size" value="L" />
                      <span>41</span>
                    </label>
                    <label class="radio">
                      <input type="radio" name="size" value="XL" />
                      <span>42</span>
                    </label>
                    <label class="radio">
                      <input type="radio" name="size" value="XXL" />
                      <span>43</span>
                    </label>
                  </div>

                  <div class="Color-filter" style="margin-top: 10px">
                    <article class="filter-group">
                      <label class="form-label" for="">Color</label>
                      <div class="filter-content collapse show" id="collapse_1">
                        <div class="card-body">
                          <ul class="nav tree" style="list-style-type: none">
                            <li class="cb-color">
                              <label
                                class="bg-color"
                                style="background-color: white"
                              >
                                <input
                                  name="cbColor"
                                  type="checkbox"
                                  value="white"
                                  multiple
                                />
                              </label>
                              <label
                                class="bg-color"
                                style="background-color: brown"
                              >
                                <input
                                  name="cbColor"
                                  type="checkbox"
                                  value="red"
                                  multiple
                                />
                              </label>
                              <label
                                class="bg-color"
                                style="background-color: black"
                              >
                                <input
                                  name="cbColor"
                                  type="checkbox"
                                  value="black"
                                  multiple
                                />
                              </label>
                            </li>
                          </ul>
                        </div>
                      </div>
                    </article>
                  </div>
                  <div class="quantity">
                    <div class="form-outline" style="width: 10rem">
                      <label class="form-label" for="typeNumber"
                        >Quantity</label
                      >
                      <input
                        min="1"
                        max="100"
                        type="number"
                        id="typeNumber"
                        value="1"
                        class="form-control"
                      />
                    </div>
                  </div>
                  <hr class="decription" />

                  <div class="cart mt-4 align-items-center">
                    <button
                      style="margin: 10px"
                      class="btn btn-success btn-md text-uppercase mr-2 px-4"
                    >
                      Add to cart
                    </button>
                    <button
                      style="margin: 10px"
                      class="btn btn-success btn-md text-uppercase mr-2 px-4"
                    >
                      Buy now
                    </button>
                  </div>
                </div>
              </div>

              <div class="decriptionProduct" style="margin-left: 30px">
                <hr style="width: 90%" class="decription" />
                <h5 class="text-uppercase">Decription Product</h5>
                <!-- <p class="about" style="font-size: large">Decription Product</p> -->
                <p class="about" style="margin-right: 30px">
                  Shop from a wide range of t-shirt from orianz. Pefect for your
                  everyday use, you could pair it with a stylish pair of jeans
                  or trousers complete the look. Shop from a wide range of
                  t-shirt from orianz. Pefect for your everyday use, you could
                  pair it with a stylish pair of jeans
                </p>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </body>
</html>