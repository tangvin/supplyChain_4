package cn.com.edzleft.service.procurement.oder;

import cn.com.edzleft.entity.Order;
import cn.com.edzleft.util.page.PageUtil;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

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

	/**
	 * 接口用信查询
	 * @return
	 */
    List<Map<String, Object>> selectOrderLetter();
}
