package pro.xstore.api.streaming.commands;

import lombok.Builder;
import lombok.NonNull;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;

@Value
@Builder
@Jacksonized
public class StreamingCommand {

    @NonNull String command;
    String streamSessionId;
    String symbol;
    Integer minArrivalTime;
    Integer maxLevel;
}
