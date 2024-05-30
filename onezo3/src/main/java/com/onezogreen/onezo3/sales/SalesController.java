package com.onezogreen.onezo3.sales;

import com.onezogreen.onezo3.manager.ManagerVo;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sales")
@RequiredArgsConstructor
public class SalesController {
    private final SalesService salesService;


    @Operation(summary = "매장의 매출 조회",
            description = "로그인한 사용자의 매장의 전체 매출을 조회")
    @GetMapping("/store")
    public List<SaleVo> getSalesByStore(Authentication authentication) {
        ManagerVo managerVo = (ManagerVo) authentication.getPrincipal();
        Long storeId = managerVo.getStore_id();
        return salesService.getSalesByStore(storeId);
    }

    @Operation(summary = "매장의 메뉴별 매출 조회",
            description = "로그인한 사용자의 매장의 특정 메뉴의 매출을 조회")
    @GetMapping("/store/menu/{menuId}")
    public List<SaleVo> getSalesByMenu(Authentication authentication, @PathVariable Long menuId) {
        ManagerVo managerVo = (ManagerVo) authentication.getPrincipal();
        Long storeId = managerVo.getStore_id();
        return salesService.getSalesByMenu(storeId, menuId);
    }

    @Operation(summary = "매장의 주문 유형별 매출 조회",
            description = "로그인한 사용자의 매장의 특정 주문 유형의 매출을 조회")
    @GetMapping("/store/type/{takeInOut}")
    public List<SaleVo> getSalesByType(Authentication authentication, @PathVariable String takeInOut) {
        ManagerVo managerVo = (ManagerVo) authentication.getPrincipal();
        Long storeId = managerVo.getStore_id();
        return salesService.getSalesByType(storeId, takeInOut);
    }
}