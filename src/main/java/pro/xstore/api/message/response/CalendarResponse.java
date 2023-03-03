package pro.xstore.api.message.response;

import org.json.JSONArray;
import org.json.JSONObject;
import pro.xstore.api.message.error.APIReplyParseException;
import pro.xstore.api.message.records.CalendarRecord;

import java.util.LinkedList;
import java.util.List;

public class CalendarResponse extends BaseResponse {

    private final List<CalendarRecord> calendarRecords = new LinkedList<CalendarRecord>();

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

    public List<CalendarRecord> getCalendarRecords() {
        return calendarRecords;
    }

    @Override
    public String toString() {
        StringBuilder response = new StringBuilder("CalendarResponse{calendarRecords=[");
        for (CalendarRecord ri : calendarRecords) {
            response.append(ri.toString()).append(",");
        }
        response.append("]}");
        return response.toString();
    }
}