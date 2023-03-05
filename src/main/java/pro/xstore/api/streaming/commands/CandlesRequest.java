package pro.xstore.api.streaming.commands;

import lombok.NonNull;

public record CandlesRequest(@NonNull String streamSessionId, @NonNull String symbol) implements StreamingRequest {

    @Override
    public StreamingCommand subscribe() {
        return StreamingCommand.builder()
                .command("getCandles")
                .streamSessionId(streamSessionId)
                .symbol(symbol)
                .build();
    }

    @Override
    public StreamingCommand stop() {
        return StreamingCommand.builder()
                .command("stopCandles")
                .symbol(symbol)
                .build();
    }
}
