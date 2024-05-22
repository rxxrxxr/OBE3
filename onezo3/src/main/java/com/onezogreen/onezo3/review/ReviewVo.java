package com.onezogreen.onezo3.review;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ReviewVo {

    private Long review_id;
    private Long member_id;
    private Long store_id;
    private int star;
    private String review;
    private String reply;
    private reviewDelete_yn reviewDelete_yn;
    private replyDelete_yn replyDeleteYn;

}
