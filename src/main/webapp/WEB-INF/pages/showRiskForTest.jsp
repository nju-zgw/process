<%--
  Created by IntelliJ IDEA.
  User: WH
  Date: 2016/11/9
  Time: 20:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>所有风险条目</title>
</head>
<body>
风险信息如下：
<script src="<c:url value="/resources/js/jquery.js" />"></script>
<script>
    $(document).ready(function(){
        $.get("/getRisks", function (data) {
            document.write(JSON.stringify(data));
        })
    });
</script>
</body>
</html>
