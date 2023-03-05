package pro.xstore.api.message.records;

import lombok.Builder;
import lombok.extern.jackson.Jacksonized;

import java.sql.Timestamp;

@Builder
@Jacksonized
public record RateInfoRecord(
        Timestamp ctm,
        double open,
        double high,
        double low,
        double close,
        double vol
) {
}
