package pro.xstore.api.message.commands;

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
public class TradingHoursRequest extends BaseRequest {

    String command = "getTradingHours";
    @NonNull Arguments arguments;

    record Arguments(@NonNull List<String> symbols) implements CommandArguments {
    }
}
