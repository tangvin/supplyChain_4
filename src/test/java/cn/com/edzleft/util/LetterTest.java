package cn.com.edzleft.util;

import cn.com.edzleft.dao.trade.letter.LefferMapper;
import cn.com.edzleft.entity.Letter;
import cn.com.edzleft.util.page.PageUtil;
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
public class LetterTest {

        @Autowired
        private LefferMapper letterMapper;

    /**
     * 分页查询授信信息
     */
    @Test
    public void testCreditPage(){
        System.out.println("!!!!!!!!!!!");
        System.out.println("~~~~~~~~~~~~~~");
        PageUtil<Letter> userPage = new PageUtil<Letter>();
        //查询总条数
        int totalCount = letterMapper.getLetterAllCount(userPage);
        System.out.println(totalCount);
        //查询合同集合
        userPage.setStart(1);
        userPage.setPageSize(2);
        userPage.setTotalCount(totalCount);
        List<Letter> letters = letterMapper.selectAllLetterByPage(userPage);
        userPage.setList(letters);
        for (Letter letter : letters) {
            System.out.println(letter);
        }
    }

    /**
     * 根据id查询详细的授信信息
     */
   /* @Test
    public void testDetail(){
        Letter byId = letterMapper.selectCreditById(1);
        System.out.println(byId);
    }
*/


}
