package cn.com.edzleft.dao.captial.signing;

import cn.com.edzleft.entity.Contract;
import cn.com.edzleft.entity.Order;
import cn.com.edzleft.util.page.PageUtil;

import java.util.List;

/**
 * Created by ASUS on 2017/11/2.
 */
public interface SigningMapper {

    List<Order> signingSelect();

    /**
     * 根据Map<String,Object>对象查询符合条件的总数据数
     * @param  userPage
     * @return
     */
    int getOrderEntityCountsByConditions(PageUtil<Contract> userPage);

    /**
     * 根据Map<String,Object>分页查询
     * @param userPage
     * @param
     * @return
     */
    List<Contract> getOrderEntityListByConditions(PageUtil<Contract> userPage);


}