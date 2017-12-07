package cn.com.edzleft.controller.trade.invoice;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import cn.com.edzleft.util.FtpUtil;
@Service
public class Ftp {
	 //获取ip地址  
     
    public static final String FTP_ADDRESS="47.104.103.141";
    //端口号  
     
    public static final String FTP_PORT="21";  
    //用户名  
      
    public static final String FTP_USERNAME="gylftpuser";  
    //密码  
      
    public static final String FTP_PASSWORD="gylftppwd";  
    //基本路径  
      
    public static final String FTP_BASEPATH="/home/gylftpuser/uploadfile";  
    //下载地址地基础url  
      
    public static final String IMAGE_BASE_URL="http://47.104.103.141/uploadfile";
    
    
    public Map uploadPicture(MultipartFile uploadFile) {  
        Map resultmMap = new HashMap<>();  
  
        try {  
            // 生成一个文件名  
            // 获取旧的名字  
            String oldName = uploadFile.getOriginalFilename();
            int nodePosition = oldName.lastIndexOf(".");
            String newName = UUID.randomUUID().toString().replaceAll("-", "").toUpperCase() + oldName.substring(nodePosition);
            //新名字  
            //newName = newName + oldName.substring(oldName.lastIndexOf("."));  
            //上传的路径  
            String imagePath = "/ukey";  
            //端口号  
            int port = Integer.parseInt(FTP_PORT);  
            System.out.println(FTP_BASEPATH);  
            //调用方法，上传文件  
            boolean result = FtpUtil.uploadFile(FTP_ADDRESS, port,  
                    FTP_USERNAME, FTP_PASSWORD, FTP_BASEPATH, imagePath,  
                    newName, uploadFile.getInputStream());  
            //判断是否上传成功  
            if (!result) {  
                resultmMap.put("error", 1);  
                resultmMap.put("message", "上传失败");  
                return resultmMap;  
            }  
            resultmMap.put("error", 0);  
            resultmMap.put("url", IMAGE_BASE_URL + imagePath + newName);  
            return resultmMap;  
  
        } catch (IOException e) {  
            resultmMap.put("error", 1);  
            resultmMap.put("message", "上传发生异常");  
            return resultmMap;  
        }  
    }  
}
