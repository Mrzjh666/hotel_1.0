<%--
  Created by IntelliJ IDEA.
  User: 25218
  Date: 2020/6/1
  Time: 8:47
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ page import="java.util.ArrayList"%>
<%@ page import="hotel.com.jd.domain.Meal" %>
<%
    String contextPath = request.getContextPath();
    request.setAttribute("contextPath", contextPath);
    String rs = (String)request.getAttribute("result");
%>
<%@page import="hotel.com.jd.domain.Manager"%>
<%
    Manager manager = (Manager) request.getSession().getAttribute("manager");
    if(manager==null)
        response.sendRedirect("login.html");
%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title></title>
    <meta name="keywords" content="" />
    <meta name="description" content="" />
    <meta name="generator" content="" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width; initial-scale=1.0; maximum-scale=1.0; user-scalable=0;">
    <link href="css/haiersoft.css" rel="stylesheet" type="text/css" media="screen,print" />
    <link href="css/print.css" rel="stylesheet" type="text/css"  media="print" />
    <script src="js/jquery-1.10.1.min.js"></script>
    <script src="js/side.js" type="text/javascript"></script>
    <!--[if lt IE 9]>
    <script src="http://html5shiv.googlecode.com/svn/trunk/html5.js"></script>
    <script src="http://css3-mediaqueries-js.googlecode.com/svn/trunk/css3-mediaqueries.js"></script>
    <![endif]-->
    <style type="text/css">
        ul{
            display: table;
            margin:40px auto;
        }
        li{
            display: table-cell;
        }
        ul li a{
            text-decoration: none;
            padding: 5px 8px;
            background-color: #ddd;
            color: #000;
            margin-right: 1px;
        }
        ul li a:hover{
            background-color: #ffcc00;
            color: #fff;
        }
    </style>
    <script>
        window.onload = function x() {
            var flag='<%=request.getAttribute("result")%>';
            console.log(flag);
            function f() {
                if(flag=='null'){
                    return;
                }
                else{
                    alert(flag);
                }
            }
            f();
        }
    </script>
</head>
<body>

<div style="height:50px;line-height:50px;font-size:25px;vertical-align: middle;text-align: center" class="bg-primary">皇家酒店房间管理</div>

<div class="row" style="padding:10px 10px">

    <!-- 左导航栏 -->

    <div class="col-md-10" style="padding-top:10px">

        <!-- 查询块 -->
        <div class="search" >
            <form class="form-inline" name="mealForm" action="../meal/searchByMealName" method="post">
                <!-- <input type="hidden" name="method" value="search"/> -->
                <input type="text" class="form-control" name="mealName" />
                <input type="hidden" class="form-control" name="currentPage" value="1" />
                <input type="submit" class="btn btn-primary" value="查   询" />&nbsp;&nbsp;


                <input type="button" class="btn btn-danger" value="增   加" onclick="javascript:window.location='../meal/openAdd'">
            </form>
        </div>
        <!-- 员工信息显示-->
        <div style="padding-top: 10px;">
            <table class="form_boxA" cellpadding="0" cellspacing="0" >
                <tr>
                    <th>餐饮Id</th>
                    <th>餐饮类型</th>
                    <th>餐饮名称</th>
                    <th>餐饮价格</th>
                    <th>餐饮注释</th>
                    <th>主厨</th>
                    <th>所属酒店</th>
                    <th colspan=2>操作</th>
                </tr>
                <c:forEach items="${requestScope.allMeal }" var="list">
                    <tr>
                        <th style="vertical-align: middle;">${list.meal_id}</th>
                        <th style="vertical-align: middle;">${list.meal_type}</th>
                        <th style="vertical-align: middle;">${list.meal_name}</th>
                        <th style="vertical-align: middle;">${list.meal_price}</th>
                        <th style="vertical-align: middle;">${list.meal_explain}</th>
                        <th style="vertical-align: middle;">${list.emp_id}</th>
                        <th style="vertical-align: middle;">${list.hotel_id}</th>
                        <th>

                            <a href="../meal/openUpdate?meal_id=${list.meal_id}">
                                <H4> 修改<span class="glyphicon glyphicon-edit" aria-hidden="true" /></H4>
                            </a>

                        </th>
                        <th>
                            <H4>
                                <a href="../meal/delete?meal_id=${list.meal_id}&meal_name=${list.meal_name}&currentPage=${currentPage}">
                                    <span class="glyphicon glyphicon-remove" aria-hidden="true" />删除
                                </a>
                            </H4>
                        </th>
                    </tr>
                </c:forEach>
            </table>
        </div>

        <div class="text-center">
            <ul class="pagination">
                <li><a href="../meal/searchByMealName?currentPage=1&meal_name=${searchMeal_name}">首页</a></li>
                <li><a
                        href="../meal/searchByMealName?currentPage=${currentPage<2?1:currentPage-1}&meal_name=${searchMeal_name}">上一页</a></li>
                <li><a
                        href="../meal/searchByMealName?currentPage=${(currentPage+1)>allPageCount?allPageCount:(currentPage+1)}&meal_name=${searchMeal_name}">下一页</a></li>
                <li><a href="../meal/searchByMealName?currentPage=${allPageCount}&meal_name=${searchMeal_name}">末页</a></li>
            </ul>
        </div>
    </div>
    <!-- 分页 -->
</div>

</body>
</html>

