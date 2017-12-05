package cn.com.edzleft.service.trade.information;

import cn.com.edzleft.entity.Information;

/**
 * Created by ibmtech on 2017/11/21.
 */
public interface TradeInformationService {
    /**
     * 基本信息查询
     */
    public Information queryBaseInformation(Integer id);


    /**
     * 根据id修改用户信息
     */
    public int modifyInformation(Information f);

}
