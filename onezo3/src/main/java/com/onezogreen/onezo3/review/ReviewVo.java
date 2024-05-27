package com.onezogreen.onezo3.review;

import lombok.*;

@Getter
@Setter
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
    private replyDelete_yn replyDelete_yn;

}
