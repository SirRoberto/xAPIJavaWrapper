package pro.xstore.api.message.commands;

import lombok.EqualsAndHashCode;
import lombok.Value;
import lombok.experimental.SuperBuilder;
import lombok.extern.jackson.Jacksonized;

@Value
@SuperBuilder
@Jacksonized
@EqualsAndHashCode(callSuper = true)
public class MarginLevelRequest extends BaseRequest {

    String command = "getMarginLevel";
    CommandArguments arguments = null;
}
