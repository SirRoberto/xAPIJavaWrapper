package pro.xstore.api.message.response;

import org.json.JSONObject;
import pro.xstore.api.message.error.APIReplyParseException;

public class VersionResponse extends BaseResponse {

    private final String version;

    public VersionResponse(String body) throws APIReplyParseException, APIErrorResponse {
        super(body);
        JSONObject ob = (JSONObject) this.getReturnData();
        this.version = (String) ob.get("version");
    }

    public String getVersion() {
        return version;
    }

    @Override
    public String toString() {
        return "VersionResponse [version=" + version + "]";
    }
}