package cn.com.edzleft.service.procurement.setting;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.com.edzleft.dao.procurement.setting.ProSettingMapper;
import cn.com.edzleft.entity.Settings;
/**
 * 
 * @author yhs
 * @日期 2017年11月24日
 */
@Service
@Transactional
public class ProSettingServiceImpl implements ProSettingService {
	@Autowired
	private ProSettingMapper proSettingMapper;
	//根据用户ID查询设置
	@Override
	public Settings querySettingByUserId(Integer userId) {
		Settings settings=proSettingMapper.findSettingByUserId(userId);
		return settings;
	}

	@Override
	public Integer update(Settings setting) {
		return proSettingMapper.update(setting);
	}

	@Override
	public Integer getCount(Integer userId) {
		return proSettingMapper.getCount(userId);
	}

	@Override
	public Integer insert(Settings setting) {
		return proSettingMapper.insert(setting);
	}

}
