package cn.com.edzleft.controller.trade.tripartite;

import cn.com.edzleft.entity.Tripartite;
import cn.com.edzleft.service.trade.tripartite.TripartiteService;
import cn.com.edzleft.util.page.DataGridJson;
import cn.com.edzleft.util.page.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;

/**
 * Created by ibmtech on 2017/11/22.
 */
@Controller
@RequestMapping(value = "/tripartite")
public class TripartiteController {

    @Autowired
    private TripartiteService tripartiteService;

    @RequestMapping("/tripartitePage")
    @ResponseBody
    public DataGridJson getTripartiteByPage(Integer pageNumber, Integer pageSize , String tripartiteDepositBank, String tripartiteCreditHolderPurchaser){
        PageUtil<Tripartite> userPage = new PageUtil<>();
        HashMap<String,Object> whereMaps =new HashMap<>();
        whereMaps.put("tripartiteDepositBank",tripartiteDepositBank);
        whereMaps.put("tripartiteCreditHolderPurchaser",tripartiteCreditHolderPurchaser);
        DataGridJson dgj = new DataGridJson();
        userPage.setCpage(pageNumber);
        userPage.setPageSize(pageSize);
        userPage.setWhereMap(whereMaps);
        userPage = tripartiteService.queryAllTripartite(userPage);
        dgj.setTotal(userPage.getTotalCount());
        dgj.setRows(userPage.getList());
        return dgj;
    }
}
