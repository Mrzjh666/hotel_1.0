<%--
  Created by IntelliJ IDEA.
  User: 朱家豪
  Date: 20/06/03
  Time: 01:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ page import="java.util.ArrayList"%>
<%@ page import="hotel.com.jd.domain.Orders" %>
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

<div style="height:50px;line-height:50px;font-size:25px;vertical-align: middle;text-align: center" class="bg-primary">皇家酒店用户管理</div>

<div class="row" style="padding:10px 10px">

    <!-- 左导航栏 -->

    <div class="col-md-10" style="padding-top:10px">

        <!-- 查询块 -->
        <div class="search" >
            <form class="form-inline" name="orderForm" action="../order/searchOrderByType" method="post">
                <!-- <input type="hidden" name="method" value="search"/> -->
                <input type="text" class="form-control" name="order_type" />
                <input type="hidden" class="form-control" name="currentPage" value="1" />
                <input type="submit" class="btn btn-primary" value="查   询" />&nbsp;&nbsp;
            </form>
        </div>
        <!-- 员工信息显示-->
        <div style="padding-top: 10px;">
            <table class="form_boxA" cellpadding="0" cellspacing="0" >
                <tr>
                    <th>订单id</th>
                    <th>订单类型</th>
                    <th>用户id</th>
                    <th>订单价格</th>
                    <th>订单完成日期</th>
                    <th colspan=2>操作</th>
                </tr>
                <c:forEach items="${requestScope.allOrder }" var="list">
                    <tr>
                        <th style="vertical-align: middle;">${list.order_id}</th>
                        <th style="vertical-align: middle;">${list.order_type}</th>
                        <th style="vertical-align: middle;">${list.user_id}</th>
                        <th style="vertical-align: middle;">${list.order_price}</th>
                        <th style="vertical-align: middle;">${list.date}</th>
                        <th>
                            <H4>
                                <a href="../order/backOrderById?order_id=${list.order_id}&currentPage=${currentPage}">
                                    <span class="glyphicon glyphicon-remove" aria-hidden="true" />退订订单
                                </a>
                            </H4>
                        </th>
                    </tr>
                </c:forEach>
            </table>
        </div>

        <div class="text-center">
            <ul class="pagination">
                <li><a href="../order/searchOrderByType?currentPage=1&order_type${searchOrder_type}">首页</a></li>
                <li><a
                        href="../order/searchOrderByType?currentPage=${currentPage<2?1:currentPage-1}&order_type${searchOrder_type}">上一页</a></li>
                <li><a
                        href="../order/searchOrderByType?currentPage=${(currentPage+1)>allPageCount?allPageCount:(currentPage+1)}&order_type${searchOrder_type}">下一页</a></li>
                <li><a href="../order/searchOrderByType?currentPage=${allPageCount}&order_type${searchOrder_type}">末页</a></li>
            </ul>
        </div>
    </div>
    <!-- 分页 -->
</div>

</body>
</html>