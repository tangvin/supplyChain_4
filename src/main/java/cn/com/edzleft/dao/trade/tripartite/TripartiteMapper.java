package cn.com.edzleft.dao.trade.tripartite;

import cn.com.edzleft.entity.Tripartite;
import cn.com.edzleft.util.page.PageUtil;

import java.util.List;

/**
 * Created by ibmtech on 2017/11/22.
 */
public interface TripartiteMapper {

    /**
     * 根据Map<String,Object>对象查询符合条件的总数据数
     * @param  pageUtil
     * @return
     */
    public Integer getTripartiteAllCount(PageUtil<Tripartite> pageUtil);

    /**
     * 分页
     * @param pageUtil
     * @return
     */
    public List<Tripartite> selectAllTripartiteByPage(PageUtil<Tripartite> pageUtil);


    /**
     *  根据id 查询出三分账户的信息
     * @param id
     * @return
     */
    public Tripartite selectTripartiteById(Integer id);



}
