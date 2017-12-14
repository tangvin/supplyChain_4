package cn.com.edzleft.service.trade.reject;

import cn.com.edzleft.entity.Reject;

import java.util.List;

/**
 * Created by ibmtech on 2017/12/7.
 */
public interface RejectService {
    /**
     * 添加驳回记录
     * @param reject
     * @return
     */
    public int addRejectReason(Reject reject, String reason);

    /**
     * 删除驳回记录
     */
    public int cutRejectReason(Integer id);

    /**
     * 根据id查询驳回记录
     */
    public int queryRejectReason(Integer id);

    /**
     * 根据订单id查询驳回记录
     * @param Id
     * @return
     */
    public List<Reject> queryRejectByOrderId(Integer id);

    /**
     * 根据合同id查询驳回记录
     * @param Id
     * @return
     */
    public List<Reject> queryRejectByContractId(Integer id);
}
