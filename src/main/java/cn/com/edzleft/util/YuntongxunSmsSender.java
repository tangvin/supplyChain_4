package cn.com.edzleft.util;

import java.util.HashMap;

import org.apache.commons.lang.StringUtils;

import com.cloopen.rest.sdk.CCPRestSmsSDK;

public class YuntongxunSmsSender
{

	/**
	 * 发送短信验证码
	 *
	 * @param toMobile
	 *            对方手机号
	 * @param templateId
	 *            短信模板
	 * @param replaceParams
	 *            短信模板里要替换的参数
	 * @return
	 */
	public static HashMap<String, Object> send(String toMobile, String templateId, String... replaceParams)
	{
		templateId = StringUtils.isNotBlank(templateId) ? templateId : DEFAULT_TEMPLATE;
		CCPRestSmsSDK restAPI = new CCPRestSmsSDK();
		restAPI.init(serverId, serverPort);
		restAPI.setAccount(accountSid, authToken);
		restAPI.setAppId(appId);
		HashMap<String, Object> result = restAPI.sendTemplateSMS(toMobile, templateId, replaceParams);
		return result;

	}

	public static  boolean send(String toMobile, String verifycode)
	{

		HashMap<String, Object> result = send(toMobile, DEFAULT_TEMPLATE, verifycode, String.valueOf(maxMinutes));
		return SUCCESS_CODE.equals(result.get("statusCode"));
	}

	public static void main(String[] args) {

		System.out.println(YuntongxunSmsSender.send("18610793685", "520520"));
	}




	/** 发送成功返回的状态码 **/
	public static final String SUCCESS_CODE = "000000";
	/** 默认短信模板 **/
	public static final String DEFAULT_TEMPLATE = "181426";
	private static String serverId = "sandboxapp.cloopen.com";
	private static String serverPort = "8883";
	private static String accountSid = "8aaf0708570871f801571d2cb9d50b3a";
	private static String appId = "8a216da85c62c9ad015c869951eb0daa";
	private static String authToken = "8fba07b3e8e74130b6a1992f87c818dd";

	private static int maxMinutes = 5;

}
