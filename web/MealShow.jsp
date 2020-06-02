<%--
  Created by IntelliJ IDEA.
  User: 25218
  Date: 2019/12/16
  Time: 17:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.hotel.bean.Meal" %>
<%@ page import="com.hotel.dao.MealDAO" %>
<%@ page import="java.util.ArrayList"%>
<%
    String contextPath = request.getContextPath();
    request.setAttribute("contextPath", contextPath);
%>

<!DOCTYPE html>
<html>
<head>
    <title>餐厅美食</title>
    <!-- for-mobile-apps -->
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta name="keywords" content="" />
    <script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false);
    function hideURLbar(){ window.scrollTo(0,1); } </script>
    <!-- //for-mobile-apps -->
    <link href="css/bootstrap.css" rel="stylesheet" type="text/css" media="all" />
    <!-- menu -->
    <link href="css/component.css" rel="stylesheet" type="text/css"  />
    <!-- //menu -->
    <link rel="stylesheet" href="css/swipebox.css">
    <link href="css/style.css" rel="stylesheet" type="text/css" media="all" />
    <!-- js -->
    <script type="text/javascript" src="js/jquery-2.1.4.min.js"></script>
    <!-- //js -->
    <!-- fonts -->
    <link href='http://fonts.googleapis.com/css?family=Gabriela' rel='stylesheet' type='text/css'>
    <link href='http://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800' rel='stylesheet' type='text/css'>
    <!-- //fonts -->
    <!-- start-smoth-scrolling -->
    <script type="text/javascript" src="js/move-top.js"></script>
    <script type="text/javascript" src="js/easing.js"></script>
    <script type="text/javascript">
        jQuery(document).ready(function($) {
            $(".scroll").click(function(event){
                event.preventDefault();
                $('html,body').animate({scrollTop:$(this.hash).offset().top},1000);
            });
        });
    </script>
    <!-- start-smoth-scrolling -->
    <!-- swipe box js -->
    <script src="js/jquery.swipebox.min.js"></script>
    <script type="text/javascript">
        jQuery(function($) {
            $(".swipebox").swipebox();
        });
    </script>
    <!-- //swipe box js -->
    <!--animate-->
    <link href="css/animate.css" rel="stylesheet" type="text/css" media="all">
    <script src="js/wow.min.js"></script>
    <script>
        new WOW().init();
    </script>
    <!--//end-animate-->
</head>
<body class="cbp-spmenu-push">
<!--top-header-->
<!--bottom-->
<section class="button">
    <button id="showLeftPush" class="wow fadeInDown animated" data-wow-delay=".5s"><img src="images/menu.png" alt=""></button>
</section>
<nav class="cbp-spmenu cbp-spmenu-vertical cbp-spmenu-left" id="cbp-spmenu-s1">
    <h3>Menu</h3>
    <div class="logo">
        <a class=" link link--yaku active" href="index.html"><span>首</span><span>页</span></a>
        <a class=" link link--yaku" href="about.html"><span>关</span><span>于</span></a>
        <a class=" link link--yaku" href="services.html"><span>服</span><span>务</span></a>
        <a class=" link link--yaku" href="gallery.html"><span>画</span><span>廊</span></a>
        <a class=" link link--yaku" href="contact.html"><span>联</span><span>系</span></a>
    </div>


</nav>

<!-- Classie - class helper functions by @desandro https://github.com/desandro/classie -->
<script src="js/classie.js"></script>
<script>
    var menuLeft = document.getElementById( 'cbp-spmenu-s1' ),
        showLeftPush = document.getElementById( 'showLeftPush' ),
        showRightPush = document.getElementById( 'showRightPush' ),
        body = document.body;

    showLeftPush.onclick = function() {
        classie.toggle( this, 'active' );
        classie.toggle( body, 'cbp-spmenu-push-toright' );
        classie.toggle( menuLeft, 'cbp-spmenu-open' );
        disableOther( 'showLeftPush' );
    };

    function disableOther( button ) {
        if( button !== 'showLeftPush' ) {
            classie.toggle( showLeftPush, 'disabled' );
        }
        if( button !== 'showRightPush' ) {
            classie.toggle( showRightPush, 'disabled' );
        }
    }
</script>
<!-- banner -->
<div class="banner ">
    <div class="banner-left page-head">
        <div class="grid__item wow fadeInDown animated" data-wow-delay=".5s">
            <h1><a class="link link--ilin" href="index.html"><span>皇家  </span><span>酒店</span></a></h1>
        </div>
        <div class="clearfix"></div>
    </div>
