package pro.xstore.api.message.records;

import lombok.Builder;
import lombok.extern.jackson.Jacksonized;
import pro.xstore.api.enums.PeriodCode;

import java.sql.Timestamp;

@Builder
@Jacksonized
public record ChartRangeInfoRecord(
        String symbol,
        PeriodCode period,
        Timestamp start,
        Timestamp end,
        long ticks
) {
}
