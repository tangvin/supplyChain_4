package cn.com.edzleft.service.trade.freight;

import cn.com.edzleft.entity.Freight;

import java.util.List;

/**
 * Created by ibmtech on 2017/11/22.
 */
public interface FreightService {

    /**
     * 查询所有的货运单位
     */
    public List<Freight> queryAllFreight();

    /**
     * 添加货源单位
     */
    public void addFreight(Freight freight);

    /**
     * 根据货运id 删除货运单位
     */
    public void deleteFreight(Integer id);

    /**
     * 设置货运单位为默认单位
     */
    public void setDefaultAddress(Freight freight);

}
