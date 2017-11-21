package cn.com.edzleft.util;

import cn.com.edzleft.dao.trade.homepage.CreditMapper;
import cn.com.edzleft.entity.CreditTable;
import cn.com.edzleft.util.page.PageUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

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
       PageUtil userpage= new PageUtil<CreditTable>();
       userpage.setTotalCount(4);
        System.out.println("~~~~~~~~~~~");
        CreditTable c = creditMapper.selectCreditById(1);
        System.out.println(c);
        //   Integer count = creditMapper.getCrdeitAllCount(userpage);
     //   System.out.println(count);
    }

}
