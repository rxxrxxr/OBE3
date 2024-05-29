package com.onezogreen.onezo3.Order;

import lombok.*;

import java.sql.Timestamp;
import java.util.List;

@Getter
@Setter
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderVo {
    private Long orderId;
    private Long storeId;
    private Long memberId;
    private String status;
    private Timestamp orderDate;
    private List<OrderItemVo> orderItems;  // 주문 항목 리스트
}
