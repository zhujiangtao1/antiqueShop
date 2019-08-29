
<%@ page import="java.util.List" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/resources/";
%><%--

  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/7/23
  Time: 20:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <base href="<%=basePath%>">
    <title>后台管理系统（S-M-M） v2.0</title>
    <!-- 引入css样式文件 -->
    <!-- Bootstrap Core CSS -->
    <link href="admin/css/bootstrap.min.css" rel="stylesheet">
    <link href="admin/css/bootstrap.css" rel="stylesheet">
    <!-- MetisMenu CSS -->
    <link href="admin/css/metisMenu.min.css" rel="stylesheet">
    <!-- DataTables CSS -->
    <link href="admin/css/dataTables.bootstrap.css" rel="stylesheet">
    <link href="admin\css\bootstrap.min.css" rel="stylesheet">
    <!-- Custom CSS -->
    <link href="fonts\css\font-awesome-ie7.min.css" rel="stylesheet">
    <link href="admin\css\bootstrap-combined.min.css" rel="stylesheet">

    <link href="admin/css/sb-admin-2.css" rel="stylesheet">
    <!-- Custom Fonts -->
    <link href="admin/css/font-awesome.min.css" rel="stylesheet" type="text/css">

    <link href="admin/css/boot-crm.css" rel="stylesheet" type="text/css">
    <style>

        .panel-heading{background-color: #337ab7;border-color: #2e6da4;font-size:14px;padding-left:20px;height:36px;line-height:36px;color:white;position:relative;cursor:pointer;}/*转成手形图标*/
        .panel-heading span{position:absolute;right:10px;top:12px;}


    </style>
</head>
<body>
<div id="wrapper">
    <!-- 导航栏部分 -->
    <nav class="navbar navbar-default navbar-static-top" role="navigation" style="margin-bottom: 0">
        <div class="navbar-header">
            <a class="navbar-brand" href="">后台管理系统（S-M-M） v2.0</a>
        </div>
        <!-- 导航栏右侧图标部分 -->
        <!-- 导航栏右侧图标部分 -->
        <ul class="nav navbar-top-links navbar-right">


            <!-- 消息通知 end -->
            <!-- 用户信息和系统设置 start -->
            <li class="dropdown">
                <a class="dropdown-toggle" data-toggle="dropdown" href="">
                    <i class="fa fa-user fa-fw"></i>
                    <i class="fa fa-caret-down"></i>
                </a>
                <ul class="dropdown-menu dropdown-user">
                    <li><a href=""><i class="fa fa-user fa-fw"></i>
                        管理员：${ sessionScope.username}</a>
                    </li>
                    <li><a href=""><i class="fa fa-gear fa-fw"></i> 系统设置</a></li>
                    <li class="divider"></li>
                    <li>
                        <a href="">
                            <i class="fa fa-sign-out fa-fw"></i>退出登录
                        </a>
                    </li>
                </ul>
            </li>
            <!-- 用户信息和系统设置结束 -->
        </ul> <!-- 左侧显示列表部分 start-->

    </nav>
    <!-- 课程列表查询部分  start-->
    <div class="container-fluid">
        <div class="quick-actions_homepage">
            <ul class="quick-actions">
                <li class="bg_lb"><a
                        href="../admin/member"> <i
                        class="icon-group"></i>用户管理
                </a><>
                <li class="bg_lg span3"><a
                        href="<%=basePath%>admin/goodList"> <i
                        class="icon-signal"></i>商品管理
                </a><>
                <li class="bg_lo"><a
                        href="<%=basePath%>admin/orderList"> <i
                        class="icon-th"></i>订单管理
                </a><>
                <li class="bg_ly"><a href="<%=basePath%>admin/pursesList">
                    <i class="icon-inbox"></i>钱包管理
                </a><>
            </ul>
        </div>
    </div>
</div>

</div>
    <!-- 课程列表查询部分  end-->
</div>


<!-- 引入js文件 -->
<!-- jQuery -->
<script src="admin/js/jquery-1.11.3.min.js"></script>

<!-- Bootstrap Core JavaScript -->
<script src="admin/js/bootstrap.min.js"></script>
<!-- Metis Menu Plugin JavaScript -->
<script src="admin/js/metisMenu.min.js"></script>
<!-- DataTables JavaScript -->
<script src="admin/js/jquery.dataTables.min.js"></script>
<script src="admin/js/dataTables.bootstrap.min.js"></script>
<!-- Custom Theme JavaScript -->
<script src="admin/js/sb-admin-2.js"></script>
<script type="text/javascript" src="js/jquery.form.js"></script>
<!-- 编写js代码 -->


</div>
</body></html>
