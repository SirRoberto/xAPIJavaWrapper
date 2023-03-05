package pro.xstore.api.message.records;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.extern.jackson.Jacksonized;
import pro.xstore.api.enums.*;

import java.sql.Timestamp;

@Builder
@Jacksonized
public record SymbolRecord(
        double ask,
        double bid,
        String currency,
        String currencyProfit,
        String description,
        int instantMaxVolume,
        double high,
        double low,
        String symbol,
        Timestamp time,
        int type,
        String groupName,
        String categoryName,
        boolean longOnly,
        Timestamp starting,
        Timestamp expiration,
        int stepRuleId,
        int stopsLevel,
        double lotMax,
        double lotMin,
        double lotStep,
        int pipsPrecision,
        int precision,
        long contractSize,
        long initialMargin,
        double marginHedged,
        boolean marginHedgedStrong,
        Long marginMaintenance,
        MarginMode marginMode,
        double percentage,
        ProfitMode profitMode,
        boolean shortSelling,
        double spreadRaw,
        double spreadTable,
        boolean swapEnable,
        double swapLong,
        double swapShort,
        SwapType swapType,
        @JsonProperty("swap_rollover3days") SwapRolloverType swapRollover3days,
        double tickSize,
        double tickValue,
        QuoteId quoteId,
        String timeString,
        double leverage,
        boolean currencyPair,
        boolean trailingEnabled
) {
}