<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <title>Layout</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <meta name="apple-mobile-web-app-status-bar-style" content="black">
    <meta name="apple-mobile-web-app-capable" content="yes">
    <meta name="format-detection" content="telephone=no">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/layout/plugins/layui/css/layui.css" media="all" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/layout/plugins/font-awesome/css/font-awesome.min.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/layout/css/layout.css" media="all" />
</head>

<body>
<div class="layui-layout layui-layout-admin beg-layout-container">
    <div class="layui-header beg-layout-header">
        <div class="beg-layout-main beg-layout-logo">
            <img src="${pageContext.request.contextPath}/layout/images/logo.jpg" alt="" style="height: 65px;width: 140px">
        </div>
        <div class="beg-layout-main beg-layout-side-toggle">
            <i class="fa fa-bars" aria-hidden="true"></i>
        </div>
        <!--一级菜单-->
        <div class="beg-layout-main beg-layout-menu" id="menu">
            <ul class="layui-nav beg-layout-nav" lay-filter="">
                <li class="layui-nav-item">
                    <a href="javascript:;" data-module-id="1">
                        <i class="fa fa-shopping-bag" aria-hidden="true"></i>
                        <cite>其他管理</cite>
                    </a>
                </li>
                <li class="layui-nav-item">
                    <a href="javascript:void(0)" data-module-id="2">
                        <i class="fa fa-users" aria-hidden="true"></i>
                        <cite>用户管理</cite>
                    </a>
                </li>
                <li class="layui-nav-item">
                    <a href="javascript:;" data-module-id="3">
                        <i class="fa fa-plug" aria-hidden="true"></i>
                        <cite>产品管理</cite>
                    </a>
                </li>
            </ul>
        </div>

        <%--个人资料--%>
        <div class="beg-layout-main beg-layout-panel">
            <ul class="layui-nav beg-layout-nav" lay-filter="user">
                <li class="layui-nav-item">
                    <%--<a href="javascript:;" class="beg-layou-head">
                        <img src="${pageContext.request.contextPath}/layout/file/admin/${loginAdmin.adminPhoto}" />
                        <span>${loginAdmin.adminName}</span>
                    </a>--%>
                    <dl class="layui-nav-child">
                        <dd>
                            <a href="javascript:void(0)" data-tab="true" data-url='updateLoginAdminUI'>
                                <i class="fa fa-user-circle" aria-hidden="true"></i>
                                <cite>个人信息</cite>
                            </a>
                        </dd>
                        <dd>
                            <a href="javascript:void(0)" data-tab="true" data-url="editPasswordUI">
                                <i class="fa fa-gear" aria-hidden="true"></i>
                                <cite>更改密码</cite>
                            </a>
                        </dd>
                        <dd>
                            <a href="${pageContext.request.contextPath}/admin/logout">
                                <i class="fa fa-sign-out" aria-hidden="true"></i>
                                <cite>注销</cite>
                            </a>
                        </dd>
                    </dl>
                </li>
            </ul>
        </div>
    </div>

    <!--侧边导航栏-->
    <div class="layui-side beg-layout-side" id="side" lay-filter="side"></div>

    <!--内容区域-->
    <div class="layui-body beg-layout-body">
        <div class="layui-tab layui-tab-brief layout-nav-card" lay-filter="layout-tab" style="border: 0; margin: 0;box-shadow: none; height: 100%;">
            <ul class="layui-tab-title">
                <li class="layui-this">
                    <a href="javascript:;">
                        <i class="fa fa-dashboard" aria-hidden="true"></i>
                        <cite>控制面板</cite>
                    </a>
                </li>
            </ul>
            <div style="width: 41px;height: 41px;text-align: center;line-height: 41px;
						position: absolute;right: 10px;background-color: #ccc;top: 0;font-size: 18px; cursor: pointer;">
                <i class="fa fa-toggle-down" aria-hidden="true"></i>
            </div>
            <div class="layui-tab-content">
                <div class="layui-tab-item layui-show">
                    <%--<iframe src="${pageContext.request.contextPath}/admin/loginUI"></iframe>--%>
                </div>
            </div>
        </div>
    </div>

    <!--页脚-->
</div>
<script src="${pageContext.request.contextPath}/layout/plugins/layui/layui.js "></script>
<script src="${pageContext.request.contextPath}/layout/js/layout.js "></script>
<%--<script>
    layui.config({
        base: '${pageContext.request.contextPath}/layout/js/'
    }).use(['paging', 'code'], function() {
        layui.code();
        var $ = layui.jquery,
                paging = layui.paging();

        paging.init({
            url: '${pageContext.request.contextPath}/layout/datas/laytpl_laypage_data.json', //地址
            elem: '#con', //内容容器
            params: { //发送到服务端的参数
                t: Math.random(),
                action: 'GetXxx'
            },
            tempElem: '#conTemp', //模块容器
            pageConfig: { //分页参数配置
                elem: '#paged', //分页容器
                pageSize: 3 //分页大小
            },
            success: function() { //渲染成功的回调
                //alert('渲染成功');
            },
            fail: function(msg) { //获取数据失败的回调
                //alert('获取数据失败')
            },
            complate: function() { //完成的回调
                //alert('处理完成');
            },
        });
        //搜索
        $('#search').on('click', function() {
            var $this = $(this);
            var name = $this.prev('input[name=name]').val();
            if(name === '' || name.length === 0) {
                layer.msg('请输入关键字！');
                return;
            }
            //调用get方法获取数据
            paging.get({
                t: Math.random(),
                name: name //获取输入的关键字。
            });
        });
    });
</script>--%>
</body>

</html>