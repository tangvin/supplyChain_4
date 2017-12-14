package cn.com.edzleft.service.trade.reject;

import cn.com.edzleft.dao.trade.reject.RejectMapper;
import cn.com.edzleft.entity.Reject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by ibmtech on 2017/12/7.
 */
@Transactional
@Service
public class RejectServiceImpl implements RejectService {

   @Autowired
   private RejectMapper rejectMapper;

    /**
     * 添加驳回记录
     * @param reject
     * @param reason
     * @return
     */
    @Override
    public int addRejectReason(Reject reject,String reason) {
        Reject r = new Reject();
        r.setBussinessType(reject.getBussinessType());
        r.setRejectReason(reason);
        r.setContractId(reject.getContractId());
        r.setOrderId(reject.getRejectId());
        int i = rejectMapper.insertRejectReason(reject);
        return i;
    }

    /**
     * 删除驳回记录
     * @param
     * @return
     */
    @Override
    public int cutRejectReason(Integer id) {
        int i = rejectMapper.deleteRejectReason(id);
        return i;
    }

    /**
     * 查询驳回记录
     * @param id
     * @return
     */
    @Override
    public int queryRejectReason(Integer id) {
        int i = rejectMapper.selectRejectReason(id);
        return i;
    }

    @Override
    public List<Reject> queryRejectByOrderId(Integer id) {
        List<Reject> rejectList = rejectMapper.selectRejectCountByorderId(id);
        return rejectList;
    }

    @Override
    public List<Reject> queryRejectByContractId(Integer id) {
        List<Reject> rejectList = rejectMapper.selectRejectCountByContractId(id);
        return rejectList;
    }


}