</div>
<!-- contact -->
<%
    MealDAO dao = new MealDAO();
    ArrayList<Meal> list = dao.selectMealAll();
    if(list!=null && list.size()>0)
    {
        for(int i=0;i<list.size();)
        {
        if(list.size()%2==0){
%>
<div class="we-focus">
    <div class="container">
        <div class="focus-grids">
            <div class="col-md-3 focus-grid wow fadeInDown animated" data-wow-delay=".5s">
                <h3><%=list.get(i).getMeal_name()%></h3>
                <p><%=list.get(i).getMeal_explain()%></p>
                <p><%=list.get(i).getMeal_place()%></p>
            </div>
            <div class="col-md-3 focus-grid wow fadeInDown animated" data-wow-delay=".5s">

                <img src="<%=list.get(i).getMeal_picpath()%>"style="width: 300px;height:250px">

            </div>
            <div class="col-md-4 focus-grid wow fadeInDown animated" data-wow-delay=".5s">

                <img src="<%=list.get(i+1).getMeal_picpath()%>"style="width: 300px;height:250px">

            </div>
            <div class="col-md-2 focus-grid wow fadeInDown animated" data-wow-delay=".5s">
                <h3><%=list.get(i+1).getMeal_name()%></h3>
                <p><%=list.get(i+1).getMeal_explain()%></p>
                <p><%=list.get(i+1).getMeal_place()%></p>
            </div>
            <div class="clearfix"></div>
        </div>
    </div>
</div>
<%
                i+=2;
            }
        else {
            if(i+1<list.size()){
           %>
<div class="focus-grids">
<div class="col-md-3 focus-grid wow fadeInDown animated" data-wow-delay=".5s">
    <h3><%=list.get(i).getMeal_name()%></h3>
    <p><%=list.get(i).getMeal_explain()%></p>
    <p><%=list.get(i).getMeal_place()%></p>
</div>
<div class="col-md-3 focus-grid wow fadeInDown animated" data-wow-delay=".5s">

    <img src="<%=list.get(i).getMeal_picpath()%>"style="width: 300px;height:250px">
</div>
    <div class="col-md-4 focus-grid wow fadeInDown animated" data-wow-delay=".5s">

        <img src="<%=list.get(i+1).getMeal_picpath()%>"style="width: 300px;height:250px">

    </div>
    <div class="col-md-2 focus-grid wow fadeInDown animated" data-wow-delay=".5s">
        <h3><%=list.get(i+1).getMeal_name()%></h3>
        <p><%=list.get(i+1).getMeal_explain()%></p>
        <p><%=list.get(i+1).getMeal_place()%></p>
    </div>
    <div class="clearfix"></div>
</div>
            <%
                    i+=2;
                }
                else {
                    %>
<div class="col-md-3 focus-grid wow fadeInDown animated" data-wow-delay=".5s">
    <h3><%=list.get(i).getMeal_name()%></h3>
    <p><%=list.get(i).getMeal_explain()%></p>
    <p><%=list.get(i).getMeal_place()%></p>
</div>
<div class="col-md-3 focus-grid wow fadeInDown animated" data-wow-delay=".5s">

    <img src="<%=list.get(i).getMeal_picpath()%>"style="width: 300px;height:250px">

</div>
<div class="clearfix"></div>
                    <%
                        i++;
                    }
            }
        }
    }
%>
<!-- //gallery -->
<!-- //contact -->
<div class="footer">
    <div class="container">
        <div class="col-md-4 footer-grids wow fadeInRight animated" data-wow-delay=".5s">
            <h3>Get in touch</h3>
            <p>Follow our social media account for the latest hotel information</p>
            <ul>
                <li><a class="ico1" href="#"></a></li>
                <li><a class="ico2" href="#"></a></li>
                <li><a class="ico3" href="#"></a></li>
                <li><a class="ico4" href="#"></a></li>
            </ul>
        </div>
        <div class="col-md-4 footer-grids wow fadeInUp animated" data-wow-delay=".5s">
            <h3>Subscribe For Newsletter</h3>
            <form action="contact.html">
                <input type="text" value="Email" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'Email';}" required="">
                <input type="submit" value="Subscribe">
            </form>
        </div>
        <div class="col-md-4 footer-grids wow fadeInLeft animated" data-wow-delay=".5s">
            <h3>Address</h3>
            <p>8901 Marmora Road <br>
                Glasgow, DO4 89GR.<br>
                Freephone: +86 188-8888-8888<br>
                Telephone: +86 188-8888-8888<br>
                FAX: +1 989 889 9898</p>
            <p>E-mail : 2219852463@qq.com</p>
        </div>
        <div class="clearfix"></div>
    </div>
</div>
<div class="footer-bot wow fadeInRight animated" data-wow-delay=".5s">
    <div class="container">
        <div class="logo2">
            <h2><a href="index.html">皇家 酒店</a></h2>
        </div>
        <div class="ftr-menu">
            <ul>
                <li><a href="index.html">主页 </a></li>
                <li><a href="about.html">关于</a></li>
                <li><a href="services.html">服务</a></li>
                <li><a href="gallery.html">画廊</a></li>
                <li><a href="contact.html">联系</a></li>
            </ul>
        </div>
        <div class="clearfix"></div>
    </div>
</div>
<div class="copy-right wow fadeInLeft animated" data-wow-delay=".5s">
    <div class="container">
        <p><a target="_blank" href="login.html">系统管理中心</a></p>
    </div>
</div>
<!-- for bootstrap working -->
<script src="js/bootstrap.js"></script>
<!-- //for bootstrap working -->
<!-- smooth scrolling -->
<script type="text/javascript">
    $(document).ready(function() {
        /*
            var defaults = {
            containerID: 'toTop', // fading element id
            containerHoverID: 'toTopHover', // fading element hover id
            scrollSpeed: 1200,
            easingType: 'linear'
            };
        */
        $().UItoTop({ easingType: 'easeOutQuart' });
    });
</script>
<a href="#" id="toTop" style="display: block;"> <span id="toTopHover" style="opacity: 1;"> </span></a>
<!-- //smooth scrolling -->

</body>
</html>