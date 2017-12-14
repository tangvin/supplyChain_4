package cn.com.edzleft.dao.trade.freight;

import cn.com.edzleft.entity.Freight;

import java.util.List;

/**
 * Created by ibmtech on 2017/11/22.
 */
public interface FreightMapper {

    /**
     * 根据用户id查询出对应的货运管理
     */
    public List<Freight> selectFreightByAccountId(Integer id);

    /**
     * 查询所有的货运单位
     */
    public List<Freight> selectAllFreight();

    /**
     * 添加货运单位
     */
    public int insertFreight(Freight freight);

    /**
     * 根据货运单位id 删除货运单位
     */
    public int deleteFreight(Integer id);

    /**
     * 设置为默认货运单位
     */
    public int updateFreight(Freight freight);

    /**
     * 查询出默认地址的货运单位
     */
    public List<Freight> selectFreightByAddress();

    /**
     * 根据货运id查看货运信息
     */
    public Freight selectFreightById(Integer id);


    /**
     * 根据货运id查询订单中对应的货运地址
     */
    public List<Freight> selectFreightListByOrder(Integer id);

    /**
     * 根据货运单位名称查询货运信息
     */
    public Freight selectFreightByName(String freightName);
}
