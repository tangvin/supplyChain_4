package cn.com.edzleft.service.register;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.com.edzleft.dao.register.RegisterMapper;
import cn.com.edzleft.entity.Account;
@Service
public class RegisterServiceImpl implements RegisterService{
	
	@Autowired
	private RegisterMapper registerMapper;
	
	@Override
	public int insert(Account account) {
		
		return registerMapper.insert(account);
	}

	@Override
	public int count(String userName) {
		return registerMapper.count(userName);
	}

}
