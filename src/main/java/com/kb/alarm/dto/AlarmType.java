package com.kb.alarm.dto;

import lombok.AllArgsConstructor;
import lombok.Generated;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum AlarmType {
    COUPON_BUY("쿠폰 구매") {
        @Override
        public String createMessage(AlarmArgs args) {
            return args.getStdName() + " 학생이 " + args.getProductName() +  "을(를) 구매했습니다.";
        }
    },
    SAVING_ACCOUNT_JOIN("적금 가입") {
        @Override
        public String createMessage(AlarmArgs args) {
            return args.getStdName() + " 학생이 적금 상품 " + args.getProductName() + "에 가입했습니다.";
        }
    },
    SAVING_ACCOUNT_MATURED("적금 만기") {
        @Override
        public String createMessage(AlarmArgs args) {
            return args.getStdName() + " 학생의 적금 상품 " + args.getProductName() + "이(가) 만기되었습니다.";
        }
    };

    private final String alarmText;
    public abstract String createMessage(AlarmArgs args);
}
