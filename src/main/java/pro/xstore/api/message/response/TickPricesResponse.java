package pro.xstore.api.message.response;

import lombok.EqualsAndHashCode;
import lombok.Value;
import org.json.JSONArray;
import org.json.JSONObject;
import pro.xstore.api.message.error.APIReplyParseException;
import pro.xstore.api.message.records.TickRecord;

import java.util.LinkedList;
import java.util.List;

@Value
@EqualsAndHashCode(callSuper = true)
public class TickPricesResponse extends BaseResponse {

    List<TickRecord> ticks = new LinkedList<>();

    public TickPricesResponse(String body) throws APIReplyParseException, APIErrorResponse {
        super(body);
        JSONObject ob = (JSONObject) this.getReturnData();
        JSONArray arr = (JSONArray) ob.get("quotations");
        for (Object o : arr) {
            JSONObject e = (JSONObject) o;
            TickRecord record = new TickRecord();
            record.setFieldsFromJSONObject(e);
            ticks.add(record);
        }
    }
}