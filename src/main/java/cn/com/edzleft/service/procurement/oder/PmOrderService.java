package cn.com.edzleft.service.procurement.oder;

import javax.servlet.http.HttpSession;

import cn.com.edzleft.entity.Order;
import cn.com.edzleft.entity.ReceivingAddress;
import cn.com.edzleft.util.page.PageUtil;

public interface PmOrderService {



	PageUtil<Order> getOrderEntityList(PageUtil<Order> userPage);

	String insetOrder(Integer userId);

	String insetOrder2(Integer userId);

	int insertSelective(Order o,HttpSession sessionInfo);

	String insetOrder3(Integer userId);

	String insetOrder4(Integer userId);

	Order getSelectOrder(Integer id);

	int updOrderStatus(Integer id, Integer flag);

	int commitSqyx(Integer id, Integer flag, String applicationletter);

	Integer insetOrder5(Integer userId);

	Order ddbj(Integer orderId);

	int updataOreder(Order order);



}
