package cn.com.edzleft.util;

import cn.com.edzleft.dao.trade.freight.FreightMapper;
import cn.com.edzleft.dao.trade.receivingAddress.ReceivingAddressMapper;
import cn.com.edzleft.entity.Freight;
import cn.com.edzleft.entity.ReceivingAddress;
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
public class FreightTest {

    @Autowired
    private FreightMapper freightMapper;

    @Autowired
    private ReceivingAddressMapper receivingAddressMapper;


    /**
     * 根据用户id查询出对应的货运单位
     */
    @Test
    public void selectFreightByAccountId(){
        List<Freight> list = freightMapper.selectFreightByAccountId(1);
        for (Freight freight : list) {
            System.out.println(freight);
        }

    }

    /**
     * 查询所有的货运单位
     */
    @Test
    public void selectAll(){
        System.out.println("~~~~~~开始");
        List<Freight> freights = freightMapper.selectAllFreight();
        System.out.println(freights);
    }

    /**
     * 添加货运单位
     */
    @Test
    public void addFreight(){
        Freight f = new Freight();
        System.out.println("准备添加");
//        f.setFreightId(11);
        //货运单位名称
        f.setFreightName("007");
        //货运方联系人
        f.setFreightContactPerson("张三");
        //货运方联系人手机
        f.setFreightContactPhone("1234556");
        //货运是否默认地址
        f.setFreightDefaultAddress(1);
        f.setFreightNumber("et1234");
        f.setAccountId(2);
        int i = freightMapper.insertFreight(f);
        System.out.println(i);
        System.out.println("添加成功");
    }

    /**
     * 删除货运单位
     */
    @Test
    public void deleteFreight(){
        freightMapper.deleteFreight(2);
        System.out.println("~~~~删除成功~~~~~~");
    }

    /**
     * 修改货运默认地址
     */
    @Test
    public void setDefault(){
        System.out.println("!!!!!!");
        Freight f = new Freight();
        f.setFreightDefaultAddress(1);
        freightMapper.updateFreight(f);
        System.out.println("修改成功");
        System.out.println(f);
    }

    /**
     * 查询出所有的货运默认地址为1的货运单位
     */
    @Test
    public void selectDefault(){
        System.out.println("~~~~~~~~开始");
        List<Freight> list = freightMapper.selectFreightByAddress();
        for (Freight freight : list) {
            Integer address = freight.getFreightDefaultAddress();
            System.out.println(address);
        }
    }

    @Test
    public void test2(){
        System.out.println("!!!!!!!!!!!");
        Freight freight = freightMapper.selectFreightById(1);
        System.out.println(freight);
    }


    @Test
    public void selectReceivingAddress(){
        System.out.println("~~~~~~~~~~~~");
        ReceivingAddress address = receivingAddressMapper.selectAddressById(1);
        System.out.println(address);
    }

}
