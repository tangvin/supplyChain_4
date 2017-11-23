package cn.com.edzleft.util;

import cn.com.edzleft.dao.trade.receivingAddress.ReceivingAddressMapper;
import cn.com.edzleft.entity.ReceivingAddress;
import org.junit.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * Created by ibmtech on 2017/11/23.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(value = "classpath:config/applicationContext.xml")
public class ReceivingAddressTest {

    @Autowired
    private ReceivingAddressMapper receivingAddressMapper;


    /**
     * 查询出所有的地址
     */
    @Test
    public void selectAllAddress(){
        List<ReceivingAddress> list = receivingAddressMapper.selectAllAddress();
        for (ReceivingAddress receivingAddress : list) {
            System.out.println(receivingAddress);
        }
    }

    /**
     * 根据id删除
     */
    public void deleteAddress(){
        receivingAddressMapper.deleteAddress(1);
        System.out.println("删除成功");
    }








    }
