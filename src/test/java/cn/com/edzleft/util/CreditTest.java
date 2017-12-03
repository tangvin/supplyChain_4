package cn.com.edzleft.util;

import cn.com.edzleft.dao.trade.homepage.CreditMapper;
import cn.com.edzleft.entity.CreditTable;
import cn.com.edzleft.util.page.PageUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * Created by ibmtech on 2017/11/20.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(value = "classpath:config/applicationContext.xml")
public class CreditTest {

    @Autowired
    private CreditMapper creditMapper;

    /**
     * 分页查询授信信息
     */
    @Test
    public void testCreditPage(){
        PageUtil<CreditTable> userPage = new PageUtil<CreditTable>();
        //查询总条数
        int totalCount = creditMapper.getCrdeitAllCount(userPage);
        System.out.println(totalCount);
        //查询合同集合
        userPage.setStart(1);
        userPage.setPageSize(2);
        userPage.setTotalCount(totalCount);
        List<CreditTable> creditList = creditMapper.selectAllCreditByPage(userPage);
        userPage.setList(creditList);
        for (CreditTable credit : creditList) {
            System.out.println(credit);
        }
    }

    /**
     * 根据id查询详细的授信信息
     */
    @Test
    public void testDetail(){
        CreditTable byId = creditMapper.selectCreditById(2);
        System.out.println(byId);
    }


}
