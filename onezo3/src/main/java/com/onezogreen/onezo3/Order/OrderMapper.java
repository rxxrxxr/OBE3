package com.onezogreen.onezo3.Order;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface OrderMapper {
    List<OrderVo> getOrdersByStore(@Param("storeId") Long storeId);
    void acceptOrder(@Param("orderId") Long orderId);
    void rejectOrder(@Param("orderId") Long orderId);
    List<OrderVo> getOrderStatus(@Param("storeId") Long storeId);
    List<OrderItemVo> getOrderItemsByOrderId(@Param("orderId") Long orderId);  // 주문 항목 조회
}
