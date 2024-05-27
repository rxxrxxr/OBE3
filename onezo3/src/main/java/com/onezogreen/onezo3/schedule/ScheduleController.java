package com.onezogreen.onezo3.schedule;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("schedule")
@RequiredArgsConstructor
public class ScheduleController {

    public final ScheduleService scheduleService;

    
}
