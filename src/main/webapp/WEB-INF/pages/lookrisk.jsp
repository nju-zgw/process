<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2016/11/8
  Time: 22:27
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
      </ul>
      <!-- sidebar menu end-->
    </div>
  </aside>

  <section id="main-descript">
    <div class="col-lg-9 col-md-4 col-sm-4 col-md-offset-2 mb" style="position:relative;height:800px;top:85px">
      <div class="panel panel-default" style="height: 100%;">
        <div class="panel-heading">
          <p style="font-size:20px">风险条目</p>
        </div>
        <div class="panel-body" style="position:relative;left:3%;top:10px">

          <div class="form-group row">
            <label class="col-sm-6  col-sm-offset-4 control-label"
                   style=" position:relative;left:20px;font-size:20px;font-weight: bold;color:gray">代码写不完的风险</label>
          </div>
          <div class="form-group row">
            <label class="col-sm-1 col-sm-offset-1 ontrol-label" style="color:#ccc">项目名：</label>
            <div class="col-sm-2">
              <p>NBA数据分析系统</p>
            </div>
            <label class="col-sm-1 control-label " style="color:#ccc">提出人：</label>
            <div class="col-sm-1">
              <p>韩奇祺</p>
            </div>
            <label class="col-sm-1 control-label" style="color:#ccc">提出时间：</label>
            <div class="col-sm-2">
              <p>2016/11/8 23:06</p>
            </div>
          </div>
          <div class="form-group row">
          <label class="col-sm-1 col-sm-offset-1 control-label" style="color:#ccc">风险类别</label>
          <div class="col-sm-1">
            <p>进度风险</p>
          </div>
          <label class="col-sm-1 col-sm-offset-1 control-label" style="color:#ccc">风险概率</label>
          <div class="col-sm-1">
            <p>高</p>
          </div>
          <label class="col-sm-2 col-sm-1 control-label" style="color:#ccc">风险影响级别</label>
          <div class="col-sm-1">
            <p>中</p>
          </div>
          </div>
          <label class="control-label"
                 style="position:relative;font-size:19px;font-weight: bold;left:6%"> 风险状态：</label>
          <div class="form-group row" style="position:relative;top:15px">
            <label class="col-sm-1 col-sm-offset-1 control-label" style="color:#ccc">跟踪人数：</label>
            <div class="col-sm-1">
              <p>6</p>
            </div>
            <label class="col-sm-1 col-sm-offset-1 control-label" style="color:#ccc">当前状态：</label>
            <div class="col-sm-1">
              <p>跟踪中</p>
            </div>
            <label class="col-sm-1  control-label" style="color:#ccc">当前跟踪人：</label>
            <div class="col-sm-1">
              <p>张冠伟</p>
            </div>
          </div>
          <label class="control-label"
                 style="position:relative;font-size:19px;font-weight: bold;left:6%;top:15px">触发器详情：</label>
          <div class="form-group row" style="position:relative;top:30px">
            <label class="col-sm-1 col-sm-offset-1 control-label" style="color:#ccc">类型：</label>
            <div class="col-sm-1">
              <p>缺陷数</p>
            </div>
            <label class="col-sm-1 col-sm-offset-1 control-label" style="color:#ccc">事件类型：</label>
            <div class="col-sm-1">
              <p>全体人员</p>
            </div>
            <label class="col-sm-1  control-label" style="color:#ccc">阈值：</label>
            <div class="col-sm-1">
              <p><15</p>
            </div>
            <label class="col-sm-1  control-label" style="color:#ccc">期限：</label>
            <div class="col-sm-2">
              <p>2016/11/8 23:37</p>
            </div>
          </div>
          <label class="control-label"
                    style="position:relative;font-size:19px;font-weight: bold;left:6%;top:20px">风险描述</label>
          <div class="form-group row">
            <textarea class="col-sm-8" rows="10" cols="30" style="position:relative;left:9%;top:35px;height:245px">我是一个文本框。</textarea>
          </div>

          <button type="button" class="btn btn-round btn-info" style="position:relative;width:21%;left:34%;top:55px"
                  data-toggle="modal" data-target="#addStatus">添加状态</button>

        </div>
      </div>
    </div>
  </section>
  <div class="panel panel-default">

    <div class="col-md-9 col-md-offset-2 mb" style="position:relative;top:75px">

        <div class="col-md-13">
          <div class="content-panel">
            <h4><i class="fa fa-angle-right"></i>状态跟踪列表</h4>
            <hr>
            <table class="table">
              <thead>
              <tr>
                <th>跟踪时间</th>
                <th>风险描述</th>
                <th>状态</th>
                <th>跟踪人</th>
              </tr>
              </thead>
              <tbody>
              <tr>
                <td>2016/11/9 7:48</td>
                <td>尼玛写不完了</td>
                <td>跟踪中</td>
                <td>韩奇祺</td>
              </tr>
              <tr>
                <td>2016/11/9 7:48</td>
                <td>尼玛写不完了</td>
                <td>跟踪中</td>
                <td>韩奇祺</td>
              </tr>
              </tbody>
            </table>
          </div>
        </div>
    </div>
  </div>
</section>



</body>
</html>
