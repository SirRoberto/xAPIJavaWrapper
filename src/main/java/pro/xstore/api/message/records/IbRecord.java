package pro.xstore.api.message.records;

import lombok.Builder;
import lombok.extern.jackson.Jacksonized;
import pro.xstore.api.enums.Side;

import java.sql.Timestamp;

@Builder
@Jacksonized
public record IbRecord(
        String surname,
        Side side,
        Double openPrice,
        Double nominal,
        Double closePrice,
        String symbol,
        Double volume,
        String login,
        Timestamp timestamp
) {
}