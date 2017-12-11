package cn.com.edzleft.service.trade.information;

import cn.com.edzleft.entity.Information;

import javax.servlet.http.HttpSession;

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

    /**
     * 新增加一个用户信息
     */
    public int addInformation(Information information, HttpSession session);
}
