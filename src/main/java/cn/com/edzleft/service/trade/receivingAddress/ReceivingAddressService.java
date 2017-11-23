package cn.com.edzleft.service.trade.receivingAddress;

import cn.com.edzleft.entity.ReceivingAddress;

import java.util.List;

/**
 * Created by ibmtech on 2017/11/22.
 */
public interface ReceivingAddressService{

    /**
     * 查询所有的收货地址
     */
    public List<ReceivingAddress> queryAllAddress();


    /**
     * 添加收货地址
     */
    public void addReceivingAddress(ReceivingAddress address);


    /**
     * 根据收货地址id删除收货地址
     */
    public void deleteReceivingAddress(Integer id);


    /**
     * 修改收货地址信息
     */
    public void modiflyAddress(ReceivingAddress r);
}
