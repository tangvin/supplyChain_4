package cn.com.edzleft.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.Properties;

//关于Properties类常用的操作

/**
 * 配置文件读取
 * @author tiger
 *
 */
public class DataUtils {
	
	private static String fileName = "/config/system.properties";
	private static String fileName2 = "/config/errorCode.properties";
    //根据Key读取Value
    public static String GetValueByKey(String key) {
        Properties pps = new Properties();
        try {
            //InputStream in = new BufferedInputStream (new FileInputStream(filePath));  
        	InputStream in = DataUtils.class.getResourceAsStream(fileName);
            pps.load(in);
            String value = pps.getProperty(key);
            //System.out.println(key + " = " + value);
            return value;
            
        }catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 根据code获取msg
     * @param code
     * @return
     */
    public static String getMsgByCode(String code) {
        Properties pps = new Properties();
        try {
            InputStream in = DataUtils.class.getResourceAsStream(fileName2);
            pps.load(in);
            String msg = pps.getProperty(code);
            return msg;

        }catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
    
    //读取Properties的全部信息
    public static Enumeration<?> GetAllProperties() throws IOException {
        Properties pps = new Properties();
        InputStream in = DataUtils.class.getResourceAsStream(fileName);
        pps.load(in);
        Enumeration<?> en = pps.propertyNames(); //得到配置文件的名字
        
        /*while(en.hasMoreElements()) {
            String strKey = (String) en.nextElement();
            String strValue = pps.getProperty(strKey);
            System.out.println(strKey + "=" + strValue);
        }*/
        return en;
    }
    
   /* //写入Properties信息
    public static void WriteProperties (String pKey, String pValue) throws IOException {
        Properties pps = new Properties();
        
        InputStream in = DataUtils.class.getResourceAsStream(fileName);  
        //从输入流中读取属性列表（键和元素对） 
        pps.load(in);
        //调用 Hashtable 的方法 put。使用 getProperty 方法提供并行性。  
        //强制要求为属性的键和值使用字符串。返回值是 Hashtable 调用 put 的结果。
        OutputStream out = new FileOutputStream(filePath);
        pps.setProperty(pKey, pValue);
        //以适合使用 load 方法加载到 Properties 表中的格式，  
        //将此 Properties 表中的属性列表（键和元素对）写入输出流  
        pps.store(out, "Update " + pKey + " name");
    }*/
    
    /*public static void main(String [] args) throws IOException{
        String value = GetValueByKey("aes_live_time");
        System.out.println(value);
        GetAllProperties();
        //WriteProperties("Test.properties","long", "212");
    }*/
}