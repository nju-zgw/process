<%--
  Created by IntelliJ IDEA.
  User: zgw
  Date: 2016/11/8
  Time: 23:57
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<button class="btn btn-primary btn-lg" data-toggle="modal" data-target="#addStatus">新增状态</button>

<div class="modal fade" id="addStatus" role="dialog" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
                <h4 class="modal-title" id="myModalLabel">新增风险状态</h4>
            </div>
            <div class="modal-body">

                <%--<div class="form-group row">--%>
                <%--<label class="text-right col-sm-2 control-label">风险名称</label>--%>

                <%--<div class="col-sm-10">--%>
                <%--<span class="form-group"> 名字 </span>--%>
                <%--</div>--%>
                <%--</div>--%>
                <div class="form-group row">
                    <label class="text-right col-sm-2  control-label"> 分配</label>

                    <div class="col-sm-10">
                        <select class="form-group">
                            <option>无</option>
                            <option>王昊</option>
                            <option>张冠炜</option>
                            <option>韩77</option>
                            <option>袁睿</option>
                        </select>
                    </div>
                </div>

                <div class="form-group row">
                    <label class="text-right col-sm-2  control-label">状态</label>

                    <div class="col-sm-10">
                        <select class="form-group">
                            <option>跟踪中</option>
                            <option>准备跟踪</option>
                            <option>已解决</option>
                        </select>
                    </div>
                </div>
                <div class="form-group row">
                    <label class="text-right col-sm-2  control-label">内容描述</label>

                    <div class="col-sm-10">
                        <input type="text" class="form-control round-form">
                    </div>
                </div>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-primary" onclick = "addRisk()">提交</button>
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>

            </div>
        </div>
        <!-- /.modal-content -->
    </div>
    <!-- /.modal-dialog -->
</div>

<%--<script>--%>
<%--$(function () {--%>
<%--$('#addStatus').modal({--%>
<%--keyboard: true--%>
<%--})--%>
<%--});--%>
<%--</script>--%>
<script>

    // ajax example
    var addRisk = function () {
        $.post(
                '/addRisk',
                {projectId: 1, riskTypeId: 1, descript: '123', riskProb: 1, riskAffect: 2},
                function (status, data) {
                    alert(data);
                }, "text"
        );
    };

</script>