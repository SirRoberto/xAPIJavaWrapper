package pro.xstore.api.message.records;

import lombok.Builder;
import lombok.extern.jackson.Jacksonized;
import pro.xstore.api.enums.Impact;

import java.sql.Timestamp;

@Builder
@Jacksonized
public record CalendarRecord(
        String country,
        String current,
        String forecast,
        Impact impact,
        String period,
        String previous,
        Timestamp time,
        String title
) {
}