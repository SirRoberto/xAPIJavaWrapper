package pro.xstore.api.message.records;

import lombok.Builder;
import lombok.extern.jackson.Jacksonized;

import java.util.List;

@Builder
@Jacksonized
public record StepRuleRecord(
        long id,
        String name,
        List<StepRecord> steps
) {
}
