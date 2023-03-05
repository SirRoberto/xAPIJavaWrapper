package pro.xstore.api.message.records;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.extern.jackson.Jacksonized;
import pro.xstore.api.enums.TradeOperation;

import java.sql.Timestamp;

@Builder
@Jacksonized
public record TradeRecord(
        TradeOperation cmd,
        String symbol,
        @JsonProperty("open_price") double openPrice,
        @JsonProperty("open_time") Timestamp openTime,
        @JsonProperty("close_price") double closePrice,
        @JsonProperty("close_time") Timestamp closeTime,
        @JsonProperty("margin_rate") double marginRate,
        double volume,
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
        Timestamp timestamp,
        String comment,
        Double commission,
        String customComment
) {
}