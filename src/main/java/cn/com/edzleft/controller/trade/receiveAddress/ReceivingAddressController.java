package cn.com.edzleft.controller.trade.receiveAddress;

import cn.com.edzleft.entity.ReceivingAddress;
import cn.com.edzleft.service.trade.receivingAddress.ReceivingAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by ibmtech on 2017/11/22.
 */
@Controller
@RequestMapping(value = "/receivingAddress")
public class ReceivingAddressController {

    @Autowired
    private ReceivingAddressService receivingAddressService;

    /**
     * 查询收货地址
     * @return
     */
    @RequestMapping(value = "queryAll",method = RequestMethod.POST)
    @ResponseBody
    public List<ReceivingAddress> getAllAddress(){
        List<ReceivingAddress> list = receivingAddressService.queryAllAddress();
        return list;
    }

    /**
     * 添加收货地址
     */
    @RequestMapping("/addAddress")
    public void addReceivingAddress(ReceivingAddress address){
        receivingAddressService.addReceivingAddress(address);
    }

    /**
     * 删除收货地址
     */
    @RequestMapping("/deleteAddress")
    public void cutAddress(Integer id){
        receivingAddressService.deleteReceivingAddress(id);
    }

    /**
     * 修改收货地址
     */
    @RequestMapping("/modiflyAddress")
    public void modiflyAddress(ReceivingAddress address){
    receivingAddressService.modiflyAddress(address);
    }
}
