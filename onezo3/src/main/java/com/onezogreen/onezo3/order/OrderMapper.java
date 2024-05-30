package com.onezogreen.onezo3.order;

import org.apache.ibatis.annotations.Mapper;
import java.util.List;

@Mapper
public interface OrderMapper {
    List<OrderVo> getOrdersByStore(Long storeId);
    int updateOrderStatus(Long storeId, Long orderId, String status);
    List<OrderVo> getOrderStatus(Long storeId);
    List<OrderItemVo> getOrderItemsByOrderId(Long orderId);  // 주문 항목 조회
}
