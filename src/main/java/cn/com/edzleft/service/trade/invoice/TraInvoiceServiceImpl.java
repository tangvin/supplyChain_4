package cn.com.edzleft.service.trade.invoice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.com.edzleft.dao.trade.invoice.TraInvoiceMapper;
import cn.com.edzleft.entity.Attachment;
import cn.com.edzleft.entity.InvoiceRecord;
import cn.com.edzleft.util.page.PageUtil;
@Service
public class TraInvoiceServiceImpl implements TraInvoiceService {
	@Autowired
	private TraInvoiceMapper traInvoiceMapper;
	@Override
	public PageUtil<InvoiceRecord> getInvoiceRecordEntityListByConditions(PageUtil<InvoiceRecord> userPage) {
		//查询总条数
		int totalCount=traInvoiceMapper.getInvoiceRecordEntityCountsByConditions(userPage);
		//查询集合
		List<InvoiceRecord> userList=traInvoiceMapper.getInvoiceRecordEntityListByConditions(userPage);
		userPage.setTotalCount(totalCount);
		userPage.setList(userList);
		return userPage;
	}

	@Override
	public InvoiceRecord getById(Integer id) {
		
		return traInvoiceMapper.getById(id);
	}

	@Override
	public Integer update(InvoiceRecord invoiceRecord) {
		
		Integer res=traInvoiceMapper.update(invoiceRecord);
		
		return res;
	}

	

}
