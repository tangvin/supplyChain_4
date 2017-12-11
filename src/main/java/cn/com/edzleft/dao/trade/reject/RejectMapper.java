package cn.com.edzleft.dao.trade.reject;

import cn.com.edzleft.entity.Reject;

/**
 * Created by ibmtech on 2017/12/7.
 */
public interface RejectMapper {

    /**
     * 添加驳回记录
     * @param reject
     * @return
     */
    public int insertRejectReason(Reject reject);

    /**
     * 删除驳回记录
     */
    public int deleteRejectReason(Integer id );

    /**
     * 根据id查询驳回记录
     */
    public int selectRejectReason(Integer id);

    /**
     * 修改驳回记录
     */
    public int updateReject(Integer id);

}
