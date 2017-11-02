package cn.com.edzleft.util.sms;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 短信工具类
 * Created by Mr.checn
 * DateTime 2017/3/23.11:26
 */
public class SmsUtil {
    private final static String UID="26";//企信通uid
    private final static String PWD="874078";//密码
    public static void main(String[] args) {
        SmsUtil y=new SmsUtil();
        //sendSmsCode("17319079281",y.getRandNum(5));
        //try{
            //SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMddHHmmss");
           // String time=sdf.format(new Date());
            //System.out.println(time);
            //String md5Pwd= MD5Util.EncoderByMd5(PWD+time);
            //System.out.println(md5Pwd);
            //sendSmsCode("17319079281","88585");
        //String md5Pwd= MD5Util.string2MD5("87407820170515154653");
            //System.out.println(md5Pwd);

        /*}catch (NoSuchAlgorithmException e){
            e.printStackTrace();
        }catch (UnsupportedEncodingException e){
            e.printStackTrace();
        }*/
        System.out.println(sendSmsCode("18610793685","88585"));
        //System.out.println("-1".length());
    }

    public static boolean sendSmsCode(String phone,String code){
        try {
            String content= URLEncoder.encode("【蒜你好】亲爱的用户，您的验证码是：" + code + "，5分钟内有效。", "UTF-8");
            SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMddHHmmss");
            String time=sdf.format(new Date());
            System.out.println(time);
            String md5Pwd= MD5Util.string2MD5(PWD + time);
            System.out.println(md5Pwd);
            String url="http://47.93.90.240:18002/send.do?uid="+UID+"&pw="+md5Pwd+"&mb="+phone+"&ms="+content+"&ex=&tm="+time;
            System.out.println(url);
            String data=CommonUtil.sendGetInfo(url);
            System.out.println(data);
            if(data!=null&&!data.equals("")&&data.length()>2){
                String[] dataStr=data.split(",");
                if(dataStr.length>1){
                    if(dataStr[0].equals("0")){
                        return true;
                    }
                }
            }
        }/*catch (NoSuchAlgorithmException e){
            e.printStackTrace();
        }*/catch (UnsupportedEncodingException e){
            e.printStackTrace();
        }
        return false;
    }
    /**
     * 生成验证码
     * @param charCount
     * @return
     */
    public static String getRandNum(int charCount) {
        String charValue = "";
        for (int i = 0; i < charCount; i++) {
            char c = (char) (randomInt(0, 10) + '0');
            charValue += String.valueOf(c);
        }
        return charValue;
    }
    public static int randomInt(int from, int to) {
        Random r = new Random();
        return from + r.nextInt(to - from);
    }
    /** 正则判断是否手机号码 */
    public static boolean isMobileNO(String mobiles) {
        Pattern p = Pattern.compile("^((13[0-9])|(15[^4,\\D])|(17[0-9])|(18[0-9]))\\d{8}$");
        Matcher m = p.matcher(mobiles);
        return m.matches();
    }
}
