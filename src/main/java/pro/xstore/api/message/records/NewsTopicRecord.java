package pro.xstore.api.message.records;

import lombok.Builder;
import lombok.extern.jackson.Jacksonized;

import java.sql.Timestamp;

@Builder
@Jacksonized
public record NewsTopicRecord(
        String body,
        int bodylen,
        String key,
        Timestamp time,
        String title
) {
}