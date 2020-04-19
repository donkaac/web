<!-- Left side column. contains the logo and sidebar -->
<aside class="main-sidebar">

    <!-- sidebar: style can be found in sidebar.less -->
    <section class="sidebar">

        <!-- Sidebar user panel (optional) -->
        <div class="user-panel">
            <div class="pull-left image">
                <img src="${ROOT_ADMIN}dist/img/user2-160x160.jpg" class="img-circle" alt="User Image">
            </div>
            <div class="pull-left info">
                <p>Alexander Pierce</p>
                <!-- Status -->
                <a href="#"><i class="fa fa-circle text-success"></i> Online</a>
            </div>
        </div>

        <!-- search form (Optional) -->
        <form action="#" method="get" class="sidebar-form">
            <div class="input-group">
                <input type="text" name="q" class="form-control" placeholder="Search...">
                <span class="input-group-btn">
              <button type="submit" name="search" id="search-btn" class="btn btn-flat"><i class="fa fa-search"></i>
              </button>
            </span>
            </div>
        </form>
        <!-- /.search form -->

        <!-- Sidebar Menu -->
        <ul class="sidebar-menu" data-widget="tree">
            <li class="header">HEADER</li>
            <!-- Optionally, you can add icons to the links -->
            <li class="treeview">
                <a href="#"><i class="fa fa-plus-square"></i> <span>Overview Manager</span>
                    <span class="pull-right-container">
                <i class="fa fa-angle-left pull-right"></i>
              </span>
                </a>
                <ul class="treeview-menu">
                    <li><a href="${ROOT_ADMIN}overview/add.jsp">Add New</a></li>
                </ul>
            </li>

            <li class="treeview">
                <a href="#"><i class="fa fa-plus-square"></i> <span>Service Provider Index</span>
                    <span class="pull-right-container">
                <i class="fa fa-angle-left pull-right"></i>
              </span>
                </a>
                <ul class="treeview-menu">
                    <li><a href="${ROOT_ADMIN}Service_Provider_Index/add.jsp">Add New</a></li>
                </ul>
            </li>

            <li class="treeview">
                <a href="#"><i class="fa fa-plus-square"></i> <span>Menu Bar</span>
                    <span class="pull-right-container">
                <i class="fa fa-angle-left pull-right"></i>
              </span>
                </a>
                <ul class="treeview-menu">
                    <li><a href="${ROOT_ADMIN}menubar/add.jsp">Add New</a></li>
                </ul>
            </li>

            <li class="treeview">
                <a href="#"><i class="fa fa-plus-square"></i> <span>User Registration</span>
                    <span class="pull-right-container">
                <i class="fa fa-angle-left pull-right"></i>
              </span>
                </a>
                <ul class="treeview-menu">
                    <li><a href="${ROOT_ADMIN}user/add-user.jsp">Register New User</a></li>
                    <li><a href="${ROOT_ADMIN}user/password.jsp">Change Password</a></li>
                </ul>
            </li>

            <li class="treeview">
                <a href="#"><i class="fa fa-plus-square"></i> <span>Quick Index</span>
                    <span class="pull-right-container">
                <i class="fa fa-angle-left pull-right"></i>
              </span>
                </a>
                <ul class="treeview-menu">
                    <li><a href="${ROOT_ADMIN}">Add Quick Index</a></li>
                </ul>
            </li>

            <li class="treeview">
                <a href="#"><i class="fa fa-plus-square"></i> <span>Image Galary</span>
                    <span class="pull-right-container">
                <i class="fa fa-angle-left pull-right"></i>
              </span>
                </a>
                <ul class="treeview-menu">
                    <li><a href="${ROOT_ADMIN}image_galary/home_page_image.jsp">Add Home Page Image</a></li>
                    <li><a href="${ROOT_ADMIN}image_galary/add_galary_images.jsp">Add Image Galary Images</a></li>
                </ul>
            </li>
        </ul>
        <!-- /.sidebar-menu -->
    </section>
    <!-- /.sidebar -->
</aside>