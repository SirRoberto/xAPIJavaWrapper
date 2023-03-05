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
public class CurrentUserDataResponse extends BaseResponse<CurrentUserDataResponse.Data> {

    public record Data(
            String currency,
            String group,
            double leverageMultiplier,
            int companyUnit,
            String spreadType,
            boolean ibAccount,
            boolean trailingStop
    ) {
    }
}