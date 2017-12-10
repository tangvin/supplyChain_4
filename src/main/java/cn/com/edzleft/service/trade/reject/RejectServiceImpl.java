package cn.com.edzleft.service.trade.reject;

import cn.com.edzleft.dao.trade.reject.RejectMapper;
import cn.com.edzleft.entity.Reject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by ibmtech on 2017/12/7.
 */
@Transactional
@Service
public class RejectServiceImpl implements RejectService {

   @Autowired
   private RejectMapper rejectMapper;

    @Override
    public int addRejectReason(Reject reject,String reason) {
        Reject r = new Reject();
        r.setBussinessType(reject.getBussinessType());
        r.setRejectReason(reason);
        r.setContract_id(reject.getContract_id());
        r.setOrder_id(reject.getRejectId());
        int i = rejectMapper.insertRejectReason(reject);
        return i;
    }

    @Override
    public int cutRejectReason(Reject reject) {
        return 0;
    }

    @Override
    public int queryRejectReason(Integer id) {
        return 0;
    }
}
