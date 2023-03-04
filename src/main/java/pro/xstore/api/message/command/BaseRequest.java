package pro.xstore.api.message.command;

import lombok.Value;
import lombok.experimental.NonFinal;
import lombok.experimental.SuperBuilder;

@Value
@NonFinal
@SuperBuilder
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
