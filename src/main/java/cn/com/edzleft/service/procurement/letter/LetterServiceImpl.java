package cn.com.edzleft.service.procurement.letter;

import java.util.HashMap;
import java.util.List;

import cn.com.edzleft.entity.Letter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import cn.com.edzleft.dao.procurement.letter.LetterMapper;
import cn.com.edzleft.entity.CreditTable;
import cn.com.edzleft.util.page.PageUtil;

@Service
public class LetterServiceImpl implements LetterService{
	@Autowired
	private LetterMapper letterMapper;

	@Override
	public List<Letter> getUseLetterList(PageUtil<Letter> userPage, Letter lf) {
		return letterMapper.getUseLetterList(userPage);
	}

	@Override
	public List<CreditTable> getCreditLetterList(PageUtil<CreditTable> userPage, CreditTable ct) {
		HashMap<String, Object> map = new HashMap<String,Object>();
		map.put("creditNumber", ct.getCreditNumber());
		map.put("applicant", ct.getApplicant());
		map.put("creditStatus", ct.getCreditStatus());
		userPage.setWhereMap(map);
		return letterMapper.getCreditLetterList(userPage);
	}
}
