package com.mine.alpha.dao;

import com.mine.alpha.model.Prjlog;

public interface PrjlogMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Prjlog record);

    int insertSelective(Prjlog record);

    Prjlog selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Prjlog record);

    int updateByPrimaryKeyWithBLOBs(Prjlog record);

    int updateByPrimaryKey(Prjlog record);
}