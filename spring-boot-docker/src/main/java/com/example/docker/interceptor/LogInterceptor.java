package com.example.docker.interceptor;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.MDC;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.time.LocalDateTime;
import java.util.UUID;

@Slf4j
@Configuration
public class LogInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        MDC.put("requestTime", String.valueOf(System.currentTimeMillis()));

        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

        long requestTime = Long.parseLong(MDC.get("requestTime"));
        long responseTime = System.currentTimeMillis();

        MDC.put("responseTime", String.valueOf(responseTime));
        MDC.put("latency", String.valueOf(responseTime - requestTime));
        MDC.put("txLog", System.currentTimeMillis() + "." + UUID.randomUUID().toString());
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        log.info("{} is complete.", request.getServletPath());
    }
}
