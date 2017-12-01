package cn.com.edzleft.service.procurement.tripartite;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.com.edzleft.dao.procurement.tripartite.PmtripartiteMapper;
import cn.com.edzleft.entity.Letter;
import cn.com.edzleft.entity.Tripartite;
import cn.com.edzleft.util.page.PageUtil;

@Service
public class PmtripartiteServiceImpl implements PmtripartiteService{

	@Autowired
	private PmtripartiteMapper pmtripartiteMapper;

	@Override
	public PageUtil<Tripartite> getOrderList(PageUtil<Tripartite> userPage) {
		//查询总条数
        int totalCount = pmtripartiteMapper.getOrderCount(userPage);
        //查询集合
        List<Tripartite> userList = pmtripartiteMapper.getOrderList(userPage);
        userPage.setTotalCount(totalCount);
        userPage.setList(userList);
        return userPage;
	}
}
