package pro.xstore.api.message.responses;

import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.Value;
import lombok.experimental.SuperBuilder;
import lombok.extern.jackson.Jacksonized;
import pro.xstore.api.enums.RequestStatus;

@Value
@SuperBuilder
@Jacksonized
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class TradeTransactionStatusResponse extends BaseResponse<TradeTransactionStatusResponse.Data> {

    public record Data(
            double ask,
            double bid,
            String message,
            int order,
            RequestStatus requestStatus,
            String customComment
    ) {
    }
}