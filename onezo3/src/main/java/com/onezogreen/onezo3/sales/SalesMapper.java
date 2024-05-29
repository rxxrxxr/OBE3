package com.onezogreen.onezo3.sales;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SalesMapper {
    List<SaleVo> getSalesByStore(Long storeId);
    List<SaleVo> getSalesByMenu(Long storeId, Long menuId);
    List<SaleVo> getSalesByType(Long storeId, String takeInOut); // 매출 유형별 조회
}
