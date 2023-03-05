package pro.xstore.api.streaming.commands;

import lombok.NonNull;

public record BalanceRequest(@NonNull String streamSessionId) implements StreamingRequest {

    @Override
    public StreamingCommand subscribe() {
        return StreamingCommand.builder()
                .command("getBalance")
                .streamSessionId(streamSessionId)
                .build();
    }

    @Override
    public StreamingCommand stop() {
        return StreamingCommand.builder()
                .command("stopBalance")
                .build();
    }
}
