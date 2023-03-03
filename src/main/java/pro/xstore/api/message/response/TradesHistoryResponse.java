package pro.xstore.api.message.response;

import lombok.EqualsAndHashCode;
import lombok.Value;
import org.json.JSONArray;
import org.json.JSONObject;
import pro.xstore.api.message.error.APIReplyParseException;
import pro.xstore.api.message.records.TradeRecord;

import java.util.LinkedList;
import java.util.List;

@Value
@EqualsAndHashCode(callSuper = true)
public class TradesHistoryResponse extends BaseResponse {

    List<TradeRecord> tradeRecords = new LinkedList<>();

    public TradesHistoryResponse(String body) throws APIReplyParseException, APIErrorResponse {
        super(body);
        JSONArray arr = (JSONArray) this.getReturnData();
        for (Object o : arr) {
            JSONObject e = (JSONObject) o;
            TradeRecord record = new TradeRecord();
            record.setFieldsFromJSONObject(e);
            tradeRecords.add(record);
        }
    }
}
