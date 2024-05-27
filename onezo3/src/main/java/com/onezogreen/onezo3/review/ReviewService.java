package com.onezogreen.onezo3.review;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ReviewService {

    public final ReviewMapper reviewMapper;

    public void AddReply(Long review_Id, ReviewVo reviewVo) {
        reviewVo.setReview_id(review_Id);
        reviewMapper.updateReply(reviewVo);
    }
    public void DeleteReply(Long review_id, ReviewVo reviewVo){
        reviewVo.setReview_id(review_id);
        reviewMapper.deleteReply(reviewVo);
    }
    public void DeleteReview(Long review_id, ReviewVo reviewVo){
        reviewVo.setReview_id(review_id);
        reviewMapper.deleteReview(reviewVo);
    }

}
