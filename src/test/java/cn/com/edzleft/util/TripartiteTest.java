package cn.com.edzleft.util;

import cn.com.edzleft.dao.trade.tripartite.TripartiteMapper;
import cn.com.edzleft.entity.Tripartite;
import cn.com.edzleft.util.page.PageUtil;
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
public class TripartiteTest {

    @Autowired
    private TripartiteMapper tripartiteMapper;


    /**
     * 条件查询加分页
     */
    @Test
    public void pageinationByCoditions(){
        PageUtil<Tripartite> userPage = new PageUtil<Tripartite>();
        //查询总条数
        int totalCount = tripartiteMapper.getTripartiteAllCount(userPage);
        System.out.println(totalCount);
        //查询合同集合
        userPage.setStart(1);
        userPage.setPageSize(3);
        userPage.setTotalCount(totalCount);
        List<Tripartite> creditList = tripartiteMapper.selectAllTripartiteByPage(userPage);
        userPage.setList(creditList);
        for (Tripartite tripartite : creditList) {
            System.out.println(tripartite);
        }
    }

    @Test
    public void selectTripartite(){
        Tripartite tripartite = tripartiteMapper.selectTripartiteById(1);
        System.out.println(tripartite);

    }

}
