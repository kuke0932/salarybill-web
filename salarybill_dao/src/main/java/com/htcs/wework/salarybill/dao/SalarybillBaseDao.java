package com.htcs.wework.salarybill.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface SalarybillBaseDao<K,V> {
	int countByExample(V example);

    int deleteByExample(V example);

    int deleteByPrimaryKey(Integer id);

    int insert(K record);

    int insertSelective(K record);

    List<K> selectByExample(V example);

    K selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") K record, @Param("example") V example);

    int updateByExample(@Param("record") K record, @Param("example") V example);

    int updateByPrimaryKeySelective(K record);

    int updateByPrimaryKey(K record);
}
