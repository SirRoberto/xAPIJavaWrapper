package pro.xstore.api.message.command;

import lombok.EqualsAndHashCode;
import lombok.Value;
import lombok.experimental.SuperBuilder;
import lombok.extern.jackson.Jacksonized;

@Value
@SuperBuilder
@Jacksonized
@EqualsAndHashCode(callSuper = true)
public class AllSymbolsRequest extends BaseRequest {

    String command = "getAllSymbols";
    CommandArguments arguments = null;
}
