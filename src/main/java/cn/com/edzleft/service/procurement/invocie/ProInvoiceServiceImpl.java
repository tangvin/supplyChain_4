package cn.com.edzleft.service.procurement.invocie;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.com.edzleft.dao.procurement.invoice.ProInvoiceMapper;
import cn.com.edzleft.entity.InvoiceRecord;
import cn.com.edzleft.util.page.PageUtil;
@Service
public class ProInvoiceServiceImpl implements ProInvoiceService {
	
	@Autowired
	private ProInvoiceMapper proInvoiceMapper;
	
	@Override
	public PageUtil<InvoiceRecord> getInvoiceRecordEntityListByConditions(PageUtil<InvoiceRecord> userPage) {
		//查询总条数
		int totalCount=proInvoiceMapper.getInvoiceRecordEntityCountsByConditions(userPage);
		//查询集合
		List<InvoiceRecord> userList=proInvoiceMapper.getInvoiceRecordEntityListByConditions(userPage);
		userPage.setTotalCount(totalCount);
		userPage.setList(userList);
		return userPage;
	}

	@Override
	public InvoiceRecord getById(Integer id) {
		return proInvoiceMapper.getById(id);
	}

}
