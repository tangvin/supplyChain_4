package cn.com.edzleft.service.procurement.freight;

import cn.com.edzleft.entity.Freight;

public interface PmFreightService {

	int insert(Freight fr);

	Freight queryFreightById(Integer logisticsUnitId);

	
}
