package com.onezogreen.onezo3.schedule;

import com.onezogreen.onezo3.exception.BizException;
import com.onezogreen.onezo3.exception.ErrorCode;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("schedule")
@RequiredArgsConstructor
public class ScheduleController {

    public final ScheduleService scheduleService;

    @GetMapping("select/{store_id}")
    @Operation(summary = "일정을 조회합니다")
    public List<ScheduleVo> selectSchedule(@PathVariable Long store_id){
        List<ScheduleVo>schedulList = scheduleService.scheduleSelect(store_id);
        if(schedulList == null || schedulList.isEmpty()){
            throw new BizException(ErrorCode.NOTSELECT);
        }
        return schedulList;
    }

    @PostMapping("insert/{store_id}")
    @Operation(summary = "일정을 추가합니다", description = "날짜 포맷은 yyyy-mm-dd로 맞춰주세요")
    public boolean insertSchedule(@PathVariable Long store_id, @RequestBody ScheduleVo scheduleVo){
        boolean check = scheduleService.scheduleInsert(store_id, scheduleVo);
        return check;
    }

    @PutMapping("update/{schedule_id}")
    @Operation(summary = "일정을 수정합니다", description = "날짜 포맷은 yyyy-mm-dd로 맞춰주세요")
    public boolean updateSchedule(@PathVariable Long schedule_id, @RequestBody ScheduleVo scheduleVo){
        boolean check = scheduleService.scheduleUpdate(schedule_id, scheduleVo);
        return check;
    }

    @DeleteMapping("delete/{schedule_id}")
    @Operation(summary = "일정을 삭제합니다", description = "삭제여부 N -> Y")
    public boolean deleteSchedule(@PathVariable Long schedule_id){
        boolean check = scheduleService.scheduleDelete(schedule_id);
        return check;
    }

}
