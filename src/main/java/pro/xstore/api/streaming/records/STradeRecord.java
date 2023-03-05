package pro.xstore.api.streaming.records;

import com.fasterxml.jackson.annotation.JsonProperty;
import pro.xstore.api.enums.StreamingTradeType;
import pro.xstore.api.enums.TradeOperation;

import java.sql.Timestamp;

public record STradeRecord(
        TradeOperation cmd,
        String symbol,
        @JsonProperty("open_price") double openPrice,
        @JsonProperty("open_time") Timestamp openTime,
        @JsonProperty("close_price") double closePrice,
        @JsonProperty("close_time") Timestamp closeTime,
        @JsonProperty("margin_rate") double marginRate,
        double volume,
        String state,
        double tp,
        double sl,
        boolean closed,
        int digits,
        Timestamp expiration,
        int offset,
        long order,
        long order2,
        long position,
        double profit,
        double storage,
        String comment,
        Double commission,
        String customComment,
        StreamingTradeType type
) {
}