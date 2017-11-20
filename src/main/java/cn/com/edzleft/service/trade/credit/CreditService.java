package cn.com.edzleft.service.trade.credit;

import cn.com.edzleft.entity.CreditTable;
import cn.com.edzleft.util.page.PageUtil;

import java.util.List;

/**
 * Created by ibmtech on 2017/11/20.
 */
public interface CreditService {



    /**
     *条件查询+分页显示
     */
    public PageUtil<CreditTable> queryAllCredit(PageUtil<CreditTable> pageUtil);


    /**
     * 根据id查询授信详细信息
     */
    public CreditTable queryCreitById(Integer id);



}
