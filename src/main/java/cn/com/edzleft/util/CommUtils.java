package cn.com.edzleft.util;
import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.net.URLDecoder;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

import com.alibaba.druid.util.StringUtils;

import sun.misc.BASE64Decoder;

/**
 * @author ccsong 一般的工具类，静态， 一般来说，某个方法被调用一次一上，与业务数据没有耦合关系的，就应该放在这里
 */
@Component
public class CommUtils {
	private static Log log = LogFactory.getLog(CommUtils.class);
	private final static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	private final static SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd 00:00:00");
	// Sun Dec 31 00:00:00 CST 1899
	private final static SimpleDateFormat cst = new SimpleDateFormat("E MMM dd HH:mm:ss zzz yyyy", Locale.US);
	private final static SimpleDateFormat monthFormat = new SimpleDateFormat("yyyy-MM");
	private final static SimpleDateFormat shortMonthFormat = new SimpleDateFormat("yyyyMM");
	private final static SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	private final static SimpleDateFormat shortDateFormat = new SimpleDateFormat("yyyyMMdd");
	private final static SimpleDateFormat chartFormat = new SimpleDateFormat("dd/MM/yyyy");
	protected static final int BUFFER_SIZE = 16 * 1024;
	private final static Random rand = new Random();
	private static CommUtils instance = new CommUtils();

	public static CommUtils getInstance() {
		return instance;
	}

