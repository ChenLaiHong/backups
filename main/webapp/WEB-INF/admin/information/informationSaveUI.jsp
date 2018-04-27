<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: CHLaih
  Date: 2018/4/26
  Time: 23:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>编辑信息</title>
    <meta charset="utf-8">
</head>

<body>
<div style="margin: 15px;">
    <fieldset class="layui-elem-field layui-field-title" style="margin-top: 20px;">
        <legend>编辑信息</legend>
    </fieldset>

    <form action="" class="layui-form" type="post">
        <input id="id" name="id" type="hidden" value="${information.id}">

        <div class="layui-form-item">
            <label class="layui-form-label">图片</label>
            <input class="layui-upload-file" name="photo" type="file">
            <img id="photo_upload" src="${pageContext.request.contextPath}/layout/file/information/${information.photo}" alt=" " style="height: 80px;width: 80px">
            <input id="photo" name="photo" value="${information.photo}" type="hidden" lay-verify="photo">
        </div>

        <div class="layui-form-item">
            <label class="layui-form-label">名称</label>
            <div class="layui-input-block">
                <input type="text" name="name" lay-verify="name" autocomplete="off" placeholder="请输入名称" class="layui-input" value="${information.name}">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">类目</label>
            <div class="layui-input-block">
                <input type="text" name="category" lay-verify="category" autocomplete="off" placeholder="请输入类目" class="layui-input" value="${information.category}">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">主体信息</label>
            <div class="layui-input-block">
                <input type="text" name="news" lay-verify="news" autocomplete="off" placeholder="请输入主体信息" class="layui-input" value="${information.news}">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">介绍</label>
            <div class="layui-input-block">
                <textarea  name="introduce" lay-verify="introduce" placeholder="请输入介绍" autocomplete="off" class="layui-textarea" >${information.introduce}</textarea>
            </div>
        </div>

        <div class="layui-form-item">
            <label class="layui-form-label">公众号图片</label>
            <input class="layui-upload-file"  name="publicPhoto" type="file">
            <img id="publicPhoto_upload" src="${pageContext.request.contextPath}/layout/file/information/${information.publicPhoto}" alt="" style="height: 80px;width: 80px">
            <input id="publicPhoto" name="publicPhoto" value="${information.publicPhoto}" type="hidden" lay-verify="publicPhoto">
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">状态</label>
            <div class="layui-input-block">
                <input type="radio" name="state" lay-verify="state" value="1" title="正在使用" <c:if test="${information.state ==1}"> checked</c:if> >
                 <input type="radio" name="state" lay-verify="state" value="0" title="未使用" <c:if test="${information.state ==0}"> checked</c:if> >
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

<script>
    layui.use(['element','form', 'jquery','upload','layer'], function() {
        var layer = layui.layer;
        var $ = layui.jquery;
        var form = layui.form();
        var id = $('#projectId').val();
        var element = layui.element();
        var $form = $('form');
        form.render();
        element.init(); //这样element对动态生成的元素才会重新有效
        layer.iframeSrc();
        layui.upload({
            url: '${pageContext.request.contextPath}/admin/information/updatePhoto?id='+id
            ,before: function st(input){
                //返回的参数item，即为当前的input DOM对象
                console.log('文件上传中');
            }
            ,success: function(data){
                photo_upload.src = '/layout/file/information/'+data.msg;
                photo.value = data.msg;
                layer.msg('上传成功', {
                    offset: '100px',
                    anim: 4
                });
                console.log('上传完毕');
            }
        });

        layui.upload({
            url: '${pageContext.request.contextPath}/admin/information/updatePublicPhoto?id='+id
            ,before: function st(input){
                //返回的参数item，即为当前的input DOM对象
                console.log('文件上传中');
            }
            ,success: function(data){
                publicPhoto_upload.src = '/layout/file/information/'+data.msg;
                publicPhoto.value = data.msg;
                layer.msg('上传成功', {
                    offset: '100px',
                    anim: 4
                });
                console.log('上传完毕');
            }
        });
        form.verify({
            name: function (value) {
                if (value.length <= 0) {
                    return '请填写名称';
                }
            },

            category: function (value) {
                if (value.length <= 0) {
                    return '请填写类目';
                }
            },
            photo: function (value) {
                if (value.length <= 0) {
                    return '请上传图片';
                }
            },
            publicPhoto: function (value) {
                if (value.length <= 0) {
                    return '请上传公众号图片';
                }
            },
            news: function (value) {
                if (value.length <= 0) {
                    return '请填写主体信息';
                }
            },
            introduce: function (value) {
                if (value.length <= 0) {
                    return '请填写介绍';
                }
                if (value.length >= 1000) {
                    return '详细介绍过长，请控制字数在1000个字符内';
                }
            }
        });
    });
    //监听提交
    form.on('submit(demo1)', function(data){
        $.ajax({
            type:'post',
            async:false,
            url:"${pageContext.request.contextPath}/admin/information/update",
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
</script>

</body>
</html>
