<%--
  Created by IntelliJ IDEA.
  User: 朱家豪
  Date: 19/12/11
  Time: 14:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<%@page import="hotel.com.jd.domain.Room" %>
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
        <form class="form-inline" name="roomForm" action="../room/update" method="post">
            <div class="best-hot"style="float: right;margin-left: -100px;margin-right: 200px;margin-top: 50px;">
                <!-- 头部提示信息--><tr>

                <div class="logD logDtip">
                    <p class="p2">修改住房</p>
                </div></tr>
                <!-- 输入框-->
                <tr>
                    <div class="form-group">
                        <img class="img1" src="../../../images/酒店.png" /><input type="text" id="room_id" name="room_id"
                                                                   placeholder="房间序号" value="${room.room_id}"/>
                    </div>
                </tr>
                <tr>
                    房间类型：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<select name="room_type" id="room_type" value="${room.room_type}">
                    <option name="room_type" value="typeA">typeA</option>
                    <option name="room_type" value="圆床房">圆床房</option>
                    <option name="room_type" value="大床房">大床房</option>
                    <option name="room_type" value="标准间">标准间</option>
                    </select>
                </tr>
                <tr>
                    <div class="form-group">
                        <img class="img1" src="../../../images/酒店.png" /><input type="text" id="room_area" name="room_area"
                                                                       placeholder="输入房间面积" value="${room.room_area}">
                    </div></tr>
                <tr>
                    <div class="form-group">
                        <img class="img1" src="../../../images/位置（指南针）.png" /><input type="text" id="room_no" name="room_no" value="${room.room_no}"
                                                                   placeholder="输入房号"/>
                    </div>
                </tr>
                <tr>
                    <div class="form-group">
                        <img class="img1" src="../../../images/价格.png" /><input type="text" id="room_price" name="room_price" value="${room.room_price}"
                                                                   placeholder="输入房间价格" />
                    </div>
                </tr>
                <tr>
                    房间状态：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<select name="room_flag" id="room_flag" value="${room.room_flag}">
                    <option name="room_state" value="已入住">已入住</option>
                    <option name="room_state" value="未入住">未入住</option>
                </select>
                </tr>
                <tr>
                    <div class="form-group">
                        <img src="../../../images/酒店.png" /><input type="text" id="hotel_id" name="hotel_id" value="${room.hotel_id}" placeholder="当前所属酒店" />
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