package cn.com.edzleft.service.procurement.information;

import java.util.List;

import cn.com.edzleft.entity.Freight;
import cn.com.edzleft.entity.Information;
import cn.com.edzleft.entity.ReceivingAddress;

public interface PmInformationService {

	List<Information> getInformationList();
	
	int insert(ReceivingAddress ra);

	int insert(Freight fr);

}
