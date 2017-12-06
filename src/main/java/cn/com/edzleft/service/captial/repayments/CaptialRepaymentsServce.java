package cn.com.edzleft.service.captial.repayments;

import cn.com.edzleft.entity.Repayments;
import cn.com.edzleft.util.page.PageUtil;

/**
 * Created by ASUS on 2017/12/4.
 */
public interface CaptialRepaymentsServce {
    PageUtil<Repayments> repaymentSelect(PageUtil<Repayments> userPage);
}
