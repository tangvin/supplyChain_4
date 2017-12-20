package cn.com.edzleft.service.procurement.contractaward;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.com.edzleft.dao.procurement.contractaward.PmContractWardMapper;
import cn.com.edzleft.entity.AssistContract;
import cn.com.edzleft.entity.Contract;
import cn.com.edzleft.service.procurement.assistcontract.PmAssistContractService;
import cn.com.edzleft.util.page.PageUtil;

@Service
public class PmContractWardServiceImpl implements PmContractWardService{

	@Autowired
	private PmContractWardMapper pmContractWardMapper;
	@Autowired
	private PmAssistContractService pmAssistContractService;

	//根据合同编号查询合同对象
	@Override
	public Contract getContract(String principalOrderId) {
		return pmContractWardMapper.getContract(principalOrderId);
	}

	

	/**
	 * 查询合同列表
	 */
	@Override
	public PageUtil<Contract> queryAllContract(PageUtil<Contract> pageUtil) {
	        //查询所有的满足条件的合同总数
	        Integer totalCount = pmContractWardMapper.getContractCount(pageUtil);
	        //查询所有满足条件的条数
	        List<Contract> list = pmContractWardMapper.getContractByPage(pageUtil);
	        //传子合同到主合同
	        for (Contract contract : list) {
	            Integer contractId = contract.getContractId();
	            List<AssistContract> assistContracts = pmAssistContractService.selectAssistContract(contractId);
	            contract.setAssistContractList(assistContracts);
	        }
	        pageUtil.setTotalCount(totalCount);
	        pageUtil.setList(list);
	        return pageUtil;
	    }

	/**
	 * 添加订单  根据合同签约贸易商id和合同签约采购方id查询出所对应的合同
	 */
	@Override
	public PageUtil<Contract> getInforIdContract(PageUtil<Contract> userPage) {
		//查询总条数
		int totalCount = pmContractWardMapper.getOrderContractCount(userPage);
		 //查询集合
        List<Contract> userList = pmContractWardMapper.getInforIdContract(userPage);
        userPage.setTotalCount(totalCount);
        userPage.setList(userList);
        return userPage;
	}
	}
	
