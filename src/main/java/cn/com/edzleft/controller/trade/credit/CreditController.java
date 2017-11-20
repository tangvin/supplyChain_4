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
     * 条件查询后分页显示
     */
    @RequestMapping(value = "/creditByPage",method = RequestMethod.POST)
    @ResponseBody
    public DataGridJson getCreditByPage(int page, int rows, PageUtil<CreditTable> pageUtil){
        DataGridJson dgj = new DataGridJson();
        //分页对象
        pageUtil.setCpage(page);
        pageUtil.setPageSize(rows);
        PageUtil<CreditTable> pages = creditService.queryAllCredit(pageUtil);
        dgj.setTotal(pages.getTotalCount());
        dgj.setRows(pages.getList());
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
