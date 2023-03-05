package pro.xstore.api.enums;

import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum TradeTransaction {

    OPEN(0),
    CLOSE(2),
    MODIFY(3),
    DELETE(4);

    @JsonValue
    private final int code;
}