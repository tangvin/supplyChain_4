package cn.com.edzleft.util.sms;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import java.io.*;
import java.net.ConnectException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.UUID;

/**
 * 公共工具类
 * Created by Mr.checn
 * DateTime 2017/3/23.14:03
 */
public class CommonUtil {


    /**
     * 生成一个用户token
     * @return
     */
    public static String createToken(){
        Object token=UUID.randomUUID();//随机码
        if(token!=null){
            String newToken=token.toString();
            if(newToken.length()>40){
                newToken= newToken.substring(0,40);
            }
            return newToken.toUpperCase().replaceAll("-", "");
        }else{
            return createToken();//没有生成则回调，重新生成
        }
    }

    /**
     * 发送get请求
     * @param urlPath
     * @return
     */
    public static String sendGetInfo(String urlPath){
        StringBuffer sb = new StringBuffer();
        try {
            URL url = new URL(urlPath);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setConnectTimeout(5000);//设置请求接口时间为5秒
            connection.connect();
            InputStream inputStream = connection.getInputStream();
            //对应的字符编码转换
            Reader reader = new InputStreamReader(inputStream, "UTF-8");
            BufferedReader bufferedReader = new BufferedReader(reader);
            String str = null;
            while ((str = bufferedReader.readLine()) != null) {
                sb.append(str);
            }
            reader.close();
            connection.disconnect();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sb.toString();//获取数据
    }

    public static String httpsRequestToString(String requestUrl, String requestMethod, String outputStr) {
        StringBuffer buffer = new StringBuffer();
        try {
            // 创建SSLContext对象，并使用我们指定的信任管理器初始化
            TrustManager[] tm = { new MyX509TrustManager() };
            SSLContext sslContext = SSLContext.getInstance("SSL", "SunJSSE");
            sslContext.init(null, tm, new java.security.SecureRandom());
            // 从上述SSLContext对象中得到SSLSocketFactory对象
            SSLSocketFactory ssf = sslContext.getSocketFactory();

            URL url = new URL(requestUrl);
            HttpsURLConnection conn = (HttpsURLConnection) url.openConnection();
            conn.setSSLSocketFactory(ssf);

            conn.setDoOutput(true);
            conn.setDoInput(true);
            conn.setUseCaches(false);
            // 设置请求方式（GET/POST）
            conn.setRequestMethod(requestMethod);
            // 当outputStr不为null时向输出流写数据
            if (null != outputStr) {
                OutputStream outputStream = conn.getOutputStream();
                // 注意编码格式
                outputStream.write(outputStr.getBytes("UTF-8"));
                outputStream.close();
            }

            // 从输入流读取返回内容
            InputStream inputStream = conn.getInputStream();
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "utf-8");
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            String str = null;
            while ((str = bufferedReader.readLine()) != null) {
                buffer.append(str);
            }

            // 释放资源
            bufferedReader.close();
            inputStreamReader.close();
            inputStream.close();
            inputStream = null;
            conn.disconnect();
        } catch (ConnectException ce) {
        } catch (Exception e) {
        }
        return buffer.toString();
    }
}
