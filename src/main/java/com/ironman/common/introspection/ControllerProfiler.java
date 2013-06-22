package com.ironman.common.introspection;

import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.statistics.StatisticsGateway;
import org.apache.log4j.Logger;
import org.hibernate.stat.Statistics;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;

/**
 * @author jsingh on 6/7/13 at 1:46 PM
 */
public class ControllerProfiler implements HandlerInterceptor {

    private static Logger log = Logger.getLogger(ControllerProfiler.class);

    private static ThreadLocalData threadLocalData = new ThreadLocalData();

    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        threadLocalData.getControllerData().setStartTime(System.nanoTime());
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
        long endTime = System.nanoTime();
        long startTime = threadLocalData.getControllerData().getStartTime();
        //  Reset the start time (to make it obvious if stale data is used mistakenly).
        threadLocalData.getControllerData().setStartTime(0);
        String method = ((HandlerMethod) o).getMethod().getName();
        log.info("Performance: " + method + ": " + ((int) ((endTime - startTime) / 1e6)) + " ms");

        CacheManager cacheManager = CacheManager.create(getClass().getResource("ehcache.xml"));
        if(cacheManager != null) {
            String[] caches =  cacheManager.getCacheNames();
            for(String cac : caches) {
                Cache cach = cacheManager.getCache(cac);
                if(cach.getSize() > 0) {
                    StatisticsGateway statistics = cach.getStatistics();
                    log.info("Cache hit : " + statistics.cacheHitCount());
                    log.info("Cache miss : " + statistics.cacheMissCount());
                    log.info("Cache get : " + statistics.cacheGetOperation().count().value());
                    log.info("Cache size: " + statistics.getSize());
                }
            }
        }
    }
}