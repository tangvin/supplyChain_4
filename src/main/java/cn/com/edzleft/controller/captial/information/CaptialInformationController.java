package cn.com.edzleft.controller.captial.information;

import cn.com.edzleft.entity.Information;
import cn.com.edzleft.service.captial.information.CaptialInformationService;
import cn.com.edzleft.util.UploadFileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by ASUS on 2017/11/29.
 */
@RequestMapping("captialInformation")
@Controller
public class CaptialInformationController {

    @Autowired
    private CaptialInformationService captialInformationService;

    @RequestMapping(value = "updateInformation",method = RequestMethod.POST)
    public String updateInformation(Information information){
        captialInformationService.updateInformation(information);
        return "";
    }

    @RequestMapping(value = "upLoInsert",method = RequestMethod.POST)
    @ResponseBody
        public String upLoInsert(HttpServletRequest request, @RequestParam("userImg")MultipartFile file){

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
        String imgUuidName = UploadFileUtil.uploadFile(request, file, "uploadImgPath");



//        boolean a = FileUtiles.uploadImg(imgSavePath,imgName,imgByte);
//        if(a){
//            return "成功";
//        }
        return imgUuidName;
    }


}
