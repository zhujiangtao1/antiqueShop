<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%
   String path = request.getContextPath();
   String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/resources/";
%>
<!DOCTYPE html>
<!--[if lt IE 7]> <html class="ie ie6 lt-ie9 lt-ie8 lt-ie7" lang="en"> <![endif]-->
<!--[if IE 7]>    <html class="ie ie7 lt-ie9 lt-ie8"        lang="en"> <![endif]-->
<!--[if IE 8]>    <html class="ie ie8 lt-ie9"               lang="en"> <![endif]-->
<!--[if IE 9]>    <html class="ie ie9"                      lang="en"> <![endif]-->
<!--[if !IE]><!-->
<html lang="en" class="no-ie">
<!--<![endif]-->

<head>
   <base href="<%=basePath%>">
   <!-- Meta-->
   <meta charset="utf-8">
   <meta http-equiv="X-UA-Compatible" content="IE=edge">
   <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=0">
   <meta name="description" content="">
   <meta name="keywords" content="">
   <meta name="author" content="">
   <title>个人中心</title>
   <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
   <!--[if lt IE 9]><script src="js/html5shiv.js"></script><script src="js/respond.min.js"></script><![endif]-->
   <!-- Bootstrap CSS-->
   <link rel="stylesheet" href="app/css/bootstrap.css">
   <!-- Vendor CSS-->
   <link rel="stylesheet" href="vendor/fontawesome/css/font-awesome.min.css">
   <link rel="stylesheet" href="vendor/animo/animate+animo.css">
   <link rel="stylesheet" href="vendor/csspinner/csspinner.min.css">
   <!-- START Page Custom CSS-->
   <link rel="stylesheet" href="vendor/slider/css/slider.css">
   <link rel="stylesheet" href="vendor/chosen/chosen.min.css">
   <link rel="stylesheet" href="vendor/datetimepicker/css/bootstrap-datetimepicker.min.css">
   <!-- Codemirror -->
   <link rel="stylesheet" href="vendor/codemirror/lib/codemirror.css">
   <!-- Bootstrap tags-->
   <link rel="stylesheet" href="vendor/tagsinput/bootstrap-tagsinput.css">
   <!-- END Page Custom CSS-->
   <!-- App CSS-->
   <link rel="stylesheet" href="app/css/app.css">
   <!-- Modernizr JS Script-->
   <script src="vendor/modernizr/modernizr.js" type="application/javascript"></script>
   <!-- FastClick for mobiles-->
   <script src="vendor/fastclick/fastclick.js" type="application/javascript"></script>
</head>

