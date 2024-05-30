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

    @Operation(summary = "특정 매장의 매출 조회",
            description = "storeId를 URL 경로로 받아서 해당 매장의 전체 매출을 조회")
    @GetMapping("/store/{storeId}")
    public List<SaleVo> getSalesByStore(@PathVariable Long storeId, Authentication authentication) {
        ManagerVo managerVo = (ManagerVo) authentication.getPrincipal();
        return salesService.getSalesByStore(storeId);
    }

    @Operation(summary = "특정 매장의 메뉴별 매출 조회",
            description = "storeId와 menuId를 URL 경로로 받아서 해당 매장의 특정 메뉴의 매출을 조회")
    @GetMapping("/store/{storeId}/menu/{menuId}")
    public List<SaleVo> getSalesByMenu(@PathVariable Long storeId, @PathVariable Long menuId, Authentication authentication) {
        ManagerVo managerVo = (ManagerVo) authentication.getPrincipal();
        return salesService.getSalesByMenu(storeId, menuId);
    }

    @Operation(summary = "특정 매장의 주문 유형별 매출 조회",
            description = "storeId와 takeInOut을 URL 경로로 받아서 해당 매장의 특정 주문 유형의 매출을 조회")
    @GetMapping("/store/{storeId}/type/{takeInOut}")
    public List<SaleVo> getSalesByType(@PathVariable Long storeId, @PathVariable String takeInOut, Authentication authentication) {
        ManagerVo managerVo = (ManagerVo) authentication.getPrincipal();
        return salesService.getSalesByType(storeId, takeInOut);
    }
}
