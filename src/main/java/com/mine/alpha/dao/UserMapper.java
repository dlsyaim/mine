package com.mine.alpha.dao;

import com.mine.alpha.model.Role;
import com.mine.alpha.model.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    User selectByUsername(String username);

    User auth(String username);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
}