package com.controller;

import com.google.gson.Gson;
import com.pojo.Banner;
import com.service.BannerService;
import com.utils.AjaxResult;
import com.utils.FileUploadUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * Created by CHLaih on 2018/4/24.
 */
@Controller
@RequestMapping("/admin/banner")
public class BannerController {
    @Autowired
    private BannerService bannerService;

    @RequestMapping("/list")
    public String bannerList(Map<String, Object> map){
        map.put("count",bannerService.getCount());
        map.put("banner",bannerService.selectBannerByPage(0,4));
        return "admin/banner/bannerManagement";
    }
    @RequestMapping({"/addUI"})
    public String addUI() {
        return "admin/banner/bannerSaveUI";
    }

    @RequestMapping(value={"/add"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
    public String add(Banner banner)
    {
      bannerService.save(banner);
        return "redirect:/admin/banner/list";
    }

    @RequestMapping({"/updatePhoto"})
    @ResponseBody
    public AjaxResult updatePhoto(@RequestParam("bannerPhoto") MultipartFile file, @RequestParam("bannerId") String bannerId) {
        try {
            if ("undefined".equals(bannerId)) {
                String fileName = FileUploadUtil.uploadFile(file, "/layout/file/banner");

                return new AjaxResult(true, fileName);
            }
            Integer int_bannerId = Integer.valueOf(Integer.parseInt(bannerId));
            String photo_url = this.bannerService.getPhoto(int_bannerId);
            if (photo_url != null) {
                FileUploadUtil.deleteFile(photo_url, "/layout/file/banner");
            }
            String fileName = FileUploadUtil.uploadFile(file, "/layout/file/banner");

            return new AjaxResult(true, fileName);
        } catch (Exception e) {
            e.printStackTrace(); }
        return new AjaxResult(false, "未知错误：添加图片失败");

    }

    @RequestMapping({"/delete"})
    public String delete(@RequestParam(value = "bannerId")Integer bannerId) {
        bannerService.delete(bannerId);
        return "redirect:/admin/banner/list";
    }

    @RequestMapping({"/updateUI"})
    public String updateUI(Map<String, Object> map,@RequestParam("bannerId") Integer bannerId) {
        map.put("banner", this.bannerService.selectBannerById(bannerId));
        return "admin/banner/bannerSaveUI";
    }

    @RequestMapping({"/update"})
    public String update(Banner banner) {
        bannerService.update(banner);
        return "redirect:/admin/banner/list";
    }

    /**
     * 文章分类异步
     * @return
     */
    @RequestMapping(value = "/asynList")
    @ResponseBody
    public void bannerAsynList(@RequestParam(value = "num",required = false)Integer num,HttpServletResponse response,
                                @RequestParam(value = "curr",required = false)Integer curr){
        response.setContentType("text/html;charset=UTF-8");
        List<Banner> banner = bannerService.selectBannerByPage(curr*num,num);
        Gson gson = new Gson();
        String str = gson.toJson(banner);
        try {
            response.getWriter().write(str);
            response.getWriter().flush();
            response.getWriter().close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
