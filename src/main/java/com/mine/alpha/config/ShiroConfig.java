package com.mine.alpha.config;

import com.mine.alpha.security.JWTFilter;
import com.mine.alpha.security.UserRealm;
import org.apache.shiro.mgt.DefaultSessionStorageEvaluator;
import org.apache.shiro.mgt.DefaultSubjectDAO;
import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;

import javax.servlet.Filter;
import java.util.HashMap;
import java.util.Map;

@Configuration
@AutoConfigureAfter(ShiroLifecycleBeanPostProcessorConfig.class)
public class ShiroConfig {
    @Bean
    @DependsOn("lifecycleBeanPostProcessor")
    public UserRealm userRealm(){
        UserRealm userRealm = new UserRealm();
        return userRealm;
    }

    @Bean("securityManager")
    public DefaultWebSecurityManager getManager(){
        DefaultWebSecurityManager manager = new DefaultWebSecurityManager();
        manager.setRealm(userRealm());

        DefaultSubjectDAO subjectDAO = new DefaultSubjectDAO();
        DefaultSessionStorageEvaluator evaluator = new DefaultSessionStorageEvaluator();
        evaluator.setSessionStorageEnabled(false);
        subjectDAO.setSessionStorageEvaluator(evaluator);
        manager.setSubjectDAO(subjectDAO);

        return manager;
    }

    @Bean("shiroFilter")
    public ShiroFilterFactoryBean factory(DefaultWebSecurityManager manager){
        ShiroFilterFactoryBean factoryBean = new ShiroFilterFactoryBean();

        Map<String,Filter> filterMap = new HashMap<>();
        filterMap.put("jwt",new JWTFilter());
        factoryBean.setFilters(filterMap);
        factoryBean.setSecurityManager(manager);
        factoryBean.setUnauthorizedUrl("/401");

        Map<String,String> ruleMap = new HashMap<>();
        ruleMap.put("/user/**","jwt");
        ruleMap.put("/**","anon");
        factoryBean.setFilterChainDefinitionMap(ruleMap);
        return factoryBean;
    }
}
