package cn.com.edzleft.controller.captial.information;

import cn.com.edzleft.entity.Account;
import cn.com.edzleft.entity.Information;
import cn.com.edzleft.entity.SessionInfo;
import cn.com.edzleft.service.captial.information.CaptialInformationService;
import cn.com.edzleft.service.trade.account.AccountService;
import cn.com.edzleft.util.UploadFileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by ASUS on 2017/11/29.
 */
@RequestMapping("captialInformation")
@Controller
public class CaptialInformationController {

    @Autowired
    private CaptialInformationService captialInformationService;
    @Autowired
    private AccountService accountService;


    @RequestMapping(value = "updateInformation",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> updateInformation(Information information, HttpSession session,Account accounts){
    	Map<String,Object> map = new HashMap<>();
        SessionInfo sessionInfo = (SessionInfo) session.getAttribute("sessionInfo");
        Integer userId = sessionInfo.getAdmin().getUserId();
        Integer informationId = accounts.getInformationId();
        if(informationId == null){
            information.setCreatorId(userId);
            information.setCertificationStatus(0);
            int i = captialInformationService.insertInformation(information);
            if(i>0){
                Information informationUserId =  captialInformationService.selectInformation(userId);
                Integer creatorId = informationUserId.getId();
                Account account = new Account();
                account.setUserId(userId);
                account.setInformationId(creatorId);
                int t =  accountService.updataAccount(account);
            }
            map.put("msg", "添加成功");
            map.put("success", true);
            return map;
        }else{
            int i = captialInformationService.updateInformation(information);
            map.put("msg", "修改成功");
            map.put("success", true);
            return map;
        }
    }

    @RequestMapping(value = "upLoInsert",method = RequestMethod.POST)
    @ResponseBody
    public String upLoInsert(HttpServletRequest request, @RequestParam("file1")MultipartFile file1,HttpServletResponse response){

        response.setContentType("text/plain");
        response.setHeader("Pragma", "No-cache");
        response.setCharacterEncoding("UTF-8");
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expires", 0);
        response.setHeader("Access-Control-Allow-Origin", "*");//添加跨域访问
        String jsonpCallback = request.getParameter("jsonpCallback");
//        String imgData = file.getOriginalFilename();// Base64的字符串
//
//        BASE64Decoder decoder = new BASE64Decoder();
//        byte[] imgByte = new byte[0];
//        try {
//            imgByte = decoder.decodeBuffer(imgData);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        for ( int i = 0; i < imgByte. length; ++i) {
//            if (imgByte[i] < 0) { // 调整异常数据
//                imgByte[i] += 256;
//            }
//        }
//        String endFile = FileUtiles.endFileDir();
//        String imgName = file.getOriginalFilename();//图片名
        //相册uuid名称
        String imgUuidName = UploadFileUtil.uploadFile(request, file1, "uploadImgPath");



//        boolean a = FileUtiles.uploadImg(imgSavePath,imgName,imgByte);
//        if(a){
//            return "成功";
//        }
        return imgUuidName;
    }


}
