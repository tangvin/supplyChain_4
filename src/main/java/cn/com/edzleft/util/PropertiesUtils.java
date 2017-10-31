package cn.com.edzleft.util;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;

import com.bhcx.entity.ProperityEntry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PropertiesUtils {
    private static Properties properties = null;
    private static final Logger log = LoggerFactory.getLogger(PropertiesUtils.class);
    static {
        InputStream ins = PropertiesUtils.class.getClassLoader().getResourceAsStream("openation.properties");
        properties = new Properties();
        try {
            properties.load(ins);
        } catch (IOException e) {
            log.error("读取配置文件信息出错",e);
        }
    }
    public static void main(String[] args) {
        System.out.println(getValue("ip"));
    }
    
    
    public static List<ProperityEntry> getProperty(){
	List<ProperityEntry> ddMap = new ArrayList<ProperityEntry>();
	 Iterator<Entry<Object, Object>> iterator = properties.entrySet().iterator();
	while (iterator.hasNext()) {
	    Entry e = (Entry) iterator.next();
	    ProperityEntry proty = new ProperityEntry();
	    proty.setId((String)e.getKey());
	    proty.setName((String)e.getValue());
	    ddMap.add(proty);
	}
	
	return ddMap;
    }
    
    //根据key查询值
    public static String getValue(String key){
	String property = properties.getProperty(key);
	return property;
    }
}
