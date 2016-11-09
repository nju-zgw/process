<%--
  Created by IntelliJ IDEA.
  User: WH
  Date: 2016/11/7
  Time: 14:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" descript="width=device-width, initial-scale=1.0">
    <meta name="description" descript="">
    <meta name="author" descript="Dashboard">
    <meta name="keyword" descript="Dashboard, Bootstrap, Admin, Template, Theme, Responsive, Fluid, Retina">

    <title>DASHGUM - FREE Bootstrap Admin Template</title>

    <!-- Bootstrap core CSS -->
    <link href="<c:url value="/resources/css/bootstrap.css" />" rel="stylesheet">
    <!--external css-->
    <link href="<c:url value="/resources/font-awesome/css/font-awesome.css" />" rel="stylesheet"/>
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/zabuto_calendar.css" />">
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/js/gritter/css/jquery.gritter.css" />"/>
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/lineicons/style.css" />"/>

    <!-- Custom styles for this template -->
    <link href="<c:url value="/resources/css/style.css" />" rel="stylesheet">
    <link href="<c:url value="/resources/css/style-responsive.css" />" rel="stylesheet">

    <script src="<c:url  value="/resources/js/chart-master/Chart.js" />"></script>

    <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
    <script src="<c:url  value=" https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js" />"></script>
    <
    script
    src = "<c:url  value="
    https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js" />"></script>
    <![endif]-->
</head>

<body>

