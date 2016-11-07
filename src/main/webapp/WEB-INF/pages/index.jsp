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
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="Dashboard">
    <meta name="keyword" content="Dashboard, Bootstrap, Admin, Template, Theme, Responsive, Fluid, Retina">

    <title>DASHGUM - FREE Bootstrap Admin Template</title>

    <!-- Bootstrap core CSS -->
    <link href="<c:url value="/resources/css/bootstrap.css" />" rel="stylesheet">
    <!--external css-->
    <link href="<c:url value="/resources/font-awesome/css/font-awesome.css" />" rel="stylesheet" />
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/zabuto_calendar.css" />">
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/js/gritter/css/jquery.gritter.css" />" />
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/lineicons/style.css" />" />

    <!-- Custom styles for this template -->
    <link href="<c:url value="/resources/css/style.css" />" rel="stylesheet">
    <link href="<c:url value="/resources/css/style-responsive.css" />" rel="stylesheet">

    <script src="<c:url  value="/resources/js/chart-master/Chart.js" />"></script>

    <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
    <script src="<c:url  value="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js" />"></script>
    <script src="<c:url  value="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js" />"></script>
    <![endif]-->
</head>

<body>

<section id="container" >
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
                <li><a class="logout" href="login.html">Logout</a></li>
            </ul>
        </div>
    </header>
    <!--header end-->

    <!-- **********************************************************************************************************************************************************
    MAIN SIDEBAR MENU
    *********************************************************************************************************************************************************** -->
    <!--sidebar start-->
    <aside>
        <div id="sidebar"  class="nav-collapse ">
            <!-- sidebar menu start-->
            <ul class="sidebar-menu" id="nav-accordion">

                <p class="centered"><a href="profile.html"><img src="/resources/img/ui-sam.jpg" class="img-circle" width="60"></a></p>
                <h5 class="centered">用户名xyz</h5>

                <li class="mt">
                    <a class="active" href="index.html">
                        <i class="fa fa-dashboard"></i>
                        <span>主页</span>
                    </a>
                </li>

                <li class="sub-menu">
                    <a href="javascript:;" >
                        <i class="fa fa-desktop"></i>
                        <span>风险管理</span>
                    </a>
                    <ul class="sub">
                        <li><a  href="general.html">新增风险</a></li>
                        <li><a  href="buttons.html">查看风险</a></li>
                        <!--<li><a  href="panels.html">风险</a></li>-->
                    </ul>
                </li>

                <li class="sub-menu">
                    <a href="javascript:;" >
                        <i class="fa fa-cogs"></i>
                        <span>用户管理</span>
                    </a>
                    <ul class="sub">
                        <li><a  href="calendar.html">编辑用户</a></li>
                        <li><a  href="gallery.html">编辑角色</a></li>
                        <li><a  href="todo_list.html">编辑风险</a></li>
                    </ul>
                </li>

                <li class="sub-menu">
                    <a href="javascript:;" >
                        <i class=" fa fa-bar-chart-o"></i>
                        <span>Charts</span>
                    </a>
                    <ul class="sub">
                        <li><a  href="morris.html">Morris</a></li>
                        <li><a  href="chartjs.html">Chartjs</a></li>
                    </ul>
                </li>

            </ul>
            <!-- sidebar menu end-->
        </div>
    </aside>
    <!--sidebar end-->

    <!-- **********************************************************************************************************************************************************
    MAIN CONTENT
    *********************************************************************************************************************************************************** -->
    <!--main content start-->
    <section id="main-content">
        <section class="wrapper">

            <div class="row">
                <div class="col-lg-9 main-chart">

                    <div class="row mtbox">
                        <div class="col-md-2 col-sm-2 col-md-offset-1 box0">
                            <div class="box1">
                                <span class="li_lab"></span>
                                <h3>33</h3>
                            </div>
                            <p>风险数量</p>
                        </div>
                        <div class="col-md-2 col-sm-2 box0">
                            <div class="box1">
                                <span class="li_params"></span>
                                <h3>高</h3>
                            </div>
                            <p>风险级别</p>
                        </div>
                        <div class="col-md-2 col-sm-2 box0">
                            <div class="box1">
                                <span class="li_clock"></span>
                                <h3>23</h3>
                            </div>
                            <p>事件措施</p>
                        </div>
                        <div class="col-md-2 col-sm-2 box0">
                            <div class="box1">
                                <span class="li_user"></span>
                                <h3>10</h3>
                            </div>
                            <p>用户数量</p>
                        </div>
                        <div class="col-md-2 col-sm-2 box0">
                            <div class="box1">
                                <span class="li_lock"></span>
                                <h3>6</h3>
                            </div>
                            <p>角色数量</p>
                        </div>

                    </div><!-- /row mt -->

                    <div class="row mt">
                        <!--col-md-4 mb starts-->
                        <div class="col-md-3 mb">
                            <!-- WHITE PANEL - TOP USER -->
                            <div class="white-panel pn">
                                <div class="white-header">
                                    <h5>TOP USER</h5>
                                </div>
                                <p><img src="/resources/img/ui-zac.jpg" class="img-circle" width="80"></p>
                                <p><b>Zac Snider</b></p>
                                <div class="row">
                                    <div class="col-md-6">
                                        <p class="small mt">MEMBER SINCE</p>
                                        <p>2012</p>
                                    </div>
                                    <div class="col-md-6">
                                        <p class="small mt">TOTAL SPEND</p>
                                        <p>$ 47,60</p>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <!--col-md-4 mb ends-->

                        <!--col-md-4 mb starts-->
                        <div class="col-md-3 mb">
                            <!-- WHITE PANEL - TOP USER -->
                            <div class="white-panel pn">
                                <div class="white-header">
                                    <h5>TOP USER</h5>
                                </div>
                                <p><img src="/resources/img/ui-zac.jpg" class="img-circle" width="80"></p>
                                <p><b>Zac Snider</b></p>
                                <div class="row">
                                    <div class="col-md-6">
                                        <p class="small mt">MEMBER SINCE</p>
                                        <p>2012</p>
                                    </div>
                                    <div class="col-md-6">
                                        <p class="small mt">TOTAL SPEND</p>
                                        <p>$ 47,60</p>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <!--col-md-4 mb ends-->

                        <!--col-md-4 mb starts-->
                        <div class="col-md-3 mb">
                            <!-- WHITE PANEL - TOP USER -->
                            <div class="white-panel pn">
                                <div class="white-header">
                                    <h5>TOP USER</h5>
                                </div>
                                <p><img src="/resources/img/ui-zac.jpg" class="img-circle" width="80"></p>
                                <p><b>Zac Snider</b></p>
                                <div class="row">
                                    <div class="col-md-6">
                                        <p class="small mt">MEMBER SINCE</p>
                                        <p>2012</p>
                                    </div>
                                    <div class="col-md-6">
                                        <p class="small mt">TOTAL SPEND</p>
                                        <p>$ 47,60</p>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <!--col-md-4 mb ends-->

                        <!--col-md-4 mb starts-->
                        <div class="col-md-3 mb">
                            <!-- WHITE PANEL - TOP USER -->
                            <div class="white-panel pn">
                                <div class="white-header">
                                    <h5>TOP USER</h5>
                                </div>
                                <p><img src="/resources/img/ui-zac.jpg" class="img-circle" width="80"></p>
                                <p><b>Zac Snider</b></p>
                                <div class="row">
                                    <div class="col-md-6">
                                        <p class="small mt">MEMBER SINCE</p>
                                        <p>2012</p>
                                    </div>
                                    <div class="col-md-6">
                                        <p class="small mt">TOTAL SPEND</p>
                                        <p>$ 47,60</p>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <!--col-md-4 mb ends-->

                    </div><!-- /row -->

                </div><!-- /col-lg-9 END SECTION MIDDLE -->


                <!-- **********************************************************************************************************************************************************
                RIGHT SIDEBAR CONTENT
                *********************************************************************************************************************************************************** -->

                <div class="col-lg-3 ds">
                    <!--COMPLETED ACTIONS DONUTS CHART-->
                    <h3>NOTIFICATIONS</h3>

                    <!-- First Action -->
                    <div class="desc">
                        <div class="thumb">
                            <span class="badge bg-theme"><i class="fa fa-clock-o"></i></span>
                        </div>
                        <div class="details">
                            <p><muted>2 Minutes Ago</muted><br/>
                                <a href="#">James Brown</a> subscribed to your newsletter.<br/>
                            </p>
                        </div>
                    </div>
                    <!-- Second Action -->
                    <div class="desc">
                        <div class="thumb">
                            <span class="badge bg-theme"><i class="fa fa-clock-o"></i></span>
                        </div>
                        <div class="details">
                            <p><muted>3 Hours Ago</muted><br/>
                                <a href="#">Diana Kennedy</a> purchased a year subscription.<br/>
                            </p>
                        </div>
                    </div>
                    <!-- Third Action -->
                    <div class="desc">
                        <div class="thumb">
                            <span class="badge bg-theme"><i class="fa fa-clock-o"></i></span>
                        </div>
                        <div class="details">
                            <p><muted>7 Hours Ago</muted><br/>
                                <a href="#">Brandon Page</a> purchased a year subscription.<br/>
                            </p>
                        </div>
                    </div>
                    <!-- Fourth Action -->
                    <div class="desc">
                        <div class="thumb">
                            <span class="badge bg-theme"><i class="fa fa-clock-o"></i></span>
                        </div>
                        <div class="details">
                            <p><muted>7 Hours Ago</muted><br/>
                                <a href="#">Brandon Page</a> purchased a year subscription.<br/>
                            </p>
                        </div>
                    </div>
                </div><!-- /col-lg-3 -->
            </div><! --/row -->
        </section>
    </section>

    <!--main content end-->
    <!--footer start-->
    <footer class="site-footer">
        <div class="text-center">
            2014 - Alvarez.is
            <a href="index.html#" class="go-top">
                <i class="fa fa-angle-up"></i>
            </a>
        </div>
    </footer>
    <!--footer end-->
</section>

<!-- js placed at the end of the document so the pages load faster -->
<script src="<c:url value="/resources/js/jquery.js" />"></script>
<script src="<c:url value="/resources/js/jquery-1.8.3.min.js" />"></script>
<script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
<script class="include" type="text/javascript" src="<c:url value="/resources/js/jquery.dcjqaccordion.2.7.js" />" ></script>
<script src="<c:url value="/resources/js/jquery.scrollTo.min.js" />"></script>
<script src="<c:url value="/resources/js/jquery.nicescroll.js/" />" type="text/javascript"></script>
<script src="<c:url value="/resources/js/jquery.sparkline.js" />" ></script>


<!--common script for all pages-->
<script src="<c:url value="/resources/js/common-scripts.js" />></script>
<script type="text/javascript" src="<c:url value="/resources/js/gritter/js/jquery.gritter.js" />" > </script>
<script type="text/javascript" src="<c:url value="/resources/js/gritter-conf.js" />" </script>

<!--script for this page-->
<script src="<c:url value="/resources/js/sparkline-chart.js" />" ></script>
<script src="<c:url value="/resources/js/zabuto_calendar.js" />" ></script>


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
                {type: "block", label: "Regular event", }
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
