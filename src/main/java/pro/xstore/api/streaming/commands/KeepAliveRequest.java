package pro.xstore.api.streaming.commands;

import lombok.NonNull;

public record KeepAliveRequest(@NonNull String streamSessionId) implements StreamingRequest {

    @Override
    public StreamingCommand subscribe() {
        return StreamingCommand.builder()
                .command("getKeepAlive")
                .streamSessionId(streamSessionId)
                .build();
    }

    @Override
    public StreamingCommand stop() {
        return StreamingCommand.builder()
                .command("stopKeepAlive")
                .build();
    }
}
