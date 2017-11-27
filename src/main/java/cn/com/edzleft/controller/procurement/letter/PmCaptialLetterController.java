package cn.com.edzleft.controller.procurement.letter;

import cn.com.edzleft.entity.CreditTable;
import cn.com.edzleft.entity.Letter;
import cn.com.edzleft.service.procurement.letter.LetterService;
import cn.com.edzleft.util.page.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
@RequestMapping()
@Controller
public class LetterController {
	/**
	 * 授用信列表
	 */
	@Autowired
	private LetterService letterService;
	
	@RequestMapping(value = "syxgl") 
	public String getCreditLetter(HttpServletRequest request, Letter lf, CreditTable ct, Integer pageNumber, Integer pageSize){
		PageUtil userPage = new PageUtil();
		userPage.setPageSize(pageSize);//起始位置
		userPage.setCpage(pageNumber);//每页显示几条数据
		String a = request.getParameter("creditNumber");
		String b = request.getParameter("creditStatus");
		String c = request.getParameter("applicant");
		ct.setCreditNumber(a);
		if(b !=null && !"".equals(b)){
			ct.setCreditStatus(new Integer(b));
		}
		ct.setApplicant(c);
		List<CreditTable> creditLetterList = letterService.getCreditLetterList(userPage,ct);
		List<Letter> useLetterList = letterService.getUseLetterList(userPage,lf);
		request.setAttribute("creditLetterList", creditLetterList);
		request.setAttribute("useLetterList", useLetterList);
		return "procurement/management/management";
	}
}
