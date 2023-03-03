package pro.xstore.api.message.response;

import lombok.EqualsAndHashCode;
import lombok.Value;
import org.json.JSONObject;
import pro.xstore.api.message.error.APIReplyParseException;

@Value
@EqualsAndHashCode(callSuper = true)
public class CommissionDefResponse extends BaseResponse {

    double commission;
    double rateOfExchange;

    public CommissionDefResponse(String body) throws APIReplyParseException, APIErrorResponse {
        super(body);
        JSONObject rd = (JSONObject) this.getReturnData();
        if (rd != null) {
            this.commission = (Double) rd.get("commission");
            this.rateOfExchange = (Double) rd.get("rateOfExchange");
        } else {
            commission = 0;
            rateOfExchange = 0;
        }
    }
}