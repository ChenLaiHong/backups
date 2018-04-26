package com.controller;

import com.pojo.Information;
import com.service.InformationService;
import com.utils.AjaxResult;
import com.utils.FileUploadUtil;
import com.utils.JsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by CHLaih on 2018/4/26.
 */
@Controller
@RequestMapping("/admin/information")
public class InformationController {
    @Autowired
    private InformationService informationService;
    @RequestMapping({"/test"})
    public String test() {
        return "admin/main";
    }

    @RequestMapping({"/listUI"})
    public String listUI(Model model)
    {
        model.addAttribute("count", this.informationService.getCount());
        return "/admin/information/informationManagement";
    }
    @RequestMapping(value = "/list",method = RequestMethod.GET)
    @ResponseBody
    public String list(@RequestParam(value = "num",required = false)Integer num, @RequestParam(value = "curr",required = false)Integer curr, HttpServletResponse response) {
        response.setContentType("text/html;charset=UTF-8");
        List<Information> informationList = informationService.get(num,curr);

        return JsonUtil.objectToJson(informationList);
    }

    @RequestMapping({"/addUI"})
    public String addUI() {
        return "admin/information/information-add";
    }

    @RequestMapping({"/add"})
    @ResponseBody
    public AjaxResult add(Information information) {

        int result = this.informationService.save(information);
        if (result != 0) {
            return new AjaxResult(true, "添加成功");
        }
        return new AjaxResult(false, "添加失败");
    }

    @RequestMapping({"/updatePhoto"})
    @ResponseBody
    public AjaxResult updatePhoto(@RequestParam("photo") MultipartFile file, @RequestParam("id") String id) {
        try {
            if ("undefined".equals(id)) {
                String fileName = FileUploadUtil.uploadFile(file,FileUploadUtil.INFORMATION_PATH);
                return new AjaxResult(true, fileName);
            }
            int int_id = Integer.parseInt(id);
            String photo_url = this.informationService.getPhoto(int_id);
            if (photo_url != null) {
                FileUploadUtil.deleteFile(photo_url, FileUploadUtil.INFORMATION_PATH);
            }
            String fileName = FileUploadUtil.uploadFile(file, FileUploadUtil.INFORMATION_PATH);
            return new AjaxResult(true, fileName);
        } catch (Exception e) {
            e.printStackTrace(); }
        return new AjaxResult(false, "未知错误：添加图片失败");
    }

    @RequestMapping({"/updatePublicPhoto"})
    @ResponseBody
    public AjaxResult updatePublicPhoto(@RequestParam("publicPhoto") MultipartFile file, @RequestParam("id") String id) {
        try {
            if ("undefined".equals(id)) {
                String fileName = FileUploadUtil.uploadFile(file,FileUploadUtil.INFORMATION_PATH);
                return new AjaxResult(true, fileName);
            }
            int int_id = Integer.parseInt(id);
            String photo_url = this.informationService.getPublicPhoto(int_id);
            if (photo_url != null) {
                FileUploadUtil.deleteFile(photo_url, FileUploadUtil.INFORMATION_PATH);
            }
            String fileName = FileUploadUtil.uploadFile(file, FileUploadUtil.INFORMATION_PATH);
            return new AjaxResult(true, fileName);
        } catch (Exception e) {
            e.printStackTrace(); }
        return new AjaxResult(false, "未知错误：添加图片失败");
    }
}
