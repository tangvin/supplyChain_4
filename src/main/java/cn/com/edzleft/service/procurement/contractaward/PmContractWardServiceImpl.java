package cn.com.edzleft.service.procurement.contractaward;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.com.edzleft.dao.procurement.contractaward.PmContractWardMapper;
import cn.com.edzleft.entity.Contract;

@Service
public class PmContractWardServiceImpl implements PmContractWardService{

	@Autowired
	private PmContractWardMapper pmContractWardMapper;

	//根据合同编号查询合同对象
	@Override
	public Contract getContract(String principalOrderId) {
		return pmContractWardMapper.getContract(principalOrderId);
	}
	
}
