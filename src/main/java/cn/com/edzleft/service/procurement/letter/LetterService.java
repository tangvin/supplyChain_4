package cn.com.edzleft.service.procurement.letter;

import java.util.List;

import cn.com.edzleft.entity.CreditTable;
import cn.com.edzleft.entity.Letter;
import cn.com.edzleft.util.page.PageUtil;

public interface LetterService {

	List<CreditTable> getCreditLetterList(PageUtil<CreditTable> userPage, CreditTable ct);

	List<Letter> getUseLetterList(PageUtil<Letter> userPage, Letter lf);

}
