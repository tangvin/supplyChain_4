package cn.com.edzleft.service.captial.loan;

import cn.com.edzleft.dao.captial.loan.CaptialLoanMapper;
import cn.com.edzleft.entity.Loan;
import cn.com.edzleft.util.page.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by ASUS on 2017/12/4.
 */
@Service
public class CaptialLoanServiceImpl implements CaptialLoanService{

    @Autowired
    private CaptialLoanMapper captialLoanMapper;

    @Override
    public PageUtil<Loan> loansSelect(PageUtil<Loan> userPage) {
        //查询总条数
        int totalCount = captialLoanMapper.loansSelectCount(userPage);
        //查询集合
        List<Loan> userList = captialLoanMapper.loansSelect(userPage);
        userPage.setTotalCount(totalCount);
        userPage.setList(userList);
        return userPage;
    }
}
