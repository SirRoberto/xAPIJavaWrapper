package pro.xstore.api.message.commands;

import lombok.Value;
import lombok.experimental.NonFinal;
import lombok.experimental.SuperBuilder;
import lombok.extern.jackson.Jacksonized;

@Value
@NonFinal
@SuperBuilder
@Jacksonized
public class BaseRequest {

    /**
     * API inter-command timeout
     * (if same command is executed more frequently than this number of milliseconds, RR-Socket disconnects)
     */
    public static final Integer TIMEOUT_MILLIS = 250;

    String command;
    CommandArguments arguments;
    String customTag;
    boolean prettyPrint;
}
