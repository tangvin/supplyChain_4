package cn.com.edzleft.util;

import cn.com.edzleft.entity.Letter;
import cn.com.edzleft.service.captial.letter.CaptialLetterService;
import cn.com.edzleft.util.page.DataGridJson;
import cn.com.edzleft.util.page.PageUtil;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.HashMap;

/**
 * Created by ASUS on 2017/11/22.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"/config/application*.xml"})
public class signingController {

    @Autowired
    private CaptialLetterService letterService;

    @org.junit.Test
    public void test() throws Exception {
        Integer pageNumber =1;
        Integer pageSize =3;
        PageUtil<Letter> userPage = new PageUtil<>();
        HashMap<String,Object> whereMaps =new HashMap<>();
        String name = null;
        DataGridJson dgj = new DataGridJson();
        userPage.setCpage(pageNumber);
        userPage.setPageSize(pageSize);
        whereMaps.put("letterName",name);
        userPage.setWhereMap(whereMaps);
        userPage = letterService.getOrderEntityListByConditions(userPage);
        dgj.setTotal(userPage.getTotalCount());
        dgj.setRows(userPage.getList());
        System.out.print(dgj);
    }

}
