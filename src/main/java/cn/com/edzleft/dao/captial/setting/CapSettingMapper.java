package cn.com.edzleft.dao.captial.setting;

import cn.com.edzleft.entity.Settings;
/**
 * 
 * @author yhs
 * @日期 2017年11月24日
 */
public interface CapSettingMapper {
	/**
	 * 根据用户ID查询设置
	 * @param userId
	 * @return
	 */
	public Settings findSettingByUserId(Integer userId);
	/**
	 * 更新设置
	 * @param setting
	 * @return
	 */
	public Integer update(Settings setting);
}
