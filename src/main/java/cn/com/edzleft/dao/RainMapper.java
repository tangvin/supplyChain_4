package cn.com.edzleft.dao;

import cn.com.edzleft.entity.Rain;

public interface RainMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Rain record);

    int insertSelective(Rain record);

    Rain selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Rain record);

    int updateByPrimaryKey(Rain record);
}