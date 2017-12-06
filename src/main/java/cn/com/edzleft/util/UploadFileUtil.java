package cn.com.edzleft.util;


import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by ASUS on 2017/12/3.
 */
public class UploadFileUtil {


    /**
     * springmvc文件上传
     * @param request
     * @param file 上传文件
     * @param pathFolder 文件存储文件夹
     * @return
     */
    public static String uploadFile(HttpServletRequest request, MultipartFile file, String pathFolder){
        String uuidName = null;

//        String attachPath =  PropertiesUtil.getProperties(pathFolder);
//        String realAttachPath = request.getServletContext().getRealPath(attachPath);
        uuidName =  FileUtiles.uploadFile(file,file.getOriginalFilename(),pathFolder);

        return uuidName;
    }

}
