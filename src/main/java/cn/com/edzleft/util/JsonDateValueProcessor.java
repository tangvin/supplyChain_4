package cn.com.edzleft.util;

import net.sf.json.JsonConfig;
import net.sf.json.processors.JsonValueProcessor;

import java.text.SimpleDateFormat;
import java.util.Date;

public class JsonDateValueProcessor implements JsonValueProcessor {  
    private String format ="yyyy年MM月dd日";  
      
    public JsonDateValueProcessor() {  
        super();  
    }  
      
    public JsonDateValueProcessor(String format) {  
        super();  
        this.format = format;  
    }  
  
    public Object processArrayValue(Object paramObject,  
            JsonConfig paramJsonConfig) {  
        return process(paramObject);  
    }  
  
    public Object processObjectValue(String paramString, Object paramObject,  
            JsonConfig paramJsonConfig) {  
        return process(paramObject);  
    }  
      
      
    private Object process(Object value){  
        if(value instanceof Date){    
            SimpleDateFormat sdf = new SimpleDateFormat(format); 
            return sdf.format(value);  
        }    
        return value == null ? "" : value.toString();    
    }  
  
}  