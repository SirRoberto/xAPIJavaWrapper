package pro.xstore.api.streaming.commands;

public interface StreamingRequest {

    StreamingCommand subscribe();

    StreamingCommand stop();
}
