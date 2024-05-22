package com.onezogreen.onezo3.review;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ReviewService {

    public final ReviewMapper reviewMapper;

    public void reviewAdd(ReviewVo reviewVo) {
    }
}
