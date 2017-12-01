package cn.com.edzleft.util;

import cn.com.edzleft.dao.trade.contractSigning.ContractSigningMapper;
import cn.com.edzleft.entity.Contract;
import cn.com.edzleft.util.page.PageUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * Created by ibmtech on 2017/11/24.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(value = "classpath:config/applicationContext.xml")
public class contractSigningTest {
    @Autowired
    private ContractSigningMapper contractSigningMapper;

    @Test
    public void contractSelect(){
        Contract contract = contractSigningMapper.selectContractById(1);
        System.out.println(contract);
    }

    @Test
    public void contractBypage(){
        PageUtil<Contract> util = new PageUtil<>();
        Integer totalCount = contractSigningMapper.selectTotalCount(util);
        System.out.println(totalCount);

        util.setStart(1);
        util.setPageSize(3);
        util.setTotalCount(totalCount);
        List<Contract> list = contractSigningMapper.selectContractByPage(util);
        util.setList(list);
        for (Contract contract : list) {
            System.out.println(contract);
        }

    }

}
