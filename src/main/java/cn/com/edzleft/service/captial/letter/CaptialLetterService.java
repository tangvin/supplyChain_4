package cn.com.edzleft.service.captial.letter;

import cn.com.edzleft.entity.CreditTable;
import cn.com.edzleft.entity.Letter;
import cn.com.edzleft.entity.Order;
import cn.com.edzleft.util.page.PageUtil;

import java.util.List;

/**
 * Created by ASUS on 2017/11/2.
 */
public interface CaptialLetterService {

    List<Order> signingSelect();

    /**
     *按条件查询用信分页数据
     */
    public PageUtil<Letter> getOrderEntityListByConditions(PageUtil<Letter> userPage);

    /**
     *按条件查询授信分页数据
     */
    public PageUtil<CreditTable> getCrownEntityListByConditions(PageUtil<CreditTable> userPage);


}
