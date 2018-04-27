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
import java.util.Map;

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
    @RequestMapping(value = "/list",method = RequestMethod.POST,produces = "text/plain;charset=utf-8")
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
    @RequestMapping(value = "/detail")
    public String informationDetail(@RequestParam(value = "id")String id,Map<String, Object> map){
        int int_id = Integer.parseInt(id);
        map.put("information",informationService.selectInformationById(int_id));
        return "admin/information/informationDetail";
    }

    @RequestMapping(value = "/updateUI")
    public String updateArticleUI(Map<String, Object> map,@RequestParam(value = "id")String id){

        int int_id = Integer.parseInt(id);
        map.put("information",informationService.selectInformationById(int_id));
        return "admin/information/informationSaveUI";
    }

    @RequestMapping(value = "/update")
    public AjaxResult updateInformation(Information information){
        int result = this.informationService.updateInformation(information);
        if (result != 0) {
            return new AjaxResult(true, "修改成功");
        }
        return new AjaxResult(false, "修改失败");

    }

    @RequestMapping({"/delete"})
    @ResponseBody
    public AjaxResult delete(Integer id) {
        int result = this.informationService.delete(id);
        if (result != 0) {
            return new AjaxResult(true, "删除成功");
        }
        return new AjaxResult(false, "删除失败");
    }

    @RequestMapping(value = "/search",produces = "text/plain;charset=utf-8")
    @ResponseBody
    public String search(String searchValue) {
        if ("".equals(searchValue)){
            return "0";
        }
        return JsonUtil.objectToJson(this.informationService.search(searchValue));
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
