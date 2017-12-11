package cn.com.edzleft.dao.trade.certificate;

import java.util.List;

import cn.com.edzleft.entity.Ukey;
import cn.com.edzleft.util.page.PageUtil;

public interface TraCertificateMapper {
	/**Ukey
	 * 根据Map<String,Object>对象查询符合条件的总数据数
	 * @param userPage
	 * @return
	 */
	int getUkeyEntityCountsByConditions(PageUtil<Ukey> userPage);
	/**Ukey
	 * 根据Map<String,Object>分页查询
	 * @param userPage
	 * @return
	 */
	List<Ukey> getUkeyEntityListByConditions(PageUtil<Ukey> userPage);
	//根据userId查询条数
	int getCounts(Integer userId);
	//根据userId查询ukey
	List<Ukey> getByUserId(Integer userId);


}
