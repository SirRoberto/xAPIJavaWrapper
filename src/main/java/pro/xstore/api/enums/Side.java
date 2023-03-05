package pro.xstore.api.enums;

import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Side {

    BUY(0),
    SELL(1);

    @JsonValue
    private final int code;
}
