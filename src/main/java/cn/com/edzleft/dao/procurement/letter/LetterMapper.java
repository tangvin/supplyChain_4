package cn.com.edzleft.dao.procurement.letter;

import java.util.List;

import cn.com.edzleft.entity.CreditTable;
import cn.com.edzleft.entity.Leffer;
import cn.com.edzleft.util.page.PageUtil;

public interface LetterMapper {


	List<Leffer> getUseLetterList(PageUtil<Leffer> userPage);

	List<CreditTable> getCreditLetterList(PageUtil<CreditTable> userPage);

}
