package cn.com.edzleft.service.procurement.assistcontract;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.com.edzleft.dao.procurement.assistcontract.PmAssistContractMapper;
import cn.com.edzleft.entity.AssistContract;

@Service
public class PmAssistContractServiceImpl implements PmAssistContractService{

	@Autowired
	private PmAssistContractMapper pmAssistContractMapper;
	/**
	 *查询辅合同
	 */
	@Override
	public List<AssistContract> selectAssistContract(Integer id) {
		 List<AssistContract> assistContracts = pmAssistContractMapper.selectContractListById(id);
	     return assistContracts;
	}

}
