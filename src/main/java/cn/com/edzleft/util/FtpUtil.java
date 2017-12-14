package cn.com.edzleft.util;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;


import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;
import org.apache.commons.net.ftp.FTPReply;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URL;
import java.net.URLConnection;

public class FtpUtil {  
	  
    /**  
     * Description: 向FTP服务器上传文件  
     * @param host FTP服务器hostname  
     * @param port FTP服务器端口  
     * @param username FTP登录账号  
     * @param password FTP登录密码  
     * @param basePath FTP服务器基础目录 
     * @param filePath FTP服务器文件存放路径。例如分日期存放：/2015/01/01。文件的路径为basePath+filePath 
     * @param filename 上传到FTP服务器上的文件名  
     * @param input 输入流  
     * @return 成功返回true，否则返回false  
     */    
    public static boolean uploadFile(String host, int port, String username, String password, String basePath,  
            String filePath, String filename, InputStream input) {  
    	boolean result = false;  
        FTPClient ftp = new FTPClient(); 
       // ftp.setControlEncoding("UTF-8");
        try {  
            int reply;  
            ftp.connect(host, port);// 连接FTP服务器  
            // 如果采用默认端口，可以使用ftp.connect(host)的方式直接连接FTP服务器  
            ftp.login(username, password);// 登录  
           /* ftp.enterLocalPassiveMode();
            ftp.setFileTransferMode(FTP.STREAM_TRANSFER_MODE);*/
            reply = ftp.getReplyCode();  
            if (!FTPReply.isPositiveCompletion(reply)) {  
                ftp.disconnect();  
                return result;  
            }  
            //切换到上传目录  
            if (!ftp.changeWorkingDirectory(basePath+filePath)) {  
                //如果目录不存在创建目录  
                String[] dirs = filePath.split("/");  
                String tempPath = basePath;  
                for (String dir : dirs) {  
                    if (null == dir || "".equals(dir)) continue;  
                    tempPath += "/" + dir;  
                    if (!ftp.changeWorkingDirectory(tempPath)) {  
                        if (!ftp.makeDirectory(tempPath)) {  
                            return result;  
                        } else {  
                            ftp.changeWorkingDirectory(tempPath);  
                        }  
                    }  
                }  
            }  
            //设置上传文件的类型为二进制类型  
            ftp.setFileType(FTP.BINARY_FILE_TYPE);  
            //上传文件  
            if (!ftp.storeFile(filename,input)) {  
                return result;  
            }  
            input.close();  
            ftp.logout();  
            result = true;  
        } catch (IOException e) {  
            e.printStackTrace();  
        } finally {  
            if (ftp.isConnected()) {  
                try {  
                    ftp.disconnect();  
                } catch (IOException ioe) {  
                }  
            }  
        }  
        return result;  
    }  
      
    /**  
     * Description: 从FTP服务器下载文件  
     * @param host FTP服务器hostname  
     * @param port FTP服务器端口  
     * @param username FTP登录账号  
     * @param password FTP登录密码  
     * @param remotePath FTP服务器上的相对路径  
     * @param fileName 要下载的文件名  
     * @param localPath 下载后保存到本地的路径  
     * @return  
     */    
    public static boolean downloadFile(String host, int port, String username, String password, String remotePath,  
            String fileName, String localPath) {  
        boolean result = false;  
        FTPClient ftp = new FTPClient();  
        try {  
            int reply;  
            ftp.connect(host, port);  
            // 如果采用默认端口，可以使用ftp.connect(host)的方式直接连接FTP服务器  
            ftp.login(username, password);// 登录  
            reply = ftp.getReplyCode();  
            if (!FTPReply.isPositiveCompletion(reply)) {  
                ftp.disconnect();  
                return result;  
            }  
            ftp.changeWorkingDirectory(remotePath);// 转移到FTP服务器目录  
            FTPFile[] fs = ftp.listFiles();  
            for (FTPFile ff : fs) {  
                if (ff.getName().equals(fileName)) {  
                    File localFile = new File(localPath + "/" + ff.getName());  
  
                    OutputStream is = new FileOutputStream(localFile);  
                    ftp.retrieveFile(ff.getName(), is);  
                    is.close();  
                }  
            }  
  
            ftp.logout();  
            result = true;  
        } catch (IOException e) {  
            e.printStackTrace();  
        } finally {  
            if (ftp.isConnected()) {  
                try {  
                    ftp.disconnect();  
                } catch (IOException ioe) {  
                }  
            }  
        }  
        return result;  
    }

    private static final Logger log = Logger.getLogger(FtpUtil.class);
    /**
     * <p>方法描述: [从ftp中获得图片流返给页面]</p>
     *
     * @param username 用户名
     * @param password 密码
     * @param ftpUrl  ftp的url
     * @param fileUrl 文件路径
     * @param response Response对象
     */
    public static void getFtpImage(String username, String password, String ftpUrl, String fileUrl,
                                   HttpServletResponse response) {
        InputStream isr = null;
        OutputStream out = null;
        URL u  = null;
        try {
            if ((fileUrl != null) && !"".equals(fileUrl)) {
                response.setHeader("Content-Type", "image/png"); //response.setContentType("image/*"); // 设置返回的文件类型
                out = response.getOutputStream();
                StringBuffer sb = new StringBuffer("ftp://");
                sb.append(username + ":");
                sb.append(password + "@");
                sb.append(ftpUrl + "/" + fileUrl);
                u = new URL(sb.toString());
                URLConnection urlconn = u.openConnection();
                isr = urlconn.getInputStream();
                int len = urlconn.getContentLength();
                int i = len;
                int c;
                while (((c = isr.read()) != -1) && (--i > 0)) {
                    out.write(c);
                }
                log.info("获取ftp图片" + fileUrl);
            } else {
                log.warn("所要显示的图片路径为空");
            }
        } catch (Exception e) {
            log.error(e.getMessage());
        } finally {
            try {
                if (isr != null) {
                    isr.close();
                }
                if (out != null) {
                    out.close();
                }
            } catch (IOException e) {
                log.error(e.getMessage());
            }
        }
    }

    /**
     *      * @param username 用户名
     * @param password 密码
     * @param ftpUrl  ftp的url
     * @param fileUrl 文件路径
     * @param area
     */





}

