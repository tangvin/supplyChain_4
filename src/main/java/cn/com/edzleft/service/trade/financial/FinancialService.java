package cn.com.edzleft.service.trade.financial;

import cn.com.edzleft.entity.Financial;
import cn.com.edzleft.util.page.PageUtil;

/**
 * Created by ibmtech on 2017/12/5.
 */
public interface FinancialService {

    /**
     *条件查询+分页显示
     */
    public PageUtil<Financial> queryAllCredit(PageUtil<Financial> pageUtil);


    /**
     * 根据id查询授信详细信息
     */
    public Financial queryFinancialById(Integer id);
}
