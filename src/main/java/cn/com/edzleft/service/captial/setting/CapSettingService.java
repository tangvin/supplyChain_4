package cn.com.edzleft.service.captial.setting;

import cn.com.edzleft.entity.Settings;
/**
 * 
 * @author yhs
 * @日期 2017年11月24日
 */
public interface CapSettingService {
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
	
	/**
	 * 查询是否存在
	 * @param userId
	 * @return
	 */
	public Integer getCount(Integer userId);
	/**
	 * 创建
	 */
	public Integer insert(Settings setting);
}
