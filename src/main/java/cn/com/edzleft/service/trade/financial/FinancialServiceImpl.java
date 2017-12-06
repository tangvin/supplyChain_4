package cn.com.edzleft.service.trade.financial;

import cn.com.edzleft.dao.trade.financial.FinancialMapper;
import cn.com.edzleft.entity.Financial;
import cn.com.edzleft.util.page.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by ibmtech on 2017/12/5.
 */
@Service
@Transactional
public class FinancialServiceImpl implements FinancialService {

    @Autowired
    private FinancialMapper financialMapper;

    /**
     * 条件查询后分页显示
     * @param pageUtil
     * @return
     */
    @Override
    public PageUtil<Financial> queryAllCredit(PageUtil<Financial> pageUtil) {
        //查询总条数
        Integer count = financialMapper.getAllFinancialCount(pageUtil);
        //查询出条件后的所有的授信信息集合
        List<Financial> credits = financialMapper.selectAllFinancialByPage(pageUtil);
        pageUtil.setTotalCount(count);
        pageUtil.setList(credits);
        return pageUtil;
    }

    /**
     * 根据id查询财务信息
     * @param id
     * @return
     */
    @Override
    public Financial queryFinancialById(Integer id) {
        Financial financial = financialMapper.selectFinancialById(id);
        return financial;
    }




}
