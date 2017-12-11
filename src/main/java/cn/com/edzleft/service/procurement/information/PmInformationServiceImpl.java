package cn.com.edzleft.service.procurement.information;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.com.edzleft.dao.procurement.freight.PmFreightMapper;
import cn.com.edzleft.dao.procurement.information.PmInformationMapper;
import cn.com.edzleft.dao.procurement.receivingaddress.PmReceivingAddressMapper;
import cn.com.edzleft.entity.Freight;
import cn.com.edzleft.entity.Information;
import cn.com.edzleft.entity.ReceivingAddress;

@Service
public class PmInformationServiceImpl implements PmInformationService{

	@Autowired
	private PmInformationMapper informationMapper;
	
	@Autowired
	private PmReceivingAddressMapper receivingAddressMapper;

	@Autowired
	private PmFreightMapper freightMapper;
	
	@Override
	public List<Information> getInformationList() {
		return informationMapper.getInformationList();
	}

	@Override
	public int insert(ReceivingAddress ra) {
		return this.receivingAddressMapper.insert(ra);
	}

	@Override
	public int insert(Freight fr) {
		return this.freightMapper.insert(fr);
	}
}
