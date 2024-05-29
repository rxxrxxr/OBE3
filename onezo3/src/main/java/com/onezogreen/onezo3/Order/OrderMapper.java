package com.onezogreen.onezo3.Order;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface OrderMapper {
    List<OrderVo> getOrdersByStore(Long storeId);
    void acceptOrder(Long orderId);
    void rejectOrder(Long orderId);
    List<OrderVo> getOrderStatus(Long storeId);
    List<OrderItemVo> getOrderItemsByOrderId(Long orderId);  // 주문 항목 조회
}
