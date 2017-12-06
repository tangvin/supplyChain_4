package cn.com.edzleft.controller.trade.credit;

import cn.com.edzleft.entity.CreditTable;
import cn.com.edzleft.service.trade.credit.CreditService;
import cn.com.edzleft.util.page.DataGridJson;
import cn.com.edzleft.util.page.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;

/**
 * Created by ibmtech on 2017/11/20.
 */
@Controller
@RequestMapping("/credit")
public class CreditController {

    @Autowired
    private CreditService creditService;


    /**
     * 授信管理
     * @param pageNumber 开始页数
     * @param pageSize   每页显示的条数
     * @param creditNumber 授信编号
     * @param creditGrantor 授信方
     * @param creditStatus 授信状态
     * @param applicant 申请人
     * @return
     */
    @RequestMapping(value = "/queryAllCredit",method = RequestMethod.POST)
    @ResponseBody
    public DataGridJson getCreditByPage(Integer pageNumber,Integer pageSize ,String creditNumber,String creditGrantor,String creditStatus,String applicant){
        PageUtil<CreditTable> pageUtil = new PageUtil<>();

        HashMap<String,Object> whereMaps =new HashMap<>();
        whereMaps.put("creditNumber",creditNumber);
        whereMaps.put("creditGrantor",creditGrantor);
        whereMaps.put("creditStatus",creditStatus);
        whereMaps.put("applicant",applicant);
        System.out.println(whereMaps);
        DataGridJson dgj = new DataGridJson();
        pageUtil.setCpage(pageNumber);
        pageUtil.setPageSize(pageSize);
        pageUtil.setWhereMap(whereMaps);
        pageUtil = creditService.queryAllCredit(pageUtil);

        dgj.setTotal(pageUtil.getTotalCount());
        dgj.setRows(pageUtil.getList());
        return dgj;
    }


    /**
     * 根据ｉｄ查询授信详细信息
     */
    @RequestMapping("/creditById")
    @ResponseBody
    public CreditTable getDetialCredit(Integer id){
        CreditTable credit = creditService.queryCreitById(id);
        return credit;
    }





}