<section id="container">
    <!-- **********************************************************************************************************************************************************
    TOP BAR CONTENT & NOTIFICATIONS
    *********************************************************************************************************************************************************** -->
    <!--header start-->
    <header class="header black-bg">
        <div class="sidebar-toggle-box">
            <div class="fa fa-bars tooltips" data-placement="right" data-original-title="Toggle Navigation"></div>
        </div>
        <!--logo start-->
        <a href="index.html" class="logo"><b>软件项目风险管理系统</b></a>
        <!--logo end-->
        <div class="top-menu">
            <ul class="nav pull-right top-menu">
                <li><a class="logout" href="login.html">退出</a></li>
            </ul>
        </div>
    </header>
    <!--header end-->

    <!-- **********************************************************************************************************************************************************
    MAIN SIDEBAR MENU
    *********************************************************************************************************************************************************** -->
    <!--sidebar start-->
    <aside>
        <div id="sidebar" class="nav-collapse ">
            <!-- sidebar menu start-->
            <ul class="sidebar-menu" id="nav-accordion">

                <p class="centered"><a href="profile.html"><img src="/resources/img/ui-sam.jpg" class="img-circle"
                                                                width="60"></a></p>
                <h5 class="centered">用户名xyz</h5>

                <li class="mt">
                    <a class="active" href="index.html">
                        <i class="fa fa-dashboard"></i>
                        <span>风险列表</span>
                    </a>
                </li>

                <li class="sub-menu">
                    <a href="javascript:;">
                        <i class="fa fa-desktop"></i>
                        <span>创建风险</span>
                    </a>
                </li>

                <%--<li class="sub-menu">--%>
                    <%--<a href="javascript:;">--%>
                        <%--<i class="fa fa-cogs"></i>--%>
                        <%--<span>用户管理</span>--%>
                    <%--</a>--%>
                    <%--<ul class="sub">--%>
                        <%--<li><a href="calendar.html">编辑用户</a></li>--%>
                        <%--<li><a href="gallery.html">编辑角色</a></li>--%>
                        <%--<li><a href="todo_list.html">编辑风险</a></li>--%>
                    <%--</ul>--%>
                <%--</li>--%>


            </ul>
            <!-- sidebar menu end-->
        </div>
    </aside>
    <!--sidebar end-->

    <!-- **********************************************************************************************************************************************************
    MAIN CONTENT
    *********************************************************************************************************************************************************** -->
    <!--main descript start-->
    <section id="main-descript">
        <section class="wrapper">
            <div class="row">
                <div class="col-lg-9 main-chart">

                    <%--<div class="panel panel-success container" id="id_panel" style="position:relative;left:8%;top:30px;width:88%">--%>

                        <nav class="navbar navbar-default" role="navigation"
                             style="position:relative;left:14%;width:87%;top:-17px">
                            <div style="position:relative;left:2%">
                                <ul class="nav navbar-nav">
                                    <li class="active"><a href="#all" data-toggle="tab">所有风险</a></li>
                                    <li><a href="#mytodo" data-toggle="tab">我的待办</a></li>
                                    <li><a href="#mypro" data-toggle="tab">我提出的</a></li>
                                </ul>
                            </div>
                        </nav>

                        <%--<div class="row mtbox " style="position:relative;width: 100%;left:9%;top: -75px;" >--%>
                        <%--<div class="col-md-2 col-md-offset-2 box0">--%>
                        <%--<div class="box1">--%>
                        <%--<span class="li_lab"></span>--%>
                        <%--<h3>风险数:33</h3>--%>
                        <%--</div>--%>
                        <%--<p>风险数量</p>--%>
                        <%--</div>--%>
                        <%--<div class="col-md-2  box0">--%>
                        <%--<div class="box1">--%>
                        <%--<span class="li_params"></span>--%>
                        <%--<h3>风险级别：高</h3>--%>
                        <%--</div>--%>
                        <%--<p>风险级别</p>--%>
                        <%--</div>--%>
                        <%--<div class="col-md-2  box0">--%>
                        <%--<div class="box1">--%>
                        <%--<span class="li_user"></span>--%>
                        <%--<h3>用户数10</h3>--%>
                        <%--</div>--%>
                        <%--<p>用户数量</p>--%>
                        <%--</div>--%>
                        <%--</div><!-- /row mt -->--%>
                        <div id="myTabContent" class="tab-content">

                            <div class="tab-pane fade in active" id="all">

                                <div class="row mt" style="position:relative;">
                                    <!--col-md-4 mb starts-->
                                    <div class="col-md-8 col-md-offset-3 mb">
                                        <!-- WHITE PANEL - TOP USER -->
                                        <div class="white-panel pn" style="height:20%">
                                            <div class="white-header">
                                                <h5> 糖果屋项目</h5>
                                            </div>
                                            <div class="row">
                                                <div class="col-md-3">
                                                    <p class="mt">风险类别：性能风险</p>
                                                </div>
                                                <div class="col-md-3">
                                                    <p class="mt">风险严重性：高</p>
                                                </div>
                                                <div class="col-md-3">
                                                    <p class="mt">风险状态：跟踪中</p>
                                                </div>
                                                <div class="col-md-3">
                                                    <p class="mt">关注人数：6</p>
                                                </div>
                                            </div>

                                            <button type="button" class="btn btn-round btn-info"
                                                    style="position:relative;width:6%;left:40%;top:40px">查看
                                            </button>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <!-- /row -->
                            <div class="tab-pane fade" id="mytodo">

                                <div class="row mt" style="position:relative;">
                                    <!--col-md-4 mb starts-->
                                    <div class="col-md-8 col-md-offset-3 mb">
                                        <!-- WHITE PANEL - TOP USER -->
                                        <div class="white-panel pn" style="height:20%">
                                            <div class="white-header">
                                                <h5> 糖果屋项目aa</h5>
                                            </div>
                                            <div class="row">
                                                <div class="col-md-3">
                                                    <p class="mt">风险类别：性能风险</p>
                                                </div>
                                                <div class="col-md-3">
                                                    <p class="mt">风险严重性：高</p>
                                                </div>
                                                <div class="col-md-3">
                                                    <p class="mt">风险状态：跟踪中</p>
                                                </div>
                                                <div class="col-md-3">
                                                    <p class="mt">关注人数：6</p>
                                                </div>
                                            </div>

                                            <button type="button" class="btn btn-round btn-info"
                                                    style="position:relative;width:6%;left:40%;top:40px">查看
                                            </button>
                                        </div>
                                    </div>
                                </div>
                            </div>

                            <div class="tab-pane fade" id="mypro">

                                <div class="row mt" style="position:relative;">
                                    <!--col-md-4 mb starts-->
                                    <div class="col-md-8 col-md-offset-3 mb">
                                        <!-- WHITE PANEL - TOP USER -->
                                        <div class="white-panel pn" style="height:20%">
                                            <div class="white-header">
                                                <h5> 糖果屋项目aa</h5>
                                            </div>
                                            <div class="row">
                                                <div class="col-md-3">
                                                    <p class="mt">风险类别：性能风险</p>
                                                </div>
                                                <div class="col-md-3">
                                                    <p class="mt">风险严重性：高</p>
                                                </div>
                                                <div class="col-md-3">
                                                    <p class="mt">风险状态：跟踪中</p>
                                                </div>
                                                <div class="col-md-3">
                                                    <p class="mt">关注人数：6</p>
                                                </div>
                                            </div>

                                            <button type="button" class="btn btn-round btn-info"
                                                    style="position:relative;width:6%;left:40%;top:40px">查看
                                            </button>
                                        </div>
                                    </div>
                                </div>
                            </div>



                        </div>

                        <div class="row mt" style="position:relative;">
                            <%@ include file="riskStatus/addRiskStatus.jsp" %>
                        </div>

                        <!-- /row -->
                    </div>
                <%--</div>--%>
                <!-- /col-lg-9 END SECTION MIDDLE -->


                <!-- **********************************************************************************************************************************************************
                RIGHT SIDEBAR CONTENT
                *********************************************************************************************************************************************************** -->

                <div class="col-lg-3 ds">
                    <!--COMPLETED ACTIONS DONUTS CHART-->
                    <h3>通知</h3>

                    <!-- First Action -->
                    <div class="desc">
                        <div class="thumb">
                            <span class="badge bg-theme"><i class="fa fa-clock-o"></i></span>
                        </div>
                        <div class="details" style="position: relative;left:15%;top:-19px;width:200%">
                            <p>
                                <muted>2 分钟前</muted>
                                <br/>
                                <a href="#">糖果屋项目</a>风险正在跟进中.<a href="#">张冠炜</a>更新了新的风险状态<br/>

                            </p>
                        </div>
                    </div>
                    <div class="desc">
                        <div class="thumb">
                            <span class="badge bg-theme"><i class="fa fa-clock-o"></i></span>
                        </div>
                        <div class="details" style="position: relative;left:15%;top:-19px;width:200%">
                            <p>
                                <muted>2 分钟前</muted>
                                <br/>
                                <a href="#">糖果屋项目</a>风险正在跟进中.<a href="#">张冠炜</a>更新了新的风险状态<br/>

                            </p>
                        </div>
                    </div>
                    <div class="desc">
                        <div class="thumb">
                            <span class="badge bg-theme"><i class="fa fa-clock-o"></i></span>
                        </div>
                        <div class="details" style="position: relative;left:15%;top:-19px;width:200%">
                            <p>
                                <muted>2 分钟前</muted>
                                <br/>
                                <a href="#">糖果屋项目</a>风险正在跟进中.<a href="#">张冠炜</a>更新了新的风险状态<br/>

                            </p>
                        </div>
                    </div>

                </div>
                <!-- /col-lg-3 -->
            </div>
            <! --/row -->


        </section>
    </section>

    <!--main descript end-->
    <!--footer start-->
    <%--<footer class="site-footer">--%>
    <%--<div class="text-center">--%>
    <%--2014 - Alvarez.is--%>
    <%--<a href="index.html#" class="go-top">--%>
    <%--<i class="fa fa-angle-up"></i>--%>
    <%--</a>--%>
    <%--</div>--%>
    <%--</footer>--%>
    <!--footer end-->
