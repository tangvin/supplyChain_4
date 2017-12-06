package cn.com.edzleft.service.procurement.receivingaddress;

import java.util.List;

import javax.servlet.http.HttpSession;

import cn.com.edzleft.entity.ReceivingAddress;

public interface PmReceivingAddressService {
	int deleteByPrimaryKey(Integer rAddressId);

    ReceivingAddress selectByPrimaryKey(String cId);

    int updateByPrimaryKeySelective(ReceivingAddress record);

    int updateByPrimaryKeyWithBLOBs(ReceivingAddress record);

    int updateByPrimaryKey(ReceivingAddress record);

	int insert(ReceivingAddress ra);

	ReceivingAddress queryReceivingAddress(Integer addressId);

	List<ReceivingAddress> selectByPrimaryKey(Integer userId);

	int setDefaultAddress(Integer id, HttpSession session, Integer value);

	int deleteAddress(Integer id);






}
