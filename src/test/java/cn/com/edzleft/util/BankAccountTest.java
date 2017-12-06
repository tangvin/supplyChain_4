package cn.com.edzleft.util;

import cn.com.edzleft.dao.trade.bankAccount.BankAccountMapper;
import cn.com.edzleft.entity.BankAccount;
import org.junit.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.*;

/**
 * Created by ibmtech on 2017/12/6.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(value = "classpath:config/applicationContext.xml")
public class BankAccountTest {
    @Autowired
    private BankAccountMapper bankAccountMapper;


    /**
     * 根据用户id 查询出银行卡
     */
    @Test
    public void selectAllBankAccount(){
        List<BankAccount> bankAccounts = bankAccountMapper.selectBankAccountByUserId(6);
        for (BankAccount bankAccount : bankAccounts) {
            System.out.println(bankAccount);
        }
    }
//
//    SessionInfo session = (SessionInfo) sessionInfo.getAttribute("sessionInfo");
//    Integer userId = session.getAdmin().getUserId();
//    String in=String.valueOf(userId);
//    List<String> list=Arrays.asList(in.split(""));
//        Collections.shuffle(list);
//    /*获取随机数*/
//    String out=new String();
//    Random r=new Random();
//    int i = r.nextInt(10);
//        System.out.println(i);
//    /*获取当前时间戳*/
//    long currentTimeMillis = System.currentTimeMillis();
//    String orderNumber= "";
//    orderNumber = "O"+i+currentTimeMillis;
//        o.setOrderNumber(orderNumber);
//        for(String s:list){
//        out+=s;
//    }

 //       System.out.println("================="+out);
        @Test
        public void test() {

                String in=String.valueOf(1211);
                List<String> list= Arrays.asList(in.split(""));
                    Collections.shuffle(list);
                System.out.println(list);
                /*获取随机数*/
                String out = new String();
                Random r = new Random();
                int i = r.nextInt(10);
                System.out.println(i);

                    /*获取当前时间戳*/
                long currentTimeMillis = System.currentTimeMillis();
                String orderNumber = "";
                orderNumber = "O" + i + currentTimeMillis;
                System.out.println(orderNumber);



                for(String s:list){
                out+=s;
                    System.out.println(out);
                }
            orderNumber = "O" + i + currentTimeMillis+out;
            System.out.println(orderNumber);
        }

    /**
     * 添加银行卡
     */
    @Test
    public void addBankAccount(){
        BankAccount bankAccount = new BankAccount();
      //  bankAccount.setBankAccountId();
        bankAccount.setBankAccountCreatePeople("zhangsan");
        bankAccount.setBankAccountCreateTime(new Date());
        bankAccount.setBankAccountCreditHolder("peo");
        bankAccount.setBankAccountDepositBank("建设银行");

        bankAccount.setBankAccountNumber("52222222222223");
        bankAccount.setUserId(6);
        bankAccount.setDefaultId(1);
        int i = bankAccountMapper.insertBankAcount(bankAccount);
        System.out.println(i);
        System.out.println("添加成功！！！！");
    }

    /**
     * 删除银行卡
     */
    @Test
    public void deleteBankAccount(){
        int i = bankAccountMapper.deleteBankAccountById(1);
        System.out.println(i);
        System.out.println("删除成功");
    }


    /**
     * 修改银行信息
     */
    @Test
    public void updateBankAccount(){
        BankAccount bankAccount = new BankAccount();
        bankAccount.setBankAccountId(2);
        bankAccount.setUserId(6);
        bankAccount.setBankAccountNumber("65");
        bankAccount.setBankAccountCreateTime(new Date());
        bankAccount.setBankAccountDepositBank("银行工商");
        bankAccount.setBankAccountCreateTime(new Date());
        bankAccount.setBankAccountCreditHolder("红孩儿");
        bankAccount.setDefaultId(0);
        bankAccountMapper.updatebankAccount(bankAccount);
        System.out.println("修改成功");

    }
}