</section>

<!-- js placed at the end of the document so the pages load faster -->
<script src="<c:url value="/resources/js/jquery.js"/>"></script>
<script src="<c:url value="/resources/js/jquery-1.8.3.min.js"/>"></script>
<script src="<c:url value="/resources/js/bootstrap.min.js"/>"></script>
<script class="include" type="text/javascript" src="<c:url
        value="/resources/js/jquery.dcjqaccordion.2.7.js"/>"></script>
<script src="<c:url value="/resources/js/jquery.scrollTo.min.js"/>"></script>
<script src="<c:url value="/resources/js/jquery.nicescroll.js/"/>" type="text/javascript"></script>
<script src="<c:url value="/resources/js/jquery.sparkline.js"/>"></script>


<!--common script for all pages-->
<script src="<c:url value="/resources/js/common-scripts.js"/>></script>
    <script type=" text
/javascript" src="<c:url value="/resources/js/gritter/js/jquery.gritter.js"/>" > </script>
<
script
type = "text/javascript"
src = "<c:url value="/resources/js/gritter-conf.js"/>" </script>

<!--script for this page-->
<script src="<c:url value="/resources/js/sparkline-chart.js"/>"></script>
<script src="<c:url value="/resources/js/zabuto_calendar.js"/>"></script>


<script type="text/javascript">
    $(document).ready(function () {

    });
</script>

<script type="application/javascript">
    $(document).ready(function () {
        $("#date-popover").popover({html: true, trigger: "manual"});
        $("#date-popover").hide();
        $("#date-popover").click(function (e) {
            $(this).hide();
        });

        $("#my-calendar").zabuto_calendar({
            action: function () {
                return myDateFunction(this.id, false);
            },
            action_nav: function () {
                return myNavFunction(this.id);
            },
            ajax: {
                url: "show_data.php?action=1",
                modal: true
            },
            legend: [
                {type: "text", label: "Special event", badge: "00"},
                {type: "block", label: "Regular event",}
            ]
        });
    });


    function myNavFunction(id) {
        $("#date-popover").hide();
        var nav = $("#" + id).data("navigation");
        var to = $("#" + id).data("to");
        console.log('nav ' + nav + ' to: ' + to.month + '/' + to.year);
    }
</script>


</body>
</html>
