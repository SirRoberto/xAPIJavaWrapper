package pro.xstore.api.enums;

import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum RequestStatus {

    ERROR(0),
    PENDING(1),
    ACCEPTED(3),
    REJECTED(4);

    @JsonValue
    private final int code;
}