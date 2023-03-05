package pro.xstore.api.message.records;

import lombok.Builder;
import lombok.extern.jackson.Jacksonized;
import pro.xstore.api.enums.TradeOperation;
import pro.xstore.api.enums.TradeTransaction;

import java.sql.Timestamp;

@Builder
@Jacksonized
public record TradeTransInfoRecord(
        TradeOperation cmd,
        TradeTransaction type,
        double price,
        double sl,
        double tp,
        String symbol,
        double volume,
        long order,
        Timestamp expiration,
        int offset,
        String customComment
) {
}