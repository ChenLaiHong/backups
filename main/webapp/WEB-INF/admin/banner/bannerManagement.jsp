<%--
  Created by IntelliJ IDEA.
  User: CHLaih
  Date: 2018/4/24
  Time: 15:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
<head>
    <title>轮播图列表</title>
    <meta charset="UTF-8">

    <link rel="stylesheet" href="${pageContext.request.contextPath}/layout/plugins/layui/css/layui.css" media="all" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/layout/css/global.css" media="all">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/layout/plugins/font-awesome/css/font-awesome.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/layout/css/table.css" />
</head>

<body>
<div class="admin-main">

    <blockquote class="layui-elem-quote">
        <a href="${pageContext.request.contextPath}/admin/banner/addUI" class="layui-btn layui-btn-small">
            <i class="layui-icon">&#xe608;</i> 添加信息
        </a>
    </blockquote>
    <fieldset class="layui-elem-field">
        <legend>数据列表</legend>
        <div class="layui-field-box">
            <table class="site-table table-hover">
                <thead>
                <tr>
                    <th>图片</th>
                    <th>状态</th>
                    <th>顺序</th>
                    <th>操作</th>
                </tr>
                </thead>
                <tbody id="biuuu_city_list">
                </tbody>
            </table>

        </div>
    </fieldset>
    <div class="admin-table-page">
        <div id="page" class="page">
        </div>
    </div>
</div>
<script type="text/javascript" src="${pageContext.request.contextPath}/layout/plugins/layui/layui.js"></script>
<script>
    layui.config({
        base: '${pageContext.request.contextPath}/layout/plugins/layui/modules/'
    });

    layui.use(['icheck', 'laypage','layer','form'], function() {
        var $ = layui.jquery,
            laypage = layui.laypage,
            layer = parent.layer === undefined ? layui.layer : parent.layer;
        var form = layui.form();
        $('input').iCheck({
            checkboxClass: 'icheckbox_flat-green'
        });
        var data = [
            <c:forEach items="${requestScope.banner}" var="banner">
            '<img src="${pageContext.request.contextPath}/layout/file/banner/${banner.bannerPhoto}" width="100px" height="100px">',
            '${banner.bannerState}',
            '${banner.bannerOrder}',
            '<a href="${pageContext.request.contextPath}/admin/banner/detail?id=${banner.bannerId}" class="layui-btn">状态修改</a> ' +
            '<a href="${pageContext.request.contextPath}/admin/banner/updateUI?bannerId=${banner.bannerId}" class="layui-btn layui-btn-normal">编辑</a> '+
            '<a href="${pageContext.request.contextPath}/admin/banner/delete?bannerId=${banner.bannerId}" data-id="1" data-opt="del" class="layui-btn layui-btn-danger">删除</a>',
            </c:forEach>
        ];
        var nums = 12; //每页出现的数据量
        var length = ${requestScope.count}*4;

        //模拟渲染
        var render = function(data, curr){
            var arr = []
                ,thisData = data.concat().splice(curr*nums-nums, nums);
            layui.each(thisData, function(index, item){
                if(index % 4 == 0 || index % 4 == 4){
                    arr.push('<tr></tr>');
                }
                arr.push('<td>'+ item +'</td>');
            });
            return arr.join('');
        };

        //异步查询模拟渲染
        var render3 = function(data, curr){
            var arr = []
                ,thisData = data.concat().splice(curr*nums-nums, nums);
            layui.each(thisData, function(index, item){
                if(index % 4 == 0 || index % 4 == 4){
                    arr.push('<tr></tr>');
                }
                if((index+1) % 4 ==0 || (index+1) % 4 == 4){
                    arr.push('<td><a href="${pageContext.request.contextPath}/admin/banner/detail?id='+ item +'"class="layui-btn">状态修改</a>' +
                        ' <a href="${pageContext.request.contextPath}/admin/banner/updateUI?bannerId='+ item +'"class="layui-btn layui-btn-normal">编辑</a>' +
                        ' <a href="${pageContext.request.contextPath}/admin/banner/delete?bannerId='+ item +'"data-id="1" data-opt="del" class="layui-btn layui-btn-danger">删除</a></td>');
                }else{
                    arr.push('<td>'+ item +'</td>');
                }
            });
            return arr.join('');
        };

        //异步模拟渲染
        var render2 = function(data, curr){
            var arr = []
                ,thisData = data.concat().splice(0,nums);
            layui.each(thisData, function(index, item){
                if(index % 4 == 0 || index % 4 == 4){
                    arr.push('<tr></tr>');
                }
                if((index+1) % 4 ==0 || (index+1) % 4 == 4){
                    arr.push('<td><a href="${pageContext.request.contextPath}/admin/banner/detail?id='+ item +'"class="layui-btn">状态修改</a>' +
                        ' <a href="${pageContext.request.contextPath}/admin/banner/updateUI?bannerId='+ item +'"class="layui-btn layui-btn-normal">编辑</a>' +
                        ' <a href="${pageContext.request.contextPath}/admin/banner/delete?bannerId='+ item +'"data-id="1" data-opt="del" class="layui-btn layui-btn-danger">删除</a></td>');
                }else if (index % 4 ==0){
                    arr.push('<td><img src="${pageContext.request.contextPath}/layout/file/banner/'+ item +'" width="100px" height="100px"></td>');
                }else{
                    arr.push('<td>'+ item +'</td>');
                }

            });
            return arr.join('');
        };

        //page
        laypage({
            cont: 'page',
            pages: Math.ceil(length/nums),//得到总页数
            skip:true,
            jump: function(obj, first) {
                //得到了当前页，用于向服务端请求对应数据
                if(!first){
                    $.ajax({
                        type:'post',
                        async:true,
                        url:"${pageContext.request.contextPath}/admin/banner/asynList",
                        data:{"num":nums/4,"curr":obj.curr-1},
                        dataType: "json",
                        success:function (data){
                            var dataObj = data; //返回的result为json格式的数据
                            var dataArray = [];
                            for(var i=0,j=dataObj.length;i<j;i++){
                                dataArray.push(dataObj[i].bannerPhoto);
                                dataArray.push(dataObj[i].bannerState);
                                dataArray.push(dataObj[i].bannerOrder);
                                dataArray.push(dataObj[i].bannerId);
                            }
                            document.getElementById('biuuu_city_list').innerHTML = render2(dataArray, obj.curr);
                        }
                    });
                }else{
                    document.getElementById('biuuu_city_list').innerHTML = render(data, obj.curr);
                }
            }
        });




        $('#import').on('click', function() {
            var that = this;
            var index = layer.tips('只想提示地精准些', that,{tips: [1, 'white']});
            $('#layui-layer'+index).children('div.layui-layer-content').css('color','#000000');
        });

        $('.site-table tbody tr').on('click', function(event) {
            var $this = $(this);
            var $input = $this.children('td').eq(0).find('input');
            $input.on('ifChecked', function(e) {
                $this.css('background-color', '#EEEEEE');
            });
            $input.on('ifUnchecked', function(e) {
                $this.removeAttr('style');
            });
            $input.iCheck('toggle');
        }).find('input').each(function() {
            var $this = $(this);
            $this.on('ifChecked', function(e) {
                $this.parents('tr').css('background-color', '#EEEEEE');
            });
            $this.on('ifUnchecked', function(e) {
                $this.parents('tr').removeAttr('style');
            });
        });
        $('#selected-all').on('ifChanged', function(event) {
            var $input = $('.site-table tbody tr td').find('input');
            $input.iCheck(event.currentTarget.checked ? 'check' : 'uncheck');
        });
    });
</script>
</body>
</html>
