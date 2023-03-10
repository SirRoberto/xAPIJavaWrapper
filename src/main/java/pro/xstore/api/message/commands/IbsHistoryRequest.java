package pro.xstore.api.message.commands;

import lombok.EqualsAndHashCode;
import lombok.NonNull;
import lombok.Value;
import lombok.experimental.SuperBuilder;
import lombok.extern.jackson.Jacksonized;

import java.sql.Timestamp;

@Value
@SuperBuilder
@Jacksonized
@EqualsAndHashCode(callSuper = true)
public class IbsHistoryRequest extends BaseRequest {

    String command = "getIbsHistory";
    @NonNull Arguments arguments;

    record Arguments(@NonNull Timestamp start, @NonNull Timestamp end) implements CommandArguments {
    }
}