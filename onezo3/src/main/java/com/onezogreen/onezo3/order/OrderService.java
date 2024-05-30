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

    public void acceptOrder(Long storeId, Long orderId) {
        orderMapper.acceptOrder(orderId);
    }

    public void rejectOrder(Long storeId, Long orderId) {
        orderMapper.rejectOrder(orderId);
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
