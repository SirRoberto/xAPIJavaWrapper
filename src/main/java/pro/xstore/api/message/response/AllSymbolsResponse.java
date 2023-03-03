package pro.xstore.api.message.response;

import lombok.EqualsAndHashCode;
import lombok.Value;
import org.json.JSONArray;
import org.json.JSONObject;
import pro.xstore.api.message.error.APIReplyParseException;
import pro.xstore.api.message.records.SymbolRecord;

import java.util.LinkedList;
import java.util.List;

@Value
@EqualsAndHashCode(callSuper = true)
public class AllSymbolsResponse extends BaseResponse {

    List<SymbolRecord> symbolRecords = new LinkedList<>();

    public AllSymbolsResponse(String body) throws APIReplyParseException, APIErrorResponse {
        super(body);
        JSONArray symbolRecords = (JSONArray) this.getReturnData();
        for (Object record : symbolRecords) {
            JSONObject e = (JSONObject) record;
            SymbolRecord symbolRecord = new SymbolRecord();
            symbolRecord.setFieldsFromJSONObject(e);
            this.symbolRecords.add(symbolRecord);
        }
    }
}
