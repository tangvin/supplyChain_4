package cn.com.edzleft.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by ASUS on 2017/11/29.
 */

public class file {


    /**
     * 获得20150803 --> 15/8/3,15/12/6,15/2/15,15/10/3文件夹形式
     *
     * @param
     * @return 15/10/3文件夹形式
     */
    public static String endFileDir () {
        Date date = new Date(System. currentTimeMillis());
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd" );
        String str = sdf.format(date).toString();
        StringBuffer sb = new StringBuffer();
        char[] timeArr = str.toCharArray();
        sb = sb.append(timeArr[2]).append(timeArr[3]);

        // str = ""+timeArr[2]+timeArr[3];
        if (timeArr[4] != '0') {
            sb = sb.append(timeArr[4]);
            // str+=timeArr[4];
        }
        sb = sb.append(timeArr[5]).append( "/");
        // str+=""+timeArr[5]+"/";//根据当前系统环境确定分隔符


        //确定天数作为文件夹,测试部不需要天数，直接注释即可
        if(timeArr[6]!= '0'){
            sb = sb.append(timeArr[6]);
        }
        sb = sb.append(timeArr[7]).append( "/");
        return sb.toString().trim();
    }


    /**
     * @Title: uploadImg 上传的图片流
     * @param path 图片上传的路径
     * @param fileItem 图片文件
     * @return
     * @return: boolean
     */
    private static boolean uploadImg (String path, String imgName, byte[] imgByte) {
        // Linux服务器是反斜杠
        path=path.replaceAll( "/", "\\\\");
        File filePath = new File(path);
        filePath.setWritable( true, false);
        if (!filePath.exists()) {
            filePath.mkdirs();
        }
        boolean isSuccess = false;
        File file = new File(path + imgName);
        FileOutputStream output = null;
        try {
            output = new FileOutputStream(file);
            output.write(imgByte);
            output.flush();
            isSuccess = true;
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            isSuccess = false;
        } finally {
            try {
                if (output != null) {
                    output.close();
                }
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        return isSuccess;
    }

}
