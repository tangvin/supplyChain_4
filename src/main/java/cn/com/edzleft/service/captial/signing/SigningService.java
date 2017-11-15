package cn.com.edzleft.service.captial.signing;

import cn.com.edzleft.entity.Contract;
import cn.com.edzleft.entity.Order;
import cn.com.edzleft.util.page.PageUtil;

import java.util.List;

/**
 * Created by ASUS on 2017/11/2.
 */
public interface SigningService {

    List<Order> signingSelect();

    /**
     *按条件查询分页数据
     */
    public PageUtil<Contract> getOrderEntityListByConditions(PageUtil<Contract> userPage);

}
