package cn.com.edzleft.service.captial.loan;

import cn.com.edzleft.entity.Loan;
import cn.com.edzleft.util.page.PageUtil;

/**
 * Created by ASUS on 2017/12/4.
 */
public interface CaptialLoanService {
    PageUtil<Loan> loansSelect(PageUtil<Loan> userPage);
}
