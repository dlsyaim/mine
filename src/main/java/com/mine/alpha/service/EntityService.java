package com.mine.alpha.service;

import com.mine.alpha.dao.EnterpriseMapper;
import com.mine.alpha.dao.UserMapper;
import com.mine.alpha.model.Enterprise;
import com.mine.alpha.model.User;
import com.mine.alpha.security.JWTUtil;
import com.mine.alpha.utils.EntityUtils;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EntityService {
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private EnterpriseMapper enterpriseMapper;

    private String md5(String password,String pass_salt){ return new Md5Hash(new Md5Hash(password).toString(), pass_salt).toString(); }

    public User userAuth(String username){ return userMapper.auth(username); }

    public Enterprise enterpriseAuth(String username){ return enterpriseMapper.auth(username); }

    public User getUser(String username){ return userMapper.selectByUsername(username); }

    public Enterprise getEnterprise(String username){ return enterpriseMapper.selectByUsername(username); }

    public String userSign(String username,String password){
        User user = userMapper.selectByUsername(username.trim());
        if (user != null){
            String pwd = md5(password,user.getPassSalt());
            if (user.getPassword().trim().equals(pwd.trim())) return JWTUtil.sign(username,pwd,"user");
                else return null;
        }else return null;
    }

    public String enterpriseSign(String username,String password){
        User user = userMapper.selectByUsername(username.trim());
        if (user != null){
            String pwd = md5(password,user.getPassSalt());
            if (user.getPassword().trim().equals(pwd.trim())) return JWTUtil.sign(username,pwd,"enterprise");
            else return null;
        }else return null;
    }

    public int createUser(
            String username,
            String password,
            int enterpriseId){
        User user = new User();
        if (EntityUtils.emailCheck(username)){
            String salt = EntityUtils.randomStr(6);
            String pwd = EntityUtils.md5(password,salt);
            user.setUsername(username);
            user.setPassword(pwd);
            user.setPassSalt(salt);
            user.setEmail(username);
            user.setEnterpriseId(enterpriseId);
            return userMapper.insert(user);
        }else {
            return 0;
        }
    }
}
