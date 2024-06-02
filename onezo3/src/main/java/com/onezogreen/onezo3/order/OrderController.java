//package com.onezogreen.onezo3.order;
//
//import com.onezogreen.onezo3.exception.BizException;
//import com.onezogreen.onezo3.exception.ErrorCode;
//import com.onezogreen.onezo3.manager.ManagerVo;
//import io.swagger.v3.oas.annotations.Operation;
//import lombok.RequiredArgsConstructor;
//import org.springframework.security.core.Authentication;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/orders")
//@RequiredArgsConstructor
//public class OrderController {
//
//    private final OrderService orderService;
//
//    @GetMapping("/store")
//    @Operation(summary = "매장의 모든 주문 조회", description = "로그인한 사용자의 매장의 모든 주문을 조회합니다.")
//    public List<OrderVo> getOrdersByStore(Authentication authentication) {
//        ManagerVo managerVo = (ManagerVo) authentication.getPrincipal();
//        Long storeId = managerVo.getStore_id();
//        List<OrderVo> orderList = orderService.getOrdersByStore(storeId);
//        if (orderList == null || orderList.isEmpty()) {
//            throw new BizException(ErrorCode.NOTSELECT);
//        }
//        return orderList;
//    }
//
//    @PutMapping("/accept/{orderId}")
//    @Operation(summary = "주문 수락", description = "order_id를 받아서 해당 주문을 수락합니다.")
//    public boolean acceptOrder(@PathVariable Long orderId, Authentication authentication) {
//        ManagerVo managerVo = (ManagerVo) authentication.getPrincipal();
//        Long storeId = managerVo.getStore_id();
//        boolean check = orderService.acceptOrder(storeId, orderId);
//        if (!check) {
//            throw new BizException(ErrorCode.UPDATEFAIL);
//        }
//        return check;
//    }
//
//    @PutMapping("/reject/{orderId}")
//    @Operation(summary = "주문 거절", description = "order_id를 받아서 해당 주문을 거절합니다.")
//    public boolean rejectOrder(@PathVariable Long orderId, Authentication authentication) {
//        ManagerVo managerVo = (ManagerVo) authentication.getPrincipal();
//        Long storeId = managerVo.getStore_id();
//        boolean check = orderService.rejectOrder(storeId, orderId);
//        if (!check) {
//            throw new BizException(ErrorCode.UPDATEFAIL);
//        }
//        return check;
//    }
//
//    @GetMapping("/status")
//    @Operation(summary = "매장의 모든 주문 상태 조회", description = "로그인한 사용자의 매장의 모든 주문 상태를 조회합니다.")
//    public List<OrderVo> getOrderStatus(Authentication authentication) {
//        ManagerVo managerVo = (ManagerVo) authentication.getPrincipal();
//        Long storeId = managerVo.getStore_id();
//        List<OrderVo> orderStatusList = orderService.getOrderStatus(storeId);
//        if (orderStatusList == null || orderStatusList.isEmpty()) {
//            throw new BizException(ErrorCode.NOTSELECT);
//        }
//        return orderStatusList;
//    }
//}
