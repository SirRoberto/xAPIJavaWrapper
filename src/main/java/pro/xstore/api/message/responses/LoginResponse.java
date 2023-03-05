package pro.xstore.api.message.responses;

import lombok.EqualsAndHashCode;
import lombok.Value;
import lombok.experimental.SuperBuilder;
import lombok.extern.jackson.Jacksonized;

@Value
@SuperBuilder
@Jacksonized
@EqualsAndHashCode(callSuper = true)
public class LoginResponse extends BaseResponse<Object> {

    String streamSessionId;
}
