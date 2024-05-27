package com.onezogreen.onezo3.review;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ReviewMapper {
    void updateReply(ReviewVo reviewVo);

    void deleteReply(ReviewVo reviewVo);

    void deleteReview(ReviewVo reviewVo);

}
