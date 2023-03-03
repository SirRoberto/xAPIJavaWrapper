package pro.xstore.api.message.response;

import org.json.JSONArray;
import org.json.JSONObject;
import pro.xstore.api.message.error.APIReplyParseException;
import pro.xstore.api.message.records.IbRecord;

import java.util.LinkedList;
import java.util.List;

public class IbsHistoryResponse extends BaseResponse {

    private final List<IbRecord> ibRecords = new LinkedList<IbRecord>();

    public IbsHistoryResponse(String body) throws APIReplyParseException, APIErrorResponse {
        super(body);
        JSONArray ibRecords = (JSONArray) this.getReturnData();
        for (Object record : ibRecords) {
            JSONObject e = (JSONObject) record;
            IbRecord ibRecord = new IbRecord();
            ibRecord.setFieldsFromJSONObject(e);
            this.ibRecords.add(ibRecord);
        }
    }

    public List<IbRecord> getIbRecords() {
        return ibRecords;
    }

    @Override
    public String toString() {
        return "IbsHistoryResponse{" + "ibRecords=" + ibRecords + '}';
    }
}