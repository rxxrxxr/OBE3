package com.onezogreen.onezo3.order;

import org.apache.ibatis.annotations.Mapper;
import java.util.List;

@Mapper
public interface OrderMapper {
    List<OrderVo> getOrdersByStore(Long storeId);
    List<OrderVo> getOrdersByStatus(Long storeId, OrderStatus status);
    int updateOrderStatus(Long storeId, Long orderId, OrderStatus status);
    List<OrderItemVo> getOrderItemsByOrderId(Long orderId);
}