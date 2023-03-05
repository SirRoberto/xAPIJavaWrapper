package pro.xstore.api.streaming.records;

public record SBalanceRecord(
        double balance,
        double margin,
        double equity,
        double marginLevel,
        double marginFree,
        double credit
) {
}