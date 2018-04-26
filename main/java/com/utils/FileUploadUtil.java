package com.utils;

import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.util.UUID;

/**
 * Created by CHLaih on 2018/4/24.
 */
public class FileUploadUtil {
    /**
     * 深爱保图片的保存位置
     */
    public final static String INFORMATION_PATH = "/layout/file/information";

    /**
     * 轮播图的保存位置
     */
    public final static String BANNER_PATH = "/layout/file/banner";

    /**
     * 海报的保存位置
     */
    public final static String POSTER_PATH = "/layout/file/poster";

    /**
     * 推广图片的保存位置
     */
    public final static String POPULARIZE_PATH = "/layout/file/popularize";

    /**
     * 详情图片的保存位置
     */
    public final static String DETAILED_PATH = "/layout/file/detailed";









    public static String uploadFile(MultipartFile uploadFile, String savePath) {
        RequestAttributes ar = RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = ((ServletRequestAttributes) ar).getRequest();
        String uploadPath = request.getSession().getServletContext().getRealPath("") + savePath;
        OutputStream os = null;
        InputStream is = null;
        try {
            is = uploadFile.getInputStream();
            String fileName = UUID.randomUUID().toString()
                    + getFileExt(uploadFile.getOriginalFilename());
            File file = new File(uploadPath);
            if (!file.exists()) { // 如果路径不存在，创建
                file.mkdirs();
            }
            File toFile = new File(uploadPath, fileName);
            os = new FileOutputStream(toFile);
            byte[] buffer = new byte[1024];
            int length = 0;
            while ((length = is.read(buffer)) > 0) {
                os.write(buffer, 0, length);
            }
            return fileName;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            try {
                is.close();
                os.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }

    /**
     * 获取文件的后缀名
     *
     * @param fileName 原文件名
     * @return 后缀
     */
    public static String getFileExt(String fileName) {
        return fileName.substring(fileName.lastIndexOf("."));
    }

    /**
     * 获取文件的名,不包括后缀名
     *
     * @param fileName 原文件名
     * @return 后缀
     */
    public static String getFilePrefix(String fileName) {
        return fileName.substring(0, fileName.lastIndexOf("."));
    }

    /**
     * 删除服务器中的文件
     * <p>
     * 根路径
     *
     * @param fileName 文件名
     */
    public static void deleteFile(String savePath, String fileName) {
        RequestAttributes ar = RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = ((ServletRequestAttributes) ar)
                .getRequest();
        String path = request.getSession().getServletContext().getRealPath("")
                + savePath;
        System.out.println("delete" + path + "/" + fileName);
        File file = new File(path + "/" + fileName);
        if (file.exists()) {
            file.delete();
        }

    }

    /**
     * 删除服务器中的文件
     * <p>
     * 根路径
     *
     * @param fileName 文件名
     * @param realPath 真实路径
     */
    public static void deleteFile(String realPath, String savePath,
                                  String fileName) {
        String path = realPath + savePath;
        System.out.println("delete" + path + "/" + fileName);
        File file = new File(path + "/" + fileName);
        if (file.exists()) {
            file.delete();
        }
    }
}
