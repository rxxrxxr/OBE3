package com.onezogreen.onezo3.order;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderMapper orderMapper;

    public List<OrderVo> getOrdersByStore(Long storeId) {
        List<OrderVo> orders = orderMapper.getOrdersByStore(storeId);
        for (OrderVo order : orders) {
            List<OrderItemVo> orderItems = orderMapper.getOrderItemsByOrderId(order.getOrderId());
            order.setOrderItems(orderItems);
        }
        return orders;
    }

    public boolean acceptOrder(Long storeId, Long orderId) {
        // 주문 상태를 "수락됨"으로 업데이트
        int updatedRows = orderMapper.updateOrderStatus(storeId, orderId, OrderStatus.ACCEPTED.getStatus());
        return updatedRows > 0;
    }

    public boolean rejectOrder(Long storeId, Long orderId) {
        // 주문 상태를 "거절됨"으로 업데이트
        int updatedRows = orderMapper.updateOrderStatus(storeId, orderId, OrderStatus.REJECTED.getStatus());
        return updatedRows > 0;
    }


    public List<OrderVo> getOrderStatus(Long storeId) {
        List<OrderVo> orders = orderMapper.getOrderStatus(storeId);
        for (OrderVo order : orders) {
            List<OrderItemVo> orderItems = orderMapper.getOrderItemsByOrderId(order.getOrderId());
            order.setOrderItems(orderItems);
        }
        return orders;
    }
}
