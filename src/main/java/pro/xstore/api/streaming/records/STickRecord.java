package pro.xstore.api.streaming.records;

import pro.xstore.api.enums.Level;
import pro.xstore.api.enums.QuoteId;

import java.sql.Timestamp;

public record STickRecord(
        Double ask,
        Double bid,
        Long askVolume,
        Long bidVolume,
        Double high,
        Double low,
        double spreadRaw,
        double spreadTable,
        String symbol,
        QuoteId quoteId,
        Level level,
        Timestamp timestamp
) {
}