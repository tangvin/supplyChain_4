package cn.com.edzleft.dao.procurement.tripartite;

import java.util.List;

import cn.com.edzleft.entity.Tripartite;
import cn.com.edzleft.util.page.PageUtil;

public interface PmtripartiteMapper {


	int getOrderCount(PageUtil<Tripartite> userPage);

	List<Tripartite> getOrderList(PageUtil<Tripartite> userPage);

}
