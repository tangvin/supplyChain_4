package cn.com.edzleft.dao.procurement.freight;

import cn.com.edzleft.entity.Freight;

public interface PmFreightMapper {
    int deleteByPrimaryKey(Integer freightId);

    int insert(Freight fr);

    int insertSelective(Freight record);

    Freight selectByPrimaryKey(Integer freightId);

    int updateByPrimaryKeySelective(Freight record);

    int updateByPrimaryKey(Freight record);

	Freight queryFreightById(Integer logisticsUnitId);
}