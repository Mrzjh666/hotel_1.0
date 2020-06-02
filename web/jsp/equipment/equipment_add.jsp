<%--
  Created by IntelliJ IDEA.
  User: 25218
  Date: 2020/6/1
  Time: 19:47
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
        <form class="form-inline" name="equipmentForm" action="../equipment/save" method="post">
            <div class="col-md-10" style="float: right;margin-left: -100px;margin-right: 200px;margin-top: 50px;">
                <!-- 头部提示信息--><tr>

                <div class="logD logDtip">
                    <p class="p2">添加健身器材</p>
                </div></tr>
                <!-- 输入框-->
                <tr>
                    器材类型：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<select name="equ_type" id="equ_type">
                    <option name="equ_type" value="有氧器材">有氧器材</option>
                    <option name="equ_type" value="无氧器材">无氧器材</option>
                </select>
                </tr>
                <tr>
                    <div class="form-group">
                        <img class="img1" src="images/日子.png" />
                        <input type="text" id="equ_name" name="equ_name" placeholder="输入器材名称"
                        />
                    </div>
                </tr>
                <tr>
                    <div class="form-group">
                        <img class="img1" src="images/人物.png" />
                        <input type="text" id="equ_num" name="equ_num" placeholder="输入器材数量" />
                    </div>
                </tr>
                <tr>
                    <div class="form-group">
                        <img class="img1" src="images/价格.png" />
                        <input type="text" id="equ_explain" name="equ_explain" placeholder="输入器材作用介绍" />
                    </div>
                </tr>
                <tr>
                    <div class="form-group">
                        <img class="img1" src="images/价格.png" />
                        <input type="text" id="equ_mark" name="equ_mark" placeholder="输入器材备注" />
                    </div>
                </tr>
                <tr>
                    <div class="form-group">
                        <img class="img1" src="images/价格.png" />
                        <input type="text" id="equ_picpath" name="equ_picpath" placeholder="图片路径" />
                    </div>
                </tr>
                <tr>
                    <div class="form-group">
                        <img class="img1" src="../../../images/人物.png"/>
                        <input type="text" id="emp_id" name="emp_id" placeholder="输入维修员工ID"/>
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
