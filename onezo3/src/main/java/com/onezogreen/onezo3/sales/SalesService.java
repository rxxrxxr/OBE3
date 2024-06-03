package com.onezogreen.onezo3.sales;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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

    public List<SaleVo> getSalesByType(Long storeId, TakeInOut takeInOut) {
        return salesMapper.getSalesByType(storeId, takeInOut);
    }

    public Map<String, List<SaleVo>> getMonthlySales(Long storeId, String month) {
        List<SaleVo> sales = salesMapper.getSalesByMonth(storeId, month);
        return sales.stream().collect(Collectors.groupingBy(SaleVo::getSaleDateFormatted));
    }
}