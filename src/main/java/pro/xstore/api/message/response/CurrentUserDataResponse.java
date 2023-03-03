package pro.xstore.api.message.response;

import lombok.EqualsAndHashCode;
import lombok.Value;
import org.json.JSONObject;
import pro.xstore.api.message.error.APIReplyParseException;

@Value
@EqualsAndHashCode(callSuper = true)
public class CurrentUserDataResponse extends BaseResponse {

    String currency;
    String group;
    double leverageMultiplier;
    int companyUnit;
    String spreadType;
    boolean ibAccount;

    public CurrentUserDataResponse(String body) throws APIReplyParseException, APIErrorResponse {
        super(body);
        JSONObject ob = (JSONObject) this.getReturnData();
        this.currency = ob.getString("currency");
        this.spreadType = ob.getString("spreadType");
        this.group = ob.getString("group");
        this.leverageMultiplier = Double.parseDouble(ob.get("leverageMultiplier").toString());
        this.companyUnit = ob.getInt("companyUnit");
        this.ibAccount = ob.getBoolean("ibAccount");
    }
}