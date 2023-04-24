package com.wangyue.interceptor;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;
import java.util.List;

@Component
public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        List<String> asList = Arrays.asList("/user/register", "/user/login");
        String url = request.getRequestURI();
        System.out.println("路径==>" + url);
        //1.设置放行路径
        if (asList.contains(url)) {
            System.out.println("放行==>" + url);
            return true;
        }
        //2.拿到请求头里面的token（如果是第一次登录，那么是没有请求头的）
        String token = request.getHeader("token");
        System.out.println("token==>" + token);
        if(token==null){
            response.setContentType("application/json; charset=utf-8");
            //2.1 拦截请求并返回信息给前台 （前台后置拦截器就是根据这里面返回的json数据，来判读并跳转到登录界面）
            response.getWriter().print("{\"success\":false,\"msg\":\"NoUser\"}");
            return false;
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
    }
}
