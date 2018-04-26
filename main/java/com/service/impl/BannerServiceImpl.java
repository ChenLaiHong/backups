package com.service.impl;

import com.dao.BannerMapper;
import com.pojo.Banner;
import com.service.BannerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by CHLaih on 2018/4/24.
 */
@Service
public class BannerServiceImpl implements BannerService {
    @Autowired
    private BannerMapper bannerMapper;
    @Override
    public int getCount() {
        return bannerMapper.getCount();
    }

    @Override
    public List<Banner> selectCms() {
        return bannerMapper.selectBanner();
    }

    @Override
    public int save(Banner banner) {

        banner.setBannerState(0);

        int result = this.bannerMapper.insert(banner);
        if (result > 0) {
            return 1;
        }
        return 0;
    }

    @Override
    public String getPhoto(int bannerId) {
        Banner banner = this.bannerMapper.selectByPrimaryKey(bannerId);
        if (!"".equals(banner.getBannerPhoto())) {
            return banner.getBannerPhoto();
        }
        return null;
    }

    @Override
    public int delete(Integer bannerId) {
        int reslut = this.bannerMapper.deleteByPrimaryKey(bannerId);
        if (reslut > 0) {
            return 1;
        }
        return 0;
    }

    @Override
    public Banner selectBannerById(Integer bannerId) {
        return this.bannerMapper.selectByPrimaryKey(bannerId);
    }

    @Override
    public int update(Banner banner) {

        int result = this.bannerMapper.updateByPrimaryKey(banner);
        if (result > 0) {
            return 1;
        }
        return 0;
    }

    @Override
    public List<Banner> selectBannerByPage(int startPage, int pageSize) {
        return bannerMapper.selectBannerByPage(startPage,pageSize);
    }
}
