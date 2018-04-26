<%--
  Created by IntelliJ IDEA.
  User: CHLaih
  Date: 2018/4/24
  Time: 15:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>添加</title>
</head>

<body>
<div style="margin: 15px;">
    <fieldset class="layui-elem-field layui-field-title" style="margin-top: 20px;">
        <legend>添加轮播图</legend>
    </fieldset>
    <form id="bannerAdd" action="" class="layui-form" type="post">
        <div class="layui-form-item">
            <label class="layui-form-label">上传图片</label>
            <input class="layui-upload-file" name="bannerPhoto" type="file">
            <img id="banner_upload" src="" alt=" " style="height: 100px;width: 100px">
            <input id="bannerPhoto" name="bannerPhoto" type="hidden">
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">状态</label>
            <div class="layui-input-block">
                        <input type="radio" name="bannerStatus" value="0" title="使用" checked="">
                        <input type="radio" name="bannerStatus" value="1" title="未使用" >
            </div>
        </div>
        <div class="layui-form-item">
            <div class="layui-inline">
                <label class="layui-form-label">顺序</label>
                <div class="layui-input-inline">
                    <input type="number" name="bannerOrder" lay-verify="number" autocomplete="off" class="layui-input"value="${activity.is_top}">
                </div>
            </div>
        </div>

        <div class="layui-form-item">
            <div class="layui-input-block">
                <button class="layui-btn" lay-filter="demo1" lay-submit="">立即提交</button>
                <button type="reset" class="layui-btn layui-btn-primary">重置</button>
            </div>
        </div>
    </form>
</div>
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
        //监听提交
        form.on('submit(demo1)', function(data){
            $.ajax({
                type:'post',
                async:false,
                url:"${pageContext.request.contextPath}/admin/banner/add",
                data:data.field,
                success:function (data){
                    layer.msg(data.msg, {
                        offset: '100px',
                        anim: 4
                    });
                    return false;
                }
            });
            return false;
        });
    });
</script>
</body>
</html>
