package pro.xstore.api.message.response;

import lombok.EqualsAndHashCode;
import lombok.Value;
import org.json.JSONObject;
import pro.xstore.api.message.error.APIReplyParseException;

@Value
@EqualsAndHashCode(callSuper = true)
public class MarginLevelResponse extends BaseResponse {

    double balance;
    double equity;
    double margin;
    double margin_free;
    double margin_level;
    String currency;
    double credit;

    public MarginLevelResponse(String body) throws APIReplyParseException, APIErrorResponse {
        super(body);
        JSONObject ob = (JSONObject) this.getReturnData();
        this.balance = ob.getDouble("balance");
        this.credit = ob.getDouble("credit");
        this.equity = ob.getDouble("equity");
        this.currency = ob.getString("currency");
        this.margin = ob.getDouble("margin");
        this.margin_free = ob.getDouble("margin_free");
        this.margin_level = ob.getDouble("margin_level");
    }
}
