package com.onezogreen.onezo3.order;

public enum OrderStatus {
    BEFORE_COOKING("조리대기중"),
    COOKING("조리중"),
    COMPLETED("조리완료"),
    ACCEPTED("수락됨"),
    REJECTED("거절됨"),
    CANCELLED("취소됨");

    private final String status;

    OrderStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
}