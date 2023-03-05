package pro.xstore.api.streaming.commands;

import lombok.NonNull;

public record PingRequest(@NonNull String streamSessionId) {

    public StreamingCommand ping() {
        return StreamingCommand.builder()
                .command("ping")
                .streamSessionId(streamSessionId)
                .build();
    }
}
