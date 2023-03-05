package pro.xstore.api.enums;

import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * Possible values of level field:<br>
 * -1 - all available levels<br>
 *  0 - base level bid and ask price for instrument<br>
 * >0 - specified level
 */
@Getter
@RequiredArgsConstructor
public enum Level {

    ALL(-1),
    BASE(0),
    ONE(1),
    TWO(2),
    THREE(4),
    FOUR(5);

    @JsonValue
    private final int code;
}
