package cn.com.edzleft.service.trade.freight;

import cn.com.edzleft.dao.trade.freight.FreightMapper;
import cn.com.edzleft.entity.Freight;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by ibmtech on 2017/11/22.
 */
@Service
@Transactional
public class FreightServiceImpl implements FreightService {

    @Autowired
    private FreightMapper freightMapper;

    /**
     * 查询所有的货运单位
     * @return
     */
    @Override
    public List<Freight> queryAllFreight() {
        List<Freight> freights = freightMapper.selectAllFreight();
        return freights;
    }

    /**
     * 添加货运单位
     * @param freight
     */
    @Override
    public void addFreight(Freight freight) {
        freightMapper.insertFreight(freight);
    }

    /**
     * 根据id删除货运单位
     * @param id
     */
    @Override
    public void deleteFreight(Integer id) {
        freightMapper.deleteFreight(id);
    }

    /**
     * 设置默认货运单位
     */
    @Override
    public void setDefaultAddress(Freight freight) {
        //查询出为默认地址的货运单位
        List<Freight> list = freightMapper.selectFreightByAddress();
        for (Freight f : list) {
            f.setFreightDefaultAddress(0);
        }
        if(freight.getFreightDefaultAddress()==0){
            freight.setFreightDefaultAddress(1);
        }else {
            freight.setFreightDefaultAddress(0);
        }
        freightMapper.updateFreight(freight);
    }



}
