package cn.com.edzleft.service.procurement.setting;

import cn.com.edzleft.entity.Settings;
/**
 * 
 * @author yhs
 * @日期 2017年11月24日
 */
public interface ProSettingService {
	/**
	 * 根据用户ID查询设置
	 * @param userId
	 * @return
	 */
	public Settings querySettingByUserId(Integer userId);
	/**
	 * 保存设置
	 * @param setting
	 * @return
	 */
	public Integer update(Settings setting);
}
