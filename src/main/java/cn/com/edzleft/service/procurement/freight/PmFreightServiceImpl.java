package cn.com.edzleft.service.procurement.freight;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.com.edzleft.dao.procurement.freight.PmFreightMapper;
import cn.com.edzleft.entity.Freight;

@Service
public class PmFreightServiceImpl implements PmFreightService{

	@Autowired
	private PmFreightMapper pmfreightMapper;
	@Override
	public int insert(Freight fr) {
		return this.pmfreightMapper.insert(fr);
	}
	
	
	@Override
	public Freight queryFreightById(Integer logisticsUnitId) {
		// TODO Auto-generated method stub
		return pmfreightMapper.queryFreightById(logisticsUnitId);
	}

	
}
