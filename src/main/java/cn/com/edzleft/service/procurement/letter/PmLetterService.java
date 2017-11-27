package cn.com.edzleft.service.procurement.letter;

import cn.com.edzleft.entity.CreditTable;
import cn.com.edzleft.entity.Letter;
import cn.com.edzleft.util.page.PageUtil;

import java.util.List;

public interface LetterService {

	List<CreditTable> getCreditLetterList(PageUtil<CreditTable> userPage, CreditTable ct);

	List<Letter> getUseLetterList(PageUtil<Letter> userPage, Letter lf);

}
