package com.example.config.interceptor;

import com.alibaba.fastjson.JSON;
import com.example.support.PageParam;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * 拦截器
 * </p>
 *
 * @author init
 * @since 2022-07-07
 */
@Component
public class RequestInterceptor extends HandlerInterceptorAdapter {

    public final static Logger logger = LoggerFactory.getLogger(RequestInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if(!"POST".equalsIgnoreCase(request.getMethod())) { return true; }

        BodyReaderWrapper requestWrapper = new BodyReaderWrapper(request);
        String bodyString = requestWrapper.getBodyString();
        if (StringUtils.isEmpty(bodyString) || !JSON.isValid(bodyString)) { return true; }

        // 分页参数 每页记录数不能超过100条
        PageParam pageParam = JSON.parseObject(bodyString, PageParam.class);
        if (null == pageParam || 100 >= pageParam.getPageSize()) { return true; }

        Map<String, Object> map = new HashMap<>();
        map.put("success", false);
        map.put("code", 400);
        map.put("msg", "每页记录数不能超过100条！");
        map.put("data", null);
        String json = new ObjectMapper().writeValueAsString(map);
        response.setContentType("application/json;charset=UTF-8");
        response.getWriter().print(json);
        logger.error("每页记录数不能超过100条！");
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable ModelAndView modelAndView) throws Exception {
        super.postHandle(request, response, handler, modelAndView);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable Exception ex) throws Exception {
        super.afterCompletion(request, response, handler, ex);
    }
}
