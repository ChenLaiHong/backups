<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>

<head>
    <title>深爱保管理</title>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/layout/plugins/layui/css/layui.css" media="all" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/layout/css/global.css" media="all">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/layout/plugins/font-awesome/css/font-awesome.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/layout/css/table.css" />
</head>

<body>
<div class="admin-main">

    <blockquote class="layui-elem-quote">
        <a href="javascript:void(0)" class="layui-btn layui-btn-small" id="addInfor">
            <i class="layui-icon">&#xe608;</i> 添加信息
        </a>
        <div class="layui-input-inline">
            <form action="" class="layui-form">
                <div class="layui-input-inline">
                    <input name="searchValue" id="searchValue" placeholder="请输入查询内容" autocomplete="off" class="layui-input" type="text">
                </div>
                <div class="layui-input-inline">
                    <button type="submit" class="layui-btn layui-btn-small" lay-filter="inforSearch" lay-submit="">
                        <i class="layui-icon">&#xe615;</i> 搜索
                    </button>
                </div>
            </form>
        </div>
        <a href="" class="layui-btn layui-btn-small" id="refresh">
            <i class="layui-icon">&#x1002;</i> 刷新
        </a>
    </blockquote>
    <fieldset class="layui-elem-field">
        <legend>数据列表</legend>
        <div class="layui-field-box">
            <table class="site-table table-hover" id="inforTable">
                <thead>
                <tr>
                    <th>名称</th>
                    <th>类目</th>
                    <th>主体信息</th>
                    <th>介绍</th>
                    <th>爱保图片</th>
                    <th>公众号图片</th>
                    <th>状态</th>
                    <th>操作</th>
                </tr>
                </thead>
                <tbody id="inforData">
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
<script type="text/javascript" src="${pageContext.request.contextPath}/layout/plugins/layui/lay/dest/layui.all.js"></script>
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

        <!--分页开始-->
        var row = 4;       //一页多少行
        var rowData = 8;   //每行出现的数据量
        var nums = rowData * row; //每页出现的数据量
        var length = Math.ceil('${count}'/row);
        var htmlData = 'inforData';

        laypage({
            cont: 'page',
            pages: length,//得到总页数
            skip:true,
            jump: function(obj, first) {
                //得到了当前页，用于向服务端请求对应数据
                if(!first){
                    $.ajax({
                        type:'post',
                        async:true,
                        url:"${pageContext.request.contextPath}/admin/information/list",
                        data:{"num":nums/rowData,"curr":obj.curr-1},
                        dataType: "json",
                        success:function (data){
                            document.getElementById(htmlData).innerHTML = render(data, obj.curr,'1');
                        }
                    });
                }else {
                    //第一页
                    $.ajax({
                        type:'post',
                        async:true,
                        url:"${pageContext.request.contextPath}/admin/information/list",
                        data:{"num":nums/rowData,"curr":obj.curr-1},
                        dataType: "json",
                        success:function (data){
                            document.getElementById(htmlData).innerHTML = render(data, 0,'1');
                        }
                    });
                }
            }
        });
        //异步模拟渲染
        var render = function(data, curr,choose){
            var dataObj = data; //返回的result为json格式的数据
            var dataArray = [];
            for(var i=0,j=dataObj.length;i<j;i++){
                dataArray.push(dataObj[i].name);
                dataArray.push(dataObj[i].category);
                dataArray.push(dataObj[i].news);
                dataArray.push(dataObj[i].introduce);
                if (dataObj[i].photo != ''){
                    dataArray.push('<i class="layui-icon">&#xe618;</i>');
                }else {
                    dataArray.push('');
                }
                if (dataObj[i].publicPhoto != ''){
                    dataArray.push('<i class="layui-icon">&#xe618;</i>');
                }else {
                    dataArray.push('');
                }
                if (dataObj[i].state == '1'){
                    dataArray.push('正在使用');
                }else{
                    dataArray.push('未使用');
                }
                dataArray.push(dataObj[i].id);
            }
            if (choose == '1'){
                var arr = [],
                    thisData = dataArray.concat().splice(0,nums);
            }else if (choose == '2'){
                var arr = [],
                    thisData = dataArray.concat().splice(curr*nums-nums,nums);
            }
            layui.each(thisData, function(index, item){
                if(index % rowData == 0 || index % rowData == rowData){
                    arr.push('<tr></tr>');
                }
                if((index+1) % rowData == 0 || (index+1) % rowData == rowData){
                    arr.push('<td> ' +
                        '<a href="javascript:void(0)"  id="'+item+'" class="layui-btn-normal layui-btn detail-row">图</a> ' +
                        '<a href="javascript:void(0)"  id="'+item+'" class="layui-btn-normal layui-btn update-row">  编辑  </a> ' +
                        '<a href="javascript:void(0)"  id="'+item+'" data-id="1" data-opt="del" class="layui-btn layui-btn-danger delete-delete">删除</a> ' +
                        '</td>')
                }else{
                    arr.push('<td>'+ item +'</td>');
                }

            });
            return arr.join('');
        };
        <!--分页结束-->

        <!--搜索开始-->
        form.on('submit(inforSearch)',function (data) {
            $.ajax({
                type:'post',
                async:true,
                url:"${pageContext.request.contextPath}/admin/information/search",
                data:data.field,
                dataType: "json",
                success:function (data){
                    if (data == '0'){
                        location.reload();
                    }
                    laypage({
                        cont: 'page',
                        pages: Math.ceil(data.length/row),//得到总页数
                        skip:true,
                        jump: function(obj, first) {
                            document.getElementById(htmlData).innerHTML = render(data, obj.curr,'2');
                        }
                    });
                    return false;
                }
            });
            return false;
        });
        <!--搜索结束-->

        $('#addInfor').on('click', function() {
            $.get('${pageContext.request.contextPath}/admin/information/addUI', null, function(form) {
                layer.open({
                    type: 1,
                    title: '添加信息',
                    content: form,
                    area: ['40%','90%'],
                    maxmin: true,
                    end: function() {
                        location.reload();
                    },
                    yes: function(index) {
                        console.log(index);
                    },
                    full: function(elem) {
                        var win = window.top === window.self ? window : parent.window;
                        $(win).on('resize', function() {
                            var $this = $(this);
                            elem.width($this.width()).height($this.height()).css({
                                top: 0,
                                left: 0
                            });
                            elem.children('div.layui-layer-content').height($this.height() - 95);
                        });
                    }
                });
            });
        });

        $('#inforTable').on('click', 'a.update-row',function() {
            var id =$(this).attr("id");
            $.get('${pageContext.request.contextPath}/admin/information/updateUI', {"id" :id}, function(form) {
                layer.open({
                    type: 1,
                    title: '编辑信息',
                    content: form,
                    area: ['40%','90%'],
                    maxmin: true,
                    end: function() {
                        location.reload();
                    },
                    yes: function(index) {
                        console.log(index);
                    },
                    full: function(elem) {
                        var win = window.top === window.self ? window : parent.window;
                        $(win).on('resize', function() {
                            var $this = $(this);
                            elem.width($this.width()).height($this.height()).css({
                                top: 0,
                                left: 0
                            });
                            elem.children('div.layui-layer-content').height($this.height() - 95);
                        });
                    }
                });
            });
        });

        $('#inforTable').on('click', 'a.delete-delete',function() {
            var id =$(this).attr("id");
            $.ajax({
                type:'post',
                async:false,
                url:"${pageContext.request.contextPath}/admin/information/delete",
                data:{"id":id},
                success:function (data){
                    layer.msg(data.msg, {
                        offset: '100px',
                        anim: 4
                    });
                    location.reload();
                    return false;
                }
            });
        });

        $('#inforTable').on('click', 'a.detail-row',function() {
            var id =$(this).attr("id");
            $.get('${pageContext.request.contextPath}/admin/information/detail', {"id" :id}, function(form) {
                layer.open({
                    type: 1,
                    title: '图片信息',
                    content: form,
                    area: ['40%','50%'],
                    maxmin: true,
                   /* end: function() {
                        location.reload();
                    },*/
                    yes: function(index) {
                        console.log(index);
                    },
                    full: function(elem) {
                        var win = window.top === window.self ? window : parent.window;
                        $(win).on('resize', function() {
                            var $this = $(this);
                            elem.width($this.width()).height($this.height()).css({
                                top: 0,
                                left: 0
                            });
                            elem.children('div.layui-layer-content').height($this.height() - 95);
                        });
                    }
                });
            });
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