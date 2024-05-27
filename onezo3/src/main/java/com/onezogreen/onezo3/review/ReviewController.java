package com.onezogreen.onezo3.review;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("review")
@RequiredArgsConstructor
public class ReviewController {

    public final ReviewService reviewService;

    @PutMapping("/reply/update/{review_id}")
    public String addReply(@PathVariable Long review_id, @RequestBody ReviewVo reviewVo){
        reviewService.AddReply(review_id, reviewVo);

        return "댓글 달기(수정)성공";
    }

    @PutMapping("/reply/delete/{review_id}")
    public String deleteReply(@PathVariable Long review_id, ReviewVo reviewVo){
        reviewService.DeleteReply(review_id, reviewVo);

        return "댓글 삭제 성공";
    }

    @PutMapping("/delete/{review_id}")
    public String deleteReview(@PathVariable Long review_id, ReviewVo reviewVo){
        reviewService.DeleteReview(review_id, reviewVo);

        return "댓글 삭제 성공";
    }

}
