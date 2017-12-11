package cn.com.edzleft.service.captial.setting;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.com.edzleft.dao.captial.setting.CapSettingMapper;
import cn.com.edzleft.entity.Settings;
/**
 * 
 * @author yhs
 * @日期 2017年11月24日
 */
@Service
@Transactional
public class CapSettingServiceImpl implements CapSettingService {
	@Autowired
	private CapSettingMapper capSettingMapper;
	
	@Override
	public Settings querySettingByUserId(Integer userId) {
		Settings settings=capSettingMapper.findSettingByUserId(userId);
		return settings;
	}

	@Override
	public Integer update(Settings setting) {
		return capSettingMapper.update(setting);
	}

}
