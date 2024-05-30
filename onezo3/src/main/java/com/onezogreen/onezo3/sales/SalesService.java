package com.onezogreen.onezo3.sales;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SalesService {
    private final SalesMapper salesMapper;

    public List<SaleVo> getSalesByStore(Long storeId) {
        return salesMapper.getSalesByStore(storeId);
    }

    public List<SaleVo> getSalesByMenu(Long storeId, Long menuId) {
        return salesMapper.getSalesByMenu(storeId, menuId);
    }

    public List<SaleVo> getSalesByType(Long storeId, String takeInOut) {
        return salesMapper.getSalesByType(storeId, takeInOut);
    }

}