<body>
   <!-- START Main wrapper-->
   <section class="wrapper">
      <!-- START Top Navbar-->
      <nav role="navigation" class="navbar navbar-default navbar-top navbar-fixed-top">
         <!-- START navbar header-->
         <div class="navbar-header">
            <a href="/page/index" class="navbar-brand">
               <div class="brand-logo">东通古玩</div>
            </a>         </div>
         <!-- END navbar header-->
         <!-- START Nav wrapper-->
         <div class="nav-wrapper">
            <!-- START Left navbar-->
            <ul class="nav navbar-nav">
               <li>
                  <a href="#" data-toggle="aside">
                     <em class="fa fa-align-left"></em>                  </a>               </li>
            </ul>
            <!-- END Left navbar-->
            <!-- START Right Navbar-->
            <ul class="nav navbar-nav navbar-right">
               <li>
                  <a href="#" data-toggle="navbar-search">
                     <em class="fa fa-search"></em>                  </a>               </li>
            </ul>
            <!-- END Right Navbar-->
         </div>
         <!-- END Nav wrapper-->
      </nav>
      <!-- END Top Navbar-->
      <!-- START aside-->
      <aside class="aside">
         <!-- START Sidebar (left)-->
         <nav class="sidebar">
            <ul class="nav">
               <!-- START user info-->
               <li>
                  <div data-toggle="collapse-next" class="item user-block has-submenu">
                     <!-- User picture-->
                     <div class="user-block-picture">
                        <img src="app/img/user/02.jpg" alt="Avatar" width="60" height="60" class="img-thumbnail img-circle">
                        <!-- Status when collapsed-->
                        <div class="user-block-status">
                           <div class="point point-success point-lg"></div>
                        </div>
                     </div>
                     <!-- Name and Role-->
                     <div class="user-block-info">
                        <span class="user-block-name item-text">尊敬的用户${ sessionScope.username}，欢迎您！</span>
                        <span class="user-block-role">买主&卖主</span>
                     </div>
                  </div>
                  <!-- START User links collapse-->
                  <ul class="nav collapse">
                     <li><a href="${basePath}/usercenter/updatepassword">密码修改 </a></li>
                     <li class="divider"></li>
                     <li><a href="/usercenter/out">退出</a>                     </li>
                  </ul>
                  <!-- END User links collapse-->
               </li>
               <!-- END user info-->
               <!-- START Menu-->
                <li>
                  <a href="${basePath}/page/user" title="Dashboard" data-toggle="" class="no-submenu">
                     <em class="fa fa-dashboard"></em>
                     <span class="item-text">个人信息</span>                  </a>
               </li>
               <li>
                  <a href="#" title="Tables" data-toggle="collapse-next" class="has-submenu">
                     <em class="fa fa-bar-chart-o"></em>
                     <span class="item-text">作为买方</span>                  </a>
                  <!-- START SubMenu item-->
                  <ul class="nav collapse ">
                     <li style="background:gray;">
                        <a href="/page/order">
                           <span class="item-text">未完成订单</span>                        </a>                     </li>
                     <li>
                        <a href="/page/bhistory">
                           <span class="item-text">历史订单</span>                  </a>
                     </li>
                  </ul>
               </li>
               <li style="background:gray;">
                  <a href="#" title="Tables" data-toggle="collapse-next" class="has-submenu"
                  style="color:white; box-shadow: 0px 1px 10px rgba(0,0,0,.8);">
                     <em class="fa fa-bar-chart-o"></em>
                     <span class="item-text" style="font-size:17px;">作为卖方</span>                  </a>
                  <!-- START SubMenu item-->
                  <ul class="nav collapse ">
                     <li>
                        <a href="/page/shistory">
                           <span class="item-text">已售出古玩信息</span>                        </a>                     </li>
                     <li>
                     <li>
                        <a href="/page/check_order">
                           <span class="item-text">订单确认</span>                        </a>                     </li>
                     <li style="background:gray;">
                        <a href="/page/check_car" style="color:white; box-shadow: 0px 1px 10px rgba(0,0,0,.8);">
                           <span class="item-text" style="font-size:17px;">我发布的古玩信息</span>                  </a>
                     </li>
                  </ul>
               </li>

               <li>
                  <a href="/page/collection" title="Standard" >
                     <em class="fa fa-table"></em>
                     <span class="item-text">收藏夹</span>                  </a>
               </li>
               <li>
                  <a href="${basePath}/page/index" title="Pages" data-toggle="" class="no-submenu">
                     <em class="fa fa-file-text"></em>
                     <div class="label label-primary pull-right">new</div>
                     <span class="item-text">返回首页</span>                  </a>
               </li>
               <!-- END Menu-->
               
               <!-- Sidebar footer    -->
               <li class="nav-footer">
                  <div class="nav-footer-divider"></div>
                  <!-- START button group-->
                  <div class="btn-group text-center">
                     <button type="button" data-toggle="tooltip" data-title="退出" class="btn btn-link">
                        <em class="fa fa-sign-out text-muted"></em>                     </button>
                  </div>
                  <!-- END button group-->
               </li>
            </ul>
         </nav>
         <!-- END Sidebar (left)-->
      </aside>
      <!-- End aside-->
      <!--XXX1-->
      <!-- 修改会员模态框 -->

      <div class="modal fade" id="courseEditDialog" tabindex="-1" role="dialog" aria-labelledby="myModalLabel"  >
         <div class="modal-dialog" role="document">
            <div class="modal-content">
               <div class="modal-header">
                  <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                     <span aria-hidden="true">×</span>
                  </button>
                  <h4 class="modal-title" id="myModal">修改古玩信息</h4>
               </div>
               <div class="modal-body">
                  <form class="form-horizontal"  method="post" action="${basePath}/antiqueInfo/updata" id="baseinfo"  enctype="multipart/form-data">
                     <fieldset>
                        <legend>输入基本信息</legend>
                        <div class="form-group">
                           <label class="col-sm-2 control-label">上传古玩图片</label>
                           <img id="img" width="200px" style="margin-left:20px;">
                           <div class="col-sm-4">
                              <input type="file" name="file" id="fileInput" style="margin-left:20px;" data-classbutton="btn btn-default"
                                     data-classinput="form-control inline" class="filestyle form-control">
                           </div>
                        </div>
                        <fieldset>
                           <div class="form-group">
                              <label class="col-sm-2 control-label">古玩号</label>
                              <div class="col-sm-10">
                                 <input type="text" style="width: 260px; margin-left:20px;" name="antId" id="antId"
                                        class="form-control" readonly="readonly">
                              </div>
                           </div>
                        </fieldset>
                        <div class="form-group">
                           <label class="col-sm-2 control-label">古玩基本信息</label>
                           <div class="col-sm-10">
                              <select style="width: 260px; margin-left:20px;" class="form-control m-b" id="years" name="years">
                                 <optgroup label="热门车型">
                                    <option selected="selected">现代</option>
                                    <option>唐</option>
                                    <option>宋</option>
                                    <option>元</option>
                                    <option>明</option>
                                    <option>清</option>
                                    <option>战国</option>
                                 </optgroup>

                              </select>
                              <select style="width: 260px; margin-left:20px;" name="category" id="category" class="form-control m-b">
                                 <option value="玉器" selected="selected">玉器</option>
                                 <option value="古币">古币</option>
                                 <option value="铜器">铜器</option>

                              </select>
                           </div>
                        </div>
                     </fieldset>
                     <fieldset>
                        <div class="form-group">
                           <label class="col-sm-2 control-label">古玩全名</label>
                           <div class="col-sm-10">
                              <input type="text" style="width: 260px; margin-left:20px;" name="antique_name" id="antique_name"
                                     class="form-control">
                           </div>
                        </div>
                     </fieldset>
                     <fieldset>
                        <div class="form-group">
                           <label for=ant_price class="col-sm-2 control-label">报价</label>
                           <div class="col-sm-10">
                              <input style="width: 260px; margin-left:20px;" name="price" id="ant_price" placeholder="单位（万元）"
                                     type="text" class="form-control">
                           </div>
                        </div>
                     </fieldset>

                     <fieldset class="last-child">
                        <div class="form-group">
                           <label class="col-sm-2 control-label">受损程度</label>
                           <div class="col-sm-10">
                              <select style="width: 260px; margin-left:20px;" name="antique_damage" id="antique_damage" class="form-control m-b">
                                 <option>0%</option>
                                 <option>5%</option>
                                 <option>10%</option>
                                 <option>15%</option>
                                 <option>20%</option>
                                 <option>25%</option>
                                 <option>30%</option>
                                 <option>35%</option>
                                 <option>40%</option>
                                 <option>45%</option>
                                 <option>50%</option>
                                 <option>55%</option>
                                 <option>60%</option>
                                 <option>65%</option>
                                 <option>70%</option>
                                 <option>75%</option>
                                 <option>80%</option>
                                 <option>85%</option>
                                 <option>90%</option>
                                 <option>95%</option>
                                 <option>100%</option>
                              </select>
                              <br>
                           </div>
                        </div>
                     </fieldset>
                     <fieldset>
                        <div class="form-group">
                           <label for="address" class="col-sm-2 control-label">验宝地址</label>
                           <div class="col-sm-10">
                              <input id="address" name="address" style="width: 260px; margin-left:20px;" placeholder="请填写详细地址"
                                     type="text" class="form-control">
                           </div>
                        </div>
                     </fieldset>
                     <fieldset>
                        <div class="form-group">
                           <label for="size" class="col-sm-2 control-label">古玩尺寸</label>
                           <div class="col-sm-10">
                              <input id="size" name="size" style="width: 260px; margin-left:20px;"
                                     type="text" class="form-control">
                           </div>
                        </div>
                     </fieldset>
                     <fieldset>
                        <div class="form-group">
                           <label for="iseager" class="col-sm-2 control-label">是否急于出售</label>
                           <div class="col-sm-10">
                              <select style="width: 260px; margin-left:20px;" id="iseager" name="iseager" class="form-control m-b">
                                 <option>是</option>
                                 <option>否</option>
                              </select>
                              <br>
                           </div>
                        </div>
                     </fieldset>
                     <div class="modal-footer">

                        <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                        <button type="button"  class="btn btn-primary" id="carinfo_submit">保存修改</button>


                     </div>
                  </form>
               </div>

            </div>
         </div>
      </div>

      <section>
         <!-- START Page content-->
         <section class="main-content">
            <h3>已发布古玩信息
               <br>
               <small>可查阅已发布的古玩信息</small>
            </h3>
            <!-- START panel-->
            <div class="panel panel-default">
               <div class="panel-heading">未完成订单
                  <a href="#" data-perform="panel-dismiss" data-toggle="tooltip" title="Close Panel" class="pull-right">
                     <em class="fa fa-times"></em>
                  </a>
                  <a href="#" data-perform="panel-collapse" data-toggle="tooltip" title="Collapse Panel" class="pull-right">
                     <em class="fa fa-minus"></em>
                  </a>
               </div>
               <!-- START table-responsive-->
               <div class="table-responsive">
                  <table id="table-id" class="table table-bordered table-hover">
                     <thead>
                     <tr class="table-th">
                        <th>古玩编号</th>
                        <th>年份</th>
                        <th>类别</th>
                        <th>具体名字</th>
                        <th>图片</th>
                        <th>价格</th>
                        <th>损耗程度</th>
                        <th>体积</th>
                        <th>状态</th>
                        <th>地址</th>
                     </tr>
                     <thead>
                     <tbody id= "table-tbody" class="table-tbody">
                     <c:forEach items="${picAntInfoVos}" var="item">
                        <tr>
                           <td>${item.antiqueInfo.antId}</td>
                           <td>${item.antiqueInfo.years}</td>
                           <td>${item.antiqueInfo.category}</td>
                           <td>${item.antiqueInfo.antique_name}</td>
                           <td><a href="/page/details?id=${item.antiqueInfo.antId}"> <img alt="111" src="${item.pic_url }" style="width: 100px;height: 100px;"></a></td>
                           <td>${item.antiqueInfo.price}</td>
                           <td>${item.antiqueInfo.antique_damage}</td>
                           <td>${item.antiqueInfo.size}</td>
                           <td>${item.antiqueInfo.islocked}</td>
                           <td>${item.antiqueInfo.address}</td>
                           <td><a href="javascript:void(0);"  id="cancel" onclick="del(${item.antiqueInfo.antId})">撤销</a>
                              <a  href="javascript:void(0);" data-toggle="modal" data-target="#courseEditDialog" onclick="showDialog(${item.antiqueInfo.antId})">修改</a></td>
                        </tr>
                     </c:forEach>
                     </tbody>
                  </table>
               </div>
               <!-- END table-responsive-->
               <div class="panel-footer">
                  <div class="row">
                     <div class="col-lg-2">
                        <div class="input-group">

                        </div>
                     </div>
                     <div class="col-lg-8"></div>
                     <div class="col-lg-2">
                        <div class="input-group">
                           <p>客服电话：400-828-3499</p>
                        </div>
                     </div>
                  </div>
               </div>
            </div>

            <!-- END panel-->
         </section>
         <!-- END Page content-->
      </section>
    </section>  
  <!-- END Main wrapper-->
   <!-- START Scripts-->
   <!-- Main vendor Scripts-->
   <script src="vendor/jquery/jquery.min.js"></script>
   <script src="vendor/bootstrap/js/bootstrap.min.js"></script>
   <!-- Plugins-->
   <script src="vendor/chosen/chosen.jquery.min.js"></script>
   <script src="vendor/slider/js/bootstrap-slider.js"></script>
   <script src="vendor/filestyle/bootstrap-filestyle.min.js"></script>
   <!-- Animo-->
   <script src="vendor/animo/animo.min.js"></script>
   <!-- Sparklines-->
   <script src="vendor/sparklines/jquery.sparkline.min.js"></script>
   <!-- Slimscroll-->
   <script src="vendor/slimscroll/jquery.slimscroll.min.js"></script>
   <!-- START Page Custom Script-->
   <!-- Markdown Area Codemirror and dependencies -->
   <script src="vendor/codemirror/lib/codemirror.js"></script>
   <script src="vendor/codemirror/addon/mode/overlay.js"></script>
   <script src="vendor/codemirror/mode/markdown/markdown.js"></script>
   <script src="vendor/codemirror/mode/xml/xml.js"></script>
   <script src="vendor/codemirror/mode/gfm/gfm.js"></script>
   <script src="vendor/marked/marked.js"></script>
   <!-- MomentJs and Datepicker-->
   <script src="vendor/moment/min/moment-with-langs.min.js"></script>
   <script src="vendor/datetimepicker/js/bootstrap-datetimepicker.min.js"></script>
   <!-- Tags input-->
   <script src="vendor/tagsinput/bootstrap-tagsinput.min.js"></script>
   <!-- Input Mask-->
   <script src="vendor/inputmask/jquery.inputmask.bundle.min.js"></script>
   <script type="text/javascript" src="js/jquery.form.js"></script>
   <!-- END Page Custom Script-->
   <!-- App Main-->
   <script src="app/js/app.js"></script>
   <!--XXX2-->
   <script type="text/javascript">
      var discussListDom = $("#table-id").find("#table-tbody");

      function del(id) {
         var user = "${user}";  //若session无user值 判为游客登录 返回登录界面
         if(user=="" || user==null) {
            alert("请先登录");
            window.location.href="/login/login"
         }
         var choice=confirm("确认删除已发布的古玩信息？");
         if(choice==false){
            return false;
         }
         $.ajax({
            type:"post",
            url:"../antiqueInfo/delete",
            data:{id:id},
            success:function(data){

//                 location.reload();
               addDiscuss(data, discussListDom);
            }
         });
      }
      function addDiscuss(data, discussListDom) {
         discussListDom.find("tr").remove();
         for (var i = 0; i < data.length; i++) {
            var liDom=$("<tr></tr>");
            <%--var message="<td>${data[i].order.orderId}</td><td>AA</td>";--%>
            message = "<td>"+data[i].antiqueInfo.antId+"</td>"+
                    "<td>"+data[i].antiqueInfo.years+"</td>"+
                    "<td>"+data[i].antiqueInfo.category+"</td>"+
                    "<td>"+data[i].antiqueInfo.antique_name+"</td>"+
                    "<td><a href='/page/details?id="+data[i].antiqueInfo.antId+"'>"+
                    "<img alt='erorr' src='"+data[i].pic_url+"' class='car1' style=\"width: 100px;height: 100px;\">"+"</a></td>"+
                    "<td>"+data[i].antiqueInfo.price+"</td>"+
                    "<td>"+data[i].antiqueInfo.antique_damage+"</td>"+
                    "<td>"+data[i].antiqueInfo.size+"</td>"+
                    "<td>"+data[i].antiqueInfo.islocked+"</td>"+
                    "<td>"+data[i].antiqueInfo.address+"</td>"+
                    "<td><a href='javascript:void(0);' id='cancel' onclick=del('"+data[i].antiqueInfo.antId+"')  >删除</a>" +
                    "<a  href='javascript:void(0);' data-toggle='modal' data-target='#courseEditDialog' onclick=showDialog('"+data[i].antiqueInfo.antId+"'>修改</a></td>";

            liDom.html(message);

            discussListDom.append(liDom);
         }
         //------------X--------------
      }

   </script>
   <script type="text/javascript">


      function showDialog(id) {
         var user = "${user}";  //若session无user值 判为游客登录 返回登录界面
         if(user=="" || user==null) {
            alert("请先登录");
            window.location.href="/login/login"
         }
         $.ajax({
            type:"post",
            url:"../antiqueInfo/find",
            data:{id:id},
            success:function(data){

               $("#antId").val(data.antId);
               $("#years").val(data.years);
               $("#category").val(data.category);
               $("#antique_name").val(data.antique_name);
               $("#ant_price").val(data.price);
               $("#antique_damage").val(data.antique_damage);
               $("#address").val(data.address);
               $("#size").val(data.size);
            }
         });
      }

   </script>
   <script type="text/javascript">
       //	关闭对话框


      $("#carinfo_submit").click(function () {
         var choice=confirm("确认提交修改？");
         if(choice==false){
            return false;
         }
         var fileInput = $.trim($("#fileInput").val());

          var years = $.trim($("#years").find("option:selected").text());
          var category = $.trim($("#category").find("option:selected").text());
          var antique_name = $.trim($("#antique_name").val());
          var price = $.trim($("#ant_price").val());
          var address = $.trim($("#address").val());


         if (fileInput == "") {
            alert("请至少上传一张图片！");
            return false;
         } else if (years == "") {
            alert("年代不能为空！");
            return false;
         }
         else if (price == "") {
            alert("售价不能为空！");
            return false;
         } else if (category == "") {
            alert("所属类别不能为空！");
            return false;
         }
         else if (address == "") {
            alert("验宝地址不能为空！");
            return false;
         }
         else if (antique_name == "") {
            alert("全名不能为空！");
            return false;
         }

         //ajax去服务器端校验

         var options = {
            success: function(data) {
                if(data=="1"){
                    alert("修改成功！");
                    location.reload();
                } if(data=="2"){
                    alert("修改失败！");
                    location.reload();
                }
                $(this).resetForm();


            }
         };
         $('#baseinfo').ajaxSubmit(options);

         return false;

      });


   </script>
   <!-- END Scripts-->
</body>

</html>