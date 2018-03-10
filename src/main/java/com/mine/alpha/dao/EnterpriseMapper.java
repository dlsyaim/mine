package com.mine.alpha.dao;

import com.mine.alpha.model.Enterprise;
import org.springframework.stereotype.Repository;

@Repository
public interface EnterpriseMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Enterprise record);

    int insertSelective(Enterprise record);

    Enterprise selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Enterprise record);

    int updateByPrimaryKey(Enterprise record);
}