<%--
  Created by IntelliJ IDEA.
  User: 25218
  Date: 2020/6/1
  Time: 10:24
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<%@page import="hotel.com.jd.domain.Meal" %>
<%
    String contextPath = request.getContextPath();
    request.setAttribute("contextPath", contextPath);
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>修改房间</title>
    <link rel="stylesheet" type="text/css" href="css/public.css" />
    <link rel="stylesheet" type="text/css" href="css/page.css" />

</head>
<body style="background:url(../../images/c4.jpg);top: 0;
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
        <form class="form-inline" name="mealForm" action="../meal/update" method="post">
            <div class="best-hot"style="float: right;margin-left: -100px;margin-right: 200px;margin-top: 50px;">
                <!-- 头部提示信息--><tr>

                <div class="logD logDtip">
                    <p class="p2">修改餐品</p>
                </div></tr>
                <!-- 输入框-->
                <tr>
                    <div class="form-group">
                        <img class="img1" src="../../../images/酒店.png" /><input type="text" id="meal_id" name="meal_id"
                                                                                placeholder="房间序号" value="${meal.meal_id}"/>
                    </div>
                </tr>
                <tr>
                    餐品类型：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<select name="meal_type" id="meal_type" value="${meal.meal_type}">
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
                        <img class="img1" src="../../../images/酒店.png" /><input type="text" id="meal_name" name="meal_name"
                                                                                placeholder="输入餐品名称" value="${meal.meal_name}">
                    </div></tr>
                <tr>
                    <div class="form-group">
                        <img class="img1" src="../../../images/位置（指南针）.png" /><input type="text" id="meal_price" name="meal_price" value="${meal.meal_price}"
                                                                                     placeholder="输入餐品价格"/>
                    </div>
                </tr>
                <tr>
                    <div class="form-group">
                        <img class="img1" src="../../../images/价格.png" /><input type="text" id="meal_explain" name="meal_explain" value="${meal.meal_explain}"
                                                                                placeholder="输入餐品注释" />
                    </div>
                </tr>
                <tr>
                    <div class="form-group">
                        <img src="../../../images/酒店.png" /><input type="text" id="hotel_id" name="hotel_id" value="${meal.hotel_id}" placeholder="当前所属酒店" />
                    </div>
                </tr>
                <tr>
                    <div class="form-group">
                        <input type="submit" value="确认修改" style="width:80px;height:30px;font-family:楷体 ;color:#5856ff;border-radius: 10px">
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
