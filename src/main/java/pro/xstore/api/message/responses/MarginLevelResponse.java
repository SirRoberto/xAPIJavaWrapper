package pro.xstore.api.message.responses;

import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.Value;
import lombok.experimental.SuperBuilder;
import lombok.extern.jackson.Jacksonized;

@Value
@SuperBuilder
@Jacksonized
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class MarginLevelResponse extends BaseResponse<MarginLevelResponse.Data> {

    public record Data(
            double balance,
            double equity,
            double margin,
            double margin_free,
            double margin_level,
            String currency,
            double credit
    ) {
    }
}
