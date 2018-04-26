package com.dao;

import com.pojo.Poster;
import com.pojo.PosterExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PosterMapper {
    long countByExample(PosterExample example);

    int deleteByExample(PosterExample example);

    int deleteByPrimaryKey(Integer posterId);

    int insert(Poster record);

    int insertSelective(Poster record);

    List<Poster> selectByExample(PosterExample example);

    Poster selectByPrimaryKey(Integer posterId);

    int updateByExampleSelective(@Param("record") Poster record, @Param("example") PosterExample example);

    int updateByExample(@Param("record") Poster record, @Param("example") PosterExample example);

    int updateByPrimaryKeySelective(Poster record);

    int updateByPrimaryKey(Poster record);
}