package cn.com.edzleft.util;

import javax.servlet.http.HttpServletRequest;

public class IPAddressUtil {

    public static  String getIpAddr(HttpServletRequest request) { 
		String addr = request.getHeader("x-forwarded-for");
		if (!isEmpty(addr) && !"unknown".equalsIgnoreCase(addr)) {
			return addr;
		}
		addr = request.getHeader("Proxy-Client-IP");
		if (!isEmpty(addr) && !"unknown".equalsIgnoreCase(addr)) {
			return addr;
		}
		addr = request.getHeader("WL-Proxy-Client-IP");
		if (!isEmpty(addr) && !"unknown".equalsIgnoreCase(addr)) {
			return addr;
		}
		return request.getRemoteAddr();
    }
    
    static boolean isEmpty(String str) {
    	return str == null || str.trim().isEmpty();
    }
    
    
}
