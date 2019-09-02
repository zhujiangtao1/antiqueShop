
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
    <!-- MetisMenu CSS -->
    <link href="admin/css/metisMenu.min.css" rel="stylesheet">
    <!-- DataTables CSS -->
    <link href="admin/css/dataTables.bootstrap.css" rel="stylesheet">
    <!-- Custom CSS -->
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

                    <li class="divider"></li>
                    <li>
                        <a href="/usercenter/out">
                            <i class="fa fa-sign-out fa-fw"></i>退出登录
                        </a>
                    </li>
                </ul>
            </li>
            <!-- 用户信息和系统设置结束 -->
        </ul> <!-- 左侧显示列表部分 start-->
        <div class="navbar-default sidebar" role="navigation">
            <div class="sidebar-nav navbar-collapse">
                <!-- 咨询管理  折叠的分组列表 -->
                <div class="panel-heading" id="collapseListGroupHeading1" data-toggle="collapse" data-target="#collapseListGroup1" role="tab">
                    <h4 class="panel-title">
                        后台管理管理 <span class="fa fa-chevron-up right"></span>
                    </h4>
                </div>
                <div id="collapseListGroup1" class="panel-collapse collapse in" role="tabpanel" aria-labelledby="collapseListGroupHeading1">
                    <ul class="list-group">
                        <li class="list-group-item">
                            <a href="/admin/member">
                                <i class="fa fa-paste fa-fw"></i> 用户管理
                            </a></li>

                        <li class="list-group-item">
                            <a href="/admin/antique">
                                <i class="fa fa-lightbulb-o fa-fw"></i> 古玩管理
                            </a>
                        </li>
                        <li class="list-group-item">
                            <a href="/admin/comment">
                                <i class="fa fa-comment-o fa-fw"></i> 评论管理
                            </a>
                        </li>
                    </ul>
                </div>

            </div>
        </div><!-- 左侧显示列表部分 end-->
    </nav>
    <!-- 课程列表查询部分  start-->
    <div id="page-wrapper">
        <div class="row">
            <div class="col-lg-12">
                <h1 class="page-header">用户管理</h1>
            </div>
            <!-- /.col-lg-12 -->
        </div>
        <!-- /.row -->
        <div class="panel panel-default">
            <!-- 搜索部分 -->
            <div class="panel-body">

                    <div class="form-group">
                        <%--@declare id="coursename"--%><label for="courseName">用户名</label>
                        <input type="text" class="form-control" id="id" value="" name="id" style="width: 200px ;height: 30px">

                            <input type="submit" id="xxs" class="btn btn-primary" value="查询" />
                    </div>


                <table id="xs" class="table table-bordered table-striped" style="display: none">

                    <thead>
                    <tr>
                        <th>用户id</th>
                        <th>用户名</th>
                        <th>真实姓名</th>
                        <th>年龄</th>
                        <th>性别</th>
                        <th>电话号码</th>
                        <th>注册时间</th>

                    </tr>
                    </thead>
                    <tbody id="tbody1">
                    </tbody>
                </table>



            </div>
        </div>

        <div class="row">
            <div class="col-lg-12">
                <div class="panel panel-default">
                    <div class="panel-heading">会员信息列表</div>
                    <!-- /.panel-heading -->
                    <table class="table table-bordered table-striped" id="dep_table">
                        <thead>
                        <tr>
                            <th>
                            <input type="checkbox" id="check_all" />
                        </th>
                            <th>用户id</th>
                            <th>用户名</th>
                            <th>真实姓名</th>
                            <th>年龄</th>
                            <th>性别</th>
                            <th>电话号码</th>
                            <th>注册时间</th>
                            <th> 操作</th>

                        <tbody >

                        </tbody>
                        </tr>
                        </thead>

                    </table>
                </div>
                <!-- 显示分页信息 -->
                <div class="row">
                    <!--分页文字信息  -->
                    <div class="col-md-6" id="page_info_area"></div>
                    <!-- 分页条信息 -->
                    <div class="col-md-6" id="page_nav_area">

                    </div>
                </div>
            </div>

                <!-- /.panel -->
            </div>
            <!-- /.col-lg-12 -->
        </div>
    </div>
    <!-- 课程列表查询部分  end-->
