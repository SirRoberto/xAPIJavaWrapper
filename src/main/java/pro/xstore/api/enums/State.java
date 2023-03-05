package pro.xstore.api.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum State {

    MODIFIED("Modified"),
    DELETED("Deleted");

    private final String value;
}
