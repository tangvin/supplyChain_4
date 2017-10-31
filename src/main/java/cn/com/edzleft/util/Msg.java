package cn.com.edzleft.util;
import java.io.OutputStream;
import java.io.PrintWriter;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSONObject;

public class Msg {
	/**
	 * 页面输出
	 * @param response
	 */
	public static void flush(HttpServletResponse response,String data) {
		OutputStream out = null;
		try {
			response.setContentType("text/plain;charset=utf-8");
			out = response.getOutputStream();
			byte[] bytes = data.getBytes("UTF-8");
			response.setContentLength(bytes.length);
			out.write(bytes);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (out != null) {
					out.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * 输出指定格式的json数据
	 * @param response
	 * @param data
	 * @param msg
	 * @param status
	 */
	public static void flush(HttpServletResponse response,String data,String msg,Integer status) {
		PrintWriter out=null;
		try {
			response.setContentType("text/plain;charset=utf-8");
			out = response.getWriter();
			JSONObject jsonObj=new JSONObject();
			jsonObj.put("Status", status);//页面返回状态码
			jsonObj.put("Msg", msg);//页面提示
			jsonObj.put("Data", data);//数据
			out.println(jsonObj);
			out.flush();
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void flushContent(HttpServletResponse response,String content){
		response.setContentType("text/html;charset=utf-8");
		try {
			PrintWriter out = response.getWriter();
			out.println(content);
			//out.println("<script>alert('登录失效，请重新登录');locatiopn.href='/userManage/login';</script>");
			out.flush();
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
