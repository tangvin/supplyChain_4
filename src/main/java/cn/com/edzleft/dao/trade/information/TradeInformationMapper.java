package cn.com.edzleft.dao.trade.information;

import cn.com.edzleft.entity.Information;

/**
 * Created by ibmtech on 2017/11/21.
 */
public interface TradeInformationMapper {
    /**
     * 基本信息查询+用户账号信息
     */
    public Information selectBaseInformation(Integer id);


    /**
     * 修改基本信息
     * param :id
     */
    public int updateInformation(Information info);

}
