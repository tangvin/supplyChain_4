package cn.com.edzleft.dao.trade.setting;

import cn.com.edzleft.entity.Settings;
/**
 * 
 * @author yhs
 * @日期 2017年11月21日
 */
public interface SettingMapper {
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
	/**
	 * 创建
	 */
	public Integer insert(Settings setting);
}
