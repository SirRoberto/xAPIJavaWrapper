package pro.xstore.api.enums;

import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum MarginMode {

    FOREX(101),
    CFD_LEVERAGED(102),
    CFD(103);

    @JsonValue
    private final int code;
}
