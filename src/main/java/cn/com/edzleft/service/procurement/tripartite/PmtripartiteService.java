package cn.com.edzleft.service.procurement.tripartite;

import cn.com.edzleft.entity.Tripartite;
import cn.com.edzleft.util.page.PageUtil;

public interface PmtripartiteService {


	PageUtil<Tripartite> getOrderList(PageUtil<Tripartite> userPage);

}
