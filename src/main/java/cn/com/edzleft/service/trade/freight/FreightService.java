package cn.com.edzleft.service.trade.freight;

import cn.com.edzleft.entity.Freight;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by ibmtech on 2017/11/22.
 */
public interface FreightService {

    /**
     * 根据用户id查询出所有的货运单位
     * @return
     */
    public List<Freight> queryFreightByAccountId(Integer id);
    /**
     * 查询所有的货运单位
     */
    public List<Freight> queryFreightByOrder(Integer id);

    /**
     * 添加货运单位
     */
    public int addFreight(Freight freight, HttpSession session);

    /**
     * 根据货运id 删除货运单位
     */
    public int deleteFreight(Integer id);

    /**
     * 设置货运单位为默认单位
     */
    public int setDefaultAddress(Integer id,HttpSession session,Integer value);

    /**
     * 根据id查询货运单位信息
     */
    public Freight queryFreightById(Integer id);

    /**
     * 根据货运单位名称查
     */
    public Freight queryFreightByName(String name);
}
