package cn.com.edzleft.service.captial.signing;

import cn.com.edzleft.dao.captial.signing.SigningMapper;
import cn.com.edzleft.entity.Contract;
import cn.com.edzleft.entity.Order;
import cn.com.edzleft.util.page.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by ASUS on 2017/11/2.
 */
@Service
public class SigningServiceImpl implements SigningService{

    @Autowired
    private SigningMapper signingMapper;

    /**
     * 查询订单签约
     * @return
     */
    @Override
    public List<Order> signingSelect() {
        List<Order> list = signingMapper.signingSelect();
        return list;
    }

    @Override
    public PageUtil<Contract> getOrderEntityListByConditions(PageUtil<Contract> userPage) {
        //查询总条数
        int totalCount = signingMapper.getOrderEntityCountsByConditions(userPage);
        //查询集合
        List<Contract> userList = signingMapper.getOrderEntityListByConditions(userPage);
        userPage.setTotalCount(totalCount);
        userPage.setList(userList);
        return userPage;
    }
}
