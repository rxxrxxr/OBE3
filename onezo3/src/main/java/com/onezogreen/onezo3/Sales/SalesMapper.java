package com.onezogreen.onezo3.Sales;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface SalesMapper {
    List<SaleVo> getSalesByStore(@Param("storeId") Long storeId);
    List<SaleVo> getSalesByMenu(@Param("storeId") Long storeId, @Param("menuId") Long menuId);
}
