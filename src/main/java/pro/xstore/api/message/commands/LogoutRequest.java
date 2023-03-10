package pro.xstore.api.message.commands;

import lombok.EqualsAndHashCode;
import lombok.Value;
import lombok.experimental.SuperBuilder;
import lombok.extern.jackson.Jacksonized;

@Value
@SuperBuilder
@Jacksonized
@EqualsAndHashCode(callSuper = true)
public class LogoutRequest extends BaseRequest {

    String command = "logout";
    CommandArguments arguments = null;
}
