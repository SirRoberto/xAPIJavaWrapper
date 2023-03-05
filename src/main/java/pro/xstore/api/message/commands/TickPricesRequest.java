package pro.xstore.api.message.commands;

import lombok.EqualsAndHashCode;
import lombok.NonNull;
import lombok.Value;
import lombok.experimental.SuperBuilder;
import lombok.extern.jackson.Jacksonized;
import pro.xstore.api.enums.Level;

import java.sql.Timestamp;
import java.util.List;

@Value
@SuperBuilder
@Jacksonized
@EqualsAndHashCode(callSuper = true)
public class TickPricesRequest extends BaseRequest {

    String command = "getTickPrices";
    @NonNull Arguments arguments;

    record Arguments(Level level,
                     @NonNull List<String> symbols,
                     @NonNull Timestamp timestamp
    ) implements CommandArguments {
    }
}