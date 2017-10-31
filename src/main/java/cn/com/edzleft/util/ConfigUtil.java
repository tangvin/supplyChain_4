package cn.com.edzleft.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * 读取配置文件
 * @author MR.Chan
 *
 */
public class ConfigUtil {
	private static Properties props = new Properties();

	static {
		try {
			//play框架下要用这种方式加载
			props.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("/config/wechat.properties"));
			//props.load(ConfKit.class.getResourceAsStream("/wechat.properties"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void settingValue(String key,String value){
		// 读取配置文件
        FileInputStream inputStream=null;
		// 写到配置文件
        FileOutputStream outputStream=null;
        Properties prop = new Properties();
		try { 
	        inputStream = new FileInputStream(props.getProperty("ConfigFileName"));
	        // 加载
	        prop.load(inputStream);
	        // 获取
	        prop.getProperty(key);
	        // 设置
	        prop.setProperty(key, value);
			outputStream = new FileOutputStream(props.getProperty("ConfigFileName"));
			prop.store(outputStream, "修改成功.....................");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			try {
				if(inputStream!=null){
					inputStream.close();
				}
				if(outputStream!=null){
					outputStream.close();
				}
				if(prop!=null){
					prop.clear();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public static String get(String key) {
		return props.getProperty(key);
	}

    public static void setProps(Properties p){
        props = p;
    }
}
