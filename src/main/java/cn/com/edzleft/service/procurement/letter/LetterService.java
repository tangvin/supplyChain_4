package cn.com.edzleft.service.procurement.letter;

import java.util.List;

import cn.com.edzleft.entity.CreditTable;
import cn.com.edzleft.entity.Leffer;
import cn.com.edzleft.util.page.PageUtil;

public interface LetterService {

	List<CreditTable> getCreditLetterList(PageUtil<CreditTable> userPage, CreditTable ct);

	List<Leffer> getUseLetterList(PageUtil<Leffer> userPage, Leffer lf);

}
