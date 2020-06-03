<%--
  Created by IntelliJ IDEA.
  User: 朱家豪
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
    <title>修改管理员</title>
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
        <form class="form-inline" name="managerForm" action="../manager/update" method="post">
            <div class="best-hot"style="float: right;margin-left: -100px;margin-right: 200px;margin-top: 50px;">
                <!-- 头部提示信息--><tr>

                <div class="logD logDtip">
                    <p class="p2">修改管理员</p>
                </div></tr>
                <!-- 输入框-->
                <tr>
                    <div class="form-group">
                        <img class="img1" src="../../../images/酒店.png" /><input type="text" id="manager_id" name="manager_id"
                                                                                placeholder="管理员id" value="${manager.manager_id}"/>
                    </div>
                </tr>
                </tr>
                <tr>
                    <div class="form-group">
                        <img class="img1" src="../../../images/酒店.png" /><input type="text" id="manager_name" name="manager_name"
                                                                                placeholder="输入管理员姓名" value="${manager.manager_name}">
                    </div></tr>
                <tr>
                    <div class="form-group">
                        <img class="img1" src="../../../images/位置（指南针）.png" /><input type="text" id="manager_account" name="manager_account" value="${manager.manager_account}"
                                                                                     placeholder="输入管理员账号"/>
                    </div>
                </tr>
                <tr>
                    <div class="form-group">
                        <img class="img1" src="../../images/coin08.png" /><input type="password" id="manager_password" name="manager_password"
                                                                                placeholder="输入管理员密码" />
                    </div>
                </tr>
                <tr>
                    <div class="form-group">
                        <img class="img1" src="../../images/coin08.png" /><input type="password" id="manager_password1" name="manager_password1"
                                                                                placeholder="再次确认管理员密码" />
                    </div>
                </tr>
                <tr>
                    <div class="form-group">
                        <img class="img1" src="../../images/coin07.png" /><input type="text" id="manager_phone" name="manager_phone"
                                                                                placeholder="管理员电话号码" />
                    </div>
                </tr>
                <tr>
                    <div class="form-group">
                        <img src="../../../images/酒店.png" /><input type="hidd。 en" id="hotel_id" name="hotel_id" value="${manager.hotel_id}" placeholder="当前所属酒店" />
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