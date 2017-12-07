package cn.com.edzleft.controller.captial.api;

import cn.com.edzleft.service.captial.letter.CaptialLetterService;
import cn.com.edzleft.service.captial.repayments.CaptialRepaymentsServce;
import cn.com.edzleft.service.procurement.oder.PmOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by ASUS on 2017/12/5.
 */
@Controller
@RequestMapping("api")
public class ApiController {


    @Autowired
    private PmOrderService pmOrderService;

    @Autowired
    private CaptialLetterService letterService;

    @Autowired
    private CaptialRepaymentsServce captialRepaymentsServce;


    /**
     * 还款接口查询
     */
    @RequestMapping(value = "repayment",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> selectRepayment(HttpServletRequest request, HttpServletResponse response){

        response.setContentType("text/plain");
        response.setHeader("Pragma", "No-cache");
        response.setCharacterEncoding("UTF-8");
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expires", 0);
        response.setHeader("Access-Control-Allow-Origin", "*");//添加跨域访问
        List<Map<String,Object>> list = captialRepaymentsServce.selectRepayment();
        Map<String,Object> map = new HashMap<>();
        map.put("data",list);
        return map;
    }

    /**
     * 授信接口查询
     */
    @RequestMapping(value = "credit",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> selectCredit(HttpServletRequest request, HttpServletResponse response){

        response.setContentType("text/plain");
        response.setHeader("Pragma", "No-cache");
        response.setCharacterEncoding("UTF-8");
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expires", 0);
        response.setHeader("Access-Control-Allow-Origin", "*");//添加跨域访问
        List<Map<String,Object>> list = letterService.creditSelect();
        Map<String,Object> map = new HashMap<>();
        map.put("data",list);
        return map;
    }
    /**
     * 接口用信查询
     * @return
     */
    @RequestMapping(value = "letter",method = RequestMethod.POST)
    @ResponseBody
    private Map<String,Object> selectOrderLetter(HttpServletRequest request, HttpServletResponse response){

        response.setContentType("text/plain");
        response.setHeader("Pragma", "No-cache");
        response.setCharacterEncoding("UTF-8");
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expires", 0);
        response.setHeader("Access-Control-Allow-Origin", "*");//添加跨域访问

        Map<String,Object> map = new HashMap<>();
        List<Map<String, Object>> letters = pmOrderService.selectOrderLetter();
        map.put("data",letters);
        return map;
    }

}
