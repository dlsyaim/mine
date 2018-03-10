package com.mine.alpha.security;

import com.sun.xml.internal.ws.resources.HttpserverMessages;
import org.apache.shiro.web.filter.authc.BasicHttpAuthenticationFilter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class JWTFilter extends BasicHttpAuthenticationFilter {
    @Override
    protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception{
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        String auth = httpServletRequest.getHeader(AUTHORIZATION_HEADER);
        if (auth != null){
            String[] array = auth.split(" ");
            try {
                return true;
            }catch (Exception e){
                e.printStackTrace();
                rsp401(request,response);
                return false;
            }
        }else {
            rsp401(request,response);
            return false;
        }
    }

    private void rsp401(ServletRequest req,ServletResponse rsp)throws Exception{
        HttpServletResponse response = (HttpServletResponse)rsp;
        response.sendRedirect("/401");
    }
}
