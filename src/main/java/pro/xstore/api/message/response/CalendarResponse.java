package pro.xstore.api.message.response;

import lombok.EqualsAndHashCode;
import lombok.Value;
import org.json.JSONArray;
import org.json.JSONObject;
import pro.xstore.api.message.error.APIReplyParseException;
import pro.xstore.api.message.records.CalendarRecord;

import java.util.LinkedList;
import java.util.List;

@Value
@EqualsAndHashCode(callSuper = true)
public class CalendarResponse extends BaseResponse {

    List<CalendarRecord> calendarRecords = new LinkedList<>();

    public CalendarResponse(String body) throws APIReplyParseException, APIErrorResponse {
        super(body);
        JSONArray arr = (JSONArray) this.getReturnData();
        for (Object o : arr) {
            JSONObject e = (JSONObject) o;
            CalendarRecord record = new CalendarRecord();
            record.setFieldsFromJSONObject(e);
            this.calendarRecords.add(record);
        }
    }
}