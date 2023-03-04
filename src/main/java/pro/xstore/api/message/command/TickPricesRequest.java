package pro.xstore.api.message.command;

import lombok.EqualsAndHashCode;
import lombok.NonNull;
import lombok.Value;
import lombok.experimental.SuperBuilder;
import lombok.extern.jackson.Jacksonized;

import java.sql.Timestamp;
import java.util.List;

@Value
@SuperBuilder
@Jacksonized
@EqualsAndHashCode(callSuper = true)
public class TickPricesRequest extends BaseRequest {

    String command = "getTickPrices";
    @NonNull Arguments arguments;

    record Arguments(int level,
                     @NonNull List<String> symbols,
                     @NonNull Timestamp timestamp
    ) implements CommandArguments {
    }
}