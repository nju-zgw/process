<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2016/11/8 0008
  Time: 下午 7:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.Date" %>
<%
    SimpleDateFormat simpledateformat = new SimpleDateFormat("yyyy-MM-dd");
    java.util.Date date = new Date();
%>
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

    <script src="<c:url value="/resources/js/jquery.js" />"></script>
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


    <aside>
        <div id="sidebar" class="nav-collapse ">
            <!-- sidebar menu start-->
            <ul class="sidebar-menu" id="nav-accordion">

                <h5 class="centered">用户名:${username}</h5>

                <li class="mt">
                    <a href="<%=request.getContextPath()%>/allRisks">
                        <i class="fa fa-dashboard"></i>
                        <span>风险列表</span>
                    </a>
                </li>

                <li class="sub-menu">
                    <a class="active" href="<%=request.getContextPath()%>/createRisk">
                        <i class="fa fa-desktop"></i>
                        <span>创建风险</span>
                    </a>
                </li>

            </ul>
        </div>
    </aside>

    <section id="main-descript">
        <div class="col-lg-9 col-md-4 col-sm-4 col-md-offset-2 mb" style="position:relative;height:850px;top:85px">
            <div class="panel panel-default" style="height: 100%;">
                <div class="panel-heading">
                    <p style="font-size:20px">创建风险</p>
                </div>
                <div class="panel-body" style="position:relative;left:25%;top:10px">

                    <form id="riskForm">
                        <div class="form-group row">
                            <label class="col-sm-2 col-sm-2 control-label">风险名</label>

                            <div class="col-sm-4">
                                <input id="riskName" type="text" name="riskName" class="form-control"
                                       style="width:50%;height:4%" required="required">
                            </div>
                        </div>
                        <div class="form-group row">
                            <label class="col-sm-2 col-sm-2 control-label">项目</label>

                            <div class="col-sm-10">
                                <select class="form-group" name="projectId" id="projectId">
                                    <c:forEach items="${projects}" var="item" >
                                        <option value="${item.pid}"><c:out value="${item.name}"/></option>
                                    </c:forEach>
                                </select>
                            </div>
                        </div>
                        <div class="form-group row">
                            <label class="col-sm-2 col-sm-2 control-label">风险类别</label>

                            <div class="col-sm-10">
                                <select class="form-group" name="riskTypeId" id="riskTypeId">
                                    <option value="1">性能风险</option>
                                    <option value="2">进度风险</option>
                                    <option value="3">成本风险</option>
                                </select>
                            </div>
                        </div>
                        <div class="form-group row">
                            <label class="col-sm-2 col-sm-2 control-label">风险概率</label>

                            <div class="col-sm-10">
                                <select class="form-group" name="riskProb" id="riskProb">
                                    <option value="3">高</option>
                                    <option value="2">中</option>
                                    <option value="1">低</option>
                                </select>
                            </div>
                        </div>
                        <div class="form-group row">
                            <label class="col-sm-2 col-sm-2 control-label">风险影响程度</label>

                            <div class="col-sm-10">
                                <select class="form-group" name="riskAffect" id="riskAffect">
                                    <option value="3">高</option>
                                    <option value="2">中</option>
                                    <option value="1">低</option>
                                </select>
                            </div>
                        </div>
                        <div class="form-group row">
                            <label class="col-sm-2 col-sm-2 control-label">风险描述</label>
                            <textarea class="col-sm-6" rows="10" cols="30"
                                      style="position:relative;left:10px" name="descript" id="descript"
                                      placeholder="请输入风险描述" required="required"></textarea>
                        </div>
                        <div class="form-group row">
                            <label class="col-sm-2 col-sm-2 control-label">触发器类别</label>

                            <div class="col-sm-10">
                                <select class="form-group" name="triggerType" id="triggerType">
                                    <option value="0">进度</option>
                                    <option value="1">缺陷</option>
                                </select>
                            </div>
                        </div>
                        <div class="form-group row">
                            <label class="col-sm-2 control-label">阈值</label>

                            <div class="col-sm-1">
                                <select class="form-group" style="width:60%;height:3%" name="valueType" id="valueType">
                                    <option value="0"> <</option>
                                    <option value="1"> =</option>
                                    <option value="2"> ></option>
                                </select>
                            </div>
                            <div class="col-sm-2">
                                <input type="text" class="form-control" name="value"
                                       style="position:relative;width:50%;height:3%;left:-20%" id="value" required="required">
                            </div>
                        </div>
                        <div class="form-group row">
                            <label class="col-sm-2 control-label">事件</label>

                            <div class="col-sm-6">
                                <select class="form-group" name="eventType" id="eventType">
                                    <option value="0">通知项目所有成员</option>
                                    <option value="1">通知风险追踪者</option>
                                    <option value="2">通知项目经理</option>
                                </select>
                            </div>
                        </div>
                        <div class="form-group row">
                            <label class="col-sm-2 control-label">触发时间</label>

                            <div class="col-sm-6">
                                <input type="date" class="form-control" name="time" id="time"
                                       value="<%= simpledateformat.format(date)%>" required="required">

                            </div>
                        </div>
                        <input type="button" class="btn btn-round btn-info"
                               style="position:relative;width:9%;left:15%;top:40px" value="提交" onclick="addRisk()">
                        </input>
                    </form>

                </div>
            </div>
        </div>
    </section>

</section>

<script>

    // ajax example
    var addRisk = function () {
        var param = {
            riskName: $('#riskName').val(),
            projectId: $('#projectId').val(),
            riskTypeId: $('#riskTypeId').val(),
            descript: $('#descript').val(),
            riskProb: $('#riskProb').val(),
            riskAffect: $('#riskAffect').val(),
            triggerType: $('#triggerType').val(),
            valueType: $('#valueType').val(),
            value: $('#value').val(),
            eventType: $('#eventType').val(),
            time: $('#time').val()
        };
        for(var k in param){
            if(!param[k]){
                alert('请填写所有字段');
                return;
            }
        }

        $.post(
                "<%=request.getContextPath()%>/addRisk",
                param,
                function (data, status) {
                    if (status === 'success') {
                        location.href = '<%=request.getContextPath()%>/allRisks';
                    } else {
                        alert(data);
                    }
                }, "text"
        );
    };

</script>
</body>
</html>
