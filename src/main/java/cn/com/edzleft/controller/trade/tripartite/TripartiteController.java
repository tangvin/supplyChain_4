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

/**
 * Created by ibmtech on 2017/11/22.
 */
@Controller
@RequestMapping(value = "/tripartite")
public class TripartiteController {

    @Autowired
    private TripartiteService tripartiteService;

    @RequestMapping("/byPage")
    @ResponseBody
    public DataGridJson getTripartiteByPage(int page, int rows, PageUtil<Tripartite> pageUtil){
        DataGridJson dgj = new DataGridJson();
        pageUtil.setCpage(page);
        pageUtil.setPageSize(rows);
        PageUtil<Tripartite> pages = tripartiteService.queryAllTripartite(pageUtil);
        dgj.setTotal(pages.getTotalCount());
        dgj.setRows(pages.getList());
        return dgj;
    }
}
