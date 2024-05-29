package com.onezogreen.onezo3.user;

import lombok.*;

@Getter
@Setter
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserVo {
    private String email;
    private String password;
    private Long manager_id;
    private Long store_id;
}
