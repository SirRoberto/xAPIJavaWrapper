package pro.xstore.api.message.command;

import lombok.EqualsAndHashCode;
import lombok.NonNull;
import lombok.Value;
import lombok.experimental.SuperBuilder;
import lombok.extern.jackson.Jacksonized;

import java.util.List;

@Value
@SuperBuilder
@Jacksonized
@EqualsAndHashCode(callSuper = true)
public class TradeRecordsRequest extends BaseRequest {

    String command = "getTradeRecords";
    @NonNull Arguments arguments;

    record Arguments(@NonNull List<Integer> orders) implements CommandArguments {
    }
}
