package com.service;

import com.pojo.Information;

import java.util.List;

/**
 * Created by CHLaih on 2018/4/26.
 */
public interface InformationService {
    int getCount();

    List<Information> get(Integer num, Integer curr);

    int save(Information information);

    String getPhoto(int int_id);

    String getPublicPhoto(int int_id);

    Information selectInformationById(int id);

    int updateInformation(Information information);

    int delete(Integer id);

    List<Information> search(String searchValue);
}
