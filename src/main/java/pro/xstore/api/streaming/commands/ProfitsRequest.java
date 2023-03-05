package pro.xstore.api.streaming.commands;

import lombok.NonNull;

public record ProfitsRequest(@NonNull String streamSessionId) implements StreamingRequest {

    @Override
    public StreamingCommand subscribe() {
        return StreamingCommand.builder()
                .command("getProfits")
                .streamSessionId(streamSessionId)
                .build();
    }

    @Override
    public StreamingCommand stop() {
        return StreamingCommand.builder()
                .command("stopProfits")
                .build();
    }
}
