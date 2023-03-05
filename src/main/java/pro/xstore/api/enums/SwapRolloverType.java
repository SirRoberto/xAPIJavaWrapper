package pro.xstore.api.enums;

import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum SwapRolloverType {

	MONDAY(0),
	TUESDAY(1),
	WEDNESDAY(2),
	THURSDAY(3),
	FRIDAY(4);

	@JsonValue
    private final int code;
}