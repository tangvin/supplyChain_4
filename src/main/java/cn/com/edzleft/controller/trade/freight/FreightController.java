package cn.com.edzleft.controller.trade.freight;

import cn.com.edzleft.entity.Freight;
import cn.com.edzleft.service.trade.freight.FreightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
    public List<Freight> getAllFreight(){
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
