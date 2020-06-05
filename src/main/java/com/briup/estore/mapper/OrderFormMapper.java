package com.briup.estore.mapper;

import com.briup.estore.bean.OrderForm;
import com.briup.estore.bean.OrderFormExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OrderFormMapper {
    long countByExample(OrderFormExample example);

    int deleteByExample(OrderFormExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(OrderForm record);

    int insertSelective(OrderForm record);

    List<OrderForm> selectByExample(OrderFormExample example);

    OrderForm selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") OrderForm record, @Param("example") OrderFormExample example);

    int updateByExample(@Param("record") OrderForm record, @Param("example") OrderFormExample example);

    int updateByPrimaryKeySelective(OrderForm record);

    int updateByPrimaryKey(OrderForm record);
}