package pro.xstore.api.enums;

import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum QuoteId {

    FIXED(1),
    FLOAT(2),
    DEPTH(3),
    CROSS(4);

    @JsonValue
    private final int code;
}
