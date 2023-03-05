package pro.xstore.api.streaming.commands;

import lombok.NonNull;

public record TradesRequest(@NonNull String streamSessionId) implements StreamingRequest {

    @Override
    public StreamingCommand subscribe() {
        return StreamingCommand.builder()
                .command("getTrades")
                .streamSessionId(streamSessionId)
                .build();
    }

    @Override
    public StreamingCommand stop() {
        return StreamingCommand.builder()
                .command("stopTrades")
                .build();
    }
}
