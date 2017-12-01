package cn.com.edzleft.service.procurement.account;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.com.edzleft.dao.procurement.account.PmAccountMapper;
import cn.com.edzleft.entity.Account;
import cn.com.edzleft.entity.SessionInfo;
@Service
public class PmaccountServiceImpl implements Pmaccountservice{

	@Autowired
	private PmAccountMapper pmaccountMapper;
	@Override
	public SessionInfo findUserById(Integer userId) {
		return pmaccountMapper.findUserById(userId);
	}
	

	@Override
	public String updataPwd(Integer userId, String oldpwd, String newpwd, String confirm) {
		Account account = pmaccountMapper.selectByPrimaryKey(userId);
		if(account == null){
			return "没有该用户！";
		}
		if(oldpwd == null && "".equals(oldpwd)){
			return "请输入原密码！";
		}
		if(newpwd == null && "".equals(newpwd)){
			return "请输入新密码！";
		}
		if(confirm == null && "".equals(confirm)){
			return "请输入确认密码！";
		}
		if(account.getUserPwd().trim().equals(oldpwd.trim())){
			if(newpwd.trim().equals(confirm.trim())){
				Account acc = new Account();
				acc.setUserId(account.getUserId());
				acc.setUserPwd(newpwd);
				Integer i = pmaccountMapper.updateByPrimaryKeySelective(acc);
				if(i>0){
					return "修改密码成功！";
				}else{
					return "修改密码失败！";
				}
			}else{
				return "两次输入的新密码有误，请重新输入！";
			}
		}else{
			return "输入的原密码有误！";
		}
	}
	}


