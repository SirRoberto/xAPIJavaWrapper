package pro.xstore.api.message.command;

import lombok.EqualsAndHashCode;
import lombok.NonNull;
import lombok.Value;
import lombok.experimental.SuperBuilder;
import lombok.extern.jackson.Jacksonized;
import pro.xstore.api.message.records.TradeTransInfoRecord;

@Value
@SuperBuilder
@Jacksonized
@EqualsAndHashCode(callSuper = true)
public class TradeTransactionRequest extends BaseRequest {

    String command = "tradeTransaction";
    @NonNull Arguments arguments;

    record Arguments(@NonNull TradeTransInfoRecord tradeTransInf) implements CommandArguments {
    }
}
