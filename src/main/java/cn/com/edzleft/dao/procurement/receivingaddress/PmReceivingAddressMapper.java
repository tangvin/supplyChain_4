package cn.com.edzleft.dao.procurement.receivingaddress;

import cn.com.edzleft.entity.ReceivingAddress;

public interface PmReceivingAddressMapper {
	int deleteByPrimaryKey(Integer rAddressId);

    int insert(ReceivingAddress ra);

    int insertSelective(ReceivingAddress record);

    ReceivingAddress selectByPrimaryKey(String cId);

    int updateByPrimaryKeySelective(ReceivingAddress record);

    int updateByPrimaryKeyWithBLOBs(ReceivingAddress record);

    int updateByPrimaryKey(ReceivingAddress record);


}
