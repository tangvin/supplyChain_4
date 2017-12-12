package cn.com.edzleft.service.procurement.homepage;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.com.edzleft.dao.procurement.homepage.PmHomePageMapper;
import cn.com.edzleft.dao.procurement.oder.PmOrderMapper;
import cn.com.edzleft.entity.Account;
import cn.com.edzleft.entity.Information;
import cn.com.edzleft.entity.Order;
import cn.com.edzleft.entity.SessionInfo;

@Service
public class PmHomePageServiceImpl implements PmHomePageService{

	@Autowired
	private PmHomePageMapper pmHomePageMapper;
	
	@Autowired
	private PmOrderMapper pmOrderMapper;

	@Override
	public Information homePageSelect(Integer userId) {
		return pmHomePageMapper.homePageSelect(userId);
	}
	/**
	 * 订单查看
	 */
	@Override
	public Order selectByPrimaryKey(String value) {
		// TODO Auto-generated method stub
		return pmOrderMapper.selectOrder(value);
	}
	/**
	 * 确认修改基础资料
	 */
	@Override
	public int updateInformation(Information information) {
		int i =pmHomePageMapper.updateInformation(information);
		return i;
	}
	/**
	 * 判断用户资料为空，进行添加
	 * 
	 */
	@Override
	public int insertSelective(Information information,HttpSession sessionInfo) {
		SessionInfo sessionInfo1 = (SessionInfo) sessionInfo.getAttribute("sessionInfo");
		Integer userId = sessionInfo1.getAdmin().getUserId();
		information.setCreatorId(userId);
		int i =pmHomePageMapper.insertSelective(information);
		  //判断添加成功后 继续将informatiionId存到数据库
		return i;
	}
	
	
	/**
	 * 新用户注册
	 */
	@Override
	public Information selectByCreatorId(Integer userId) {
		Information information = pmHomePageMapper.selectByCreatorId(userId);
        return information;
	}

}
