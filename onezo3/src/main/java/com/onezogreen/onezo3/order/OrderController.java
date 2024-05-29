package com.onezogreen.onezo3.order;

import com.onezogreen.onezo3.manager.ManagerVo;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
@RequiredArgsConstructor
public class OrderController {
    private final OrderService orderService;

    @Operation(summary = "매장의 모든 주문 조회",
            description = "로그인한 사용자의 매장의 모든 주문을 조회")
    @GetMapping("/store")
    public List<OrderVo> getOrdersByStore(Authentication authentication) {
        ManagerVo managerVo = (ManagerVo) authentication.getPrincipal();
        Long storeId = managerVo.getStore_id();
        return orderService.getOrdersByStore(storeId);
    }

    @Operation(summary = "주문 수락",
            description = "order_id를 param값으로 받아서 해당 주문을 수락")
    @PutMapping("/accept/{orderId}")
    public void acceptOrder(@PathVariable Long orderId) {
        orderService.acceptOrder(orderId);
    }

    @Operation(summary = "주문 거절",
            description = "order_id를 param값으로 받아서 해당 주문을 거절")
    @PutMapping("/reject/{orderId}")
    public void rejectOrder(@PathVariable Long orderId) {
        orderService.rejectOrder(orderId);
    }

    @Operation(summary = "매장의 모든 주문 상태 조회",
            description = "로그인한 사용자의 매장의 모든 주문 상태를 조회")
    @GetMapping("/status")
    public List<OrderVo> getOrderStatus(Authentication authentication) {
        ManagerVo managerVo = (ManagerVo) authentication.getPrincipal();
        Long storeId = managerVo.getStore_id();
        return orderService.getOrderStatus(storeId);
    }
}