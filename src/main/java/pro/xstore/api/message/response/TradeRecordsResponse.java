package pro.xstore.api.message.response;

import org.json.JSONArray;
import org.json.JSONObject;
import pro.xstore.api.message.error.APIReplyParseException;
import pro.xstore.api.message.records.TradeRecord;

import java.util.LinkedList;
import java.util.List;

public class TradeRecordsResponse extends BaseResponse {

    private final List<TradeRecord> tradeRecords = new LinkedList<TradeRecord>();

    public TradeRecordsResponse(String body) throws APIReplyParseException, APIErrorResponse {
        super(body);
        JSONArray arr = (JSONArray) this.getReturnData();
        for (Object o : arr) {
            JSONObject e = (JSONObject) o;
            TradeRecord record = new TradeRecord();
            record.setFieldsFromJSONObject(e);
            tradeRecords.add(record);
        }
    }

    public List<TradeRecord> getTradeRecords() {
        return tradeRecords;
    }

    @Override
    public String toString() {
        return "TradeRecordsResponse{" + "tradeRecords=" + tradeRecords + '}';
    }
}
