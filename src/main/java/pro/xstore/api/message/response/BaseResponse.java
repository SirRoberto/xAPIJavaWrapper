package pro.xstore.api.message.response;

import org.json.JSONObject;
import pro.xstore.api.message.error.APIReplyParseException;
import pro.xstore.api.message.error.ERR_CODE;
import pro.xstore.api.sync.SyncAPIConnector;

public class BaseResponse {

    private final Boolean status;
    private final String errorDescr;
    private final ERR_CODE errCode;
    private final Object returnData;
    private JSONObject redirectJson;
    private final String streamSessionId;

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

            try {
                this.redirectJson = (JSONObject) ob.get("redirect");
            } catch (Exception ignore) {
                this.redirectJson = null;
            }

            if (Boolean.FALSE.equals(this.status) && SyncAPIConnector.throwOnError && redirectJson == null) {
                throw new APIErrorResponse(errCode, errorDescr, body);
            }
        }
    }

    public Object getReturnData() {
        return returnData;
    }

    public Boolean getStatus() {
        return status;
    }

    public String getErrorDescr() {
        return errorDescr;
    }

    public ERR_CODE getErrCode() {
        return errCode;
    }

    public String getStreamSessionId() {
        return streamSessionId;
    }

    public JSONObject getRedirectJson() {
        return redirectJson;
    }

    @Override
    public String toString() {
        return "BaseResponse [status=" + status + ", errorDescr=" + errorDescr
                + ", errCode=" + errCode + ", returnData=" + returnData
                + ", redirectJson=" + redirectJson + ", streamSessionId="
                + streamSessionId + "]";
    }
}