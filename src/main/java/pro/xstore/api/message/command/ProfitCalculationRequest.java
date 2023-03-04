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
public class ProfitCalculationRequest extends BaseRequest {

    String command = "getProfitCalculation";
    @NonNull Arguments arguments;

    record Arguments(int cmd,
                     @NonNull String symbol,
                     double volume,
                     double openPrice,
                     double closePrice
    ) implements CommandArguments {
    }
}
