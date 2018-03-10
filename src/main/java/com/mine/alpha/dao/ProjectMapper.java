package com.mine.alpha.dao;

import com.mine.alpha.model.Project;
import com.mine.alpha.model.ProjectWithBLOBs;

public interface ProjectMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ProjectWithBLOBs record);

    int insertSelective(ProjectWithBLOBs record);

    ProjectWithBLOBs selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ProjectWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(ProjectWithBLOBs record);

    int updateByPrimaryKey(Project record);
}