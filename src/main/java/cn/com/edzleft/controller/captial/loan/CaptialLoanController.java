package cn.com.edzleft.controller.captial.loan;

import cn.com.edzleft.entity.Loan;
import cn.com.edzleft.service.captial.loan.CaptialLoanService;
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
@RequestMapping(value = "/captialLoan")
public class CaptialLoanController {

    @Autowired
    private CaptialLoanService captialLoanService;


    /**
     * 贷款管理
     * @param pageNumber
     * @param pageSize
     * @param lender 贷款方
     * @param loanAmount 贷款金额
     * @param occurrenceTime 开始时间
     * @param expirationTime  结束时间
     * @param loanStatus 贷款状态
     * @return
     */
    @RequestMapping(value = "/loansSelect",method = RequestMethod.POST)
    @ResponseBody
    public DataGridJson loansSelect(Integer pageNumber, Integer pageSize , String lender, String loanAmount, String occurrenceTime, String expirationTime,String loanStatus){
        PageUtil<Loan> userPage = new PageUtil<>();
        HashMap<String,Object> whereMaps =new HashMap<>();
        whereMaps.put("lender",lender);
        whereMaps.put("loanAmount",loanAmount);
        whereMaps.put("occurrenceTime",occurrenceTime);
        whereMaps.put("expirationTime",expirationTime);
        whereMaps.put("loanStatus",loanStatus);
        DataGridJson dgj = new DataGridJson();
        userPage.setCpage(pageNumber);
        userPage.setPageSize(pageSize);
        userPage.setWhereMap(whereMaps);
        userPage = captialLoanService.loansSelect(userPage);
        dgj.setTotal(userPage.getTotalCount());
        dgj.setRows(userPage.getList());
        return dgj;
    }

}
