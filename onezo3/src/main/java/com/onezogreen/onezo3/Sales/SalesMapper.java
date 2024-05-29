package com.onezogreen.onezo3.Sales;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface SalesMapper {
    List<SaleVo> getSalesByStore(Long storeId);
    List<SaleVo> getSalesByMenu(Long storeId,Long menuId);
}