</div>

 <!-- 修改会员模态框 -->
 <div class="modal fade" id="courseEditDialog" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">×</span>
                </button>
                <h4 class="modal-title" id="myModal">修改用户信息</h4>
            </div>
            <div class="modal-body">
                <form class="form-horizontal"  method="post" action="${basePath}/admin/updata" id="baseinfo"   >
                    <div class="form-group">
                        <label  class="col-sm-2 control-label">
                            用户号
                        </label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control"  placeholder="用户号"  name="uid" id="uid"  readonly>
                        </div>
                    </div>
                    <div class="form-group">
                        <label  class="col-sm-2 control-label">
                            用户名
                        </label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control"  placeholder="姓名"  name="username" id="username" readonly>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">
                            真实姓名
                        </label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control"  placeholder="真实姓名"  name="uname" id="uname">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">
                            年龄
                        </label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control"  placeholder="年龄" name="uage" id="uage">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">
                            性别
                        </label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control"  placeholder="性别" name="usex" id="usex">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">
                            电话号码
                        </label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control"  placeholder="电话号码"  name="uphone" id="uphone">
                        </div>
                    </div>

                    <div class="modal-footer">
                        <input type="reset"  class="btn btn-default" value="重置" />

                        <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                        <button type="button"  class="btn btn-primary" id="carinfo_submit">保存修改</button>

                    </div>
                </form>
            </div>

        </div>
    </div>
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
<script type="text/javascript">
$(function () {
    to_page(1);
    $("#xxs").click(function () {
        var id=$("#id").val();
        findByid(id);
    });
});

function to_page(pn){
    $.ajax({
        url:"../admin/user",
        data:"pn="+pn,
        type:"GET",
        success:function(result){
            console.log(result);
            //1、解析并显示员工数据
            build_users_table(result);
            //2、解析并显示分页信息
            build_page_info(result);
            //3、解析显示分页条数据
            build_page_nav(result);

        }
    });
}
function build_users_table(result){
    //清空table表格
    $("#dep_table tbody").empty();
    var users = result.extend.pageInfo.list;//list<Department>departments
    $.each(users,function(index,user){
        var checkBoxTd = $("<td><input type='checkbox' class='check_item' /></td>");
        var IdTd = $("<td></td>").append(user.uid);
        var usernameTd = $("<td></td>").append(user.username);
        var unameTd = $("<td></td>").append(user.uname);
        var uageTd = $("<td></td>").append(user.uage);
        var usexTd = $("<td></td>").append(user.usex);
        var uphoneTd = $("<td></td>").append(user.uphone);
        var uregistertimeTd = $("<td></td>").append(user.uregistertime);

        var editBtn = $("<button></button>").addClass("btn btn-primary btn-sm edit_btn ")
            .append($("<span ></span>").addClass("glyphicon glyphicon-pencil")).append("编辑");
        //为编辑按钮添加一个自定义的属性，来表示当前员工id
        editBtn.attr("edit-id",user.uid);
        var delBtn =  $("<button></button>").addClass("btn btn-danger btn-sm delete_btn")
            .append($("<span></span>").addClass("glyphicon glyphicon-trash")).append("删除");
        //为删除按钮添加一个自定义的属性来表示当前删除的员工id
        delBtn.attr("del-id",user.uid);
        var btnTd = $("<td></td>").append(editBtn).append(" ").append(delBtn);
        //var delBtn =
        //append方法执行完成以后还是返回原来的元素
        $("<tr></tr>").append(checkBoxTd)
            .append(IdTd)
            .append(usernameTd)
            .append(unameTd)
            .append(uageTd)
            .append(usexTd)
            .append(uphoneTd)
            .append(uregistertimeTd)
            .append(btnTd)
            .appendTo("#dep_table tbody");
    });
}
//解析显示分页信息
function build_page_info(result){
    $("#page_info_area").empty();
    $("#page_info_area").append("当前"+result.extend.pageInfo.pageNum+"页,总"+
        result.extend.pageInfo.pages+"页,总"+
        result.extend.pageInfo.total+"条记录");
    totalRecord = result.extend.pageInfo.total;//最后的数据
    currentPage = result.extend.pageInfo.pageNum;//当前页
}
//解析显示分页条，点击分页要能去下一页....
function build_page_nav(result){
    //page_nav_area
    $("#page_nav_area").empty();
    var ul = $("<ul></ul>").addClass("pagination");

    //构建元素
    var firstPageLi = $("<li></li>").append($("<a></a>").append("首页"));
    var prePageLi = $("<li></li>").append($("<a></a>").append("&laquo;"));
    if(result.extend.pageInfo.hasPreviousPage == false){
        firstPageLi.addClass("disabled");
        prePageLi.addClass("disabled");
    }else{
        //为元素添加点击翻页的事件
        firstPageLi.click(function(){
            to_page(1);
        });
        prePageLi.click(function(){
            to_page(result.extend.pageInfo.pageNum -1);
        });
    }

    var nextPageLi = $("<li></li>").append($("<a></a>").append("&raquo;"));
    var lastPageLi = $("<li></li>").append($("<a></a>").append("末页"));
    if(result.extend.pageInfo.hasNextPage == false){
        nextPageLi.addClass("disabled");
        lastPageLi.addClass("disabled");
    }else{
        nextPageLi.click(function(){
            to_page(result.extend.pageInfo.pageNum +1);
        });
        lastPageLi.click(function(){
            to_page(result.extend.pageInfo.pages);
        });
    }

    //添加首页和前一页 的提示
    ul.append(firstPageLi).append(prePageLi);
    //1,2，3遍历给ul中添加页码提示
    $.each(result.extend.pageInfo.navigatepageNums,function(index,item){

        var numLi = $("<li></li>").append($("<a></a>").append(item));
        if(result.extend.pageInfo.pageNum == item){
            numLi.addClass("active");
        }
        numLi.click(function(){
            to_page(item);
        });
        ul.append(numLi);
    });
    //添加下一页和末页 的提示
    ul.append(nextPageLi).append(lastPageLi);

    //把ul加入到nav
    var navEle = $("<nav></nav>").append(ul);
    navEle.appendTo("#page_nav_area");
}
//单个删除
$(document).on("click",".delete_btn",function(){
    //1、弹出是否确认删除对话框
    var empName = $(this).parents("tr").find("td:eq(2)").text();
    var userId = $(this).attr("del-id");

    if(confirm("确认删除【"+empName+"】吗？")){
        //确认，发送ajax请求删除即可
        $.ajax({
            url:"../admin/delete",
            type:"GET",
            data:{id:userId},
            success:function(result){
                alert(result.msg);
                //回到本页
                to_page(currentPage);
            }
        });
    }
});
//弹出修改模态框
$(document).on("click",".edit_btn",function () {
    var userId = $(this).attr("edit-id");
    //清除表单数据（表单完整重置（表单的数据，表单的样式））
    reset_form("#courseEditDialog form");
    //弹出模态框
    $("#courseEditDialog").modal({
        backdrop:"static"
    });
    $.ajax({
        url:"../admin/Byuserid",
        type:"post",
        data:{id:userId},
        success:function (data) {

           $("#uid").val(data.uid);
            $("#username").val(data.username);
            $("#uname").val(data.uname);
            $("#uage").val(data.uage);
            $("#usex").val(data.usex);
            $("#uphone").val(data.uphone);
            $("#uregistertime").val(data.uregistertime);

        }
    });

});



    //清空表单样式及内容
    function reset_form(ele) {
        $(ele)[0].reset();
        //清空表单样式
        $(ele).find("*").removeClass("has-error has-success");
        $(ele).find(".help-block").text("");
    }


