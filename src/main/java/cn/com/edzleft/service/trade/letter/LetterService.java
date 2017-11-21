package cn.com.edzleft.service.trade.letter;

import cn.com.edzleft.entity.Letter;
import cn.com.edzleft.util.page.PageUtil;

/**
 * Created by ibmtech on 2017/11/20.
 */
public interface LetterService {

    /**
     * 条件查询＋分页显示
     */
    public PageUtil<Letter> queryAllLetterByPage(PageUtil<Letter> userpage);

    /**
     * 根据id 查询用信信息
     */
    public Letter selectLetterById(Integer id);


}
