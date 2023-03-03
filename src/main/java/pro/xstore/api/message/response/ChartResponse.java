package pro.xstore.api.message.response;

import org.json.JSONArray;
import org.json.JSONObject;
import pro.xstore.api.message.error.APIReplyParseException;
import pro.xstore.api.message.records.RateInfoRecord;

import java.util.LinkedList;
import java.util.List;

public class ChartResponse extends BaseResponse {

    private int digits;
    private final List<RateInfoRecord> rateInfos = new LinkedList<RateInfoRecord>();

    public ChartResponse(String body) throws APIReplyParseException, APIErrorResponse {
        super(body);
        JSONObject rd = (JSONObject) this.getReturnData();
        if (rd != null) {
            this.digits = ((Long) rd.get("digits")).intValue();
            JSONArray arr = (JSONArray) rd.get("rateInfos");
            for (Object o : arr) {
                JSONObject e = (JSONObject) o;
                RateInfoRecord record = new RateInfoRecord();
                record.setFieldsFromJSONObject(e);
                this.rateInfos.add(record);
            }
        }
    }

    public int getDigits() {
        return digits;
    }

    public List<RateInfoRecord> getRateInfos() {
        return rateInfos;
    }

    @Override
    public String toString() {
        StringBuilder response = new StringBuilder("ChartResponse{" + "digits=" + digits + ", rateInfos=[");
        for (RateInfoRecord ri : rateInfos) {
            response.append(ri.toString()).append(",");
        }
        response.append("]}");
        return response.toString();
    }
}