<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: CHLaih
  Date: 2018/4/25
  Time: 10:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修改轮播图</title>
</head>
<body>
<div style="margin: 15px;">
    <fieldset class="layui-elem-field layui-field-title" style="margin-top: 20px;">
        <legend>修改轮播图</legend>
    </fieldset>
    <form action="" class="layui-form" method="post">
        <input id="bannerId" name="bannerId" type="hidden" value="${banner.bannerId}"/>
        <div class="layui-form-item">
            <label class="layui-form-label">上传图片</label>
            <input class="layui-upload-file" name="bannerPhoto" type="file">
            <img id="banner_upload" src="${pageContext.request.contextPath}/layout/file/banner/${banner.bannerPhoto}" alt=" " style="height: 80px;width: 80px">
            <input id="bannerPhoto" name="bannerPhoto" type="hidden">
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">状态</label>
            <div class="layui-input-block">
            <c:if test="${banner.bannerState == 0}">
                <input type="radio" name="bannerStatus" value="0" title="使用" checked="">
                <input type="radio" name="bannerStatus" value="1" title="未使用" >
            </c:if>
                <c:if test="${banner.bannerState == 1}">
                    <input type="radio" name="bannerStatus" value="0" title="使用">
                    <input type="radio" name="bannerStatus" value="1" title="未使用"  checked="">
                </c:if>
            </div>
        </div>
        <div class="layui-form-item">
            <div class="layui-inline">
                <label class="layui-form-label">顺序</label>
                <div class="layui-input-inline">
                    <input type="number" name="bannerOrder" lay-verify="number" autocomplete="off" class="layui-input"value="${banner.bannerOrder}">
                </div>
            </div>
        </div>
        <div class="layui-form-item">
            <div class="layui-input-block">
                <button class="layui-btn" lay-submit="" lay-filter="demo1">立即提交</button>
            </div>
        </div>
    </form>
</div>
<script>
    layui.use(['form', 'jquery','upload'], function() {
        var $ = layui.jquery;
        var form = layui.form();
        var id = $('#bannerId').val();
        form.render();
        layui.upload({
            url: '${pageContext.request.contextPath}/admin/banner/updatePhoto?bannerId='+id
            ,before: function st(input){
                //返回的参数item，即为当前的input DOM对象
                console.log('文件上传中');
            }
            ,success: function(data){
                var url = '/layout/file/banner/'+data.msg;
                banner_upload.src = url;
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
        form.on('submit(demo1)', function(data){
            $.ajax({
                type:'post',
                async:false,
                url:"${pageContext.request.contextPath}/admin/banner/update",
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
