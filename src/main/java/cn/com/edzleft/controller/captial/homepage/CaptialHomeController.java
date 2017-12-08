package cn.com.edzleft.controller.captial.homepage;

import cn.com.edzleft.entity.Account;

import cn.com.edzleft.entity.Code;
import cn.com.edzleft.entity.SessionInfo;
import cn.com.edzleft.service.captial.homepage.CaptialHomePageService;
import cn.com.edzleft.service.captial.homepage.CodeService;
import cn.com.edzleft.service.trade.account.AccountService;
import cn.com.edzleft.util.noteMsg;

import com.aliyuncs.dysmsapi.model.v20170525.QuerySendDetailsResponse;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.aliyuncs.exceptions.ClientException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by ASUS on 2017/11/24.
 */
@Controller
@RequestMapping("/captialHomes")
public class CaptialHomeController {

    @Autowired
    private CaptialHomePageService captialHomePageService;
    @Autowired
    private AccountService accountService;
    @Autowired
    private CodeService codeService;

    /**
     * 获取短信验证码
     * @param session
     * @return
     */
    @RequestMapping(value = "sendMsg",method = RequestMethod.POST)
    @ResponseBody
    public String sendMsg(HttpSession session){
        //发短信
        SendSmsResponse response = null;
        Code code = new Code();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            //获取session中userId
            SessionInfo sessionInfo = (SessionInfo) session.getAttribute("sessionInfo");
            Account sessionAccount=sessionInfo.getAdmin();
            String userPhone=sessionAccount.getUserPhone();
            String img = noteMsg.imgCodes();
            session.setAttribute("sendCodes",img);
            response = noteMsg.sendSms(userPhone,img);
            Thread.sleep(3000L);
            //查明细
            if(response.getCode() != null && response.getCode().equals("OK")) {
                QuerySendDetailsResponse querySendDetailsResponse = noteMsg.querySendDetails(response.getBizId(),userPhone);
                int i = 0;
                for(QuerySendDetailsResponse.SmsSendDetailDTO smsSendDetailDTO : querySendDetailsResponse.getSmsSendDetailDTOs())
                {
                    System.out.println("SmsSendDetailDTO["+i+"]:");
                    System.out.println("Content=" + smsSendDetailDTO.getContent());
                    System.out.println("ErrCode=" + smsSendDetailDTO.getErrCode());
                    System.out.println("OutId=" + smsSendDetailDTO.getOutId());
                    System.out.println("PhoneNum=" + smsSendDetailDTO.getPhoneNum());
                    System.out.println("ReceiveDate=" + smsSendDetailDTO.getReceiveDate());
                    System.out.println("SendDate=" + smsSendDetailDTO.getSendDate());
                    session.setAttribute("SendDate",smsSendDetailDTO.getSendDate());
                    System.out.println("SendStatus=" + smsSendDetailDTO.getSendStatus());
                    System.out.println("Template=" + smsSendDetailDTO.getTemplateCode());
                    code.setCode(img);
                    code.setUserId(sessionAccount.getUserId());
                    code.setCreatTime(new Date());
                    codeService.insertCode(code);
                }
                System.out.println("TotalCount=" + querySendDetailsResponse.getTotalCount());
                System.out.println("RequestId=" + querySendDetailsResponse.getRequestId());
            }
        } catch (ClientException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 获取短信验证码
     * @param session
     * @return
     */
    @RequestMapping(value = "sendMsgBank",method = RequestMethod.POST)
    @ResponseBody
    public String sendMsgBank(String userPhone,HttpSession session){
        //发短信
        SendSmsResponse response = null;
        Code code = new Code();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            //获取session中userId
            SessionInfo sessionInfo = (SessionInfo) session.getAttribute("sessionInfo");
            Account sessionAccount=sessionInfo.getAdmin();
            String img = noteMsg.imgCodes();
            session.setAttribute("sendCodes",img);
            response = noteMsg.sendSms(userPhone,img);
            Thread.sleep(3000L);
            //查明细
            if(response.getCode() != null && response.getCode().equals("OK")) {
                QuerySendDetailsResponse querySendDetailsResponse = noteMsg.querySendDetails(response.getBizId(),userPhone);
                int i = 0;
                for(QuerySendDetailsResponse.SmsSendDetailDTO smsSendDetailDTO : querySendDetailsResponse.getSmsSendDetailDTOs())
                {
                    System.out.println("SmsSendDetailDTO["+i+"]:");
                    System.out.println("Content=" + smsSendDetailDTO.getContent());
                    System.out.println("ErrCode=" + smsSendDetailDTO.getErrCode());
                    System.out.println("OutId=" + smsSendDetailDTO.getOutId());
                    System.out.println("PhoneNum=" + smsSendDetailDTO.getPhoneNum());
                    System.out.println("ReceiveDate=" + smsSendDetailDTO.getReceiveDate());
                    System.out.println("SendDate=" + smsSendDetailDTO.getSendDate());
                    session.setAttribute("SendDate",smsSendDetailDTO.getSendDate());
                    System.out.println("SendStatus=" + smsSendDetailDTO.getSendStatus());
                    System.out.println("Template=" + smsSendDetailDTO.getTemplateCode());
                    code.setCode(img);
                    code.setUserId(sessionAccount.getUserId());
                    code.setCreatTime(new Date());
                    codeService.insertCode(code);
                }
                System.out.println("TotalCount=" + querySendDetailsResponse.getTotalCount());
                System.out.println("RequestId=" + querySendDetailsResponse.getRequestId());
            }
        } catch (ClientException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return null;
    }

}
