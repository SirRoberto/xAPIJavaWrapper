package pro.xstore.api.message.response;

import lombok.EqualsAndHashCode;
import lombok.Value;
import org.json.JSONObject;
import pro.xstore.api.message.codes.REQUEST_STATUS;
import pro.xstore.api.message.error.APIReplyParseException;

@Value
@EqualsAndHashCode(callSuper = true)
public class TradeTransactionStatusResponse extends BaseResponse {

    Double ask;
    Double bid;
    String message;
    Long order;
    REQUEST_STATUS requestStatus;
    String customComment;

    public TradeTransactionStatusResponse(String body) throws APIReplyParseException, APIErrorResponse {
        super(body);
        JSONObject ob = (JSONObject) this.getReturnData();
        this.ask = getStatus() ? Double.valueOf(ob.get("ask").toString()) : null;
        this.bid = getStatus() ? Double.valueOf(ob.get("bid").toString()) : null;
        this.order = getStatus() ? ob.getLong("order") : null;
        this.message = getStatus() ? ob.getString("message") : null;
        this.customComment = getStatus() ? ob.getString("customComment") : null;
        this.requestStatus = getStatus() ? new REQUEST_STATUS((Long) ob.get("requestStatus")) : null;
    }
}