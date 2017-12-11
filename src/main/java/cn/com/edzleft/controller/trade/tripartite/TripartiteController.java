package cn.com.edzleft.controller.trade.tripartite;

import cn.com.edzleft.entity.Account;
import cn.com.edzleft.entity.SessionInfo;
import cn.com.edzleft.entity.Tripartite;
import cn.com.edzleft.service.trade.tripartite.TripartiteService;
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
 * Created by ibmtech on 2017/11/22.
 */
@Controller
@RequestMapping(value = "/tripartite")
public class TripartiteController {

    @Autowired
    private TripartiteService tripartiteService;

    @RequestMapping(value = "/tripartitePage",method = RequestMethod.POST)
    @ResponseBody
    public DataGridJson getTripartiteByPage(Integer pageNumber, Integer pageSize , String caEntName, String pmEntName, HttpSession session){
        PageUtil<Tripartite> userPage = new PageUtil<>();
        HashMap<String,Object> whereMaps =new HashMap<>(); /*从session获取当前用户的信息*/

        whereMaps.put("caEntName",caEntName);
        whereMaps.put("pmEntName",pmEntName);
        SessionInfo sessionInfo = (SessionInfo) session.getAttribute("sessionInfo");
        Account sessionAccount=sessionInfo.getAdmin();
        Integer userId = sessionAccount.getUserId();
        //  System.out.println(sessionAccount);
        whereMaps.put("userId",userId);
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
