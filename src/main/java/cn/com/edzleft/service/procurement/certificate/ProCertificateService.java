package cn.com.edzleft.service.procurement.certificate;

import java.util.Map;

import cn.com.edzleft.entity.Ukey;
import cn.com.edzleft.util.page.PageUtil;
/**
 * 
 * @author yhs
 * @日期 2017年11月29日
 */
public interface ProCertificateService {
	//按条件查询Ukey分页数据
		public PageUtil<Ukey> getUkeyEntityListByConditions(PageUtil<Ukey> userPage);
		public Map<String,Object> getByUserId(Integer userId);
}
