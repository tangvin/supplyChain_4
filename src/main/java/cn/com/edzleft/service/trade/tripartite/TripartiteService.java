package cn.com.edzleft.service.trade.tripartite;

import cn.com.edzleft.entity.Tripartite;
import cn.com.edzleft.util.page.PageUtil;

/**
 * Created by ibmtech on 2017/11/22.
 */
public interface TripartiteService {
    /**
     *条件查询+分页显示
     */
    public PageUtil<Tripartite> queryAllTripartite(PageUtil<Tripartite> pageUtil);

}
