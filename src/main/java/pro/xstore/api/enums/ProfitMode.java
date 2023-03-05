package pro.xstore.api.enums;

import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ProfitMode {

    FOREX(5),
    CFD(6);

    @JsonValue
    private final int code;
}
