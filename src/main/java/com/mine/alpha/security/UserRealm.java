package com.mine.alpha.security;

import com.mine.alpha.dao.UserMapper;
import com.mine.alpha.model.Permission;
import com.mine.alpha.model.Role;
import com.mine.alpha.model.User;
import com.mine.alpha.service.AuthService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.Set;

public class UserRealm extends AuthorizingRealm{
    @Autowired
    AuthService authService;

    @Override
    public boolean supports(AuthenticationToken token){return token instanceof JWTToken;}

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals){
        String token = principals.toString();
        String username = JWTUtil.getUsername(token);
        User user = authService.auth(username);
        if (user != null){
            SimpleAuthorizationInfo simple = new SimpleAuthorizationInfo();
            Set<String> rset = new HashSet<>();
            Set<String> pset = new HashSet<>();
            for (Role role : user.getRoles()){
                rset.add(role.getName());
                for (Permission permission : role.getPermissions()) {
                    pset.add(permission.getName());
                }
            }
            simple.addRoles(rset);
            simple.addStringPermissions(pset);
            return simple;
        }else {
            return null;
        }
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken auth)throws AuthenticationException{
        String username = ((String) auth.getPrincipal()).trim();
        String token = ((String) auth.getCredentials()).trim();
        User user = authService.getUser(username);
        if (user == null){
            throw new AuthenticationException("用户不存在");
        }
        if (!JWTUtil.vertify(token,user.getUsername(),user.getPassword())){
            throw new AuthenticationException("用户名或密码错误");
        }
        return new SimpleAuthenticationInfo(token,token,"user_realm");
    }
}
