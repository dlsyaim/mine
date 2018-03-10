package com.mine.alpha.service;

import com.mine.alpha.dao.UserMapper;
import com.mine.alpha.model.User;
import com.mine.alpha.security.JWTUtil;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    @Autowired
    private UserMapper userMapper;

    public User auth(String username){ return userMapper.auth(username); }

    public User getUser(String username){ return userMapper.selectByUsername(username); }

    public String sign(String username,String password){
        User user = userMapper.selectByUsername(username.trim());
        if (user != null){
            String pwd = md5(password,user.getPassSalt());
            if (user.getPassword().trim().equals(pwd.trim())) return JWTUtil.sign(username,pwd);
                else return null;
        }else return null;
    }

    private String md5(String password,String pass_salt){ return new Md5Hash(new Md5Hash(password).toString(), pass_salt).toString(); }
}
