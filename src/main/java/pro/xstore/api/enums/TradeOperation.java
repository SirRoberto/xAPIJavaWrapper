package pro.xstore.api.enums;

import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum TradeOperation {

    BUY(0),
    SELL(1),
    BUY_LIMIT(2),
    SELL_LIMIT(3),
    BUY_STOP(4),
    SELL_STOP(5),
    BALANCE(6),
    CREDIT(7);

    @JsonValue
    private final int code;
}
