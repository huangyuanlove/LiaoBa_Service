<!DOCTYPE html>
<!--[if lt IE 7]> <html class="no-js lt-ie9 lt-ie8 lt-ie7"> <![endif]-->
<!--[if IE 7]> <html class="no-js lt-ie9 lt-ie8"> <![endif]-->
<!--[if IE 8]> <html class="no-js lt-ie9"> <![endif]-->
<!--[if gt IE 8]><!-->
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html class="no-js">
<!--<![endif]-->

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>Admin Area</title>
    <link rel="icon" href="icon/index.ico" type="image/x-icon"/>
    <meta name="description" content="">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no"/>
    <!-- Favicon -->
    <link rel="shortcut icon" href="assets/img/favicon.ico" type="image/x-icon">
    <!-- Bootstrap core CSS -->
    <link rel="stylesheet" href="assets/plugins/bootstrap/css/bootstrap.min.css">
    <!-- Fonts from Font Awsome -->
    <link rel="stylesheet" href="assets/css/font-awesome.min.css">
    <!-- CSS Animate -->
    <link rel="stylesheet" href="assets/css/animate.css">
    <!-- Custom styles for this theme -->
    <link rel="stylesheet" href="assets/css/main.css">
    <!-- Vector Map  -->
    <link rel="stylesheet" href="assets/plugins/jvectormap/css/jquery-jvectormap-1.2.2.css">
    <!-- ToDos  -->
    <link rel="stylesheet" href="assets/plugins/todo/css/todos.css">
    <!-- Morris  -->
    <link rel="stylesheet" href="assets/plugins/morris/css/morris.css">
    <!-- Fonts -->
    <!-- <link href='http://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,600,700,900,300italic,400italic,600italic,700italic,900italic' rel='stylesheet' type='text/css'>
    <link href='http://fonts.googleapis.com/css?family=Open+Sans:400,700' rel='stylesheet' type='text/css'> -->
    <!-- Feature detection -->
    <script src="assets/js/modernizr-2.6.2.min.js"></script>
    <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
    <script src="assets/js/html5shiv.js"></script>
    <script src="assets/js/respond.min.js"></script>
    <![endif]-->
</head>

<body>
<section id="container">
    <header id="header">
        <!--logo start-->
        <div class="brand">
            <a href="index.jsp" class="logo">
                <span>Liao</span>Ba</a>
        </div>
        <!--logo end-->
        <div class="toggle-navigation toggle-left">
            <button type="button" class="btn btn-default" id="toggle-left" data-toggle="tooltip" data-placement="right"
                    title="Toggle Navigation">
                <i class="fa fa-bars"></i>
            </button>
        </div>
    </header>
    <!--sidebar left start-->
    <aside class="sidebar">
        <div id="leftside-navigation" class="nano">
            <ul class="nano-content">
                <li class="sub-menu">
                    <a href="javascript:void(0);"><i class="fa fa-table"></i><span>Tables</span><i
                            class="arrow fa fa-angle-right pull-right"></i></a>
                    <ul>
                        <li>
                            <a href="${pageContext.request.contextPath}/listall.do">Basic Info</a>
                        </li>
                       <%-- <li><a href="tables-basic-info.jsp">Basic Info</a>
                        </li>--%>
                        <li>
                            <a href="${pageContext.request.contextPath}/get_all_chat_log.do">Chat Log</a>
                        </li>
                    </ul>
                </li>
                <li class="sub-menu">
                    <a href="${pageContext.request.contextPath}/get_all_suggest.do"><i class="fa fa-text-height"></i><span>Feedback</span></a>
                </li>
                <li class="sub-menu">
                    <a href="javascript:void(0);"><i class="fa fa-file"></i><span>Pages</span><i
                            class="arrow fa fa-angle-right pull-right"></i></a>
                    <ul>
                        <li><a href="pages-404.jsp">404</a>
                        </li>
                        <li><a href="pages-500.jsp">500</a>
                        </li>
                    </ul>
                </li>
            </ul>
        </div>

    </aside>
    <!--sidebar left end-->
    <!--main content start-->
    <section class="main-content-wrapper" >
        <section id="main-content">
            <p align="center">
                <span>聊吧后台管理页</span><br>
                    <span>ICP主体备案号： 鲁ICP备16004473号<br/>
    技术支持 @huangyuan_xuan</span>
            </p>
        </section>
    </section>
    <!--main content end-->

    <!--sidebar right end-->
</section>
<!--Global JS-->
<script src="assets/js/jquery-1.10.2.min.js"></script>
<script src="assets/plugins/bootstrap/js/bootstrap.min.js"></script>
<script src="assets/plugins/waypoints/waypoints.min.js"></script>
<script src="assets/js/application.js"></script>
<!--Page Level JS-->
<script src="assets/plugins/countTo/jquery.countTo.js"></script>
<script src="assets/plugins/weather/js/skycons.js"></script>
<!-- FlotCharts  -->
<script src="assets/plugins/flot/js/jquery.flot.min.js"></script>
<script src="assets/plugins/flot/js/jquery.flot.resize.min.js"></script>
<script src="assets/plugins/flot/js/jquery.flot.canvas.min.js"></script>
<script src="assets/plugins/flot/js/jquery.flot.image.min.js"></script>
<script src="assets/plugins/flot/js/jquery.flot.categories.min.js"></script>
<script src="assets/plugins/flot/js/jquery.flot.crosshair.min.js"></script>
<script src="assets/plugins/flot/js/jquery.flot.errorbars.min.js"></script>
<script src="assets/plugins/flot/js/jquery.flot.fillbetween.min.js"></script>
<script src="assets/plugins/flot/js/jquery.flot.navigate.min.js"></script>
<script src="assets/plugins/flot/js/jquery.flot.pie.min.js"></script>
<script src="assets/plugins/flot/js/jquery.flot.selection.min.js"></script>
<script src="assets/plugins/flot/js/jquery.flot.stack.min.js"></script>
<script src="assets/plugins/flot/js/jquery.flot.symbol.min.js"></script>
<script src="assets/plugins/flot/js/jquery.flot.threshold.min.js"></script>
<script src="assets/plugins/flot/js/jquery.colorhelpers.min.js"></script>
<script src="assets/plugins/flot/js/jquery.flot.time.min.js"></script>
<script src="assets/plugins/flot/js/jquery.flot.example.js"></script>
<!-- Morris  -->
<script src="assets/plugins/morris/js/morris.min.js"></script>
<script src="assets/plugins/morris/js/raphael.2.1.0.min.js"></script>
<!-- Vector Map  -->
<script src="assets/plugins/jvectormap/js/jquery-jvectormap-1.2.2.min.js"></script>
<script src="assets/plugins/jvectormap/js/jquery-jvectormap-world-mill-en.js"></script>
<!-- ToDo List  -->
<script src="assets/plugins/todo/js/todos.js"></script>
<!--Load these page level functions-->
<script>
    $(document).ready(function () {
        app.timer();
        app.map();
        app.weather();
        app.morrisPie();
    });
</script>

</body>

</html>
