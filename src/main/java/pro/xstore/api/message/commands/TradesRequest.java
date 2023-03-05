package pro.xstore.api.message.commands;

import lombok.EqualsAndHashCode;
import lombok.NonNull;
import lombok.Value;
import lombok.experimental.SuperBuilder;
import lombok.extern.jackson.Jacksonized;

@Value
@SuperBuilder
@Jacksonized
@EqualsAndHashCode(callSuper = true)
public class TradesRequest extends BaseRequest {

    String command = "getTrades";
    @NonNull Arguments arguments;

    record Arguments(boolean openedOnly) implements CommandArguments {
    }
}
