package com.lcehn.lucy.name.filter;

import com.lcehn.lucy.name.validator.QueryFrequencyValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 过滤用户访问
 */
@Slf4j
@Component
@WebFilter(
        filterName = "ipAssertionFilter",
        urlPatterns = {"/*"})
public class IpAssertionFilter implements Filter {

    @Autowired
    private QueryFrequencyValidator frequencyValidator;

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        try {
//            frequencyValidator.valid(servletRequest);
        } catch (Exception e) {
            HttpServletResponse response = (HttpServletResponse) servletResponse;
            response.getWriter().write("您搜索的过于频繁，请稍后再试吧");
            return;
        }
        filterChain.doFilter(servletRequest, servletResponse);
    }
}
