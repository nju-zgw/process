<%--
  Created by IntelliJ IDEA.
  User: WH
  Date: 2016/11/9
  Time: 14:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>增加风险</title>
</head>
<body>
<form id="riskForm" action="/addRisk" method="post">
    <h2>增加riskItem</h2>
    <div>

        <input type="text" name="projectId" placeholder="projectId" autofocus>
        <br/>
        <input type="text" name="riskTypeId"  placeholder="riskTypeId">
        <br/>
        <input type="text" name="descript"  placeholder="descript">
        <br/>
        <input type="text" name="riskProb"  placeholder="riskProb">
        <br/>
        <input type="text" name="riskAffect" placeholder="riskAffect">
        <br/>
        <input type="submit" name="submit">
        <hr>
    </div>

</form>
</body>
</html>
