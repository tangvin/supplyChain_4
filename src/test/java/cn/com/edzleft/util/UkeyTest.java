package cn.com.edzleft.util;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.com.edzleft.dao.captial.certificate.CapCertificateMapper;
import cn.com.edzleft.entity.Ukey;
import cn.com.edzleft.util.page.PageUtil;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:config/applicationContext.xml")
public class UkeyTest {

	@Autowired
	private CapCertificateMapper capMapper;
	
	
	/**
	 *  PageUtil<CreditTable> userPage = new PageUtil<CreditTable>();
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
	 */
	@Test
	public void test1() {
		PageUtil<Ukey> userPage = new PageUtil<Ukey>();
		
		int total = capMapper.getUkeyEntityCountsByConditions(userPage);
		
		System.out.println(total);
		
		userPage.setStart(1);
        userPage.setPageSize(2);
        userPage.setTotalCount(total);
       
        List<Ukey> list = capMapper.getUkeyEntityListByConditions(userPage);
       
        userPage.setList(list);
        
        for (Ukey ukey : list) {
			System.out.println(ukey);
		}
        
        System.out.println("--------------------");
        int count =capMapper.getCounts(3);
        System.out.println(count);
        List<Ukey> dlist = capMapper.getByUserId(3);
        for (Ukey ukey : dlist) {
			System.out.println(ukey);
		}
        
        
        
	}

}
