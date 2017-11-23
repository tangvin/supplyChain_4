package cn.com.edzleft.dao.trade.information;

import cn.com.edzleft.entity.Information;

/**
 * Created by ibmtech on 2017/11/21.
 */
public interface TradeInformationMapper {
    /**
     * 基本信息查询
     */
    public Information selectBaseInformation();


    /**
     * 修改基本信息
     * param :id
     */
    public void updateInformation(Information info);

}
