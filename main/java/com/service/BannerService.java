package com.service;

import com.pojo.Banner;

import java.util.List;

/**
 * Created by CHLaih on 2018/4/24.
 */
public interface BannerService {
    int getCount();

    List<Banner> selectCms();

    int save(Banner banner);

    String getPhoto(int bannerId);

    int delete(Integer bannerId);

    Banner selectBannerById(Integer bannerId);

    int update(Banner banner);

    List<Banner> selectBannerByPage(int startPage, int pageSize);
}
