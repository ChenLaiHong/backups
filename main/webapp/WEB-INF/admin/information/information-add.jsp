<%--
  Created by IntelliJ IDEA.
  User: CHLaih
  Date: 2018/4/26
  Time: 8:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加信息</title>
</head>
<body>
<div style="margin: 15px;">
    <fieldset class="layui-elem-field layui-field-title" style="margin-top: 20px;">
        <legend>添加信息</legend>
    </fieldset>
    <form id="informationAdd" action="" class="layui-form" type="post">

        <div class="layui-form-item">
            <label class="layui-form-label">名称</label>
            <div class="layui-input-block">
                <input type="text" id="name" name="name" lay-verify="name" placeholder="请输入名称" autocomplete="off" class="layui-input">
            </div>
        </div>

        <div class="layui-form-item">
            <label class="layui-form-label">类目</label>
            <div class="layui-input-block">
                <input type="text" id="category" name="category" lay-verify="category" placeholder="请输入类目" autocomplete="off" class="layui-input">
            </div>
        </div>

        <div class="layui-form-item">
            <label class="layui-form-label">主体信息</label>
            <div class="layui-input-block">
                <input type="text" id="news" lay-verify="news" name="news" placeholder="请输入主体信息" autocomplete="off" class="layui-input">
            </div>
        </div>

        <div class="layui-form-item">
            <label class="layui-form-label">介绍</label>
            <div class="layui-input-block">
                <textarea id="introduce" name="introduce" lay-verify="introduce" placeholder="请输入介绍" autocomplete="off" class="layui-textarea"></textarea>
            </div>
        </div>

        <div class="layui-form-item">
            <label class="layui-form-label">图片</label>
            <input class="layui-upload-file" id="photo_up" name="photo" type="file">
            <img id="photo_upload" src="" alt=" " style="height: 50px;width: 50px">
            <input id="photo" name="photo" type="hidden" lay-verify="photo">
        </div>

        <div class="layui-form-item">
            <label class="layui-form-label">公众号图片</label>
            <input class="layui-upload-file" id="publicPhoto_up" name="publicPhoto" type="file">
            <img id="publicPhoto_upload" src="" alt=" " style="height: 50px;width: 50px">
            <input id="publicPhoto" name="publicPhoto" type="hidden" lay-verify="publicPhoto">
        </div>

        <div class="layui-form-item">
            <label class="layui-form-label">状态</label>
            <div class="layui-input-block">
                <input type="radio" name="state"  value="1" title="正在使用" checked>
                <input type="radio" name="state"  value="0" title="未使用">
            </div>
        </div>

        <div class="layui-form-item">
            <div class="layui-form-item">
                <div class="layui-input-block">
                    <button class="layui-btn" lay-filter="demo1" lay-submit="">立即提交</button>
                    <button type="reset" class="layui-btn layui-btn-primary">重置</button>
                </div>
            </div>
        </div>

    </form>
</div>
<script>
    layui.use(['element','form', 'jquery','upload','layer'], function() {
        var layer = layui.layer;
        var $ = layui.jquery;
        var form = layui.form();
        var id = $('#id').val();
        var element = layui.element();
        var $form = $('form');
        form.render();
        element.init(); //这样element对动态生成的元素才会重新有效
        layui.upload({
            url: '${pageContext.request.contextPath}/admin/information/updatePhoto?id='+id
            ,elem:'#photo_up'
            ,before: function st(input){
                //返回的参数item，即为当前的input DOM对象
                console.log('文件上传中');
            }
            ,success: function(data){
                if(data.success) {
                    photo_upload.src = '/layout/file/information/'+data.msg;
                    photo.value = data.msg;
                    layer.msg('上传成功', {
                        offset: '100px',
                        anim: 4
                    });
                } else {
                    layer.msg('上传失败', {
                        offset: '100px',
                        anim: 4
                    });
                }
                console.log('上传完毕');
            }
        });
        layui.upload({
            url: '${pageContext.request.contextPath}/admin/information/updatePublicPhoto?id='+id
            ,elem:'#publicPhoto_up'
            ,before: function st(input){
                //返回的参数item，即为当前的input DOM对象
                console.log('文件上传中');
            }
            ,success: function(data){
                if(data.success) {
                    publicPhoto_upload.src = '/layout/file/information/'+data.msg;
                    publicPhoto.value = data.msg;
                    layer.msg('上传成功', {
                        offset: '100px',
                        anim: 4
                    });
                } else {
                    layer.msg('上传失败', {
                        offset: '100px',
                        anim: 4
                    });
                }
                console.log('上传完毕');
            }
        });
        form.verify({
            name: function(value){
                if(value.length <= 0 ){
                    return '请填写名称';
                }
            },

            category: function(value){
                if(value.length <= 0 ){
                    return '请填写类目';
                }
            },
            photo: function(value){
                if(value.length <= 0 ){
                    return '请上传图片';
                }
            },
            publicPhoto: function(value){
                if(value.length <= 0 ){
                    return '请上传公众号图片';
                }
            },
            news: function(value){
                if(value.length <= 0 ){
                    return '请填写主体信息';
                }
            },
            introduce: function(value){
                if(value.length <= 0 ){
                    return '请填写介绍';
                }
                if(value.length >= 1000 ){
                    return '详细介绍过长，请控制字数在1000个字符内';
                }
            }
        });


        //监听提交
        form.on('submit(demo1)', function(data){
            $.ajax({
                type:'post',
                async:false,
                url:"${pageContext.request.contextPath}/admin/information/add",
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
