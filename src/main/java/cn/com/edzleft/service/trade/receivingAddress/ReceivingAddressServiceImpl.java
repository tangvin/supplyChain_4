package cn.com.edzleft.service.trade.receivingAddress;

import cn.com.edzleft.dao.trade.receivingAddress.ReceivingAddressMapper;
import cn.com.edzleft.entity.ReceivingAddress;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by ibmtech on 2017/11/22.
 */
@Service
@Transactional
public class ReceivingAddressServiceImpl implements ReceivingAddressService {

    @Autowired
   private ReceivingAddressMapper receivingAddressMapper;

    /**
     * 查询所有的收货地址
     * @return
     */
    @Override
    public List<ReceivingAddress> queryAllAddress() {
        List<ReceivingAddress> addresses = receivingAddressMapper.selectAllAddress();
        return addresses;
    }

    /**
     * 添加收货地址
     */
    @Override
    public void addReceivingAddress(ReceivingAddress r) {
        ReceivingAddress address = new ReceivingAddress();
        address.setrAddressArea(r.getrAddressArea());
        address.setrAddressAddress(r.getrAddressAddress());
        address.setrAddressZipcode(r.getrAddressZipcode());
        address.setrAddressPerson(r.getrAddressPerson());
        address.setrAddressPhone(r.getrAddressPhone());
        address.setrAddressDefault(r.getrAddressDefault());
        receivingAddressMapper.insertAddress(address);

    }

    /**
     * 根据id 删除收货地址
     */
    @Override
    public void deleteReceivingAddress(Integer id) {
        receivingAddressMapper.deleteAddress(id);
    }



    /**
     * 修改收货地址
     */
    public void updateAddress(ReceivingAddress address){
        receivingAddressMapper.updateAddress(address);
    }

    /**
     * 修改收货地址
     */
    @Override
    public void modiflyAddress(ReceivingAddress r) {
        ReceivingAddress address = new ReceivingAddress();
        address.setrAddressArea(r.getrAddressArea());
        address.setrAddressAddress(r.getrAddressAddress());
        address.setrAddressZipcode(r.getrAddressZipcode());
        address.setrAddressPerson(r.getrAddressPerson());
        address.setrAddressPhone(r.getrAddressPhone());
        address.setrAddressDefault(r.getrAddressDefault());
        receivingAddressMapper.updateAddress(address);
    }


    /**
     * 根据id 查看收货地址信息
     */
    public ReceivingAddress queryReceivingAddress(Integer id){
        ReceivingAddress address = receivingAddressMapper.selectAddressById(id);
        return address;
    }


}
