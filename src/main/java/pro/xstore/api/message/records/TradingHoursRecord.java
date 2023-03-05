package pro.xstore.api.message.records;

import lombok.Builder;
import lombok.extern.jackson.Jacksonized;
import pro.xstore.api.enums.Day;

import java.sql.Timestamp;
import java.util.List;

@Builder
@Jacksonized
public record TradingHoursRecord(
        String symbol,
        List<QuotesRecord> quotes,
        List<TradingRecord> trading
) {

    public record QuotesRecord(
            Day day,
            Timestamp fromT,
            Timestamp toT
    ) {
    }

    public record TradingRecord(
            Day day,
            Timestamp fromT,
            Timestamp toT
    ) {
    }
}
