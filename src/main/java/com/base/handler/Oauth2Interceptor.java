package com.base.handler;

import com.base.anno.AuthCheck;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *   用来做权限校验
 */
@Component
public class Oauth2Interceptor implements HandlerInterceptor {
    private final Logger log = LoggerFactory.getLogger(getClass());
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
                             Object handler) throws Exception {
        //从传入的handler中检查是否有AuthCheck的声明
        HandlerMethod method = (HandlerMethod)handler;
        AuthCheck authCheck = method.getMethodAnnotation(AuthCheck.class);
        if(authCheck != null){
            log.info("enter authchek..............");
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
