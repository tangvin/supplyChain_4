package cn.com.edzleft.service.trade.invoice;

import cn.com.edzleft.entity.Attachment;
import cn.com.edzleft.entity.InvoiceRecord;
import cn.com.edzleft.util.page.PageUtil;

import javax.servlet.http.HttpSession;

public interface TraInvoiceService {
	//根据条件查询集合
		public PageUtil<InvoiceRecord> getInvoiceRecordEntityListByConditions(PageUtil<InvoiceRecord> userPage);
		
		//根据id查询详情
		public InvoiceRecord getById(Integer id);

		public Integer update(InvoiceRecord invoiceRecord);

		//新增发票
		public Integer addInvoiceRecord(InvoiceRecord invoiceRecord, HttpSession sessionInfo);
		
}
