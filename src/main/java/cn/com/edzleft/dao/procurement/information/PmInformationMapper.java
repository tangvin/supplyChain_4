package cn.com.edzleft.dao.procurement.information;

import java.util.List;

import cn.com.edzleft.entity.Information;
import cn.com.edzleft.entity.ReceivingAddress;

public interface PmInformationMapper {

	List<Information> getInformationList();

	String insert(ReceivingAddress ra);

}
