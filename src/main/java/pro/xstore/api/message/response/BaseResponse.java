package pro.xstore.api.message.response;

import lombok.Value;
import lombok.experimental.NonFinal;
import org.json.JSONObject;
import pro.xstore.api.message.error.APIReplyParseException;
import pro.xstore.api.message.error.ERR_CODE;
import pro.xstore.api.sync.SyncAPIConnector;

@Value
@NonFinal
public class BaseResponse {

    Boolean status;
    String errorDescr;
    ERR_CODE errCode;
    Object returnData;
    JSONObject redirectJson;
    String streamSessionId;

    public BaseResponse(String body) throws APIReplyParseException, APIErrorResponse {
        JSONObject ob;
        try {
            ob = new JSONObject(body);
        } catch (Exception ex) {
            String resp = "JSON Parse error: " + ex.getMessage() + "\nWhile trying to parse: " + body;
            if (SyncAPIConnector.throwOnError) {
                throw new APIReplyParseException(resp);
            } else {
                System.err.println(resp);
            }
            ob = null;
        }
        if (ob == null) {
            throw new APIReplyParseException("JSON Parse exception: " + body);
        } else {
            this.status = ob.has("status") ? ob.getBoolean("status") : null;
            this.errCode = ob.has("errorCode") ? new ERR_CODE(ob.getString("errorCode")) : null;
            this.errorDescr = ob.has("errorDescr") ? ob.getString("errorDescr") : null;
            this.returnData = ob.has("returnData") ? ob.get("returnData") : null;
            this.streamSessionId = ob.has("streamSessionId") ? ob.getString("streamSessionId") : null;

            if (this.status == null) {
                String resp = "JSON Parse error: " + "\"status\" is null!";
                if (SyncAPIConnector.throwOnError) {
                    throw new APIReplyParseException(resp);
                } else {
                    System.err.println(resp);
                }
            }

            this.redirectJson = ob.has("redirect") ? (JSONObject) ob.get("redirect") : null;

            if (Boolean.FALSE.equals(this.status) && SyncAPIConnector.throwOnError && redirectJson == null) {
                throw new APIErrorResponse(errCode, errorDescr, body);
            }
        }
    }
}