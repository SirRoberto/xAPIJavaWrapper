package pro.xstore.api.message.response;

import org.json.JSONArray;
import org.json.JSONObject;
import pro.xstore.api.message.error.APIReplyParseException;
import pro.xstore.api.message.records.StepRecord;

import java.util.LinkedList;
import java.util.List;

public class StepRulesResponse extends BaseResponse {

    private final List<Integer> ids = new LinkedList<Integer>();
    private final List<String> names = new LinkedList<String>();
    private final List<List<StepRecord>> stepRecords = new LinkedList<List<StepRecord>>();

    public StepRulesResponse(String body) throws APIReplyParseException, APIErrorResponse {
        super(body);
        JSONArray returnDataArray = (JSONArray) this.getReturnData();
        for (Object o : returnDataArray) {
            JSONObject ob = (JSONObject) o;
            int id = ((Long) ob.get("id")).intValue();
            ids.add(id);

            String name = (String) ob.get("name");
            names.add(name);

            List<StepRecord> stepsList = new LinkedList<StepRecord>();
            JSONArray stepsArray = (JSONArray) ob.get("steps");
            for (Object value : stepsArray) {
                JSONObject e = (JSONObject) value;
                StepRecord rec = new StepRecord();
                rec.setFieldsFromJSONObject(e);
                stepsList.add(rec);
            }
            stepRecords.add(stepsList);
        }
    }

    public List<Integer> getIds() {
        return ids;
    }

    public List<String> getNames() {
        return names;
    }

    public List<List<StepRecord>> getStepRecords() {
        return stepRecords;
    }

    @Override
    public String toString() {
        return "StepRulesResponse [ids=" + ids + ", names=" + names
                + ", stepRecords=" + stepRecords + "]";
    }
}