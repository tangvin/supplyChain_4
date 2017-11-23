package cn.com.edzleft.dao.procurement.letter;

import cn.com.edzleft.entity.CreditTable;
import cn.com.edzleft.entity.Letter;
import cn.com.edzleft.util.page.PageUtil;

import java.util.List;

public interface LetterMapper {


	List<Letter> getUseLetterList(PageUtil<Letter> userPage);

	List<CreditTable> getCreditLetterList(PageUtil<CreditTable> userPage);

}
