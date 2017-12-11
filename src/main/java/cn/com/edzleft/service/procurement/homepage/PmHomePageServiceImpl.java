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
	/*@Override
	public int addInformation(Information information,HttpSession sessionInfo) {
		int i =pmHomePageMapper.addInformation(information);
		if(i>0){
            //企业身份
            Integer entIdentity = information.getEntIdentity();
            //企业名字
            String entName = information.getEntName();
            //工商注册登记号registration_number
            String registrationNumber = information.getRegistrationNumber();
            //企业社会信用代码
            String entCreditCode = information.getEntCreditCode();
            //获取查询对象
            Information in = pmHomePageMapper.selectByParam(entIdentity, entName, registrationNumber, entCreditCode);
            //获取当前增加的信息id
            Integer informationId = in.getId();
            SessionInfo session = (SessionInfo) sessionInfo.getAttribute("sessionInfo");
            Integer userId = session.getAdmin().getUserId();
            Information infor = pmHomePageMapper.selectBaseInformation(userId);
            Account account = accountMapper.selectAccountById(userId);
            account.setInformationId(informationId);
        }
		return 0;
	}*/
	@Override
	public int addInformation(Information information) {
		int i =pmHomePageMapper.addInformation(information);
		return i;
	}

}
