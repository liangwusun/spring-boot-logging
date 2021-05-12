package com.hand.springboot.config.interceptor;

import com.hand.springboot.config.filter.TimeFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * description
 *
 * @author liangwusun 2021/03/29 11:51
 */
@Component
public class TimeInterceptor implements HandlerInterceptor {

    protected Logger logger = LoggerFactory.getLogger(TimeInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        logger.info("preHandle");
        logger.info(((HandlerMethod) handler).getBean().getClass().getName());
        logger.info(((HandlerMethod) handler).getMethod().getName());
        request.setAttribute("startTime", System.currentTimeMillis());
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
                           ModelAndView modelAndView) throws Exception {
        logger.info("postHandle");
        Long start = (Long) request.getAttribute("startTime");
        logger.info("time interceptor 耗时:" + (System.currentTimeMillis() - start));
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
            throws Exception {
        logger.info("afterCompletion");
        Long start = (Long) request.getAttribute("startTime");
        logger.info("time interceptor 耗时:" + (System.currentTimeMillis() - start));
        logger.info("ex is " + ex);
    }

}
