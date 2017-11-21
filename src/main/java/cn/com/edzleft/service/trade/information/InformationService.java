package cn.com.edzleft.service.trade.information;

import cn.com.edzleft.entity.Information;

/**
 * Created by ibmtech on 2017/11/21.
 */
public interface InformationService {
    /**
     * 基本信息查询
     */
    public Information queryBaseInformation();

    /**
     * 高级信息查询
     */
    public Information queryAdvancedInformation();

    /**
     * 根据id修改用户信息
     */
    public void modiflyInformation(Information f);

}
