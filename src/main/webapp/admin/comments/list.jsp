<%--
  Created by IntelliJ IDEA.
  User: Lakdimuthu
  Date: 4/28/2020
  Time: 11:25 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="x-ua-compatible" content="ie=edge">

    <title>AdminLTE 3 | Starter</title>
    <%@ include file="../includes/styles.jsp" %>
    <link rel="stylesheet" href="${ROOT_ADMIN}bower_components/drag-drop-image-uploader/dist/image-uploader.min.css">
</head>
<body class="hold-transition skin-blue sidebar-mini">
<div class="wrapper">
    <%@include file="../includes/header.jsp" %>
    <%@include file="../includes/sidebar.jsp" %>

    <!-- Content Wrapper. Contains page content -->
    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <h1>
                Overview
                <small>All overview in the database.</small>
            </h1>
            <ol class="breadcrumb">
                <li><a href="#"><i class="fa fa-dashboard"></i> Dashboard</a></li>
                <li><a href="#">Overview</a></li>
                <li class="active">List</li>
            </ol>
        </section>

        <!--------------------------------- Main content -------------------------------------------------------------->
        <section class="content container-fluid">

            <div class="row">
                <div class="col-md-12">
                    <div class="box">
                        <div class="box-header"></div>
                        <div class="box-body">
                            <table id="crudTable" class="table table-bordered table-striped display">
                                <thead>
                                <tr>
                                    <th data-orderable=true>
                                        Name
                                    </th>
                                    <th data-orderable=true>
                                        Date
                                    </th>
                                    <th data-orderable=true>
                                        Comment
                                    </th>
                                </tr>
                                </thead>

                                <tbody id="comments-all">


                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
            </div>

        </section>
        <!----------------------------------------- /.content --------------------------------------------------------->
    </div>
    <!-- /.content-wrapper -->


    <!-- Control Sidebar -->
    <aside class="control-sidebar control-sidebar-dark">
        <!-- Create the tabs -->
        <ul class="nav nav-tabs nav-justified control-sidebar-tabs">
            <li class="active"><a href="#control-sidebar-home-tab" data-toggle="tab"><i class="fa fa-home"></i></a></li>
            <li><a href="#control-sidebar-settings-tab" data-toggle="tab"><i class="fa fa-gears"></i></a></li>
        </ul>
        <!-- Tab panes -->
        <div class="tab-content">
            <!-- Home tab content -->
            <div class="tab-pane active" id="control-sidebar-home-tab">
                <h3 class="control-sidebar-heading">Recent Activity</h3>
                <ul class="control-sidebar-menu">
                    <li>
                        <a href="javascript:;">
                            <i class="menu-icon fa fa-birthday-cake bg-red"></i>

                            <div class="menu-info">
                                <h4 class="control-sidebar-subheading">Langdon's Birthday</h4>

                                <p>Will be 23 on April 24th</p>
                            </div>
                        </a>
                    </li>
                </ul>
                <!-- /.control-sidebar-menu -->

                <h3 class="control-sidebar-heading">Tasks Progress</h3>
                <ul class="control-sidebar-menu">
                    <li>
                        <a href="javascript:;">
                            <h4 class="control-sidebar-subheading">
                                Custom Template Design
                                <span class="pull-right-container">
                    <span class="label label-danger pull-right">70%</span>
                  </span>
                            </h4>

                            <div class="progress progress-xxs">
                                <div class="progress-bar progress-bar-danger" style="width: 70%"></div>
                            </div>
                        </a>
                    </li>
                </ul>
                <!-- /.control-sidebar-menu -->

            </div>
            <!-- /.tab-pane -->
            <!-- Stats tab content -->
            <div class="tab-pane" id="control-sidebar-stats-tab">Stats Tab Content</div>
            <!-- /.tab-pane -->
            <!-- Settings tab content -->
            <div class="tab-pane" id="control-sidebar-settings-tab">
                <form method="post">
                    <h3 class="control-sidebar-heading">General Settings</h3>

                    <div class="form-group">
                        <label class="control-sidebar-subheading">
                            Report panel usage
                            <input type="checkbox" class="pull-right" checked>
                        </label>

                        <p>
                            Some information about this general settings option
                        </p>
                    </div>
                    <!-- /.form-group -->
                </form>
            </div>
            <!-- /.tab-pane -->
        </div>
    </aside>
    <!-- /.control-sidebar -->
    <!-- Add the sidebar's background. This div must be placed
    immediately after the control sidebar -->
    <div class="control-sidebar-bg"></div>

    <%@include file="../includes/footer.jsp" %>
</div>

<%@include file="../includes/scripts.jsp" %>
<%--<script src="${ROOT_ADMIN}bower_components/jquery-ui/jquery-ui.min.js"></script>--%>
<script type="text/javascript"
        src="${ROOT_ADMIN}bower_components/drag-drop-image-uploader/dist/image-uploader.min.js"></script>
<script src="${ROOT_ADMIN}dist/js/pages/comment.js"></script>
<script>
    $(function () {
        $(".main-image").imageUploader();
        $(".content-images").imageUploader();

        REST_PATH = "${REST_PATH}";

        loadAll();

    })
</script>
</body>
</html>