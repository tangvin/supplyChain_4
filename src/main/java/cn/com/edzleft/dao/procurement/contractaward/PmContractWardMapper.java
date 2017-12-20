package cn.com.edzleft.dao.procurement.contractaward;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cn.com.edzleft.entity.Contract;
import cn.com.edzleft.util.page.PageUtil;

public interface PmContractWardMapper {

	Contract getContract(String principalOrderId);

	/**
	 * 添加订单  根据合同签约贸易商id和合同签约采购方id查询出所对应的合同
	 */
	int getOrderContractCount(PageUtil<Contract> userPage);
	List<Contract> getInforIdContract(PageUtil<Contract> pageUtil);

	/**
	 * 查询合同列表
	 * @param pageUtil
	 * @return
	 */

	Integer getContractCount(PageUtil<Contract> pageUtil);

	List<Contract> getContractByPage(PageUtil<Contract> pageUtil);

	
	
	

}
