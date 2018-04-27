<%--
  Created by IntelliJ IDEA.
  User: CHLaih
  Date: 2018/4/26
  Time: 22:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>查看图片</title>
        <meta charset="utf-8">
        <meta name="renderer" content="webkit">
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
        <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
        <meta name="apple-mobile-web-app-status-bar-style" content="black">
        <meta name="apple-mobile-web-app-capable" content="yes">
        <meta name="format-detection" content="telephone=no">

        <link rel="stylesheet" href="${pageContext.request.contextPath}/layout/plugins/layui/css/layui.css" media="all" />
        <link rel="stylesheet" href="${pageContext.request.contextPath}/layout/css/global.css" media="all">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/layout/plugins/font-awesome/css/font-awesome.min.css">
    </head>

<body>
<div style="margin: 15px;">
    <fieldset class="layui-elem-field" id="event">
        <div class="layui-field-box">
            <table class="layui-table">
                <thead>
                <tr>
                    <th>图片</th>
                    <th>公众号图片</th>
                </tr>
                </thead>
                <tbody>
                <tr>
                    <td><img src="${pageContext.request.contextPath}/layout/file/information/${information.photo}" width="200px" height="150px"></td>
                    <td><img src="${pageContext.request.contextPath}/layout/file/information/${information.publicPhoto}" width="200px" height="150px"></td>
                </tr>
                </tbody>
            </table>
        </div>
    </fieldset>
</div>
<script type="text/javascript" src="${pageContext.request.contextPath}/layout/plugins/layui/layui.js"></script>
<script>
    layui.config({
        base: '${pageContext.request.contextPath}/layout/js/'
    }).use(['navbar', 'code'], function() {
        var navbar = layui.navbar(),
            layer = parent.layer === undefined ? layui.layer : parent.layer,
            $ = layui.jquery;
        layui.code();
        navbar.set({
            elem: '#nav',
            url: '${pageContext.request.contextPath}/layout/datas/nav.json',
            cached: true
        });
        navbar.render();
        navbar.on('click(demo)', function(data) {
            console.log(data.elem);
            console.log(data.field.title);
            console.log(data.field.icon);
            console.log(data.field.href);
            layer.msg(data.field.href);
        });
    });
</script>
</body>
</html>
