package pro.xstore.api.message.response;

import lombok.EqualsAndHashCode;
import lombok.Value;
import org.json.JSONObject;
import pro.xstore.api.message.error.APIReplyParseException;

@Value
@EqualsAndHashCode(callSuper = true)
public class VersionResponse extends BaseResponse {

    String version;

    public VersionResponse(String body) throws APIReplyParseException, APIErrorResponse {
        super(body);
        JSONObject ob = (JSONObject) this.getReturnData();
        this.version = (String) ob.get("version");
    }
}