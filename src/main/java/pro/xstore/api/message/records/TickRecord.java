package pro.xstore.api.message.records;

import lombok.Builder;
import lombok.extern.jackson.Jacksonized;
import pro.xstore.api.enums.Level;

import java.math.BigDecimal;
import java.sql.Timestamp;

@Builder
@Jacksonized
public record TickRecord(
        BigDecimal ask,
        BigDecimal bid,
        Long askVolume,
        Long bidVolume,
        BigDecimal high,
        BigDecimal low,
        String symbol,
        Timestamp timestamp,
        Level level,
        BigDecimal spreadRaw,
        BigDecimal spreadTable
) {
}