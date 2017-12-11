package cn.com.edzleft.service.trade.certificate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.com.edzleft.dao.trade.certificate.TraCertificateMapper;
import cn.com.edzleft.entity.Ukey;
import cn.com.edzleft.util.page.PageUtil;
@Service
public class TraCertificateServiceImpl implements TraCertificateService {
	
	@Autowired
	private TraCertificateMapper traCertificateMapper;
	
	@Override
	public PageUtil<Ukey> getUkeyEntityListByConditions(PageUtil<Ukey> userPage) {
		//查询总条数
				int totalCount=traCertificateMapper.getUkeyEntityCountsByConditions(userPage);
				//查询集合
				List<Ukey> userList=traCertificateMapper.getUkeyEntityListByConditions(userPage);
				userPage.setTotalCount(totalCount);
				userPage.setList(userList);
				return userPage;
	}

	@Override
	public Map<String, Object> getByUserId(Integer userId) {
		//总条数
				int count = traCertificateMapper.getCounts(userId);
				List<Ukey> uList=traCertificateMapper.getByUserId(userId);
				HashMap<String, Object> map=new HashMap<>();
				map.put("count", count);
				map.put("uList", uList);
				return map;
	}

}
