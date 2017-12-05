package cn.com.edzleft.controller.trade.freight;

import cn.com.edzleft.entity.Freight;
import cn.com.edzleft.service.trade.freight.FreightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
    public List<Freight> getAllFreight(HttpServletRequest request,HttpServletResponse response){
        response.setContentType("text/plain");
        response.setHeader("Pragma", "No-cache");
        response.setCharacterEncoding("UTF-8");
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expires", 0);
        response.setHeader("Access-Control-Allow-Origin", "*");//添加跨域访问
        String jsonpCallback = request.getParameter("jsonpCallback");

        List<Freight> freights = freightService.queryAllFreight();
        return freights;
    }

    /**
     * 添加货运单位
     */
    @RequestMapping("/addFreight")
    public void  addFreight(Freight f){
        freightService.addFreight(f);
    }

    /**
     * 根据id删除货运单位
     */
    @RequestMapping("/deleteFreight")
    public void cutFreight(Integer id){
        freightService.deleteFreight(id);
    }

    /**
     * 设置默认货运单位
     */
    @RequestMapping("/setDefault")
    public void setDefaultAddress(Freight freight){
        freightService.setDefaultAddress(freight);
    }


}
