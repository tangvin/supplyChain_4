package cn.com.edzleft.service.procurement.oder;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.com.edzleft.dao.procurement.oder.PmOrderMapper;
import cn.com.edzleft.entity.Order;
import cn.com.edzleft.util.page.PageUtil;

@Service
public class PmOrderServiceImpl implements PmOrderService{

	@Autowired
	private PmOrderMapper pmOrderMapper;

	@Override
	public PageUtil<Order> getOrderEntityList(PageUtil<Order> userPage) {
		//查询总条数
        int totalCount = pmOrderMapper.getCrownEntityCounts(userPage);
        //查询集合
        List<Order> userList = pmOrderMapper.getCrownEntityList(userPage);
        userPage.setTotalCount(totalCount);
        userPage.setList(userList);
        return userPage;
	}

	@Override
	public String insetOrder(Integer userId) {
		return pmOrderMapper.insetOrder(userId);
	}

	@Override
	public String insetOrder2(Integer userId) {
		return pmOrderMapper.insetOrder2(userId);
	}

	/*添加订单*/
	@Override
	public int insertSelective(Order o) {
		return pmOrderMapper.insertSelective(o);
	}

	@Override
	public String insetOrder3(Integer userId) {
		// TODO Auto-generated method stub
		return pmOrderMapper.insetOrder3(userId);
	}

	@Override
	public Integer insetOrder4(Integer userId) {
		return pmOrderMapper.insetOrder4(userId);
	}
	/**
	 * 修改订单状态
	 * @param id
	 */
	@Override
	public void setOrderStatus(Integer id,Integer flag) {
	    //根据id查询当前的订单
	    Order order = pmOrderMapper.selectByPrimaryKey(id);
	    Integer orderStatus = order.getOrderStatus();
	    if(orderStatus==0){
	    	if(flag==1){
	    		order.setOrderStatus(2);
	    	}
	    }
	   
}
}
