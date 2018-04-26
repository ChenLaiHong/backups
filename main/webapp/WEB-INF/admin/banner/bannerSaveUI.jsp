<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: CHLaih
  Date: 2018/4/25
  Time: 14:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>编辑轮播图</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <meta name="apple-mobile-web-app-status-bar-style" content="black">
    <meta name="apple-mobile-web-app-capable" content="yes">
    <meta name="format-detection" content="telephone=no">

    <link rel="stylesheet" href="${pageContext.request.contextPath}/layout/plugins/layui/css/layui.css" media="all" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/layout/plugins/font-awesome/css/font-awesome.min.css">
</head>

<body>
<div style="margin: 35px;">
    <fieldset class="layui-elem-field layui-field-title" style="margin-top: 20px;">
        <legend>轮播图编辑</legend>
    </fieldset>

    <form class="layui-form" action="${pageContext.request.contextPath}/admin/banner${banner.bannerId == null ? '/add' : '/update' }" method="post" enctype="multipart/form-data">
<c:if test="${banner.bannerId != null}">
        <input id="bannerId" name="bannerId" type="hidden" value="${banner.bannerId}"/>
</c:if>
        <div class="layui-form-item">
            <label class="layui-form-label">图片</label>
            <input class="layui-upload-file" name="bannerPhoto" type="file">
            <img id="banner_upload" src="${pageContext.request.contextPath}/layout/file/banner/${banner.bannerPhoto}" alt=" " style="height: 100px;width: 100px">
            <input id="bannerPhoto" name="bannerPhoto" type="hidden" value="${banner.bannerPhoto}">
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">状态</label>
        <c:if test="${banner.bannerId == null}">
            <div class="layui-input-block">
                <input type="radio" name="bannerState" value="0" title="使用" checked="">
                <input type="radio" name="bannerState" value="1" title="未使用" >
            </div>
        </c:if>
            <c:if test="${banner.bannerId != null}">
                <div class="layui-input-block">
                    <c:if test="${banner.bannerState == 0}">
                        <input type="radio" name="bannerState" value="0" title="使用" checked="">
                        <input type="radio" name="bannerState" value="1" title="未使用" >
                    </c:if>
                    <c:if test="${banner.bannerState == 1}">
                        <input type="radio" name="bannerState" value="0" title="使用">
                        <input type="radio" name="bannerState" value="1" title="未使用"  checked="">
                    </c:if>
                </div>
            </c:if>

        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">顺序</label>
            <div class="layui-input-block">
                <div class="layui-input-inline">
                    <input type="number" name="bannerOrder" lay-verify="number" autocomplete="off" class="layui-input"value="${banner.bannerOrder}">
                </div>
            </div>
        </div>

        <div class="layui-form-item">
            <div class="layui-input-block">
                <button type="submit" class="layui-btn" lay-submit="" lay-filter="demo1">提交</button>
                <button type="reset" class="layui-btn layui-btn-primary">重置</button>
            </div>
        </div>
    </form>
</div>
<script type="text/javascript" src="${pageContext.request.contextPath}/layout/plugins/layui/layui.js"></script>

<script>
    layui.use(['element','form', 'jquery','upload','layer'], function() {
        var layer = layui.layer;
        var $ = layui.jquery;
        var form = layui.form();
        var id = $('#bannerId').val();
        var element = layui.element();
        element.init(); //这样element对动态生成的元素才会重新有效
        layui.upload({
            url: '${pageContext.request.contextPath}/admin/banner/updatePhoto?bannerId='+id
            ,before: function st(input){
                //返回的参数item，即为当前的input DOM对象
                console.log('文件上传中');
            }
            ,success: function(data){
                banner_upload.src = '/layout/file/banner/'+data.msg;
                bannerPhoto.value = data.msg;
                layer.msg('上传成功', {
                    offset: '100px',
                    anim: 4
                });
                console.log('上传完毕');
            }
        });
        form.verify({
            bannerOrder: [
                /^[+]{0,1}(\d+)$|^[+]{0,1}(\d+\.\d+)$/,
                '顺序必须为非负数'
            ]
        });
    });
</script>

</body>
</html>
