package cn.com.edzleft.dao.trade.letter;

import cn.com.edzleft.entity.Letter;
import cn.com.edzleft.util.page.PageUtil;

import java.util.List;

/**
 * Created by ibmtech on 2017/11/20.
 * 用信管理
 */
public interface TradeLefferMapper {

    /**
     * 根据Map<String,Object>对象查询符合条件的总数据数
     * @param  pageUtil
     * @return
     */
    public Integer getLetterAllCount(PageUtil<Letter> pageUtil);

    /**
     * 分页
     * @param pageUtil
     * @return
     */
    public List<Letter> selectAllLetterByPage(PageUtil<Letter> pageUtil);

    /**
     * 根据id 查询用信详细信息
     */
    public Letter selectLetterById(Integer id);



}
