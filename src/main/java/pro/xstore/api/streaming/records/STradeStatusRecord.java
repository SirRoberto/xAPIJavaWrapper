package pro.xstore.api.streaming.records;

import pro.xstore.api.enums.RequestStatus;

public record STradeStatusRecord(
        int order,
        RequestStatus requestStatus,
        String message,
        String customComment,
        Double price
) {
}