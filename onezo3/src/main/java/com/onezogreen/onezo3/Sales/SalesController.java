package com.onezogreen.onezo3.Sales;

import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sales")
@RequiredArgsConstructor
public class SalesController {
    private final SalesService salesService;

    @Operation(summary = "매장의 매출 조회",
            description = "store_id를 받아서 해당 매장의 전체 매출을 조회" )
    @GetMapping("/store/{storeId}")
    public List<SaleVo> getSalesByStore(@PathVariable Long storeId) {
        return salesService.getSalesByStore(storeId);
    }

    @Operation(summary = "매장의 메뉴별 매출 조회",
            description = "store_id와 menu_id를 받아서 해당 매장의 특정 메뉴의 매출을 조회" )
    @GetMapping("/store/{storeId}/menu/{menuId}")
    public List<SaleVo> getSalesByMenu(@PathVariable Long storeId, @PathVariable Long menuId) {
        return salesService.getSalesByMenu(storeId, menuId);
    }
}
