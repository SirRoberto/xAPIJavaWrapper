package pro.xstore.api.message.commands;

import lombok.EqualsAndHashCode;
import lombok.NonNull;
import lombok.Value;
import lombok.experimental.SuperBuilder;
import lombok.extern.jackson.Jacksonized;
import pro.xstore.api.enums.TradeOperation;

@Value
@SuperBuilder
@Jacksonized
@EqualsAndHashCode(callSuper = true)
public class ProfitCalculationRequest extends BaseRequest {

    String command = "getProfitCalculation";
    @NonNull Arguments arguments;

    record Arguments(TradeOperation cmd,
                     @NonNull String symbol,
                     double volume,
                     double openPrice,
                     double closePrice
    ) implements CommandArguments {
    }
}
