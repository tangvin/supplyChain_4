package cn.com.edzleft.service.trade.invoice;

import java.util.*;

import cn.com.edzleft.entity.SessionInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.com.edzleft.dao.trade.invoice.TraInvoiceMapper;
import cn.com.edzleft.entity.Attachment;
import cn.com.edzleft.entity.InvoiceRecord;
import cn.com.edzleft.util.page.PageUtil;

import javax.servlet.http.HttpSession;

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

    /**
     * 新增发票
     * @param invoiceRecord
     * @return
     */
	@Override
	public Integer addInvoiceRecord(InvoiceRecord invoiceRecord,HttpSession sessionInfo) {
        SessionInfo session = (SessionInfo) sessionInfo.getAttribute("sessionInfo");
        Integer userId = session.getAdmin().getUserId();
        String in=String.valueOf(userId);

        //拆分用户id
        List<String> list= Arrays.asList(in.split(""));
        Collections.shuffle(list);
        /*获取随机数0-9*/
        String out=new String();
        Random r=new Random();
        int f = r.nextInt(10);
        /*获取当前时间戳*/
        long currentTimeMillis = System.currentTimeMillis();
        String invoiceNumber= "";
        //自动生成发票编号
        invoiceNumber = "I"+f+currentTimeMillis;
	    InvoiceRecord invoice = new InvoiceRecord();
		//设置发票编号
        invoiceRecord.setInvoiceNumber(invoiceNumber);
        int m = traInvoiceMapper.insertInvoiceRecord(invoiceRecord);
        return m;
	}



}
