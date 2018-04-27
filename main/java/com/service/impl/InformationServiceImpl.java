package com.service.impl;

import com.dao.InformationMapper;
import com.pojo.Information;
import com.pojo.InformationExample;
import com.service.InformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by CHLaih on 2018/4/26.
 */
@Service
public class InformationServiceImpl implements InformationService {
    @Autowired
    private InformationMapper informationMapper;

    @Override
    public int getCount() {
        return informationMapper.getCount();
    }

    @Override
    public List<Information> get(Integer num, Integer curr) {
        int startPage = num*curr;
        int pageSize = num;
        return informationMapper.get(startPage,pageSize);
    }

    @Override
    public int save(Information information) {
        int result = this.informationMapper.insert(information);
        if (result > 0) {
            return 1;
        }
        return 0;
    }

    @Override
    public String getPhoto(int int_id) {
        Information information = this.informationMapper.selectByPrimaryKey(int_id);
        return information.getPhoto();
    }

    @Override
    public String getPublicPhoto(int int_id) {
        Information information = this.informationMapper.selectByPrimaryKey(int_id);
        return information.getPublicPhoto();
    }

    @Override
    public Information selectInformationById(int id) {
        return this.informationMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateInformation(Information information) {
        return informationMapper.updateByPrimaryKey(information);
    }

    @Override
    public int delete(Integer id) {
        return informationMapper.deleteByPrimaryKey(id);
    }

    @Override
    public List<Information> search(String searchValue) {
        InformationExample informationExample = new InformationExample();
        informationExample.createCriteria().andCategoryLike("%"+searchValue+"%");
        informationExample.or().andNameLike("%"+searchValue+"%");
        informationExample.or().andNewsLike("%"+searchValue+"%");
        return informationMapper.selectByExample(informationExample);
    }
}
