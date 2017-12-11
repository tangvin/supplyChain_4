package cn.com.edzleft.service.trade.setting;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.com.edzleft.dao.trade.setting.SettingMapper;
import cn.com.edzleft.entity.Settings;
/**
 * 
 * @author yhs
 * @日期 2017年11月21日
 */
@Service
@Transactional
public class SettingServiceImpl implements SettingService{
	@Autowired
	private SettingMapper settingMapper;
	
	//根据用户ID查询设置
	@Override
	public Settings querySettingByUserId(Integer userId) {
		Settings settings=settingMapper.findSettingByUserId(userId);
		return settings;
	}

	@Override
	public Integer update(Settings setting) {
		return settingMapper.update(setting);
	}

}
