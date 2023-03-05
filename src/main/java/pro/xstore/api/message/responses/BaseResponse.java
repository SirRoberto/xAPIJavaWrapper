package pro.xstore.api.message.responses;

import lombok.Value;
import lombok.experimental.NonFinal;
import lombok.experimental.SuperBuilder;
import lombok.extern.jackson.Jacksonized;

@Value
@NonFinal
@SuperBuilder
@Jacksonized
public class BaseResponse<T> {

    Boolean status;
    T returnData;
    String errorCode;
    String errorDescr;
    String customTag;
}
