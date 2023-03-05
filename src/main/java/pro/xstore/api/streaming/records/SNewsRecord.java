package pro.xstore.api.streaming.records;

import java.sql.Timestamp;

public record SNewsRecord(
	String body,
	String title,
	String key,
	Timestamp time
) {
}