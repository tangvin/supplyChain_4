package cn.com.edzleft.service.trade.tripartite;

import cn.com.edzleft.dao.trade.tripartite.TripartiteMapper;
import cn.com.edzleft.entity.Tripartite;
import cn.com.edzleft.util.page.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by ibmtech on 2017/11/22.
 */
@Service
@Transactional
public class TripartiteServiceImpl implements TripartiteService {

    @Autowired
    private TripartiteMapper tripartiteMapper;

    /**
     * 条件查询+分页显示
     * @param pageUtil
     * @return
     */
    @Override
    public PageUtil<Tripartite> queryAllTripartite(PageUtil<Tripartite> pageUtil) {
       //查询出总的条数
        Integer count = tripartiteMapper.getTripartiteAllCount(pageUtil);
        //条件查询后的所有的三方账户信息
        List<Tripartite> list = tripartiteMapper.selectAllTripartiteByPage(pageUtil);
        pageUtil.setTotalCount(count);
        pageUtil.setList(list);
        return pageUtil;
    }
}
