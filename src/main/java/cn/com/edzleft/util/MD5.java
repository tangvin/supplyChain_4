package cn.com.edzleft.util;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SignatureException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.DigestUtils;

/**
 * 功能：MD5签名处理核心
 * 
 */
public class MD5 {
	private static Logger logger = LoggerFactory.getLogger(MD5.class);
	private static String projectName="HappyTree";
	/**
	 * 签名字符串
	 * 
	 * @param text
	 *            需要签名的字符串
	 * @param key
	 *            密钥
	 * @param input_charset
	 *            编码格式
	 * @return 签名结果
	 */
	public static String sign(String text, String key, String input_charset) {
		text = text + key;
//		return DigestUtils.md5Hex(getContentBytes(text, input_charset));
		return DigestUtils.md5DigestAsHex(getContentBytes(text, input_charset));
	}
	/**
	 * 签名加密
	 * @param text 需要加密的串
	 */
	public static String sign(String text){
		return sign(text,projectName, "utf-8");
	}
	
	/**
	 * 签名字符串
	 * 
	 * @param text
	 *            需要签名的字符串
	 * @param sign
	 *            签名结果
	 * @param key
	 *            密钥
	 * @param input_charset
	 *            编码格式
	 * @return 签名结果
	 */
	public static boolean verify(String text, String sign, String key, String input_charset) {
		text = text + key;
//		String mysign = DigestUtils.md5Hex(getContentBytes(text, input_charset));
		String mysign = DigestUtils.md5DigestAsHex(getContentBytes(text, input_charset));
		if (mysign.equals(sign)) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * @param content
	 * @param charset
	 * @return
	 * @throws SignatureException
	 * @throws UnsupportedEncodingException
	 */
	private static byte[] getContentBytes(String content, String charset) {
		if (charset == null || "".equals(charset)) {
			return content.getBytes();
		}
		try {
			return content.getBytes(charset);
		} catch (UnsupportedEncodingException e) {
			throw new RuntimeException("MD5签名过程中出现错误,指定的编码集不对,您目前指定的编码集是:" + charset);
		}
	}

	/**
	 * 生成6位或10位随机数 param codeLength(多少位)
	 * 
	 * @return
	 */
	public static String createCode(int codeLength) {
		String code = "";
		for (int i = 0; i < codeLength; i++) {
			code += (int) (Math.random() * 9);
		}
		return code;
	}

	@SuppressWarnings("unused")
	private static boolean isValidChar(char ch) {
		if ((ch >= '0' && ch <= '9') || (ch >= 'A' && ch <= 'Z') || (ch >= 'a' && ch <= 'z'))
			return true;
		if ((ch >= 0x4e00 && ch <= 0x7fff) || (ch >= 0x8000 && ch <= 0x952f))
			return true;// 简体中文汉字编码
		return false;
	}

	/**
	 * 除去数组中的空值和签名参数
	 * 
	 * @param sArray
	 *            签名参数组
	 * @return 去掉空值与签名参数后的新签名参数组
	 */
	public static Map<String, String> paraFilter(Map<String, String> sArray) {

		Map<String, String> result = new HashMap<String, String>();

		if (sArray == null || sArray.size() <= 0) {
			return result;
		}

		for (String key : sArray.keySet()) {
			String value = sArray.get(key);
			if (value == null || value.equals("") || key.equalsIgnoreCase("sign") || key.equalsIgnoreCase("sign_type")) {
				continue;
			}
			result.put(key, value);
		}

		return result;
	}

	/**
	 * 把数组所有元素排序，并按照“参数=参数值”的模式用“&”字符拼接成字符串
	 * 
	 * @param params
	 *            需要排序并参与字符拼接的参数组
	 * @return 拼接后字符串
	 */
	public static String createLinkString(Map<String, String> params) {

		List<String> keys = new ArrayList<String>(params.keySet());
		Collections.sort(keys);

		String prestr = "";

		for (int i = 0; i < keys.size(); i++) {
			String key = keys.get(i);
			String value = params.get(key);

			if (i == keys.size() - 1) {// 拼接时，不包括最后一个&字符
				prestr = prestr + key + "=" + value;
			} else {
				prestr = prestr + key + "=" + value + "&";
			}
		}

		return prestr;
	}
	/**
	 * SHA 加密
	 * @param params 加密值
	 * @return 返回加密后的串
	 */
	public static String SHA(String params) {

		String s1 = "";
		if (params.trim() == null)
			return "null";
		try {
			s1 = System.getProperty("SHA.algorithm", "SHA");
		} catch (SecurityException _ex) {
		}
		MessageDigest messagedigest = null;
		try {
			messagedigest = MessageDigest.getInstance(s1);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		byte abyte0[] = params.getBytes();
		messagedigest.update(abyte0);
		byte abyte1[] = messagedigest.digest();
		BigInteger biginteger = new BigInteger(abyte1);
		return biginteger.toString(32);
	}
	public static void main(String[] args) {
		String str = MD5.sign("1123", projectName, "utf-8");
		logger.info(str);
		boolean flg = MD5.verify("1123", "7d4b8efd9708fb98eab9ee7dd7835fbe", "key", "utf-8");
		logger.info(flg+"");
		logger.info(SHA("root"));
		logger.info(SHA("123456"));
	}
}