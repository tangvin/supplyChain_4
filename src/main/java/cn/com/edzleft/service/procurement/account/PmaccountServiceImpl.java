package cn.com.edzleft.service.procurement.account;

import cn.com.edzleft.dao.procurement.account.PmAccountMapper;
import cn.com.edzleft.entity.Account;
import cn.com.edzleft.entity.SessionInfo;
import cn.com.edzleft.util.MD5;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class PmaccountServiceImpl implements Pmaccountservice{

	@Autowired
	private PmAccountMapper pmaccountMapper;
	@Override
	public SessionInfo findUserById(Integer userId) {
		// TODO Auto-generated method stub
		return pmaccountMapper.findUserById(userId);
	}

	@Override
	public String updataPwd(Integer userId, String newpwd, String confirm, String senCode,String code,Date creatDate) {
		if(newpwd == null && "".equals(newpwd)){
			return "请输入新密码！";
		}
		if(confirm == null && "".equals(confirm)){
			return "请输入确认密码！";
		}
		if(senCode == null &&"".equals((senCode))){
			return "请输入验证码！";
		}
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date now = new Date();
		Date date = new Date(now .getTime() - 300000);
		String dateString = String.valueOf(sdf.format(date));
		if(creatDate.getTime()> date.getTime() ) {
			if (senCode.equals(code)) {
				if (newpwd.trim().equals(confirm.trim())) {
					Account acc = new Account();
					//加密后的密码
					String newMd5Pwd = MD5.sign(newpwd);
					acc.setUserId(userId);
					acc.setUserPwd(newMd5Pwd);

					Integer i = pmaccountMapper.updateByPrimaryKeySelective(acc);
					if (i > 0) {
						return "修改密码成功！";
					} else {
						return "修改密码失败！";
					}
				} else {
					return "两次输入的新密码有误，请重新输入！";
				}
			} else {
				return "验证码错误,请重新输入!";
			}
		}else{
			return "验证码过期!";
		}
	}

}


