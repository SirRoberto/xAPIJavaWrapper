package pro.xstore.api.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum StreamingTradeType {

    OPEN(0),
    PENDING(1),
    CLOSE(2),
    MODIFY(3),
    DELETE(4);

    private final int code;
}