package cn.com.edzleft.controller.captial.signing;

import cn.com.edzleft.entity.Contract;
import cn.com.edzleft.service.captial.signing.SigningService;
import cn.com.edzleft.util.page.DataGridJson;
import cn.com.edzleft.util.page.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by ASUS on 2017/11/2.
 */
@Controller
@RequestMapping(value="/signing")
public class SigningController {

    @Autowired
    private SigningService signingService;


    /**
     *查询合同签约订单
     * @return
     */
    @RequestMapping(value = "/signingSelect",method = RequestMethod.POST)
    @ResponseBody
    public DataGridJson signingSelect(Integer pageNumber,Integer pageSize , PageUtil<Contract> userPage){
        DataGridJson dgj = new DataGridJson();
        userPage.setCpage(pageNumber);
        userPage.setPageSize(pageSize);
        userPage = signingService.getOrderEntityListByConditions(userPage);
        dgj.setTotal(userPage.getTotalCount());
        dgj.setRows(userPage.getList());
        return dgj;
    }



}
