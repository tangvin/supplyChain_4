package cn.com.edzleft.service.procurement.contractaward;



import cn.com.edzleft.entity.Contract;
import cn.com.edzleft.util.page.PageUtil;

public interface PmContractWardService {

	Contract getContract(String principalOrderId);
	//添加订单  根据合同签约贸易商id和合同签约采购方id查询出所对应的合同
	PageUtil<Contract> getInforIdContract(PageUtil<Contract> userPage);
	//查询合同列表
	PageUtil<Contract> queryAllContract(PageUtil<Contract> pageUtil);
	
}
