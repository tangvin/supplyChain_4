package cn.com.edzleft.dao.trade.information;

import cn.com.edzleft.entity.Information;

import java.util.Date;

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

    /**
     * 新增加一个用户信息
     */
    public int insertInformation(Information information);




    public Information selectByCreatorId(Integer id);



}
