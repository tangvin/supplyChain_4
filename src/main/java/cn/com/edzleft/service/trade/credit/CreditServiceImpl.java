package cn.com.edzleft.service.trade.credit;

import cn.com.edzleft.dao.trade.homepage.CreditMapper;
import cn.com.edzleft.entity.CreditTable;
import cn.com.edzleft.util.page.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by ibmtech on 2017/11/20.
 */
@Service
@Transactional
public class CreditServiceImpl implements CreditService {
    
    @Autowired
    private CreditMapper creditMapper;

    //分页查询后显示
    @Override
    public PageUtil<CreditTable> queryAllCredit(PageUtil<CreditTable> pageUtil) {
       //查询总条数
        Integer count = creditMapper.getCrdeitAllCount(pageUtil);
        //查询出条件后的所有的授信信息
        List<CreditTable> creditTables = creditMapper.selectAllCreditByPage(pageUtil);
        pageUtil.setTotalCount(count);
        pageUtil.setList(creditTables);
        return pageUtil;
    }

    //根据id查询授信详细信息
    @Override
    public CreditTable queryCreitById(Integer id) {
        CreditTable credit = creditMapper.selectCreditById(id);
        return credit;
    }
}
