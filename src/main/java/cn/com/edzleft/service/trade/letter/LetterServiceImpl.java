package cn.com.edzleft.service.trade.letter;

import cn.com.edzleft.dao.trade.homepage.LetterMapper;
import cn.com.edzleft.entity.Letter;
import cn.com.edzleft.util.page.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by ibmtech on 2017/11/20.
 */
@Service
@Transactional
public class LetterServiceImpl implements LetterService {

   @Autowired
   private LetterMapper letterMapper;

    /**
     * 条件查询+分页显示
     * @param userpage
     * @return
     */
    @Override
    public PageUtil<Letter> queryAllLetterByPage(PageUtil<Letter> userpage) {
        //查询出总的条数
        Integer allCount = letterMapper.getLetterAllCount(userpage);
        //条件查询后所有的用信信息
        List<Letter> letters = letterMapper.selectAllLetterByPage(userpage);
        userpage.setTotalCount(allCount);
        userpage.setList(letters);
        return userpage;
    }

    /**
     * 根据id查询用信信息
     * @return
     */
    @Override
    public Letter selectLetterById(Integer id) {
        Letter letter = letterMapper.selectLetterById(id);
        return letter;
    }
}
