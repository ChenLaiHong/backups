package com.dao;

import com.pojo.FeedBack;
import com.pojo.FeedBackExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface FeedBackMapper {
    long countByExample(FeedBackExample example);

    int deleteByExample(FeedBackExample example);

    int deleteByPrimaryKey(Integer feedbackId);

    int insert(FeedBack record);

    int insertSelective(FeedBack record);

    List<FeedBack> selectByExampleWithBLOBs(FeedBackExample example);

    List<FeedBack> selectByExample(FeedBackExample example);

    FeedBack selectByPrimaryKey(Integer feedbackId);

    int updateByExampleSelective(@Param("record") FeedBack record, @Param("example") FeedBackExample example);

    int updateByExampleWithBLOBs(@Param("record") FeedBack record, @Param("example") FeedBackExample example);

    int updateByExample(@Param("record") FeedBack record, @Param("example") FeedBackExample example);

    int updateByPrimaryKeySelective(FeedBack record);

    int updateByPrimaryKeyWithBLOBs(FeedBack record);

    int updateByPrimaryKey(FeedBack record);
}