package com.onezogreen.onezo3.review;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.List;

@RestController
@RequestMapping("review")
@RequiredArgsConstructor
public class ReviewController {

    public final ReviewService reviewService;

    @GetMapping("/select/{store_id}")
//    @Schema(hidden = true)
    public ResponseEntity<List<ReviewVo>> getReviewReply(@PathVariable Long store_id) {
        List<ReviewVo> reviewReply = reviewService.getReviewReply(store_id);
        return ResponseEntity.ok(reviewReply);

    }

    // 댓글 달기 & 수정
    @PutMapping("/reply/update/{review_id}")
    public String addReply(@PathVariable Long review_id, @RequestBody ReviewVo reviewVo) {
        reviewService.AddReply(review_id, reviewVo);

        return "댓글 달기(수정)성공";
    }

    // 댓글 삭제
    @PutMapping("/reply/delete/{review_id}")
    public String deleteReply(@PathVariable Long review_id, ReviewVo reviewVo) {
        reviewService.DeleteReply(review_id, reviewVo);

        return "댓글 삭제 성공";
    }

    // 리뷰삭제
    @PutMapping("/delete/{review_id}")
    public String deleteReview(@PathVariable Long review_id, ReviewVo reviewVo) {
        reviewService.DeleteReview(review_id, reviewVo);

        return "리뷰 삭제 성공";
    }

}
