package cn.com.edzleft.dao.trade.receivingAddress;

import cn.com.edzleft.entity.ReceivingAddress;

import java.util.List;

/**
 * Created by ibmtech on 2017/11/22.
 */
public interface ReceivingAddressMapper {

    /**
     * 查询所有的收货地址
     */
    public List<ReceivingAddress> selectAllAddress();


    /**
     * 添加收货地址
     */
    public void insertAddress(ReceivingAddress r);


    /**
     * 根据收货id删除收货地址
     */
    public void deleteAddress(Integer id);

    /**
     * 修改收货地址
     */
    public void updateAddress(ReceivingAddress r);



}
