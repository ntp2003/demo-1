<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html data-bs-theme="light" lang="en">
  <head>
    <meta charset="utf-8" />
    <meta
      name="viewport"
      content="width=device-width, initial-scale=1.0, shrink-to-fit=no" />
    <title>Profile</title>
  </head>

  <body>
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
      </div>
      <a class="border rounded d-inline scroll-to-top" href="#page-top"
        ><i class="fas fa-angle-up"></i
      ></a>
    </div>
  </body>
</html>
