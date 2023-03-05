package pro.xstore.api.streaming.records;

public record SProfitRecord(
        long order,
        long order2,
        long position,
        double profit
) {
}