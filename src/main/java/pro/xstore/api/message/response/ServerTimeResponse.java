package pro.xstore.api.message.response;

import org.json.JSONObject;
import pro.xstore.api.message.error.APIReplyParseException;

public class ServerTimeResponse extends BaseResponse {

    private final long time;

    public ServerTimeResponse(String body) throws APIReplyParseException, APIErrorResponse {
        super(body);
        JSONObject ob = (JSONObject) this.getReturnData();
        this.time = (Long) ob.get("time");
    }

    public long getTime() {
        return time;
    }

    @Override
    public String toString() {
        return "ServerTimeResponse{" + "time=" + time + '}';
    }
}
