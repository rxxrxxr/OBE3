package com.onezogreen.onezo3.schedule;

import com.onezogreen.onezo3.menu.sold_out_yn;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ScheduleVo {
    private Long schedule_id;
    private Long store_id;
    private LocalDate start_date;
    private LocalDate end_date;
    private String content;
    private delete_yn delete_yn;
}
