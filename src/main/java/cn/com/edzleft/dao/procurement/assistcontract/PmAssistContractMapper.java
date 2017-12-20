package cn.com.edzleft.dao.procurement.assistcontract;

import java.util.List;

import cn.com.edzleft.entity.AssistContract;

public interface PmAssistContractMapper {

	List<AssistContract> selectContractListById(Integer id);

}
