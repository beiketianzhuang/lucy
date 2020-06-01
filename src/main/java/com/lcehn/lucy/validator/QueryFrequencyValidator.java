package com.lcehn.lucy.validator;

import com.lcehn.lucy.utils.IpUtil;
import org.springframework.stereotype.Component;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;

import static com.lcehn.lucy.constants.LucyConstants.COMPANY_INFO_PATH;

@Component
public class QueryFrequencyValidator implements Validator<ServletRequest> {

    @Override
    public void valid(ServletRequest servletRequest) throws Exception {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        String ipAddr = IpUtil.getIpAddr(request);
        String requestURI = request.getRequestURI();
        if (COMPANY_INFO_PATH.contains(requestURI)) {
            validIp(ipAddr);
        }
    }

    public void validIp(String ip) {
//        throw new RuntimeException();
    }
}
