package cn.com.edzleft.controller.captial.tripartite;

import cn.com.edzleft.entity.Tripartite;
import cn.com.edzleft.service.captial.tripartite.CaptialTripartiteService;
import cn.com.edzleft.util.page.DataGridJson;
import cn.com.edzleft.util.page.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;

/**
 * Created by ASUS on 2017/11/28.
 */
@RequestMapping("captialTripartite")
@Controller
public class CaptialTripartiteController {

    @Autowired
    private CaptialTripartiteService captialTripartiteService;


    /**
     * 资方三方账户信息
     * @param pageNumber 开始页数
     * @param pageSize 每页条数
     * @param tripartiteDepositBank 开户行
     * @param tripartiteCreditHolderPurchaser 户主
     * @return
     */
    @RequestMapping(value = "/tripartiteSelect",method = RequestMethod.POST)
    @ResponseBody
    public DataGridJson tripartiteSelect(Integer pageNumber, Integer pageSize , String tripartiteDepositBank, String tripartiteCreditHolderPurchaser){
        PageUtil<Tripartite> userPage = new PageUtil<>();
        HashMap<String,Object> whereMaps =new HashMap<>();
        whereMaps.put("tripartiteDepositBank",tripartiteDepositBank);
        whereMaps.put("tripartiteCreditHolderPurchaser",tripartiteCreditHolderPurchaser);
        DataGridJson dgj = new DataGridJson();
        userPage.setCpage(pageNumber);
        userPage.setPageSize(pageSize);
        userPage.setWhereMap(whereMaps);
        userPage = captialTripartiteService.getTripartiteSelect(userPage);
        dgj.setTotal(userPage.getTotalCount());
        dgj.setRows(userPage.getList());
        return dgj;
    }

}
