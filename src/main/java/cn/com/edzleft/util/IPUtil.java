package cn.com.edzleft.util;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

/**
 * The Class IpUtils.
 *
 */
public abstract class IPUtil {

	/**
	 * Gets the client ip addr.
	 *
	 * @param request
	 *            the request
	 * @return the client ip addr
	 */
	public static String getClientIpAddr(HttpServletRequest request) {
		String ip = request.getHeader("x-forwarded-for");
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("WL-Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getRemoteAddr();
		}
		return ip;
	}

	/**
	 * Gets the real ips.
	 *
	 * @return the real ips
	 */
	public static List<String> getRealIps() {
		List<String> ips = new ArrayList<String>();
		String localip = null;// 本地IP，如果没有配置外网IP则返回它
		String netip = null;// 外网IP
		Enumeration<NetworkInterface> netInterfaces;
		try {
			netInterfaces = NetworkInterface.getNetworkInterfaces();
		} catch (SocketException e) {
			return null;
		}
		InetAddress ip = null;
		boolean finded = false;// 是否找到外网IP
		while (netInterfaces.hasMoreElements() && !finded) {
			NetworkInterface ni = netInterfaces.nextElement();
			Enumeration<InetAddress> address = ni.getInetAddresses();
			while (address.hasMoreElements()) {
				ip = address.nextElement();
				if (!ip.isSiteLocalAddress() && !ip.isLoopbackAddress() && ip.getHostAddress().indexOf(":") == -1) {// 外网IP
					netip = ip.getHostAddress();
					ips.add(netip);
					finded = true;
					break;
				} else if (ip.isSiteLocalAddress() && !ip.isLoopbackAddress()
						&& ip.getHostAddress().indexOf(":") == -1) {// 内网IP
					localip = ip.getHostAddress();
					ips.add(localip);
				}
			}
		}
		return ips;
	}

	/**
	 * Gets the real ip.
	 *
	 * @return the real ip
	 */
	public static String getRealIp() {
		return getRealIps().iterator().next();
	}
	
	public static String getAddress(String ip){
		String getAddressUrl=ConfigUtil.get("AddressUrl").replace("IPURL", ip);//本地配置根据ip获取详细地址
		String addressStr=CommonUtil.sendGetInfo(getAddressUrl);
		String address="未知";
		if(addressStr!=null&&!addressStr.equals("null")&&!addressStr.equals("")){
			JSONObject json=JSONObject.parseObject(addressStr);
			String contentStr=json.getString("content");
			if(contentStr!=null&&!contentStr.equals("null")&&!contentStr.equals("")){
				JSONObject contentJson=JSON.parseObject(contentStr);
				String unAddress=contentJson.getString("address");
				if(unAddress!=null&&!unAddress.equals("")){
					address=unAddress;
				}
			}
		}
		return address;
	}
}