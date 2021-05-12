package com.hand.springboot.config.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Date;
import javax.servlet.*;

/**
 * description
 *
 * @author liangwusun 2021/03/29 11:25
 */
@Component
public class TimeFilter implements Filter {

    protected Logger logger= LoggerFactory.getLogger(TimeFilter.class);

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        logger.info("Time Filter Init......");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        logger.info("Time Filter Start......");
        long start = System.currentTimeMillis();
        filterChain.doFilter(servletRequest,servletResponse);
        long end = System.currentTimeMillis();
        logger.info("Time Filter: " + (end - start));
        logger.info("Time Filter Finish......");
    }

    @Override
    public void destroy() {
        logger.info("Time Filter Destroy......");
    }
}
