package com.onezogreen.onezo3.Order;

import lombok.*;

@Getter
@Setter
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderItemVo {
    private Long orderItemId;
    private Long orderId;
    private Long menuId;
    private int quantity;
}
