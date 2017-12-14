package cn.com.edzleft.service.trade.invoice;

import cn.com.edzleft.entity.Attachment;

public interface TraAttService {

	//修改
	public Integer updateImg(Attachment attachment);

	//上传发票附件
	public  Integer addAttachment(Attachment attachment);
}
