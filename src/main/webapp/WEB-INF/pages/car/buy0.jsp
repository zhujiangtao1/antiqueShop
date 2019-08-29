<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/" + "resources/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <base href="<%=basePath%>">
    <title>我要买车</title>
    <!-- 头部 -->
    <style type="text/css">
body{color: #333;font: 400 15px/15px Raleway,Arial,Helvetica;}
    .shoubu
    {border-radius:25px;
        background-color:#f0f0f0;
        margin-top:0px;
        margin-bottom:10px;
        border-bottom:1px solid #6e6e6e;
        box-shadow:2px 4px 6px #000;

    }
.shoubu p{display:inline-block;padding:0px 20px 5px 20px;padding-top: -30px;}
.shoubu_p{padding:20px 20px 35px 20px;}
.shoubu p a:hover{text-decoration:none !important;box-shadow:1px 2px 1px #000;}
.backtable{border-radius:5px;display:inline-block;height:40px;padding:0px 45px 5px 45px;}
a {
    color: #00a9c6;
    text-decoration: none;
}
    </style>
    <!-- 中部 -->
    <style type="text/css">
        .agemin {
            width: 70px;
        }

        .agemax {
            width: 70px;
        }

        .pricemin {
            width: 70px;
        }

        .pricemax {
            width: 70px;
        }

        /*.carshow {*/
            /*display: inline-block;*/
        /*}*/

        .carshow a:hover {
            text-decoration: none;
        }

        .carinfo {
            font-size: 20px;
            text-overflow: ellipsis;
            overflow: hidden;
            white-space: nowrap;
        }

        .main1 {
            border-bottom: 1px solid #e6e6e6;
            margin-bottom: 20px;
            font-size: 30px;
        }

        .main1 span {
            border-bottom: 4px solid #22ac38;
        }
    </style>
    <!--c:foreach中 样式设计-->
    <style type="text/css">
        a.car_a{
            height: 300px;
            width:300px;
            text-decoration:none;
            color:#000000;
            /*display: inline-block;*/
            padding-left: 30px;
            padding-bottom: 10px;
        }
        a img.car1{
            height: 280px;
            width:280px;
        }
        td.car_td{
            padding: 30px;
        }
    </style>
    <!-- 尾部 -->
    <style type="text/css">
        .footer_bg1 {
            background-color: #000000;
            position: relative;
            bottom: 0;
            right: 0;
            left: 0;
            text-align: center;
        }

        #toTop {
            position: fixed;
            right: 10px;
            bottom: 15px;
            background: url(images/top_move.png) no-repeat right top;
        }

    </style>
    <script src="js/jquery-1.11.2.min.js"></script>

</head>
<body>
<!-- start header -->
<div class="shoubu"style="text-align:center;font-size:30px;">
	<div class="shoubu_p">
	<img alt="" src="images/dongtong2.png"style="width:50px;position:relative;left:-30px;top: 15px;">
	<p>|</p>
	<p class="logo" style="font:700 1.5em Raleway,Arial,Helvetica;position:relative;left:-60px;top:10px;">DongTong</p>
	<table class="backtable"style="font-weight: 600;">
		<tr>
			<td>
				<p><a href="/page/index">首页</a></p>
				<p><a href="/page/showCar" >我要买古玩</a></p>
				<p><a  href="/page/index">我要卖古玩</a></p>
				<p> <a href="${basePath}/page/user" >个人中心</a></p>
					<img alt="" src="images/contact.png"style="width:50px;position:relative;left:20px;">
			</td>
		</tr>
	</table>
	</div>
</div>
<div class="clear"></div>

<div style="border-left:1px solid #e6e6e6;border-right:1px solid #e6e6e6;padding-top:10px;padding-bottom:30px;">
    <form id="form1" method="post"></form>

    <div class="screen" style="padding-top:10px;padding-bottom:10px;border-bottom:1px solid #6e6e6e;">
        <em style="margin-left:20px;margin-right:20px;">价格</em>
        <input type="text" class="price1" value="0" name="ant_price1">
        <em>--</em>
        <input type="text" class="price2" value="1000" name="ant_price2">
        <em>万</em>
        <%--<button>确定</button>--%>
    </div>

    <div class="selection" style="padding-top:10px;padding-bottom:10px;border-bottom:1px solid #6e6e6e;">
        <em style="margin-left:20px;margin-right:20px;">更多</em>
        年代
        <select name="ant_years">
            <option value="0">不限</option>
            <option value="宋">宋</option>
            <option value="现代">现代</option>
            <option value="清">清</option>
        </select>
        类别
        <select name="ant_category">
            <option value="0">不限</option>
            <option value="玉器">玉器</option>
            <option value="古币">古币</option>
            <option value="铜器">铜器</option>

        </select>

        <a href="javascript:void(0)" id="btn">查询</a>
        <div class="clear"></div>
    </div>
    </form>
</div>
<!-- start main1 -->
<div class="main_bg1">
    <div class="wrap">
        <div class="main1">
            <span>古玩展示</span>
        </div>
    </div>
</div>
<!-- start main -->
<div class="carshow">
    <table class="table-detail">
        <tbody class="tbody-dom">
        <tr>
            <c:forEach items="${itemsList}" var="item" varStatus="status" begin="0" end="19">
            <td class="car_td">
            <a  class="car_a" href="/page/details?id=${item.antiqueInfo.antId}">
                <img alt="" src="${item.pic_url}" class="car1" style="left: 20px;">
                <div class="carinfo">
                    <div class="item_name" style="line-height: 30px;">${item.antiqueInfo.category}  </div>
                    <div class="item_conf" style="line-height: 30px;">${item.antiqueInfo.antique_name}</div>
                    <div class="car_age" style="line-height: 30px;">朝代：${item.antiqueInfo.years} | 损耗程度：${item.antiqueInfo.antique_damage}</div>
                    <div class="car_price" style="line-height: 30px;">标价：${item.antiqueInfo.price}万</div>
                </div>
            </a>
            </td>
                <c:if test="${status.count % 4 == 0}">
        </tr>
        <tr>
            </c:if>
            </c:forEach>
        </tr>
        </tbody>
    </table>
</div>

<script type="text/javascript">
    $(function () {
        var discussListDom = $(".table-detail").find(".tbody-dom");
//        console.log(discussListDom.html());
//            var discussListDom = document.getElementsByName("tbody-dom");
        $("#btn").click(function () {
            var years = $("select[name='ant_years']").val();
            var category = $("select[name='ant_category']").val();

            var price1 = $("input[name='ant_price1']").val();
            var price2 = $("input[name='ant_price2']").val();
            var params = {
                years: years,
                category: category,
                price1: price1,
                price2: price2
            };
//            alert(121);
            $.ajax({
                type: "post",
                url: "../antiqueInfo/selectCar",
                data: params,
                success: function (data) {
//                        alert(data);
//                        alert(typeof data);
//                    alert(JSON.stringify(data));
//                        discussListDom.children().remove();
//                    alert(discussListDom.attr("innerHTML"));
                    addDiscuss(data, discussListDom);
                }
            });
        });
        function addDiscuss(data, discussListDom) {
//            discussListDom.children().removeAll();

            discussListDom.find("tr").remove();
//            alert(data.length);
            for (var i = 0; i < data.length; i++) {
                if (i + 3 <= data.length - 1) {
                    var liDom = $("<tr></tr>");
                    var message = "";
//                    alert(i);
                    message = "<td class='car_td'><a  class='car_a' href='/page/details?id=" + data[i].antiqueInfo.antId + "'>"+
                        "<img alt='erorr' src='"+data[i].pic_url+"' class='car1'>"+
                        "<div class='carinfo'>"+
                        "<div class='item_name'style='line-height: 30px;'>"+data[i].antiqueInfo.category+"  "+" </div>"+
                        "<div class='item_conf'style='line-height: 30px;'>"+data[i].antiqueInfo.antique_name+"</div>"+
                        "<div class='car_age' style='line-height: 30px;'>朝代: "+data[i].antiqueInfo.years+"| 损耗程度："+data[i].antiqueInfo.antique_damage+"</div>"+
                        "<div class='car_price'style='line-height: 30px;'>标价："+data[i].antiqueInfo.price+"万"+"</div></div></a></div>" +
                        "<td class='car_td'><a  class='car_a' href='/page/details?id=" + data[i+1].antiqueInfo.antId + "'>"+
                        "<img alt='erorr' src='"+data[i+1].pic_url+"' class='car1'>"+
                        "<div class='carinfo'>"+
                        "<div class='item_name'style='line-height: 30px;'>"+data[i+1].antiqueInfo.category+"  "+" </div>"+
                        "<div class='item_conf'style='line-height: 30px;'>"+data[i+1].antiqueInfo.antique_name+"</div>"+
                        "<div class='car_age'style='line-height: 30px;'>朝代: "+data[i+1].antiqueInfo.years+"| 损耗程度："+data[i+1].antiqueInfo.antique_damage+"</div>"+
                        "<div class='car_price'style='line-height: 30px;'>标价："+data[i+1].antiqueInfo.price+"万"+"</div></div></a></div>" +
                        "<td class='car_td'><a  class='car_a' href='/page/details?id=" + data[i+2].antiqueInfo.antId + "'>"+
                        "<img alt='erorr' src='"+data[i+2].pic_url+"' class='car1'>"+
                        "<div class='carinfo'>"+
                        "<div class='item_name'style='line-height: 30px;'>"+data[i+2].antiqueInfo.category+"  "+" </div>"+
                        "<div class='item_conf'style='line-height: 30px;'>"+data[i+2].antiqueInfo.antique_name+"</div>"+
                        "<div class='car_age'style='line-height: 30px;'>朝代: "+data[i+2].antiqueInfo.years+"| 损耗程度："+data[i+2].antiqueInfo.antique_damage+"</div>"+
                        "<div class='car_price'style='line-height: 30px;'>标价："+data[i+2].antiqueInfo.price+"万"+"</div></div></a></div>" +
                        "<td class='car_td'><a  class='car_a' href='/page/details?id=" + data[i+3].antiqueInfo.antId + "'>"+
                        "<img alt='erorr' src='"+data[i+2].pic_url+"' class='car1'>"+
                        "<div class='carinfo'>"+
                        "<div class='item_name'style='line-height: 30px;'>"+data[i+3].antiqueInfo.category+"  "+" </div>"+
                        "<div class='item_conf'style='line-height: 30px;'>"+data[i+3].antiqueInfo.antique_name+"</div>"+
                        "<div class='car_age'style='line-height: 30px;'>朝代: "+data[i+3].antiqueInfo.years+"| 损耗程度："+data[i+3].antiqueInfo.antique_damage+"</div>"+
                        "<div class='car_price'style='line-height: 30px;'>标价："+data[i+3].antiqueInfo.price+"万"+"</div></div></a></div>";
                    i = i + 3;
//                    alert(message);
//                    alert("end:"+i);
                    liDom.html(message);
                    discussListDom.append(liDom);
                }else if(i+2<=data.length-1){
                    var liDom = $("<tr></tr>");
                    var message = "";
//                    alert(i);
                    message = "<td class='car_td'><a  class='car_a' href='/page/details?id=" + data[i].antiqueInfo.antId + "'>"+
                        "<img alt='erorr' src='"+data[i].pic_url+"' class='car1'>"+
                        "<div class='carinfo'>"+
                        "<div class='item_name'style='line-height: 30px;'>"+data[i].antiqueInfo.category+"  "+" </div>"+
                        "<div class='item_conf'style='line-height: 30px;'>"+data[i].antiqueInfo.antique_name+"</div>"+
                        "<div class='car_age'style='line-height: 30px;'>朝代: "+data[i].antiqueInfo.years+"| 损耗程度："+data[i].antiqueInfo.antique_damage+"</div>"+
                        "<div class='car_price'style='line-height: 30px;'>标价："+data[i].antiqueInfo.price+"万"+"</div></div></a></div>" +
                        "<td class='car_td'><a  class='car_a' href='/page/details?id=" + data[i+1].antiqueInfo.antId + "'>"+
                        "<img alt='erorr' src='"+data[i+1].pic_url+"' class='car1'>"+
                        "<div class='carinfo'>"+
                        "<div class='item_name'style='line-height: 30px;'>"+data[i+1].antiqueInfo.category+"  "+" </div>"+
                        "<div class='item_conf'style='line-height: 30px;'>"+data[i+1].antiqueInfo.antique_name+"</div>"+
                        "<div class='car_age'style='line-height: 30px;'>朝代: "+data[i+1].antiqueInfo.years+"| 损耗程度："+data[i+1].antiqueInfo.antique_damage+"</div>"+
                        "<div class='car_price'style='line-height: 30px;'>标价："+data[i+1].antiqueInfo.price+"万"+"</div></div></a></div>" +
                        "<td class='car_td'><a  class='car_a' href='/page/details?id=" + data[i+2].antiqueInfo.antId + "'>"+
                        "<img alt='erorr' src='"+data[i+2].pic_url+"' class='car1'>"+
                        "<div class='carinfo'>"+
                        "<div class='item_name'style='line-height: 30px;'>"+data[i+2].antiqueInfo.category+"  "+" </div>"+
                        "<div class='item_conf'style='line-height: 30px;'>"+data[i+2].antiqueInfo.antique_name+"</div>"+
                        "<div class='car_age'style='line-height: 30px;'>朝代: "+data[i+2].antiqueInfo.years+"| 损耗程度："+data[i+2].antiqueInfo.antique_damage+"</div>"+
                        "<div class='car_price'style='line-height: 30px;'>标价："+data[i+2].antiqueInfo.price+"万"+"</div></div></a></div>";
                    i = i + 2;
                    liDom.html(message);
                    discussListDom.append(liDom);
                } else if (i + 1 == data.length - 1) {
//                    alert("if222"+i);
                    var liDom = $("<tr></tr>");
                    var message = "";
                    message = "<td class='car_td'> <a  class='car_a' href='/page/details?id=" + data[i].antiqueInfo.antId + "'>"+
                        "<img alt='erorr' src='"+data[i].pic_url+"' class='car1'>"+
                        "<div class='carinfo'>"+
                        "<div class='item_name'style='line-height: 30px;'>"+data[i].antiqueInfo.category+"  "+" </div>"+
                        "<div class='item_conf'style='line-height: 30px;'>"+data[i].antiqueInfo.antique_name+"</div>"+
                        "<div class='car_age'style='line-height: 30px;'>朝代: "+data[i].antiqueInfo.years+"| 损耗程度："+data[i].antiqueInfo.antique_damage+"</div>"+
                        "<div class='car_price'style='line-height: 30px;'>标价："+data[i].antiqueInfo.price+"万"+"</div></div></a></div>" +
                        "<td class='car_td'><a  class='car_a' href='/page/details?id=" + data[i+1].antiqueInfo.antId + "'>"+
                        "<img alt='erorr' src='"+data[i+1].pic_url+"' class='car1'>"+
                        "<div class='carinfo'>"+
                        "<div class='item_name'style='line-height: 30px;'>"+data[i+1].antiqueInfo.category+"  "+" </div>"+
                        "<div class='item_conf'style='line-height: 30px;'>"+data[i+1].antiqueInfo.antique_name+"</div>"+
                        "<div class='car_age'style='line-height: 30px;'>朝代: "+data[i+1].antiqueInfo.years+"| 损耗程度："+data[i+1].antiqueInfo.antique_damage+"</div>"+
                        "<div class='car_price'style='line-height: 30px;'>标价："+data[i+1].antiqueInfo.price+"万"+"</div></div></a></div>";
                    i = i + 1;
                    liDom.html(message);
                    discussListDom.append(liDom);
                }
                else {
                    var liDom = $("<tr></tr>");
                    var message = "";
                    message = "<td class='car_td'><a  class='car_a' href='/page/details?id=" + data[i].antiqueInfo.antId + "'>"+
                        "<img alt='erorr' src='"+data[i].pic_url+"' class='car1'>"+
                        "<div class='carinfo'>"+
                        "<div class='item_name'style='line-height: 30px;'>"+data[i].antiqueInfo.category+"  "+" </div>"+
                        "<div class='item_conf'style='line-height: 30px;'>"+data[i].antiqueInfo.antique_name+"</div>"+
                        "<div class='car_age'style='line-height: 30px;'>朝代: "+data[i].antiqueInfo.years+"| 损耗程度："+data[i].antiqueInfo.antique_damage+"</div>"+
                        "<div class='car_price'style='line-height: 30px;'>标价："+data[i].antiqueInfo.price+"万"+"</div></div></a></div>";
//                    i=i+1;
                    liDom.html(message);
                    discussListDom.append(liDom);
                }
            }
            //------------X--------------
        };
    });

</script>
</body>
</html>