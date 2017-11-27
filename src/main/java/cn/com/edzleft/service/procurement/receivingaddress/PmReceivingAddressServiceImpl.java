package cn.com.edzleft.service.procurement.receivingaddress;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.com.edzleft.dao.procurement.receivingaddress.PmReceivingAddressMapper;
import cn.com.edzleft.entity.ReceivingAddress;
@Service
public class PmReceivingAddressServiceImpl implements PmReceivingAddressService{
	@Autowired
	private PmReceivingAddressMapper pmReceivingAddressMapper;
	@Override
	public int deleteByPrimaryKey(Integer rAddressId) {
		// TODO Auto-generated method stub
		return 0;
	}

	/**
	 *添加收货地址
	 */
	@Override
	public int insert(ReceivingAddress ra) {
		return this.pmReceivingAddressMapper.insert(ra);
	}

	@Override
	public ReceivingAddress selectByPrimaryKey(String cId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateByPrimaryKeySelective(ReceivingAddress record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateByPrimaryKeyWithBLOBs(ReceivingAddress record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateByPrimaryKey(ReceivingAddress record) {
		// TODO Auto-generated method stub
		return 0;
	}

}
