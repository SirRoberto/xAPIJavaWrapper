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
public class CommissionDefResponse extends BaseResponse<CommissionDefResponse.Data> {

    public record Data(Double commission, Double rateOfExchange) {
    }
}