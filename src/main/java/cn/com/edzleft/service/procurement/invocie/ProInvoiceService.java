package cn.com.edzleft.service.procurement.invocie;

import cn.com.edzleft.entity.InvoiceRecord;
import cn.com.edzleft.util.page.PageUtil;

public interface ProInvoiceService {
	//根据条件查询集合
	public PageUtil<InvoiceRecord> getInvoiceRecordEntityListByConditions(PageUtil<InvoiceRecord> userPage);
	
	//根据id查询详情
	public InvoiceRecord getById(Integer id);
}
