package cn.com.edzleft.service.procurement.receivingaddress;

import cn.com.edzleft.entity.ReceivingAddress;

public interface PmReceivingAddressService {
	int deleteByPrimaryKey(Integer rAddressId);

    ReceivingAddress selectByPrimaryKey(String cId);

    int updateByPrimaryKeySelective(ReceivingAddress record);

    int updateByPrimaryKeyWithBLOBs(ReceivingAddress record);

    int updateByPrimaryKey(ReceivingAddress record);

	int insert(ReceivingAddress ra);





}
