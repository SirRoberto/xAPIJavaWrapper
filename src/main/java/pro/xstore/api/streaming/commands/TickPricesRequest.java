package pro.xstore.api.streaming.commands;

import lombok.Builder;
import lombok.NonNull;
import lombok.extern.jackson.Jacksonized;

@Builder
@Jacksonized
public record TickPricesRequest(
        @NonNull String streamSessionId,
        @NonNull String symbol,
        Integer minArrivalTime,
        Integer maxLevel) implements StreamingRequest {

    @Override
    public StreamingCommand subscribe() {
        return StreamingCommand.builder()
                .command("getTickPrices")
                .streamSessionId(streamSessionId)
                .symbol(symbol)
                .minArrivalTime(minArrivalTime)
                .maxLevel(maxLevel)
                .build();
    }

    @Override
    public StreamingCommand stop() {
        return StreamingCommand.builder()
                .command("stopBalance")
                .symbol(symbol)
                .build();
    }
}
