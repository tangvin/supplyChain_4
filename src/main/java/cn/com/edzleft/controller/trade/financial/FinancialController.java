package cn.com.edzleft.controller.trade.financial;

import cn.com.edzleft.entity.Account;
import cn.com.edzleft.entity.Financial;
import cn.com.edzleft.entity.SessionInfo;
import cn.com.edzleft.service.trade.financial.FinancialService;
import cn.com.edzleft.util.page.DataGridJson;
import cn.com.edzleft.util.page.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.HashMap;

/**
 * Created by ibmtech on 2017/12/5.
 */
@Controller
@RequestMapping("/financial")
public class FinancialController {

    @Autowired
    private FinancialService financialService;


    /**
     * 财务查询
     * @param pageNumber
     * @param pageSize
     * @param financialType
     * @param billTime
     * @return
     */
    @RequestMapping(value = "/getAllFinancial",method = RequestMethod.POST)
    @ResponseBody
    public DataGridJson getLetterByPage(Integer pageNumber, Integer pageSize , String financialType, String billTime, String payer, String bankCard, HttpSession session){
        PageUtil<Financial> pageUtil = new PageUtil<>();
        HashMap<String,Object> whereMaps =new HashMap<>();

        whereMaps.put("financialType",financialType);
        whereMaps.put("billTime",billTime);
        whereMaps.put("payer",payer);
        whereMaps.put("bankAccount",bankCard);
        SessionInfo sessionInfo = (SessionInfo) session.getAttribute("sessionInfo");
        Account sessionAccount=sessionInfo.getAdmin();
        Integer userId = sessionAccount.getUserId();

        whereMaps.put("userId",userId);
        DataGridJson dgj = new DataGridJson();
        pageUtil.setCpage(pageNumber);
        pageUtil.setPageSize(pageSize);
        pageUtil.setWhereMap(whereMaps);

        pageUtil = financialService.queryAllCredit(pageUtil);
        dgj.setTotal(pageUtil.getTotalCount());
        dgj.setRows(pageUtil.getList());
        return dgj;
    }


}
