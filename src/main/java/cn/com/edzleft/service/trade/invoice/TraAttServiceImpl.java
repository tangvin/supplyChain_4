package cn.com.edzleft.service.trade.invoice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.com.edzleft.dao.trade.invoice.TraAttMapper;
import cn.com.edzleft.entity.Attachment;
@Service
public class TraAttServiceImpl implements TraAttService {
	
	
	@Autowired
	private TraAttMapper traAttMapper;
	@Override
	public Integer updateImg(Attachment attachment) {
		
		
		Integer res=traAttMapper.updateImg(attachment);
		return res;
	}

}
