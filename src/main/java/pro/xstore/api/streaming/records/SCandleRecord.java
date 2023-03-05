package pro.xstore.api.streaming.records;

import pro.xstore.api.enums.QuoteId;

import java.sql.Timestamp;

public record SCandleRecord(
        Timestamp ctm,
        String ctmString,
        double open,
        double high,
        double low,
        double close,
        double vol,
        QuoteId quoteId,
        String symbol
) {
}