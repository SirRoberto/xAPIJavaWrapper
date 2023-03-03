package pro.xstore.api.message.response;

import lombok.EqualsAndHashCode;
import lombok.Value;
import org.json.JSONArray;
import org.json.JSONObject;
import pro.xstore.api.message.error.APIReplyParseException;
import pro.xstore.api.message.records.RateInfoRecord;

import java.util.LinkedList;
import java.util.List;

@Value
@EqualsAndHashCode(callSuper = true)
public class ChartResponse extends BaseResponse {

    int digits;
    List<RateInfoRecord> rateInfos = new LinkedList<>();

    public ChartResponse(String body) throws APIReplyParseException, APIErrorResponse {
        super(body);
        JSONObject rd = (JSONObject) this.getReturnData();
        if (rd != null) {
            this.digits = rd.getInt("digits");
            JSONArray arr = (JSONArray) rd.get("rateInfos");
            for (Object o : arr) {
                JSONObject e = (JSONObject) o;
                RateInfoRecord record = new RateInfoRecord();
                record.setFieldsFromJSONObject(e);
                this.rateInfos.add(record);
            }
        } else {
            digits = 0;
        }
    }
}