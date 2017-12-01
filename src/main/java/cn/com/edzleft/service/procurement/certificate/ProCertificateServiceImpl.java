package cn.com.edzleft.service.procurement.certificate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.com.edzleft.dao.procurement.certificate.ProCertificateMapper;
import cn.com.edzleft.entity.Ukey;
import cn.com.edzleft.util.page.PageUtil;
/**
 * 
 * @author yhs
 * @日期 2017年11月29日
 */
@Service
public class ProCertificateServiceImpl implements ProCertificateService {

	@Autowired
	private ProCertificateMapper proCertificateMapper;
	
	@Override
	public PageUtil<Ukey> getUkeyEntityListByConditions(PageUtil<Ukey> userPage) {
		//查询总条数
		int totalCount=proCertificateMapper.getUkeyEntityCountsByConditions(userPage);
		//查询集合
		List<Ukey> userList=proCertificateMapper.getUkeyEntityListByConditions(userPage);
		userPage.setTotalCount(totalCount);
		userPage.setList(userList);
		return userPage;
	}

	@Override
	public HashMap<String,Object> getByUserId(Integer userId) {
		//总条数
		int count = proCertificateMapper.getCounts(userId);
		List<Ukey> uList=proCertificateMapper.getByUserId(userId);
		HashMap<String, Object> map=new HashMap<>();
		map.put("count", count);
		map.put("uList", uList);
		return map;
	}

}
