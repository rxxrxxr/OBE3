package com.onezogreen.onezo3.review;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("review")
@RequiredArgsConstructor
public class ReviewController {

    public final ReviewService reviewService;

    @PostMapping("/insert")
    public String addReview(@RequestBody ReviewVo reviewVo){
        reviewService.reviewAdd(reviewVo);

        return "추가성공";
    }
}
