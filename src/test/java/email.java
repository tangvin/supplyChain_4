

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;


/**
 * Created by ASUS on 2017/12/20.
 */
public class email {

    public static void main(String[] args){
        StringBuilder emailContent = new StringBuilder("<!DOCTYPE html><html><head><meta charset='UTF-8'><title>快来买桃子</title><style type='text/css'>        .container{            font-family: 'Microsoft YaHei';            width: 600px;            margin: 0 auto;            padding: 8px;            border: 3px dashed #db303f;            border-radius: 6px;        }        .title{            text-align: center;            color: #db303f;        }        .content{            text-align: justify;            color: #717273;            font-weight: 600;        }        footer{            text-align: right;            color: #db303f;            font-weight: 600;            font-size: 18px;        }</style></head><body><div class='container'><h2 class='title'>好吃的桃子</h2><p class='content'>桃子含有维生素A、维生素B和维生素C,儿童多吃桃子可使身体健康成长,因为桃子含有的多种维生索可以直接强化他们的身体和智力。</p><footer>联系桃子：11110000</footer></div></body></html>");
        try {
            String host = "smtp.mxhichina.com";//这是QQ邮箱的smtp服务器地址
            String port = "25"; //端口号
            /*
            *Properties是一个属性对象，用来创建Session对象
            */
            Properties props = new Properties();
            props.setProperty("mail.smtp.host", host);
            props.setProperty("mail.smtp.port", port);
            props.setProperty("mail.smtp.auth", "true");
            props.setProperty("mail.smtp.ssl.enable", "false");//"true"
            props.setProperty("mail.smtp.connectiontimeout", "5000");
            final String user ="service@cnfinatech.com";//用户名
            final String pwd = "Mchl123456";//密码
            /*
            *Session类定义了一个基本的邮件对话。
            */
            Session session = Session.getInstance(props, new Authenticator() {
                @Override
                protected PasswordAuthentication getPasswordAuthentication() {
                    //登录用户名密码
                    return new PasswordAuthentication(user,pwd);
                }
            });
            session.setDebug(true);
            /*
            *Transport类用来发送邮件。
            *传入参数smtp，transport将自动按照smtp协议发送邮件。
            */
            Transport transport = session.getTransport("smtp");//"smtps"
            transport.connect(host,user,pwd);
            /*
            *Message对象用来储存实际发送的电子邮件信息
            */
            MimeMessage message = new MimeMessage(session);
            message.setSubject("邮件标题");
            //消息发送者接收者设置(发件地址，昵称)，收件人看到的昵称是这里设定的
            message.setFrom(new InternetAddress(user,"飞迅金服"));
            message.addRecipients(Message.RecipientType.TO,new InternetAddress[]{
                    //消息接收者(收件地址，昵称)
                    //不过这个昵称貌似没有看到效果
                    new InternetAddress("653809545@qq.com","飞迅金服"),
            });
            message.saveChanges();

            //设置邮件内容及编码格式
            //后一个参数可以不指定编码，如"text/plain"，但是将不能显示中文字符
            message.setContent(createEmail().toString(), "text/plain;charset=UTF-8");
            //发送
            //transport.send(message);
            Transport.send(message);
            transport.close();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    private static StringBuilder createEmail() {
        StringBuilder emailContent = new StringBuilder("<!DOCTYPE html><html><head><meta charset='UTF-8'><title>快来买桃子</title><style type='text/css'>        .container{            font-family: 'Microsoft YaHei';            width: 600px;            margin: 0 auto;            padding: 8px;            border: 3px dashed #db303f;            border-radius: 6px;        }        .title{            text-align: center;            color: #db303f;        }        .content{            text-align: justify;            color: #717273;            font-weight: 600;        }        footer{            text-align: right;            color: #db303f;            font-weight: 600;            font-size: 18px;        }</style></head><body><div class='container'><h2 class='title'>好吃的桃子</h2><p class='content'>桃子含有维生素A、维生素B和维生素C,儿童多吃桃子可使身体健康成长,因为桃子含有的多种维生索可以直接强化他们的身体和智力。</p><footer>联系桃子：11110000</footer></div></body></html>");
        return emailContent;
    }

}
