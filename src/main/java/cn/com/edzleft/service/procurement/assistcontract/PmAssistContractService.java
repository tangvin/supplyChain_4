package cn.com.edzleft.service.procurement.assistcontract;

import java.util.List;

import cn.com.edzleft.entity.AssistContract;

public interface PmAssistContractService {

	/**
     * 根据主合同id查询子合同
     */
    public List<AssistContract> selectAssistContract(Integer id);
}


