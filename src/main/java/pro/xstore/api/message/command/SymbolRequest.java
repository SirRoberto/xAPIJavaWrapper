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
public class SymbolRequest extends BaseRequest {

    String command = "getSymbol";
    @NonNull Arguments arguments;

    record Arguments(@NonNull String symbol) implements CommandArguments {
    }
}
