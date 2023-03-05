package pro.xstore.api.message.responses;

import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.Value;
import lombok.experimental.SuperBuilder;
import lombok.extern.jackson.Jacksonized;

@Value
@SuperBuilder
@Jacksonized
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class VersionResponse extends BaseResponse<VersionResponse.Data> {

    public record Data(String version) {
    }
}