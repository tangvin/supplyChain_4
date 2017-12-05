package cn.com.edzleft.dao.captial.loan;

import cn.com.edzleft.entity.Loan;
import cn.com.edzleft.util.page.PageUtil;

import java.util.List;

public interface CaptialLoanMapper {
    /**贷款
     * 根据Map<String,Object>对象查询符合条件的总数据数
     * @param  userPage
     * @return
     */
    int loansSelectCount(PageUtil<Loan> userPage);

    /**贷款
     * 根据Map<String,Object>分页查询
     * @param userPage
     * @param
     * @return
     */
    List<Loan> loansSelect(PageUtil<Loan> userPage);
}