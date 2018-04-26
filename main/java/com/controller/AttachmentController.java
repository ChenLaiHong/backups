package com.controller;

import com.pojo.Attachment;
import com.service.AttachmentService;
import com.utils.FileUploadUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

/**
 * Created by CHLaih on 2018/4/24.
 */
@Controller
@RequestMapping("/admin/attachment")
public class AttachmentController {
    @Autowired
    private AttachmentService attachmentService;

    @RequestMapping(value = "/fileUpload", method = RequestMethod.POST)
    public void fileUpload(HttpServletResponse response, @RequestParam("upload") MultipartFile upload, String CKEditorFuncNum)  {
        try {
            response.setCharacterEncoding("utf-8");
            PrintWriter out = response.getWriter();
            // CKEditor提交的很重要的一个参数
            String expandedName = ""; // 文件扩展名
            String contentType=upload.getContentType();
            if (upload.isEmpty()|upload.getSize()==0){
                out.println("<script type=\"text/javascript\">");
                out.println("window.parent.CKEDITOR.tools.callFunction(" + CKEditorFuncNum + ",''," + "'文件大小不得大于600k');");
                out.println("</script>");
                return ;
            }
            if (contentType.equals("image/pjpeg") || contentType.equals("image/jpeg")) {
                // IE6上传jpg图片的headimageContentType是image/pjpeg，而IE9以及火狐上传的jpg图片是image/jpeg
                expandedName = ".jpg";
            } else if (contentType.equals("image/png") || contentType.equals("image/x-png")) {
                // IE6上传的png图片的headimageContentType是"image/x-png"
                expandedName = ".png";
            } else if (contentType.equals("image/gif")) {
                expandedName = ".gif";
            } else if (contentType.equals("image/bmp")) {
                expandedName = ".bmp";
            } else {
                out.println("<script type=\"text/javascript\">");
                out.println("window.parent.CKEDITOR.tools.callFunction(" + CKEditorFuncNum+ ",''," + "'文件格式不正确（必须为.jpg/.gif/.bmp/.png文件）');");
                out.println("</script>");
                return ;
            }
            if (upload.getSize() > 600 * 1024) {
                out.println("<script type=\"text/javascript\">");
                out.println("window.parent.CKEDITOR.tools.callFunction(" + CKEditorFuncNum+ ",''," + "'文件大小不得大于600k');");
                out.println("</script>");
                return ;
            }
            String fileName= FileUploadUtil.uploadFile(upload, FileUploadUtil.BANNER_PATH);
            // 返回"图像"选项卡并显示图片
            out.println("<script type=\"text/javascript\">");
            out.println("window.parent.CKEDITOR.tools.callFunction(" + CKEditorFuncNum + ",'" +FileUploadUtil.BANNER_PATH + "/" + fileName + "','')");
            out.println("</script>");
            Attachment a=new Attachment();
            a.setFileName(fileName);
            attachmentService.insert(a);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
