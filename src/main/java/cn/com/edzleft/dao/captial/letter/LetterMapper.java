package cn.com.edzleft.dao.captial.letter;

import cn.com.edzleft.entity.CreditTable;
import cn.com.edzleft.entity.Leffer;
import cn.com.edzleft.entity.Order;
import cn.com.edzleft.util.page.PageUtil;

import java.util.List;

/**
 * Created by ASUS on 2017/11/2.
 */
public interface LetterMapper {

    List<Order> signingSelect();

    /**用信
     * 根据Map<String,Object>对象查询符合条件的总数据数
     * @param  userPage
     * @return
     */
    int getOrderEntityCountsByConditions(PageUtil<Leffer> userPage);

    /**用信
     * 根据Map<String,Object>分页查询
     * @param userPage
     * @param
     * @return
     */
    List<Leffer> getOrderEntityListByConditions(PageUtil<Leffer> userPage);





}
