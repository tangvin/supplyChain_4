package cn.com.edzleft.dao.trade.financial;

import cn.com.edzleft.entity.Financial;
import cn.com.edzleft.util.page.PageUtil;

import java.util.List;

/**
 * Created by ibmtech on 2017/12/5.
 */
public interface FinancialMapper {

    /**
     * 根据Map<String,Object>对象查询符合条件的总数据数
     * @param  pageUtil
     * @return
     */
    public Integer getAllFinancialCount(PageUtil<Financial> pageUtil);

    /**
     * 分页
     * @param pageUtil
     * @return
     */
    public List<Financial> selectAllFinancialByPage(PageUtil<Financial> pageUtil);


    /**
     * 根据id查看财务信息
     * @param id
     * @return
     */
    public Financial selectFinancialById(Integer id);

    /**
     * 根据id删除财务信息
     * @param id
     * @return
     */
    public int deleteFinancial(Integer id);


    /**
     * 添加财务信息
     */
    public int insertFinancial(Integer id);


}
