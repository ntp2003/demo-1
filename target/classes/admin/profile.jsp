<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html data-bs-theme="light" lang="en">
  <head>
    <meta charset="utf-8" />
    <meta
      name="viewport"
      content="width=device-width, initial-scale=1.0, shrink-to-fit=no" />
    <title>Profile - Brand</title>
    <link rel="stylesheet" href="/assets/bootstrap/css/bootstrap.min.css" />
    <link
      rel="stylesheet"
      href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i&amp;display=swap" />
    <link
      rel="stylesheet"
      href="https://use.fontawesome.com/releases/v5.12.0/css/all.css" />
  </head>

  <body id="page-top">
    <div id="wrapper">
      <nav
        class="navbar align-items-start sidebar sidebar-dark accordion bg-gradient-primary p-0 navbar-dark">
        <div class="container-fluid d-flex flex-column p-0">
          <a
            class="navbar-brand d-flex justify-content-center align-items-center sidebar-brand m-0"
            href="#">
            <div class="sidebar-brand-icon rotate-n-15">
              <i class="fas fa-laugh-wink"></i>
            </div>
            <div class="sidebar-brand-text mx-3"><span>Brand</span></div>
          </a>
          <hr class="sidebar-divider my-0" />
          <ul class="navbar-nav text-light" id="accordionSidebar">
            <li class="nav-item">
              <a class="nav-link active" href="index.html"
                ><i class="fas fa-tachometer-alt"></i><span>Dashboard</span></a
              >
            </li>
            <li class="nav-item">
              <a class="nav-link active" href="profile.html"
                ><i class="fas fa-user"></i><span>Profile</span></a
              >
            </li>
            <li class="nav-item">
              <a class="nav-link" href="table.html"
                ><i class="fas fa-table"></i><span>Table</span></a
              >
            </li>
            <li class="nav-item">
              <a class="nav-link" href="login.html"
                ><i class="far fa-user-circle"></i><span>Login</span></a
              >
            </li>
            <li class="nav-item">
              <a class="nav-link" href="register.html"
                ><i class="fas fa-user-circle"></i><span>Register</span></a
              >
            </li>
            <li class="nav-item">
              <a class="nav-link" href="product.html"
                ><i class="fas fa-shopping-cart"></i><span>Product</span></a
              >
            </li>
          </ul>
          <div class="text-center d-none d-md-inline">
            <button
              class="btn rounded-circle border-0"
              id="sidebarToggle"
              type="button"></button>
          </div>
        </div>
      </nav>
      <div class="d-flex flex-column" id="content-wrapper">
        <div id="content">
          <nav
            class="navbar navbar-expand bg-white shadow mb-4 topbar static-top navbar-light">
            <div class="container-fluid">
              <button
                class="btn btn-link d-md-none rounded-circle me-3"
                id="sidebarToggleTop"
                type="button">
                <i class="fas fa-bars"></i>
              </button>
              <form
                class="d-none d-sm-inline-block me-auto ms-md-3 my-2 my-md-0 mw-100 navbar-search">
                <div class="input-group">
                  <input
                    class="bg-light form-control border-0 small"
                    type="text"
                    placeholder="Search for ..." /><button
                    class="btn btn-primary py-0"
                    type="button">
                    <i class="fas fa-search"></i>
                  </button>
                </div>
              </form>
              <ul class="navbar-nav flex-nowrap ms-auto">
                <li class="nav-item dropdown no-arrow">
                  <div class="nav-item dropdown no-arrow">
                    <a
                      class="dropdown-toggle nav-link"
                      aria-expanded="false"
                      data-bs-toggle="dropdown"
                      href="#"
                      ><span class="d-none d-lg-inline me-2 text-gray-600 small"
                        >Valerie Luna</span
                      ><img
                        class="border rounded-circle img-profile"
                        src="assets/img/avatars/avatar1.jpeg"
                    /></a>
                    <div
                      class="dropdown-menu shadow dropdown-menu-end animated--grow-in">
                      <a class="dropdown-item" href="#"
                        ><i
                          class="fas fa-user fa-sm fa-fw me-2 text-gray-400"></i
                        >&nbsp;Profile</a
                      ><a class="dropdown-item" href="#"
                        ><i
                          class="fas fa-cogs fa-sm fa-fw me-2 text-gray-400"></i
                        >&nbsp;Settings</a
                      ><a class="dropdown-item" href="#"
                        ><i
                          class="fas fa-list fa-sm fa-fw me-2 text-gray-400"></i
                        >&nbsp;Activity log</a
                      >
                      <div class="dropdown-divider"></div>
                      <a class="dropdown-item" href="#"
                        ><i
                          class="fas fa-sign-out-alt fa-sm fa-fw me-2 text-gray-400"></i
                        >&nbsp;Logout</a
                      >
                    </div>
                  </div>
                </li>
              </ul>
            </div>
          </nav>
          <div class="container-fluid">
            <h3 class="text-dark mb-4">Admin</h3>
            <div class="row mb-3">
              <div class="col-lg-4">
                <div class="card mb-3">
                  <div
                    class="card-header py-3"
                    style="background: var(--bs-card-cap-bg)">
                    <h2
                      class="fw-bold text-primary m-0"
                      style="font-size: 24px">
                      Login Information
                    </h2>
                  </div>
                  <div class="card-body">
                    <div class="mb-3">
                      <label class="form-label"
                        >Username : <span>admin</span></label
                      >
                    </div>
                    <div class="mb-3">
                      <label class="form-label"
                        >Password : <span>*************** </span></label
                      >
                    </div>
                    <div class="d-flex justify-content-xl-end mb-3">
                      <button
                        class="btn btn-primary"
                        type="button"
                        data-bs-toggle="modal"
                        data-bs-target="#passwordModal">
                        Change Password
                      </button>
                    </div>
                  </div>
                </div>
              </div>
              <div class="col-lg-8">
                <div class="row d-none mb-3">
                  <div class="col">
                    <div class="card text-white bg-primary shadow">
                      <div class="card-body">
                        <div class="row mb-2">
                          <div class="col">
                            <p class="m-0">Peformance</p>
                            <p class="m-0"><strong>65.2%</strong></p>
                          </div>
                          <div class="col-auto">
                            <i class="fas fa-rocket fa-2x"></i>
                          </div>
                        </div>
                        <p class="text-white-50 small m-0">
                          <i class="fas fa-arrow-up"></i>&nbsp;5% since last
                          month
                        </p>
                      </div>
                    </div>
                  </div>
                  <div class="col">
                    <div class="card text-white bg-success shadow">
                      <div class="card-body">
                        <div class="row mb-2">
                          <div class="col">
                            <p class="m-0">Peformance</p>
                            <p class="m-0"><strong>65.2%</strong></p>
                          </div>
                          <div class="col-auto">
                            <i class="fas fa-rocket fa-2x"></i>
                          </div>
                        </div>
                        <p class="text-white-50 small m-0">
                          <i class="fas fa-arrow-up"></i>&nbsp;5% since last
                          month
                        </p>
                      </div>
                    </div>
                  </div>
                </div>
                <div class="row">
                  <div class="col">
                    <div class="card shadow mb-3">
                      <div
                        class="card-header py-3"
                        style="background: var(--bs-card-cap-bg)">
                        <h2
                          class="fw-bold text-primary m-0"
                          style="font-size: 24px">
                          Admin Information
                        </h2>
                      </div>
                      <div class="card-body">
                        <div class="row">
                          <div class="col">
                            <div class="mb-3">
                              <label class="form-label" for="email"
                                ><strong>Email</strong></label
                              ><input
                                type="email"
                                id="email"
                                class="form-control"
                                name="email"
                                placeholder="Enter your email" />
                            </div>
                          </div>
                        </div>
                        <form>
                          <div class="row">
                            <div class="col">
                              <div class="mb-3">
                                <label class="form-label" for="firstname"
                                  ><strong>First name</strong></label
                                ><input
                                  class="form-control"
                                  type="text"
                                  id="firstname"
                                  name="firstname"
                                  placeholder="Enter your first name" />
                              </div>
                            </div>
                            <div class="col">
                              <div class="mb-3">
                                <label class="form-label" for="lastname"
                                  ><strong>Last name</strong></label
                                ><input
                                  class="form-control"
                                  type="text"
                                  id="lastname"
                                  name="lastname"
                                  placeholder="Enter your last name" />
                              </div>
                            </div>
                          </div>
                          <div class="row">
                            <div class="col">
                              <div class="mb-3">
                                <label class="form-label" for="cccd"
                                  ><strong>CCCD</strong></label
                                ><input
                                  class="form-control"
                                  type="text"
                                  id="cccd"
                                  name="cccd"
                                  placeholder="Enter your cccd" />
                              </div>
                            </div>
                            <div class="col">
                              <div class="mb-3">
                                <label class="form-label" for="phonenumber"
                                  ><strong>Phone number</strong></label
                                ><input
                                  class="form-control"
                                  type="tel"
                                  id="phonenumber"
                                  pattern="[0-9]{10}"
                                  placeholder="Enter your phone number" />
                              </div>
                            </div>
                          </div>
                          <div class="d-flex justify-content-xl-end mb-3">
                            <button class="btn btn-primary" type="submit">
                              Save&nbsp;
                            </button>
                          </div>
                        </form>
                      </div>
                    </div>
                  </div>
                </div>
              </div>
            </div>
            <div
              class="modal fade"
              role="dialog"
              tabindex="-1"
              id="passwordModal"
              aria-labelledby="passwordModalLabel"
              aria-hidden="true">
              <div class="modal-dialog modal-dialog-centered" role="document">
                <div class="modal-content">
                  <div class="modal-header">
                    <h5 class="modal-title" id="passwordModalLabel">
                      Change Password
                    </h5>
                    <button
                      class="btn-close"
                      aria-label="Close"
                      data-bs-dismiss="modal"
                      type="button"></button>
                  </div>
                  <form id="passwordForm" class="ms-1">
                    <div class="modal-body" style="padding-bottom: 0">
                      <div class="mb-3 row ms-2">
                        <label
                          class="form-label col-form-label col-sm-4"
                          for="oldPassword"
                          >Old Password</label
                        >
                        <div class="col-lg-7 col-sm-7">
                          <input
                            class="form-control"
                            type="password"
                            id="oldPassword"
                            maxlength="15"
                            minlength="5"
                            required=""
                            placeholder="Enter old password" />
                        </div>
                      </div>
                      <div class="mb-3 row ms-2">
                        <label
                          class="form-label col-form-label col-sm-4"
                          for="newPassword"
                          >New Password</label
                        >
                        <div class="col col-sm-7">
                          <input
                            class="form-control"
                            type="password"
                            id="newPassword"
                            maxlength="15"
                            minlength="5"
                            pattern="(?=.*\d)(?=.*[@$!%*?&amp;]).{5,15}"
                            required=""
                            title="Must contain at least one number and one special character, and at most 15 characters"
                            placeholder="Enter new password" />
                        </div>
                      </div>
                      <div class="mb-3 row ms-2">
                        <label
                          class="form-label col-form-label col-sm-4"
                          for="confirmPassword"
                          >Confirm Password</label
                        >
                        <div class="col col-sm-7">
                          <input
                            class="form-control"
                            type="password"
                            id="confirmPassword"
                            maxlength="15"
                            minlength="5"
                            required=""
                            placeholder="Repeat new password" />
                        </div>
                      </div>
                    </div>
                    <div
                      class="modal-footer d-flex justify-content-end pt-0 pe-4 pb-3"
                      style="border-style: none">
                      <button
                        class="btn btn-primary"
                        form="passwordForm"
                        id="updateButton"
                        type="submit">
                        Update
                      </button>
                    </div>
                  </form>
                </div>
              </div>
            </div>
          </div>
        </div>
        <footer class="bg-white sticky-footer">
          <div class="container my-auto">
            <div class="text-center my-auto copyright">
              <span>Copyright © Brand 2023</span>
            </div>
          </div>
        </footer>
      </div>
      <a class="border rounded d-inline scroll-to-top" href="#page-top"
        ><i class="fas fa-angle-up"></i
      ></a>
    </div>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.7.0/jquery.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
    <script src="/assets/js/theme.js"></script>
  </body>
</html>
