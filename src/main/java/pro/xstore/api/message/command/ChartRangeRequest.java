package pro.xstore.api.message.command;

import lombok.EqualsAndHashCode;
import lombok.NonNull;
import lombok.Value;
import lombok.experimental.SuperBuilder;
import lombok.extern.jackson.Jacksonized;
import pro.xstore.api.message.records.ChartRangeInfoRecord;

@Value
@SuperBuilder
@Jacksonized
@EqualsAndHashCode(callSuper = true)
public class ChartRangeRequest extends BaseRequest {

    String command = "getChartRangeRequest";
    @NonNull Arguments arguments;

    @Value(staticConstructor = "of")
    public static class Arguments implements CommandArguments {

        @NonNull ChartRangeInfoRecord info;
    }
}
