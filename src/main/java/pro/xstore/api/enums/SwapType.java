package pro.xstore.api.enums;

import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum SwapType {

    SWAP_BY_POINTS(0),
    SWAP_BY_DOLLARS(1),
    SWAP_BY_INTEREST(2),
    SWAP_BY_MARGIN_CURRENCY(3);

    @JsonValue
    private final int code;
}