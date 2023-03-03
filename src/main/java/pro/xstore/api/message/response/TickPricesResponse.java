package pro.xstore.api.message.response;

import org.json.JSONArray;
import org.json.JSONObject;
import pro.xstore.api.message.error.APIReplyParseException;
import pro.xstore.api.message.records.TickRecord;

import java.util.LinkedList;
import java.util.List;

public class TickPricesResponse extends BaseResponse {

    private final List<TickRecord> ticks = new LinkedList<TickRecord>();

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

    public List<TickRecord> getTicks() {
        return ticks;
    }

    @Override
    public String toString() {
        return "TickPricesResponse{ticks=" + ticks + '}';
    }
}