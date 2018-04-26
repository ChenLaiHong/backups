package com.dao;

import com.pojo.Popularize;
import com.pojo.PopularizeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PopularizeMapper {
    long countByExample(PopularizeExample example);

    int deleteByExample(PopularizeExample example);

    int deleteByPrimaryKey(Integer popularizeId);

    int insert(Popularize record);

    int insertSelective(Popularize record);

    List<Popularize> selectByExample(PopularizeExample example);

    Popularize selectByPrimaryKey(Integer popularizeId);

    int updateByExampleSelective(@Param("record") Popularize record, @Param("example") PopularizeExample example);

    int updateByExample(@Param("record") Popularize record, @Param("example") PopularizeExample example);

    int updateByPrimaryKeySelective(Popularize record);

    int updateByPrimaryKey(Popularize record);
}