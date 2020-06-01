<%--
  Created by IntelliJ IDEA.
  User: 25218
  Date: 2020/6/1
  Time: 15:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<%@page import="hotel.com.jd.domain.Employee" %>
<%
    String contextPath = request.getContextPath();
    request.setAttribute("contextPath", contextPath);
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>修改员工信息</title>
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
        <form class="form-inline" name="employeeForm" action="../employee/update" method="post">
            <div class="best-hot"style="float: right;margin-left: -100px;margin-right: 200px;margin-top: 50px;">
                <!-- 头部提示信息--><tr>

                <div class="logD logDtip">
                    <p class="p2">修改员工</p>
                </div></tr>
                <!-- 输入框-->
                <tr>
                    <div class="form-group">
                        <img class="img1" src="../../../images/酒店.png" /><input type="text" id="emp_id" name="emp_id"
                                                                                placeholder="员工序号" value="${employee.emp_id}"/>
                    </div>
                </tr>
                <tr>
                    餐品类型：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<select name="emp_pos" id="emp_pos" value="${employee.emp_pos}">
                    <option name="emp_pos" value="服务员">服务员</option>
                    <option name="emp_pos" value="保安">保安</option>
                    <option name="emp_pos" value="厨师">厨师</option>
                    <option name="emp_pos" value="清洁工">清洁工</option>
                    <option name="emp_pos" value="经理">经理</option>
                </select>
                </tr>
                <tr>
                    <div class="form-group">
                        <img class="img1" src="../../../images/酒店.png" /><input type="text" id="emp_name" name="emp_name"
                                                                                placeholder="输入员工姓名" value="${employee.emp_name}">
                    </div></tr>
                <tr>
                    <div class="form-group">
                        <img class="img1" src="../../../images/酒店.png" /><input type="text" id="emp_phone" name="emp_phone"
                                                                                placeholder="输入员工电话" value="${employee.emp_phone}">
                    </div></tr>
                <tr>
                    <div class="form-group">
                        <img class="img1" src="../../../images/位置（指南针）.png" /><input type="text" id="emp_no" name="emp_no" value="${employee.emp_no}"
                                                                                     placeholder="输入员工工号"/>
                    </div>
                </tr>
                <tr>
                    <div class="form-group">
                        <img class="img1" src="../../../images/价格.png" /><input type="text" id="emp_salary" name="emp_salary" value="${employee.emp_salary}"
                                                                                placeholder="输入员工薪资" />
                    </div>
                </tr>
                <tr>
                    <div class="form-group">
                        <img src="../../../images/酒店.png" /><input type="text" id="hotel_id" name="hotel_id" value="${employee.hotel_id}" placeholder="当前所属酒店" />
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

