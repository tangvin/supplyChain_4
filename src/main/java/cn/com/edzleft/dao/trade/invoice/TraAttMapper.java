package cn.com.edzleft.dao.trade.invoice;

import cn.com.edzleft.entity.Attachment;
import cn.com.edzleft.entity.InvoiceRecord;

public interface TraAttMapper {
	Integer updateImg(Attachment attachment);


	//上传发票附件
	public Integer insertAttachment(Attachment attachment);

}
