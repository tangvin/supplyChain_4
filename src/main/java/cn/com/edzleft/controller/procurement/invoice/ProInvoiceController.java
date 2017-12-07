package cn.com.edzleft.controller.procurement.invoice;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.com.edzleft.entity.Account;
import cn.com.edzleft.entity.InvoiceRecord;
import cn.com.edzleft.entity.SessionInfo;
import cn.com.edzleft.service.procurement.invocie.ProInvoiceService;
import cn.com.edzleft.util.page.DataGridJson;
import cn.com.edzleft.util.page.PageUtil;

@Controller
@RequestMapping("/proInvoice")
public class ProInvoiceController {
	
	@Autowired
	private ProInvoiceService proInvoiceService;
	
	@RequestMapping(value = "/invoiceList",method = RequestMethod.POST)
    @ResponseBody
    public DataGridJson invoiceList(HttpSession session,Integer pageNumber,Integer pageSize,String invoiceNumber,String drawer) {
		DataGridJson dgj = new DataGridJson();
		PageUtil<InvoiceRecord> userPage = new PageUtil<>();
		HashMap<String, Object> whereMaps = new HashMap<>();
		SessionInfo sessionInfo = (SessionInfo) session.getAttribute("sessionInfo");
		Account sessionAccount=sessionInfo.getAdmin();
		Integer invoiceUserId=sessionAccount.getUserId();
		whereMaps.put("invoiceUserId", invoiceUserId);
		whereMaps.put("invoiceNumber",invoiceNumber);
		whereMaps.put("drawer",drawer);
		/*System.out.println("================");
		System.out.println(drawer);
		System.out.println("================");*/
		userPage.setCpage(pageNumber);
		userPage.setPageSize(pageSize);
        userPage.setWhereMap(whereMaps);
        
        userPage = proInvoiceService.getInvoiceRecordEntityListByConditions(userPage);
        dgj.setTotal(userPage.getTotalCount());
        dgj.setRows(userPage.getList());
		return dgj;
	}
	
	/*@RequestMapping("/edit")
	public String edit(Map<String, Object> map,Integer id) {
		System.out.println("=============");
		System.out.println(id);
		System.out.println("=============");
		InvoiceRecord invoiceRecord = proInvoiceService.getById(id);
		map.put("invoiceRecord", invoiceRecord);
		return "/procurement/invoice/edit";
	}*/
}
