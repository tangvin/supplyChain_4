package cn.com.edzleft.dao.captial.repayments;

import cn.com.edzleft.entity.Repayments;
import cn.com.edzleft.util.page.PageUtil;

import java.util.List;

public interface CaptialRepaymentsMapper {
    /**还款
     * 根据Map<String,Object>对象查询符合条件的总数据数
     * @param  userPage
     * @return
     */
    int repaymentSelectCount(PageUtil<Repayments> userPage);

    /**还款
     * 根据Map<String,Object>分页查询
     * @param userPage
     * @param
     * @return
     */
    List<Repayments> repaymentSelect(PageUtil<Repayments> userPage);
}