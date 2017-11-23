package cn.com.edzleft.service.captial.letter;

import cn.com.edzleft.dao.captial.letter.CreditTableMapper;
import cn.com.edzleft.dao.captial.letter.LetterMapper;
import cn.com.edzleft.entity.CreditTable;
import cn.com.edzleft.entity.Leffer;
import cn.com.edzleft.entity.Order;
import cn.com.edzleft.util.page.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by ASUS on 2017/11/2.
 */
@Service
public class LetterServiceImpl implements LetterService {

    @Autowired
    private LetterMapper letterMapper;

    @Autowired
    private CreditTableMapper creditTableMapper;

    /**
     * 查询订单签约
     * @return
     */
    @Override
    public List<Order> signingSelect() {
        List<Order> list = letterMapper.signingSelect();
        return list;
    }

    @Override
    public PageUtil<Leffer> getOrderEntityListByConditions(PageUtil<Leffer> userPage) {
        //查询总条数
        int totalCount = letterMapper.getOrderEntityCountsByConditions(userPage);
        //查询集合
        List<Leffer> userList = letterMapper.getOrderEntityListByConditions(userPage);
        userPage.setTotalCount(totalCount);
        userPage.setList(userList);
        return userPage;
    }

    @Override
    public PageUtil<CreditTable> getCrownEntityListByConditions(PageUtil<CreditTable> userPage) {
        //查询总条数
        int totalCount = creditTableMapper.getCrownEntityCountsByConditions(userPage);
        //查询集合
        List<CreditTable> userList = creditTableMapper.getCrownEntityListByConditions(userPage);
        userPage.setTotalCount(totalCount);
        userPage.setList(userList);
        return userPage;
    }



}
