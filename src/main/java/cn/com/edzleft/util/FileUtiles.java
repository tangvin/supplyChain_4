package cn.com.edzleft.util;

import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

/**
 * Created by ASUS on 2017/12/3.
 */
public class FileUtiles {

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
     * @param  图片文件
     * @return
     * @return: boolean
     */
    public static boolean uploadImg (String path, String imgName, byte[] imgByte) {
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
        //上传到的文件--- 路径+UUID文件名
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


    //上传文件--返回值文件的UUID名称---参数：上传的文件 ，上传的文件原名称，上传的文件路径
    public static  String  uploadFile(MultipartFile uploadFile , String fileName , String uploadPath ){
        String uuidName = null;

        //文件字节输入流
        FileOutputStream fos = null;
        //	缓冲字节输入流
        BufferedOutputStream bos = null;
        //文件字节输出流
        InputStream is = null;
        //缓冲字节输出流
        BufferedInputStream bis = null;
    // Linux服务器是反斜杠
//        uploadPath=uploadPath.replaceAll( "/", "\\\\");
        //上传的文件路径
        File filePath = new File(uploadPath);
        //判断有无上传的文件夹
        if (! filePath.exists()) {
            filePath.mkdirs();//创建上传的文件夹
        }

        //获取一个随机数
        String uuidStr = UUID.randomUUID().toString();

        // UUID随机数+"_" +文件后缀名   --->w34q324dssfasdf_.jpg
        uuidName = uuidStr+"_"+getSuffix(fileName);

        //上传到的文件--- 路径+UUID文件名
        File f = new File(uploadPath+"/"+uuidName);

        try {
            is = uploadFile.getInputStream();
            bis = new BufferedInputStream(is);
            fos = new FileOutputStream(f);
            bos = new BufferedOutputStream(fos);//缓冲流 提高效率
            byte [] b = new byte[2048];
            int s = 0;
            while (  (s = bis.read(b)) != -1 ) {
                bos.write(b, 0, s);
                bos.flush();//刷新--强制写出缓冲区
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally{

            closeIO(is, bis, fos, bos);
        }
        return uuidName;
    }

    // 截取上传文件的后缀名（扩展名）
    private static String getSuffix(String fileName) {
        int pos = fileName.lastIndexOf(".");
        String suffix = fileName.substring(pos);
        return suffix;
    }

    public static void closeIO(InputStream fis , BufferedInputStream bis , OutputStream fos , BufferedOutputStream bos){

        try {
            if (bos != null) {
                bos.flush();
                bos.close();
                bos = null;
            }
            if (fos  != null) {
                fos.flush();
                fos.close();
                fos = null;
            }
            if (bis != null) {
                bis.close();
                bis = null;
            }
            if (fis != null) {
                fis.close();
                fis = null;
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

}