	/**
	 * 字符串分割成list集合
	 * 
	 * @param string
	 * @param regex
	 * @return
	 */
	public static List<Integer> toIntList(String string, String regex) {
		if (string == null || string.equals("")) {
			return null;
		}
		List<Integer> list = new ArrayList<Integer>();
		try {
			String[] str = string.split(regex);
			if (str == null || str.length == 0) {
				return null;
			}
			for (int i = 0; i < str.length; i++) {
				if (str[i] == null || str[i].trim().equals("")) {
					continue;
				}
				list.add(Integer.parseInt(str[i].trim()));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;

	}

	public static List<String> StringToList(String string, String regex) {
		if (string == null || string.equals("")) {
			return null;
		}
		List<String> list = new ArrayList<String>();
		try {
			String[] str = string.split(regex);
			if (str == null || str.length == 0) {
				return null;
			}
			for (int i = 0; i < str.length; i++) {
				list.add(str[i]);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;

	}

	public static String listToString(List<Integer> idList) {
		if (idList == null || idList.isEmpty()) {
			return null;
		}
		StringBuilder builder = new StringBuilder();
		try {
			for (Integer id : idList) {
				builder.append(id).append(",");
			}
			String str = builder.toString();
			if (str.endsWith(",")) {
				str = str.substring(0, str.length() - 1);
			}
			return str;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;

	}

	public static String listToString(String[] strList) {
		if (strList.length == 0) {
			return null;
		}
		StringBuilder builder = new StringBuilder();
		try {
			for (String str : strList) {
				builder.append(str).append(",");
			}
			String str = builder.toString();
			if (str.endsWith(",")) {
				str = str.substring(0, str.length() - 1);
			}
			return str;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;

	}

	public static String listToRegexString(List list, String regex) {
		if (list == null) {
			return null;
		}
		StringBuilder builder = new StringBuilder(regex);
		for (Object o : list) {
			builder.append(o).append(regex);
		}
		return builder.toString();
	}

	/**
	 * 将逗号分隔的字符串列表中，每个字符串加上单引号
	 * 
	 * @param strlist
	 * @return
	 */
	public static String addQuotes(String strlist) {
		String[] rpArr = strlist.split(", ");
		StringBuffer resb = new StringBuffer("");
		for (int i = 0; i < rpArr.length; i++) {
			if (resb.length() > 0) {
				resb.append(",");
			}
			resb.append("'" + rpArr[i] + "'");
		}
		return resb.toString();
	}

	/**
	 * 将字符串变成int
	 * 
	 * @param str
	 * @return
	 */
	public static int toInt(String str) {
		if (str == null)
			return 0;
		int si = 0;
		byte[] sc = str.getBytes();
		for (int i = 0; i < sc.length; i++) {
			si += sc[i];
		}
		return si;
	}

	public static Integer[] toIntArray(String[] strArray) {
		if (strArray == null || strArray.length == 0) {
			return null;
		}
		Integer[] intArray = new Integer[strArray.length];
		for (int i = 0; i < strArray.length; i++) {
			intArray[i] = Integer.parseInt(strArray[i]);
		}
		return intArray;
	}

	/**
	 * 获取远程用户IP地址
	 * 
	 * @param request
	 * @return
	 */
	public static String getRemoteIP(HttpServletRequest request) {
		// Enumeration en = request.getHeaders("X-Forwarded-For");
		// String remoteIP = "";
		String ip = request.getHeader("x-forwarded-for");
		if (ip != null && ip.trim().length() > 0 && !ip.equalsIgnoreCase("unknown")) {
			if (ip.indexOf(".") != -1) {
				if (ip.indexOf(",") != -1) {
					ip = ip.trim().replace("'", "");
					String[] temparyip = ip.split(",");
					for (int i = 0; i < temparyip.length; i++) {
						if (temparyip[i] != null
								&& (temparyip[i].trim().length() > 7 || temparyip[i].trim().length() < 15)
								&& !temparyip[i].substring(0, 3).equals("10.")
								&& !temparyip[i].substring(0, 7).equals("192.168")
								&& !temparyip[i].substring(0, 7).equals("172.16.")) {
							ip = temparyip[i];
						}
					}
				}
			}
		} else {
			if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
				ip = request.getHeader("Proxy-Client-IP");
			}
			if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
				ip = request.getHeader("WL-Proxy-Client-IP");
			}
			if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
				ip = request.getRemoteAddr();
			}
		}
		return ip;
	}

	/**
	 * 显示一年的第几个季度
	 * 
	 * @param date
	 * @return
	 */
	public static String formatQuarter(Date date) {
		Calendar ca = Calendar.getInstance();
		ca.setTime(date);
		int year = ca.get(Calendar.YEAR);
		String quarterStr = String.valueOf(year);
		int month = ca.get(Calendar.MONTH) + 1;
		if (4 > month) {
			quarterStr += "1";
		} else if (3 < month && 7 > month) {
			quarterStr += "2";
		} else if (6 < month && 10 > month) {
			quarterStr += "3";
		} else if (9 < month && 12 >= month) {
			quarterStr += "4";
		}
		return quarterStr;
	}

	/**
	 * 将时间格式化为yyyy-MM-dd HH:mm:ss类型字符串
	 * 
	 * @param date
	 * @return
	 */
	public static String format(Date date) {
		return sdf.format(date);
	}

	/**
	 * 将时间格式化为当天的开始 yyyy-MM-dd 00:00:00
	 * 
	 * @param date
	 * @return
	 */
	public static String formatDay(Date date) {
		return format.format(date);
	}

	public static String format(Date date, String formatStr) {
		if (null == formatStr || "".equals(formatStr)) {
			formatStr = "yyyy-MM-dd";
		}
		SimpleDateFormat format = new SimpleDateFormat(formatStr);
		return format.format(date);
	}

	/**
	 * 按月份格式化日期 yyyy-MM
	 * 
	 * @param date
	 * @return
	 */
	public static String monthFormat(Date date) {
		return monthFormat.format(date);
	}

	/**
	 * 按月份格式化日期 yyyyMM
	 * 
	 * @param date
	 * @return
	 */
	public static String shortMonthFormat(Date date) {
		return shortMonthFormat.format(date);
	}

	/**
	 * 到日期格式化(yyyy-MM-dd)
	 * 
	 * @param date
	 * @return
	 */
	public static String dateFormat(Date date) {
		return dateFormat.format(date);
	}

	/**
	 * 到日期格式化(yyyyMMdd)
	 * 
	 * @param date
	 * @return
	 */
	public static String shortDateFormat(Date date) {
		return shortDateFormat.format(date);
	}

	public static String chartFormat(Date date) {
		return chartFormat.format(date);
	}

	public static Date parseCST(String dateStr) {
		try {
			return cst.parse(dateStr);
		} catch (ParseException e) {
			try {
				return sdf.parse(dateStr);
			} catch (Exception e2) {
				log.error("日期转换错误:", e);
			}
		} catch (Exception e) {
			log.error("日期转换错误:", e);
		}
		return null;
	}

	public static Date parseDate(String dateStr, String formatStr) {
		if (formatStr == null || formatStr.equals("")) {
			formatStr = "yyyy-MM-dd";
		}
		SimpleDateFormat format = new SimpleDateFormat(formatStr);
		try {
			return format.parse(dateStr);
		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		}
	}

	public static Date parseDate(String dateStr) {
		try {
			return sdf.parse(dateStr);
		} catch (Exception e) {
			log.error("日期转换错误:", e);
		}
		return null;
	}

	/**
	 * 多个对象累加
	 * 
	 * @param objects
	 * @return
	 */
	public static String getString(Object... objects) {
		if (null == objects || objects.length == 0) {
			return "";
		}
		StringBuilder buf = new StringBuilder();
		for (Object object : objects) {
			buf.append(object);
		}
		return buf.toString();
	}

	/**
	 * 获得文件后缀
	 * 
	 * @param fileName
	 * @return
	 */
	public static String getSuffix(String fileName) {
		if (null == fileName || "".equals(fileName)) {
			return "";
		}
		int index = fileName.lastIndexOf(".");
		if (index > 0) {
			return fileName.substring(index + 1);
		}
		return "";
	}

	/**
	 * 将对象存入session
	 * 
	 * @param entity
	 */
	public static <T> void putEntityToSession(HttpServletRequest httpRequest, T entity) {
		HttpSession session = httpRequest.getSession();
		String classSimpleName = entity.getClass().getSimpleName();
		if (log.isDebugEnabled()) {
			log.debug("classSimpleName : " + classSimpleName);
		}
		session.setAttribute(classSimpleName, entity);
	}

	public static String getCookie(HttpServletRequest httpRequest, String name) {
		if (name == null || name.equals("")) {
			return null;
		}
		Cookie[] cookies = httpRequest.getCookies();
		if (cookies == null || cookies.length == 0) {
			return null;
		}
		for (Cookie cookie : cookies) {
			if (cookie.getName().equals(name)) {
				return cookie.getValue();
			}
		}
		return null;
	}

	public static void addCookie(HttpServletResponse response, String name, String value) {
		Cookie cookie = new Cookie(name, value);
		// 5年
		cookie.setMaxAge(5 * 365 * 24 * 60 * 60);
		cookie.setPath("/");
		response.addCookie(cookie);
	}

	public static void addCookie(HttpServletResponse response, String name, String value, int maxAge) {
		Cookie cookie = new Cookie(name, value);
		cookie.setMaxAge(maxAge);
		cookie.setPath("/");
		response.addCookie(cookie);
	}

	public static void removeCookie(HttpServletRequest httpRequest, HttpServletResponse response, String name) {
		if (name == null || name.equals("")) {
			return;
		}
		Cookie[] cookies = httpRequest.getCookies();
		if (cookies == null || cookies.length == 0) {
			return;
		}
		for (Cookie cookie : cookies) {
			if (cookie.getName().equals(name)) {
				cookie.setMaxAge(0);
				cookie.setPath("/");
				response.addCookie(cookie);
				break;
			}
		}
	}

	/**
	 * Session 活动状态
	 * 
	 * @param status
	 * @return
	 */
	public static String getSessionStatus(String status) {
		if (null == status) {
			return null;
		}
		String statusStr = "";
		if ("A".equalsIgnoreCase(status)) {
			statusStr = "活动";
		} else if ("O".equalsIgnoreCase(status)) {
			statusStr = "退出";
		} else if ("E".equalsIgnoreCase(status)) {
			statusStr = "过期";
		}
		return statusStr;
	}

	public static String getServerNameOnWindow() {
		String s = "";
		try {
			String s1 = "ipconfig /all";
			Process process = Runtime.getRuntime().exec(s1);
			BufferedReader bufferedreader = new BufferedReader(new InputStreamReader(process.getInputStream()));
			String nextLine;
			for (String line = bufferedreader.readLine(); line != null; line = nextLine) {
				nextLine = bufferedreader.readLine();
				String filter = "Host Name . . . . . . . . . . . . ";
				int index = line.indexOf(filter);
				if (index != -1) {
					int endIndex = line.indexOf(":", index);
					if (endIndex != -1) {
						s = line.substring(endIndex + 1);
						break;
					}
				}
			}
			bufferedreader.close();
			process.waitFor();
		} catch (Exception exception) {
			s = "";
		}
		return s.trim();
	}

	public static Date getDefaultDate() {
		Calendar ca = Calendar.getInstance();
		// ca.setTimeZone(TimeZone.getDefault());
		ca.set(Calendar.YEAR, 1900);
		ca.set(Calendar.MONTH, 0);
		ca.set(Calendar.DAY_OF_MONTH, 0);
		ca.set(Calendar.HOUR_OF_DAY, 0);
		ca.set(Calendar.MINUTE, 0);
		ca.set(Calendar.SECOND, 0);
		ca.set(Calendar.MILLISECOND, 0);
		return ca.getTime();
	}

	/**
	 * 获到一个文件的扩展名，并强制将扩展名变为小写
	 * 
	 * @param filename
	 * @return
	 */
	public static String getExt(String filename) {
		String ext = "";
		ext = filename.substring(filename.lastIndexOf(".") + 1);
		ext = ext.toLowerCase();
		return ext;
	}

	/**
	 * 将一个字符串前面补0,后一个参数是字返回字符串的总长度 (常用于将序列号转成定长)
	 * 
	 * @param seq
	 * @param len
	 * @return
	 */
	public static String getSeqStr(String seq, int len) {
		int seqLen = seq.length();
		StringBuilder buf = new StringBuilder(seq);
		if (len > seq.length()) {
			for (int i = 0; i < len - seqLen; i++) {
				buf.insert(0, "0");
			}
		}

		return buf.toString();
	}

	/**
	 * 获取List包含对象中指定属性名的数值并生成SQL判断语句中in的参数(,,,)
	 * 在Criteria中Restrictions.in使用时通过split转换为String[] in的参数需要在页面中传递在该方法中不直接转换为数组
	 * 
	 * @param list
	 * @param columnName
	 * @return
	 * @throws Exception
	 */
	public static String getRestrictionsIn(List list, String columnName) throws Exception {
		StringBuffer vals = new StringBuffer("");
		Object object = new Object();// 判断是否重复
		for (int i = 0; i < list.size(); i++) {
			Object obj = list.get(i);
			Class c = obj.getClass();
			// 属性名首字母大写
			String column = CommUtils.getString(columnName.substring(0, 1).toUpperCase(),
					columnName.substring(1).toLowerCase());
			// 获取get方法名称
			String methodNameOfGet = CommUtils.getString("get", column);
			// get属性方法
			Method methodOfGetView = c.getMethod(methodNameOfGet, null);
			// 获取数值
			Object val = methodOfGetView.invoke(obj, null);
			// 对空数据和重复数据过滤
			if (null != val && !object.equals(val)) {
				vals.append(val);
				vals.append(",");
				object = val;
			}
		}
		String str = vals.toString();
		if (str.length() > 0) {
			str = str.substring(0, str.length() - 1);
		}
		return str;
	}

	public static String decode(String str) {
		try {
			return URLDecoder.decode(str, "UTF-8");
		} catch (Exception e) {
			log.error("encode String error.", e);
		}
		return null;
	}

	/**
	 * 在in 子句 查询时需要将每个字符串加单引号
	 * 
	 * @param str
	 * @return
	 */
	public static String StringJoinQuotation(String str) {
		if (null == str || "".equals(str)) {
			return "";
		}
		StringBuffer buffer = new StringBuffer();
		String[] array = str.split(",");
		if (null != array && array.length > 0) {
			for (int i = 0; i < array.length; i++) {
				buffer.append("'" + array[i] + "'").append(",");
			}
		}
		String quotationStr = buffer.toString();
		if (quotationStr.endsWith(",")) {
			quotationStr = quotationStr.substring(0, quotationStr.length() - 1);
		}
		return quotationStr;
	}

	/**
	 * 原生SQL IN条件
	 * 
	 * @param str
	 */
	public static String getSqlIn(String[] str) {
		StringBuffer vals = new StringBuffer("");
		for (String val : str) {
			vals.append("'" + val + "',");
		}
		String ss = vals.toString();
		return ss.substring(0, ss.length() - 1);
	}

	public static String getSqlIn(List<String> strList) {
		StringBuffer vals = new StringBuffer();
		for (String val : strList) {
			vals.append("'" + val + "',");
		}
		String ss = vals.toString();
		return ss.substring(0, ss.length() - 1);
	}

	/**
	 * 拷贝属性
	 * 
	 * @param src
	 * @param dest
	 * @param b
	 */
	public static void copyProperties(Object src, Object dest) {
		try {
			Class srcClass = src.getClass();
			Class destClass = dest.getClass();

			Map<String, Field> srcFieldMap = new HashMap<String, Field>();
			getFields(srcClass, srcFieldMap);
			Map<String, Field> destFieldMap = new HashMap<String, Field>();
			getFields(destClass, destFieldMap);
			Iterator<String> it = srcFieldMap.keySet().iterator();
			while (it.hasNext()) {
				String name = it.next();
				Field srcField = srcFieldMap.get(name);
				Field destField = destFieldMap.get(name);
				if (destField != null) {
					srcField.setAccessible(true);
					destField.setAccessible(true);
					Object o = srcField.get(src);
					destField.set(dest, o);
				}
			}

		} catch (Exception e) {
			log.error("error.", e);
		}
	}

	/**
	 * 拷贝属性值 如果b=true表示源对象覆盖目标对象相同属性值，b=flase不覆盖
	 * 
	 * @param src
	 * @param dest
	 */
	@SuppressWarnings("rawtypes")
	public static void copyProperties(Object src, Object dest, boolean b) {
		try {
			Class srcClass = src.getClass();
			Class destClass = dest.getClass();
			Map<String, Field> srcFieldMap = new HashMap<String, Field>();
			getFields(srcClass, srcFieldMap);
			Map<String, Field> destFieldMap = new HashMap<String, Field>();
			getFields(destClass, destFieldMap);
			Iterator<String> it = srcFieldMap.keySet().iterator();
			while (it.hasNext()) {
				String name = it.next();
				if ("serialVersionUID".equals(name)) {
					continue;
				}
				Field srcField = srcFieldMap.get(name);
				Field destField = destFieldMap.get(name);
				if (destField != null) {
					srcField.setAccessible(true);
					destField.setAccessible(true);
					Object o = srcField.get(src);
					if (!b) {
						if (o != null && !o.equals("")) {
							destField.set(dest, o);
						}
					} else {
						destField.set(dest, o);
					}
				}
			}

		} catch (Exception e) {
			log.error("error.", e);
		}
	}

	public static boolean copy(File srcFile, File destFile) {
		boolean result = false;
		InputStream in = null;
		OutputStream out = null;
		try {
			in = new BufferedInputStream(new FileInputStream(srcFile), BUFFER_SIZE);
			out = new BufferedOutputStream(new FileOutputStream(destFile), BUFFER_SIZE);
			byte[] buffer = new byte[BUFFER_SIZE];
			int len = 0;
			while ((len = in.read(buffer)) > 0) {
				out.write(buffer, 0, len);
			}
			result = true;
		} catch (Exception e) {
			log.error("copy file error.", e);
			result = false;
		} finally {
			if (null != in) {
				try {
					in.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (null != out) {
				try {
					out.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return result;
	}

	public static void getPublicFields(Class clazz, Map<String, Field> fieldMap) {
		String className = clazz.getCanonicalName();
		String objectName = Object.class.getCanonicalName();
		if (className.equals(objectName)) {
			return;
		}
		Field[] fields = clazz.getFields();
		for (int i = 0; i < fields.length; i++) {
			String name = fields[i].getName();
			if (!fieldMap.containsKey(name)) {
				fieldMap.put(name, fields[i]);
			}
		}
		getFields(clazz.getSuperclass(), fieldMap);

	}

	public static void getFields(Class clazz, Map<String, Field> fieldMap) {
		String className = clazz.getCanonicalName();
		String objectName = Object.class.getCanonicalName();
		if (className.equals(objectName)) {
			return;
		}
		Field[] fields = clazz.getDeclaredFields();
		for (int i = 0; i < fields.length; i++) {
			String name = fields[i].getName();
			if (!fieldMap.containsKey(name)) {
				fieldMap.put(name, fields[i]);
			}
		}
		getFields(clazz.getSuperclass(), fieldMap);

	}

	/**
	 * 将对象列表中某个对象属性自动生成SQL中IN条件 参数条件不能超过1000
	 * 参数条件超过1000时使用Restrictions.sqlRestriction
	 * 
	 * @param list
	 * @param columnName
	 * @return
	 * @throws Exception
	 */
	public static String getSqlIn(List list, String columnName) throws Exception {
		StringBuffer vals = new StringBuffer("");
		Object object = new Object();// 判断是否重复
		for (int i = 0; i < list.size(); i++) {
			Object obj = list.get(i);
			Class c = obj.getClass();
			// 属性名首字母大写
			String column = CommUtils.getString(columnName.substring(0, 1).toUpperCase(),
					columnName.substring(1).toLowerCase());
			// 获取get方法名称
			String methodNameOfGet = CommUtils.getString("get", column);
			// get属性方法
			Method methodOfGetView = c.getMethod(methodNameOfGet, null);
			// 获取数值
			Object val = methodOfGetView.invoke(obj, null);
			// 对空数据和重复数据过滤
			if (null != val && !object.equals(val)) {
				vals.append("'" + val + "',");
				object = val;
			}
		}
		String str = vals.toString();
		return str.substring(0, str.length() - 1);
	}

	public static void flushData(String str, HttpServletResponse response) {
		OutputStream out = null;
		try {
			response.setContentType("text/html;charset=utf-8");
			byte[] data = str.getBytes("UTF-8");
			response.setContentLength(data.length);
			out = response.getOutputStream();
			out.write(data);
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void flushData(HttpServletResponse response, String str) {
		OutputStream out = null;
		try {
			response.setContentType("text/html;charset=utf-8");
			response.getHeaderNames().clear();
			byte[] data = str.getBytes("UTF-8");
			response.setContentLength(data.length);
			out = response.getOutputStream();
			out.write(data);
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {
		try {
			String start = "F600E1324";
			for (int i = 0; i < 100000; i++) {
				start = getNext(start);
			}
			  String str = new CommUtils().spilt("a,b,c,d,e,f");
			  System.out.println(str);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static String getNext(String currentValue) {
		int index = currentValue.length() - 1;
		char[] chars = currentValue.toCharArray();
		while (true) {
			if (chars[index] == '9') {
				chars[index--] = '0';
				continue;
			} else {
				chars[index]++;
				break;
			}
		}
		return new String(chars);
	}

	public static void close(Object obj) {
		if (obj != null) {
			try {
				Method m = obj.getClass().getMethod("close", null);
				m.invoke(obj, null);
			} catch (Exception e) {
			}
		}
	}

	public static void close(Object... objects) {
		for (Object object : objects) {
			CommUtils.close(object);
		}
	}

	public static String getRandString(int length) {
		StringBuffer buf = new StringBuffer();
		int alNum = 'Z' - 'A' + 1;
		for (int i = 0; i < length; i++) {
			int n = rand.nextInt(10 + alNum * 2);
			char c;
			if (n >= 10 + alNum) {
				c = (char) ('a' + n - alNum - 10);
			} else if (n >= 10) {
				c = (char) ('A' + n - 10);
			} else {
				c = (char) ('0' + n);
			}

			buf.append(c);
		}
		return buf.toString();

	}

	public static void block(long time) {
		try {
			Thread.sleep(time);
		} catch (Exception e) {
		}
	}

	// public static String getBeanInfo(Object object) {
	// if (object != null) {
	// return ToStringBuilder.reflectionToString(object);
	// }
	// return "object is null";
	// }

	/**
	 * 显示到目前为止，过去的时间
	 * 
	 * @param date
	 * @return
	 */
	public static String formatPassTime(Date date) {
		if (date == null) {
			return "";
		}
		long now = System.currentTimeMillis();
		long diff = (now - date.getTime()) / 1000;
		if (diff < 1) {
			return "1秒前";
		} else if (diff < 60) {
			return diff + "秒前";
		} else {
			diff = diff / 60;
			if (diff < 1) {
				return "1分前";
			} else if (diff < 60) {
				return diff + "分前";
			} else {
				diff = diff / 60;
				if (diff < 1) {
					return "1小时前";
				} else if (diff < 24) {
					return diff + "小时前";
				} else {
					diff = diff / 24;
					if (diff < 1) {
						return "1天前";
					} else if (diff < 7) {
						return diff + "天前";
					} else if (diff < 30) {
						diff = diff / 7;
						if (diff < 1) {
							return "1周前";
						}
						return diff + "周前";
					} else if (diff < 180) {
						diff = diff / 30;
						if (diff < 1) {
							return "1月前";
						}
						return diff + "月前";
					} else if (diff < 365) {
						return "半年前";
					} else {
						diff = diff / 365;
						return diff + "年前";
					}
				}
			}
		}

	}

	public static Integer[] StringToInt(String[] strArray) {
		Integer[] intArray = null;
		if (strArray != null && strArray.length > 0) {
			intArray = new Integer[strArray.length];
			for (int i = 0; i < strArray.length; i++) {
				if (strArray[i] == null || strArray[i].equals("")) {
					continue;
				}
				intArray[i] = Integer.parseInt(strArray[i]);
			}
		}
		return intArray;
	}

	public static List<String> toStringList(List<Integer> intIdList) {
		if (intIdList == null || intIdList.isEmpty()) {
			return null;
		}
		List<String> strIdList = new ArrayList<String>();
		for (Integer integer : intIdList) {
			strIdList.add(String.valueOf(integer));
		}
		return strIdList;
	}

	/**
	 * 根据对象列表获取对象主键的列表
	 * 
	 * @param entities
	 * @return
	 */
	// public static List<Integer> getKeyFieldFromEntity(List entities) {
	// try {
	// if (entities == null || entities.isEmpty()) {
	// return null;
	// }
	// List<Integer> idList = new ArrayList<Integer>();
	// for (Object object : entities) {
	// Class clazz = object.getClass();
	// String idName = getKeyFieldName(clazz);
	// Field field = clazz.getDeclaredField(idName);
	// field.setAccessible(true);
	// String type = field.getType().getSimpleName();
	// Object idObj = field.get(object);
	// if (idObj != null && (type.equals("Integer") || type.equals("int"))) {
	// idList.add(Integer.parseInt(idObj.toString()));
	// }
	// }
	// return idList;
	// } catch (Exception e) {
	// log.error("getKeyFieldFromEntity Error.", e);
	// }
	// return null;
	// }

	// public static <E> String getKeyFieldName(Class<E> clazz) {
	// try {
	// PropertyDescriptor[] propertyDescriptors =
	// Introspector.getBeanInfo(clazz).getPropertyDescriptors();
	// for (PropertyDescriptor propertydesc : propertyDescriptors) {
	// Method method = propertydesc.getReadMethod();
	// if (null != method && null !=
	// method.getAnnotation(javax.persistence.Id.class)) {
	// return propertydesc.getName();
	// }
	// }
	// } catch (Exception e) {
	// e.printStackTrace();
	// }
	// return "id";
	// }

	public static List<Integer> renderToFieldList(List list, String fieldName) {
		try {
			if (list == null || list.isEmpty()) {
				return null;
			}
			List<Integer> fieldNameList = new ArrayList<Integer>();
			for (Object object : list) {
				Class clazz = object.getClass();
				Field field = clazz.getDeclaredField(fieldName);
				field.setAccessible(true);
				Object id = field.get(object);
				if (id != null && !fieldNameList.contains(Integer.parseInt(id.toString()))) {
					fieldNameList.add(Integer.parseInt(id.toString()));
				}
			}
			return fieldNameList;
		} catch (Exception e) {
			log.error("renderToIdList Error.", e);
		}
		return null;
	}
	
	public static List<String> renderFieldToList(List list, String fieldName) {
		try {
			if (list == null || list.isEmpty()) {
				return null;
			}
			List<String> fieldNameList = new ArrayList<String>();
			for (Object object : list) {
				Class clazz = object.getClass();
				Field field = clazz.getDeclaredField(fieldName);
				field.setAccessible(true);
				Object id = field.get(object);
				if (id != null && !fieldNameList.contains(id.toString())) {
					fieldNameList.add(id.toString());
				}
			}
			return fieldNameList;
		} catch (Exception e) {
			log.error("renderToIdList Error.", e);
		}
		return null;
	}

	public static List<Integer> renderToPublicFieldList(List list, String fieldName) {
		try {
			if (list == null || list.isEmpty()) {
				return null;
			}
			List<Integer> fieldNameList = new ArrayList<Integer>();
			for (Object object : list) {
				Class clazz = object.getClass();
				Field field = clazz.getField(fieldName);
				field.setAccessible(true);
				Object id = field.get(object);
				if (id != null && !fieldNameList.contains(Integer.parseInt(id.toString()))) {
					fieldNameList.add(Integer.parseInt(id.toString()));
				}
			}
			return fieldNameList;
		} catch (Exception e) {
			log.error("renderToIdList Error.", e);
		}
		return null;
	}

	/**
	 * Bean --> Map 1: 利用Introspector和PropertyDescriptor 将Bean --> Map
	 * 
	 * @param obj
	 * @return
	 */
	public static Map<String, Object> bean2Map(Object obj) {

		if (obj == null) {
			return null;
		}
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			BeanInfo beanInfo = Introspector.getBeanInfo(obj.getClass());
			PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
			for (PropertyDescriptor property : propertyDescriptors) {
				String key = property.getName();
				String type = property.getPropertyType().getSimpleName();
				if (log.isDebugEnabled()) {
					log.debug(key + " : " + type);
				}
				// 过滤class属性
				if (key.equals("class")) {
					continue;
				}
				// 得到property对应的getter方法
				Method getter = property.getReadMethod();
				Object value = getter.invoke(obj);
				map.put(key, value);
			}
		} catch (Exception e) {
			log.error("bean2Map error.", e);
		}
		return map;
	}

	// public static boolean isCommonMethod(Class clazz, String property) {
	// try {
	// Method method = clazz.getMethod(property, null);
	// Annotation commonMethod = method.getAnnotation(CommonMethod.class);
	// if (commonMethod != null) {
	// return true;
	// }
	// } catch (Exception e) {
	// e.printStackTrace();
	// }
	// return false;
	// }
	/**
	 * 获取文件夹下所有文件
	 * 
	 * @param strPath
	 * @return
	 */
	public static List<File> getFileList(String strPath) {
		List<File> filelist = new ArrayList();
		File dir = new File(strPath);
		File[] files = dir.listFiles(); // 该文件目录下文件全部放入数组
		if (files != null) {
			for (int i = 0; i < files.length; i++) {
				String fileName = files[i].getName();
				if (files[i].isDirectory()) { // 判断是文件还是文件夹
					getFileList(files[i].getAbsolutePath()); // 获取文件绝对路径
				} else if (fileName.endsWith("bmp") || fileName.endsWith("jpg") || fileName.endsWith("gif")) { // 判断文件名是否以.avi结尾
					// String strFileName = files[i].getAbsolutePath();
					// logger.debug("---" + strFileName);
					log.info(files[i].getAbsolutePath());
					filelist.add(files[i]);
				} else {
					continue;
				}
			}
		}
		return filelist;
	}

	/**
	 * 生成文件
	 * 
	 * @param String
	 *            ilePath
	 * @param String
	 *            filename
	 * @param String
	 *            str 文件内容
	 * @param String
	 *            encode 文件格式
	 * @return file 返回目录
	 */
	public static File writeToFile(String filePath, String name, String str, String encode) {
		OutputStreamWriter fw = null;
		BufferedWriter bw = null;
		File file = null;
		try {
			file = new File(filePath);
			if (!file.exists()) {
				file.mkdirs();
			}
			fw = new OutputStreamWriter(new FileOutputStream(new File(filePath + name)), encode);
			bw = new BufferedWriter(fw);

			// 将读入的字符串写入到文件中
			bw.write(str, 0, str.length());
			bw.flush();

		} catch (IOException e) {
			// throw e;
			log.error("Error-- :" + e.toString());
		} finally {
			if (bw != null) {
				try {
					bw.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (fw != null) {
				try {
					fw.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return file;
	}

	public static boolean isNumeric(String str) {
		for (int i = str.length(); --i >= 0;) {
			if (!Character.isDigit(str.charAt(i))) {
				return false;
			}
		}
		return true;
	}

	public static boolean isEmpty(List list) {
		if (list == null || list.size() == 0) {
			return true;
		}
		return false;
	}

	/** 正则判断是否手机号码 */
	public static boolean isMobileNO(String mobiles) {
		Pattern p = Pattern.compile("^((13[0-9])|(15[^4,\\D])|(17[0-9])|(18[0-9]))\\d{8}$");
		Matcher m = p.matcher(mobiles);
		log.info("手机号 --- " + m.matches());
		return m.matches();
	}

	public static int daysBetween(String beginDate, String endDate) throws ParseException {
		if (StringUtils.isEmpty(beginDate) || StringUtils.isEmpty(endDate))
			return 0;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Calendar cal = Calendar.getInstance();
		cal.setTime(sdf.parse(beginDate));
		long time1 = cal.getTimeInMillis();
		cal.setTime(sdf.parse(endDate));
		long time2 = cal.getTimeInMillis();
		long between_days = (time2 - time1) / (1000 * 3600 * 24);

		return Integer.parseInt(String.valueOf(between_days));
	}

	public static int daysBetween(Date smdate, Date bdate) throws ParseException {
		if (null == smdate || bdate == null)
			return 0;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		smdate = sdf.parse(sdf.format(smdate));
		bdate = sdf.parse(sdf.format(bdate));
		Calendar cal = Calendar.getInstance();
		cal.setTime(smdate);
		long time1 = cal.getTimeInMillis();
		cal.setTime(bdate);
		long time2 = cal.getTimeInMillis();
		long between_days = (time2 - time1) / (1000 * 3600 * 24);

		return Integer.parseInt(String.valueOf(between_days));
	}

	/**
	 * sql过滤关键字 效验
	 * 
	 * @param str
	 * @return
	 */
	public static boolean sqlValidate(String str) {
		str = str.toLowerCase();// 统一转为小写
		StringBuffer badStr = new StringBuffer(
				"'|\"|and|exec|execute|insert|select|delete|update|count|drop|*|%|chr|mid|master|truncate|")
						.append("char|declare|sitename|net user|xp_cmdshell|;|or|-|+|,|like'|and|exec|execute|insert|create|drop|")
						.append("table|from|grant|use|group_concat|column_name|")
						.append("information_schema.columns|table_schema|union|where|select|delete|update|order|by|count|*|")
						.append("chr|mid|master|truncate|char|declare|or|;|-|--|+|,|like|//|/|%|#");// 过滤掉的sql关键字，可以手动添加
		String[] badStrs = badStr.toString().split("\\|");
		for (int i = 0; i < badStrs.length; i++) {
			if (str.indexOf(badStrs[i]) >= 0) {
				return true;
			}
		}
		return false;
	}

	/**
	 * 判断是否<11位的数字
	 * 
	 * @param param
	 * @return
	 */
	public static boolean isNum11Param(String param) {
		return !param.equals("0") && param.matches("^[0-9]+$") && param.length() < 11;
	}

	/**
	 * 
	 * @param date
	 *            日期
	 * @param format
	 *            显示格式,周/星期
	 * @return
	 */
	public static String getWeekOfDate(Date date, String format) {
		String[] weekOfDays = { "日", "一", "二", "三", "四", "五", "六" };
		Calendar calendar = Calendar.getInstance();
		if (date != null) {
			calendar.setTime(date);
		}
		int w = calendar.get(Calendar.DAY_OF_WEEK) - 1;
		if (w < 0) {
			w = 0;
		}
		return format + weekOfDays[w];
	}

	/**
	 * 把64bit编码转化成普通字符串
	 * 
	 * @param s
	 * @param enc
	 *            编码
	 * @return
	 */
	public static String Base64ToStr(String s, String enc) {
		if (s == null)
			return null;
		BASE64Decoder decoder = new BASE64Decoder();
		try {
			byte[] b = decoder.decodeBuffer(s);
			return new String(b, enc);
		} catch (Exception e) {
			return null;
		}
	}

	/**
	 * 把64bit编码转化成普通字符串再decode
	 * 
	 * @param s
	 *            内容
	 * @param enc
	 *            编码
	 * @return
	 */
	public static String URLDecoderStr(String s, String enc) {
		if (StringUtils.isEmpty(s))
			return null;

		if (StringUtils.isEmpty(enc))
			enc = "UTF-8";

		s = CommUtils.Base64ToStr(s, enc);
		try {
			s = URLDecoder.decode(s, enc);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return s;
	}
	/**
	 * 將 逗號 “，” 字符串 拆分為  ，單引號 + 字符串 
	 * @param str
	 * @return
	 */
	 public static String spilt(String str) {
		  StringBuffer sb = new StringBuffer();
		  String[] temp = str.split(",");
		  for (int i = 0; i < temp.length; i++) {
		   if (!"".equals(temp[i]) && temp[i] != null)
		    sb.append("'" + temp[i] + "',");
		  }
		  String result = sb.toString();
		  String tp = result.substring(result.length() - 1, result.length());
		  if (",".equals(tp))
		   return result.substring(0, result.length() - 1);
		  else
		   return result;
		 }
}
