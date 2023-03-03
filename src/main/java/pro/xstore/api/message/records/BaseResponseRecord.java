package pro.xstore.api.message.records;

import org.json.JSONObject;

public interface BaseResponseRecord {
    public abstract void setFieldsFromJSONObject(JSONObject ob);
}