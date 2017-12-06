package cn.com.edzleft.service.captial.repayments;

import cn.com.edzleft.dao.captial.repayments.CaptialRepaymentsMapper;
import cn.com.edzleft.entity.Repayments;
import cn.com.edzleft.util.page.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by ASUS on 2017/12/4.
 */
@Service
public class CaptialRepaymentsServceImpl implements CaptialRepaymentsServce{

    @Autowired
    private CaptialRepaymentsMapper captialRepaymentsMapper;

    @Override
    public PageUtil<Repayments> repaymentSelect(PageUtil<Repayments> userPage) {
        //查询总条数
        int totalCount = captialRepaymentsMapper.repaymentSelectCount(userPage);
        //查询集合
        List<Repayments> userList = captialRepaymentsMapper.repaymentSelect(userPage);
        userPage.setTotalCount(totalCount);
        userPage.setList(userList);
        return userPage;
    }
}
