package com.dao;

import com.pojo.Detailed;
import com.pojo.DetailedExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface DetailedMapper {
    long countByExample(DetailedExample example);

    int deleteByExample(DetailedExample example);

    int deleteByPrimaryKey(Integer detailedId);

    int insert(Detailed record);

    int insertSelective(Detailed record);

    List<Detailed> selectByExampleWithBLOBs(DetailedExample example);

    List<Detailed> selectByExample(DetailedExample example);

    Detailed selectByPrimaryKey(Integer detailedId);

    int updateByExampleSelective(@Param("record") Detailed record, @Param("example") DetailedExample example);

    int updateByExampleWithBLOBs(@Param("record") Detailed record, @Param("example") DetailedExample example);

    int updateByExample(@Param("record") Detailed record, @Param("example") DetailedExample example);

    int updateByPrimaryKeySelective(Detailed record);

    int updateByPrimaryKeyWithBLOBs(Detailed record);

    int updateByPrimaryKey(Detailed record);
}