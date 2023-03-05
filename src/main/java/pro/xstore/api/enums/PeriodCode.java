package pro.xstore.api.enums;

import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum PeriodCode {

    PERIOD_M1(1),
    PERIOD_M5(5),
    PERIOD_M15(15),
    PERIOD_M30(30),
    PERIOD_H1(60),
    PERIOD_H4(240),
    PERIOD_D1(1440),
    PERIOD_W1(10080),
    PERIOD_MN1(43200);

    @JsonValue
    private final int code;
}