package pro.xstore.api.message.commands;

import lombok.EqualsAndHashCode;
import lombok.NonNull;
import lombok.Value;
import lombok.experimental.SuperBuilder;
import lombok.extern.jackson.Jacksonized;
import pro.xstore.api.message.records.ChartLastInfoRecord;

@Value
@SuperBuilder
@Jacksonized
@EqualsAndHashCode(callSuper = true)
public class ChartLastRequest extends BaseRequest {

    String command = "getChartLastRequest";
    @NonNull Arguments arguments;

    @Value(staticConstructor = "of")
    static class Arguments implements CommandArguments {

        @NonNull ChartLastInfoRecord info;
    }
}
