package cn.com.edzleft.util;

import java.util.ResourceBundle;

/**
 * 项目参数工具类
 * 
 */
public class ConfigUtil {
	
	
//	这个类的作用就是读取资源属性文件（properties），然后根据.properties文件的名称信息（本地化信息），匹配当前系统的国别语言信息（也可以程序指定），然后获取相应的properties文件的内容。
	

	//config代表 properties配置文件的名称！！！
	private static final ResourceBundle bundle = ResourceBundle.getBundle("config/config");

	/**
	 * 获得sessionInfo名字
	 * 
	 * @return
	*/
	public static final String getSessionInfoName() {

		return bundle.getString("sessionInfoName");
	}

	/**
	 * 通过键获取值
	 * 
	 * @param key
	 * @return
	 */
	public static final String get(String key) {
		return bundle.getString(key);
	}
	
	public static void main(String[] args) {
		String str = get("uploadPath");
		System.out.println(str);
	}
	
}
