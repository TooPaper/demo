package com.example.config.interceptor;

import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * <p>
 * 过滤器
 * 请求参数重新创建传给控制器
 * </p>
 *
 * @author init
 * @since 2022-07-07
 */
@Component
@WebFilter(filterName="bodyReaderFilter",urlPatterns="/*")
public class BodyReaderFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        // do nothing
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        // 将 request请求 重新创建 自定义的请求对象，并往下传递
        ServletRequest requestWrapper = null;
        if(request instanceof HttpServletRequest) {
            requestWrapper = new BodyReaderWrapper((HttpServletRequest)request);
        }
        if(requestWrapper == null) {
            chain.doFilter(request, response);
        }else {
            chain.doFilter(requestWrapper, response);
        }

    }

    @Override
    public void destroy() {
        // do nothing

    }
}
