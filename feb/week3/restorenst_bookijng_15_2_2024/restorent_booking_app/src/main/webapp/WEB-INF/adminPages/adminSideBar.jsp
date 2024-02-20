<style>
    body {
        background-image: url('/loginBg.jpg');
        background-size: cover;
    }
</style>
<aside class="navbar navbar-vertical navbar-expand-lg navbar-dark">
    <div class="container-fluid">
        <button class="navbar-toggler" type="button">
            <span class="navbar-toggler-icon">

            </span>
        </button>
        <h1 class="navbar-brand navbar-brand-autodark">
            <a href="#">
                <img class="avatar avatar-lg" src="/logo.jpg">
            </a>
        </h1>
        <div class="collapse navbar-collapse" id="sidebar-menu">
            <ul class="navbar-nav pt-lg-3">
                <li class="nav-item">
                    <a class="nav-link" href="/admin/dashBoard">

                        <span class="nav-link-title ">
                            &nbsp;&nbsp; <svg xmlns="http://www.w3.org/2000/svg"
                                class="icon icon-tabler icon-tabler-screen-share-off" width="200" height="200"
                                viewBox="0 0 24 24" stroke-width="1.5" stroke="#7280F6" fill="none"
                                stroke-linecap="round" stroke-linejoin="round">
                                <path stroke="none" d="M0 0h24v24H0z" fill="none" />
                                <path d="M21 12v3a1 1 0 0 1 -1 1h-16a1 1 0 0 1 -1 -1v-10a1 1 0 0 1 1 -1h9" />
                                <path d="M7 20l10 0" />
                                <path d="M9 16l0 4" />
                                <path d="M15 16l0 4" />
                                <path d="M17 8l4 -4m-4 0l4 4" />
                            </svg>&nbsp;&nbsp;
                            Dashboard
                        </span>
                    </a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/admin/manageCity">

                        <span class="nav-link-title">
                            &nbsp;&nbsp; <svg xmlns="http://www.w3.org/2000/svg"
                                class="icon icon-tabler icon-tabler-building" width="24" height="24" viewBox="0 0 24 24"
                                stroke-width="1.5" stroke="#7280F6" fill="none" stroke-linecap="round"
                                stroke-linejoin="round">
                                <path stroke="none" d="M0 0h24v24H0z" fill="none" />
                                <path d="M3 21l18 0" />
                                <path d="M9 8l1 0" />
                                <path d="M9 12l1 0" />
                                <path d="M9 16l1 0" />
                                <path d="M14 8l1 0" />
                                <path d="M14 12l1 0" />
                                <path d="M14 16l1 0" />
                                <path d="M5 21v-16a2 2 0 0 1 2 -2h10a2 2 0 0 1 2 2v16" />
                            </svg>&nbsp;&nbsp;
                            Manage City
                        </span>
                    </a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/admin/manageArea">

                        <span class="nav-link-title">
                            &nbsp;&nbsp; <svg xmlns="http://www.w3.org/2000/svg"
                                class="icon icon-tabler icon-tabler-map-pin" width="24" height="24" viewBox="0 0 24 24"
                                stroke-width="1.5" stroke="#7280F6" fill="none" stroke-linecap="round"
                                stroke-linejoin="round">
                                <path stroke="none" d="M0 0h24v24H0z" fill="none" />
                                <path d="M9 11a3 3 0 1 0 6 0a3 3 0 0 0 -6 0" />
                                <path
                                    d="M17.657 16.657l-4.243 4.243a2 2 0 0 1 -2.827 0l-4.244 -4.243a8 8 0 1 1 11.314 0z" />
                            </svg>&nbsp;&nbsp;
                            Manage Area
                        </span>
                    </a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/admin/manageCategory">

                        <span class="nav-link-title">
                            &nbsp;&nbsp; <svg xmlns="http://www.w3.org/2000/svg"
                                class="icon icon-tabler icon-tabler-mug" width="24" height="24" viewBox="0 0 24 24"
                                stroke-width="1.5" stroke="#7280F6" fill="none" stroke-linecap="round"
                                stroke-linejoin="round">
                                <path stroke="none" d="M0 0h24v24H0z" fill="none" />
                                <path
                                    d="M4.083 5h10.834a1.08 1.08 0 0 1 1.083 1.077v8.615c0 2.38 -1.94 4.308 -4.333 4.308h-4.334c-2.393 0 -4.333 -1.929 -4.333 -4.308v-8.615a1.08 1.08 0 0 1 1.083 -1.077" />
                                <path
                                    d="M16 8h2.5c1.38 0 2.5 1.045 2.5 2.333v2.334c0 1.288 -1.12 2.333 -2.5 2.333h-2.5" />
                            </svg>&nbsp;&nbsp;
                            Manage Category
                        </span>
                    </a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/admin/manageSubCategory">

                        <span class="nav-link-title">
                            &nbsp;&nbsp; <svg xmlns="http://www.w3.org/2000/svg"
                                class="icon icon-tabler icon-tabler-bowl" width="24" height="24" viewBox="0 0 24 24"
                                stroke-width="1.5" stroke="#7280F6" fill="none" stroke-linecap="round"
                                stroke-linejoin="round">
                                <path stroke="none" d="M0 0h24v24H0z" fill="none" />
                                <path
                                    d="M4 8h16a1 1 0 0 1 1 1v.5c0 1.5 -2.517 5.573 -4 6.5v1a1 1 0 0 1 -1 1h-8a1 1 0 0 1 -1 -1v-1c-1.687 -1.054 -4 -5 -4 -6.5v-.5a1 1 0 0 1 1 -1z" />
                            </svg>&nbsp;&nbsp;
                            Manage Subcategory
                        </span>
                    </a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/admin/manageRestaurant">

                        <span class="nav-link-title">
                            &nbsp;&nbsp; <svg xmlns="http://www.w3.org/2000/svg"
                                class="icon icon-tabler icon-tabler-tools-kitchen-2-off" width="24" height="24"
                                viewBox="0 0 24 24" stroke-width="1.5" stroke="#7280F6" fill="none"
                                stroke-linecap="round" stroke-linejoin="round">
                                <path stroke="none" d="M0 0h24v24H0z" fill="none" />
                                <path
                                    d="M14.386 10.409c.53 -2.28 1.766 -4.692 4.614 -7.409v12m-4 0h-1c0 -.313 0 -.627 0 -.941" />
                                <path d="M19 19v2h-1v-3" />
                                <path d="M8 8v13" />
                                <path d="M5 5v2a3 3 0 0 0 4.546 2.572m1.454 -2.572v-3" />
                                <path d="M3 3l18 18" />
                            </svg>&nbsp;&nbsp;
                            Manage Restaurant
                        </span>
                    </a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/admin/manageOffers">

                        <span class="nav-link-title">
                            &nbsp;&nbsp; <svg xmlns="http://www.w3.org/2000/svg"
                                class="icon icon-tabler icon-tabler-shopping-bag-check" width="24" height="24"
                                viewBox="0 0 24 24" stroke-width="1.5" stroke="#7280F6" fill="none"
                                stroke-linecap="round" stroke-linejoin="round">
                                <path stroke="none" d="M0 0h24v24H0z" fill="none" />
                                <path
                                    d="M11.5 21h-2.926a3 3 0 0 1 -2.965 -2.544l-1.255 -8.152a2 2 0 0 1 1.977 -2.304h11.339a2 2 0 0 1 1.977 2.304l-.5 3.248" />
                                <path d="M9 11v-5a3 3 0 0 1 6 0v5" />
                                <path d="M15 19l2 2l4 -4" />
                            </svg>&nbsp;&nbsp;
                            Manage Offers
                        </span>
                    </a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/admin/manageComplaint">

                        <span class="nav-link-title">
                            &nbsp;&nbsp; <svg xmlns="http://www.w3.org/2000/svg"
                                class="icon icon-tabler icon-tabler-phone" width="24" height="24" viewBox="0 0 24 24"
                                stroke-width="1.5" stroke="#7280F6" fill="none" stroke-linecap="round"
                                stroke-linejoin="round">
                                <path stroke="none" d="M0 0h24v24H0z" fill="none" />
                                <path
                                    d="M5 4h4l2 5l-2.5 1.5a11 11 0 0 0 5 5l1.5 -2.5l5 2v4a2 2 0 0 1 -2 2a16 16 0 0 1 -15 -15a2 2 0 0 1 2 -2" />
                            </svg>&nbsp;&nbsp;
                            Manage Complaint
                        </span>
                    </a>
                </li>

                <li class="nav-item">
                    <a class="nav-link" href="/logout">

                        <span class="nav-link-title">
                            &nbsp;&nbsp;<svg xmlns="http://www.w3.org/2000/svg"
                                class="icon icon-tabler icon-tabler-screen-share-off" width="200" height="200"
                                viewBox="0 0 24 24" stroke-width="1.5" stroke="#7280F6" fill="none"
                                stroke-linecap="round" stroke-linejoin="round">
                                <path stroke="none" d="M0 0h24v24H0z" fill="none" />
                                <path d="M21 12v3a1 1 0 0 1 -1 1h-16a1 1 0 0 1 -1 -1v-10a1 1 0 0 1 1 -1h9" />
                                <path d="M7 20l10 0" />
                                <path d="M9 16l0 4" />
                                <path d="M15 16l0 4" />
                                <path d="M17 8l4 -4m-4 0l4 4" />
                            </svg>&nbsp;&nbsp;
                            Logout
                        </span>
                    </a>
                </li>
            </ul>
        </div>
    </div>
</aside>

<header class="navbar navbar-expand-sm navbar-light d-print-none" style="background-color: #354052; color: white;">
    <div class="container-xl">
        <h1 class="navbar-brand navbar-brand-autodark d-none-navbar-horizontal pe-0 pe-md-3">

        </h1>

        <div class="navbar-nav flex-row order-md-last">
            <div class="nav-item">
                <a href="#" class="nav-link d-flex lh-1 text-reset p-0">
                    <span class="avatar avatar-sm" style="background-image: url('/user.png')"></span>
                    <div class="d-none d-xl-block ps-2">
                        <div>Prince Patel</div>
                        <div class="mt-1 small text-secondary">Programer</div>
                    </div>
                </a>
            </div>
        </div>
    </div>
</header>