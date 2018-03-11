package com.mine.alpha.security;

import com.mine.alpha.model.Enterprise;
import com.mine.alpha.model.Permission;
import com.mine.alpha.model.Role;
import com.mine.alpha.model.User;
import com.mine.alpha.service.EntityService;
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
import java.util.List;
import java.util.Set;

public class EntityRealm extends AuthorizingRealm{
    @Autowired
    EntityService entityService;

    @Override
    public boolean supports(AuthenticationToken token){return token instanceof JWTToken;}

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals){
        String token = principals.toString();
        String username = JWTUtil.getUsername(token);
        String type = JWTUtil.getType(token);

        switch (type){
            case "user":
                User user = entityService.userAuth(username);
                if (user != null){
                    return vertifyRoles(user.getRoles());
                }else {
                    return null;
                }

            case "enterprise":
                Enterprise enterprise = entityService.enterpriseAuth(username);
                if (enterprise != null){
                    return vertifyRoles(enterprise.getRoles());
                }else {
                    return null;
                }

            default:
                return null;
        }

    }

    private SimpleAuthorizationInfo vertifyRoles(List<Role> roles){
        SimpleAuthorizationInfo simple = new SimpleAuthorizationInfo();
        Set<String> rset = new HashSet<>();
        Set<String> pset = new HashSet<>();
        for (Role role : roles){
            rset.add(role.getName());
            for (Permission permission : role.getPermissions()) {
                pset.add(permission.getName());
            }
        }
        simple.addRoles(rset);
        simple.addStringPermissions(pset);
        return simple;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken auth)throws AuthenticationException{
        String username = ((String) auth.getPrincipal()).trim();
        String token = ((String) auth.getCredentials()).trim();
        String type = JWTUtil.getType(token);

        System.out.println(type);

        switch (type){
            case "user":
                User user = entityService.getUser(username);
                if (user == null){
                    throw new AuthenticationException("用户不存在");
                }
                if (!JWTUtil.vertify(token,user.getUsername(),user.getPassword())){
                    throw new AuthenticationException("用户名或密码错误");
                }
                break;

            case "enterprise":
                Enterprise enterprise = entityService.getEnterprise(username);
                if (enterprise == null){
                    throw new AuthenticationException("企业不存在");
                }
                if (!JWTUtil.vertify(token,enterprise.getUsername(),enterprise.getPassword())){
                    throw new AuthenticationException("用户名或密码错误");
                }
                break;
        }
        return new SimpleAuthenticationInfo(token,token,"entity_realm");
    }
}
