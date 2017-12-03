package cn.com.edzleft.dao.procurement.oder;

import java.util.List;

import cn.com.edzleft.entity.Order;
import cn.com.edzleft.entity.ReceivingAddress;
import cn.com.edzleft.util.page.PageUtil;

public interface PmOrderMapper {

	List<Order> getCrownEntityList(PageUtil<Order> userPage);


	int getCrownEntityCounts(PageUtil<Order> userPage);


	String insetOrder(Integer userId);


	String insetOrder2(Integer userId);

	int insertSelective(Order o);


	String insetOrder3(Integer userId);


	String insetOrder4(Integer userId);

	Order selectByPrimaryKey(Integer id);


	void updOrderStatus(Order order);


	Integer insetOrder5(Integer userId);

	
}
