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

    @Operation(summary = "특정 매장의 모든 주문 조회",
            description = "storeId를 URL 경로로 받아서 해당 매장의 모든 주문을 조회")
    @GetMapping("/store/{storeId}")
    public List<OrderVo> getOrdersByStore(@PathVariable Long storeId, Authentication authentication) {
        ManagerVo managerVo = (ManagerVo) authentication.getPrincipal();
        return orderService.getOrdersByStore(storeId);
    }

    @Operation(summary = "주문 수락",
            description = "storeId와 orderId를 URL 경로로 받아서 해당 매장의 특정 주문을 수락")
    @PutMapping("/accept/{storeId}/{orderId}")
    public void acceptOrder(@PathVariable Long storeId, @PathVariable Long orderId, Authentication authentication) {
        ManagerVo managerVo = (ManagerVo) authentication.getPrincipal();
        orderService.acceptOrder(storeId, orderId);
    }

    @Operation(summary = "주문 거절",
            description = "storeId와 orderId를 URL 경로로 받아서 해당 매장의 특정 주문을 거절")
    @PutMapping("/reject/{storeId}/{orderId}")
    public void rejectOrder(@PathVariable Long storeId, @PathVariable Long orderId, Authentication authentication) {
        ManagerVo managerVo = (ManagerVo) authentication.getPrincipal();
        orderService.rejectOrder(storeId, orderId);
    }

    @Operation(summary = "특정 매장의 모든 주문 상태 조회",
            description = "storeId를 URL 경로로 받아서 해당 매장의 모든 주문 상태를 조회")
    @GetMapping("/status/{storeId}")
    public List<OrderVo> getOrderStatus(@PathVariable Long storeId, Authentication authentication) {
        ManagerVo managerVo = (ManagerVo) authentication.getPrincipal();
        return orderService.getOrderStatus(storeId);
    }
}
