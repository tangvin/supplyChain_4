package cn.com.edzleft.service.procurement.oder;

import cn.com.edzleft.entity.Order;
import cn.com.edzleft.util.page.PageUtil;

public interface PmOrderService {



	PageUtil<Order> getOrderEntityList(PageUtil<Order> userPage);

	String insetOrder(Integer userId);

	String insetOrder2(Integer userId);

	int insertSelective(Order o);

	String insetOrder3(Integer userId);

	Integer insetOrder4(Integer userId);

	void setOrderStatus(Integer id, Integer flag);

}
