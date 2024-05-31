package com.onezogreen.onezo3.sales;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SalesService {
    private final SalesMapper saleMapper;

    public List<SaleVo> getSalesByStore(Long storeId) {
        return saleMapper.getSalesByStore(storeId);
    }

    public List<SaleVo> getSalesByMenu(Long storeId, Long menuId) {
        return saleMapper.getSalesByMenu(storeId, menuId);
    }

    public List<SaleVo> getSalesByType(Long storeId, TakeInOut takeInOut) {
        return saleMapper.getSalesByType(storeId, takeInOut);
    }
}
