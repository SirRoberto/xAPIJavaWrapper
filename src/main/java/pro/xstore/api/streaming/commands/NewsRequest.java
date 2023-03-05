package pro.xstore.api.streaming.commands;

import lombok.NonNull;

public record NewsRequest(@NonNull String streamSessionId) implements StreamingRequest {

    @Override
    public StreamingCommand subscribe() {
        return StreamingCommand.builder()
                .command("getNews")
                .streamSessionId(streamSessionId)
                .build();
    }

    @Override
    public StreamingCommand stop() {
        return StreamingCommand.builder()
                .command("stopNews")
                .build();
    }
}
