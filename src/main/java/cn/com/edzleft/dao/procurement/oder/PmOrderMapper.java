package cn.com.edzleft.dao.procurement.oder;


import cn.com.edzleft.entity.Information;
import cn.com.edzleft.entity.Order;
import cn.com.edzleft.util.page.PageUtil;

import java.util.List;
import java.util.Map;

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

	Order selectOrder(String orderNumber);


	//编辑回写订单
	Order ddbj(Integer orderId);


	int updataOreder(Order order);
	/**
	 * 接口用信查询
	 * @return
	 */
    List<Map<String, Object>> selectOrderLetter();


	void updateInformation(Information information);


	List<Information> getIfor();
}
