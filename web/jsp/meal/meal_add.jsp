<%--
  Created by IntelliJ IDEA.
  User: 25218
  Date: 2020/6/1
  Time: 10:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
    String contextPath=request.getContextPath();
    request.setAttribute("contextPath", contextPath);
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>登录</title>
    <link rel="stylesheet" type="text/css" href="css/public.css" />
    <link rel="stylesheet" type="text/css" href="css/page.css" />

</head>
<body style="background:url(../../images/bg.jpg);top: 0;
	left: 0;
	width:100%;
	height:100%;
	min-width: 1000px;
	z-index:-10;
	zoom: 1;
	background-color: #fff;
	background-repeat: no-repeat;
	background-size: cover;
	-webkit-background-size: cover;
	-o-background-size: cover;
	background-position: center 0;">
<div class="logDiv">
    <%--    <img class="logBanner" src="images/logBanner.png" />--%>
    <div class="banner-text">
        <form class="form-inline" name="mealForm" enctype="multipart/form-data" action="../meal/save" method="post">
            <div class="col-md-10" style="float: right;margin-left: -100px;margin-right: 200px;margin-top: 50px;">
                <!-- 头部提示信息--><tr>

                <div class="logD logDtip">
                    <p class="p2">添加餐饮</p>
                </div></tr>
                <!-- 输入框-->
                <tr>
                    餐饮类型：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<select name="meal_type" id="meal_type">
                    <option name="meal_type" value="凉菜">凉菜</option>
                    <option name="meal_type" value="热菜">热菜</option>
                    <option name="meal_type" value="主食">主食</option>
                    <option name="meal_type" value="汤品">汤品</option>
                    <option name="meal_type" value="甜品">甜品</option>
                    <option name="meal_type" value="饮品">饮品</option>
                </select>
                </tr>
                <tr>
                    <div class="form-group">
                        <img class="img1" src="images/日子.png" />
                        <input type="text" id="meal_name" name="meal_name" placeholder="输入餐品名称"
                        />
                    </div>
                </tr>
                <tr>
                    <div class="form-group">
                        <img class="img1" src="images/人物.png" />
                        <input type="text" id="meal_price" name="meal_price" placeholder="输入餐品价格" />
                    </div>
                </tr>

                <tr>
                    <div class="form-group">
                        <img class="img1" src="images/价格.png" />
                        <input type="text" id="emp_id" name="emp_id" placeholder="输入厨师ID" />
                    </div>
                </tr>
                <tr>
                    <div class="form-group">
                        <img src="../../../images/酒店.png" /><input type="file" id="flie" name="file" value="选择菜品图片"  />
                    </div>
                </tr>
                <tr>
                    <div class="form-group">
                        <img class="img1" src="../../../images/人物.png"/>
                        <input type="text" id="hotel_id" name="hotel_id" placeholder="输入所属酒店"/>
                    </div>
                </tr>
                <tr>
                    <div class="form-group">
                        <img class="img1" src="../../../images/人物.png"/>
                        <input type="text" id="meal_explain" name="meal_explain" placeholder="餐品注释"/>
                    </div>
                </tr>
                <tr>
                    <div class="form-group">
                        <img class="img1" src="images/价格.png" />
                        <input type="text" id="meal_picpath" name="meal_picpath" placeholder="图片路径" />
                        <input type="file" name="file" class="file" id="fileField" onchange="document.getElementById('meal_picpath').value=this.files[0].name"/>

                    </div>
                </tr>
                <tr>
                    <div class="form-group">
                        <input type="submit" value="添加" style="width:80px;height:30px;font-family:楷体 ;color:#5856ff;border-radius: 10px">
                    </div>
                </tr>
            </div>
        </form></div>
</div>

<!-- 登录body  end-->

<!-- 登录页面底部 -->
<div class="logFoot">
    <p class="p1"style="margin-left: 42%;">版权所有：皇家酒店</p>
</div>
<!-- 登录页面底部end -->

</body>
</html>
