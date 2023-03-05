package pro.xstore.api.message.responses;

import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.Value;
import lombok.experimental.SuperBuilder;
import lombok.extern.jackson.Jacksonized;
import pro.xstore.api.message.records.RateInfoRecord;

import java.util.List;

@Value
@SuperBuilder
@Jacksonized
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class ChartResponse extends BaseResponse<ChartResponse.Data> {
    public record Data(int digits, List<RateInfoRecord> rateInfos) {
    }
}