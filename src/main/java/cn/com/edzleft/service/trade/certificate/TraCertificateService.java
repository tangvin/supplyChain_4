package cn.com.edzleft.service.trade.certificate;

import java.util.Map;

import cn.com.edzleft.entity.Ukey;
import cn.com.edzleft.util.page.PageUtil;

public interface TraCertificateService {
	//按条件查询Ukey分页数据
			public PageUtil<Ukey> getUkeyEntityListByConditions(PageUtil<Ukey> userPage);
			public Map<String,Object> getByUserId(Integer userId);
}
