package cn.com.edzleft.util;

import cn.com.edzleft.dao.trade.financial.FinancialMapper;
import cn.com.edzleft.entity.Financial;
import cn.com.edzleft.util.page.PageUtil;
import org.junit.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * Created by ibmtech on 2017/12/6.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(value = "classpath:config/applicationContext.xml")
public class FinancialTest {
    @Autowired
    private FinancialMapper financialMapper;


    @Test
    public  void selectAllFinancial(){
        PageUtil<Financial> userPage = new PageUtil<Financial>();
        //查询总条数
        int totalCount = financialMapper.getAllFinancialCount(userPage);
        System.out.println(totalCount);
        //查询合同集合
        userPage.setStart(1);
        userPage.setPageSize(2);
        userPage.setTotalCount(totalCount);
        List<Financial> letters = financialMapper.selectAllFinancialByPage(userPage);
        userPage.setList(letters);
        for (Financial f : letters) {
            System.out.println(f);
        }
    }

    @Test
    public void selectById(){
        Financial financial = financialMapper.selectFinancialById(1);
        System.out.println(financial);
    }



}
