package pro.xstore.api.enums;

import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Impact {

    LOW("1"),
    MEDIUM("2"),
    HIGH("3");

    @JsonValue
    private final String code;
}
