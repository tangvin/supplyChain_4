package cn.com.edzleft.service.procurement.shouye;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.com.edzleft.dao.procurement.shouye.InformationMapper;
import cn.com.edzleft.entity.Information;

@Service
public class InformationServiceImpl implements InformationService{

	@Autowired
	private InformationMapper informationMapper;

	@Override
	public List<Information> getInformationList() {
		return informationMapper.getInformationList();
	}
}
