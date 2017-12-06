package cn.com.edzleft.controller.captial.repayments;

import cn.com.edzleft.entity.Repayments;
import cn.com.edzleft.service.captial.repayments.CaptialRepaymentsServce;
import cn.com.edzleft.util.page.DataGridJson;
import cn.com.edzleft.util.page.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;

/**
 * Created by ASUS on 2017/12/4.
 */
@Controller
@RequestMapping("repayment")
public class CaptialRepayController {

    @Autowired
    private CaptialRepaymentsServce captialRepaymentsServce;

    /**
     *
     * @param pageNumber
     * @param pageSize
     * @param repaymentsPerson 还款方
     * @param repaymentsAmount 还款金额
     * @param repaymentsStatus 还款状态
     * @param endTime 结束时间
     * @param creatTime 开始时间
     * @return
     */
    @RequestMapping(value = "/repaymentSelect",method = RequestMethod.POST)
    @ResponseBody
    public DataGridJson repaymentSelect(Integer pageNumber, Integer pageSize , String repaymentsPerson, String repaymentsAmount, String repaymentsStatus,String endTime,String creatTime){
        PageUtil<Repayments> userPage = new PageUtil<>();
        HashMap<String,Object> whereMaps =new HashMap<>();
        whereMaps.put("repaymentsPerson",repaymentsPerson);
        whereMaps.put("repaymentsAmount",repaymentsAmount);
        whereMaps.put("repaymentsStatus",repaymentsStatus);
        whereMaps.put("endTime",endTime);
        whereMaps.put("creatTime",creatTime);
        DataGridJson dgj = new DataGridJson();
        userPage.setCpage(pageNumber);
        userPage.setPageSize(pageSize);
        userPage.setWhereMap(whereMaps);
        userPage = captialRepaymentsServce.repaymentSelect(userPage);
        dgj.setTotal(userPage.getTotalCount());
        dgj.setRows(userPage.getList());
        return dgj;
    }


}
