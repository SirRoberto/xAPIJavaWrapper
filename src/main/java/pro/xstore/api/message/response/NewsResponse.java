package pro.xstore.api.message.response;

import org.json.JSONArray;
import org.json.JSONObject;
import pro.xstore.api.message.error.APIReplyParseException;
import pro.xstore.api.message.records.NewsTopicRecord;

import java.util.LinkedList;
import java.util.List;

public class NewsResponse extends BaseResponse {

    private final List<NewsTopicRecord> newsTopicRecords = new LinkedList<NewsTopicRecord>();

    public NewsResponse(String body) throws APIReplyParseException, APIErrorResponse {
        super(body);
        JSONArray arr = (JSONArray) this.getReturnData();
        for (Object o : arr) {
            JSONObject e = (JSONObject) o;
            NewsTopicRecord record = new NewsTopicRecord();
            record.setFieldsFromJSONObject(e);
            newsTopicRecords.add(record);
        }
    }

    public List<NewsTopicRecord> getNewsTopicRecords() {
        return newsTopicRecords;
    }

    @Override
    public String toString() {
        return "NewsResponse{" + "newsTopicRecords=" + newsTopicRecords + '}';
    }
}
