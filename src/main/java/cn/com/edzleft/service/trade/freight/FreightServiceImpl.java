package cn.com.edzleft.service.trade.freight;

import cn.com.edzleft.dao.trade.freight.FreightMapper;
import cn.com.edzleft.entity.Freight;
import cn.com.edzleft.entity.SessionInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by ibmtech on 2017/11/22.
 */
@Service
@Transactional
public class FreightServiceImpl implements FreightService {


    @Autowired
    private FreightMapper freightMapper;

    @Override
    public List<Freight> queryFreightByAccountId(Integer id) {
        List<Freight> freights = freightMapper.selectFreightByAccountId(id);
        return freights;
    }

    /**
     * 根据订单表中的货运id查询出对应的所有的货运管理地址
     *
     * @param id
     * @return
     */
    @Override
    public List<Freight> queryFreightByOrder(Integer id) {
        List<Freight> list = freightMapper.selectFreightListByOrder(id);
        return list;
    }


    /**
     * 添加货运单位
     *
     * @param freight
     */
    @Override
    public int addFreight(Freight freight, HttpSession session) {
        SessionInfo sessions = (SessionInfo) session.getAttribute("sessionInfo");
        Integer userId = sessions.getAdmin().getUserId();
        //查询出所有的默认地址
        List<Freight> list = freightMapper.selectFreightByAccountId(userId);
        if (freight.getFreightDefaultAddress() == 1) {
            for (Freight f : list) {
                if (f.getFreightDefaultAddress() == 1) {
                    f.setFreightDefaultAddress(0);
                    freightMapper.updateFreight(f);
                }
            }
        }
        freight.setAccountId(userId);
        int i = freightMapper.insertFreight(freight);
        return i;
    }

    /**
     * 根据id删除货运单位
     *
     * @param id
     */
    @Override
    public int deleteFreight(Integer id) {
        int flag = freightMapper.deleteFreight(id);
        return flag;
    }

    /**
     * 设置默认货运单位
     */
    @Override
    public int setDefaultAddress(Integer id, HttpSession session, Integer value) {
        SessionInfo sessions = (SessionInfo) session.getAttribute("sessionInfo");
        Integer userId = sessions.getAdmin().getUserId();
        //查询出为默认地址的货运单位
        List<Freight> list = freightMapper.selectFreightByAccountId(userId);
        if (value == 1) {
            for (Freight f : list) {
                if (f.getFreightDefaultAddress() == 1) {
                    f.setFreightDefaultAddress(0);
                    freightMapper.updateFreight(f);
                }
            }
        }
        Freight freight = new Freight();
        freight.setFreightId(id);
        freight.setFreightDefaultAddress(value);
        int i = freightMapper.updateFreight(freight);
        return i;
    }


    /**
     * 根据id查询出当前的货运信息
     *
     * @param id
     * @return
     */
    public Freight queryFreightById(Integer id) {
        Freight freight = freightMapper.selectFreightById(id);
        return freight;
    }


    /**
     * 根据名字查询货运单位
     */
    public Freight queryFreightByName(String name) {
        Freight freight = freightMapper.selectFreightByName(name);
        return freight;
    }
}