//查找用户
    function findByid(id) {
        $.ajax({
            url: "../admin/find",
            data: {id: id},
            type: "POST",
            success: function (data) {

                if (data == "") {
                    alert("查询的用户不存在");
                } else {
                    var str = "";
                    str += "<tr>" +
                        "<td>" + data.uid + "</td>" +
                        "<td>" + data.username + "</td>" +
                        "<td>" + data.uname + "</td>" +
                        "<td>" + data.uage + "</td>" +
                        "<td>" + data.usex + "</td>" +
                        "<td>" + data.uphone + "</td>" +

                        "</tr>";
                    $("#xs").show();
                    $("#tbody1").empty();
                    $("#tbody1").append(str);
                }

            },
        });
        return false;
    }

</script>
<script type="text/javascript">
    //	关闭对话框


    $("#carinfo_submit").click(function () {
        var choice=confirm("确认提交修改？");
        if(choice==false){
            return false;
        }
       //ajax去服务器端校验

        var options = {
            success: function(data) {
                $("#courseEditDialog").modal('hide');
                if(data=="1"){
                    alert("修改成功！");
                    //回到本页
                    to_page(currentPage);
                } if(data=="2"){
                    alert("修改失败！");
                    //回到本页
                    to_page(currentPage);
                }
                $(this).resetForm();


            }
        };
        $('#baseinfo').ajaxSubmit(options);

        return false;

    });


</script>

</div>
</body></html>
