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
public class TradeTransactionStatusRequest extends BaseRequest {

    String command = "tradeTransactionStatus";
    @NonNull Arguments arguments;

    record Arguments(int order) implements CommandArguments {
    }
}
