package cn.com.edzleft.controller.trade.freight;

import cn.com.edzleft.entity.Freight;
import cn.com.edzleft.entity.SessionInfo;
import cn.com.edzleft.service.trade.freight.FreightService;
import com.paypal.api.openidconnect.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by ibmtech on 2017/11/22.
 */
@Controller
@RequestMapping(value = "/freight")
public class FreightController {

    @Autowired
    private FreightService freightService;


    /**
     * 查询所有的货运单位
     */
    @RequestMapping("/getAllFreight")
    @ResponseBody
    public List<Freight> getAllFreight(HttpServletRequest request, HttpServletResponse response, HttpSession sessionInfo){
        response.setContentType("text/plain");
        response.setHeader("Pragma", "No-cache");
        response.setCharacterEncoding("UTF-8");
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expires", 0);
        response.setHeader("Access-Control-Allow-Origin", "*");//添加跨域访问
        String jsonpCallback = request.getParameter("jsonpCallback");

        SessionInfo session = (SessionInfo) sessionInfo.getAttribute("sessionInfo");
        Integer userId = session.getAdmin().getUserId();
        List<Freight> freights = freightService.queryFreightByAccountId(userId);
        return freights;
    }

    /**
     * 添加货运单位
     */
    @RequestMapping(value = "/addFreight",method = RequestMethod.POST)
    @ResponseBody
    public int addFreight(Freight f,HttpSession session){
        int i = freightService.addFreight(f,session);
        return i;
    }

    /**
     * 根据id删除货运单位
     */
    @RequestMapping(value = "/deleteFreight",method = RequestMethod.POST)
    @ResponseBody
    public int cutFreight(Integer id){
         int flag = freightService.deleteFreight(id);
         return flag;
    }


    /**
     * 设置默认货运单位
     */
    @RequestMapping(value = "/setDefault",method = RequestMethod.POST)
    @ResponseBody
    public int setDefaultAddress(Integer id,Integer value,HttpSession session){
        int flag = freightService.setDefaultAddress(id,session,value);
        return flag;
    }

    /**
     * 根据用户id查询查询出当前的货运单位
     */
    @RequestMapping(value = "/freightSelect",method = RequestMethod.POST)
    @ResponseBody
    public List<Freight> freightSelect(HttpSession sessionInfo){
        SessionInfo session = (SessionInfo) sessionInfo.getAttribute("sessionInfo");
        Integer userId = session.getAdmin().getUserId();
        List<Freight> freightList = freightService.queryFreightByAccountId(userId);
        return  freightList;
    }


}
