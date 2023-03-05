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
public class CommissionDefRequest extends BaseRequest {

    String command = "getCommissionDef";
    @NonNull Arguments arguments;

    record Arguments(@NonNull String symbol, double volume) implements CommandArguments {
    }
}