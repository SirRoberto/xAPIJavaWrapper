package pro.xstore.api.message.command;

import lombok.EqualsAndHashCode;
import lombok.NonNull;
import lombok.Value;
import lombok.experimental.SuperBuilder;
import lombok.extern.jackson.Jacksonized;

@Value
@SuperBuilder
@Jacksonized
@EqualsAndHashCode(callSuper = true)
public class LoginRequest extends BaseRequest {

    String command = "login";
    @NonNull Arguments arguments;

    record Arguments(@NonNull String userId, @NonNull String password, String appName) implements CommandArguments {
    }
}