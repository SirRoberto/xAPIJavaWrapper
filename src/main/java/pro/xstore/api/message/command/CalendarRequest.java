package pro.xstore.api.message.command;

import lombok.EqualsAndHashCode;
import lombok.Value;
import lombok.experimental.SuperBuilder;
import lombok.extern.jackson.Jacksonized;

@Value
@SuperBuilder
@Jacksonized
@EqualsAndHashCode(callSuper = true)
public class CalendarRequest extends BaseRequest {

    String command = "getCalendar";
    CommandArguments arguments = null;
}
