package pro.xstore.api.streaming.commands;

import lombok.NonNull;

public record TradeStatusRequest(@NonNull String streamSessionId) implements StreamingRequest{

    @Override
    public StreamingCommand subscribe() {
        return StreamingCommand.builder()
                .command("getTradeStatus")
                .streamSessionId(streamSessionId)
                .build();
    }

    @Override
    public StreamingCommand stop() {
        return StreamingCommand.builder()
                .command("stopTradeStatus")
                .build();
    }
}
