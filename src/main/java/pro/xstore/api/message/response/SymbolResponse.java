package pro.xstore.api.message.response;

import lombok.EqualsAndHashCode;
import lombok.Value;
import org.json.JSONObject;
import pro.xstore.api.message.error.APIReplyParseException;
import pro.xstore.api.message.records.SymbolRecord;

@Value
@EqualsAndHashCode(callSuper = true)
public class SymbolResponse extends BaseResponse {

    SymbolRecord symbol;

    public SymbolResponse(String body) throws APIReplyParseException, APIErrorResponse {
        super(body);
        JSONObject ob = (JSONObject) this.getReturnData();
        symbol = new SymbolRecord();
        symbol.setFieldsFromJSONObject(ob);
    }
}
