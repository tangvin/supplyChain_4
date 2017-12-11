package cn.com.edzleft.service.captial.certificate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.com.edzleft.dao.captial.certificate.CapCertificateMapper;
import cn.com.edzleft.entity.Ukey;
import cn.com.edzleft.util.page.PageUtil;
/**
 * 
 * @author yhs
 * @日期 2017年11月27日
 */
@Service
public class CapCertificateServiceImpl implements CapCertificateService {
	
	@Autowired
	private CapCertificateMapper capCertificateMapper;
	
	@Override
	public PageUtil<Ukey> getUkeyEntityListByConditions(PageUtil<Ukey> userPage) {
		//查询总条数
		int totalCount=capCertificateMapper.getUkeyEntityCountsByConditions(userPage);
		//查询集合
		List<Ukey> userList=capCertificateMapper.getUkeyEntityListByConditions(userPage);
		userPage.setTotalCount(totalCount);
		userPage.setList(userList);
		return userPage;
	}

	@Override
	public HashMap<String,Object> getByUserId(Integer userId) {
		//总条数
		int count = capCertificateMapper.getCounts(userId);
		List<Ukey> uList=capCertificateMapper.getByUserId(userId);
		HashMap<String, Object> map=new HashMap<>();
		map.put("count", count);
		map.put("uList", uList);
		return map;
	}

}
