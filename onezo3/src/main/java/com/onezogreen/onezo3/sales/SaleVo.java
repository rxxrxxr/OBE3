package com.onezogreen.onezo3.sales;

import lombok.*;

import java.sql.Timestamp;

@Getter
@Setter
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SaleVo {
    private Long saleId;
    private Long storeId;
    private Long menuId;
    private Double amount;
    private String takeInOut;
    private Timestamp saleDate;
}
