package com.lcehn.lucy.name.utils;

import javax.servlet.http.HttpServletRequest;

public final class IpUtil {

    private final static String X_FORWARDED_FOR_HEADER = "x-forwarded-for";
    private final static String PROXY_CLIENT_IP_HEADER = "Proxy-Client-IP";
    private final static String WL_PROXY_CLIENT_IP_HEADER = "WL-Proxy-Client-IP";

    private IpUtil() {
        throw new AssertionError();
    }

    public static String getIpAddr(HttpServletRequest request) {
        String ip = request.getHeader(X_FORWARDED_FOR_HEADER);
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader(PROXY_CLIENT_IP_HEADER);
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader(WL_PROXY_CLIENT_IP_HEADER);
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        if ("0:0:0:0:0:0:0:1".equals(ip)) {
            ip = "127.0.0.1";
        }
        if (ip.split(",").length > 1) {
            ip = ip.split(",")[0];
        }
        return ip;
    }
}
