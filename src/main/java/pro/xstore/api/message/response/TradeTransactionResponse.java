package pro.xstore.api.message.response;

import lombok.EqualsAndHashCode;
import lombok.Value;
import org.json.JSONObject;
import pro.xstore.api.message.error.APIReplyParseException;

@Value
@EqualsAndHashCode(callSuper = true)
public class TradeTransactionResponse extends BaseResponse {

    long order;

    public TradeTransactionResponse(String body) throws APIReplyParseException, APIErrorResponse {
        super(body);
        JSONObject ob = (JSONObject) this.getReturnData();
        this.order = getStatus() ? ob.getLong("order") : 0;
    }
}